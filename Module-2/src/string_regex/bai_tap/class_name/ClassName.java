package string_regex.bai_tap.class_name;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassName {
    public static Pattern pattern;
    public static Matcher matcher;
    public static final String CLASS_NAME_REGEX = "^[A-C-P]+\\d{4}+[G-H-I-K-L-M]$";

    public ClassName(){
        pattern = Pattern.compile(CLASS_NAME_REGEX);
    }

    public boolean validate(String regex){
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
