package panel;

import cache.CacheProvider;
import constant.PermissionTypeEnum;
import factory.AlertFactory;
import factory.PanelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.extensions.Account;
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

    private static final CacheProvider cacheProvider = CacheProvider.getCacheProvider();

    public void initialize()
    {

    }

    public LoginPanel()
    {

    }

    @FXML
    private void logIn()
    {
        final String email = loginField.getText();
        final String password = passwordField.getText();

        if( email.trim().isEmpty() || password.trim().isEmpty() )
        {
            LOGGER.info( "Logging failed because of lack of required data." );
            AlertFactory.popUpInfoAlert( "Nieudane logowanie",
                    "Logowanie się nie powiodło z powodu niekompletnych danych." );
            return;
        }

        Account account = lookForAccount( email );
        if( account == null )
        {
            LOGGER.info( "There is no account linked with email " + email + "." );
            AlertFactory.popUpInfoAlert( "Nieudane logowanie",
                    "Nie istnieje konto z przypisanem emailem: " + email + "." );
            return;
        }
        validateAccountDataLogin( account, email, password );
    }

    private Stage createMainPanel()
    {
        return PanelFactory.createMainPanel();
    }

    private void initMainPanelAndAttachAccount( Account aAccount )
    {
        Stage mainPanel = createMainPanel();
        mainPanel.setUserData( aAccount );
        mainPanel.show();
        getCurrentStage( loginField ).hide();
    }

    private Account lookForAccount( String aEmail )
    {
        return cacheProvider.getAccounts().values()
                .stream()
                .filter( acc -> acc.getEmail().equals( aEmail ) )
                .findAny()
                .orElse( null );
    }

    private void validateAccountDataLogin( Account aAccount, String aEmail, String aPassword )
    {
        if( aAccount.getPassword().equals( aPassword ) )
        {
            if ( aAccount.getPermissionType() == PermissionTypeEnum.MODERATOR )
            {
                LOGGER.info( aEmail + " logged as MODERATOR." );
                initMainPanelAndAttachAccount( aAccount );
            }
            else if( aAccount.getPermissionType() == PermissionTypeEnum.STUDENT )
            {
                LOGGER.info( aEmail + " logged as STUDENT." );
                initMainPanelAndAttachAccount( aAccount );
            }
            else if( aAccount.getPermissionType() == PermissionTypeEnum.LECTURER )
            {
                LOGGER.info( aEmail + " logged as LECTURER." );
                initMainPanelAndAttachAccount( aAccount );
            }
        }
        else
        {
            LOGGER.info( "Invalid password for " + aEmail + "." );
            AlertFactory.popUpInfoAlert( "Nieudane logowanie",
                    "Niepoprawne haslo dla konta z emailem " + aEmail + "." );
        }
    }
}
