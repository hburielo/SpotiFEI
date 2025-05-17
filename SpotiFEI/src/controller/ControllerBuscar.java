/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import spotifei.model.Musica;
import spotifei.model.Usuario;
import spotifei.view.Interface_busca;
import java.sql.ResultSet;

/**
 *
 * @author hburi
 */

public class ControllerBuscar {
    private Interface_busca view;

    public ControllerBuscar(Interface_busca view){
        this.view = view;
    }

    public void Buscar() {
        String resultado = "";
        String nome = view.getTxt_nomebuscar().getText();
        String artista = view.getTxt_artistabuscar().getText().trim();
        String genero = view.getTxt_generobuscar().getText();
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            Musica musica = new Musica();
            musica.setTitulo(nome);
            musica.setGenero(genero);
            musica.setIdArtista(dao.buscarIdArtistaPorNome(artista));
            ResultSet rs = dao.consultarMusica(musica);
            while (rs.next()) {
                resultado += "Música: " + rs.getString("titulo") + " | Gênero: " + rs.getString("genero") + "\n";
            }
            if (resultado.isEmpty()) {
                resultado = "Nenhum resultado encontrado.";
            }
            view.getLbl_visor().setText(resultado);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(view, "Erro ao realizar a busca!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}