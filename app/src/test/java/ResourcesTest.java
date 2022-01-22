import constant.PathsConstants;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Equals tests between objects od different classes
 *
 * @author created: Michał Nowak on 22.01.2021
 * @author last changed:
 */

class ResourcesTest {

    private static final String resourcePath = "src/main/resources";

    @Test
    void testCssDir() {

        File loginPanelStyle = new File(resourcePath + PathsConstants.LOGIN_PANEL_CSS_PATH);
        File mainPanelStyle = new File(resourcePath + PathsConstants.MAIN_PANEL_CSS_PATH);
        File makeAnnouncementStyle = new File(resourcePath + PathsConstants.ANNOUNCEMENT_PANEL_CSS_PATH);

        assertTrue(loginPanelStyle.isFile());
        assertTrue(loginPanelStyle.canRead());
        assertTrue(loginPanelStyle.canWrite());
        assertTrue(loginPanelStyle.canExecute());

        assertTrue(mainPanelStyle.isFile());
        assertTrue(mainPanelStyle.canRead());
        assertTrue(mainPanelStyle.canWrite());
        assertTrue(mainPanelStyle.canExecute());

        assertTrue(makeAnnouncementStyle.isFile());
        assertTrue(makeAnnouncementStyle.canRead());
        assertTrue(makeAnnouncementStyle.canWrite());
        assertTrue(makeAnnouncementStyle.canExecute());
    }

    @Test
    void testFxmlDir() {

        File loginPanel = new File(resourcePath + PathsConstants.LOGIN_PANEL_FXML_PATH);
        File mainPanel = new File(resourcePath + PathsConstants.MAIN_PANEL_FXML_PATH);
        File makeAnnouncement = new File(resourcePath + PathsConstants.ANNOUNCEMENT_PANEL_FXML_PATH);

        assertTrue(loginPanel.isFile());
        assertTrue(loginPanel.canRead());
        assertTrue(loginPanel.canWrite());
        assertTrue(loginPanel.canExecute());

        assertTrue(mainPanel.isFile());
        assertTrue(mainPanel.canRead());
        assertTrue(mainPanel.canWrite());
        assertTrue(mainPanel.canExecute());

        assertTrue(makeAnnouncement.isFile());
        assertTrue(makeAnnouncement.canRead());
        assertTrue(makeAnnouncement.canWrite());
        assertTrue(makeAnnouncement.canExecute());
    }

    @Test
    void testIconsDir() {

        File travelJournal = new File(resourcePath + PathsConstants.ICON_PATH);

        assertTrue(travelJournal.isFile());
        assertTrue(travelJournal.canRead());
        assertTrue(travelJournal.canWrite());
        assertTrue(travelJournal.canExecute());
    }
}