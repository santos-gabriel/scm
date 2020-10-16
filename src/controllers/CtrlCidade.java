/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CidadeDao;
import java.util.List;
import modelo.Cidades;

/**
 *
 * @author Gabriel
 */
public abstract class CtrlCidade {
    
    public static Integer SalvarTodosCampos (Cidades prCidades){
        return CidadeDao.SalvarTodosCampos(prCidades);
    }
    
    public static void AtualizarTodosCampos(Cidades prCidades){
        CidadeDao.AtualizarTodosCampos(prCidades);
    }
    
    public static void Excluir(Cidades prCidades){
        CidadeDao.Excluir(prCidades.getCodCidade());
    }
    
    public static Cidades PesquisarViaCodigo(Cidades prCidades){
        return CidadeDao.PesquisarViaCodigo(prCidades.getCodCidade());
    }
    
    public static List<Cidades> PesquisarViaDescricaoExata(Cidades prCidades){
        return CidadeDao.PesquisarViaDescricaoExata(prCidades.getDescricao());
    }
    
    public static List<Cidades> PesquisarViaDescricaoInicia(Cidades prCidades){
        return CidadeDao.PesquisarViaDescricaoInicia(prCidades.getDescricao());
    }
    
    public static List<Cidades> PesquisarTodos(){
        return CidadeDao.PesquisarTodos();
    }
}
