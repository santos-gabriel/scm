/**
 * CLASSE RESPONSÁVEL POR REALIZAR A CONEXÃO COM O BANCO DE DADOS MYSQL
 */
package br.com.scm.conexao;
import br.com.scm.utilitarios.Funcoes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Gabriel
 */
public abstract class ConexaoMySql {
    
    
    
    public static Connection getConnection (){
        String path = "src\\br\\com\\scm\\properties\\db.properties";
        try{
            Properties props = Funcoes.getPropertie(path);
            String url = props.getProperty("dburl");
            return DriverManager.getConnection(url, props); 
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static void closeConnection(Connection con){
        if (con != null){
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
