package mensagens;
import javax.swing.JOptionPane;
/**
 * @author Gabriel
 */
public abstract class Confirmacao {
    
    public static boolean show(String pMensagem){
        return JOptionPane.showConfirmDialog(null, pMensagem, "Confirmação", 3, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;        
    }
    
}
