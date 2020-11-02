/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ProdutosVendaDao;
import modelo.ProdutosVenda;

/**
 *
 * @author Gabriel
 */
public abstract class CtrlProdutosVenda {
    
    public static void Inserir(ProdutosVenda prProdutosVenda){
        ProdutosVendaDao.Inserir(prProdutosVenda);
    }
    
}
