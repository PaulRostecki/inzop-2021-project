package constant;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Equals tests between objects od different classes
 *
 * @author created: Michał Nowak on 22.01.2021
 * @author last changed:
 */

class PathsConstantsTest {

    private static final String resourcePath = "src/main/resources";
    private static List<File> resourcesFilesPaths;

    @BeforeAll
    static void setUp() {
        resourcesFilesPaths = new ArrayList<>();

        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.MAIN_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.MAIN_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.LOGIN_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.LOGIN_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.ANNOUNCEMENT_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.ANNOUNCEMENT_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.ADD_LECTURER_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.ADD_LECTURER_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.ADD_STUDENT_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.ADD_STUDENT_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.ADD_STUDY_GROUP_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.ADD_STUDY_GROUP_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.ADD_UNIVERSITY_SUBJECT_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.ADD_UNIVERSITY_SUBJECT_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.AVERAGE_MARKS_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.AVERAGE_MARKS_PANEL_CSS_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.EVALUATE_STUDENTS_PANEL_FXML_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.EVALUATE_STUDENTS_PANEL_CSS_PATH));

        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.HIBERNATE_CONF_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.ICON_PATH));
        resourcesFilesPaths.add(new File(resourcePath + PathsConstants.BACKGROUND_IMAGE_PATH));
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
