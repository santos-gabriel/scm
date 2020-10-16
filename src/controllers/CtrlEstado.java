/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.EstadoDao;
import java.util.List;
import modelo.Estados;

/**
 *
 * @author Gabriel
 */
public abstract class CtrlEstado {
    
    public static Integer SalvarTodosCampos (Estados prEstado){
        return EstadoDao.SalvarTodosCampos(prEstado);
    }
    
    public static void AtualizarTodosCampos(Estados prEstado){
        EstadoDao.AtualizarTodosCampos(prEstado);
    }
    
    public static void Excluir(Estados prEstado){
        EstadoDao.Excluir(prEstado.getCodEstado());
    }
    
    public static Estados PesquisarViaCodigo(Estados prEstado){
        return EstadoDao.PesquisarViaCodigo(prEstado.getCodEstado());
    }
    
    public static List<Estados> PesquisarViaDescricaoExata(Estados prEstado){
        return EstadoDao.PesquisarViaDescricaoExata(prEstado.getDescricao());
    }
    
    public static List<Estados> PesquisarViaDescricaoInicia(Estados prEstado){
        return EstadoDao.PesquisarViaDescricaoInicia(prEstado.getDescricao());
    }
    
    public static List<Estados> PesquisarTodos(){
        return EstadoDao.PesquisarTodos();
    }
    
}
