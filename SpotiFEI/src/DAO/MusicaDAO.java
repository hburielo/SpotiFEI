/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import spotifei.model.Musica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MusicaDAO {

    private Connection connection;

    public MusicaDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvarMusica(Musica musica, int playlistId) throws SQLException {
        String sql = "INSERT INTO musicas (titulo, genero, idArtista) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, musica.getTitulo());
            stmt.setString(2, musica.getGenero());
            stmt.setInt(3, musica.getIdArtista());
            stmt.executeUpdate();

            var rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int musicaId = rs.getInt(1);
                associarMusicaPlaylist(musicaId, playlistId);
            }
        }
    }

    private void associarMusicaPlaylist(int musicaId, int playlistId) throws SQLException {
        String sql = "INSERT INTO playlist_musicas (idPlaylist, idMusica) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, playlistId);
            stmt.setInt(2, musicaId);
            stmt.executeUpdate();
        }
    }
}
