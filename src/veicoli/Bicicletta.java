package veicoli;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Bicicletta extends Veicolo {
    private static final boolean NEED_HELMET = true;

    public Bicicletta (double tariffa, String posizione) {
        super(tariffa, posizione);}

    @Override
    public String toString() {
        return "Bicicletta{" +
                "idVeicolo=" + idVeicolo +
                ", posizione='" + posizione + '\'' +
                ", isBooked=" + isBooked +
                ", tariffa=" + tariffa +
                '}';
    }
}
