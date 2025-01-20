class Bil {

    String merke;
    String modell;
    String regNr;
    Person eier;

    public Bil(String merke, String modell, String regNr, Person eier) {
        this.merke = merke;
        this.modell = modell;
        this.regNr = regNr;
        this.eier = eier;
    }
    @Override
    public String toString() {
        if (eier == null) {
            return merke + " " + modell + ", " + regNr;
        } else {
            return merke + " " + modell + ", " + regNr + ". Eier: " + eier.toString();
        }
        
    }
    public void nyEier(Person nyEier) {
        eier = nyEier;
    }
}