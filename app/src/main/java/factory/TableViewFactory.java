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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        final List< TableColumn< Student, String > > listOfColumns = Stream.of(
                new TableColumn< Student, String >( "Numer albumu "),
                new TableColumn< Student, String >( "Imie" ),
                new TableColumn< Student, String >( "Nazwisko" ),
                new TableColumn< Student, String >( "PESEL" ),
                new TableColumn< Student, String >( "Adres" ),
                new TableColumn< Student, String >( "Data urodzenia" ),
                new TableColumn< Student, String >( "Numer telefonu" ),
                new TableColumn< Student, String >( "Adres e-mail" ) )
                        .collect( Collectors.toList() );

        tableView.getColumns().addAll( listOfColumns );
        return tableView;
    }

    private TableView< Lecturer > createTableViewForLecturers()
    {
        final TableView< Lecturer > tableView = new TableView<>();
        tableView.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        tableView.setPlaceholder( new Label( StringUtils.EMPTY ) );

        final List< TableColumn< Lecturer, String > > listOfColumns = Stream.of(
                        new TableColumn< Lecturer, String >( "Imie"),
                        new TableColumn< Lecturer, String >( "Nazwisko" ),
                        new TableColumn< Lecturer, String >( "Tytul" ),
                        new TableColumn< Lecturer, String >( "PESEL" ),
                        new TableColumn< Lecturer, String >( "Adres" ),
                        new TableColumn< Lecturer, String >( "Data urodzenia" ),
                        new TableColumn< Lecturer, String >( "Numer telefonu" ),
                        new TableColumn< Lecturer, String >( "Adres e-mail" ) )
                .collect( Collectors.toList() );

        tableView.getColumns().addAll( listOfColumns );
        return tableView;
    }

    private TableView< StudyGroup > createTableViewForStudyGroups()
    {
        final TableView< StudyGroup > tableView = new TableView<>();
        tableView.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        tableView.setPlaceholder( new Label( StringUtils.EMPTY ) );

        final List< TableColumn< StudyGroup, String > > listOfColumns = Stream.of(
                        new TableColumn< StudyGroup, String >( "Przedmiot" ),
                        new TableColumn< StudyGroup, String >( "Dzień zajęć" ),
                        new TableColumn< StudyGroup, String >( "Godzina rozpoczęcia zajęć" ),
                        new TableColumn< StudyGroup, String >( "Imie prowadzącego" ),
                        new TableColumn< StudyGroup, String >( "Nazwisko prowadzącego" ),
                        new TableColumn< StudyGroup, String >( "Liczba studentów" ) )
                .collect( Collectors.toList() );

        tableView.getColumns().addAll( listOfColumns );
        return tableView;
    }

    private TableView< UniversitySubject > createTableViewForUniversitySubjects()
    {
        final TableView< UniversitySubject > tableView = new TableView<>();
        tableView.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        tableView.setPlaceholder( new Label( StringUtils.EMPTY ) );

        final List< TableColumn< UniversitySubject, String > > listOfColumns = Stream.of(
                        new TableColumn< UniversitySubject, String >( "Nazwa przedmiotu"),
                        new TableColumn< UniversitySubject, String >( "Opis przedmiotu" ),
                        new TableColumn< UniversitySubject, String >( "Punkty ECTS" ) )
                .collect( Collectors.toList() );

        tableView.getColumns().addAll( listOfColumns );
        return tableView;
    }
}
