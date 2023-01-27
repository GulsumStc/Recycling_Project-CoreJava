import javax.swing.plaf.basic.BasicTreeUI;
import java.util.Scanner;

public class Login {

    static String currentUser;

    public void login() {

        Scanner scan = new Scanner(System.in);
        //Register register = new Register();

        String enter;
        String psw;
        boolean isCorrect;
        do {
            isCorrect = true;
            System.out.println("Enter UserId or Identity No");
            enter = scan.next();
            System.out.println("Enter Password");
            psw = scan.next();
            if (!Register.findUserBy(enter,psw)) {
                    System.out.println("Invalıd userId or Identıty No");
                    isCorrect = false;
            }
        } while (!isCorrect);

        System.out.println("you have been successfully logged in");


        Entity.options();


    }



}
