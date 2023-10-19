package veicoli;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import shared_mobility.SharedMobility.src.Patenti;

@Getter @Setter
public class Automobile extends Veicolo {

    private String targa;
    private Patenti patenteRichiesta;

    public Automobile() {
        super();
    }
    public Automobile (String targa, String tipoCarburante, double tariffa, String posizione) {
        super(tipoCarburante, tariffa, posizione);
        this.targa = targa;
        patenteRichiesta = Patenti.B;
    }
}
