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

    @Override
    public String toString() {
        return "MonopattinoElettrico{" +
                "idVeicolo=" + idVeicolo +
                ", targa='" + targa + '\'' +
                ", posizione='" + posizione + '\'' +
                ", isBooked=" + isBooked +
                ", tipoCarburante='" + tipoCarburante + '\'' +
                ", livelloCarburante=" + livelloCarburante +
                ", tariffa=" + tariffa +
                "}\n";
    }
}
