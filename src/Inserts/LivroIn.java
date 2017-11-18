/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserts;

import Conexão.ConexaoBD;
import ConnectTelas.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Igor Oliveira
 */
public class LivroIn {
    
    public void create(Livro c){
        
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO livro(titulo_livro,autor_livro,genero_livro,anoPubli_livro,editora_livro,numeroPag_livro,"
                    + "isbn_livro,codBarras_livro) VALUES(?,?,?,?,?,?,?,?)");
            stmt.setString(1,c.getTitulo_livro());
            stmt.setString(2,c.getAutor_livro());
            stmt.setString(3,c.getGenero_livro());
            stmt.setString(4,c.getAnoPubli_livro());
            stmt.setString(5,c.getEditora_livro());
            stmt.setString(6,c.getNumeroPag_livro());
            stmt.setString(7,c.getIsbn_livro());
            stmt.setString(8,c.getCodBarras_livro());


            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
                    
                    } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
        ConexaoBD.closeConnection(con,stmt);    
        }
        
    }
    
    
    public List<Livro> read(){
        
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Livro> livros = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM livro");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Livro Livro = new Livro();
                
                Livro.setId_livro(rs.getInt("id_livro"));
                Livro.setTitulo_livro(rs.getString("titulo_livro"));
                Livro.setAutor_livro(rs.getString("autor_livro"));
                Livro.setGenero_livro(rs.getString("genero_livro"));
                Livro.setAnoPubli_livro(rs.getString("anoPubli_livro"));
                Livro.setEditora_livro(rs.getString("editora_livro"));
                Livro.setNumeroPag_livro(rs.getString("numeroPag_livro"));
                Livro.setIsbn_livro(rs.getString("isbn_livro"));
                Livro.setCodBarras_livro(rs.getString("codBarras_livro"));
                
            
                livros.add(Livro);
            
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
            
            ConexaoBD.closeConnection(con, stmt, rs);
        }
        
        return livros;
    }
    

    public List<Livro> readForDesc(String desc){
        
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Livro> livros = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM livro  WHERE titulo_livro LIKE ?");
            stmt.setString(1,"%"+desc+"%");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Livro Livro = new Livro();
                
                Livro.setId_livro(rs.getInt("id_livro"));
                Livro.setTitulo_livro(rs.getString("titulo_livro"));
                Livro.setAutor_livro(rs.getString("autor_livro"));
                Livro.setGenero_livro(rs.getString("genero_livro"));
                Livro.setAnoPubli_livro(rs.getString("anoPubli_livro"));
                Livro.setEditora_livro(rs.getString("editora_livro"));
                Livro.setNumeroPag_livro(rs.getString("numeroPag_livro"));
                Livro.setIsbn_livro(rs.getString("isbn_livro"));
                Livro.setCodBarras_livro(rs.getString("codBarras_livro"));
                
            
                livros.add(Livro);
            
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
            
            ConexaoBD.closeConnection(con, stmt, rs);
        }
        
        return livros;
    }
    
    public void update(Livro c){
        
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE livro SET titulo_livro = ?,autor_livro = ?,genero_livro = ?,anoPubli_livro = ?,editora_livro = ?,numeroPag_livro = ?,"
                    + "isbn_livro = ?,codBarras_livro = ? WHERE id_livro = ?");
           
            stmt.setString(1,c.getTitulo_livro());
            stmt.setString(2,c.getAutor_livro());
            stmt.setString(3,c.getGenero_livro());
            stmt.setString(4,c.getAnoPubli_livro());
            stmt.setString(5,c.getEditora_livro());
            stmt.setString(6,c.getNumeroPag_livro());
            stmt.setString(7,c.getIsbn_livro());
            stmt.setString(8,c.getCodBarras_livro());
            stmt.setInt(9,c.getId_livro());


            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso !");
                    
                    } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
        ConexaoBD.closeConnection(con,stmt);    
        }
        
    }
    
    public void delete(Livro c){
        
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM livro WHERE id_livro = ?");
            
            
            stmt.setInt(1,c.getId_livro());


            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Excluido com sucesso !");
                    
                    } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao excluir: "+ex);
        }finally{
        ConexaoBD.closeConnection(con,stmt);    
        }
        
    }
    
}


