package controllers;

import dao.MovimentacaoUsuarioDao;
import modelo.MovimentacaoUsuario;

/**
 * @author Gabriel
 */
public class CtrlMovimentacaoUsuario {
    
    
    public static void SalvarTodosCampos (MovimentacaoUsuario prMovimentacaoUsuario){
        MovimentacaoUsuarioDao.SalvarTodosCampos(prMovimentacaoUsuario);
    }
    
    public static void AtualizarTodosCampos(MovimentacaoUsuario prMovimentacaoUsuario){
        MovimentacaoUsuarioDao.AtualizarTodosCampos(prMovimentacaoUsuario);
    }
        
}
