package controllers;

import dao.CategoriasProdutosDao;
import java.util.List;
import modelo.CategoriasProdutos;

/**
 * @author Gabriel
 */
public class CtrlCategoriasProdutos {
    
    public static Integer SalvarTodosCampos (CategoriasProdutos prCategoriasProdutos){
        return CategoriasProdutosDao.SalvarTodosCampos(prCategoriasProdutos);
    }
    
    public static void AtualizarTodosCampos(CategoriasProdutos prCategoriasProdutos){
        CategoriasProdutosDao.AtualizarTodosCampos(prCategoriasProdutos);
    }
    
    public static void Excluir(CategoriasProdutos prCategoriasProdutos){
        CategoriasProdutosDao.Excluir(prCategoriasProdutos.getCod_Categoria());
    }
    
    public static CategoriasProdutos PesquisarViaCodigo(CategoriasProdutos prCategoriasProdutos){
        return CategoriasProdutosDao.PesquisarViaCodigo(prCategoriasProdutos.getCod_Categoria());
    }
    
    public static List<CategoriasProdutos> PesquisarViaDescricaoExata(CategoriasProdutos prCategoriasProdutos){
        return CategoriasProdutosDao.PesquisarViaDescricaoExata(prCategoriasProdutos.getDesc_Categoria());
    }
    
    public static List<CategoriasProdutos> PesquisarViaDescricaoInicia(CategoriasProdutos prCategoriasProdutos){
        return CategoriasProdutosDao.PesquisarViaDescricaoInicia(prCategoriasProdutos.getDesc_Categoria());
    }
    
    public static List<CategoriasProdutos> PesquisarTodos(){
        return CategoriasProdutosDao.PesquisarTodos();
    }
    
}
