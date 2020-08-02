package controllers;

import dao.ProdutoDao;
import modelo.Produto;

/**
 * @author Gabriel
 */
public class CtrlProduto {
    
    public static void SalvarTodosCampos (Produto prProduto){
        ProdutoDao.SalvarTodosCampos(prProduto);
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
    
}
