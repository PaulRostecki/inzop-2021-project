package factory;

import cache.CacheProvider;
import cache.DataService;
import constant.ModelEnum;
import constant.PathsConstants;
import constant.PermissionTypeEnum;
import init.AppInitializer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.extensions.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import panel.PanelIf;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * Factory for Stages.
 *
 * @author created: Michał Musiałowicz on 29.12.2021
 * @author last changed:
 */
public class PanelFactory implements PanelIf
{
    private static final Logger LOGGER = LogManager.getLogger( PanelFactory.class );

    private static final CacheProvider cacheProvider = CacheProvider.getCacheProvider();

    private static final DataService dataService = DataService.getDataService();

    private PanelFactory()
    {

    }

    public static Stage createLoginPanel( Stage aStage )
    {
        LOGGER.info( "Creating new panel." );
        Parent root = null;
        URL urlToFXML = null;
        URL urlToCSS = null;

        try
        {
            urlToFXML = AppInitializer.class.getResource( PathsConstants.LOGIN_PANEL_FXML_PATH );
            urlToCSS = AppInitializer.class.getResource( PathsConstants.LOGIN_PANEL_CSS_PATH );
            root = FXMLLoader.load(  urlToFXML );
            Objects.requireNonNull( root );
            LOGGER.info( "Login Panel loaded." );
        }
        catch ( IOException | NullPointerException e )
        {
            LOGGER.fatal( e.getClass().getSimpleName() + " thrown while initializing Login Panel." );
            AlertFactory.popUpErrorAlert( e );
            System.exit( 1 );
        }

        aStage.setTitle( "Zaloguj się" );
        aStage.setResizable( false );

        Scene loginScene = new Scene( root );
        setStylesheetForPanel( loginScene, urlToCSS );
        PanelIf.setIcon( aStage );

        aStage.setScene( loginScene );
        return aStage;
    }

    public static Stage createMainPanel()
    {
        LOGGER.info( "Creating Main Panel." );
        final Stage newPanel = new Stage();
        Parent root = null;
        URL urlToFXML = null;
        URL urlToCSS = null;

        try
        {
            urlToFXML = AppInitializer.class.getResource( PathsConstants.MAIN_PANEL_FXML_PATH );
            urlToCSS = AppInitializer.class.getResource( PathsConstants.MAIN_PANEL_CSS_PATH );
            root = FXMLLoader.load(  urlToFXML );
            Objects.requireNonNull( root );
            LOGGER.info( "Main Panel loaded." );
        }
        catch ( IOException | NullPointerException e )
        {
            LOGGER.fatal( e.getClass().getSimpleName() + " thrown while initializing Main Panel." );
            AlertFactory.popUpErrorAlert( e );
            System.exit( 1 );
        }

        newPanel.setTitle( "Dziennik elektroniczny" );
        newPanel.setResizable( true );
        newPanel.setMaximized( true );
        newPanel.setMinHeight( 500 );
        newPanel.setMinWidth( 1000 );

        final Scene scene = new Scene( root );
//        setStyleForLoginPanel( scene, urlToCSS );
        PanelIf.setIcon( newPanel );

        newPanel.setScene( scene );
        return newPanel;
    }

