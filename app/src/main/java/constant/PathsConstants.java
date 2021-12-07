package constant;

import java.io.File;

public class PathsConstants
{
    private PathsConstants(){}

    private static final String SEP = File.separator;

    /**
     * Names of CSS and FXML files for LoginPanel
     */

    private static final String LOGIN_PANEL_FXML_FILE_NAME = "loginPanel.fxml";
    private static final String LOGIN_PANEL_CSS_FILE_NAME = "loginPanelStyle.css";


    /**
     * Relative paths (from resources dir) to FXML/CSS files for LoginPanel.
     */

    public static String LOGIN_PANEL_FXML_PATH = ( SEP + "fxml" + SEP +
            LOGIN_PANEL_FXML_FILE_NAME).replace( "\\", "/" );
    public static String LOGIN_PANEL_CSS_PATH = ( SEP + "css" + SEP +
            LOGIN_PANEL_CSS_FILE_NAME).replace( "\\", "/" );
}
