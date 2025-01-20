public class Node {
    private Node neste;
    private String verdi;
    public Node(String verdi) {
        this.verdi = verdi;
    }
    void settNeste(Node n) {neste = n;}
    Node hentNeste() {return neste;}
    String hentVerdi() {return verdi;}
}