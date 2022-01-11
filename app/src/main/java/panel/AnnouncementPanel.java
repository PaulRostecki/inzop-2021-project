package panel;

import cache.CacheProvider;
import cache.DataService;
import factory.AlertFactory;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.extensions.Announcement;
import model.model.Lecturer;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;


/**
 * Panel for sending Announcements.
 *
 * @author created: Michał Musiałowicz on 11.12.2021
 * @author last changed:
 */
public class AnnouncementPanel implements PanelIf
{
    private final CacheProvider cacheProvider = CacheProvider.getCacheProvider();

    @FXML
    private TextField announcementTitleTextField;

    @FXML
    private TextArea announcementDescriptionTextArea;

    private StringProperty titleValueProperty;

    private StringProperty descriptionValueProperty;

    private Lecturer lecturer;

    private Stage announcementPanelStage;

    private final DataService dataService = DataService.getDataService();

    public AnnouncementPanel()
    {

    }

    public void initialize()
    {
        titleValueProperty = announcementTitleTextField.textProperty();
        descriptionValueProperty = announcementDescriptionTextArea.textProperty();

        Platform.runLater( this::initData );
        Platform.runLater( () -> PanelIf.setIcon( announcementPanelStage ) );
    }

    private void initData()
    {
        announcementPanelStage = getCurrentStage( announcementTitleTextField );
        lecturer = (Lecturer) announcementPanelStage.getUserData();
    }

    @FXML
    private void makeAnnouncement()
    {
        if( !Objects.equals( titleValueProperty.getValue(), StringUtils.EMPTY ) &&
                !Objects.equals( descriptionValueProperty.getValue(), StringUtils.EMPTY ) )
        {
            Announcement newAnnouncement = new Announcement( cacheProvider.getAnnouncements().size() + 1, lecturer.getId(),
                    titleValueProperty.getValue(), descriptionValueProperty.getValue() );
            cacheProvider.getAnnouncements().add( newAnnouncement );
            dataService.addNewAnnouncementToDatabase( newAnnouncement );


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
