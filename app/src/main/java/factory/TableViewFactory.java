package factory;

import constant.ModelEnum;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Lecturer;
import model.Student;
import model.StudyGroup;
import model.UniversitySubject;
import org.apache.commons.lang3.StringUtils;

/**
 * TableView Factory for model.
 *
 * @author created: Michał Musiałowicz on 11.12.2021
 * @author last changed:
 */
public class TableViewFactory
{
    public TableViewFactory()
    {

    }

    public TableView< ? > createTableView( ModelEnum modelClass )
    {
        switch( modelClass )
        {
            case STUDENT:
                return createTableViewForStudents();
            case LECTURER:
                return createTableViewForLecturers();
            case STUDY_GROUP:
                return createTableViewForStudyGroups();
            case UNIVERSITY_SUBJECT:
                return createTableViewForUniversitySubjects();
            default:
                return new TableView<>();
        }
    }

    private TableView< Student > createTableViewForStudents()
    {
        final TableView< Student > tableView = new TableView<>();
        tableView.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        tableView.setPlaceholder( new Label( StringUtils.EMPTY ) );

        final TableColumn< Student, String > parentColumn = new TableColumn<>( "Studenci" );
        parentColumn.getColumns().addAll(
                new TableColumn< Student, String >( "Numer albumu "),
                new TableColumn< Student, String >( "Imie" ),
                new TableColumn< Student, String >( "Nazwisko" ),
                new TableColumn< Student, String >( "PESEL" ),
                new TableColumn< Student, String >( "Adres" ),
                new TableColumn< Student, String >( "Data urodzenia" ),
                new TableColumn< Student, String >( "Numer telefonu" ),
                new TableColumn< Student, String >( "Adres e-mail" ) );

        tableView.getColumns().add( parentColumn );
        return tableView;
    }

    private TableView< Lecturer > createTableViewForLecturers()
    {
        final TableView< Lecturer > tableView = new TableView<>();
        tableView.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        tableView.setPlaceholder( new Label( StringUtils.EMPTY ) );

        final TableColumn< Lecturer, String > parentColumn = new TableColumn<>( "Wykładowcy" );
        parentColumn.getColumns().addAll(
                new TableColumn< Lecturer, String >( "Imie"),
                new TableColumn< Lecturer, String >( "Nazwisko" ),
                new TableColumn< Lecturer, String >( "Tytul" ),
                new TableColumn< Lecturer, String >( "PESEL" ),
                new TableColumn< Lecturer, String >( "Adres" ),
                new TableColumn< Lecturer, String >( "Data urodzenia" ),
                new TableColumn< Lecturer, String >( "Numer telefonu" ),
                new TableColumn< Lecturer, String >( "Adres e-mail" ) );

        tableView.getColumns().add( parentColumn );
        return tableView;
    }

    private TableView< StudyGroup > createTableViewForStudyGroups()
    {
        final TableView< StudyGroup > tableView = new TableView<>();
        tableView.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        tableView.setPlaceholder( new Label( StringUtils.EMPTY ) );

        final TableColumn< StudyGroup, String > parentColumn = new TableColumn<>( "Grupy zajęciowe" );
        parentColumn.getColumns().addAll(
                new TableColumn< StudyGroup, String >( "Przedmiot" ),
                new TableColumn< StudyGroup, String >( "Dzień zajęć" ),
                new TableColumn< StudyGroup, String >( "Godzina rozpoczęcia zajęć" ),
                new TableColumn< StudyGroup, String >( "Imie prowadzącego" ),
                new TableColumn< StudyGroup, String >( "Nazwisko prowadzącego" ),
                new TableColumn< StudyGroup, String >( "Liczba studentów" ) );

        tableView.getColumns().add( parentColumn );
        return tableView;
    }

    private TableView< UniversitySubject > createTableViewForUniversitySubjects()
    {
        final TableView< UniversitySubject > tableView = new TableView<>();
        tableView.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        tableView.setPlaceholder( new Label( StringUtils.EMPTY ) );

        final TableColumn< UniversitySubject, String > parentColumn = new TableColumn<>( "Przedmioty" );
        parentColumn.getColumns().addAll(
                new TableColumn< UniversitySubject, String >( "Nazwa przedmiotu"),
                new TableColumn< UniversitySubject, String >( "Opis przedmiotu" ),
                new TableColumn< UniversitySubject, String >( "Punkty ECTS" ) );

        tableView.getColumns().add( parentColumn );
        return tableView;
    }
}
