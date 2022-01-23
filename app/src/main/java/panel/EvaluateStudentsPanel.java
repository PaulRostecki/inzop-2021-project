package panel;

import cache.CacheProvider;
import cache.DataService;
import factory.TableViewFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import model.model.Lecturer;
import model.model.Mark;
import model.model.Student;
import model.model.StudyGroup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Panel for evaluating Students
 *
 * @author created: Michał Musiałowicz on 08.01.2022
 * @author last changed:
 */
public class EvaluateStudentsPanel implements PanelIf
{
    private static final Logger LOGGER = LogManager.getLogger( EvaluateStudentsPanel.class );

    @FXML
    private BorderPane leftSidePane;

    @FXML
    private BorderPane rightSidePane;

    private Lecturer lecturer;

    private DataService dataService = DataService.getDataService();

    private static final CacheProvider cacheProvider = CacheProvider.getCacheProvider();

    private static final TableViewFactory tableViewFactory = new TableViewFactory();

    public EvaluateStudentsPanel()
    {

    }

    public void initialize()
    {
        Platform.runLater( this::initLecturer );
        Platform.runLater( this::initStudyGroupsForListView );

        LOGGER.info( "Evaluate Students Panel initialized." );
    }

    private void initLecturer()
    {
        lecturer = (Lecturer) getCurrentStage( leftSidePane ).getUserData();
    }

    private void initStudyGroupsForListView()
    {
        final ListView< StudyGroup > studyGroupsListView = new ListView<>();
        studyGroupsListView.getSelectionModel().setSelectionMode( SelectionMode.SINGLE );

        List< StudyGroup > studyGroups = cacheProvider.getStudyGroups().values().stream()
                .filter( sG -> sG.getLecturerId() == lecturer.getId() )
                .collect( Collectors.toList() );

        studyGroupsListView.getItems().addAll( studyGroups );
        studyGroupsListView.getSelectionModel().selectFirst();

        studyGroupsListView.setOnMouseClicked( item ->
                initStudyGroupsMarksForListView( studyGroupsListView.getSelectionModel().getSelectedItem() ) );

        studyGroupsListView.getSelectionModel().clearSelection();
        leftSidePane.setCenter( studyGroupsListView );

        LOGGER.info( "ListView initialized for Study Groups.." );
    }

    private void initStudyGroupsMarksForListView( final StudyGroup aStudyGroup )
    {
        TableView< Mark > studyGroupsMarksTableView = tableViewFactory.createTableViewForStudyGroupMarks( aStudyGroup );

        final List< Integer > studentsIDFromStudyGroup = cacheProvider.getStudents().values().stream()
                .filter( student -> aStudyGroup.getStudents().contains( student ) )
                .map( Student::getIndexNumber )
                .collect( Collectors.toList() );

        Set< Mark > studyGroupMarks = cacheProvider.getMarks().stream()
                .filter( mark -> studentsIDFromStudyGroup.contains( mark.getMarkId().getStudentId() ) )
                .filter( mark -> mark.getMarkId().getUniversitySubjectId() == aStudyGroup.getUniversitySubjectId() )
                .collect( Collectors.toSet() );
        HashSet< Mark > hashedStudyGroupMarks = new HashSet<>( studyGroupMarks );


        studyGroupsMarksTableView.getItems().addAll( hashedStudyGroupMarks );
        addStudentsWithoutMarksToTableView( aStudyGroup, studentsIDFromStudyGroup, hashedStudyGroupMarks, studyGroupsMarksTableView);
        rightSidePane.setCenter( studyGroupsMarksTableView );

        LOGGER.info( "ListView initialized for Marks that belong to Study Group with ID " + aStudyGroup.getGroupId() + "." );
    }

    /**
     * A method which adds student to TableView that don't have mark at the moment.
     */
    private void addStudentsWithoutMarksToTableView( StudyGroup studyGroup, List< Integer > studentsIDFromStudyGroup,
                                                     Set< Mark > studyGroupMarks, TableView< Mark > studyGroupsMarksTableView )
    {
        LOGGER.info( "Adding empty Marks for Student without a Mark." );

        List< Mark > undefinedStudyGroupMarks = new ArrayList<>();
        for( Integer indexNumber : studentsIDFromStudyGroup )
        {
            boolean found = false;
            for( Mark mark : studyGroupMarks )
            {
                if( mark.getMarkId().getStudentId() == indexNumber )
                {
                    found = true;
                    break;
                }
            }
            if( !found )
            {
                undefinedStudyGroupMarks.add( new Mark( indexNumber, studyGroup.getLecturerId(),
                        studyGroup.getUniversitySubjectId(), null ) );
            }
        }
        undefinedStudyGroupMarks.forEach( newMark -> dataService.addNewMarkToDatabase( newMark ) );
        undefinedStudyGroupMarks.forEach( newMark -> cacheProvider.getMarks().add( newMark ) );
        studyGroupsMarksTableView.getItems().addAll( undefinedStudyGroupMarks );
    }

}
