package panel;

import cache.CacheProvider;
import constant.ModelEnum;
import constant.PathsConstants;
import factory.AlertFactory;
import factory.PanelFactory;
import factory.TableViewFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;
import model.extensions.Account;
import model.extensions.Announcement;
import model.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ModelUtil;

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
    private MenuItem seeTimeTableAction;

    @FXML
    private MenuItem seeMarksAction;

    @FXML
    private MenuItem seeAverageAction;

    @FXML
    private MenuItem evaluateStudentAction;

    @FXML
    private MenuItem sendAnnouncementAction;

    @FXML
    private Menu marksActions;

    @FXML
    private Menu moderatorActions;

    @FXML
    private BorderPane mainPanelPane;

    private final TableViewFactory tableViewFactory = new TableViewFactory();

    private final CacheProvider cacheProvider = CacheProvider.getCacheProvider();

    private Stage loginPanel;

    private Account loggedAccount;

    public MainPanel()
    {

    }

    private void setBackgroundIcon()
    {
        Image image = new Image( getClass().getResource( PathsConstants.BACKGROUND_IMAGE_PATH ).toString() );
        ImageView imageView = new ImageView( image );
        mainPanelPane.setCenter( imageView );
    }

    public void initialize()
    {
        Platform.runLater( this::initStageData );
        Platform.runLater( () -> setEnabledActionsBasedOnPermissions( loggedAccount ) );
        Platform.runLater( this::setBackgroundIcon );

        LOGGER.info( "Main Panel initialized." );
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
        addListenerForDoubleClickOnCell( tableView );
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
                .filter( mark -> mark.getMarkId().getStudentId() == student.getIndexNumber() )
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

    @FXML
    private void deleteStudents()
    {
        Stage deletePanel = PanelFactory.createDeletePanel( ModelEnum.STUDENT, loggedAccount );
        if( deletePanel != null )
        {
            deletePanel.show();
        }
    }

    @FXML
    private void deleteLecturers()
    {
        Stage deletePanel = PanelFactory.createDeletePanel( ModelEnum.LECTURER, loggedAccount );
        if( deletePanel != null )
        {
            deletePanel.show();
        }
    }

    @FXML
    private void deleteStudyGroups()
    {
        Stage deletePanel = PanelFactory.createDeletePanel( ModelEnum.STUDY_GROUP, loggedAccount );
        if( deletePanel != null )
        {
            deletePanel.show();
        }
    }

    @FXML
    private void deleteUniversitySubjects()
    {
        Stage deletePanel = PanelFactory.createDeletePanel( ModelEnum.UNIVERSITY_SUBJECT, loggedAccount );
        if( deletePanel != null )
        {
            deletePanel.show();
        }
    }

    @FXML
    private void showAddStudentPanel()
    {
        Stage addStudentPanel = PanelFactory.createAddStudentPanel();
        addStudentPanel.setUserData( ModelEnum.STUDENT );
        addStudentPanel.show();
    }

    @FXML
    private void showAddLecturerPanel()
    {
        Stage addLecturerPanel = PanelFactory.createAddLecturerPanel();
        addLecturerPanel.setUserData( ModelEnum.LECTURER );
        addLecturerPanel.show();
    }

    @FXML
    private void showAddUniversitySubjectPanel()
    {
        Stage addUniversitySubjectPanel = PanelFactory.createAddUniversitySubjectPanel();
        addUniversitySubjectPanel.setUserData( ModelEnum.UNIVERSITY_SUBJECT );
        addUniversitySubjectPanel.show();
    }

    @FXML
    private void showAddStudyGroupPanel()
    {
        Stage addStudyGroupPanel = PanelFactory.createAddStudyGroupPanel();
        addStudyGroupPanel.setUserData( ModelEnum.STUDY_GROUP );
        addStudyGroupPanel.show();
    }

    @FXML
    private void showStudentTimeTable()
    {
        Stage stage = new Stage();

        BorderPane borderPane = new BorderPane();
        HBox hBox = new HBox();
        hBox.setAlignment( Pos.CENTER );
        VBox vbox = new VBox();
        vbox.setAlignment( Pos.CENTER );
        vbox.setSpacing( 10d );

        borderPane.setCenter( hBox );
        hBox.getChildren().add( vbox );

        Student student = getStudentFromAccount();
        List< StudyGroup > studyGroups = cacheProvider.getStudyGroups().values().stream()
                .filter( sG -> sG.getStudents().contains( student ) )
                .sorted( ModelUtil.studyGroupComparator )
                .collect( Collectors.toList() );

        vbox.getChildren().addAll( studyGroups.stream()
                .map( sG -> new Label( sG + " " + sG.getDayString() ) )
                .collect( Collectors.toList() ) );

        PanelIf.setIcon( stage );
        stage.setResizable( false );
        stage.setTitle( "Plan zajęć: " + student.getFullName() );
        stage.setScene( new Scene( borderPane, 600, 600 ) );
        stage.show();
    }

    private void addListenerForDoubleClickOnCell( TableView< Announcement > aTableView )
    {
        aTableView.setOnMouseClicked( click -> {
            if ( click.getClickCount() == 2 )
            {
                Announcement announcement = aTableView.getSelectionModel().getSelectedItem();
                openAnnouncement( announcement );
            }
        });
    }

    private void openAnnouncement( Announcement aAnnouncement )
    {
        Stage showAnnouncementPanel = new Stage();
        showAnnouncementPanel.setTitle( aAnnouncement.getTitle() );

        TextFlow textFlow = new TextFlow();
        Text authorText = new Text( "Od: " + aAnnouncement.getLecturerTitle() + " "
                + aAnnouncement.getLecturerFirstName() + " " + aAnnouncement.getLecturerLastName() + "\n\n\n" );
        Text titleText = new Text( aAnnouncement.getTitle() + "\n\n\n" );
        Text contentText = new Text( aAnnouncement.getDetails() );

        authorText.setUnderline( true );
        authorText.setFont( Font.font( "Helvetica", FontPosture.ITALIC, 10 ) );
        titleText.setFont( Font.font( "Helvetica", FontPosture.ITALIC, 25 ) );
        contentText.setFont( Font.font( "Helvetica", FontPosture.ITALIC, 15 ) );

        VBox vBox = new VBox( textFlow );
        vBox.setAlignment( Pos.CENTER );

        textFlow.getChildren().addAll( authorText, titleText, contentText );
        textFlow.setTextAlignment( TextAlignment.CENTER );

        Scene scene = new Scene( vBox, 400, 400 );
        PanelIf.setIcon( showAnnouncementPanel );
        showAnnouncementPanel.setScene( scene );
        showAnnouncementPanel.show();
    }

    private void initStageData()
    {
       loggedAccount = (Account) ( (List) getCurrentStage( mainPanelPane ).getUserData() ).get( 0 );
       loginPanel = (Stage) ( (List) getCurrentStage( mainPanelPane ).getUserData() ).get( 1 );
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

    private void setEnabledActionsBasedOnPermissions( Account aAccount )
    {
        switch ( aAccount.getPermissionType() )
        {
            case LECTURER:
                seeMarksAction.setVisible( false );
                seeAverageAction.setVisible( false );
                moderatorActions.setVisible( false );
                seeTimeTableAction.setVisible( false );
                break;
            case STUDENT:
                evaluateStudentAction.setVisible( false );
                sendAnnouncementAction.setVisible( false );
                moderatorActions.setVisible( false );
                break;
            case MODERATOR:
                seeMarksAction.setVisible( false );
                seeAverageAction.setVisible( false );
                evaluateStudentAction.setVisible( false );
                sendAnnouncementAction.setVisible( false );
                marksActions.setVisible( false );
                break;
        }
    }

    @FXML
    private void logout()
    {
        getCurrentStage( mainPanelPane ).hide();
        loginPanel.show();
    }
}
