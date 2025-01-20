public class Lenkeliste {
    Node forste, siste;

    public Node pop(){
        Node m = siste;
        siste.settForrige(siste);
        return m;
    }
    public void leggTil(Node ny){
        if (forste == null){forste = ny;}
        else {
            Node m = forste;
            forste = ny;
            forste.settNeste(m);
            m.settForrige(ny);
        }
    }
}
