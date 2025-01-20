package Subklasser;

import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        HashMap<String, Kjoretoy> kjoretoyMap = new HashMap<>();

        Bil bil1 = new Bil("1", "BMW", "i3", 2019, 5, "Stasjonsvogn, El-bil");
        kjoretoyMap.put(bil1.hentId(), bil1);
        Motorsykkel mc1 = new Motorsykkel("1", "Ducati", "798", 1989, "En skikkelig rakker");
        kjoretoyMap.put(mc1.hentId(), mc1);

        for (Kjoretoy k : kjoretoyMap.values()) {
            System.out.println("Id: " + k.hentId());
            System.out.println("Merke: " + k.hentMerke());
            System.out.println("Modell: " + k.hentModell());
            System.out.println("År: " + k.hentAar());

            if (k instanceof Bil) {
                System.out.println("Seter: " + ((Bil) k).hentSeter());
                System.out.println("Biltype: " + ((Bil) k).hentBiltype());
            }
            if (k instanceof Motorsykkel) {
                System.out.println("Motortype: " + ((Motorsykkel) k).hentMotortype());
            }
        }
    }
}
