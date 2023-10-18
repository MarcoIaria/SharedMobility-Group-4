package shared_mobility.SharedMobility.src.veicoli;

public class Bicicletta extends Veicolo {
    private static final boolean NEED_HELMET = true;

    public Bicicletta (double tariffa, String posizione) {
        super(tariffa, posizione);
    }
}
