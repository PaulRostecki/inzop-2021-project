package converter;

import factory.AlertFactory;
import javafx.util.converter.FloatStringConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ModelUtil;

/**
 * Extended Float String Converter from JavaFX Framework to support Float-String conversion, logging and popping alerts.
 *
 * @author created: Michał Musiałowicz on 11.01.2022
 * @author last changed:
 */
public class USOSFloatStringConverter extends FloatStringConverter
{
    private static final Logger LOGGER = LogManager.getLogger( USOSFloatStringConverter.class );

    @Override
    public String toString( Float aMarkValue )
    {
        try
        {
            if( aMarkValue == null )
            {
                return null;
            }

            if( ModelUtil.acceptedFloatMarks.contains( aMarkValue ) )
            {
                return super.toString( aMarkValue );
            }

            LOGGER.warn( "Incorrect mark value : " + aMarkValue );
            popUpInfoAlert();
            return null;
        }
        catch ( NumberFormatException e )
        {
            popUpInfoAlert();
        }
        return null;
    }

    @Override
    public Float fromString( String aMarkValue )
    {
        try
        {
            if( aMarkValue == null )
            {
                return null;
            }

            if( ModelUtil.acceptedStringMarks.contains( aMarkValue ) )
            {
                return super.fromString( aMarkValue );
            }

            LOGGER.warn( "Incorrect mark value : " + aMarkValue );
            popUpInfoAlert();
            return null;
        }
        catch ( NumberFormatException e )
        {
            popUpInfoAlert();
        }
        return null;
    }

    private void popUpInfoAlert()
    {
        AlertFactory.popUpInfoAlert( "BŁĄD",
                "Ocena nie mogła zostać zapisana z powodu błędu przy zapisie",  "Upewnij się, że ocena należy do " +
                        "przedziału 2.0 - 5.0 oraz czy nie zawiera niepożądanych znaków." );
    }
}
