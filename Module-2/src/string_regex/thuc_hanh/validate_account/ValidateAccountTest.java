package string_regex.thuc_hanh.validate_account;

public class ValidateAccountTest {
    private static ValidateAccount validateAccount;
    public static final String[] validAccount = new String[] { "123abc_", "_abc123", "______", "123456","abcdefgh" };
    public static final String[] invalidAccount = new String[] { ".@", "12345", "1234_", "abcde" };

    public static void main(String[] args) {
        validateAccount = new ValidateAccount();
        for (String accont : validAccount){
            boolean isvalid = validateAccount.validate(accont);
            System.out.println("Account is "+accont+" is valid: "+isvalid);
        }
        for (String accont : invalidAccount){
            boolean isvalid = validateAccount.validate(accont);
            System.out.println("Account is "+accont+" is valid: "+isvalid);
        }
    }
}
