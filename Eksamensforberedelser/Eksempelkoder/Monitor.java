import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {
    Lock laas = new ReentrantLock();
    // Andre instansvariabler

    public Monitor() {
        // Konstruktør
    }

    public void etEllerAnnet() {
        laas.lock();
        try {
            // Å gjennomføre en handling
            System.out.println("Handling");
        } finally {
            laas.unlock();
        }
    }
}
