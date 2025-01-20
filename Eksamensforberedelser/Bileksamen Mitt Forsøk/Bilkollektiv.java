import java.util.Scanner;

public class Bil implements Comparable<Bil> {
    final String NUMMER;
    final int PRIS;
    boolean elektrisk = false;
    Bil neste, forrige;

    public Bil(String nr, int pris) {
        NUMMER = nr;
        PRIS = pris;
    }

    public void settNeste(Bil b) {
        neste = b;
    }

    public void settForrige(Bil b) {
        forrige = b;
    }

    public boolean erElektrisk() {
        return elektrisk;
    }

    public Bil finnBilR(Dialog d, boolean kunElektrisk) {
        if (! kunElektrisk && d.svarJaEllerNei(this.toString())) return this;
        if (neste != null) return neste.finnBilR(d, kunElektrisk);
        return null;
    }

    @Override
    public String toString() {
        return "Registreringsnummer: " + NUMMER + ", Pris: " + PRIS;
    }

    @Override
    public int compareTo(Bil b) { // <= 0: b er dyrere eller like billig, > 0: b er 
        return PRIS - b.PRIS;
    }
}

public class Personbil extends Bil {
    final int ANT_PASSASJERER;

    public Personbil(String nr, int pris, int seter) {
        super(nr, pris);
        ANT_PASSASJERER = seter;
    }

    @Override
    public String toString() {
        return super.toString() + ", Antall seter: " + ANT_PASSASJERER;
    }
}

public class Varebil extends Bil {
    final int LASTEVOLUM;

    public Varebil(String nr, int pris, int kapasitet) {
        super(nr, pris);
        LASTEVOLUM = kapasitet;
    }

    @Override
    public String toString() {
        return super.toString() + ", Lastekapasitet: " + LASTEVOLUM + "m^3";
    }

    @Override
    public Bil finnBilR(Dialog d, boolean kunElektrisk) {
        if (kunElektrisk && d.svarJaEllerNei(toString())) return this;
        if (neste != null) return neste.finnBilR(d, kunElektrisk);
        return null;
    }
}

public interface Elektrisk {
    int hentBatteriStr();
}

public class ElBil  extends Personbil implements Elektrisk {
    final int BATTERI_STR;

    public ElBil(String nr, int pris, int seter, int batteriStr) {
        super(nr, pris, seter);
        BATTERI_STR = batteriStr;
        elektrisk = true;
    }

    @Override
    public int hentBatteriStr() {
        return BATTERI_STR;
    }
}

public class ElVarebil  extends Varebil implements Elektrisk {
    final int BATTERI_STR;

    public ElVarebil(String nr, int pris, int kapasitet, int batteriStr) {
        super(nr, pris, kapasitet);
        BATTERI_STR = batteriStr;
        elektrisk = true;
    }

    @Override
    public int hentBatteriStr() {
        return BATTERI_STR;
    }
}

public interface Dialog {
    boolean svarJaEllerNei(String spm);
}

public class TastaturDialog implements Dialog {
    Scanner brukerInput = new Scanner(System.in);

    public boolean svarJaEllerNei(String spm) {
        System.out.println(spm);
        System.out.println("Svar 'j' for ja og 'n' for nei");
        String svar = brukerInput.nextLine();
        if (svar.equals("j")) return true;
        else if (svar.equals("n")) return false;
    }
}

public class Bilkollektiv {
    final int ANTALL_BILER; // Valgte et mer deskriptivt navn enn AB
    Bil[] alleBilene;
    Bil start, slutt;

    public Bilkollektiv(int antall) {
        ANTALL_BILER = antall;
        alleBilene = new Bil[ANTALL_BILER];
    }

    public void lagBilPris() {
        for (Bil b : alleBilene) {
            if (start == null && slutt == null) start = slutt = b; // Denne setter bare b inn hvis lista er tom
            if (b.compareTo(slutt) > 0) { // Denne setter b inn til slutt, dersom b er dyrere enn 'slutt' (dyreste bil)
                slutt.neste = b;
                b.forrige = slutt;
                slutt = b;
            }

            Bil peker = start;
            while (peker != null) {
                if (b.compareTo(peker) <= 0) { // Dette setter b inn foran peker, dersom peker er dyrere eller like dyr som b
                    b.neste = peker;
                    b.forrige = peker.forrige;
                    peker.forrige.neste = b;
                    peker.forrige = b;
                }
                peker = peker.neste;
            }
        }
    }

    public void fjernBil(Bil b) { // Kalte den fjernBil istedenfor taUtBil
        if (b.equals(start) && b.equals(slutt)) {
            start = slutt = null; 
        } else if (b.equals(start)) { // Veit ikke heelt om dette blir helt riktig, men satser på det..
            start.neste.forrige = null;
            start = start.neste;
            b.neste = null;
        } else if (b.equals(slutt)) {
            slutt.forrige.neste = null;
            slutt = slutt.forrige;
            b.forrige = null;
        } else {
            Bil peker = start;
            while (peker != null) {
                if (b.equals(peker)) { // Hvis b finnes i lenkelista, så fjernes denne bilen
                    peker.neste.forrige = peker.forrige;
                    peker.forrige.neste = peker.neste;
                    peker.forrige = peker.neste = null;
                }
                peker = peker.neste;
            }
        }
    }

    public Bil velgBil(Dialog d) {
        boolean elBil = false;
        if (d.svarJaEllerNei("Vil du kun låne El-bil?")) elBil = true;
        Bil peker = start;
        while (peker != null) {
            if (elBil && !peker.elektrisk) peker = peker.neste;
            System.out.println(peker);
            if (d.svarJaEllerNei("Vil du låne denne bilen?")) break;
            else peker = peker.neste;
        }
        if (peker == null) System.out.println("Ingen flere biler å velge mellom");
        else System.out.println("Du har valgt denen bilen: "+peker);
        fjernBil(peker);
        return peker;
    }

    public Bil velgBilR(Dialog d) {
        boolean elBil = d.svarJaEllerNei("Vil du kun ha El-bil?");
        Bil valgtBil = start.finnBilR(d, elBil);
        if (valgtBil != null) fjernBil(valgtBil);
        return valgtBil;
    }
}