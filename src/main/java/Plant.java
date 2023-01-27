import java.time.LocalDateTime;

public class Plant {
    short wasteType;
    double kg;
    LocalDateTime time;
    String user;

    public Plant(short wasteType, double kg, String currentUser) {
        this.wasteType = wasteType;
        this.kg = kg;
        this.time = LocalDateTime.now();
        this.user = currentUser;
    }

    @Override
    public String toString() {
        return "Plant\n" +
                "wasteType=" + wasteType +
                ", kg=" + kg +
                ", time=" + time +
                ", user='" + user + '\'' +
                "\n";
    }
}
