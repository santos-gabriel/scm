package controllers;

import dao.FuncionarioDao;
import java.util.List;
import modelo.Funcionario;

/**
 * @author Gabriel
 */
public abstract class CtrlFuncionario {
    
    public static void SalvarTodosCampos (Funcionario prFuncionario){
        FuncionarioDao.SalvarTodosCampos(prFuncionario);
    }
    
    public static void AtualizarTodosCampos(Funcionario prFuncionario){
        FuncionarioDao.AtualizarTodosCampos(prFuncionario);
    }
    
    public static void Excluir(Funcionario prFuncionario){
        FuncionarioDao.Excluir(prFuncionario.getCod_Funcionario());
    }
    
    public static Funcionario PesquisarViaCodigo(Funcionario prFuncionario){
        return FuncionarioDao.PesquisarViaCodigo(prFuncionario.getCod_Funcionario());
    }
    
    public static List<Funcionario> PesquisarViaDescricaoExata(Funcionario prFuncionario){
        return FuncionarioDao.PesquisarViaDescricaoExata(prFuncionario.getNome_Funcionario());
    }
    
    public static List<Funcionario> PesquisarViaDescricaoInicia(Funcionario prFuncionario){
        return FuncionarioDao.PesquisarViaDescricaoInicia(prFuncionario.getNome_Funcionario());
    }
    
    public static List<Funcionario> PesquisarTodos(){
        return FuncionarioDao.PesquisarTodos();
    }
    
}
