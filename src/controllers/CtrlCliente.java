package controllers;

import dao.ClienteDao;
import java.util.List;
import modelo.Cliente;

/**
 * @author Gabriel
 */
public class CtrlCliente {
    
    public static void SalvarTodosCampos (Cliente prCliente){
        ClienteDao.SalvarTodosCampos(prCliente);
    }
    
    public static void AtualizarTodosCampos(Cliente prCliente){
        ClienteDao.AtualizarTodosCampos(prCliente);
    }
    
    public static void Excluir(Cliente prCliente){
        ClienteDao.Excluir(prCliente.getCod_Cliente());
    }
    
    public static Cliente PesquisarViaCodigo(Cliente prCliente){
        return ClienteDao.PesquisarViaCodigo(prCliente.getCod_Cliente());
    }
    
    public static List<Cliente> PesquisarViaDescricaoExata(Cliente prCliente){
        return ClienteDao.PesquisarViaDescricaoExata(prCliente.getNome_Cliente());
    }
    
    public static List<Cliente> PesquisarViaDescricaoInicia(Cliente prCliente){
        return ClienteDao.PesquisarViaDescricaoInicia(prCliente.getNome_Cliente());
    }
    
    public static List<Cliente> PesquisarTodos(){
        return ClienteDao.PesquisarTodos();
    }
    
}
