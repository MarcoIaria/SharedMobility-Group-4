package cliente;

import shared_mobility.SharedMobility.src.Patenti;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cliente {
    private static int idTot = 0;
    private int idUtente;
    private String nome;
    private String cognome;
    private Data dataDiNascita;
    private String codiceFiscale;
    private List<Patenti> patenti;
    //Srtring patenti;

    private boolean haCasco = false;
    private double credito;

    public Cliente(String nome, String cognome, Data dataDiNascita, String codiceFiscale, List<Patenti> patenti, boolean haCasco) {
        this.idUtente = idTot++;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.codiceFiscale = codiceFiscale;
        this.patenti = List.copyOf(patenti);
        this.haCasco = haCasco;
        this.credito = 0.0;
    }
}
