package init;

import constant.PathsConstants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import panel.PanelIf;
import factory.AlertFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * Application initializer.
 *
 * @author created: Michał Musiałowicz on 06.12.2021
 * @author last changed:
 */
public class InitApplication extends Application implements PanelIf
{
    private final Logger LOGGER = LogManager.getLogger( InitApplication.class );

    public static void main ( String[] args )
    {
        launch( args );
    }

    @Override
    public void start( Stage initStage )
    {
        Stage loginPanel = createLoginPanel( initStage );
        loginPanel.show();
    }


    private Stage createLoginPanel( Stage loginPanel )
    {
        LOGGER.info( "Creating new panel." );
        Parent root = null;
        URL urlToFXML = null;
        URL urlToCSS = null;

        try
        {
            urlToFXML = getClass().getResource( PathsConstants.LOGIN_PANEL_FXML_PATH );
            urlToCSS = getClass().getResource( PathsConstants.LOGIN_PANEL_CSS_PATH );
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

        loginPanel.setTitle( "Zaloguj się" );
        loginPanel.setResizable( false );

        Scene loginScene = new Scene( root );
        setStyleForLoginPanel( loginScene, urlToCSS );
        setIcon( loginPanel );

        loginPanel.setScene( loginScene );
        return loginPanel;
    }

    private void setStyleForLoginPanel( Scene loginScene, URL css )
    {
        loginScene.getStylesheets().clear();
        loginScene.getStylesheets().add( css.toExternalForm() );
    }
}
