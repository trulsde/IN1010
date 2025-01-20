import java.util.Random;

public class Bil3 {
    private String bilmerke;
    private String registreringsnummer;
    private String Reg_number_generator() {
        Random rand = new Random();
        char char1 = (char)(rand.nextInt(26) + 'A');
        char char2 = (char)(rand.nextInt(26) + 'A');
        return String.format("%c%c%05d", char1, char2, rand.nextInt(100000));
    }


    Bil3(String merke) {
        Random rand = new Random();
        bilmerke = merke;
        registreringsnummer = this.Reg_number_generator();
    }
    public String hentBilmerke() {
        return bilmerke;
    }

    public String hentRegnummer() {
        return registreringsnummer;
    }
}
