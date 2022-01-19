package validation;

public class RegexProvider
{
    private RegexProvider()
    {

    }

    public static String EMAIL_REGEX = ".*@.*\\..*";

    public static String NAME_REGEX = "[a-zA-Z ]+";

    public static String PESEL_REGEX = "[0-9]{11}";

    public static String PHONE_NUMBER_REGEX = "[1-9][0-9]{8}";

    public static String ADDRESS_REGEX = "[A-Za-z0-9 ]{5}.*";

    public static String DUTY_REGEX = "[A-Za-z0-9 ]+";
}
