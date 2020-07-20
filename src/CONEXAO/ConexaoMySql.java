/**
 * CLASSE RESPONSÁVEL POR REALIZAR A CONEXÃO COM O BANCO DE DADOS MYSQL
 */
package CONEXAO;
import UTILITARIOS.Funcoes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 * @author Gabriel
 */
public abstract class ConexaoMySql {
    
    public static Connection conectar (){
        try{
            Properties props = Funcoes.getProperties("src\\br\\com\\scm\\properties\\db.properties");        
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(props.getProperty("dburl"), props.getProperty("user"), props.getProperty("password"));            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Falha ao estabelecer conexão com banco de dados, entre em contato com o suporte do sistema!");
            e.printStackTrace();
            return null;
        }
    }
    
    public static void desconectar(Connection con){
        if (con != null){
            try {
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Falha ao fechar conexão com banco de dados, entre em contato com o suporte do sistema!");            
                e.printStackTrace();
            }
        }
    }
    
    public static void desconectar(Connection con, PreparedStatement stmt){
        desconectar(con);
        if (stmt != null){
            try {
                stmt.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Falha ao fechar conexão com banco de dados, entre em contato com o suporte do sistema!");            
                e.printStackTrace();
            }
        }
    }
    
    public static void desconectar(Connection con, PreparedStatement stmt, ResultSet rs){
        desconectar(con, stmt);
        if (rs != null){
            try {
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Falha ao fechar conexão com banco de dados, entre em contato com o suporte do sistema");            
                e.printStackTrace();
            }
        }
    }
    
    
}
