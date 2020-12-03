package controllers;

import dao.UsuarioDao;
import java.util.List;
import modelo.Usuario;

/**
 * @author Gabriel
 * @version %I%, %G%
 * @since v1.4.2-beta.1
 */
public abstract class CtrlUsuario {
    
    public static Integer SalvarTodosCampos (Usuario prUsuario){
        return UsuarioDao.SalvarTodosCampos(prUsuario);
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
    
    public static Usuario PesquisarViaLoginExceto(Usuario prUsuario){
        return UsuarioDao.PesquisarViaLoginExceto(prUsuario);
    }
    
    public static Usuario VerificaDisponibilidadeLogin(Usuario prUsuario){
        if (prUsuario.getCod_Usuario() == 0)
            return PesquisarViaLogin(prUsuario);
        else 
            return PesquisarViaLoginExceto(prUsuario);
    }
    
    public static List<String> PesquisaPermissoesUsuarioModulo (String prDescricaoModulo, int prCodUsuario){
        return UsuarioDao.PesquisaPermissoesUsuarioModulo(prDescricaoModulo, prCodUsuario);
    }
    
    public static List<Usuario> PesquisarTodos(){
        return UsuarioDao.PesquisarTodos();
    }
}
