package conexao;
import excecoes.ExcecaoDB;
import utilitarios.Funcoes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * @author Gabriel
 */
public abstract class Conexao {
    
    public static Connection conectar (){
        try{
            // JOptionPane.showMessageDialog(null, System.getProperty("user.dir")+"\\src\\propriedades\\db.properties");
            Properties props = Funcoes.getProperties(System.getProperty("user.dir")+"\\src\\propriedades\\db.properties");        
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(props.getProperty("dburl"), props.getProperty("user"), props.getProperty("password"));            
        }catch(Exception e){
            throw new ExcecaoDB(e, "Falha ao estabeleceer conexão com banco de dados, entre em contato com o suporte do sistema");
        }
    }
    
    public static void desconectar(Connection con){
        if (con != null){
            try {
                con.close();
            } catch (Exception e) {
                throw new ExcecaoDB(e, "Falha ao fechar conexão com banco de dados, entre em contato com o suporte do sistema");
            }
        }
    }
    
    public static void desconectar(Connection con, PreparedStatement stmt){
        desconectar(con);
        if (stmt != null){
            try {
                stmt.close();
            } catch (Exception e) {
                throw new ExcecaoDB(e, "Falha ao fechar conexão com banco de dados, entre em contato com o suporte do sistema");
            }
        }
    }
    
    public static void desconectar(Connection con, PreparedStatement stmt, ResultSet rs){
        desconectar(con, stmt);
        if (rs != null){
            try {
                rs.close();
            } catch (Exception e) {
                throw new ExcecaoDB(e, "Falha ao fechar conexão com banco de dados, entre em contato com o suporte do sistema");
            }
        }
    }
    
    
}
