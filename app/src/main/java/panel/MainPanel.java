package panel;

import constant.ModelEnum;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import model.Lecturer;
import model.Student;
import model.StudyGroup;
import model.UniversitySubject;
import factory.TableViewFactory;

public class MainPanel
{
    @FXML
    private BorderPane mainPanelPane;

    private final TableViewFactory tableViewFactory = new TableViewFactory();

    public MainPanel()
    {

    }

    public void initialize()
    {

    }

    @FXML
    private void showStudentsOnList()
    {
        final TableView< Student > tableView =
                (TableView< Student >) tableViewFactory.createTableView( ModelEnum.STUDENT );
        mainPanelPane.setCenter( tableView );
    }

    @FXML
    private void showLecturersOnList()
    {
        final TableView< Lecturer > tableView =
                (TableView< Lecturer >) tableViewFactory.createTableView( ModelEnum.LECTURER );
        mainPanelPane.setCenter( tableView );
    }

    @FXML
    private void showStudyGroupsOnList()
    {
        final TableView<StudyGroup> tableView =
                (TableView< StudyGroup >) tableViewFactory.createTableView( ModelEnum.STUDY_GROUP );
        mainPanelPane.setCenter( tableView );
    }

    @FXML
    private void showUniversitySubjectsOnList()
    {
        final TableView<UniversitySubject> tableView =
                (TableView< UniversitySubject >) tableViewFactory.createTableView( ModelEnum.UNIVERSITY_SUBJECT );
        mainPanelPane.setCenter( tableView );
    }

}
