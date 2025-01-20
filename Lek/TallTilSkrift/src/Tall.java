import java.util.ArrayList;

public class Tall {
    private int tall_som_int;
    private String tall_som_string;
    private ArrayList<String> sifferliste;

    Tall(int tall) {
        tall_som_int = tall;
        tall_som_string = Integer.toString(tall);
    }

    public String getTall() {
        return this.SifferEn();
    }

    private String SifferEn() {
        String tekst = null;
        switch (tall_som_int) {
            case 1 -> tekst = "én";
            case 2 -> tekst = "to";
            case 3 -> tekst = "tre";
            case 4 -> tekst = "fire";
            case 5 -> tekst = "fem";
            case 6 -> tekst = "seks";
            case 7 -> tekst = "sju";
            case 8 -> tekst = "åtte";
            case 9 -> tekst = "ni";
        }
        return tekst;
    }
}
