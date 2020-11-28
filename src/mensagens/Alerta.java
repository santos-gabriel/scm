package mensagens;
import javax.swing.JOptionPane;
/**
 * @author Gabriel
 */
public abstract class Alerta {
    
    public static void show(String pMensagem){
        JOptionPane.showMessageDialog(null, pMensagem, "Alerta", 2);
    }
    
}
