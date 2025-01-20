abstract class Rom {
    final int nr;
    final int str;
    final int etg;
    boolean ledig;
    Rom neste;

    public Rom(int nr, int str, int etg) {
        this.nr = nr;
        this.str = str;
        this.etg = etg;

        ledig = true;
    }

    public void settNeste(Rom r) {
        neste = r;
    }

    public void settLedig() {
        ledig = true;
    }

    public void settOpptatt() {
        ledig = false;
    }

    abstract int hentAntallSengeplasser();
}
