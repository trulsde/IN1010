import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class FinnEldsteNavn {
  public static void main(String[] args) throws FileNotFoundException {
    File fil = new File("alder.txt");
    Scanner sc = new Scanner(fil);
    String eldsteNavn = "ingen";
    int maksAlder = -1;
    while (sc.hasNextLine()) {
      String[] biter = sc.nextLine().split(" "); 
      String navn = biter[0];   // Virker for alle navn?
      int alder = Integer.parseInt(biter[1]);
      if (alder > maksAlder) {
        maksAlder = alder;
        eldsteNavn = navn;
      }
    }
    System.out.println(eldsteNavn);
    sc.close();
  }
}
