package dao;

import conexao.Conexao;
import excecoes.ExcecaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.CondicaoPagamento;

/**
 * @author Gabriel
 */
public abstract class CondicaoPagamentoDao {
    
    private static Connection conexao = null;
    
    
    public static void SalvarTodosCampos (CondicaoPagamento prCondicao){
        CriarConexoes();
        String sql = "INSERT INTO condicoes_pagamentos(desc_condicao_pagamento, quantidade_parcela, ativo) VALUES (?, ?, true)";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prCondicao.getDesc_condicao_pagamento());
            stmt.setInt(2, prCondicao.getQuantidade_parcelas());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao salvar condição de pagamento, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void AtualizarTodosCampos(CondicaoPagamento prCondicao){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE condicoes_pagamentos SET desc_condicao_pagamento = ?, quantidade_parcela = ? WHERE cod_condicao_pagamento = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prCondicao.getDesc_condicao_pagamento());
            stmt.setInt(2, prCondicao.getQuantidade_parcelas());
            stmt.setInt(3, prCondicao.getCod_condicao_pagamento());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao atualizar condição de pagamento, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void Excluir(Integer prCodigoCondicao){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE condicoes_pagamentos SET ativo = false WHERE cod_condicao_pagamento = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigoCondicao);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao excluir condição de pagamento, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static CondicaoPagamento PesquisarViaCodigo(Integer prCodigoCondicao){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM condicoes_pagamentos WHERE ativo = true AND cod_condicao_pagamento = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigoCondicao);
            rs = stmt.executeQuery();
            if (rs.next())
                return new CondicaoPagamento(rs.getInt("cod_condicao_pagamento"), rs.getString("desc_condicao_pagamento"), rs.getInt("quantidade_parcela"));
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar condição de pagamento pelo código, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<CondicaoPagamento> PesquisarTodos(){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM condicoes_pagamentos WHERE ativo = true ";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<CondicaoPagamento> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new CondicaoPagamento(rs.getInt("cod_condicao_pagamento"), rs.getString("desc_condicao_pagamento"), rs.getInt("quantidade_parcela")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar condições de pagamentos, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<CondicaoPagamento> PesquisarViaDescricaoExata(String prDescricaoCargo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM condicoes_pagamentos WHERE ativo = true AND UPPER(desc_condicao_pagamento) = UPPER(?) ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoCargo);
            rs = stmt.executeQuery();
            List <CondicaoPagamento> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new CondicaoPagamento(rs.getInt("cod_condicao_pagamento"), rs.getString("desc_condicao_pagamento"), rs.getInt("quantidade_parcela")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar condição de pagamento pela descrção, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<CondicaoPagamento> PesquisarViaDescricaoInicia(String prDescricaoCargo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM condicoes_pagamentos WHERE ativo = true AND UPPER(desc_condicao_pagamento) = UPPER(?) ";
        try {
            stmt = conexao.prepareStatement(sql+"%");
            stmt.setString(1, prDescricaoCargo);
            rs = stmt.executeQuery();
            List <CondicaoPagamento> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new CondicaoPagamento(rs.getInt("cod_condicao_pagamento"), rs.getString("desc_condicao_pagamento"), rs.getInt("quantidade_parcela")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar condição de pagamento pela descrção, entre em contato com o suporte do sistema ");
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
