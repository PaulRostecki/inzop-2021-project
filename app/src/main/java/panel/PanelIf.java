package panel;

import constant.PathsConstants;
import javafx.scene.Node;
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
    static void setIcon( Stage aPanel )
    {
        String urlToIcon = PanelIf.class.getResource( PathsConstants.ICON_PATH ).toString();
        Image image = new Image( urlToIcon );
        aPanel.getIcons().add( image );
    }

    default Stage getCurrentStage( Node aNode )
    {
        return (Stage) aNode.getScene().getWindow();
    }
}
