package veicoli;

import shared_mobility.SharedMobility.src.Patenti;

public class Furgoncino extends Veicolo {
    private String targa;
    private Patenti patenteRichiesta;

    public Furgoncino (String targa, String tipoCarburante, double tariffa, String posizione) {
        super(tipoCarburante, tariffa, posizione);
        this.targa = targa;
        patenteRichiesta = Patenti.C;
    }
}