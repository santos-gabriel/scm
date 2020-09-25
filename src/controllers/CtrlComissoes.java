package controllers;

import dao.ComissoesDao;
import java.util.List;
import modelo.Comissoes;

/**
 * @author Gabriel
 */
public abstract class CtrlComissoes {
    
    public static void SalvarTodosCampos (Comissoes prComissoes){
        ComissoesDao.SalvarTodosCampos(prComissoes);
    }
    
    public static void AtualizarTodosCampos(Comissoes prComissoes){
        ComissoesDao.AtualizarTodosCampos(prComissoes);
    }
    
    public static void Excluir(Comissoes prCliente){
        ComissoesDao.Excluir(prCliente.getCod_comissao());
    }
    
    public static Comissoes PesquisarViaCodigo(Comissoes prComissoes){
        return ComissoesDao.PesquisarViaCodigo(prComissoes.getCod_comissao());
    }
    
    public static List<Comissoes> PesquisarTodos(){
        return ComissoesDao.PesquisarTodos();
    }
    
       
}
