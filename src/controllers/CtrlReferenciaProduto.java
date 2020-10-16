package controllers;

import dao.ReferenciaProdutoDao;
import modelo.ReferenciaProduto;

/**
 * @author Gabriel
 */
public abstract class CtrlReferenciaProduto {
    
    public static void SalvarTodosCampos (ReferenciaProduto prReferenciaProduto){
        ReferenciaProdutoDao.SalvarTodosCampos(prReferenciaProduto);
    }
    
    public static void AtualizarTodosCampos(ReferenciaProduto prReferenciaProduto){
        ReferenciaProdutoDao.AtualizarTodosCampos(prReferenciaProduto);
    }
        
}
