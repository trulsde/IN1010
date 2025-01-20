public class Main {
    public static void main(String[] args) {
        Runnable task = new Traad();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();

        Kode kode = new Kode();
        Thread lunte = new Thread(new Bombe(kode));
        Thread def = new Thread(new Disarmer(kode));
        lunte.start();
        def.start();

        try{
            def.join();
        } catch (InterruptedException e){}
        lunte.interrupt();
    }
    
}
