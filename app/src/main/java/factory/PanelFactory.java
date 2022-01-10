package factory;

import constant.PathsConstants;
import init.AppInitializer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
        setStyleForLoginPanel( loginScene, urlToCSS );
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
        setStyleForLoginPanel( scene, urlToCSS );
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
        setStyleForLoginPanel( scene, urlToCSS );
        PanelIf.setIcon( newPanel );

        newPanel.setScene( scene );
        return newPanel;
    }

    private static void setStyleForLoginPanel( Scene aScene, URL css )
    {
        aScene.getStylesheets().clear();
        aScene.getStylesheets().add( css.toExternalForm() );
    }
}
