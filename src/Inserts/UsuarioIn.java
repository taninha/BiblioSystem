package Inserts;

import Conexão.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Igor Oliveira
 */
public class UsuarioIn {
    
    public boolean checkLogin(String login, String senha){
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM funcionario WHERE usuario_funcionario = ? and senha_funcionario = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if(rs.next()){
               
                check = true;
                
                }
        } catch(SQLException ex){
            Logger.getLogger(UsuarioIn.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConexaoBD.closeConnection(con, stmt, rs);
        }
        return check;
    }
    
    
    
    
}
