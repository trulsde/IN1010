import java.util.Scanner;

public class GameMedLokke {
    public static void main(String[] args) {
        int rader = 0;
        int kolonner = 0;

        Scanner input = new Scanner(System.in);
        boolean condition1 = false;
        while (!condition1) {
            System.out.print("Skriv inn antall rader for spillbrettet: ");
            String innVerdi1 = input.next();
            try {
                rader = Integer.parseInt(innVerdi1);
                condition1 = true;
            } catch (NumberFormatException e) {
                System.out.println("**** Vennligst skriv inn et heltall ****");
            }
        }

        boolean condition2 = false;
        while (!condition2) {
            System.out.print("Skriv inn antall kolonner for spillbrettet: ");
            String innVerdi2 = input.next();
            try {
                kolonner = Integer.parseInt(innVerdi2);
                condition2 = true;
            } catch(NumberFormatException e) {
                System.out.println("**** Vennligst skriv inn et heltall ****");
            }
        }

        Verden spill1 = new Verden(rader, kolonner);
        spill1.oppdatering();
        spill1.tegn();

        int fortsettelse = 1;
        while (fortsettelse == 1) {
            if (spill1.hentAntallLevende() == 0) {
                System.out.println("Alle cellene døde!");
                fortsettelse = 0;
                break;
            }
            System.out.print("Ny generasjon?\nJ/N:  ");
            String valg = input.next();
            if (valg.equals("N") || valg.equals("n")) {
                System.out.println("Takk for at du spilte!");
                fortsettelse = 0;
                input.close();
            } else if (valg.equals("J") || valg.equals("j")) {
                spill1.oppdatering();
                spill1.tegn();
                fortsettelse = 1;
            } else {
                System.out.println("**** Vennligst skriv enten 'J' eller 'N' ****");
            }

        }
    }
}