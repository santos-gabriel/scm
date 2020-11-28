/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ProdutosCompraDao;
import modelo.ProdutosCompra;

/**
 *
 * @author Gabriel
 */
public abstract class CtrlProdutosCompra {
    
    public static void Inserir(ProdutosCompra prProdutosCompra){
        ProdutosCompraDao.Inserir(prProdutosCompra);
    }
    
}
