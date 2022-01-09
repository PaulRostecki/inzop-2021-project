package panel;

import cache.CacheProvider;
import factory.TableViewFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import model.model.Lecturer;
import model.model.Mark;
import model.model.StudyGroup;

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
    @FXML
    private BorderPane leftSidePane;

    @FXML
    private BorderPane rightSidePane;

    private Lecturer lecturer;

    private static final CacheProvider cacheProvider = CacheProvider.getCacheProvider();

    private static final TableViewFactory tableViewFactory = new TableViewFactory();

    public EvaluateStudentsPanel()
    {

    }

    public void initialize()
    {
        Platform.runLater( this::initLecturer );
        Platform.runLater( this::initStudyGroupsForListView );
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

        leftSidePane.setCenter( studyGroupsListView );
    }

    private void initStudyGroupsMarksForListView( final StudyGroup aStudyGroup )
    {
        TableView< Mark > studyGroupsMarksTableView = tableViewFactory.createTableViewForStudyGroupMarks( aStudyGroup );

        final List< Integer > studentsIDFromStudyGroup = cacheProvider.getStudents().values().stream()
                .filter( student -> aStudyGroup.getStudents().contains( student ) )
                .map( student -> Integer.parseInt( student.getIndexNumber() ) )
                .collect( Collectors.toList() );

        Set< Mark > studyGroupMarks = cacheProvider.getMarks().stream()
                .filter( mark -> studentsIDFromStudyGroup.contains( mark.getMarkId().getStudentId() ) )
                .collect( Collectors.toSet() );
        HashSet< Mark > hashedStudyGroupMarks = new HashSet<>( deleteDuplicates( studyGroupMarks ) );


        studyGroupsMarksTableView.getItems().addAll( hashedStudyGroupMarks );
        addStudentsWithoutMarksToTableView( aStudyGroup, studentsIDFromStudyGroup, hashedStudyGroupMarks, studyGroupsMarksTableView);
        rightSidePane.setCenter(studyGroupsMarksTableView);
    }

    /**
     * A method which adds student to TableView that don't have mark at the moment.
     */
    private void addStudentsWithoutMarksToTableView( StudyGroup studyGroup, List< Integer > studentsIDFromStudyGroup,
                                                     Set< Mark > studyGroupMarks, TableView< Mark > studyGroupsMarksTableView )
    {
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
        studyGroupsMarksTableView.getItems().addAll( undefinedStudyGroupMarks );
    }

    /**
     * Additional validation for client side to check whether Student doesn't have two marks for one StudyGroup.
     */
    private Set< Mark > deleteDuplicates( Set< Mark > studyGroupMarks )
    {
        Set< Mark > noDuplicateMarks = new HashSet<>( studyGroupMarks );
        for( Mark mark : studyGroupMarks )
        {
            noDuplicateMarks.removeIf( mark_ -> mark != mark_
                    && mark.getMarkId().getStudentId() == mark_.getMarkId().getStudentId() );
        }
        return noDuplicateMarks;
    }
}
