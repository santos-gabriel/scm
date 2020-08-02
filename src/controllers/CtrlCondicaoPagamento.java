package controllers;

import dao.CondicaoPagamentoDao;
import modelo.CondicaoPagamento;

/**
 * @author Gabriel
 */
public class CtrlCondicaoPagamento {
    
    public static void SalvarTodosCampos (CondicaoPagamento prCondicaoPagamento){
        CondicaoPagamentoDao.SalvarTodosCampos(prCondicaoPagamento);
    }
    
    public static void AtualizarTodosCampos(CondicaoPagamento prCondicaoPagamento){
        CondicaoPagamentoDao.AtualizarTodosCampos(prCondicaoPagamento);
    }
    
    public static void Excluir(CondicaoPagamento prCondicaoPagamento){
        CondicaoPagamentoDao.Excluir(prCondicaoPagamento.getCod_condicao_pagamento());
    }
    
    public static CondicaoPagamento PesquisarViaCodigo(CondicaoPagamento prCondicaoPagamento){
        return CondicaoPagamentoDao.PesquisarViaCodigo(prCondicaoPagamento.getCod_condicao_pagamento());
    }
    
        
}
