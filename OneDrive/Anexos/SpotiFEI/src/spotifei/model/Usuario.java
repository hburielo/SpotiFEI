/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spotifei.model;

/**
 *
 * @author hburi
 */
public class Usuario extends Pessoa{
    private String usuario,senha;

    public Usuario(String nome, String usuario, String senha) {
        super(nome);
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario() {
        super("");
    }

   

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

   

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + getNome() + ", usuario=" + usuario + ", senha=" + senha + '}';
    }
    
    
    
}
