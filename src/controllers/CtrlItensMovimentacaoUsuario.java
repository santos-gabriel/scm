package controllers;

import dao.ItensMovimentacaoUsuarioDao;
import java.util.List;
import modelo.ItensMovimentacaoUsuario;

/**
 * @author Gabriel
 */
public class CtrlItensMovimentacaoUsuario {
    
    public static void SalvarTodosCampos (ItensMovimentacaoUsuario prItensMovimentacaoUsuario){
        ItensMovimentacaoUsuarioDao.SalvarTodosCampos(prItensMovimentacaoUsuario);
    }
    
    public static void AtualizarTodosCampos(ItensMovimentacaoUsuario prItensMovimentacaoUsuario){
        ItensMovimentacaoUsuarioDao.AtualizarTodosCampos(prItensMovimentacaoUsuario);
    }
    
     
}
