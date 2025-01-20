package Subklasser;

public class Bil extends Kjoretoy {
    private int antallSeter;
    private String biltype;

    public Bil(String id, String merke, String modell, int aar, int antallSeter, String biltype) {
        super(id, merke, modell, aar);
        this.antallSeter = antallSeter;
        this.biltype = biltype;
    }
    public int hentSeter() {
        return antallSeter;
    }
    public String hentBiltype() {
        return biltype;
    }
}
