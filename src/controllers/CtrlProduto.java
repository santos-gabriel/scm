package controllers;

import dao.ProdutoDao;
import java.util.List;
import modelo.Produto;

/**
 * @author Gabriel
 */
public class CtrlProduto {
    
    public static Integer SalvarTodosCampos (Produto prProduto){
        return ProdutoDao.SalvarTodosCampos(prProduto);
    }
    
    public static void AtualizarTodosCampos(Produto prProduto){
        ProdutoDao.AtualizarTodosCampos(prProduto);
    }
    
    public static void Excluir(Produto prProduto){
        ProdutoDao.Excluir(prProduto.getCod_Produto());
    }
    
    public static Produto PesquisarViaCodigo(Produto prProduto){
        return ProdutoDao.PesquisarViaCodigo(prProduto.getCod_Produto());
    }
    
    public static List<Produto> PesquisarViaDescricaoExata(Produto prProduto){
        return ProdutoDao.PesquisarViaDescricaoExata(prProduto.getDesc_Produto());
    }
    
    public static List<Produto> PesquisarViaDescricaoInicia(Produto prProduto){
        return ProdutoDao.PesquisarViaDescricaoInicia(prProduto.getDesc_Produto());
    }
    
    public static List<Produto> PesquisarTodos(){
        return ProdutoDao.PesquisarTodos();
    }
    
}
