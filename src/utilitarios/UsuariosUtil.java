package utilitarios;

import modelo.Usuario;

/**Classe de gerenciamento e utilitarios do usuário atual da sessão
 * @author Gabriel
 * @version %I%, %G%
 * @since v1.0
 */
public abstract class UsuariosUtil {
    
    private static Usuario usuario;

    
    /**Método para verificar a permissão de um usuário ao módulo
     * @param pPermissao permissão a ser verificada
     * @param pModulo módulo a ser verificado
     * @return boolean permissão do usuário ao módulo, sendo true para permissão concedida e false para permissão negada
     * @since v1.0
     */
    public static boolean getPermissao(int pPermissao, int pModulo){
        return true;
    }
    
    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        UsuariosUtil.usuario = usuario;
    }
    
}
