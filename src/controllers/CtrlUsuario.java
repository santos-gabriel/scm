package controllers;

import dao.UsuarioDao;
import modelo.Usuario;

/**
 * @author Gabriel
 */
public class CtrlUsuario {
    
    public static void SalvarTodosCampos (Usuario prUsuario){
        UsuarioDao.SalvarTodosCampos(prUsuario);
    }
    
    public static void AtualizarTodosCampos(Usuario prUsuario){
        UsuarioDao.AtualizarTodosCampos(prUsuario);
    }
    
    public static void Excluir(Usuario prUsuario){
        UsuarioDao.Excluir(prUsuario.getCod_Usuario());
    }
    
    public static Usuario PesquisarViaCodigo(Usuario prUsuario){
        return UsuarioDao.PesquisarViaCodigo(prUsuario.getCod_Usuario());
    }
    
}
