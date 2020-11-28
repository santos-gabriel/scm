package mensagens;
import javax.swing.JOptionPane;
/**
 * @author Gabriel
 */
public abstract class Informacao {
    
    public static void show(String pMensagem){
        JOptionPane.showMessageDialog(null, pMensagem, "Informação", 1);
    }
    
}
