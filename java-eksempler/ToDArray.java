public class ToDArray {
    public static void main(String[] args) {
        final int LAND = 7; // Alternativt Integer.parseInt(args[0])
        final int MEDALJER = 3; // Alternativt Integer.parseInt(args[1])
        int[][] antall = new int[LAND][MEDALJER];

        antall[0][0]++;                     // ny gullmedalje for land nr 0

        for (int landNr=0; landNr<LAND; landNr++) {
            for (int medNr=0; medNr<MEDALJER; medNr++) {
                System.out.print(antall[landNr][medNr] + "   ");
            }
            System.out.println();
        }
    }
}
