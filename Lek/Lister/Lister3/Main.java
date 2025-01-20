class Main {
    public static void main(String[] args) {
        Person arne = new Person("Arne", "Bergesen", 54);
        Bil vw = new Bil("Volkswagen", "ID.4", "EB37653", null);
        vw.nyEier(arne);
        
        Garasje<Bil> garasje = new Garasje<Bil>(70);
        garasje.parkerBil(vw);
        garasje.skrivUtBiler();
    }
}    


