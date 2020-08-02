package excecoes;

import mensagens.Erro;

/**
 * @author Gabriel
 */
public class ExcecaoDB  extends RuntimeException {
    
    public ExcecaoDB(Exception e, String mensagem) {
        super(e);
        e.printStackTrace();
        Erro.show(mensagem);
    }
    
}
