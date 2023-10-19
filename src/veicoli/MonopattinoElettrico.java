package veicoli;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MonopattinoElettrico extends Veicolo {
    private String targa;
    private static final boolean NEED_HELMET = true;

    public MonopattinoElettrico (String targa, double tariffa, String posizione) {
        super("Elettrico", tariffa, posizione);
        this.targa = targa;
    }
}
