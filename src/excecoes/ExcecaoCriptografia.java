package excecoes;

import mensagens.Erro;

/**
 * @author Gabriel
 */
public class ExcecaoCriptografia extends RuntimeException {
    
    public ExcecaoCriptografia(Exception e, String mensagem) {
        super(e);
        e.printStackTrace();
        Erro.show(mensagem);
    }
    
}
