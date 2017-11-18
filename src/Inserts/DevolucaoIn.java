/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserts;

import Conexão.ConexaoBD;
import ConnectTelas.Devolucao;
import ConnectTelas.Reserva;
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
public class DevolucaoIn {
    
    public void create(Devolucao d){
        
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Devolucao (titulo_livro, nome_usuario, cpf_usuario ,data_emprestimo, data_devolucao, data_entregue, multa_usuario)"
                    +"VALUES(?,?,?,?,?,?,?)");
            
            stmt.setString(1,d.getTitulo_livro());
            stmt.setString(2,d.getNome_usuario());
            stmt.setString(3,d.getCpf_usuario());
            stmt.setString(4,d.getData_emprestimo());
            stmt.setString(5,d.getData_devolucao());
            stmt.setString(6,d.getData_entregue());
            stmt.setDouble(7,d.getMulta_usuario());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso !");
                    
                    } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao cadastrar. "+ex);
        }finally{
        ConexaoBD.closeConnection(con,stmt);    
        }
}
    
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
        
        List<Reserva> Livros = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Reserva WHERE título_livro LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Reserva livro = new Reserva();
                
                livro.setTítulo_livro(rs.getString("título_livro"));
                livro.setNome_usuario(rs.getString("nome_usuario"));
                livro.setCpf_usuario(rs.getString("cpf_usuario"));
                livro.setData_emprestimo(rs.getString("data_emprestimo"));


            
                Livros.add(livro);
            
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
            
            ConexaoBD.closeConnection(con, stmt, rs);
        }
        
        return Livros;  

  }
    
}
