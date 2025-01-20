public class VanligRom extends Rom {
    final String type;
    final int sengeplasser;
    final int pantryStr;
    final boolean hasPantry;

    public VanligRom (int nr, int str, int sengeplasser, int etg) {
        super(nr, str, etg);
        type = "Vanlig rom";
        this.sengeplasser = sengeplasser;
    }

    @Override
    public String toString() {
        return etg+". Etasje, "+type +", "+sengeplasser+" Sengepl.";
    }

    @Override
    public int hentAntallSengeplasser() {
        return sengeplasser;
    }

    @Override
    public boolean hasPantry() {
        return hasPantry;
    }

    @Override
    public int pantryStr() {
        return pantryStr;
    }
}
