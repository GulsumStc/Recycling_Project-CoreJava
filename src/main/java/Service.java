import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {

    /*
             - Enter amount of Waste
               - enter code of the waste
               - amounts of the waste
             - total amount of waste sent for recycling
               - Waste Paper and Cardboard - amount
               - Plastic Recycling
               - Metal Recycling
               - WEEE Recycling (The Waste Electrical and Electronic Equipment)
               - Glass Recycling
               - Clothing and Textile
             - amounts of waste and  discount on this month
               - display amount of waste  and discount which is entered
               - total discount

     */

    List<Waste> wasteList = new ArrayList<>();
    static List<Plant> plant = new ArrayList<>();

    public Service(){
        Waste waste1 = new Waste("1", "Paper and Cardboard", 5.10);
        Waste waste2 = new Waste("2", "Plastic", 10.20);
        Waste waste3 = new Waste("3", "Metal", 30.25);
        Waste waste4 = new Waste("4", "Electronic Equipment", 100.30);
        Waste waste5 = new Waste("5", "Glass", 15.10);
        Waste waste6 = new Waste("6", "Clothing and Textile", 20.15);
        wasteList.add(waste1);
        wasteList.add(waste2);
        wasteList.add(waste3);
        wasteList.add(waste4);
        wasteList.add(waste5);
        wasteList.add(waste6);
    }


    public void showWasteMenu() {

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        System.out.println("      *****Waste List*****      ");
        System.out.printf("%-3s    %-20s     %-4s\n", "Code", "Type of Waste", "Rate of Discount");
        System.out.printf("%-3s    %-20s     %-4s\n", "----", "-------------", "----------------");
        for (Waste waste : this.wasteList) {
            System.out.printf("%-3s    %-25s   %4s₺\n", waste.getCodeOfWaste(), waste.getNameOfWaste(), decimalFormat.format(waste.getDiscount()));

        }
        enterWaste();
    }

    public void enterWaste() {
        Scanner scan = new Scanner(System.in);
        Service srvc = new Service();

        String select;
        String kg;

        boolean a = false;
        do {
            System.out.print("Enter Code of Waste:");
            select = scan.next();

            //**** method ta yap
            for (Waste w : srvc.wasteList) {
                if (select.equals(w.getCodeOfWaste())) {
                    a = false;
                    break;
                } else {
                    a = true;
                }
            }
            if (a) System.out.println("Invalid Code of Waste.");
        } while (a);

        boolean isCorrect;
        do {
            System.out.println("How many kilograms of waste you are going to send");
            kg = scan.next();
            isCorrect = kg.isEmpty() || kg.replaceAll("\\d", "").length() != 0;
            if (isCorrect) {
                System.out.println("The value of kg can not be empty or contain value except digit");
            }
        } while (isCorrect);

        Plant data = new Plant(Short.parseShort(select), Double.parseDouble(kg), Login.currentUser);
        plant.add(data);

        System.out.print("If you want to enter another waste enter 'Y', otherwise enter any key.");

        if (scan.next().equalsIgnoreCase("y")) {
            showWasteMenu();
        } else Entity.options();
    }

    void displayWasteSent() {
        DecimalFormat df = new DecimalFormat("0.00");
        double kg = 0;
        double discount = 0;
        double total = 0;
        System.out.printf("%-20s     %-3s    %-4s\n", "Type of Waste", "Amount", "Discount");
        System.out.printf("%-20s     %-3s    %-4s\n", "-------------", "------", "--------");
        for (int i = 0; i < wasteList.size(); i++) {
            for (Plant plant1 : plant) {
                if (plant1.user.equals(Login.currentUser) && wasteList.get(i).getCodeOfWaste().equals(String.valueOf(plant1.wasteType))) {
                    kg += plant1.kg;
                    discount += wasteList.get(i).getDiscount() * plant1.kg;
                    total += discount;
                }
            }
            System.out.printf("%-21s     %-6s    %4s₺\n", wasteList.get(i).getNameOfWaste(), kg, df.format(discount));
            kg = 0;
            discount = 0;
        }
        System.out.println("Total Discount: " + df.format(total) + " ₺");

        Entity.options();
    }

    void displayTotalWasteMonthly() {
        DecimalFormat df = new DecimalFormat("0.00");
        double kg = 0;
        double discount = 0;
        double total = 0;
        boolean time = false;
        boolean userWaste = false;
        System.out.println("-----------Amount of waste which is sent in this month-----------");
        System.out.printf("%-20s     %-3s    %-4s  %10s\n", "Type of Waste", "Amount", "Discount","   Date");
        System.out.printf("%-20s     %-3s    %-4s  %10s\n", "-------------", "------", "--------","   --------");
        for (int i = 0; i < wasteList.size(); i++) {
            for (Plant plant1 : plant) {
                time = plant1.time.getMonth().equals(LocalDate.now().getMonth()) && plant1.time.getYear() == LocalDate.now().getYear();
                userWaste = plant1.user.equals(Login.currentUser) && wasteList.get(i).getCodeOfWaste().equals(String.valueOf(plant1.wasteType));
                if (time && userWaste) {
                    discount = wasteList.get(i).getDiscount() * plant1.kg;
                    System.out.printf("%-21s     %-6s    %6s     %-11s\n", wasteList.get(i).getNameOfWaste(), plant1.kg, df.format(discount),plant1.time.format(DateTimeFormatter.ISO_DATE));
                    total += discount;
                }
            }
        }
        System.out.println("Total Discount: " + df.format(total) + " ₺");
        System.out.println("--------------------------------------------");
        System.out.println("Total discount will be applied on Water Bill");
        System.out.println("--------------------------------------------");
        Entity.options();
    }
}
