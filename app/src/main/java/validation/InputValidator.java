package validation;

import cache.CacheProvider;
import factory.AlertFactory;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import model.model.Lecturer;
import model.model.Student;
import model.model.StudyGroup;
import model.model.UniversitySubject;
import util.ModelUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator
{
    private CacheProvider cacheProvider = CacheProvider.getCacheProvider();

    public InputValidator()
    {

    }

    public boolean isEmailValid( String aEmail )
    {
        if( !aEmail.matches( RegexProvider.EMAIL_REGEX ) || !( aEmail.length() > 6 ) )
        {
            AlertFactory.popUpInfoAlert( "Błąd!", "Nie można dodać nowego obiektu.",
                    "Email musi mieć minimum 6 znaków oraz być w formacie *@*.*, gdzie '*' to dowolona ilość dowolnych znaków." );
            return false;
        }

        List< String > studentEmails = cacheProvider.getStudents().values().stream()
                .map( Student::getEmail )
                .collect( Collectors.toList() );
        List< String > lecturerEmails = cacheProvider.getLecturers().values().stream()
                .map( Lecturer::getEmail )
                .collect( Collectors.toList() );
        if( studentEmails.contains( aEmail ) || lecturerEmails.contains( aEmail ) )
        {
            AlertFactory.popUpInfoAlert( "Błąd", "Nie można dodać nowego obiektu.",
                    "Podany email należy już do studenta lub wykładowcy w bazie danych." );
            return false;
        }
        return true;
    }

    public boolean isNameValid( String aName )
    {
        if( !aName.matches( RegexProvider.NAME_REGEX ) )
        {
            AlertFactory.popUpInfoAlert( "Błąd", "Nie można dodać nowego obiektu.",
                    "Imię/Nazwisko podane jest w złym formacie. Dozwlone są tylko litery." );
            return false;
        }
        return true;
    }

    public boolean isDutyValid( String aDuty )
    {
        if( !aDuty.matches( RegexProvider.DUTY_REGEX ) )
        {
            AlertFactory.popUpInfoAlert( "Błąd", "Nie można dodać nowego obiektu.",
                    "Dyżur podany jest w złym formacie." );
            return false;
        }
        return true;
    }

    public boolean isPESELValid( String aPESEL )
    {
        if( !aPESEL.matches( RegexProvider.PESEL_REGEX ) )
        {
            AlertFactory.popUpInfoAlert( "Błąd", "Nie można dodać nowego obiektu.",
                    "PESEL podany jest w złym formacie. Musi mieć dokładnie 11 cyfr." );
            return false;
        }
        List< String > studentPESELs = cacheProvider.getStudents().values().stream()
                .map( Student::getPESEL )
                .collect( Collectors.toList() );
        List< String > lecturerPESELs = cacheProvider.getLecturers().values().stream()
                .map( Lecturer::getPESEL )
                .collect( Collectors.toList() );
        if( studentPESELs.contains( aPESEL ) || lecturerPESELs.contains( aPESEL ) )
        {
            AlertFactory.popUpInfoAlert( "Błąd", "Nie można dodać nowego obiektu.",
                    "Podany PESEL należy już do studenta lub wykładowcy w bazie danych." );
            return false;
        }
        return true;
    }

    public boolean isPhoneNumberValid( String aPhoneNumber )
    {
        if( !aPhoneNumber.matches( RegexProvider.PHONE_NUMBER_REGEX ) )
        {
            AlertFactory.popUpInfoAlert( "Błąd", "Nie można dodać nowego obiektu.",
                    "Numer telefonu jest w złym formacie. Musi to być 9 cyfrowa liczba" );
            return false;
        }
        List< String > studentPhoneNumbers = cacheProvider.getStudents().values().stream()
                .map( Student::getPhoneNumber )
                .collect( Collectors.toList() );
        List< String > lecturersPhoneNumbers = cacheProvider.getLecturers().values().stream()
                .map( Lecturer::getPhoneNumber )
                .collect( Collectors.toList() );
        if( studentPhoneNumbers.contains( aPhoneNumber ) || lecturersPhoneNumbers.contains( aPhoneNumber ) )
        {
            AlertFactory.popUpInfoAlert( "Błąd", "Nie można dodać nowego obiektu.",
                    "Podany numer telefonu należy już do studenta lub wykładowcy w bazie danych." );
            return false;
        }
        return true;
    }

    public boolean isAddressValid( String aAddress )
    {
        boolean isValid = aAddress.matches( RegexProvider.ADDRESS_REGEX );
        if( !isValid )
        {
            AlertFactory.popUpInfoAlert( "Błąd", "Nie można dodać nowego obiektu.",
                    "Nie wprowadzono daty urodzenia." );
            return false;
        }
        return true;
    }

    public boolean isDateOfBirthValid( LocalDate aDateOfBirth )
    {
        boolean isValid = aDateOfBirth != null;
        if( !isValid )
        {
            AlertFactory.popUpInfoAlert( "Błąd", "Nie można dodać nowego obiektu.",
                    "Nie wprowadzono daty urodzenia." );
            return false;
        }
        return true;
    }

    public boolean isComboBoxValueValid(ComboBox< ? > aComboBox, Object aComboBoxName )
    {
        boolean isValid = aComboBox.getValue() != null;
        if( !isValid )
        {
            AlertFactory.popUpInfoAlert( "Błąd", "Nie można dodać nowego obiektu.",
                    "Nie wprowadzono informacji w " + aComboBoxName + "." );
            return false;
        }
        return true;
    }

    public int getIDThatDoesntBelongToAnyStudent()
    {
        int id = 10000;
        List< Integer > studentIDs = cacheProvider.getStudents().values().stream()
                .map( Student::getIndexNumber )
                .collect( Collectors.toList() );
        while( true )
        {
            if( !studentIDs.contains( id ) )
            {
                return id;
            }
            id++;
        }
    }

    public int getIDThatDoesntBelongToAnyLecturer()
    {
        int id = 1;
        List< Integer > lecturerIDs = cacheProvider.getLecturers().values().stream()
                .map( Lecturer::getId )
                .collect( Collectors.toList() );
        while( true )
        {
            if( !lecturerIDs.contains( id ) )
            {
                return id;
            }
            id++;
        }
    }

    public int getIDThatDoesntBelongToAnyUniversitySubject()
    {
        int id = 1;
        List< Integer > universitySubjectIDs = cacheProvider.getUniversitySubjects().values().stream()
                .map( UniversitySubject::getId )
                .collect( Collectors.toList() );
        while( true )
        {
            if( !universitySubjectIDs.contains( id ) )
            {
                return id;
            }
            id++;
        }
    }

    public int getIDThatDoesntBelongToAnyStudyGroup()
    {
        int id = 1;
        List< Integer > studyGroupsIDs = cacheProvider.getStudyGroups().values().stream()
                .map( StudyGroup::getGroupId )
                .collect( Collectors.toList() );
        while( true )
        {
            if( !studyGroupsIDs.contains( id ) )
            {
                return id;
            }
            id++;
        }
    }

    public void disallowFutureDatesForDatePicker( DatePicker aDatePicker, int aMinusYears )
    {
        aDatePicker.setDayCellFactory( cell -> new DateCell()
        {
            @Override
            public void updateItem( LocalDate aDate, boolean aEmpty )
            {
                super.updateItem( aDate, aEmpty );
                setDisable( aEmpty || aDate.compareTo( LocalDate.now().minusYears( aMinusYears ) ) > 0 );
            }
        });
    }

    public void setValidAcademicTitles( ComboBox< String > aComboBox )
    {
        aComboBox.getItems().clear();
        aComboBox.getItems().addAll( ModelUtil.validAcademicTitles );
    }

    public void setValidEctsPoints( ComboBox< Integer > aComboBox )
    {
        aComboBox.getItems().clear();
        aComboBox.getItems().addAll( ModelUtil.validEctsPoints );
    }

    public void setValidLecturers( ComboBox< Lecturer > aComboBox )
    {
        aComboBox.getItems().clear();
        aComboBox.getItems().addAll( cacheProvider.getLecturers().values() );
    }

    public void setValidUniversitySubjects( ComboBox< UniversitySubject > aComboBox )
    {
        aComboBox.getItems().clear();
        aComboBox.getItems().addAll( cacheProvider.getUniversitySubjects().values() );
    }

    public void setValidDays( ComboBox< String > aComboBox )
    {
        aComboBox.getItems().clear();
        aComboBox.getItems().addAll( ModelUtil.acceptedDays );
    }

    public void setValidStartTimes( ComboBox< String > aComboBox )
    {
        aComboBox.getItems().clear();
        aComboBox.getItems().addAll( ModelUtil.acceptedStartTimes );
    }
}
