package factory;

import constant.ModelEnum;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.model.Lecturer;
import model.model.Student;
import model.model.StudyGroup;
import model.model.UniversitySubject;
import model.extensions.Announcement;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * TableView Factory for model.
 *
 * @author created: Michał Musiałowicz on 11.12.2021
 * @author last changed:
 */
public class TableViewFactory
{
    private static final Logger LOGGER = LogManager.getLogger( TableViewFactory.class );

    public TableViewFactory()
    {

    }

    public TableView< ? > createTableView( ModelEnum aModelClass )
    {
        switch( aModelClass )
        {
            case STUDENT:
                return createTableViewForStudents();
            case LECTURER:
                return createTableViewForLecturers();
            case STUDY_GROUP:
                return createTableViewForStudyGroups();
            case UNIVERSITY_SUBJECT:
                return createTableViewForUniversitySubjects();
            case ANNOUNCEMENT:
                return createTableViewForAnnouncements();
            default:
                return new TableView<>();
        }
    }

    private TableView< Student > createTableViewForStudents()
    {
        LOGGER.info( "Creating TableView for Students." );
        final TableView< Student > tableView = new TableView<>();
        configureTableView( tableView );

        final TableColumn< Student, String > parentColumn = new TableColumn<>( "Studenci" );
        final TableColumn< Student, String >[] columns = new TableColumn[ 8 ];

        columns [ 0 ] = new TableColumn<>("Numer albumu" );
        columns [ 1 ] = new TableColumn<>("Imie" );
        columns [ 2 ] = new TableColumn<>("Nazwisko" );
        columns [ 3 ] = new TableColumn<>("PESEL" );
        columns [ 4 ] = new TableColumn<>("Adres" );
        columns [ 5 ] = new TableColumn<>("Data urodzenia" );
        columns [ 6 ] = new TableColumn<>("Numer telefonu" );
        columns [ 7 ] = new TableColumn<>("Adres e-mail" );

        columns [ 0 ].setCellValueFactory( new PropertyValueFactory<>( "indexNumber" ) );
        columns [ 1 ].setCellValueFactory( new PropertyValueFactory<>( "firstName" ) );
        columns [ 2 ].setCellValueFactory( new PropertyValueFactory<>( "lastName" ) );
        columns [ 3 ].setCellValueFactory( new PropertyValueFactory<>( "PESEL" ) );
        columns [ 4 ].setCellValueFactory( new PropertyValueFactory<>( "address" ) );
        columns [ 5 ].setCellValueFactory( new PropertyValueFactory<>( "dateOfBirthAsString" ) );
        columns [ 6 ].setCellValueFactory( new PropertyValueFactory<>( "phoneNumber" ) );
        columns [ 7 ].setCellValueFactory( new PropertyValueFactory<>( "email" ) );

        parentColumn.getColumns().addAll( columns );
        tableView.getColumns().add( parentColumn );
        return tableView;
    }

    private TableView< Lecturer > createTableViewForLecturers()
    {
        LOGGER.info( "Creating TableView for Lecturers." );
        final TableView< Lecturer > tableView = new TableView<>();
        configureTableView( tableView );

        final TableColumn< Lecturer, String > parentColumn = new TableColumn<>( "Wykładowcy" );
        final TableColumn< Lecturer, String >[] columns = new TableColumn[ 8 ];

        columns [ 0 ] = new TableColumn<>("Imie" );
        columns [ 1 ] = new TableColumn<>("Nazwisko" );
        columns [ 2 ] = new TableColumn<>("Tytul" );
        columns [ 3 ] = new TableColumn<>("PESEL" );
        columns [ 4 ] = new TableColumn<>("Adres" );
        columns [ 5 ] = new TableColumn<>("Data urodzenia" );
        columns [ 6 ] = new TableColumn<>("Numer telefonu" );
        columns [ 7 ] = new TableColumn<>("Adres e-mail" );

        columns [ 0 ].setCellValueFactory( new PropertyValueFactory<>( "firstName" ) );
        columns [ 1 ].setCellValueFactory( new PropertyValueFactory<>( "lastName" ) );
        columns [ 2 ].setCellValueFactory( new PropertyValueFactory<>( "academicTitle" ) );
        columns [ 3 ].setCellValueFactory( new PropertyValueFactory<>( "PESEL" ) );
        columns [ 4 ].setCellValueFactory( new PropertyValueFactory<>( "address" ) );
        columns [ 5 ].setCellValueFactory( new PropertyValueFactory<>( "dateOfBirthAsString" ) );
        columns [ 6 ].setCellValueFactory( new PropertyValueFactory<>( "phoneNumber" ) );
        columns [ 7 ].setCellValueFactory( new PropertyValueFactory<>( "email" ) );

        parentColumn.getColumns().addAll( columns );
        tableView.getColumns().add( parentColumn );
        return tableView;
    }

