public class Prosess implements Runnable {
    private int pId;

    public Prosess(int pId) {
        this.pId = pId;
    }

    @Override
    public void run(){
        System.out.println("Prosess " + pId + " kjører");
    }
}