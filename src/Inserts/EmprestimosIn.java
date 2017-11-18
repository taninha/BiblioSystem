/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserts;

import Conexão.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import ConnectTelas.Reserva;

/**
 *
 * @author Igor Oliveira
 */
public class EmprestimosIn {
    
    public List<Reserva> read(){
        
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Reserva> Reservas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Reserva");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Reserva Reserva = new Reserva();
                
                
                
                Reserva.setTítulo_livro(rs.getString("título_livro"));
                Reserva.setNome_usuario(rs.getString("nome_usuario"));
                Reserva.setCpf_usuario(rs.getString("cpf_usuario"));
                Reserva.setData_emprestimo(rs.getString("data_emprestimo"));

            
                Reservas.add(Reserva);
            
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
            
            ConexaoBD.closeConnection(con, stmt, rs);
        }
        
        return Reservas;  
        
        }
      
    public List<Reserva> readForDesc(String desc){
          
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Reserva> Reservas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Reserva  WHERE data_emprestimo LIKE ?");
            stmt.setString(1, "%"+desc+"%");

            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Reserva Reserva = new Reserva();
                
                
                
                Reserva.setTítulo_livro(rs.getString("título_livro"));
                Reserva.setNome_usuario(rs.getString("nome_usuario"));
                Reserva.setCpf_usuario(rs.getString("cpf_usuario"));
                Reserva.setData_emprestimo(rs.getString("data_emprestimo"));

            
                Reservas.add(Reserva);
            
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
            
            ConexaoBD.closeConnection(con, stmt, rs);
        }
        
        return Reservas;  
        
        }
    
}
