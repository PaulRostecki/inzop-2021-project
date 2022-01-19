package cache;

import constant.ModelEnum;
import factory.AlertFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.model.Lecturer;
import model.model.Student;
import model.model.StudyGroup;
import model.model.UniversitySubject;
import panel.PanelIf;
import validation.InputValidator;

import java.time.LocalDate;

public class DataCreator implements PanelIf
{
    private CacheProvider cacheProvider = CacheProvider.getCacheProvider();

    private DataService dataService = DataService.getDataService();

    private InputValidator inputValidator = new InputValidator();

    private ModelEnum mode;

    @FXML
    private BorderPane addObjectPane;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField peselTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField dutyTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private ComboBox< Integer > ectsPointsComboBox;

    @FXML
    private ComboBox< String > academicTitleComboBox;

    @FXML
    private ComboBox< Lecturer > lecturerComboBox;

    @FXML
    private ComboBox< UniversitySubject > universitySubjectComboBox;

    @FXML
    private ComboBox< String > dayComboBox;

    @FXML
    private ComboBox< String > startTimeComboBox;

    @FXML
    private DatePicker dateOfBirthDatePicker;

    public DataCreator()
    {

    }

    public void initialize()
    {
        Platform.runLater( this::setAddObjectMode );
        Platform.runLater( this::setValidationForControls );
    }

    private void setAddObjectMode()
    {
        mode = (ModelEnum) getCurrentStage( addObjectPane ).getUserData();
    }

    private void setValidationForControls()
    {
        switch ( mode )
        {
            case STUDENT:
                setValidationForControlsWhenAddingStudent();
                break;
            case LECTURER:
                setValidationForControlsWhenAddingLecturer();
                break;
            case UNIVERSITY_SUBJECT:
                setValidationForControlsWhenAddingUniversitySubject();
                break;
            case STUDY_GROUP:
                setValidationForControlsWhenAddingStudyGroup();
                break;
        }
    }

    private void setValidationForControlsWhenAddingStudent()
    {
        inputValidator.disallowFutureDatesForDatePicker( dateOfBirthDatePicker, 19 );
    }

    private void setValidationForControlsWhenAddingLecturer()
    {
        inputValidator.disallowFutureDatesForDatePicker( dateOfBirthDatePicker, 19 );
        if( academicTitleComboBox != null )
        {
            Platform.runLater( () -> inputValidator.setValidAcademicTitles( academicTitleComboBox ) );
        }
    }

    private void setValidationForControlsWhenAddingUniversitySubject()
    {
        if( ectsPointsComboBox != null )
        {
            Platform.runLater( () -> inputValidator.setValidEctsPoints( ectsPointsComboBox ) );
        }
    }

    private void setValidationForControlsWhenAddingStudyGroup()
    {
        if( lecturerComboBox != null && universitySubjectComboBox != null
                && startTimeComboBox != null && dayComboBox != null )
        {
            Platform.runLater( () -> inputValidator.setValidLecturers( lecturerComboBox ) );
            Platform.runLater( () -> inputValidator.setValidUniversitySubjects( universitySubjectComboBox ) );
            Platform.runLater( () -> inputValidator.setValidDays( dayComboBox ) );
            Platform.runLater( () -> inputValidator.setValidStartTimes( startTimeComboBox ) );
        }
    }

    @FXML
    private void addStudent()
    {
        final String firstName = firstNameTextField.getText();
        final String lastName = lastNameTextField.getText();
        final String pesel = peselTextField.getText();
        final String address = addressTextField.getText();
        final String phoneNumber = phoneNumberTextField.getText();
        final String email = emailTextField.getText();
        final LocalDate dateOfBirth = dateOfBirthDatePicker.getValue();

        final int id = inputValidator.getIDThatDoesntBelongToAnyStudent();

        if( !inputValidator.isEmailValid( email ) || !inputValidator.isNameValid( firstName )
                || !inputValidator.isNameValid( lastName ) || !inputValidator.isPESELValid( pesel ) ||
                    !inputValidator.isPhoneNumberValid( phoneNumber ) || !inputValidator.isAddressValid( address )
                        || !inputValidator.isDateOfBirthValid( dateOfBirth ) )
        {
            return;
        }

        Student newStudent = new Student( firstName, lastName, pesel, address, dateOfBirth, phoneNumber, email, id );
        cacheProvider.getStudents().put( id, newStudent );
        dataService.addNewStudentToDatabase( newStudent );
        AlertFactory.popUpInfoAlert( "Informacja", "Operacja się powiodła.",
                "Nowy student został dodany do dziennika." );
    }

