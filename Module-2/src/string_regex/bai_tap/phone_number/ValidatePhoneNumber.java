package string_regex.bai_tap.phone_number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    public static Pattern pattern;
    public static Matcher matcher;
    public static final String PHONE_NUMBER_REGEX = "^\\d{2}+(-)+0+\\d{9}$";

    public ValidatePhoneNumber(){
        pattern = Pattern.compile(PHONE_NUMBER_REGEX);
    }

    public boolean validate(String regex){
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
