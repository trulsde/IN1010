import java.util.Scanner;

public class Disarmer implements Runnable {

    Scanner sc = new Scanner(System.in);
    Kode kode;

    public Disarmer(Kode k) {
        kode = k;
    }

    public void run(){
        System.out.println("Skriv: '" + kode.hentKode() + "' for å desarmere");
        String inn = sc.nextLine();
        while (!kode.sammenlignKode(inn)){
            System.out.println("Feil kode!");
            inn = sc.nextLine();
        }
        
        System.out.println("Bombe desarmert!");
    }
}
