public class Lenkeliste {
    public static void main(String[] args){
        Node start = new Node("Fitte");
        Node neste = new Node("Satan");
        Node endaEn = new Node("Anarki");
        Node siste = new Node("Kommando");
        start.settNeste(neste);
        neste.settNeste(endaEn);
        endaEn.settNeste(siste);

        Node n = start;

        while (n != null) {
            System.out.println(n.hentVerdi());
            n = n.hentNeste();
        }

        GeneriskListe<String> l = new GeneriskListe<String>();
        String tekst = "FiteSatanAnarkiKommando";
        l.fyll(tekst);

        System.out.println(l.hent());
    }
}
