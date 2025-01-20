import java.util.Scanner;

public class Bombe implements Runnable {

    int i = 10;
    Kode kode;

    public Bombe(Kode kode){
        System.out.println("Skriv inn desarmeringskode: ");
        this.kode = kode;
        kode.leggTilKode(new Scanner(System.in).nextLine());
    }

    public void run() {

        while (i>0){
            System.out.println(i);
            i--;
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e) {return;}
        }
    System.out.println("BANG");
    System.exit(0);
    }
    
    
}
