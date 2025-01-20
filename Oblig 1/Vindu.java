import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;

public class Vindu {
    private Controller c;

    private int antRader = 10;
    private int antKolonner = 5;

    private JPanel panel;
    private JFrame vindu;
    private JMenuBar meny;
    private JButton start;
    private JButton exit;
    private JMenu velgRader;
    private JMenu velgKolonner;

    // Konstruktør (og egentlig alt resten)
    public Vindu(Controller controller) {
        c = controller;

        vindu = new JFrame("Game of life");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Lager et grunnoppsett av knapper med antRader = 10 rader og antKolonner = 15 kolonner. Oppretter en menylinje
         * og alternativer for valg av kolonner og rader samt å avslutte spillet.
        */

        meny = new JMenuBar();
        exit = new JButton("Avslutt");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        start = new JButton("Start Spillet");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {

            }
        });
        
        velgRader = new JMenu("Velg rader");
        velgKolonner = new JMenu("Velg kolonner");

        /* Nå legger vi til 15 valgknapper til hver av menyalternativene "Velg rader" og "Velg kolonner".
         * Hver av disse knappene får tildelt en ActionListener som oppdaterer antallet rader og kolonner med det tallet som
         * utgjør etiketten til valgknappen.
         */

        for (int i=0; i < 20; i++) {

            JMenuItem radNummer = new JMenuItem(Integer.toString(i+1));
            radNummer.addActionListener(new RadAction(this, i+1));
            velgRader.add(radNummer);
            
            JMenuItem kolNummer = new JMenuItem(Integer.toString(i+1));
            kolNummer.addActionListener(new KolonneAction(this, i+1));
            velgKolonner.add(kolNummer);
        }

        meny.add(exit);
        meny.add(velgRader);
        meny.add(velgKolonner);

        vindu.setJMenuBar(meny);

        panel = new JPanel();

        oppdaterRutenett();

        vindu.add(panel);
        vindu.pack();
        vindu.setSize(500, 500);
        vindu.setLocationRelativeTo(null);
        vindu.setVisible(true);

    }

    private class KolonneAction implements ActionListener {
        int antall;
        Vindu v;

        public KolonneAction(Vindu v, int antall) {
            this.v = v;
            this.antall = antall;
        }

        @Override
        public void actionPerformed (ActionEvent e) {
            v.antKolonner = antall;
            v.oppdaterRutenett();
        }
    }

    private class RadAction implements ActionListener {
        Vindu v;
        int antall;

        public RadAction(Vindu v, int antall) {
            this.v = v;
            this.antall = antall;
        }

        @Override
        public void actionPerformed (ActionEvent e) {
            v.antRader = antall;
            v.oppdaterRutenett();
        }
    }

    private class KnappListener implements ActionListener {
        int rader;
        int kolonner;

        public KnappListener(int rader, int kolonner) {
            this.rader = rader;
            this.kolonner = kolonner;
        }

        @Override
        public void actionPerformed (ActionEvent e) {
            JButton knapp = (JButton) e.getSource();
            if (knapp.getBackground().equals(Color.darkGray) && c.hentCelle(rader, kolonner).erLevende()) {
                knapp.setBackground(Color.lightGray);
                c.hentCelle(rader, kolonner).settDoed();
            } else if (knapp.getBackground().equals(Color.lightGray) && !c.hentCelle(rader, kolonner).erLevende()) {
                 knapp.setBackground(Color.darkGray);
                 c.hentCelle(antRader, antKolonner).settLevende();
            } else {System.out.println("Farge på knapp matcher ikke med død / levende");}
        }
    }
    
    // Metode for oppdatering av rutenettet
    public void oppdaterRutenett() {
        
        panel.removeAll();
        panel.setLayout(new GridLayout(antRader, antKolonner));

        for (int i=0; i < antRader; i++) {
            for (int j=0; j < antKolonner; j++) {
                JButton knapp = new JButton();
                knapp.setBackground(Color.lightGray);
                knapp.addActionListener(new KnappListener(i, j));
                panel.add(knapp);
            }
        }
        panel.revalidate();
        panel.repaint();
    }

    public Integer[] getDimensions() {
        Integer[] currentDimensions = new Integer[2];
        currentDimensions[0] = antRader;
        currentDimensions[1] = antKolonner;
        return currentDimensions;
    }
}
