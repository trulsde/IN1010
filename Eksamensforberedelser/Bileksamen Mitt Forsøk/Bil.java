public class Bil {
    final String NUMMER;
    final int PRIS;
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

    @Override
    public String toString() {
        return "Registreringsnummer: " + NUMMER + ", Pris: " + PRIS;
    }
}
