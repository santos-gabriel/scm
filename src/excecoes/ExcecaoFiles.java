package excecoes;

import javax.swing.JOptionPane;
import mensagens.Erro;

/**
 * @author Gabriel
 */
public class ExcecaoFiles extends RuntimeException {
    
    public ExcecaoFiles(Exception e, String mensagem) {
        super(e);
        e.printStackTrace();
        Erro.show(mensagem);
        
    }
    
}
