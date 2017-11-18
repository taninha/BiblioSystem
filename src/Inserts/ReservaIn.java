/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserts;

import ConnectTelas.Livro;
import Conexão.ConexaoBD;
import ConnectTelas.Leitor;

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
 * @author 8994213
 */
public class ReservaIn {
    public void create(Reserva r){
        
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Reserva (nome_usuario, cpf_usuario, título_livro, data_emprestimo)"
                    +"VALUES(?,?,?,?)");
            
            stmt.setString(1,r.getNome_usuario());
            stmt.setString(2,r.getCpf_usuario());
            stmt.setString(3,r.getTítulo_livro());
            stmt.setString(4,r.getData_emprestimo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso !");
                    
                    } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao cadastrar. "+ex);
        }finally{
        ConexaoBD.closeConnection(con,stmt);    
        }
}
    
  public List<Livro> read(){
        
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Livro> Livros = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM livro");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Livro Livro = new Livro();
                
                Livro.setTitulo_livro(rs.getString("titulo_livro"));
                Livro.setAutor_livro(rs.getString("autor_livro"));
                 Livro.setNumeroPag_livro(rs.getString("numeroPag_livro"));
                Livro.setCodBarras_livro(rs.getString("codBarras_livro"));

            
                Livros.add(Livro);
            
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
            
            ConexaoBD.closeConnection(con, stmt, rs);
        }
        
        return Livros;  
        
  }
  public List<Leitor> read2(){
        
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Leitor> leitores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM leitor");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Leitor leitor = new Leitor();
                
                
                leitor.setNome_leitor(rs.getString("nome_leitor"));
                leitor.setCpf_leitor(rs.getString("cpf_leitor"));
                leitor.setEmail_leitor(rs.getString("email_leitor"));
                leitor.setCelular_leitor(rs.getString("celular_leitor"));
                
            
                leitores.add(leitor);
            
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
            
            ConexaoBD.closeConnection(con, stmt, rs);
        }
        
        return leitores;
    }
  
  
  
  public List<Livro> readForDesc(String desc){
          
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Livro> Livros = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM livro WHERE titulo_livro LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Livro livro = new Livro();
                
                livro.setTitulo_livro(rs.getString("titulo_livro"));
                livro.setAutor_livro(rs.getString("autor_livro"));
                livro.setNumeroPag_livro(rs.getString("numeroPag_livro"));
                livro.setCodBarras_livro(rs.getString("CodBarras_livro"));

            
                Livros.add(livro);
            
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
            
            ConexaoBD.closeConnection(con, stmt, rs);
        }
        
        return Livros;  

  }

public List<Leitor> readForDesc2(String desc2){
          
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Leitor> Leitores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM leitor WHERE nome_leitor LIKE ?");
            stmt.setString(1, "%"+desc2+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Leitor leitor = new Leitor();
                
                leitor.setNome_leitor(rs.getString("nome_leitor"));
                leitor.setCpf_leitor(rs.getString("cpf_leitor"));
                leitor.setEmail_leitor(rs.getString("email_leitor"));
                leitor.setCelular_leitor(rs.getString("celular_leitor"));
                

            
                Leitores.add(leitor);
            
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
            
            ConexaoBD.closeConnection(con, stmt, rs);
        }
        
        return Leitores;  

  }
}
