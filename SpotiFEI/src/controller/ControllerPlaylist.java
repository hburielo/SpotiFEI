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
import spotifei.view.Interface_criaplaylist;
import spotifei.model.Playlist;
import spotifei.model.Musica;
import spotifei.view.Interface_editarplaylist;

/**
 *
 * @author hburi
 */
public class ControllerPlaylist {
    
    private Interface_criaplaylist view;
   

    public ControllerPlaylist(Interface_criaplaylist view){ 
        this.view = view;
    }
    public void CriaPlaylist(){
        String nomeplaylist = view.getTxt_nomeplaylist().getText();
        String titulo = view.getTxt_addmusicaplaylist().getText();
        String genero= view.getTxt_addgenero().getText();
        if (nomeplaylist.isEmpty()) {
        System.out.println("O nome da playlist não pode estar vazio.");
        return;
    }
    
    if (titulo.isEmpty()) {
        System.out.println("O título da música não pode estar vazio.");
        return;
    }
        Playlist playlist = new Playlist(nomeplaylist);
        Musica musica = new Musica(0,titulo,genero,0);
        
         Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            dao.salvarPlaylist(playlist,musica);
            JOptionPane.showMessageDialog(view, "Playlist Cadastrada!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(view, "Playlist não cadastrada!","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    
}
