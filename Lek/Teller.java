class Teller {

    private int antall;
    private static int total;

    public static int hentTotal()   {
        return total;
    }

    public Teller() {
        this.antall = 0;
    }

    public int hentAntall()  {
        return this.antall;
    }

    public void tell() {
        this.antall++;
        total ++;
    }

    void tellOpp(int n) {
        this.antall += n;
        total += n;
    }
}
