/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.PessoaDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import spotifei.model.Usuario;
import spotifei.view.Interface_AltExc;
import spotifei.view.Interface_login;

/**
 *
 * @author hburi
 */
public class ControllerLogin {
    private Interface_login view;

    public ControllerLogin(Interface_login view) {
        this.view = view;
    }
    
    public void loginAluno(){
        Usuario aluno = new Usuario(null, 
                                view.getTxt_userLogin().getText(),
                                view.getTxt_senhalogin().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            ResultSet res = dao.consultar(aluno);
            if(res.next()){
                JOptionPane.showMessageDialog(view, 
                                              "Login efetuado!", 
                                              "Aviso",
                                              JOptionPane.INFORMATION_MESSAGE);
                Usuario aluno2 = new Usuario(res.getString("nome"), 
                                         res.getString("usuario"), 
                                         res.getString("senha"));
                Interface_AltExc aec = new Interface_AltExc(aluno2);
                aec.setVisible(true);
            } else{
                JOptionPane.showMessageDialog(view, 
                                              "Login NÃO efetuado!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
            }
        } catch(SQLException e){ 
            System.out.println(e);
            JOptionPane.showMessageDialog(view, 
                                              "Erro de conexão!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
        }
    }
}
