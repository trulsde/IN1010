import java.util.Iterator;
public class Arrayliste<T> implements Liste<T>{
    @SuppressWarnings("unchecked")
    private T[] data = (T[]) new Object[10];
    private int iBruk = 0;

    class ListeIterator implements Iterator<T> {
        private int pos = 0;
        @Override
        public T next() {
            pos++;
            return get(pos-1);
        }
        @Override
        public boolean hasNext() {
            return pos < size();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListeIterator();
    }

    @Override
    public int size() {
        return iBruk; }

    @Override
    public void set(int pos, T x) {
        if (pos<0 || pos>=iBruk) {
            throw new UlovligListeIndeks(pos, iBruk-1); }
        data[pos] = x; }

    @Override
    public T get(int pos) {
        if (pos<0 || pos>=iBruk) {
            throw new UlovligListeIndeks(pos, iBruk-1); }
        return data[pos]; }

    @Override
    public void add(T x) {
        if (iBruk == data.length) {
            @SuppressWarnings("unchecked")
            T[] ny = (T[]) new Object[2 * iBruk];
            for (int i = 0; i < data.length; i++) {
                ny[i] = data[i]; }
            data = ny; }
        data[iBruk] = x;
        iBruk++;
    }

    @Override
    public T remove(int pos) {
        if (pos<0 || pos>=iBruk) {
            throw new UlovligListeIndeks(pos, iBruk-1); }
        T res = data[pos];
        for (int i = pos + 1; i < iBruk; i++) {
            data[i - 1] = data[i]; }
        iBruk--;
        return res; }
}
