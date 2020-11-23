/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CaixaDao;
import java.util.List;
import modelo.Caixa;

/**
 *
 * @author Gabriel
 */
public abstract class CtrlCaixa {

    public static void Inserir(Caixa prCaixa){
        CaixaDao.Inserir(prCaixa);
    }
    
    public static Caixa PesquisaUltimoCaixa(){  
        return CaixaDao.PesquisaUltimoCaixa();
    }
    
    public static Double PesquisaSaldoAtual(){        
        return CaixaDao.PesquisaSaldoAtual(PesquisaUltimoCaixaComTimesTamp());
    }
    
    public static List<Caixa> PesquisaTodos(){
        return CaixaDao.PesquisaTodos();
    }
    
    public static Caixa PesquisaUltimoCaixaComTimesTamp(){  
        return CaixaDao.PesquisaUltimoCaixaComTimesTamp();
    }
    
}
