public class EnkeltRom extends Rom {
    final String type;
    final int sengeplasser;

    public EnkeltRom (int nr, int str, int etg) {
        super(nr, str, etg);
        type = "Enkeltrom";
        sengeplasser = 1;
    }

    @Override
    public String toString() {
        return etg+". Etasje, "+type +", "+sengeplasser+" Sengepl.";
    }

    @Override
    public int hentAntallSengeplasser() {
        return sengeplasser;
    }
}
