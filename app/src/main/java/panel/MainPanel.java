package panel;

import cache.CacheProvider;
import constant.ModelEnum;
import factory.PanelFactory;
import factory.TableViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.extensions.Announcement;
import model.model.Lecturer;
import model.model.Student;
import model.model.StudyGroup;
import model.model.UniversitySubject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


/**
 * Panel for main functionalities of USOS.
 *
 * @author created: Michał Musiałowicz on 30.12.2021
 * @author last changed:
 */
public class MainPanel implements PanelIf
{
    private static final Logger LOGGER = LogManager.getLogger( MainPanel.class );

    @FXML
    private BorderPane mainPanelPane;

    private final TableViewFactory tableViewFactory = new TableViewFactory();

    private final CacheProvider cacheProvider = CacheProvider.getCacheProvider();

    public MainPanel()
    {
    }

    public void initialize()
    {

    }

    @FXML
    private void showStudentsOnTableView()
    {
        LOGGER.info( "Displaying Students on Main Panel." );
        final TableView< Student > tableView =
                (TableView< Student >) tableViewFactory.createTableView( ModelEnum.STUDENT );
        cacheProvider.getStudents().values().forEach( student -> tableView.getItems().add( student ) );
        tableView.refresh();
        mainPanelPane.setCenter( tableView );
    }

    @FXML
    private void showLecturersOnTableView()
    {
        LOGGER.info( "Displaying Lecturers on Main Panel." );
        final TableView< Lecturer > tableView =
                (TableView< Lecturer >) tableViewFactory.createTableView( ModelEnum.LECTURER );
        cacheProvider.getLecturers().values().forEach( lecturer -> tableView.getItems().add( lecturer ) );
        tableView.refresh();
        mainPanelPane.setCenter( tableView );

    }

    @FXML
    private void showStudyGroupsOnTableView()
    {
        LOGGER.info( "Displaying Study Groups on Main Panel." );
        final TableView< StudyGroup > tableView =
                (TableView< StudyGroup >) tableViewFactory.createTableView( ModelEnum.STUDY_GROUP );
        cacheProvider.getStudyGroups().values().forEach( studyGroup -> tableView.getItems().add( studyGroup ) );
        tableView.refresh();
        mainPanelPane.setCenter( tableView );
    }

    @FXML
    private void showUniversitySubjectsOnTableView()
    {
        LOGGER.info( "Displaying University Subjects on Main Panel." );
        final TableView< UniversitySubject > tableView =
                (TableView< UniversitySubject >) tableViewFactory.createTableView( ModelEnum.UNIVERSITY_SUBJECT );
        cacheProvider.getUniversitySubjects().values().forEach( universitySubject -> tableView.getItems().add( universitySubject ) );
        tableView.refresh();
        mainPanelPane.setCenter( tableView );
    }

    @FXML
    private void showAnnouncementsOnTableView()
    {
        LOGGER.info( "Displaying Announcements on Main Panel." );
        final TableView< Announcement > tableView =
                (TableView< Announcement >) tableViewFactory.createTableView( ModelEnum.ANNOUNCEMENT );
        cacheProvider.getAnnouncements().forEach( announcement -> tableView.getItems().add( announcement ) );
        tableView.refresh();
        mainPanelPane.setCenter( tableView );
    }

    @FXML
    private void sendAnnouncement()
    {
        Stage announcementPanel = PanelFactory.createAnnouncementPanel();
        ArrayList< Object > paramObjets = new ArrayList<>();
        // add lecturer id.
        paramObjets.add( 1 );

        announcementPanel.setUserData( paramObjets );
        announcementPanel.show();
    }
}
