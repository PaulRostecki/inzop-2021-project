package constant;

import java.io.File;

/**
 * Constants for all paths for resources directory.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
public class PathsConstants
{
    private PathsConstants(){}

    private static final String SEP = File.separator;

    /**
     * Names of files.
     */
    private static final String LOGIN_PANEL_FXML_FILE_NAME = "loginPanel.fxml";
    private static final String LOGIN_PANEL_CSS_FILE_NAME = "loginPanelStyle.css";
    private static final String MAIN_PANEL_FXML_FILE_NAME = "mainPanel.fxml";
    private static final String MAIN_PANEL_CSS_FILE_NAME = "mainPanelStyle.css";
    private static final String ICON_FILE_NAME = "travel-journal.png";


    /**
     * Relative paths (from resources dir) to files.
     */
    public static String LOGIN_PANEL_FXML_PATH = ( SEP + "fxml" + SEP +
            LOGIN_PANEL_FXML_FILE_NAME ).replace( "\\", "/" );
    public static String LOGIN_PANEL_CSS_PATH = ( SEP + "css" + SEP +
            LOGIN_PANEL_CSS_FILE_NAME ).replace( "\\", "/" );
    public static String MAIN_PANEL_FXML_PATH = ( SEP + "fxml" + SEP +
            MAIN_PANEL_FXML_FILE_NAME ).replace( "\\", "/" );
    public static String MAIN_PANEL_CSS_PATH = ( SEP + "css" + SEP +
            MAIN_PANEL_CSS_FILE_NAME ).replace( "\\", "/" );
    public static String ICON_PATH = ( SEP + "icons" + SEP +
            ICON_FILE_NAME ).replace( "\\", "/" );
}
