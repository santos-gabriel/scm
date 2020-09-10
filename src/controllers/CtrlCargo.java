package controllers;

import dao.CargoDao;
import java.util.List;
import modelo.Cargo;

/**
 * @author Gabriel
 */
public abstract class CtrlCargo {
    
    public static Integer SalvarTodosCampos (Cargo prCargo){
        return CargoDao.SalvarTodosCampos(prCargo);
    }
    
    public static void AtualizarTodosCampos(Cargo prCargo){
        CargoDao.AtualizarTodosCampos(prCargo);
    }
    
    public static void Excluir(Cargo prCargo){
        CargoDao.Excluir(prCargo.getCod_Cargo());
    }
    
    public static Cargo PesquisarViaCodigo(Cargo prCargo){
        return CargoDao.PesquisarViaCodigo(prCargo.getCod_Cargo());
    }
    
    public static List<Cargo> PesquisarViaDescricaoExata(Cargo prCargo){
        return CargoDao.PesquisarViaDescricaoExata(prCargo.getDesc_Cargo());
    }
    
    public static List<Cargo> PesquisarViaDescricaoInicia(Cargo prCargo){
        return CargoDao.PesquisarViaDescricaoInicia(prCargo.getDesc_Cargo());
    }
    
    public static List<Cargo> PesquisarTodos(){
        return CargoDao.PesquisarTodos();
    }
    
}
