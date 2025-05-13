/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spotifei.model;

/**
 *
 * @author hburi
 */
public class Musica {
    private int id,idArtista;
    private String titulo,genero;
    
    public Musica(){
        
    }
    
            
    
    public Musica(int id, String titulo,String genero,int idArtista){
        this.id=id;
        this.titulo= titulo;
        this.genero=genero;
        this.idArtista=idArtista;
    }
    public int idArtista(){
        return idArtista;
    }

    public int getId() {
        return id;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
