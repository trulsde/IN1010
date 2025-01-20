import java.util.HashMap;

public class LeseTrad implements Runnable {
    private String filnavn;
    Monitor monitor;
    int filnummer;

    public LeseTrad(String filnavn, Monitor monitor, int filnummer) {
        this.filnavn = filnavn;
        this.monitor = monitor;
        this.filnummer = filnummer;
    }
    
    public void run() {
        HashMap<String, Subsekvens> ovs = SubsekvensRegister.lagOversikt(filnavn);
        
        monitor.sperre.lock();
        try {
            monitor.leggTil(ovs);
        } finally {
            monitor.sperre.unlock();
        }
        
        
    }
}
