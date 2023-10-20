package veicoli;

import lombok.Getter;
import lombok.Setter;
import shared_mobility.SharedMobility.src.Patenti;

@Getter @Setter
public class Scooter extends Veicolo {
    private String targa;
    private Patenti patenteRichiesta;
    private static final boolean NEED_HELMET = true;

    public Scooter (String targa, String tipoCarburante, double tariffa, String posizione) {
        super(tipoCarburante, tariffa, posizione);
        this.targa = targa;
    }
    public String toString() {
        return "Scooter{" +
                "idVeicolo= " + idVeicolo +
                ", targa='" + targa + '\'' +
                ", patenteRichiesta=" + patenteRichiesta +
                ", posizione='" + posizione + '\'' +
                ", isBooked=" + isBooked +
                ", tipoCarburante='" + tipoCarburante + '\'' +
                ", livelloCarburante=" + livelloCarburante +
                ", tariffa=" + tariffa +
                "}\n";
    }
}
