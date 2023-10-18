package shared_mobility.SharedMobility.src.veicoli;

public class MonopattinoElettrico extends Veicolo {
    private String targa;
    private static final boolean NEED_HELMET = true;

    public MonopattinoElettrico (String targa, double tariffa, String posizione) {
        super("Elettrico", tariffa, posizione);
        this.targa = targa;
    }
}
