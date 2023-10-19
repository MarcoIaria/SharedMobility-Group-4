package veicoli;

public abstract class Veicolo {
    private static int idTot = 0;
    protected int idVeicolo;
    protected String posizione;
    protected boolean isBoooked;
    protected String tipoCarburante;
    protected int livelloCarburante;
    protected double tariffa;

    public Veicolo(double tariffa, String posizione) {
        idVeicolo = idTot++;
        this.posizione = posizione;
        isBoooked = false;
        this.tipoCarburante = null;
        livelloCarburante = 100;
        this.tariffa = tariffa;
    }

    public Veicolo(String tipoCarburante, double tariffa, String posizione) {
        idVeicolo = idTot++;
        this.posizione = posizione;
        isBoooked = false;
        this.tipoCarburante = tipoCarburante;
        livelloCarburante = 100;
        this.tariffa = tariffa;
    }

}
