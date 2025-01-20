import java.util.ArrayList;

public class Beholder <T> {
    ArrayList<T> elementer;
    int kapasitet;
    int antBiler;
    int antLedigePlasser;

    public Beholder(int plasser) {
        this.kapasitet = plasser;
        elementer = new ArrayList<>();
        antBiler = tellBiler();
        kapasitet = elementer.length;
        antLedigePlasser = kapasitet - antBiler;
    }
    private int tellBiler() {
        int antall = 0;
        for (Bil b : biler) {
            if (b != null) {antall ++;}
        }
        return antall;
    }
    public void parkerBil(Bil bil) {
        for (int i = 0; i < biler.length; i++) {
            if (biler[i] == null) {biler[i] = bil; break;}
        }
        
    }
    public void skrivUtBiler() {
        for (Bil b : biler) {
            if (b != null) {System.out.println(b);}
        }
    }
}