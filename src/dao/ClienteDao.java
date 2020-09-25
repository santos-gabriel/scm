package dao;

import conexao.Conexao;
import excecoes.ExcecaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import utilitarios.UsuariosUtil;

/**
 * @author Gabriel
 */
public abstract class ClienteDao {
    private static Connection conexao = null;    
    
    public static void SalvarTodosCampos (Cliente prCliente){
        CriarConexoes();
        String sql = "INSERT INTO CLIENTES(NOME_CLIENTE, DATA_NASCIMENTO, RG_CLIENTE, CPF_CLIENTE, CNPJ_CLIENTE, WHATSAPP_CLIENTE, TELEFONE_CLIENTE, ENDERECO_CLIENTE, COD_USUARIO, COD_ESTADO, COD_CIDADE , ATIVO) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prCliente.getNome_Cliente());
            stmt.setString(2, prCliente.getData_Nascimento_Cliente());
            stmt.setString(3, prCliente.getRG_Cliente());
            stmt.setString(4, prCliente.getCPF_Cliente());
            stmt.setString(5, prCliente.getCNPJ_Cliente());
            stmt.setString(6, prCliente.getWhatsApp_Cliente());
            stmt.setString(7, prCliente.getTelefone_Cliente());
            stmt.setString(8, prCliente.getEndereco_Cliente());
            stmt.setInt(9,UsuariosUtil.getUsuario().getCod_Usuario());
            stmt.setInt(10, prCliente.getCod_Estado());
            stmt.setInt(11, prCliente.getCod_Cidade());
            stmt.setBoolean(12, true);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao salvar cliente, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static void AtualizarTodosCampos(Cliente prCliente){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE CLIENTES SET NOME = ?, SET DATA_NASCIMENTO = ?, SET RG = ?, SET CPF = ?, SET CNPJ = ?, SET WHATSAPP = ?, SET TELEFONE = ?, SET ENDERECO = ? "
                + "WHERE CODIGO = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prCliente.getNome_Cliente());
            stmt.setString(2, prCliente.getData_Nascimento_Cliente());
            stmt.setString(3, prCliente.getRG_Cliente());
            stmt.setString(4, prCliente.getCPF_Cliente());
            stmt.setString(5, prCliente.getCNPJ_Cliente());
            stmt.setString(6, prCliente.getWhatsApp_Cliente());
            stmt.setString(7, prCliente.getTelefone_Cliente());
            stmt.setString(8, prCliente.getEndereco_Cliente());
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao atualizar cliente, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static void Excluir(Integer prCodigoCliente){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "DELETE FROM CLIENTES WHERE CODIGO = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigoCliente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao excluir cliente, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static Cliente PesquisarViaCodigo(Integer prCodigoCliente){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT C.* FROM CLIENTES C WHERE C.CODIGO = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigoCliente);
            rs = stmt.executeQuery();
            if (rs.next())
                return new Cliente();
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar cliente pelo código, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<Cliente> PesquisarTodos(){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM CLIENTES";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            List <Cliente> lista = new ArrayList<>();
            while(rs.next()){ 
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar categoria pela descrção, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<Cliente> PesquisarViaDescricaoExata(String prDescricaoCliente){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT C.* FROM CLIENTES WHERE UPPER(C.NOME) = UPPER(?) C.NOME ASC";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoCliente);
            rs = stmt.executeQuery();
            List <Cliente> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Cliente());
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar categoria pela descrção, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
        
    public static List<Cliente> PesquisarViaDescricaoInicia(String prDescricaoCliente){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT C.* FROM CLIENTES WHERE UPPER(C.NOME) LIKE UPPER(?%) C.NOME ASC";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoCliente);
            rs = stmt.executeQuery();
            List <Cliente> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Cliente());
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar categoria pela descrção, entre em contato com o suporte do sistema ");
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
