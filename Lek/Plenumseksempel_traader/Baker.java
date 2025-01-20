public class Baker implements Runnable{
    private int bakerId;
    private Bakeri bakeri; 
    private static final int ANTALL_BAKVARER_SOM_LAGES = 50;

    public Baker(int bakerid, Bakeri bakeri){
        this.bakerId = bakerid;
        this.bakeri = bakeri;
    }

    @Override
    public void run(){
        for (int i = 0; i < ANTALL_BAKVARER_SOM_LAGES; i++) {
            bakeri.lagBakvare(bakerId);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Avbrutt under baking...");
            }
        }
        System.out.println("Baker " + bakerId + " er ferdig med å bake");

    }   
}
