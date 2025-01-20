import java.util.concurrent.CountDownLatch;

public class TraadProgram {
    public static void main(String[] args) {
        int antTraader = 10;
        Monitor monitor = new Monitor();
        CountDownLatch barriere = new CountDownLatch(antTraader);
        
        for (int i=0; i<antTraader; i++) 
            new Thread(new Traad(monitor, barriere)).start();
        
        try {
            barriere.await();
        } catch (InterruptedException e) {}
    }
}
