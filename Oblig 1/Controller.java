public class Controller {
    Vindu vindu;
    Rutenett rutenett;

    public Controller() {
        vindu = new Vindu(this);
        rutenett = new Rutenett(vindu.getDimensions()[0], vindu.getDimensions()[1]);
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
        vindu.oppdaterRutenett();
    }

    public void endreCelleStatus(int antRader, int antKolonner) {
        Celle celle = rutenett.hentCelle(antRader, antKolonner);
        if(celle.erLevende()) {
            celle.settDoed();
        } else {celle.settLevende();}
    }

    public Celle hentCelle(int antRader, int antKolonner) {
        return rutenett.hentCelle(antRader, antKolonner);
    }
}
