public class Bakeriprogram {
    public static void main(String[] args) {
        Bakeri monitor = new Bakeri();
        int antallBakere = 1;
        Thread[] bakerTraader = new Thread[antallBakere]; 

        for (int i = 0; i < antallBakere; i++) {
            bakerTraader[i] = new Thread(new Baker(i, monitor));
            bakerTraader[i].start();
        }

        Thread[] kundeTraader = {
            new Thread(new Kunde("Ahmed", monitor)),
            new Thread(new Kunde("Annika", monitor)),
            new Thread(new Kunde("Bushra", monitor)),
            new Thread(new Kunde("Samuek", monitor))
        };

        for (Thread kunde : kundeTraader) {
            kunde.start();
        }

        for (Thread baker : bakerTraader) {
            try {
                baker.join();
            } catch(InterruptedException e) {
                System.out.println("avbrutt under joining av bakere");
            }
        }

        System.out.println("Alle bakere er ferdig..");
        monitor.ferdigBakt();


        for (Thread kunde : kundeTraader) {
            try {
                kunde.join();
            } catch(InterruptedException e) {
                System.out.println("avbrutt under joining av kunder");
            }
        }

        System.out.println("Alle kunder er ferdig med å spise, bakeriet stenger!");
    }
}