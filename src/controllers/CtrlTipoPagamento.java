package controllers;

import dao.TipoPagamentoDao;
import modelo.TipoPagamento;

/**
 * @author Gabriel
 */
public class CtrlTipoPagamento {
    
    public static void SalvarTodosCampos (TipoPagamento prTipoPagamento){
        TipoPagamentoDao.SalvarTodosCampos(prTipoPagamento);
    }
    
    public static void AtualizarTodosCampos(TipoPagamento prTipoPagamento){
        TipoPagamentoDao.AtualizarTodosCampos(prTipoPagamento);
    }
        
}
