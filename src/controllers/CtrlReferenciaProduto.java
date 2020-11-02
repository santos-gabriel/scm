package controllers;

import dao.ReferenciaProdutoDao;
import java.util.List;
import modelo.Produto;
import modelo.ReferenciaProduto;

/**
 * @author Gabriel
 */
public abstract class CtrlReferenciaProduto {
    
    public static Integer Inserir(ReferenciaProduto prReferenciaProduto){
        return ReferenciaProdutoDao.Inserir(prReferenciaProduto);
    }
    
    public static void Atualizar(ReferenciaProduto prReferenciaProduto){
        ReferenciaProdutoDao.Atualizar(prReferenciaProduto);
    }
        
    public static List<ReferenciaProduto> PesquisaTodosAtivosViaCodProduto(Produto prProduto){
        return ReferenciaProdutoDao.PesquisaTodosAtivosViaCodProduto(prProduto);
    }
    
    public static List<ReferenciaProduto> PesquisaAtivosViaCodProduto(Produto prProduto, Integer prQuantidade){
        return ReferenciaProdutoDao.PesquisaAtivosViaCodProduto(prProduto, prQuantidade);
    }
}
