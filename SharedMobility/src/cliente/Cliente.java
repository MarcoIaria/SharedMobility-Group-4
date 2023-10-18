package cliente;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String cognome;
    private String dataDiNascita;
    private String codiceFiscale;
    private List<String> patenti;
    //Srtring patenti;

    private boolean haCasco;
    private double credito;

    public Cliente(int id, String nome, String cognome, String dataDiNascita, String codiceFiscale) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.codiceFiscale = codiceFiscale;
        this.patenti = new ArrayList<>();
        this.haCasco = false;
        this.credito = 0.0;
    }
}
