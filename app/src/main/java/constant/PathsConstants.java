package constant;

import java.io.File;

/**
 * Constants for all paths in resources directory.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
public final class PathsConstants
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
    private static final String ANNOUNCEMENT_PANEL_FXML_FILE_NAME = "makeAnnouncement.fxml";
    private static final String ANNOUNCEMENT_PANEL_CSS_FILE_NAME = "makeAnnouncementStyle.css";
    private static final String EVALUATE_STUDENTS_PANEL_FXML_FILE_NAME = "evaluateStudents.fxml";
    private static final String EVALUATE_STUDENTS_PANEL_CSS_FILE_NAME = "evaluateStudentsStyle.css";
    private static final String AVERAGE_MARKS_PANEL_FXML_FILE_NAME = "averageMarks.fxml";
    private static final String AVERAGE_MARKS_PANEL_CSS_FILE_NAME = "averageMarksStyle.css";
    private static final String HIBERNATE_CONF_FILE_NAME = "persistence.xml";
    private static final String ICON_FILE_NAME = "travel-journal.png";


    /**
     * Relative paths (from resources dir) to files.
     */
    public static final String LOGIN_PANEL_FXML_PATH = ( SEP + "fxml" + SEP +
            LOGIN_PANEL_FXML_FILE_NAME ).replace( "\\", "/" );
    public static final String LOGIN_PANEL_CSS_PATH = ( SEP + "css" + SEP +
            LOGIN_PANEL_CSS_FILE_NAME ).replace( "\\", "/" );
    public static final String MAIN_PANEL_FXML_PATH = ( SEP + "fxml" + SEP +
            MAIN_PANEL_FXML_FILE_NAME ).replace( "\\", "/" );
    public static final String MAIN_PANEL_CSS_PATH = ( SEP + "css" + SEP +
            MAIN_PANEL_CSS_FILE_NAME ).replace( "\\", "/" );
    public static final String ANNOUNCEMENT_PANEL_FXML_PATH = ( SEP + "fxml" + SEP +
            ANNOUNCEMENT_PANEL_FXML_FILE_NAME ).replace( "\\", "/" );
    public static final String ANNOUNCEMENT_PANEL_CSS_PATH = ( SEP + "css" + SEP +
            ANNOUNCEMENT_PANEL_CSS_FILE_NAME ).replace( "\\", "/" );
    public static final String EVALUATE_STUDENTS_PANEL_FXML_PATH = ( SEP + "fxml" + SEP +
            EVALUATE_STUDENTS_PANEL_FXML_FILE_NAME ).replace( "\\", "/" );
    public static final String EVALUATE_STUDENTS_PANEL_CSS_PATH = ( SEP + "css" + SEP +
            EVALUATE_STUDENTS_PANEL_CSS_FILE_NAME ).replace( "\\", "/" );
    public static final String AVERAGE_MARKS_PANEL_FXML_PATH = ( SEP + "fxml" + SEP +
            AVERAGE_MARKS_PANEL_FXML_FILE_NAME ).replace( "\\", "/" );
    public static final String AVERAGE_MARKS_PANEL_CSS_PATH = ( SEP + "css" + SEP +
            AVERAGE_MARKS_PANEL_CSS_FILE_NAME ).replace( "\\", "/" );
    public static final String ICON_PATH = ( SEP + "icons" + SEP +
            ICON_FILE_NAME ).replace( "\\", "/" );
    public static final String HIBERNATE_CONF_PATH = ( SEP + "META-INF" + SEP +
            HIBERNATE_CONF_FILE_NAME ).replace( "\\", "/" );
}
