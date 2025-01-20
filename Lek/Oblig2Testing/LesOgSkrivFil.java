import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

class LesOgSkrivFil {

    File fil;
    
    public LesOgSkrivFil(String filnavn) {
        this.fil = new File(filnavn);
    }

    public static void printSekvenser(String filnavn) {
        Scanner fil = null;
        try {
            fil = new Scanner(new File(filnavn));
        } catch (FileNotFoundException e) {
            System.out.println("Filnavn ikke funnet");
            System.exit(1);
        }
        
        HashMap<String, Integer> oversikt = new HashMap<>();

        while (fil.hasNextLine()) {
            String linje = fil.nextLine();
            int start = 0;
            
            while (start + 2 < linje.length()) {
                String subsekvens = linje.substring(start, start + 3);
                if (!oversikt.containsKey(subsekvens)) {
                    oversikt.put(subsekvens, 1);
                } else {}
                start++;
            }
        }
        System.out.println(oversikt);
        fil.close();
    }
}

class Main {
    public static void main(String[] args) {
        LesOgSkrivFil.printSekvenser("fil1.csv");
    }
}
