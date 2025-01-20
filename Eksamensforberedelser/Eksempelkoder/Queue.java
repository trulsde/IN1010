import java.util.Iterator;

public class Queue implements Iterable<Node> {
    Node first;
    Node siste;
    int lengde;

    public Queue() {
        first = siste = null;
        lengde = 0;
    }

    protected class Node implements Comparable<Node> {
        Object data;
        int prioritet;
        Node bak;
        Node foran;

        public Node (Object data, int pri) {
            this.data = data;
            this.prioritet = pri;
        }

        protected void settNeste (Node n) {
            bak = n;
        }
 
        protected void endrePrioritet(int nyPri) {
            prioritet = nyPri;
        }

        @Override
        public int compareTo(Node other) {
            return other.prioritet - this.prioritet;
        } 
    }

    public Node nesteMann() throws IllegalStateException {
        if (first == null) throw new IllegalStateException("Køen er tom");
        Node toReturn = first;
        first = first.bak;
        if (first == null) siste = null;
        else first.foran = null;
        toReturn.bak = null;
        lengde--;
        return toReturn;
    }

    public void settInn(Node n) throws IllegalArgumentException {
        if (n == null) throw new IllegalArgumentException("Noden som settes inn kan ikke være null");
        if (lengde == 0) { // Hvis lista er tom, settes ny Node inn på eneste tilgjengelige plass
            first = siste = n;
        } else if (n.compareTo(first) > 0) { // Hvis høyest pri av alle, settes Node inn først
            n.bak = first;
            first.foran = n;
            first = n;
        } else if (n.compareTo(siste) <= 0) { // Hvis lavest pri (eller samme som siste) -> inn sist
            siste.bak = n; 
            n.foran = siste;
            siste = n;
        } else { // Ellers må vi iterere
            Node peker = first;
            while (n.compareTo(peker) <= 0) {
                peker = peker.bak;
            }
            peker.foran.bak = n;
            n.foran = peker.foran;
            peker.foran = n;
            n.bak = peker;
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
        public Node next() {
            Node toReturn = peker;
            peker = peker.bak;
            return toReturn;
        }
    }
}
