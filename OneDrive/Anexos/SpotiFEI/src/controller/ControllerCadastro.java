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
import spotifei.view.Interface_cadastro;
import spotifei.model.Usuario;

/**
 *
 * @author hburi
 */
public class ControllerCadastro {
    private Interface_cadastro view;

    public ControllerCadastro(Interface_cadastro view){ 
        this.view = view;
    }
    
    public void SalvarAluno(){
        String nome = view.getTxt_nomecad().getText();
        String usuario = view.getTxt_usuariocad().getText();
        String senha = view.getTxt_senhacad().getText();
        
        Usuario aluno = new Usuario(nome,usuario,senha);
    
    
    
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            dao.inserir(aluno);
            JOptionPane.showMessageDialog(view, "Usuario Cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(view, "Usuário não cadastrado!","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
           

}