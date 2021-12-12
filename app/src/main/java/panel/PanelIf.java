package panel;

import constant.PathsConstants;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Interface for all Panels (Stages).
 *
 * @author created: Michał Musiałowicz on 11.12.2021
 * @author last changed:
 */
public interface PanelIf
{
    default void setIcon( Stage panel )
    {
        String urlToIcon = getClass().getResource( PathsConstants.ICON_PATH ).toString();
        Image image = new Image( urlToIcon );
        panel.getIcons().add( image );
    }
}
