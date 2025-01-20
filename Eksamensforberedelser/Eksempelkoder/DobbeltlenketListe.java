import java.util.Iterator;
import java.util.NoSuchElementException;

public class DobbeltlenketListe {
    Node first;
    Node siste;
    int lengde;

    // Konstruktør trengs ikke med mindre parametre tas

    protected class Node {
        Object data;
        int indeks;
        String id;
        Node neste;
        Node forrige;

        public Node (Object data, String id) {
            this.data = data;
            this.id = id;
        }

        protected void settNeste (Node n) {
            neste = n;
        }

        protected Object hentData() {
            return data;
        }
    }

    public void settInnPosisjon(Object o, int indeks) throws IndexOutOfBoundsException {
        if (indeks > lengde || indeks < 0) throw new IndexOutOfBoundsException("Indeks "+indeks+" utenfor rekkevidde. Lista har lengde "+lengde);
        Node nyNode = new Node (o, "Identitet");
        if (lengde == 0) { // Hvis lista er tom fra før
            first = siste = nyNode;
        } else if (indeks == 0) { // Hvis nyNode skal settes inn på førsteplass
            nyNode.neste = first;
            first.forrige = nyNode;
            first = nyNode;
        } else if (indeks == lengde) { // Hvis ny node skal settes inn til slutt
            siste.neste = nyNode;
            nyNode.forrige = siste;
            siste = nyNode;
        } else { // Hvis ny node skal settes inn et eller annet sted inni der
            Node peker = first;
            for (int i=0; i < indeks; i++) {
                peker = peker.neste;
            }
            nyNode.forrige = peker.forrige;
            nyNode.neste = peker;
            peker.forrige = nyNode;
            nyNode.forrige.neste = nyNode;
        }
        lengde++;
    }

    public void leggTil(Object o) {
        settInnPosisjon(o, lengde);
    }

    public void fjern(Object o) throws NoSuchElementException { // Dette funker (vel?) kun for dobbellenkede lister
        if (lengde == 0) {
            throw new NoSuchElementException("Lista inneholder ingen elementer");
        }
        
        if (first.hentData().equals(o)) {
            if (lengde == 1) {
                first = siste = null;
            } else {
                first = first.neste;
                first.forrige = null;
            }
            lengde--;
            return;
        }
        
        if (siste.hentData().equals(o)) {
            siste = siste.forrige;
            if (siste != null) {
                siste.neste = null;
            }
            lengde--;
            return;
        }
        Node peker = first.neste; // We can start from the second node since the first node is already checked
        while (peker != null) {
            if (peker.hentData().equals(o)) {
                peker.forrige.neste = peker.neste;
                if (peker.neste != null) {
                    peker.neste.forrige = peker.forrige;
                }
                lengde--;
                return;
            }
            peker = peker.neste;
        }
        throw new NoSuchElementException("Dette elementet finnes ikke i lista");
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
        public Node next() {
            Node toReturn = peker;
            peker = peker.neste;
            return toReturn;
        }
    }
}
