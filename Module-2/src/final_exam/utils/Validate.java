package final_exam.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Pattern pattern;
    private static Matcher matcher;
    public static final String NAME_REGEX = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$";
    public static final String DATE_REGEX = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";

    public static boolean nameRegex(String name)
    {
        pattern = Pattern.compile(NAME_REGEX);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean dateRegex(String date)
    {
        pattern = Pattern.compile(DATE_REGEX);
        matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
