package dao;

import conexao.Conexao;
import excecoes.ExcecaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.TipoPagamento;

/**
 * @author Gabriel
 */
public abstract class TipoPagamentoDao {
    
    private static Connection conexao = null;
    
    public static void SalvarTodosCampos (TipoPagamento prTipoPagamento){
        CriarConexoes();
        String sql = "INSERT INTO tipos_pagamentos(desc_tipo_pagamento, ativo) VALUES (?, true)";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prTipoPagamento.getDesc_pagamento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao salvar tipo de pagamento, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void AtualizarTodosCampos(TipoPagamento prTipoPagamento){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE tipos_pagamentos SET desc_tipo_pagamento = ? WHERE cod_tipo_pagamento = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prTipoPagamento.getDesc_pagamento());
            stmt.setInt(2, prTipoPagamento.getCod_pagamento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao atualizar tipo de pagamento, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void Excluir(Integer prCodigo){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE tipos_pagamentos SET ativo = false WHERE cod_tipo_pagamento = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao excluir tipo de pagamento, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    
    public static TipoPagamento PesquisarViaCodigo(Integer prCodigo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM tipos_pagamentos WHERE ativo = true AND cod_tipo_pagamento = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigo);
            rs = stmt.executeQuery();
            if (rs.next())
                return new TipoPagamento(rs.getInt("cod_tipo_pagamento"), rs.getString("desc_tipo_pagamento"));
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar tipo de pagamento pelo código, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<TipoPagamento> PesquisarTodos() {
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM tipos_pagamentos WHERE ativo = true ";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<TipoPagamento> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new TipoPagamento(rs.getInt("cod_tipo_pagamento"), rs.getString("desc_tipo_pagamento")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar tipo de pagamento pelo código, entre em contato com o suporte do sistema ");
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
