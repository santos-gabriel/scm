package controllers;

import dao.TipoPagamentoDao;
import java.util.List;
import modelo.TipoPagamento;

/**
 * @author Gabriel
 */
public abstract class CtrlTipoPagamento {
    
    public static void SalvarTodosCampos (TipoPagamento prTipoPagamento){
        TipoPagamentoDao.SalvarTodosCampos(prTipoPagamento);
    }
    
    public static void AtualizarTodosCampos(TipoPagamento prTipoPagamento){
        TipoPagamentoDao.AtualizarTodosCampos(prTipoPagamento);
    }
    
    public static void Excluir (TipoPagamento  prTipoPagamento){
        TipoPagamentoDao.Excluir(prTipoPagamento.getCod_pagamento());
    }
    
    public static TipoPagamento PesquisarViaCodigo (TipoPagamento prTipoPagamento){
        return TipoPagamentoDao.PesquisarViaCodigo(prTipoPagamento.getCod_pagamento());
    }
    
    public static List<TipoPagamento> PesquisarTodos(){
        return TipoPagamentoDao.PesquisarTodos();
    }

}
