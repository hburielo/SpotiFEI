/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import spotifei.model.Playlist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import spotifei.model.Musica;

public class PlaylistDAO {

    private Connection connection;

    public PlaylistDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvarPlaylist(Playlist playlist, Musica musica) throws SQLException {
      String sql = "insert into tabela_playlist (nomeplaylist, titulo, genero) values ('"
                      + playlist.getNomeplaylist()    + "', '"
                      + musica.getTitulo().toLowerCase().trim() + "', '"
                      + musica.getGenero().toLowerCase().trim()   + "')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        connection.close();
    }
        public ResultSet consultar(Playlist playlist, Musica musica) throws SQLException{
        String sql = "select * from tabela_playlist where nomeplaylist = ? and titulo = ? AND genero =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, playlist.getNomeplaylist());
        statement.setString(2, musica.getTitulo().toLowerCase().trim());
         statement.setString(3, musica.getGenero().toLowerCase().trim());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
          public void removerPlaylist(Playlist playlist) throws SQLException{
        String sql = "delete from tabela_playlist where nomeplaylist = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, playlist.getNomeplaylist());
        statement.execute();
        connection.close();
    }
     public void adicionarMusicaNaPlaylist(Playlist playlist, Musica musica) throws SQLException {
    String sql = "INSERT INTO tabela_playlist (titulo) VALUES (?)";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, musica.getTitulo());
        

        statement.executeUpdate();
        }
    }
    
    public void editarNomeplaylist(Playlist playlist) throws SQLException{
    String sql= "RENAME from tabela_playlist WHERE nomeplaylist =?";
    PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, playlist.getNomeplaylist());
        statement.setString(2,playlist.getNomeplaylist());
        statement.execute();
        connection.close();
    }
}

