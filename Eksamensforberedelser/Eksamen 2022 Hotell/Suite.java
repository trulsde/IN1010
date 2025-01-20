public class Suite extends Rom implements Pantry {
    final String type;
    final int sengeplasser;
    final int pantryStr;
    final boolean hasPantry;

    public Suite (int nr, int str, int sengeplasser, int etg, int pantryStr) {
        super(nr, str, etg);
        type = "Suite";
        this.sengeplasser = sengeplasser;
        if (pantryStr > 0) {
            hasPantry = true;
            this.pantryStr = pantryStr;
        } else {pantryStr = 0;}
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
