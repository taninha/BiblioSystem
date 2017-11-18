
package Inserts;

import Conexão.ConexaoBD;
import ConnectTelas.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FuncionarioIn {
    public void create (Funcionario f){
        
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
      
        try {
            stmt = con.prepareStatement("INSERT INTO funcionario(nome_funcionario,cpf_funcionario,dataNascimento_funcionario,"
                      + "sexo_funcionario,formacao_funcionario,email_funcionario,telefone_funcionario,celular_funcionario,logradouro_funcionario,"
                      + "numero_funcionario,bairro_funcionario,cidade_funcionario,estado_funcionario,cep_funcionario,salario_funcionario,dataAdmissao_funcionario,usuario_funcionario,senha_funcionario)"
                      +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            stmt.setString(1,f.getNome_funcionario());
            stmt.setString(2,f.getCpf_funcionario());
            stmt.setString(3,f.getDataNascimento_funcionario());
            stmt.setString(4,f.getSexo_funcionario());
            stmt.setString(5,f.getFormacao_funcionario());
            stmt.setString(6,f.getEmail_funcionario());
            stmt.setString(7,f.getTelefone_funcionario());
            stmt.setString(8,f.getCelular_funcionario());
            stmt.setString(9,f.getLogradouro_funcionario());
            stmt.setString(10,f.getNumero_funcionario());
            stmt.setString(11,f.getBairro_funcionario());
            stmt.setString(12,f.getCidade_funcionario());
            stmt.setString(13,f.getEstado_funcionario());
            stmt.setString(14,f.getCep_funcionario());
            stmt.setDouble(15,f.getSalario_funcionario());
            stmt.setString(16,f.getDataAdmissao_funcionario());
            stmt.setString(17,f.getUsuario_funcionario());
            stmt.setString(18,f.getSenha_usuario());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso !");
    }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao cadastrar. "+ex);
        }finally{
        ConexaoBD.closeConnection(con,stmt);   
        
    }
    }
}


