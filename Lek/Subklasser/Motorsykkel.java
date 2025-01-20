package Subklasser;

public class Motorsykkel extends Kjoretoy {
    private String motortype;

    public Motorsykkel(String id, String merke, String modell, int aar, String motortype) {
        super(id, merke, modell, aar);
        this.motortype = motortype;
    }
    public String hentMotortype() {
        return motortype;
    }
}
