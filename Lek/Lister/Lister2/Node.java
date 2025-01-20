class Node {
    private Node neste, forrige;
    private String verdi;

    public Node(String verdi){
        this.verdi = verdi;
    }

    public void settNeste(Node n){
        this.neste = n;
        n.settForrige(this);
    }
    public void settForrige(Node f){
        this.forrige = f;
    }
    public String hentVerdi(){
        return verdi;
    }
    private Node forste = new Node("Første");
    private Node n2 = new Node("Andre");
    private Node n3 = new Node("Tredje");

}