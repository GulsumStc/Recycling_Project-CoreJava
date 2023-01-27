import java.util.Map;

public class SetId {

    String Id;

    public SetId(String nameSur, String identityNo) {

        if (nameSur.split(" ").length==2) {
            Id = (nameSur.substring(0, 2) + nameSur.split(" ")[1].substring(0, 2) + identityNo.substring(0,2)).toUpperCase();
        }else {
            int a = nameSur.split(" ").length-1;
            Id = (nameSur.substring(0, 2) + nameSur.split(" ")[a].substring(0, 2) + identityNo.substring(0,2)).toUpperCase();
        }
    }
}
