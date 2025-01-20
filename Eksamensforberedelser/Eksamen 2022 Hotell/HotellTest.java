import java.util.Iterator;

public class HotellTest {
    public static void main(String[] args) {
        int antEtasjer = 4;
        int maxSengeplasser = 8;

        Hotell hotell = new Hotell(antEtasjer);

        VanligRom v1 = new VanligRom(11, 25, 2, 1);
        EnkeltRom e1 = new EnkeltRom(12, 15, 1);
        Suite s1 = new Suite(21, 50, 3, 2);
        VanligRom v2 = new VanligRom(22, 20, 5, 2);

        v1.settNeste(e1);
        s1.settNeste(v2);

        hotell.settInForsteRom(v1, 1);
        hotell.settInForsteRom(s1, 2);

        Iterator<Rom> iter = hotell.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
