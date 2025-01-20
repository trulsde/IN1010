import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {
    public ReentrantLock sperre = new ReentrantLock();
    private SubsekvensRegister register = new SubsekvensRegister();
    private Condition minstTo = sperre.newCondition();
    public volatile boolean ferdigFletta = false;
    private volatile int flettingerIgjen = 0;

    public void settAntFlettinger(int antFilerMinusEn) {
        flettingerIgjen = antFilerMinusEn;
    }

    public void leggTil(HashMap<String, Subsekvens> nyOversikt) {
        sperre.lock();
        try {            
            register.leggTil(nyOversikt);
            if (register.hentStr() >= 2) {
                minstTo.signal();
            }
        }
        finally {sperre.unlock();}
    }

    public void flettSammen() throws IllegalStateException {
        try {
            sperre.lock();

            if (flettingerIgjen == 0 && register.hentStr() == 1) {
                ferdigFletta = true;
            }
            else if (flettingerIgjen == 0 && register.hentStr() > 1) {
                throw new IllegalStateException("Ingen gjenværende flettinger, men "+register.hentStr()+" elementer i 'register'.");
            }

            while (register.hentStr() < 2) {
                try {
                    if (ferdigFletta) {return;}
                    minstTo.await();
                }
                catch (InterruptedException e) {}                    
            }

            HashMap<String, Subsekvens> ovs1 = register.hentUtOversikt(0);
            HashMap<String, Subsekvens> ovs2 = register.hentUtOversikt(1);

            HashMap<String, Subsekvens> flettaOversikt = SubsekvensRegister.flettSammen(ovs1, ovs2);
            register.erstatt(0, flettaOversikt);
            register.fjern(1);
            flettingerIgjen--;

        } finally {sperre.unlock();}
    }

    public boolean erFerdig() {
        return ferdigFletta;
    }

    public HashMap<String, Subsekvens> hentUtOversikt(Integer indeks) {
        if (indeks == null) {
            return register.hentUtOversikt(null);
        } else {return register.hentUtOversikt(indeks);}
    }

    public Subsekvens hentHyppigste() {
        return register.hentHyppigste();        
    }

    public int hentStr() {
        return register.hentStr();
    }
}
