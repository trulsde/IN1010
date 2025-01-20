import javax.swing.SwingUtilities;

public class VindusTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Controller();
            }
        });
    }
}
