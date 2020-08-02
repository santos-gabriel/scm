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

/**
 * @author Gabriel
 */
public abstract class ClienteDao {
    private static Connection conexao = null;    
    
    public static void SalvarTodosCampos (Cliente prCliente){
        CriarConexoes();
        String sql = "INSERT INTO CLIENTE(NOME, DATA_NASCIMENTO, RG, CPF, CNPJ, WHATSAPP, TELEFONE, ENDERECO) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
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
        String sql = "UPDATE CLIENTE SET NOME = ?, SET DATA_NASCIMENTO = ?, SET RG = ?, SET CPF = ?, SET CNPJ = ?, SET WHATSAPP = ?, SET TELEFONE = ?, SET ENDERECO = ? "
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
        String sql = "DELETE FROM CLIENTE WHERE CODIGO = ?";
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
        String sql = "SELECT C.* FROM CLIENTE C WHERE C.CODIGO = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigoCliente);
            rs = stmt.executeQuery();
            if (rs.next())
                return new Cliente(rs.getInt("CODIGO"), 
                                   rs.getString("DESCRICAO"),
                                   rs.getString("DATA_NASCIMENTO"),
                                   rs.getString("RG"),
                                   rs.getString("CPF"),
                                   rs.getString("CPNJ"),
                                   rs.getString("WHATSAPP"),
                                   rs.getString("TELEFONE"),
                                   rs.getString("ENDERECO"));
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar cliente pelo código, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<Cliente> PesquisarViaDescricaoExata(String prDescricaoCliente){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT C.* FROM CLIENTE WHERE UPPER(C.NOME) = UPPER(?) C.NOME ASC";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoCliente);
            rs = stmt.executeQuery();
            List <Cliente> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Cliente(rs.getInt("CODIGO"), 
                                      rs.getString("DESCRICAO"),
                                      rs.getString("DATA_NASCIMENTO"),
                                      rs.getString("RG"),
                                      rs.getString("CPF"),
                                      rs.getString("CPNJ"),
                                      rs.getString("WHATSAPP"),
                                      rs.getString("TELEFONE"),
                                      rs.getString("ENDERECO")));
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
        String sql = "SELECT C.* FROM CLIENTE WHERE UPPER(C.NOME) LIKE UPPER(?%) C.NOME ASC";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoCliente);
            rs = stmt.executeQuery();
            List <Cliente> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Cliente(rs.getInt("CODIGO"), 
                                      rs.getString("DESCRICAO"),
                                      rs.getString("DATA_NASCIMENTO"),
                                      rs.getString("RG"),
                                      rs.getString("CPF"),
                                      rs.getString("CPNJ"),
                                      rs.getString("WHATSAPP"),
                                      rs.getString("TELEFONE"),
                                      rs.getString("ENDERECO")));
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
