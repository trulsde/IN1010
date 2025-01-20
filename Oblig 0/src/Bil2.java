import java.util.Random;

public class Bil2 {
    private int bilnummer;
    private String bilmerke;

    private String Reg_number_generator() {
        Random rand = new Random();
        char char1 = (char)(rand.nextInt(26) + 'A');
        char char2 = (char)(rand.nextInt(26) + 'A');
        return String.format("%c%c%05d", char1, char2, rand.nextInt(100000));
    }


    Bil2(String merke) {
        Random rand = new Random();
        bilmerke = merke;
    }
    public String getDetails() {
        return "Registreringsnummer: " + this.Reg_number_generator() +
                "\nBilmerke: " + bilmerke;
    }

}
