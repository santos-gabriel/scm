package utilitarios;

import controllers.CtrlUsuario;
import java.util.List;
import modelo.Usuario;

/**Classe de gerenciamento e utilitarios do usuário atual da sessão
 * @author Gabriel
 * @version %I%, %G%
 * @since v1.4.2-beta.1
 */
public abstract class UsuariosUtil {
    
    private static Usuario usuario;

    
    /**Método para verificar a permissões de um usuário ao módulo
     * @param prDescricaoModulo modulo a ser verificada
     * @return List permissões do usuário ao módulo
     * @since v1.4.2-beta.1
     */
    public static List<String> getPermissao(String prDescricaoModulo){
        return CtrlUsuario.PesquisaPermissoesUsuarioModulo(prDescricaoModulo, usuario.getCod_Usuario());
    }
    
    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        UsuariosUtil.usuario = usuario;
    }
    
    
}
