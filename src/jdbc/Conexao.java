package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Onacio
 */
public class Conexao {
        
    public Connection pegarConexao(){        
        try {            
            return DriverManager.getConnection("jdbc:sqlite:banco_dados.db");            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco " + e.getMessage());            
        }
        JOptionPane.showMessageDialog(null, "Conectou com o banco");
        return null;
    }    
}