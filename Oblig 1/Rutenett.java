public class Rutenett {
    int antRader;
    int antKolonner;
    Celle[][] rutene;

    public Rutenett(int rader, int kolonner)    {
        antRader = rader;
        antKolonner = kolonner;
        rutene = new Celle[antRader][antKolonner];
    }
    private Celle lagCelle()  {
        Celle celle = new Celle();
        if (Math.random()<= 0.333333)   {
            celle.settLevende();
        }
        return celle;
    }
    public void fyllMedTilfeldigeCeller()   {
        for (int i = 0; i < antRader; i++) {
            for (int j = 0; j < antKolonner; j++) {
                rutene[i][j] = lagCelle();
            }
        }
    }
    public Celle hentCelle(int rad, int kolonne)    {
        try {
            return rutene[rad][kolonne];
        } catch(Exception e) {
            return null;
        }
    }
    public void tegnRutenett()  {
        for (Celle[] rad : rutene) {
            for (Celle celle : rad) {
                if (rad[antKolonner - 1] == celle) {
                    System.out.println("[ " + celle.hentStatusTegn() + " ]");
                } else {
                    System.out.print("[ " + celle.hentStatusTegn() + " ]");
                }
            }
        }
    }
    public void settNaboer(int rad, int kolonne) {
        Celle celle = hentCelle(rad, kolonne);
        for (int r = rad -1; r <= rad + 1; r++) {
            for (int k = kolonne - 1; k <= kolonne + 1; k++) {
                if (r != rad || k != kolonne) {
                    Celle c = hentCelle(r, k);
                    if (c != null) {
                        celle.leggTilNabo(c);
                    }
                }
            }
        }
    }
    public void kobleAlleCeller() {
        for (int r = 0; r < antRader; r++) {
            for (int k = 0; k < antKolonner; k++) {
                settNaboer(r, k);
            }
        }
    }
    public int antallLevende() {
        int levendeCeller = 0;
        for (Celle[] rad : rutene) {
            for (Celle celle : rad) {
                if (celle.erLevende()) {
                    levendeCeller++;
                }
            }
        }
        return levendeCeller;
    }
}
