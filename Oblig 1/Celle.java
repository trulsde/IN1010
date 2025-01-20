public class Celle {

    boolean levende;
    Celle[] naboer;
    int antNaboer;
    int antLevendeNaboer;

    public Celle()   {
        naboer = new Celle[8];
        levende = false;
        antNaboer = 0;
        antLevendeNaboer = 0;
    }
    public int hentLevendeNaboer() {
        return antLevendeNaboer;
    }
    public void settDoed()   {
        levende = false;
    }
    public void settLevende()   {
        levende = true;
    }
    public boolean erLevende()  {
        return levende;
    }
    public char hentStatusTegn()    {
        if (levende)    {
            return 'O';
        }   else {
            return '.';
        }
    }
    public void leggTilNabo(Celle celle) {
        for (int i = 0; i < naboer.length; i++) {
            if (naboer[i] == null) {
                naboer[i] = celle;
                antNaboer++;
                break;
            }
        }
    }
    public void tellLevendeNaboer() {
        antLevendeNaboer = 0;
        for (Celle celle : naboer) {
            if (celle == null) break;
            else if (celle.erLevende()) antLevendeNaboer++;
        }
    }
    public void oppdaterStatus()  {
        if (levende == true) {
            if (antLevendeNaboer < 2 || antLevendeNaboer > 3)   {
                levende = false;
            }
        } else if (levende == false) {
            if (antLevendeNaboer == 3)  {
                levende = true;
            }
        }
    }
}
