/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectTelas;

/**
 *
 * @author Igor Oliveira
 */
public class Usuario {

        private int id_funcionario;
        private String nome_funcionario;
        private String usuario_funcionario;
        private String senha_funcionario;

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public String getUsuario_funcionario() {
        return usuario_funcionario;
    }

    public void setUsuario_funcionario(String usuario_funcionario) {
        this.usuario_funcionario = usuario_funcionario;
    }

    public String getSenha_funcionario() {
        return senha_funcionario;
    }

    public void setSenha_funcionario(String senha_funcionario) {
        this.senha_funcionario = senha_funcionario;
    }
        
}
