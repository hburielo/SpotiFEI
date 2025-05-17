/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spotifei.model;

/**
 *
 * @author hburi
 */
public class Playlist {
    private String nomeplaylist;

    public Playlist() {
    }

    public Playlist(String nomeplaylist) {
        this.nomeplaylist = nomeplaylist;
    }

    public String getNomeplaylist() {
        return nomeplaylist;
    }

    public void setNomeplaylist(String nomeplaylist) {
        this.nomeplaylist = nomeplaylist;
    }
    
}
