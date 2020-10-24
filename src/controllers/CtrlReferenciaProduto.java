package controllers;

import dao.ReferenciaProdutoDao;
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
        
}
