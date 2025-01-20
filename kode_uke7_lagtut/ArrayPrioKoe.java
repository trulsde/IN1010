public class ArrayPrioKoe<T extends Comparable<T>> extends Arrayliste<T> {
    @Override
    public void add(T x) {
        if (size() == 0) {
            // Listen er tom, så sett inn nytt element:
            super.add(x);
            return;
        }

        for (int i = 0; i < size(); i++) {
            if (get(i).compareTo(x) > 0) {
            // Vi har funnet et element som er større enn det nye.
            // Flytt det og etterfølgende elementer ett hakk opp.
            super.add(null); // Utvid arrayen (overskrives straks)
            for (int ix = size()-2; ix >= i; ix--)
                set(ix+1, get(ix));
            // Sett inn det nye elementet:
            set(i, x);
            return;
            }
        }
        // Det nye elementet er størst (ellers ville vi returnert)
        // og skal inn bakerst:
        super.add(x);
    } // end of add
    
}
