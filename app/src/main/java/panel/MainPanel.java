package panel;

import cache.CacheProvider;
import constant.ModelEnum;
import constant.PathsConstants;
import factory.AlertFactory;
import factory.TableViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Lecturer;
import model.Student;
import model.StudyGroup;
import model.UniversitySubject;
import model.extensions.Announcement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

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
        Stage announcementPanel = createAnnouncementPanel();
        ArrayList< Object > paramObjets = new ArrayList<>();
        // add lecturer id.
        paramObjets.add( 1 );

        announcementPanel.setUserData( paramObjets );
        announcementPanel.show();
    }

    private Stage createAnnouncementPanel()
    {
        LOGGER.info( "Creating Announcement Panel." );
        final Stage newPanel = new Stage();
        Parent root = null;
        URL urlToFXML = null;
        URL urlToCSS = null;

        try
        {
            urlToFXML = getClass().getResource( PathsConstants.ANNOUNCEMENT_PANEL_FXML_PATH );
            urlToCSS = getClass().getResource( PathsConstants.ANNOUNCEMENT_PANEL_CSS_PATH );
            root = FXMLLoader.load(  urlToFXML );
            Objects.requireNonNull( root );
            LOGGER.info( "Announcement Panel loaded." );
        }
        catch ( IOException | NullPointerException e )
        {
            LOGGER.fatal( e.getClass().getSimpleName() + " thrown while initializing Announcement Panel." );
            AlertFactory.popUpErrorAlert( e );
            System.exit( 1 );
        }

        newPanel.setTitle( "Nadaj komunikat" );
        newPanel.setResizable( false );

        final Scene scene = new Scene( root );
//        setStyleForLoginPanel( scene, urlToCSS );
        setIcon( newPanel );

        newPanel.setScene( scene );
        return newPanel;
    }

}
