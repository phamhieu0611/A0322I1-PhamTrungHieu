package string_regex.bai_tap.phone_number;

public class ValidatePhoneNumberTest {
    public static ValidatePhoneNumber validatePhoneNumber;
    public static final String[] validPhoneNumber = new String[] {"84-0123456789", "18-0986325174", "88-0643122579"};
    public static final String[] invalidPhoneNumber = new String[] {"a8-0123456789", "$@-0986325174", "88-0s43122579"};

    public static void main(String[] args) {
        validatePhoneNumber = new ValidatePhoneNumber();
        for (String phoneNumber : validPhoneNumber){
            boolean isvalid = validatePhoneNumber.validate(phoneNumber);
            System.out.println("Phone number is "+phoneNumber+" is valid: "+isvalid);
        }
        for (String phoneNumber : invalidPhoneNumber){
            boolean isvalid = validatePhoneNumber.validate(phoneNumber);
            System.out.println("Phone number is "+phoneNumber+" is valid: "+isvalid);
        }
    }
}
