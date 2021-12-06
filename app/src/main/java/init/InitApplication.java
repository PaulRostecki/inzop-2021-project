package init;

import constant.PathsConstants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.AlertUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class InitApplication extends Application
{
    private static final Double LOGIN_PANEL_HEIGHT = 275D;

    private static final Double LOGIN_PANEL_WIDTH = 500D;

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
        Parent root = null;
        URL urlToFXML = null;
        URL urlToCSS = null;

        try
        {
            urlToFXML = getClass().getResource( PathsConstants.LOGIN_PANEL_FXML_PATH );
            urlToCSS = getClass().getResource( PathsConstants.LOGIN_PANEL_CSS_PATH );
            root = FXMLLoader.load(  urlToFXML );
            Objects.requireNonNull( root );
            LOGGER.info( "LoginPanel loaded." );
        }
        catch ( IOException | NullPointerException e )
        {
            LOGGER.fatal( e.getClass().getSimpleName() + " thrown while initializing LoginPanel." );
            AlertUtils.popUpErrorAlert( e );
            System.exit( 1 );
        }

        LOGGER.info( "Creating new panel." );
        loginPanel.setTitle( "Login Panel" );
        loginPanel.setResizable( false );

        Scene loginScene = new Scene( root, LOGIN_PANEL_WIDTH, LOGIN_PANEL_HEIGHT );
        setStyleForLoginPanel( loginScene, urlToCSS );

        loginPanel.setScene( loginScene );
        return loginPanel;
    }

    private void setStyleForLoginPanel( Scene loginScene, URL css )
    {
        loginScene.getStylesheets().clear();
        loginScene.getStylesheets().add( css.toExternalForm() );
    }

}
