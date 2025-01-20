import java.util.Iterator;

public class TestArrayliste<T> {
    public static void main(String[] args) {
        Liste<String> lx = new Arrayliste<>();
        // Sett inn 13 elementer:
        for (int i = 0; i < 13; i++) {
            lx.add("A" + i);
        }
        // sjekk antall
        System.out.println("Listen har " + lx.size() + " elementer");
        // Marker element nr 10:
        lx.set(10, lx.get(10) + "*");
        // Fjern første element
        lx.remove(0);
        System.out.println("Fjernet element 0");
        // Skriv ut listen
        for (int i = 0; i < lx.size(); i++) {
            System.out.println("Element " + i + ": " + lx.get(i));
        }
        // Lag en feil - og håndter den
        try {
            lx.remove(999);
        } catch (UlovligListeIndeks u) {
            System.out.println("Feil: " + u.getMessage()); }
        System.out.println("Kommer vi hit?");

        for (String elem: lx) {
            System.out.println(elem);
        }

        Liste<String> ly = new Arrayliste<>();
        for (String elem: ly) {
            System.out.println(elem);
        }

        System.out.println("Tester eksplisitte kall på iterator:");
        Iterator<String> iter = lx.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
