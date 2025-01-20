import java.io.PrintWriter;

class LagFil {
    public static void main(String[] args) {
        PrintWriter f = null;
        try {
            f = new PrintWriter("tall-til-10.txt");
        } catch (Exception e) {
            System.out.println("Kan ikke lage filen tall-til-10.txt.");
            System.exit(1);
        }
        // Skriv tallene fra 1 til 10:
        for (int i = 1; i <= 10; i++) {
            f.print(" " + i);
        }
        f.println(); f.close();
    }
} 