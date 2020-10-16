package dao;

import conexao.Conexao;
import excecoes.ExcecaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cargo;
import modelo.Cidades;
import modelo.Estados;
import modelo.Funcionario;

/**
 * @author Gabriel
 */
public abstract class FuncionarioDao {
    
    private static Connection conexao = null;
    
    
    public static void SalvarTodosCampos (Funcionario prFuncionario){
        CriarConexoes();
        String sql = "INSERT INTO funcionarios(                                                 "
                                             + "cod_cargo,                                      "
                                             + "cod_usuario_cadastro,                           "
                                             + "cod_estado,                                     "
                                             + "cod_cidade,                                     "
                                             + "nome_funcionario,                               "
                                             + "data_nascimento,                                "
                                             + "rg_funcionario,                                 "
                                             + "cpf_funcionario,                                "
                                             + "whatsapp_funcionario,                           "
                                             + "endereco_funcionario,                           "
                                             + "ativo                                           "
                                             + ") VALUES (?, ?, ?, ?, ?, ? , ?, ?, ?, ?, true)  ";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prFuncionario.getCargo().getCod_Cargo());
            stmt.setInt(2, prFuncionario.getUsuarioCadastro().getCod_Usuario());
            stmt.setInt(3, prFuncionario.getEstado().getCodEstado());
            stmt.setInt(4, prFuncionario.getCidade().getCodCidade());
            stmt.setString(5, prFuncionario.getNome_Funcionario());
            stmt.setString(6, prFuncionario.getData_Nascimento());
            stmt.setString(7, prFuncionario.getRg_Funcionario());
            stmt.setString(8, prFuncionario.getCPF_Funcionario());
            stmt.setString(9, prFuncionario.getWhatsApp_Funcionario());
            stmt.setString(10, prFuncionario.getEndereco_Funcionario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao salvar Funcionario, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void AtualizarTodosCampos(Funcionario prFuncionario){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE funcionarios SET                                "
                                             + "cod_cargo               = ?, "
                                             + "cod_estado              = ?, "
                                             + "cod_cidade              = ?, "
                                             + "nome_funcionario        = ?, "
                                             + "data_nascimento         = ?, "
                                             + "rg_funcionario          = ?, "
                                             + "cpf_funcionario         = ?, "
                                             + "whatsapp_funcionario    = ?, "
                                             + "endereco_funcionario    = ?  "
                                             + "WHERE cod_funcionario   = ?  ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prFuncionario.getCargo().getCod_Cargo());
            stmt.setInt(2, prFuncionario.getEstado().getCodEstado());
            stmt.setInt(3, prFuncionario.getCidade().getCodCidade());
            stmt.setString(4, prFuncionario.getNome_Funcionario());
            stmt.setString(5, prFuncionario.getData_Nascimento());
            stmt.setString(6, prFuncionario.getRg_Funcionario());
            stmt.setString(7, prFuncionario.getCPF_Funcionario());
            stmt.setString(8, prFuncionario.getWhatsApp_Funcionario());
            stmt.setString(9, prFuncionario.getEndereco_Funcionario());
            stmt.setInt(10, prFuncionario.getCod_Funcionario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao atualizar Funcionario, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void Excluir(Integer prCodigo){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE funcionarios SET ativo = false WHERE cod_funcionario = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao excluir Funcionario, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static Funcionario PesquisarViaCodigo(Integer prCodigo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql =  "SELECT  f.cod_funcionario, f.nome_funcionario, c.cod_cargo, c.desc_cargo, f.data_nascimento, f.rg_funcionario, f.cpf_funcionario,        "
                    + "        f.whatsapp_funcionario, f.endereco_funcionario, cit.cod_cidade, cit.descricao AS cidade, est.cod_estado, est.descricao AS estado "
                    + "FROM funcionarios 		f                                                                                                       "
                    + "INNER JOIN cargos 		c 	ON                                                                                              "
                    + "     c.cod_cargo = f.cod_cargo                                                                                                           "
                    + "INNER JOIN cidades 		cit 	ON                                                                                              "
                    + "     cit.cod_cidade = f.cod_cidade                                                                                                       "
                    + "INNER JOIN estados 		est 	ON                                                                                              "
                    + "     est.cod_estado = f.cod_estado                                                                                                       "
                    + "WHERE f.ativo = true                                                                                                                     "
                    + "AND   f.cod_funcionario = ?                                                                                                              ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigo);
            rs = stmt.executeQuery();
            if (rs.next())
                return new Funcionario(
                                        rs.getInt("cod_funcionario"), 
                                        new Cargo(rs.getInt("cod_cargo"), rs.getString("desc_cargo")),
                                        rs.getString("nome_funcionario"),
                                        rs.getString("data_nascimento"), 
                                        rs.getString("rg_funcionario"), 
                                        rs.getString("cpf_funcionario"),
                                        rs.getString("whatsapp_funcionario"), 
                                        new Cidades(rs.getInt("cod_cidade"), rs.getString("cidade")), 
                                        new Estados(rs.getInt("cod_estado"), rs.getString("estado")), 
                                        rs.getString("endereco_funcionario")
                                       );
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar Funcionario pelo código, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<Funcionario> PesquisarViaDescricaoExata(String prDescricaoFuncionario){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql =  "SELECT  f.cod_funcionario, f.nome_funcionario, c.cod_cargo, c.desc_cargo, f.data_nascimento, f.rg_funcionario, f.cpf_funcionario,        "
                    + "        f.whatsapp_funcionario, f.endereco_funcionario, cit.cod_cidade, cit.descricao AS cidade, est.cod_estado, est.descricao AS estado "
                    + "FROM funcionarios 		f                                                                                                       "
                    + "INNER JOIN cargos 		c 	ON                                                                                              "
                    + "     c.cod_cargo = f.cod_cargo                                                                                                           "
                    + "INNER JOIN cidades 		cit 	ON                                                                                              "
                    + "     cit.cod_cidade = f.cod_cidade                                                                                                       "
                    + "INNER JOIN estados 		est 	ON                                                                                              "
                    + "     est.cod_estado = f.cod_estado                                                                                                       "
                    + "WHERE f.ativo = true                                                                                                                     "
                    + "AND   UPPER(f.nome_funcionario) = UPPER(?)                                                                                               ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoFuncionario);
            rs = stmt.executeQuery();
            List <Funcionario> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Funcionario(
                                        rs.getInt("cod_funcionario"), 
                                        new Cargo(rs.getInt("cod_cargo"), rs.getString("desc_cargo")),
                                        rs.getString("nome_funcionario"),
                                        rs.getString("data_nascimento"), 
                                        rs.getString("rg_funcionario"), 
                                        rs.getString("cpf_funcionario"),
                                        rs.getString("whatsapp_funcionario"), 
                                        new Cidades(rs.getInt("cod_cidade"), rs.getString("cidade")), 
                                        new Estados(rs.getInt("cod_estado"), rs.getString("estado")), 
                                        rs.getString("endereco_funcionario")
                                       ));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar Funcionario pela descrção, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<Funcionario> PesquisarViaDescricaoInicia(String prDescricaoFuncionario){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql =  "SELECT  f.cod_funcionario, f.nome_funcionario, c.cod_cargo, c.desc_cargo, f.data_nascimento, f.rg_funcionario, f.cpf_funcionario,        "
                    + "        f.whatsapp_funcionario, f.endereco_funcionario, cit.cod_cidade, cit.descricao AS cidade, est.cod_estado, est.descricao AS estado "
                    + "FROM funcionarios 		f                                                                                                       "
                    + "INNER JOIN cargos 		c 	ON                                                                                              "
                    + "     c.cod_cargo = f.cod_cargo                                                                                                           "
                    + "INNER JOIN cidades 		cit 	ON                                                                                              "
                    + "     cit.cod_cidade = f.cod_cidade                                                                                                       "
                    + "INNER JOIN estados 		est 	ON                                                                                              "
                    + "     est.cod_estado = f.cod_estado                                                                                                       "
                    + "WHERE f.ativo = true                                                                                                                     "
                    + "AND   UPPER(f.nome_funcionario) = UPPER(?)                                                                                               ";
        try {
            stmt = conexao.prepareStatement(sql+"%");
            stmt.setString(1, prDescricaoFuncionario);
            rs = stmt.executeQuery();
            List <Funcionario> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Funcionario(
                                        rs.getInt("cod_funcionario"), 
                                        new Cargo(rs.getInt("cod_cargo"), rs.getString("desc_cargo")),
                                        rs.getString("nome_funcionario"),
                                        rs.getString("data_nascimento"), 
                                        rs.getString("rg_funcionario"), 
                                        rs.getString("cpf_funcionario"),
                                        rs.getString("whatsapp_funcionario"), 
                                        new Cidades(rs.getInt("cod_cidade"), rs.getString("cidade")), 
                                        new Estados(rs.getInt("cod_estado"), rs.getString("estado")), 
                                        rs.getString("endereco_funcionario")
                                       ));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar Funcionario pela descrção, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<Funcionario> PesquisarTodos(){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql =  "SELECT  f.cod_funcionario, f.nome_funcionario, c.cod_cargo, c.desc_cargo, f.data_nascimento, f.rg_funcionario, f.cpf_funcionario,        "
                    + "        f.whatsapp_funcionario, f.endereco_funcionario, cit.cod_cidade, cit.descricao AS cidade, est.cod_estado, est.descricao AS estado "
                    + "FROM funcionarios 		f                                                                                                       "
                    + "INNER JOIN cargos 		c 	ON                                                                                              "
                    + "     c.cod_cargo = f.cod_cargo                                                                                                           "
                    + "INNER JOIN cidades 		cit 	ON                                                                                              "
                    + "     cit.cod_cidade = f.cod_cidade                                                                                                       "
                    + "INNER JOIN estados 		est 	ON                                                                                              "
                    + "     est.cod_estado = f.cod_estado                                                                                                       "
                    + "WHERE f.ativo = true                                                                                                                     ";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            List <Funcionario> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Funcionario(
                                        rs.getInt("cod_funcionario"), 
                                        new Cargo(rs.getInt("cod_cargo"), rs.getString("desc_cargo")),
                                        rs.getString("nome_funcionario"),
                                        rs.getString("data_nascimento"), 
                                        rs.getString("rg_funcionario"), 
                                        rs.getString("cpf_funcionario"),
                                        rs.getString("whatsapp_funcionario"), 
                                        new Cidades(rs.getInt("cod_cidade"), rs.getString("cidade")), 
                                        new Estados(rs.getInt("cod_estado"), rs.getString("estado")), 
                                        rs.getString("endereco_funcionario")
                                        ));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar Funcionario pela descrção, entre em contato com o suporte do sistema ");
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
