package excecoes;

import mensagens.Erro;

/**
 * @author Gabriel
 */
public class ExcecaoNetWork extends RuntimeException {
    
    public ExcecaoNetWork(Exception e, String mensagem) {
        super(e);
        e.printStackTrace();
        Erro.show(mensagem);
    }
    
}
