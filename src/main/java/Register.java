import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Register {

    //i- get name,surname, identity No, Address, Phone Number, E-mail(not necessary) from user

    static List<Users> userList = new ArrayList<>();

    public void register() {

        Scanner scan = new Scanner(System.in);
        boolean isVaild;
        String namesur;
        do {
            isVaild = true;
            System.out.println("Enter your name and surname");
            namesur = scan.nextLine().trim();
            boolean space = namesur.contains(" ");
            boolean firstName = namesur.split(" ")[0].length() > 2;
            boolean lastName = namesur.split(" ")[namesur.split(" ").length - 1].length() > 2;
            if (!space) {
                System.out.println("You must enter name and surname");
                isVaild = false;
            }
            if (!firstName || !lastName) {
                System.out.println("Your name and surname have to be more than 2 character");
                isVaild = false;
            }
        } while (!isVaild);

        String identity;

        do {
            isVaild = true;
            System.out.println("Enter your Identity Number: ");
            identity = scan.nextLine().trim();
            boolean space = identity.contains(" ");
            boolean length = identity.length() == 11;
            boolean isDigit = identity.replaceAll("\\d", "").length() == 0;

            for (Users users: userList){
                if (users.getIdentityNo().equals(identity)){
                    isVaild = false;
                    System.out.println("This Identity number has been used before");
                }
            }
            if (space || !length || !isDigit) {
                System.out.println("Invaild Number ");
                isVaild = false;
            }

        } while (!isVaild);

        String address = address();
        System.out.println(address);

        String phoneNum;
        do {
            isVaild = true;
            System.out.println("Enter your Phone Number: ");
            phoneNum = scan.nextLine().trim();
            boolean space = phoneNum.contains(" ");
            boolean length = phoneNum.length() == 11;
            boolean isDigit = phoneNum.replaceAll("\\d", "").length() == 0;

            if (space || !length || !isDigit) {
                System.out.println("Invaild Number.. Enter it again ");
                isVaild = false;
            }
        } while (!isVaild);

        String email;
        do {

            System.out.println("Enter your Email address: ");
            email = scan.nextLine().trim();
            isVaild = isValidEmail(email);

        } while (!isVaild);

        SetPassword setpsw = new SetPassword(namesur);
        System.out.println("Password: " + setpsw.password);
        System.out.println("If you want to change your password enter 1\n" +
                "if not enter any key");
        String changepsw = scan.next();
        String password = setpsw.password;
        if (changepsw.equals("1")) {
            do {
                System.out.println("Enter your Password: ");
                password = scan.next().trim();
                isVaild = isValidPassword(password);

            } while (!isVaild);

        }

        SetId id = new SetId(namesur, identity);
        id.Id = isUniqueId(id.Id);
        Users user = new Users(namesur, id.Id, address, identity, phoneNum, email, password);
        userList.add(user);

        System.out.printf("Name - Surname: " + namesur + "\nUser Id:        " + id.Id + "\nIdentity No:    " + identity +
         "\nAddress:        " + address + "\nPhone Number:   " + phoneNum + "\nE-mail:         " + email + "\nPassword:       " + password);

        System.out.println();
        Entity.intro();

    }

    String isUniqueId(String id) {

        for (Users users : userList) {
            if (users.getUserId().equals(id)) {
                id = id.substring(0, 4) + (int) (Math.random() * 10) + (int) (Math.random() * 10);
                for (Users users1 : userList) {
                    if (users1.getUserId().equals(id)) isUniqueId(id);
                    else return id;
                }
            }
        }
        return id;
    }

    String address() {
        Scanner scan = new Scanner(System.in);
        String address = "";
        String town;
        String neighborhood;
        String street;
        String apartmentNo;

        boolean length;
        do {
            System.out.println("Enter your town:");
            town = scan.nextLine();
            length = town.length() > 0;
        } while (!length);
        do {
            System.out.println("Enter your neighborhood:");
            neighborhood = scan.nextLine();
            length = neighborhood.length() > 0;
        } while (!length);
        do {
            System.out.println("Enter your street:");
            street = scan.nextLine();
            length = street.length() > 0;
        } while (!length);
        do {
            System.out.println("Enter your apartment no:");
            apartmentNo = scan.nextLine();
            length = apartmentNo.length() > 0;
        } while (!length);

        address += "Town: " + town + " Neighborhood: " + neighborhood + " Street: " + street + " Apartment No: " + apartmentNo;

        return address;

    }

    boolean isValidEmail(String email) {

        boolean space = email.contains(" ");
        boolean containsAt = email.replaceAll("[^@]", "").length() == 1;
        boolean firstPart = email.split("@")[0].replaceAll("[A-Za-z0-9-._]", "").length() == 0;
        String[] arr = email.split("@");
        boolean secondPart = arr[1].equals("gmail.com") || arr[1].equals("hotmail.com") || arr[1].equals("yahoo.com") || arr[1].equals("yandex.com");
        if (space) {
            System.out.println("Email address must not contain a space");
        }
        if (!containsAt) {
            System.out.println("Your e-mail address must contain only one '@' symbol.");
        }
        if (!firstPart) {
            System.out.println("Your email address must contain only: 'A-Za-z0-9-._' ");
        }
        if (!secondPart) {
            System.out.println("Your email address must be gmail.com, hotmail.com, yahoo.com or yandex.com ");
        }

        return !space && containsAt && firstPart && secondPart;
    }

    boolean isValidPassword(String password) {

        boolean space = password.contains(" ");
        boolean length = password.length() >= 6;
        boolean lowerCase = password.replaceAll("[^a-z]", "").length() > 0;
        boolean upperCase = password.replaceAll("[^A-Z]", "").length() > 0;
        boolean digit = password.replaceAll("[^0-9]", "").length() > 0;
        boolean symbol = password.replaceAll("[^\\p{Punct}]", "").length() > 0;

        if (space) {
            System.out.println("Password must not contain a space");
        }
        if (!length) {
            System.out.println("Password's length  must be at least 6 characters");
        }
        if (!lowerCase) {
            System.out.println("Password must  contain lowercase ");
        }
        if (!upperCase) {
            System.out.println("Password must  contain uppercase");
        }
        if (!digit) {
            System.out.println("Password must  contain digit");
        }
        if (!symbol) {
            System.out.println("Password must  contain symbol ");
        }

        return !space && length && lowerCase && upperCase && digit && symbol;


    }


    public static boolean findUserBy(String id, String psw) {

        for (Users users : userList) {

            if (users.getUserId().equals(id) || users.getIdentityNo().equals(id)) {
                if (users.getPasswords().equals(psw)) {
                    Login.currentUser = users.getUserId();
                    return true;
                }
            }
        }
        return false;
    }
}
