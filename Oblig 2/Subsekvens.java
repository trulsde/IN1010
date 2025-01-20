class Subsekvens {
    private int antall = 0;
    public final String sekvens;

    public Subsekvens(String sekvens) {
        this.sekvens = sekvens;
    }
    @Override
    public String toString() {
        return "("+ sekvens +", "+ antall +")";
    }
    public void oneUp() {
        antall++;
    }
    public int hentAntall() {
        return antall;
    }
}