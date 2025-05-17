/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spotifei.model;

/**
 *
 * @author hburi
 */
public class Artista extends Pessoa{
    private String nomeArtistico;
    private int idArtista;
    
    public Artista(String nome, String nomeArtistico){
        super(nome);
        this.nomeArtistico = nomeArtistico;
    }

    public Artista(String nome) {
        super(nome);
    }
    
    

    public String getNomeArtistico() {
        return nomeArtistico;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setNomeArtistico(String nomeArtistico) {
        this.nomeArtistico = nomeArtistico;
    }

    public void setId(int idArtista) {
        this.idArtista = idArtista;
    }
    
}
