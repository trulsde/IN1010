import java.util.Arrays;
public class Resultatliste {
    public static void main(String[] args) {
        Deltagerland[] land = {
            new Deltagerland("Danmark", 0, 0, 0),
            new Deltagerland("Finland", 2, 2, 4),
            new Deltagerland("Island", 0, 0, 0),
            new Deltagerland("Norge", 16, 8, 13),
            new Deltagerland("Sverige", 8, 5, 5),
            new Deltagerland("Norge 2018", 14, 14, 11)};
        Arrays.sort(land);
        for (int i = 0; i < land.length; i++)
            System.out.println(land[i].hentNavn());
    }
}
