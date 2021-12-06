package util;

import javafx.scene.control.Alert;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AlertUtils
{
    private static final Logger LOGGER = LogManager.getLogger( AlertUtils.class );


    public static void popUpErrorAlert( Throwable e )
    {
        LOGGER.error( "Popping up error alert." );
        e.printStackTrace();
        Alert alert = new Alert( Alert.AlertType.ERROR );

        alert.setTitle( "Error." );
        alert.setHeaderText( e.getClass().getCanonicalName() );
        alert.setContentText( e.getMessage() );
        alert.showAndWait();
    }


    public static void popUpInfoAlert( String aTitle, String aHeader, String aContent )
    {
        LOGGER.info( "Popping up info alert." );
        Alert alert = new Alert( Alert.AlertType.INFORMATION );

        alert.setTitle( aTitle );
        alert.setHeaderText( aHeader );
        alert.setContentText( aContent );
        alert.showAndWait();
    }


    public static void popUpInfoAlert( String aTitle, String aHeader )
    {
        popUpInfoAlert( aTitle, aHeader, StringUtils.EMPTY );
    }
}
