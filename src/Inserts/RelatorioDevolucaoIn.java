/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserts;

import Conexão.ConexaoBD;
import ConnectTelas.Devolucao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class RelatorioDevolucaoIn {
    
      public List<Devolucao> read(){
        
Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Devolucao> Devolucoes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Devolucao");
            rs = stmt.executeQuery();
            

            
            while(rs.next()){
                
                Devolucao Devolucao = new Devolucao();
                
               Devolucao.setTitulo_livro(rs.getString("titulo_livro"));
                Devolucao.setNome_usuario(rs.getString("nome_usuario"));
                Devolucao.setCpf_usuario(rs.getString("cpf_usuario"));
                Devolucao.setData_emprestimo(rs.getString("data_emprestimo"));
                Devolucao.setData_devolucao(rs.getString("data_devolucao"));
                Devolucao.setData_entregue(rs.getString("data_entregue"));
                Devolucao.setMulta_usuario(rs.getDouble("multa_usuario"));


            
                Devolucoes.add(Devolucao);
            
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
            
            ConexaoBD.closeConnection(con, stmt, rs);
        }
        
        return Devolucoes;  

  }
    
    
    public List<Devolucao> readForDesc(String desc){
          
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Devolucao> Devolucoes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Reserva WHERE título_livro LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Devolucao Devolucao = new Devolucao();
                
               Devolucao.setTitulo_livro(rs.getString("titulo_livro"));
                Devolucao.setNome_usuario(rs.getString("nome_usuario"));
                Devolucao.setCpf_usuario(rs.getString("cpf_usuario"));
                Devolucao.setData_emprestimo(rs.getString("data_emprestimo"));
                Devolucao.setData_devolucao(rs.getString("data_devolucao"));
                Devolucao.setData_entregue(rs.getString("data_entregue"));
                Devolucao.setMulta_usuario(rs.getDouble("multa_usuario"));


            
                Devolucoes.add(Devolucao);
            
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
            
            ConexaoBD.closeConnection(con, stmt, rs);
        }
        
        return Devolucoes;  

  }
    
    
}
