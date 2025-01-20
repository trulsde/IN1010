import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.File;
import java.io.FileNotFoundException;
import org.apache.commons.math3.stat.inference.BinomialTest;
import org.apache.commons.math3.stat.inference.AlternativeHypothesis;


public class SubsekvensRegister {
    ArrayList<HashMap<String, Subsekvens>> register;

    public SubsekvensRegister() {
        register = new ArrayList<HashMap<String, Subsekvens>>();
    }

    public void fjern(int indeks) {
        register.remove(indeks);
    }

    public void erstatt(int indeks, HashMap<String, Subsekvens> nyOversikt) {
        register.set(indeks, nyOversikt);
    }

    public void leggTil(HashMap<String, Subsekvens> nyOversikt) {
        register.add(nyOversikt);
    }

    public HashMap<String, Subsekvens> hentUtOversikt(Integer indeks) throws IndexOutOfBoundsException {

        if (indeks == null) {
            return register.getLast();
        }
        else if (indeks >= 0 && indeks < register.size()) {
            return register.get(indeks);
        }
        else {throw new IndexOutOfBoundsException("Oppgitt indeks "+indeks+" er utenfor rekkevidde for subsekvensregisteret. Må være mellom 0 og "+ (register.size() - 1));}
    }

    public int hentStr() {
        return register.size();
    }

    public static HashMap<String, Subsekvens> lagOversikt(String filnavn) {

        Scanner fil = null;
        HashMap<String, Subsekvens> oversikt = new HashMap<>();

        try {
            fil = new Scanner(new File(filnavn));
        } catch (FileNotFoundException e) {
            System.out.println("Fil "+ filnavn +" ikke funnet");
            System.exit(1);
        }

        while (fil.hasNextLine()) {
            String linje = fil.nextLine();
            int start = 0;

            if (linje.length() < 3) {
                System.out.println("Møtte på ei linje kortere enn 3 bokstaver: " + linje);
                System.exit(1);
            }

            while (start + 3 <= linje.length()) {
                String subsekvensString = linje.substring(start, start + 3);
                if (!oversikt.containsKey(subsekvensString)) {
                    Subsekvens subsekvens = new Subsekvens(subsekvensString);
                    subsekvens.oneUp();
                    oversikt.put(subsekvensString, subsekvens);
                }
                start++;
            }
        }

        return oversikt;
    }

    public static HashMap<String, Subsekvens> flettSammen(HashMap<String, Subsekvens> ovs1, HashMap<String, Subsekvens> ovs2) {
        
        for (String key : ovs1.keySet()) {
            if (!ovs2.containsKey(key)) {
                ovs2.put(key, ovs1.get(key));
            }
            else {
                ovs1.get(key).oneUp();
                ovs2.put(key, ovs1.get(key));
            }
        }
        return ovs2;
    }

    public void flettAlle() {
        while (register.size() > 1) {
            HashMap<String, Subsekvens> ovs = SubsekvensRegister.flettSammen(register.get(0), register.get(1));
            register.set(0, ovs);
            register.remove(1);
        }
    }

    public Subsekvens hentHyppigste() {

        if (register.size() > 1) {
            System.out.println("Metoden .flettAlle() må kjøres før .skrivUtHyppigste()");
            System.exit(-1);
        }
        HashMap<String, Subsekvens> ovs = register.getLast();
        Subsekvens hyppigste = new Subsekvens("AAA");
        for (String key : ovs.keySet()) {
            Subsekvens subsekvens = ovs.get(key);
            if (subsekvens.hentAntall() > hyppigste.hentAntall()) {
                hyppigste = subsekvens;
            } else {}
        }
        return hyppigste;
    }

    public static void mestBlantSjuke(HashMap<String, Subsekvens> sjuk, HashMap<String, Subsekvens> frisk, Integer minDiff) {
        HashMap<String, Integer> hyppigsteSekvens = new HashMap<>();
        for (String key : sjuk.keySet()) {
            int antSjuk = sjuk.get(key).hentAntall();
            int antFrisk = 0;
            if (frisk.get(key) != null) {
                antFrisk = frisk.get(key).hentAntall(); 
            }         
            
            int diff = antSjuk - antFrisk;
            if (diff > minDiff) {
                hyppigsteSekvens.put(key, diff);
            }
        }

        // Herfra og ned er kopiert fra ChatGPT. Ville bare ha ordboka sortert etter forskjell i forekomst mellom sunn og frisk.
        Map<String, Integer> sortedHyppigsteSekvens = hyppigsteSekvens.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println("Subsekvenser som forekommer x flere ganger hos smittede enn hos friske:");
        System.out.println(sortedHyppigsteSekvens);
    }

    public static void binomialTest(HashMap<String, Subsekvens> sjuk, HashMap<String, Subsekvens> frisk, double grenseVerdi) {
        System.out.println();
        System.out.println("------ Dominante sekvenser ------");
        System.out.println("Subsekvens - p-verdi");

        List<Map.Entry<String, Double>> entryList = new ArrayList<>();

        for (String key : sjuk.keySet()) {
            BinomialTest test = new BinomialTest();
            int antSjuk = sjuk.get(key).hentAntall();
            int antTotalt = antSjuk;
            if (frisk.get(key) != null) {antTotalt += frisk.get(key).hentAntall();}
            double pSmitte = 0.5;

            double pVerdi = test.binomialTest(antTotalt, antSjuk, pSmitte, AlternativeHypothesis.GREATER_THAN);

            // Herfra og ned er samme som ovenfor
            if (pVerdi < grenseVerdi) {
            entryList.add(new AbstractMap.SimpleEntry<>(key, pVerdi));
            }
        }

        Collections.sort(entryList, new Comparator<Map.Entry<String, Double>>() {

            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return Double.compare(o1.getValue(), o2.getValue());
            }
        });

        for (Map.Entry<String, Double> entry : entryList) {
            System.out.println(entry.getKey() + " ; " + entry.getValue());
        }
    }
}