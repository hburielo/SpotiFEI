/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import spotifei.model.Usuario;
import spotifei.model.Musica;

/**
 *
 * @author hburi
 */


public class PessoaDAO {
    private Connection conn;

    public PessoaDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Usuario usuario) throws SQLException{
        String sql = "select * from tabela_aluno where usuario = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void inserir(Usuario usuario) throws SQLException{
        String sql = "insert into tabela_aluno (nome, usuario, senha) values ('"
                      + usuario.getNome()    + "', '"
                      + usuario.getUsuario() + "', '"
                      + usuario.getSenha()   + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public void atualizar(Usuario usuario) throws SQLException{
        String sql = "update aluno set senha = ? where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getSenha());
        statement.setString(2, usuario.getUsuario());
        statement.execute();
        conn.close();
    }
    
    public void remover(Usuario usuario) throws SQLException{
        String sql = "delete from aluno where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.execute();
        conn.close();
    }

   
    public ResultSet consultarMusica(Musica musica) throws SQLException {
    StringBuilder sql = new StringBuilder("SELECT * FROM tabela_musica WHERE 1=1");
    if (musica.getTitulo() != null && !musica.getTitulo().isEmpty()) {
        sql.append(" AND LOWER(titulo) LIKE ?");
    }
    if (musica.getGenero() != null && !musica.getGenero().isEmpty()) {
        sql.append(" AND LOWER(genero) LIKE ?");
    }
    if (musica.getIdArtista() != -1) {
        sql.append(" AND idartista = ?");
    }

    PreparedStatement statement = conn.prepareStatement(sql.toString());
    int paramIndex = 1;

    if (musica.getTitulo() != null && !musica.getTitulo().isEmpty()) {
        statement.setString(paramIndex++, "%" + musica.getTitulo().toLowerCase().trim() + "%");
    }
    if (musica.getGenero() != null && !musica.getGenero().isEmpty()) {
        statement.setString(paramIndex++, "%" + musica.getGenero().toLowerCase().trim() + "%");
    }
    if (musica.getIdArtista() != -1) {
        statement.setInt(paramIndex++, musica.getIdArtista());
    }

    return statement.executeQuery();
}

public int buscarIdArtistaPorNome(String nomeArtista) throws SQLException {
    if (nomeArtista == null || nomeArtista.trim().isEmpty()) {
        return -1;
    }
    String sql = "SELECT id FROM artista WHERE LOWER(nome_artistico) = ?";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, nomeArtista.toLowerCase().trim());
    ResultSet rs = statement.executeQuery();
    return rs.next() ? rs.getInt("id") : -1;
}
}

