public class Main {
    public static void main(String [] args)   {
        Teller t1 = new Teller();
        Teller t2 = new Teller();
        t1.tell();
        t2.tellOpp(14);
        t1.tellOpp(24);
        System.out.println("Antall t1: " + t1.hentAntall());
        System.out.println("Antall t2: " + t2.hentAntall());
        System.out.println("Total: " + Teller.hentTotal());
    }
}
