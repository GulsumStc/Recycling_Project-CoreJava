import java.util.ArrayList;
import java.util.List;

public class Users {
    private String nameSurname;
    private  String userId;
    private  String addresses;
    private String identityNo;
    private  String phoneNums;
    private String emails;
    private  String passwords;

    public Users(String nameSurname, String userId, String addresses, String identityNo, String phoneNums, String emails, String passwords) {
        this.nameSurname = nameSurname;
        this.userId = userId;
        this.addresses = addresses;
        this.identityNo = identityNo;
        this.phoneNums = phoneNums;
        this.emails = emails;
        this.passwords = passwords;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public String getUserId() {
        return userId;
    }

    public String getAddresses() {
        return addresses;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public String getPhoneNums() {
        return phoneNums;
    }

    public String getEmails() {
        return emails;
    }

    public String getPasswords() {
        return passwords;
    }
}
