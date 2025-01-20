class Person {
    String navn;
    String etternavn;
    int alder;

    public Person(String navn, String etternavn, int alder) {
        this.navn = navn;
        this.etternavn = etternavn;
        this.alder = alder;
    }
    @Override
    public String toString() {
        return navn + " " + etternavn + ", " + alder;
    }
    public void bursdag() {
        alder ++;
    }
}