package controllers;

import dao.ParcelasVendaDao;
import modelo.ParcelasVenda;

/**
 * @author Gabriel
 */
public class CtrlParcelasVenda {
    
    public static void SalvarTodosCampos (ParcelasVenda prParcelasVenda){
        ParcelasVendaDao.SalvarTodosCampos(prParcelasVenda);
    }
    
    public static void AtualizarTodosCampos(ParcelasVenda prParcelasVenda){
        ParcelasVendaDao.AtualizarTodosCampos(prParcelasVenda);
    }
       
}
