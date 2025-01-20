import java.util.Iterator;

public class Hotell implements Iterable<Rom> {
    Rom[] forsteRomEtasje;
    final int MAX_ANTALL_SENGEPLASSER = 8;
    final int ANTALL_ETASJER;

    public Hotell (int antEtasjer) {
        ANTALL_ETASJER = antEtasjer;
        forsteRomEtasje = new Rom[ANTALL_ETASJER];
    }

    public void settInForsteRom(Rom r, int pos) {
        forsteRomEtasje[pos] = r;
    }

    public Rom[] hentRomliste() {
        return forsteRomEtasje;
    }

    public void leggTilRom(Rom r, int pos) {
        if (forsteRomEtasje != null) {System.out.println("Erstatter 1. rom i etasje " + pos);}
        else {System.out.println("Nytt 1. rom i etasje " + pos);}
        forsteRomEtasje[pos] = r;
    }

    @Override
    public Iterator<Rom> iterator() {
        return new RomIterator(forsteRomEtasje);
    }

    private class RomIterator implements Iterator<Rom> {
        private Rom[] etasjeliste;
        private Rom gjeldendeRom;
        private int pos = 0;

        public RomIterator(Rom[] etasjeliste) {
            this.etasjeliste = etasjeliste;
            this.gjeldendeRom = etasjeliste[0];
        }

        @Override
        public boolean hasNext() {
            if (gjeldendeRom == null) {
                while (pos < etasjeliste.length) {
                    pos++;
                    if (etasjeliste[pos] != null) {
                        gjeldendeRom = etasjeliste[pos];
                        return true;
                    }
                    return false;
                }
            }
            return true;
        }

        @Override
        public Rom next() {
            Rom toReturn = gjeldendeRom;
            gjeldendeRom = gjeldendeRom.neste;
            return toReturn;
        }
    }
}
