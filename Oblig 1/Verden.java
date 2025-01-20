public class Verden {
    Rutenett rutenett;
    int genNr;
    int levendeCeller = 0;

    public Verden(int rader, int kolonner) {
        rutenett = new Rutenett(rader, kolonner);
        genNr = 0;
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
        levendeCeller = rutenett.antallLevende();
    }
    public void tegn() {
        System.out.println("Generasjon: " + genNr);
        System.out.println("Antall levende celler: " + rutenett.antallLevende());
        rutenett.tegnRutenett();
    }
    public void oppdatering() {

        for (int r = 0; r < rutenett.antRader; r++) {
            for (int k = 0; k < rutenett.antKolonner; k++) {
                Celle celle = rutenett.hentCelle(r, k);
                celle.tellLevendeNaboer();
            }
        }
        for (int r = 0; r < rutenett.antRader; r++) {
            for (int k = 0; k < rutenett.antKolonner; k++) {
                Celle celle = rutenett.hentCelle(r, k);
                celle.oppdaterStatus();
            }
        }
        genNr++;
        levendeCeller = rutenett.antallLevende();
    }
    public int hentAntallLevende() {
        return levendeCeller;
    }
}
