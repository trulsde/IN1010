import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*Kommentarer:

Det har ikke lykkes meg å kjøre dette programmet med 8 + 8 flettetråder - gud veit hvorfor. Opp til den enedelige kjøringa på Data-mappa
hadde alt fungert som det skulle, men dersom man kjører programmet med 8 + 8 flettetråder, henger det ca ved fletting nr. 8.

Jeg har kun testa hovedprogrammet med -cp ".;C: \...\commons-math3-3.6.1\commons-math3-3.6.1.jar", så jeg kan ikke garantere at det funker
på noen som helst annen måte.

For utregninga av gensekvenser som forekommer oftere hos sjuke enn hos friske, har jeg laga to statiske metoder i klassen
SubsekvensRegister (SubsekvensRegister.mestBlantSjuke() og SubsekvensRegister.binomialTest()). Begge tar de sorterte ordbøkene/registrene
over gensekvenser fra de to monitorene som parametre (smitta først, så den friske), mens førstnevnte også tar grenseverdien for 
antall flere forekomster hos sjuke enn friske (i dette tilfellet 7) som en tredje parameter.*/

public class Oblig2Hele {
    
    public static void main(String[] args) {
        Scanner metadata = null;
        // Da jeg beholdt antFlettere = 8, kom ikke programmet seg forbi fletting nr. 8. Med 2 * 100 flettere, fungerer det derimot.
        int antFlettere = 100;
        ArrayList<Thread> lesere = new ArrayList<>();
        ArrayList<Thread> flettere = new ArrayList<>();
        int elementerSjuk = 0;
        int elementerFrisk = 0;
        int filerLest = 0;
        Monitor monitorFrisk = new Monitor();
        Monitor monitorSjuk = new Monitor();

        try {
            // Linjene under er kun for å forsikre meg om at et mappenavn er sendt som parameter til hovedprogrammet
            String filnavn = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Et mappenavn må gis som parameter til dette programmet");
            System.exit(1);
        }

        try {
            metadata = new Scanner(new File(args[0] + "/metadata.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("Filnavn ikke funnet");
        }
        
        System.out.println("Leser inn filer ...");
        while (metadata.hasNextLine()) {
            String[] filOgSjukdom = metadata.nextLine().split(",");
            String filnavn = args[0] + "/" + filOgSjukdom[0];
            String sjuk = filOgSjukdom[1];
            Monitor m = null;
            if (sjuk.equals("True")) {
                m = monitorSjuk;
                elementerSjuk++;
            } else {
                m = monitorFrisk;
                elementerFrisk++;
            }
            LeseTrad lt = new LeseTrad(filnavn, m, filerLest + 1);
            Thread leser = new Thread(lt);
            lesere.add(leser);
            leser.start();
 
            filerLest++;
        }

        monitorFrisk.settAntFlettinger(elementerFrisk - 1);
        monitorSjuk.settAntFlettinger(elementerSjuk - 1);

        System.out.println("Oversikter lages og legges inn i subsekvensregistrene ...");
        while (monitorFrisk.hentStr() != elementerFrisk || monitorSjuk.hentStr() != elementerSjuk) {System.out.print("");}

        System.out.println("Lager "+antFlettere+" flettetråder ...");
        for (int a = 1; a <= antFlettere; a++) {
            FletteTrad sjuk = new FletteTrad(monitorSjuk);
            FletteTrad alle = new FletteTrad(monitorFrisk);
            Thread fletterSjuk = new Thread(sjuk);
            Thread fletterAlle = new Thread(alle);
            flettere.add(fletterSjuk);
            flettere.add(fletterAlle);
            fletterSjuk.start();
            fletterAlle.start();
        }
        
        System.out.println("Fletting ferdigstilles ...");
        while (!monitorFrisk.erFerdig() || !monitorSjuk.erFerdig()) {
            System.out.print("");
        }

        System.out.println("Avbryter flettetråder ...");
        for (Thread fletter : flettere) {
            fletter.interrupt();
        }

        HashMap<String, Subsekvens> sjukeRegister = monitorSjuk.hentUtOversikt(null);
        HashMap<String, Subsekvens> friskeRegister = monitorFrisk.hentUtOversikt(null);
        double pVerdiGrense = 0.05;

        SubsekvensRegister.mestBlantSjuke(sjukeRegister, friskeRegister, 7);
        SubsekvensRegister.binomialTest(sjukeRegister, friskeRegister, pVerdiGrense);        
    }
}
