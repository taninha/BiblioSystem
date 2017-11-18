/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserts;

import Conexão.ConexaoBD;
import ConnectTelas.Leitor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 * @author Igor Oliveira
 */
public class LeitorIn {
   
    
    public void create(Leitor p){
        
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO leitor(nome_leitor,cpf_leitor,dataNascimento_leitor,sexo_leitor,"
                    + "formacao_leitor,email_leitor,telefone_leitor,celular_leitor,logradouro_leitor,numero_leitor,bairro_leitor,"
                    + "cidade_leitor,estado_leitor,cep_leitor) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,p.getNome_leitor());
            stmt.setString(2,p.getCpf_leitor());
            stmt.setString(3,p.getDataNascimento());
            stmt.setString(4,p.getSexo_leitor());
            stmt.setString(5,p.getFormacao_leitor());
            stmt.setString(6,p.getEmail_leitor());
            stmt.setString(7,p.getTelefone_leitor());
            stmt.setString(8,p.getCelular_leitor());
            stmt.setString(9,p.getLogradouro_leitor());
            stmt.setString(10,p.getNumero_leitor());
            stmt.setString(11,p.getBairro_leitor());
            stmt.setString(12,p.getCidade_leitor());
            stmt.setString(13,p.getEstado_leitor());
            stmt.setString(14,p.getCep_leitor());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
                    
                    } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
        ConexaoBD.closeConnection(con,stmt);    
        }
        
    }
  
    
    public List<Leitor> read(){
        
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Leitor> leitores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM leitor");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Leitor leitor = new Leitor();
                
                leitor.setId_leitor(rs.getInt("id_leitor"));
                leitor.setNome_leitor(rs.getString("nome_leitor"));
                leitor.setCpf_leitor(rs.getString("cpf_leitor"));
                leitor.setDataNascimento(rs.getString("dataNascimento_leitor"));
                leitor.setSexo_leitor(rs.getString("sexo_leitor"));
                leitor.setFormacao_leitor(rs.getString("formacao_leitor"));
                leitor.setEmail_leitor(rs.getString("email_leitor"));
                leitor.setTelefone_leitor(rs.getString("telefone_leitor"));
                leitor.setCelular_leitor(rs.getString("celular_leitor"));
                leitor.setLogradouro_leitor(rs.getString("logradouro_leitor"));
                leitor.setNumero_leitor(rs.getString("numero_leitor"));
                leitor.setBairro_leitor(rs.getString("bairro_leitor"));
                leitor.setCidade_leitor(rs.getString("cidade_leitor"));
                leitor.setEstado_leitor(rs.getString("estado_leitor"));
                leitor.setCep_leitor(rs.getString("cep_leitor"));
            
                leitores.add(leitor);
            
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
            
            ConexaoBD.closeConnection(con, stmt, rs);
        }
        
        return leitores;
    }
   

    public List<Leitor> readForDesc(String desc){
        
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Leitor> leitores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM leitor  WHERE nome_leitor LIKE ?");
            stmt.setString(1,"%"+desc+"%");
            
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Leitor leitor = new Leitor();
                
                leitor.setId_leitor(rs.getInt("id_leitor"));
                leitor.setNome_leitor(rs.getString("nome_leitor"));
                leitor.setCpf_leitor(rs.getString("cpf_leitor"));
                leitor.setDataNascimento(rs.getString("dataNascimento_leitor"));
                leitor.setSexo_leitor(rs.getString("sexo_leitor"));
                leitor.setFormacao_leitor(rs.getString("formacao_leitor"));
                leitor.setEmail_leitor(rs.getString("email_leitor"));
                leitor.setTelefone_leitor(rs.getString("telefone_leitor"));
                leitor.setCelular_leitor(rs.getString("celular_leitor"));
                leitor.setLogradouro_leitor(rs.getString("logradouro_leitor"));
                leitor.setNumero_leitor(rs.getString("numero_leitor"));
                leitor.setBairro_leitor(rs.getString("bairro_leitor"));
                leitor.setCidade_leitor(rs.getString("cidade_leitor"));
                leitor.setEstado_leitor(rs.getString("estado_leitor"));
                leitor.setCep_leitor(rs.getString("cep_leitor"));
            
                leitores.add(leitor);
            
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar: "+ex);
        }finally{
            
            ConexaoBD.closeConnection(con, stmt, rs);
        }
        
        return leitores;
    }
   
    public void update(Leitor p){
        
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE leitor SET nome_leitor = ? , sexo_leitor = ? , dataNascimento_leitor = ?,"
                    + " formacao_leitor = ? , email_leitor = ? , telefone_leitor = ? , celular_leitor = ?,"
                    + " logradouro_leitor = ? , numero_leitor = ? , bairro_leitor = ? , cidade_leitor = ? ,"
                    + " estado_leitor = ? , cep_leitor = ? WHERE id_leitor = ?");
            stmt.setString(1,p.getNome_leitor());
            stmt.setString(2,p.getSexo_leitor());
            stmt.setString(3,p.getDataNascimento());
            stmt.setString(4,p.getFormacao_leitor());
            stmt.setString(5,p.getEmail_leitor());
            stmt.setString(6,p.getTelefone_leitor());
            stmt.setString(7,p.getCelular_leitor());
            stmt.setString(8,p.getLogradouro_leitor());
            stmt.setString(9,p.getNumero_leitor());
            stmt.setString(10,p.getBairro_leitor());
            stmt.setString(11,p.getCidade_leitor());
            stmt.setString(12,p.getEstado_leitor());
            stmt.setString(13,p.getCep_leitor());
            stmt.setInt(14,p.getId_leitor());
                       
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso");
                    
                    } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao atualizar: "+ex);
        }finally{
        ConexaoBD.closeConnection(con,stmt);    
        }
        
    }
    
    
    public void delete(Leitor p){
        
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM leitor WHERE id_leitor = ?");
            stmt.setInt(1,p.getId_leitor());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Excluido com sucesso");
                    
                    } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao excluir: "+ex);
        }finally{
        ConexaoBD.closeConnection(con,stmt);    
        }
        
    }
    
   
   
}
