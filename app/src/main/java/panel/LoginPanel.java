package panel;

import constant.PathsConstants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import factory.AlertFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * Login Panel.
 *
 * @author created: Michał Musiałowicz on 11.12.2021
 * @author last changed:
 */
public class LoginPanel implements PanelIf
{
    private static final Logger LOGGER = LogManager.getLogger( LoginPanel.class );

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Hyperlink loginHyperlink;

    public void initialize()
    {

    }

    public LoginPanel()
    {
    }

    @FXML
    private void logIn()
    {
        // we need to check if provided e-mail belongs to one of the users, if so - we need to check if the password
        // matches. If it does - we allow user to log in, and in every other case we pop up an appropriate alert.

        Stage mainPanel = createMainPanel();
        mainPanel.show();
    }

    private Stage createMainPanel()
    {
        LOGGER.info( "Creating new panel." );

        final Stage newPanel = new Stage();
        Parent root = null;
        URL urlToFXML = null;
        URL urlToCSS = null;

        try
        {
            urlToFXML = getClass().getResource( PathsConstants.MAIN_PANEL_FXML_PATH );
            urlToCSS = getClass().getResource( PathsConstants.MAIN_PANEL_CSS_PATH );
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

        newPanel.setTitle( "Main Panel" );
        newPanel.setResizable( true );
        newPanel.setMaximized( true );

        final Scene scene = new Scene( root );
//        setStyleForLoginPanel( loginScene, urlToCSS );
        setIcon( newPanel );

        newPanel.setScene( scene );
        return newPanel;
    }


}
