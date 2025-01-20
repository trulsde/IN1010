public class Rekursjon {
    
    public Node finnSisteElementIEnLenkeliste(Node n) {
        if (n.neste == null) return n;
        return finnSisteElementIEnLenkeliste(n.neste);
    }

    public void tellNedFra(int tall) {
        if (tall > 0) {
            System.out.println(tall);
            tellNedFra(tall-1);
        }
    }
}


