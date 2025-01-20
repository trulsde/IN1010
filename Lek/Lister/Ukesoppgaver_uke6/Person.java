class Person implements Comparable<Person> {
    private String fornavn;
    private String etternavn;
    private int alder;

    public Person(String fornavn, String etternavn, int alder) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.alder = alder;
    }
    @Override
    public String toString() {
        return etternavn + ", " + fornavn;
    }
    public int hentAlder() {
        return alder;
    }
    @Override
    public int compareTo(Person annen) {
        if (alder == annen.hentAlder()) {return this.toString().compareTo(annen.toString());}
        else {return this.alder - annen.hentAlder();}
    }
}
