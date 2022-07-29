package case_study.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Pattern pattern;
    private static Matcher matcher;
    public static final String ID_SERVICE_REGEX = "SV.[VL | HO | RO].-*[0-9]{4}";
    public static final String NAME_FACILITY_REGEX = "[A-Z]{1}[a-z]{1,50}";
    public static final String ROOM_STANDART = "[A-Z]{1}[a-z]{1,50}";
    public static final String EMAIL_REGEX = "^\\w+@\\w+(\\.+\\w+){1,2}$";
    public static final String ID_REGEX = "[1-9][0-9]{3}";
    public static final String ONE_REGEX = "[1-9]";
    public static final String ID_CARD_REGEX = "([0-9]{9}|[0-9]{14})";
    public static final String PHONE_NUMBER_REGEX = "(09|03)[0-9]{8}";
    public static final String DATE_REGEX = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
    public static final String NAME_REGEX = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$";


    public static boolean checkMaxPerson(int thePeoples){
        if (thePeoples > 0 && thePeoples < 20){
            return true;
        }
        return false;
    }

    public static boolean checkPoolArea(double poolArea){
        if (poolArea > 30.0){
            return true;
        }
        return false;
    }

    public static boolean checkNumberFloors(int floors){
        if (floors > 0){
            return true;
        }
        return false;
    }

    public static boolean checkRentPrice(double rentPrice){
        if (rentPrice > 0.0){
            return true;
        }
        return false;
    }
    public static boolean checkEmail(String email)
    {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean checkRoomStandart(String roomStandart){
        pattern = Pattern.compile(ROOM_STANDART);
        matcher = pattern.matcher(roomStandart);
        return matcher.matches();
    }

    public static boolean checkIDFacility(String idFacility){
        pattern = Pattern.compile(ID_SERVICE_REGEX);
        matcher = pattern.matcher(idFacility);
        return matcher.matches();
    }

    public static boolean checkNameFacility(String nameFacility){
        pattern = Pattern.compile(NAME_FACILITY_REGEX);
        matcher = pattern.matcher(nameFacility);
        return matcher.matches();
    }

    public static boolean checkId(String id){
        pattern = Pattern.compile(ID_REGEX);
        matcher = pattern.matcher(id);
        return matcher.matches();
    }

    public static boolean checkOneNumber(String index)
    {
        pattern = Pattern.compile(ONE_REGEX);
        matcher = pattern.matcher(index);
        return matcher.matches();
    }

    public static boolean idCard(String idCard)
    {
        pattern = Pattern.compile(ID_CARD_REGEX);
        matcher = pattern.matcher(idCard);
        return matcher.matches();
    }

    public static boolean phoneNumber(String phoneNumber)
    {
        pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

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
