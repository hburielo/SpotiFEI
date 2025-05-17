/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.PessoaDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import spotifei.model.Usuario;
import spotifei.view.Interface_AltExc;

/**
 *
 * @author hburi
 */
public class ControllerUsuario {
    private Interface_AltExc view;
    private Usuario usuario;

    public ControllerUsuario(Interface_AltExc view, Usuario aluno) {
        this.view = view;
        this.usuario = aluno;
    }
    
    public void atualizar(){
        String novaSenha = view.getTxt_senha_altexc().getText();
        String usuario = view.getLbl_usuario_altexc().getText();
        Usuario aluno = new Usuario("", usuario, novaSenha);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            dao.atualizar(aluno);
            JOptionPane.showMessageDialog(view, "Senha de Usuário atualizada com Sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Falha de conexão!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void remover(){
        String usuario = this.usuario.getUsuario();
        int option = JOptionPane.showConfirmDialog(view, "Deseja realmente excluir o cadastro",
                "Aviso", JOptionPane.YES_NO_OPTION);
        if(option != 1){
            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                PessoaDAO dao = new PessoaDAO(conn);
                dao.remover(this.usuario);
                JOptionPane.showMessageDialog(view, "Usuario removido com Sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(view, "Falha de conexão!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
