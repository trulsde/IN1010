import java.util.concurrent.CountDownLatch;

public class Traad implements Runnable {
    Monitor monitor;
    CountDownLatch barriere;
    // Andre instansvariabler

    public Traad(Monitor m, CountDownLatch c) {
        monitor = m; barriere = c;
    }

    @Override
    public void run() {
        // Gjøre et eller annet
        barriere.countDown();
    }
}
