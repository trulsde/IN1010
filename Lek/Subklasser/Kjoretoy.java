package Subklasser;

class Kjoretoy {
    private String id;
    private String merke;
    private String modell;
    private int aar;

    public Kjoretoy(String id, String merke, String modell, int aar) {
        this.id = id;
        this.merke = merke;
        this.modell = modell;
        this.aar = aar;
    }
    public String hentId() {
        return id;
    }
    public String hentMerke() {
        return merke;
    }
    public String hentModell() {
        return modell;
    }
    public int hentAar() {
        return aar;
    }
    public void settId(String id) {
        this.id = id;
    }
    public void settMerke(String merke) {
        this.merke = merke;
    }
    public void settModell(String modell) {
        this.modell = modell;
    }
    public void settAar(int aar) {
        this.aar = aar;
    }
}
