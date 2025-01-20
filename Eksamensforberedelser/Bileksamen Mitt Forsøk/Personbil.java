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
