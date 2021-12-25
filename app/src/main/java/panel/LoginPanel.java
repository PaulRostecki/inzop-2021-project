package panel;

import factory.PanelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Panel for logging in.
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
        // for Miguel:
        // we need to check if provided e-mail belongs to one of the users, if so - we need to check if the password
        // matches. If it does - we allow user to log in (create
        // main panel and show it), and in every other case we pop up an appropriate alert.
        // see CacheProvider and AlertFactory classes.
        LOGGER.info( "Logged to USOS as " ); // add user string
        Stage mainPanel = createMainPanel();
        mainPanel.show();
        getCurrentStage( loginField ).hide();
    }

    private Stage createMainPanel()
    {
        return PanelFactory.createMainPanel();
    }
}
