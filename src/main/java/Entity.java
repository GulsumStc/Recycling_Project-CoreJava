import java.util.Scanner;

public class Entity {

    public static void start() {


        System.out.println("   ========= Welcome To  The  Recycling  System =========  ");
        System.out.println("Discount is applied on the water bill in proportion to the amount of waste that sent.");
        System.out.println();
        intro();

    }

    public static void intro() {
        Register service = new Register();
        Login login = new Login();
        Scanner scan = new Scanner(System.in);
        boolean isValid;
        do {
            isValid = true;
            System.out.println("Enter your choice\n1-Sign up\n2-Log in\n3-Exit");
            String select = scan.next();

            if (select.equals("1")) {
                service.register();
            } else if (select.equals("2")) {
                login.login();
            } else if (select.equals("3")) {
                break;
            } else {
                System.out.println("Invalid choice. Try it again ");
                isValid = false;
            }
        } while (!isValid);

    }

    public static void options() {
        Service srvc = new Service();

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a process");
        String select;
        boolean isValid = false;

        do {
            isValid = true;
            System.out.println("1 - Enter amount of Waste\n2 - Total amount of waste sent for recycling\n" +
                    "3 - Amounts of waste and  discount on this month\n0 - Sıgn Out");
            select = scan.next();
            switch (select) {
                case "1":
                    srvc.showWasteMenu();
                    break;
                case "2":
                    srvc.displayWasteSent();
                    break;
                case "3":
                    srvc.displayTotalWasteMonthly();
                    break;
                case "0":
                    System.out.println("You have been sıng out successfully");
                    intro();
                    break;
                default:
                    isValid = false;
                    System.out.println("Invalid choice. Try it again ");
            }
        } while (!isValid);

    }

}



