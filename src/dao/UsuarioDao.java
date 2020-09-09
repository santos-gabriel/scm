package dao;

import conexao.Conexao;
import excecoes.ExcecaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

/**
 * @author Gabriel
 * @version %I%, %G%
 * @since v1.0
 */
public class UsuarioDao {
    
    private static Connection conexao = null;
    
    public static void SalvarTodosCampos (Usuario prUsuario){
        CriarConexoes();
        String sql = "INSERT INTO usuarios(login, senha, cod_funcionario, ativo) VALUES (?, ?, ?, ?); ";
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prUsuario.getLogin().toUpperCase());
            stmt.setString(2, prUsuario.getSenha());
            
            if (prUsuario.getCod_Funcionario() > 0)
                stmt.setObject(3, prUsuario.getCod_Funcionario());
            else
                stmt.setObject(3, null);
            
            stmt.setBoolean(4, true);
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao salvar usuario, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void AtualizarTodosCampos(Usuario prUsuario){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE usuarios SET login = ?, senha = ? ";
        if (prUsuario.getCod_Funcionario() > 0)
            sql += " , cod_funcionario = ?";
        sql += " WHERE cod_usuario = ?; ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prUsuario.getLogin().toUpperCase());
            stmt.setString(2, prUsuario.getSenha());
            if (prUsuario.getCod_Funcionario() > 0){
                stmt.setInt(3, prUsuario.getCod_Funcionario());
                stmt.setInt(4, prUsuario.getCod_Usuario());
            } else{
                stmt.setInt(3, prUsuario.getCod_Usuario());
            }
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao atualizar usuario, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void Excluir(Integer prCodigo){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE usuarios SET ativo = ? WHERE cod_usuario = ?; ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setBoolean(1, false);
            stmt.setInt(2, prCodigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao excluir usuario, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    
    public static Usuario PesquisarViaCodigo(Integer prCodigo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM usuarios u WHERE u.cod_usuario = ? AND u.ativo = true; ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigo);
            rs = stmt.executeQuery();
            if (rs.next())
                return new Usuario(rs.getInt("cod_usuario"), rs.getString("login"), rs.getString("senha"));
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar usuario pelo código, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static Usuario PesquisarViaLoginSenha(Usuario prUsuario){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM usuarios u WHERE UPPER(u.login) = UPPER(?) AND u.senha = ? AND u.ativo = true; ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prUsuario.getLogin());
            stmt.setString(2, prUsuario.getSenha());
            rs = stmt.executeQuery();
            if (rs.next())
                return new Usuario(rs.getInt("cod_usuario"), rs.getInt("cod_funcionario"), rs.getString("login"), rs.getString("senha"), rs.getBoolean("ativo"));
            else
                return null;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar usuario pelo login e senha, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<Usuario> PesquisarViaLoginInicia(Usuario prUsuario){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM usuarios u WHERE UPPER(u.login) LIKE UPPER(?) AND u.ativo = true; ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, (prUsuario.getLogin()+"%"));
            rs = stmt.executeQuery();
            List <Usuario> usuarios = new ArrayList<>();
            while(rs.next()){
                usuarios.add(new Usuario(
                                        rs.getInt("cod_usuario"), rs.getString("login"), rs.getString("senha")
                                      ));
            }
            return usuarios;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar usuario pelo login e senha, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static Usuario PesquisarViaLogin(Usuario prUsuario){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM usuarios u WHERE UPPER(u.login) = UPPER(?) ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prUsuario.getLogin());
            rs = stmt.executeQuery();
            if (rs.next())
                return new Usuario(rs.getInt("cod_usuario"), rs.getString("login"), rs.getString("senha"));
            else
                return null;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar usuario pelo login, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<String> PesquisaPermissoesUsuarioModulo(String prDescricaoModulo, int prCodUsuario){
        CriarConexoes();
        List<String> permissoes = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT usr.cod_usuario, usr.login, mdl.descricao as modulo, prs.descricao as permissao "
                   + "FROM       usuarios          usr                                                       "
                   + "INNER JOIN permissao_usuario pru  ON                                                   "
                   + "      pru.cod_usuario = usr.cod_usuario                                                "
                   + "INNER JOIN permissoes        prs  ON                                                   "
                   + "      prs.cod_permissao = pru.cod_permissao                                            "
                   + "INNER JOIN modulos           mdl  ON                                                   "
                   + "      mdl.cod_modulo = pru.cod_modulo                                                  "
                   + "WHERE usr.ativo = true                                                                 "
                   + "AND   usr.cod_usuario = ?                                                              "
                   + "AND   UPPER(mdl.descricao) LIKE UPPER(?)                                               ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodUsuario);
            stmt.setString(2, prDescricaoModulo);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                permissoes.add(rs.getString("permissao"));
            }
            
            return permissoes;
            
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar permissão do usuário ao módulo ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    private static void CriarConexoes(){
        conexao = Conexao.conectar();
    }
    
    private static void FecharConexoes(Connection conexao, PreparedStatement stmt, ResultSet rs){
        if(conexao != null && stmt == null && rs == null){
            Conexao.desconectar(conexao);
        }else if (stmt != null && rs != null){
            Conexao.desconectar(conexao, stmt, rs);
        }else if(stmt != null && rs == null){
            Conexao.desconectar(conexao, stmt);
        }
    }
    
}
