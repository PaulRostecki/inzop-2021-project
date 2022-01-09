package panel;

import cache.CacheProvider;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import model.model.Lecturer;
import model.model.StudyGroup;

import java.util.List;
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

    private ListView< StudyGroup > studyGroupsListView;

    private static final CacheProvider cacheProvider = CacheProvider.getCacheProvider();

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
        studyGroupsListView = new ListView<>();
        studyGroupsListView.getSelectionModel().setSelectionMode( SelectionMode.SINGLE );

        List< StudyGroup > studyGroups = cacheProvider.getStudyGroups().values().stream()
                .filter( sG -> sG.getLecturerId() == lecturer.getId() )
                .collect( Collectors.toList() );
        studyGroupsListView.getItems().addAll( studyGroups );
        leftSidePane.setCenter( studyGroupsListView );
    }
}
