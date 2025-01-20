import java.util.ArrayList;

public class Hovedprogram {
    public static void main(String[] args){
        ArrayList<Thread> traader = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread prosess = new Thread(new Prosess(i+1));
            traader.add(prosess);
            prosess.start();
        }

        for (Thread traad : traader){
            try {
                traad.join();
            } catch (InterruptedException e) {
                System.out.println("Avbrutt traad ...");
            }
        }

        System.out.println("Ferdig!");

    }
}