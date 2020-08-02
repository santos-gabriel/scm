package controllers;

import dao.CargoDao;
import java.util.List;
import modelo.Cargo;

/**
 * @author Gabriel
 */
public class CtrlCargo {
    
    public static void SalvarTodosCampos (Cargo prCargo){
        CargoDao.SalvarTodosCampos(prCargo);
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
    
}
