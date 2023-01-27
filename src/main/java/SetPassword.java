import java.util.Random;

public class SetPassword {


    String password;

    public SetPassword(String name) {

        Random random = new Random();
        String symbols = "*_+-.#";
        String digit = String.valueOf((char) (random.nextInt(10) + 48));
        String symbol = String.valueOf(symbols.charAt((int) (Math.random() * symbols.length())));
        password = name.substring(0, 2).toUpperCase() + name.substring(0, 2).toLowerCase() + digit + symbol;


    }


}
