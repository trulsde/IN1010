import java.util.Random;

public class RandomShit {
    public static void main(String[] args)  {
        Random rand = new Random();
        for (int i = 0; i < 15; i++) {
            char firstLetter = (char)(rand.nextInt(26) + 'A');
            int nummer = rand.nextInt(100000);
            System.out.print(firstLetter);
        }
    }
}
