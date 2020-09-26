package controllers;

import dao.ClienteDao;
import java.util.List;
import modelo.Cliente;

/**
 * @author Gabriel
 */
public class CtrlCliente {
    
    public static void SalvarTodosCamposFisica (Cliente prCliente){
        ClienteDao.SalvarTodosCamposFisica(prCliente);
    }
    public static void SalvarTodosCamposJuridica (Cliente prCliente){
        ClienteDao.SalvarTodosCamposJuridica(prCliente);
    }
    
    public static void AtualizarTodosCamposFisica(Cliente prCliente){
        ClienteDao.AtualizarTodosCamposFisica(prCliente);
    }
    public static void AtualizarTodosCamposJuridica(Cliente prCliente){
        ClienteDao.AtualizarTodosCamposJuridica(prCliente);
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
    public static List<Cliente> PesquisarTodosPorCodigo(int Cod_cliente){
        return ClienteDao.PesquisarTodosPorCodigo(Cod_cliente);
    }
    
}
