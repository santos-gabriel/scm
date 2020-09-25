package controllers;

import dao.FornecedorDao;
import java.util.List;
import modelo.Fornecedor;

/**
 * @author Gabriel
 */
public class CtrlFornecedor {
    
    public static void SalvarTodosCampos (Fornecedor prFornecedor){
        FornecedorDao.SalvarTodosCampos(prFornecedor);
    }
    
    public static void AtualizarTodosCampos(Fornecedor prFornecedor){
        FornecedorDao.AtualizarTodosCampos(prFornecedor);
    }
    
    public static void Excluir(Fornecedor prFornecedor){
        FornecedorDao.Excluir(prFornecedor.getCod_Fornecedor());
    }
    
    public static List<Fornecedor> PesquisarTodos(){
        return FornecedorDao.PesquisarTodos();
    }
    
    public static Fornecedor PesquisarViaCodigo(Fornecedor prFornecedor){
        return FornecedorDao.PesquisarViaCodigo(prFornecedor.getCod_Fornecedor());
    }
    
    public static List<Fornecedor> PesquisarViaDescricaoExata(Fornecedor prFornecedor){
        return FornecedorDao.PesquisarViaDescricaoExata(prFornecedor.getNome_Fornecedor());
    }
    
    public static List<Fornecedor> PesquisarViaDescricaoInicia(Fornecedor prFornecedor){
        return FornecedorDao.PesquisarViaDescricaoInicia(prFornecedor.getNome_Fornecedor());
    }
    
}
