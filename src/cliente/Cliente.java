package cliente;

import lombok.Getter;
import shared_mobility.SharedMobility.src.Patenti;
import java.util.Date;
import java.util.List;

@Getter
public class Cliente {
    private static int idTot = 0;
    private int idUtente;
    private String nome;
    private String cognome;
    private Date dataDiNascita;
    private String codiceFiscale;
    private List<Patenti> patenti;
    private boolean haCasco = false;
    private double credito;

    public Cliente(String nome, String cognome, Date dataDiNascita, String codiceFiscale, List<Patenti> patenti, boolean haCasco) {
        this.idUtente = idTot++;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.codiceFiscale = codiceFiscale;
        this.patenti = List.copyOf(patenti);
        this.haCasco = haCasco;
        this.credito = 0.0;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idUtente=" + idUtente +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", patenti=" + patenti +
                ", haCasco=" + haCasco +
                ", credito=" + credito +
                '}';
    }

    // metodo per ricaricare credito
    public void addCredit(int credito) {
        this.credito += credito;
    }

}
