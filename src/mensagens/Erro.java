package mensagens;
import javax.swing.JOptionPane;
/**
 * @author Gabriel
 */
public abstract class Erro {
    
    public static void show(String pMensagem){        
        JOptionPane.showMessageDialog(null, pMensagem, "Erro", 0);
    }
    
}