    private TableView< StudyGroup > createTableViewForStudyGroups()
    {
        LOGGER.info( "Creating TableView for Study Groups." );
        final TableView< StudyGroup > tableView = new TableView<>();
        configureTableView( tableView );

        final TableColumn< StudyGroup, String > parentColumn = new TableColumn<>( "Grupy zajęciowe" );
        final TableColumn< StudyGroup, String >[] columns = new TableColumn[ 6 ];

        columns [ 0 ] = new TableColumn<>( "Przedmiot" );
        columns [ 1 ] = new TableColumn<>( "Dzień zajęć" );
        columns [ 2 ] = new TableColumn<>( "Godzina rozpoczęcia zajęć" );
        columns [ 3 ] = new TableColumn<>( "Imie prowadzącego" );
        columns [ 4 ] = new TableColumn<>( "Nazwisko prowadzącego" );
        columns [ 5 ] = new TableColumn<>( "Liczba studentów" );

        columns [ 0 ].setCellValueFactory( new PropertyValueFactory<>( "universitySubjectName" ) );
        columns [ 1 ].setCellValueFactory( new PropertyValueFactory<>( "dayString" ) );
        columns [ 2 ].setCellValueFactory( new PropertyValueFactory<>( "startTime" ) );
        columns [ 3 ].setCellValueFactory( new PropertyValueFactory<>( "lecturerFirstName" ) );
        columns [ 4 ].setCellValueFactory( new PropertyValueFactory<>( "lecturerLastName" ) );
        columns [ 5 ].setCellValueFactory( new PropertyValueFactory<>( "numberOfStudents" ) );

        parentColumn.getColumns().addAll( columns );
        tableView.getColumns().add( parentColumn );
        return tableView;
    }

    private TableView< UniversitySubject > createTableViewForUniversitySubjects()
    {
        LOGGER.info( "Creating TableView for University Subjects." );
        final TableView< UniversitySubject > tableView = new TableView<>();
        configureTableView( tableView );

        final TableColumn< UniversitySubject, String > parentColumn = new TableColumn<>( "Grupy zajęciowe" );
        final TableColumn< UniversitySubject, String >[] columns = new TableColumn[ 3 ];

        columns [ 0 ] = new TableColumn<>( "Nazwa przedmiotu");
        columns [ 1 ] = new TableColumn<>( "Opis przedmiotu" );
        columns [ 2 ] = new TableColumn<>( "Punkty ECTS" );

        columns [ 0 ].setCellValueFactory( new PropertyValueFactory<>( "name" ) );
        columns [ 1 ].setCellValueFactory( new PropertyValueFactory<>( "description" ) );
        columns [ 2 ].setCellValueFactory( new PropertyValueFactory<>( "ectsPoints" ) );

        parentColumn.getColumns().addAll( columns );
        tableView.getColumns().add( parentColumn );
        return tableView;
    }

    private TableView< Announcement > createTableViewForAnnouncements()
    {
        LOGGER.info( "Creating TableView for Announcements." );
        final TableView< Announcement > tableView = new TableView<>();
        configureTableView( tableView );

        final TableColumn< Announcement, String > parentColumn = new TableColumn<>( "Komunikaty" );
        final TableColumn< Announcement, String >[] columns = new TableColumn [ 5 ];

        final TableColumn< Announcement, String > lecturerColumn = new TableColumn<>( "Prowadzący" );


        columns [ 0 ] = new TableColumn<>( "Tytuł");
        columns [ 1 ] = new TableColumn<>( "Imię" );
        columns [ 2 ] = new TableColumn<>( "Nazwisko");
        columns [ 3 ] = new TableColumn<>( "Tytuł komunikatu" );

        columns [ 0 ].setCellValueFactory( new PropertyValueFactory<>( "lecturerTitle" ) );
        columns [ 1 ].setCellValueFactory( new PropertyValueFactory<>( "lecturerFirstName" ) );
        columns [ 2 ].setCellValueFactory( new PropertyValueFactory<>( "lecturerLastName" ) );
        columns [ 3 ].setCellValueFactory( new PropertyValueFactory<>( "title" ) );

        lecturerColumn.getColumns().addAll( columns[ 0 ], columns[ 1 ], columns[ 2 ] );

        parentColumn.getColumns().addAll( lecturerColumn, columns[ 3 ] );
        tableView.getColumns().add( parentColumn );
        return tableView;
    }

    private void configureTableView( TableView< ? > aTableView )
    {
        LOGGER.info( "Configuring TableView properties." );
        aTableView.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        aTableView.setPlaceholder( new Label( StringUtils.EMPTY ) );
        aTableView.getSelectionModel().setSelectionMode( SelectionMode.SINGLE );
    }
}
