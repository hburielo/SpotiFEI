/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import dao.PlaylistDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import spotifei.model.Musica;
import spotifei.model.Playlist;
import spotifei.view.Interface_editarplaylist;

/**
 *
 * @author hburi
 */
public class ControllerEdicaoPlaylist {
    private Interface_editarplaylist view;

    public ControllerEdicaoPlaylist(Interface_editarplaylist view) {
        this.view = view;
    }
    
    public void ExcluirPlaylist(){
         String nomeplaylist = view.getTxt_excmusicaplaylist().getText();
          if (nomeplaylist.isEmpty()) {
        System.out.println("O nome da playlist não pode estar vazio.");
        return;
    
        }
      Playlist playlist = new Playlist();
      playlist.setNomeplaylist(nomeplaylist);
      Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            dao.removerPlaylist(playlist);
            JOptionPane.showMessageDialog(view, "Playlist Excluída!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(view, "Playlist não Excluída!","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void AdicionarMusica() {
    String nomeplaylist = view.getTxt_inserirmusicaplaylist2().getText();
    String tituloMusica = view.getTxt_addmusicaplaylist().getText();

    if (nomeplaylist.isEmpty() || tituloMusica.isEmpty()) {
        System.out.println("O nome da playlist e o título da música não podem estar vazios.");
        return;
    }

    Playlist playlist = new Playlist();
    playlist.setNomeplaylist(nomeplaylist);

    Musica musica = new Musica();
    musica.setTitulo(tituloMusica);

    Conexao conexao = new Conexao();
    try {
        Connection conn = conexao.getConnection();
        PlaylistDAO dao = new PlaylistDAO(conn);
       
        dao.adicionarMusicaNaPlaylist(playlist, musica);
        JOptionPane.showMessageDialog(view, "Música adicionada à playlist!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException ex) {
        System.out.println(ex);
        JOptionPane.showMessageDialog(view, "Erro ao adicionar música à playlist!", "Erro", JOptionPane.ERROR_MESSAGE);}
    
    }
    public void EditNomePlaylist(){
    String nomeplaylist = view.getTxt_inserirnomeplaylist().getText();
    String editplaylist = view.getTxt_editplaylistnome().getText();
    
    if(nomeplaylist.isEmpty()&& editplaylist.isEmpty()){
        System.out.println("O nome da playlist e o novo nome nao podem estar vazios");
        return;
    }
    
    Playlist playlist = new Playlist();
    
    Conexao conexao = new Conexao();
    try {
        Connection conn = conexao.getConnection();
        PlaylistDAO dao = new PlaylistDAO(conn);
       
        dao.editarNomeplaylist(playlist);
        JOptionPane.showMessageDialog(view, "Playlist editada com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException ex) {
        System.out.println(ex);
        JOptionPane.showMessageDialog(view, "Erro ao editar playlist!", "Erro", JOptionPane.ERROR_MESSAGE);}
    
    }
    
}
    
   
