/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ComprasDao;
import java.util.List;
import modelo.Compras;
import modelo.Fornecedor;
import modelo.Produto;

/**
 *
 * @author Gabriel
 */
public abstract class CtrlCompras {
    
    public static Integer Inserir (Compras prCompra){
        return ComprasDao.Inserir(prCompra);
    }
    
    public static List<Produto> PesquisarTodosProdutosDaCompra(Compras prCompra){
        return ComprasDao.PesquisarTodosProdutosDaCompra(prCompra);
    }
    
    public static void AtualizarTotais(Compras prCompra){
        ComprasDao.AtualizarTotais(prCompra);
    }
    
    public static List<Compras> PesquisarVendasPorPeriodoFuncionario(String prDataInicial, String prDataFinal, Fornecedor prFornecedor){
        return ComprasDao.PesquisarVendasPorPeriodoFuncionario(prDataInicial, prDataFinal, prFornecedor);
    }
    
}
