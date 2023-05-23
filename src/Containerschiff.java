public class Containerschiff {
    // Attributes
    private String taufname;
    private short schiffslaenge;
    private int maxStellplaetze;
    private int belegeteStellplaetze;
    private int brz;
    private double geladenesVolumen;
    private double maxVolumen;
    private static final short MIN_MAX_STELLPLAETZE;

    // static initialization block
    static {
        MIN_MAX_STELLPLAETZE = 1000; // Limitation of the number of Stellplaetze to 1000
    }

    public Containerschiff(String taufname, short schiffslaenge, int maxStellplaetze) {
        this.taufname = taufname;
        this.schiffslaenge = schiffslaenge;
        this.maxStellplaetze = Math.max(maxStellplaetze,MIN_MAX_STELLPLAETZE);
        this.belegeteStellplaetze = 0;
        this.geladenesVolumen = 0;
    }

    // Getters

    public String getTaufname() {
        return taufname;
    }
    public short getSchiffslaenge() {
        return schiffslaenge;
    }
    public int getMaxStellplaetze() {
        return maxStellplaetze;
    }
    public int getBrz() {
        return brz;
    }

    // Setters
    public void setTaufname(String taufname) {
        this.taufname = taufname;
    }
    public void setSchiffslaenge(short schiffslaenge) {
        this.schiffslaenge = schiffslaenge;
    }
    public void setMaxStellplaetze(int maxStellplaetze) {
        this.maxStellplaetze = maxStellplaetze;
    }
    public void setBrz(int brz) {
        this.brz = brz;
    }

    // Methods / Functions
    public boolean beladen(int anzahlContainer, boolean ist20TEU) {

        int benoetigteStellplaetze = ist20TEU ? anzahlContainer : 2 * anzahlContainer;

        if (belegeteStellplaetze + benoetigteStellplaetze > maxStellplaetze) {
            return false; // Platzmangel, Laden nicht möglich
        } else {
            belegeteStellplaetze += benoetigteStellplaetze;
            setBrz(getBrz() + (ist20TEU ? 33 * anzahlContainer : 68 * anzahlContainer));
            return true; // kein Platzmangel, Laden möglich
        }
    }
    public int ladungLoeschen() {
        int geloeschteContainer = belegeteStellplaetze / 2; // Jeder 40 TEU-Container belegt 2 Plätze
        belegeteStellplaetze = 0;
        brz = 0;
        return geloeschteContainer;
    }
    public double getLaengeInMeter() {
        return schiffslaenge * 0.3048 // 1 nautischer Fuß entspricht 0.3048 Metern
    }
    public String toString() {
        return "Taufname " + this.taufname + " belegte Stellplaetze " + this.belegeteStellplaetze + " von " + this.maxStellplaetze;
    }
}
