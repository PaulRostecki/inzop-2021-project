package resources;

import constant.PathsConstants;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for existence and access of files from resources.
 *
 * @author created: Michał Nowak on 22.01.2021
 * @author last changed:
 */

class ResourcesTest {

    private static final String RESOURCE_PATH = "src/main/resources";
    private static List<File> resourcesFilesPaths;

    @BeforeAll
    static void setUp() {
        resourcesFilesPaths = new ArrayList<>();

        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.MAIN_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.MAIN_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.LOGIN_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.LOGIN_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.ANNOUNCEMENT_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.ANNOUNCEMENT_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.ADD_LECTURER_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.ADD_LECTURER_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.ADD_STUDENT_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.ADD_STUDENT_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.ADD_STUDY_GROUP_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.ADD_STUDY_GROUP_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.ADD_UNIVERSITY_SUBJECT_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.ADD_UNIVERSITY_SUBJECT_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.AVERAGE_MARKS_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.AVERAGE_MARKS_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.EVALUATE_STUDENTS_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.EVALUATE_STUDENTS_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.HIBERNATE_CONF_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.ICON_PATH));
        resourcesFilesPaths.add(new File(RESOURCE_PATH + PathsConstants.BACKGROUND_IMAGE_PATH));
    }

    @Test
    void testResourcesFiles() {

        resourcesFilesPaths.forEach(file -> {
                assertTrue(file.isFile());
                assertTrue(file.canRead());
                assertTrue(file.canWrite());
                assertTrue(file.canExecute());
        });
    }
}
