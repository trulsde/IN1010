import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class Kode {
    private Lock laas = new ReentrantLock();
    private String id;

    public boolean sammenlignKode(String s){
        return s.equals(id);
    }

    public void leggTilKode(String s){
        laas.lock();
        try{
            id = s;
        } finally {
            laas.unlock();
        }
    }

    public String hentKode(){
        return id;
    }
}