    @FXML
    private void addLecturer()
    {
        final String firstName = firstNameTextField.getText();
        final String lastName = lastNameTextField.getText();
        final String pesel = peselTextField.getText();
        final String address = addressTextField.getText();
        final String phoneNumber = phoneNumberTextField.getText();
        final String email = emailTextField.getText();
        final LocalDate dateOfBirth = dateOfBirthDatePicker.getValue();
        final String duty = dutyTextField.getText();
        final String academicTitle = academicTitleComboBox.getValue();

        final int id = inputValidator.getIDThatDoesntBelongToAnyLecturer();

        if( !inputValidator.isEmailValid( email ) || !inputValidator.isNameValid( firstName )
                || !inputValidator.isNameValid( lastName ) || !inputValidator.isPESELValid( pesel ) ||
                !inputValidator.isPhoneNumberValid( phoneNumber ) || !inputValidator.isAddressValid( address )
                || !inputValidator.isDateOfBirthValid( dateOfBirth ) || !inputValidator.isDutyValid( duty )
                    || !inputValidator.isComboBoxValueValid( academicTitleComboBox, "Tytul naukowy:" ) )
        {
            return;
        }
        Lecturer newLecturer = new Lecturer( firstName, lastName, pesel, address, dateOfBirth,
                phoneNumber, email, academicTitle, duty, id );
        cacheProvider.getLecturers().put( id, newLecturer );
        dataService.addNewLecturerToDatabase( newLecturer );
        AlertFactory.popUpInfoAlert( "Informacja", "Operacja się powiodła.",
                "Nowy wykładowca został dodany do dziennika." );
    }

    @FXML
    private void addUniversitySubject()
    {
        final String name = nameTextField.getText();
        final String description = descriptionTextField.getText();
        final int ectsPoints = ectsPointsComboBox.getValue();

        final int id = inputValidator.getIDThatDoesntBelongToAnyUniversitySubject();

        if( !inputValidator.isNameValid( name )
                || !inputValidator.isComboBoxValueValid( ectsPointsComboBox, "Ilość punktów ECTS:" ) )
        {
            return;
        }
        UniversitySubject universitySubject = new UniversitySubject( id, name, description, ectsPoints );
        cacheProvider.getUniversitySubjects().put( id, universitySubject );
        dataService.addNewUniversitySubjectToDatabase( universitySubject );
        AlertFactory.popUpInfoAlert( "Informacja", "Operacja się powiodła.",
                "Nowy przedmiot został dodany do dziennika." );
    }

    @FXML
    private void addStudyGroup()
    {
        final Lecturer lecturer = lecturerComboBox.getValue();
        final UniversitySubject universitySubject = universitySubjectComboBox.getValue();
        final String day = dayComboBox.getValue();
        final String startTime = startTimeComboBox.getValue();

        final int id = inputValidator.getIDThatDoesntBelongToAnyStudyGroup();

        if( !inputValidator.isComboBoxValueValid( lecturerComboBox, "Prowadzący" )
                || !inputValidator.isComboBoxValueValid( universitySubjectComboBox, "Przedmiot" )
                    || !inputValidator.isComboBoxValueValid( dayComboBox, "Dzień" )
                        || !inputValidator.isComboBoxValueValid( startTimeComboBox, "Godzina rozpoczęcia" ) )
        {
            return;
        }
        StudyGroup studyGroup = new StudyGroup( id, lecturer.getId(), universitySubject.getId(), day, startTime );
        CacheProvider.getCacheProvider().getStudyGroups().put( id, studyGroup );
        dataService.addNewStudyGroupToDatabase( studyGroup );
        AlertFactory.popUpInfoAlert( "Informacja", "Operacja się powiodła.",
                "Nowa grupa została dodana do dziennika." );
    }


}
