package factory;

import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import panel.PanelIf;

/**
 * Factory for various Alert Types.
 *
 * @author created: Michał Musiałowicz on 11.12.2021
 * @author last changed:
 */
public class AlertFactory implements PanelIf
{
    private static final Logger LOGGER = LogManager.getLogger( AlertFactory.class );


    public static void popUpErrorAlert( Throwable e )
    {
        LOGGER.error( "Popping up error alert." );
        e.printStackTrace();
        Alert alert = new Alert( Alert.AlertType.ERROR );

        alert.setTitle( "Error." );
        alert.setHeaderText( e.getClass().getCanonicalName() );
        alert.setContentText( e.getMessage() );
        setIconForAlert( alert );
        alert.showAndWait();
    }


    public static void popUpInfoAlert( String aTitle, String aHeader, String aContent )
    {
        LOGGER.info( "Popping up info alert." );
        Alert alert = new Alert( Alert.AlertType.INFORMATION );

        alert.setTitle( aTitle );
        alert.setHeaderText( aHeader );
        alert.setContentText( aContent );
        setIconForAlert( alert );
        alert.showAndWait();
    }


    public static void popUpInfoAlert( String aTitle, String aHeader )
    {
        popUpInfoAlert( aTitle, aHeader, StringUtils.EMPTY );
    }

    public static void popUpConfirmationAlert( String aTitle, String aHeader, String aContent )
    {
        LOGGER.info( "Popping up confirmation alert." );
        Alert alert = new Alert( Alert.AlertType.CONFIRMATION );

        alert.setTitle( aTitle );
        alert.setHeaderText( aHeader );
        alert.setContentText( aContent );
        setIconForAlert( alert );
        alert.showAndWait();
    }

    public static void popUpConfirmationAlert( String aTitle, String aHeader )
    {
        popUpConfirmationAlert( aTitle, aHeader, StringUtils.EMPTY );
    }

    private static void setIconForAlert( Alert aAlert )
    {
        PanelIf.setIcon( (Stage) aAlert.getDialogPane().getScene().getWindow() );
    }
}
