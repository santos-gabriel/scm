package controllers;

import dao.LoginSessaoDao;
import modelo.LoginSessao;

/**
 * @author Gabriel
 */
public class CtrlLoginSessao {
    
    public static void SalvarTodosCampos (LoginSessao prLoginSessao){
        LoginSessaoDao.SalvarTodosCampos(prLoginSessao);
    }
    
    public static void AtualizarTodosCampos(LoginSessao prLoginSessao){
        LoginSessaoDao.AtualizarTodosCampos(prLoginSessao);
    }
        
}
