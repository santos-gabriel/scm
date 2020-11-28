package mensagens;
import javax.swing.JOptionPane;
/**
 * @author Gabriel
 */
public abstract class Confirmacao {
    
    public static boolean show(String pMensagem){
        Object[] options = { "Confirmar", "Cancelar" };
        return JOptionPane.showOptionDialog(null, pMensagem, "Confirmação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0;        
    }
    
}
