import java.util.ArrayList;
import java.util.List;

public class Waste {

    /*
           - Waste Paper and Cardboard
           - Plastic Recycling
           - Metal Recycling
           - WEEE Recycling (The Waste Electrical and Electronic Equipment)
           - Glass Recycling
           - Clothing and Textile

     */

    private final short codeOfWaste;
    private final String nameOfWaste;
    private final double discount;

    public Waste(String codeOfWaste, String nameOfWaste, double discount) {
        this.codeOfWaste = Short.parseShort(codeOfWaste);
        this.nameOfWaste = nameOfWaste;
        this.discount = discount;
    }

    public String getCodeOfWaste() {
        return String.valueOf(codeOfWaste);
    }

    public String getNameOfWaste() {
        return nameOfWaste;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "Waste{" +
                "codeOfWaste='" + codeOfWaste + '\'' +
                ", nameOfWaste='" + nameOfWaste + '\'' +
                ", discount=" + discount +
                '}';
    }





}
