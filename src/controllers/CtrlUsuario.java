package controllers;

import dao.UsuarioDao;
import java.util.List;
import modelo.Usuario;

/**
 * @author Gabriel
 * @version %I%, %G%
 * @since v1.0
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
    
    public static Usuario PesquisarViaLoginSenha(Usuario prUsuario){
        return UsuarioDao.PesquisarViaLoginSenha(prUsuario);
    }
    
    public static List<Usuario> PesquisarViaLoginInicia(Usuario prUsuario){
        return UsuarioDao.PesquisarViaLoginInicia(prUsuario);
    }
    
    public static Usuario PesquisarViaLogin(Usuario prUsuario){
        return UsuarioDao.PesquisarViaLogin(prUsuario);
    }    
    
    public static List<String> PesquisaPermissoesUsuarioModulo (String prDescricaoModulo, int prCodUsuario){
        return UsuarioDao.PesquisaPermissoesUsuarioModulo(prDescricaoModulo, prCodUsuario);
    }
    
}
