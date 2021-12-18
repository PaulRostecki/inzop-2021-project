package panel;

import cache.CacheProvider;
import factory.AlertFactory;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.extensions.Announcement;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Objects;

public class AnnouncementPanel implements PanelIf
{
    private final CacheProvider cacheProvider = CacheProvider.getCacheProvider();

    @FXML
    private TextField announcementTitleTextField;

    @FXML
    private TextArea announcementDescriptionTextArea;

    private StringProperty titleValueProperty;

    private StringProperty descriptionValueProperty;

    private int lecturerId;

    private Stage announcementPanelStage;

    public AnnouncementPanel()
    {

    }

    public void initialize()
    {
        titleValueProperty = announcementTitleTextField.textProperty();
        descriptionValueProperty = announcementDescriptionTextArea.textProperty();

        Platform.runLater( this::initData );
        Platform.runLater( () -> setIcon( announcementPanelStage ) );
    }

    private void initData()
    {
        announcementPanelStage = getCurrentStage( announcementTitleTextField );
        lecturerId = (int) ((ArrayList<Object>) announcementPanelStage.getUserData()).get( 0 );
    }

    @FXML
    private void makeAnnouncement()
    {
        if( !Objects.equals( titleValueProperty.getValue(), StringUtils.EMPTY ) &&
                !Objects.equals( descriptionValueProperty.getValue(), StringUtils.EMPTY ) )
        {
            Announcement newAnnouncement = new Announcement( lecturerId, titleValueProperty.getValue(),
                    descriptionValueProperty.getValue() );
            cacheProvider.getAnnouncements().add( newAnnouncement );

            announcementPanelStage.hide();
            AlertFactory.popUpConfirmationAlert( "Operacja się powiodła",
                    ( "Komunikat o tytule " + titleValueProperty.getValue() + " został przesłany wszystkim studentom" ) );
        }
        else if ( Objects.equals( titleValueProperty.getValue(), StringUtils.EMPTY ) &&
                    Objects.equals( descriptionValueProperty.getValue(), StringUtils.EMPTY ) )
        {
            AlertFactory.popUpInfoAlert( "Operacja się nie powiodła", "Komunikat nie został przesłany studentom",
                    "Treść i tytuł komunikatu nie może być pusta." );
        }
        else if ( Objects.equals( titleValueProperty.getValue(), StringUtils.EMPTY ) )
        {
            AlertFactory.popUpInfoAlert( "Operacja się nie powiodła", "Komunikat nie został przesłany studentom",
                    "Komunikat nie zawiera tytułu." );
        }
        else if ( Objects.equals( descriptionValueProperty.getValue(), StringUtils.EMPTY ) )
        {
            AlertFactory.popUpInfoAlert( "Operacja się nie powiodła", "Komunikat nie został przesłany studentom",
                    "Komunikat nie zawiera treści." );
        }
    }
}
