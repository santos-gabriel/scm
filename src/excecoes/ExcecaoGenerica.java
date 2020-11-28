package excecoes;

import mensagens.Erro;

/**
 *
 * @author Gabriel
 */
public class ExcecaoGenerica extends RuntimeException{
    
    public ExcecaoGenerica(Exception e){
        super(e);
        e.printStackTrace();
    }
    
    public ExcecaoGenerica(Exception e, String menssagem){
        super(e);
        e.printStackTrace();
        Erro.show(menssagem);
    }
    
}
