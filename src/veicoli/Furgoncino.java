package veicoli;

import lombok.Getter;
import lombok.Setter;
import shared_mobility.SharedMobility.src.Patenti;

@Getter @Setter
public class Furgoncino extends Veicolo {
    private String targa;
    private Patenti patenteRichiesta;

    public Furgoncino (String targa, String tipoCarburante, double tariffa, String posizione) {
        super(tipoCarburante, tariffa, posizione);
        this.targa = targa;
        patenteRichiesta = Patenti.C;
    }

    @Override
    public String toString() {
        return "Furgoncino{" +
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
