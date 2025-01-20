import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Monitor-klassen
public class Bakeri {
    private ReentrantLock laas = new ReentrantLock();
    private int antallBakvarer = 0;
    private Condition ikkeTom  = laas.newCondition();
    private boolean erFerdigBakt = false;

    // bakerId refererer til bakeren sin id (produsent)
    public void lagBakvare(int bakerId) {
        laas.lock();

        try {
            antallBakvarer++;

            // System.out.println("Baker " + bakerId + " lagde en bakvare");
            ikkeTom.signalAll();
        } finally {
            laas.unlock();
        }
    }

    // kunde = navn på kunden (konsumentene)
    // Returverdi: tallet som indikerer bakvaren som ble spist, hvis -1: enten ferdig bakt eller
    // ble avbrutt
    public int spisBakvare(String kunde) {
        laas.lock();

        try  {
            while (antallBakvarer == 0 && !erFerdigBakt) {
                ikkeTom.await();
            }

            // hvis dette er true: bakeriet er ferdig bakt
            if (erFerdigBakt) {
                System.out.println("Ingen bakvarer "+ kunde + " går hjem :(");
                return -1;
            }

            // På dette stadiet er antallBakvarer > 0
            antallBakvarer--;
            System.out.println(kunde + " spiste en bakvare");
            return antallBakvarer + 1;
        } catch (InterruptedException e) {
            System.out.println("Avbrutt under venting på bakvare..");
            return -1;
        } finally {
            laas.unlock();
        }
    }

    // Signalisere alle ventende konsumenter om at produsentene er ferdig
    public void ferdigBakt() {
        laas.lock();
        try {
            erFerdigBakt = true;
            ikkeTom.signalAll();
        } finally {
            laas.unlock();
        }
    }
}