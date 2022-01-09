package panel;

import cache.CacheProvider;
import constant.ModelEnum;
import factory.AlertFactory;
import factory.PanelFactory;
import factory.TableViewFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.extensions.Account;
import model.extensions.Announcement;
import model.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;


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

    private Account loggedAccount;

    public MainPanel()
    {

    }

    public void initialize()
    {
        Platform.runLater( this::initLoggedAccount );
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
    private void showStudentMarksOnTableView()
    {
        Student student = getStudentFromAccount();
        if( student == null )
        {
            AlertFactory.popUpInfoAlert( "BŁĄD", "Podane konto nie jest powiązane z żadnym studentem." );
            return;
        }
        final TableView< Mark > tableView = tableViewFactory.createTableViewForStudentMarks( student );
        List< Mark > studentMarks = cacheProvider.getMarks().stream()
                .filter( mark -> mark.getMarkId().getStudentId() == Integer.parseInt( student.getIndexNumber() ) )
                .collect( Collectors.toList() );
        tableView.getItems().addAll( studentMarks );
        tableView.refresh();
        mainPanelPane.setCenter( tableView );
    }

    @FXML
    private void showStudentAverageMarks()
    {
        Student student = getStudentFromAccount();
        if( student == null )
        {
            AlertFactory.popUpInfoAlert( "BŁĄD", "Podane konto nie jest powiązane z żadnym studentem." );
            return;
        }
        Stage averageMarksPanel = PanelFactory.createAverageMarksPanel();
        averageMarksPanel.setUserData( student );
        averageMarksPanel.show();
    }

    @FXML
    private void sendAnnouncement()
    {
        Lecturer lecturer = getLecturerFromAccount();
        if( lecturer == null )
        {
            AlertFactory.popUpInfoAlert( "BŁĄD", "Podane konto nie jest powiązane z żadnym wykładowcą." );
            return;
        }

        Stage announcementPanel = PanelFactory.createAnnouncementPanel();
        announcementPanel.setUserData( lecturer );
        announcementPanel.show();
    }

    @FXML
    private void evaluateStudents()
    {
        Lecturer lecturer = getLecturerFromAccount();
        if( lecturer == null )
        {
            AlertFactory.popUpInfoAlert( "BŁĄD", "Podane konto nie jest powiązane z żadnym wykładowcą." );
            return;
        }

        Stage evaluateStudentsPanel = PanelFactory.createEvaluateStudentsPanel();
        evaluateStudentsPanel.setUserData( lecturer );
        evaluateStudentsPanel.show();
    }


    private void initLoggedAccount()
    {
       loggedAccount = (Account) getCurrentStage( mainPanelPane ).getUserData();
    }

    private Student getStudentFromAccount()
    {
        return cacheProvider.getStudents().values().stream()
                .filter( student -> student.getEmail().equals( loggedAccount.getEmail() ) )
                .findAny()
                .orElse( null );
    }

    private Lecturer getLecturerFromAccount()
    {
        return cacheProvider.getLecturers().values().stream()
                .filter( lecturer -> lecturer.getEmail().equals( loggedAccount.getEmail() ) )
                .findAny()
                .orElse( null );
    }
}