    public static Stage createAnnouncementPanel()
    {
        LOGGER.info( "Creating Announcement Panel." );
        final Stage newPanel = new Stage();
        Parent root = null;
        URL urlToFXML = null;
        URL urlToCSS = null;

        try
        {
            urlToFXML = AppInitializer.class.getResource( PathsConstants.ANNOUNCEMENT_PANEL_FXML_PATH );
            urlToCSS = AppInitializer.class.getResource( PathsConstants.ANNOUNCEMENT_PANEL_CSS_PATH );
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
        PanelIf.setIcon( newPanel );

        newPanel.setScene( scene );
        return newPanel;
    }

    public static Stage createEvaluateStudentsPanel()
    {
        LOGGER.info( "Creating Evaluate Students Panel." );
        final Stage newPanel = new Stage();
        Parent root = null;
        URL urlToFXML = null;
        URL urlToCSS = null;

        try
        {
            urlToFXML = AppInitializer.class.getResource( PathsConstants.EVALUATE_STUDENTS_PANEL_FXML_PATH );
            urlToCSS = AppInitializer.class.getResource( PathsConstants.EVALUATE_STUDENTS_PANEL_CSS_PATH );
            root = FXMLLoader.load(  urlToFXML );
            Objects.requireNonNull( root );
            LOGGER.info( "Evaluate Students Panel loaded." );
        }
        catch ( IOException | NullPointerException e )
        {
            LOGGER.fatal( e.getClass().getSimpleName() + " thrown while initializing Evaluate Students Panel." );
            AlertFactory.popUpErrorAlert( e );
            System.exit( 1 );
        }

        newPanel.setTitle( "Wystaw oceny" );
        newPanel.setResizable( false );

        final Scene scene = new Scene( root );
        setStylesheetForPanel( scene, urlToCSS );
        PanelIf.setIcon( newPanel );

        newPanel.setScene( scene );
        return newPanel;
    }

    public static Stage createAverageMarksPanel()
    {
        LOGGER.info( "Creating Average Marks Panel." );
        final Stage newPanel = new Stage();
        Parent root = null;
        URL urlToFXML = null;
        URL urlToCSS = null;

        try
        {
            urlToFXML = AppInitializer.class.getResource( PathsConstants.AVERAGE_MARKS_PANEL_FXML_PATH );
            urlToCSS = AppInitializer.class.getResource( PathsConstants.AVERAGE_MARKS_PANEL_CSS_PATH );
            root = FXMLLoader.load(  urlToFXML );
            Objects.requireNonNull( root );
            LOGGER.info( "Average Marks Panel loaded." );
        }
        catch ( IOException | NullPointerException e )
        {
            LOGGER.fatal( e.getClass().getSimpleName() + " thrown while initializing Average Marks Panel." );
            AlertFactory.popUpErrorAlert( e );
            System.exit( 1 );
        }

        newPanel.setTitle( "Średnia ocen" );
        newPanel.setResizable( false );

        final Scene scene = new Scene( root );
        setStylesheetForPanel( scene, urlToCSS );
        PanelIf.setIcon( newPanel );

        newPanel.setScene( scene );
        return newPanel;
    }

    public static Stage createAddStudentPanel()
    {
        LOGGER.info( "Creating Add Student Panel." );
        final Stage newPanel = new Stage();
        Parent root = null;
        URL urlToFXML = null;
        URL urlToCSS = null;

        try
        {
            urlToFXML = AppInitializer.class.getResource( PathsConstants.ADD_STUDENT_PANEL_FXML_PATH );
            urlToCSS = AppInitializer.class.getResource( PathsConstants.ADD_STUDENT_PANEL_CSS_PATH );
            root = FXMLLoader.load(  urlToFXML );
            Objects.requireNonNull( root );
            LOGGER.info( "Add Student Panel loaded." );
        }
        catch ( IOException | NullPointerException e )
        {
            LOGGER.fatal( e.getClass().getSimpleName() + " thrown while initializing Add Student Panel." );
            AlertFactory.popUpErrorAlert( e );
            System.exit( 1 );
        }

        newPanel.setTitle( "Panel dodawania studenta" );
        newPanel.setResizable( false );

        final Scene scene = new Scene( root );
        PanelIf.setIcon( newPanel );

        newPanel.setScene( scene );
        return newPanel;
    }

    public static Stage createAddLecturerPanel()
    {
        LOGGER.info( "Creating Add Lecturer Panel." );
        final Stage newPanel = new Stage();
        Parent root = null;
        URL urlToFXML = null;
        URL urlToCSS = null;

        try
        {
            urlToFXML = AppInitializer.class.getResource( PathsConstants.ADD_LECTURER_PANEL_FXML_PATH );
            urlToCSS = AppInitializer.class.getResource( PathsConstants.ADD_LECTURER_PANEL_CSS_PATH );
            root = FXMLLoader.load(  urlToFXML );
            Objects.requireNonNull( root );
            LOGGER.info( "Add Lecturer Panel loaded." );
        }
        catch ( IOException | NullPointerException e )
        {
            LOGGER.fatal( e.getClass().getSimpleName() + " thrown while initializing Add Lecturer Panel." );
            AlertFactory.popUpErrorAlert( e );
            System.exit( 1 );
        }

        newPanel.setTitle( "Panel dodawania wykładowcy" );
        newPanel.setResizable( false );

        final Scene scene = new Scene( root );
        PanelIf.setIcon( newPanel );

        newPanel.setScene( scene );
        return newPanel;
    }

    public static Stage createAddUniversitySubjectPanel()
    {
        LOGGER.info( "Creating Add University Subject Panel." );
        final Stage newPanel = new Stage();
        Parent root = null;
        URL urlToFXML = null;
        URL urlToCSS = null;

        try
        {
            urlToFXML = AppInitializer.class.getResource( PathsConstants.ADD_UNIVERSITY_SUBJECT_PANEL_FXML_PATH );
            urlToCSS = AppInitializer.class.getResource( PathsConstants.ADD_UNIVERSITY_SUBJECT_PANEL_CSS_PATH );
            root = FXMLLoader.load(  urlToFXML );
            Objects.requireNonNull( root );
            LOGGER.info( "Add University Subject Panel loaded." );
        }
        catch ( IOException | NullPointerException e )
        {
            LOGGER.fatal( e.getClass().getSimpleName() + " thrown while initializing Add University Subjectt Panel." );
            AlertFactory.popUpErrorAlert( e );
            System.exit( 1 );
        }

        newPanel.setTitle( "Panel dodawania przedmiotu" );
        newPanel.setResizable( false );

        final Scene scene = new Scene( root );
        PanelIf.setIcon( newPanel );

        newPanel.setScene( scene );
        return newPanel;
    }

    public static Stage createAddStudyGroupPanel()
    {
        LOGGER.info( "Creating Add Study Group Panel." );
        final Stage newPanel = new Stage();
        Parent root = null;
        URL urlToFXML = null;
        URL urlToCSS = null;

        try
        {
            urlToFXML = AppInitializer.class.getResource( PathsConstants.ADD_STUDY_GROUP_PANEL_FXML_PATH );
            urlToCSS = AppInitializer.class.getResource( PathsConstants.ADD_STUDY_GROUP_PANEL_CSS_PATH );
            root = FXMLLoader.load(  urlToFXML );
            Objects.requireNonNull( root );
            LOGGER.info( "Add Study Group Panel loaded." );
        }
        catch ( IOException | NullPointerException e )
        {
            LOGGER.fatal( e.getClass().getSimpleName() + " thrown while initializing Add Study Group Panel." );
            AlertFactory.popUpErrorAlert( e );
            System.exit( 1 );
        }

        newPanel.setTitle( "Panel dodawania grupy zajęciowej" );
        newPanel.setResizable( false );

        final Scene scene = new Scene( root );
        PanelIf.setIcon( newPanel );

        newPanel.setScene( scene );
        return newPanel;
    }

    public static Stage createDeletePanel( ModelEnum aModelClass, Account aAccount )
    {
        if( aAccount.getPermissionType() !=  PermissionTypeEnum.MODERATOR )
        {
            AlertFactory.popUpInfoAlert( "BŁĄD", "Podane konto nie ma uprawnień moderatora." );
            return null;
        }

        Stage deleteModelObjectPanel = new Stage();
        PanelIf.setIcon( deleteModelObjectPanel );
        deleteModelObjectPanel.setTitle( "Panel usuwania" );
        ListView listView = new ListView();
        listView.getSelectionModel().setSelectionMode( SelectionMode.SINGLE );

        listView.setOnKeyPressed( keyEvent ->
        {
            if( listView.getSelectionModel().getSelectedItem() != null && keyEvent.getCode().equals( KeyCode.DELETE ) )
            {
                Object modelObject = listView.getSelectionModel().getSelectedItem();
                listView.getItems().remove( modelObject );
                dataService.deleteModelObjectFromDatabase( modelObject );
                listView.refresh();
                LOGGER.info( "Delete action called on object: " + modelObject.toString() );
            }
        } );

        switch ( aModelClass )
        {
            case STUDENT:
                listView.getItems().addAll( cacheProvider.getStudents().values() );
                break;
            case LECTURER:
                listView.getItems().addAll( cacheProvider.getLecturers().values() );
                break;
            case STUDY_GROUP:
                listView.getItems().addAll( cacheProvider.getStudyGroups().values() );
                break;
            case UNIVERSITY_SUBJECT:
                listView.getItems().addAll( cacheProvider.getUniversitySubjects().values() );
                break;
        }
        VBox vBox = new VBox();
        vBox.getChildren().add( listView );

        Scene scene = new Scene( vBox, 400, 400 );
        deleteModelObjectPanel.setScene( scene );
        return deleteModelObjectPanel;
    }

    private static void setStylesheetForPanel( Scene aScene, URL aCss )
    {
        aScene.getStylesheets().clear();
        aScene.getStylesheets().add( aCss.toExternalForm() );
    }
}
