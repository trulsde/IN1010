import java.util.Iterator;

public class LenkelisteLIFO implements Iterable<Node> { // Dette blir feil fordi klassen Node ikke er definert ennå, men dette skal kun være et eksempel
    Node first;
    Node siste;
    int lengde;

    // Konstruktør trengs ikke med mindre parametre tas

    protected class Node {
        Object data;
        int indeks;
        String id;
        Node neste;

        public Node (Object data, String id) {
            this.data = data;
            this.id = id;
            neste = null;
        }
    }

    public LenkelisteLIFO() {
        first = siste = null;
        lengde = 0;
    }

    public void leggTil(Object o) {
        Node nyNode = new Node (o, "Identitet");
        if (lengde == 0) first = siste = nyNode;
        else {
            siste.neste = nyNode;
            siste = nyNode;
        }
        lengde++;
    }

    public Iterator<Node> iterator() {
        return new NodeIterator();
    }
    
    class NodeIterator implements Iterator<Node> {
        Node peker = first;

        @Override
        public boolean hasNext() {
            return peker != null;
        }

        @Override
        public Object next() {
            Object toReturn = peker.data;
            peker = peker.neste;
            return toReturn;
        }
    }
}
