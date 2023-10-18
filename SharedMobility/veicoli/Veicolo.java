package shared_mobility.SharedMobility.veicoli;

public class Veicolo {
    private int id;
    private String tipoVeicolo;
    private String targa;
    private boolean affittato;
    private String posizione;
    private double livelloCarburante;
    private double livelloBatteria;

    public Veicolo(int id, String tipoVeicolo) {
        this.id = id;
        this.tipoVeicolo = tipoVeicolo;
        this.affittato = false;
        this.targa = "";
        this.posizione = "";
        this.livelloCarburante = 0.0;
        this.livelloBatteria = 0.0;
    }
}
