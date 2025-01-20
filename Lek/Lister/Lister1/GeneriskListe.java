public class GeneriskListe <T> {
    private T t;
    public void fyll(T t){
        this.t = t;
    }

    public T hent(){
        return t;
    }
}
