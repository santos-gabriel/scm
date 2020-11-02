/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.VendasDao;
import java.util.List;
import modelo.Produto;
import modelo.Vendas;

/**
 *
 * @author Gabriel
 */
public abstract class CtrlVendas {
    
    public static Integer Inserir(Vendas venda){
        return VendasDao.Inserir(venda);
    }
    
    public static void AtualizarTotais(Vendas venda){
        VendasDao.AtualizarTotais(venda);
    }
    
    public static List<Produto> PesquisarTodosProdutosDaVenda(Vendas venda){
        return VendasDao.PesquisarTodosProdutosDaVenda(venda);
    }
    
    public static Integer PesquisaQuantidadeDisponivelProduto(Produto prProduto){
        return VendasDao.PesquisaQuantidadeDisponivelProduto(prProduto);
    }
    
}
