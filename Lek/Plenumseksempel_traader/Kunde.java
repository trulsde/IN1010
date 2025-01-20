public class Kunde implements Runnable {
    private String kunde;
    private Bakeri bakeri; 
    private static final int ANTALL_BAKVARER_SOM_SPISES = 20;

    public Kunde(String navn, Bakeri bakeri){
        this.kunde = navn;
        this.bakeri = bakeri;
    }

    @Override 
    public void run(){
        for (int i = 0; i < ANTALL_BAKVARER_SOM_SPISES; i++){
            int returVerdi = bakeri.spisBakvare(kunde);
            if (returVerdi == -1) {
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e){
                System.out.println("Avbrutt under spising...");
            }
        }

        System.out.println(kunde + " er ferdig med å spise");
    }
}