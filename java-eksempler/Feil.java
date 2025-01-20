class Feil {
    public static void main (String[] args) {
        int pris = 25;
        pris = 2*pris;
        if (pris > 200) {
            pris = 200;
        }
        else {
            pris = pris + 50;
        System.out.println("Pris: " + pris);
    }
}
