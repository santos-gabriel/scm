/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import excecoes.ExcecaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Cidades;

/**
 *
 * @author Gabriel
 */
public abstract class CidadeDao {
    private static Connection conexao = null;
    
    public static Integer SalvarTodosCampos (Cidades prCidade){
        CriarConexoes();
        String sql = "INSERT INTO cidades(cod_cidade, descricao, ativo) VALUES(null, ?, true)";
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, prCidade.getDescricao());
            stmt.executeUpdate();
            ResultSet rsKeys = stmt.getGeneratedKeys();
            if (rsKeys.next())
                return rsKeys.getInt(1);
            else
                return null;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao salvar cidade, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static void AtualizarTodosCampos(Cidades prCidade){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE cidades SET descricao = ? WHERE cod_cidade = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prCidade.getDescricao());
            stmt.setInt(2, prCidade.getCodCidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao atualizar cidade, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static void Excluir(Integer prCodigoCidade){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE cidades SET ativo = false WHERE cod_cidade = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigoCidade);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao excluir cidade, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static Cidades PesquisarViaCodigo(Integer prCodigoCidade){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT c.cod_cidade, c.descricao FROM cidades c WHERE c.cod_cidade = ? AND c.ativo = true";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigoCidade);
            rs = stmt.executeQuery();
            if (rs.next())
                return new Cidades(rs.getInt("cod_cidade"), rs.getString("descricao"));
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar cidade pelo código, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<Cidades> PesquisarTodos(){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT c.cod_cidade, c.descricao FROM cidades c WHERE c.ativo = true ORDER BY c.descricao ASC ";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            List <Cidades> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Cidades(rs.getInt("cod_cidade"), rs.getString("descricao")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar cidade pela descrção, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<Cidades> PesquisarViaDescricaoExata(String prDescricaoCidade){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT c.cod_cidade, c.descricao FROM cidades c WHERE UPPER(c.descricao) = UPPER(?) AND c.ativo = true ORDER BY c.descricao ASC ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoCidade);
            rs = stmt.executeQuery();
            List <Cidades> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Cidades(rs.getInt("cod_cidade"), rs.getString("descricao")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar cidade pela descrção, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<Cidades> PesquisarViaDescricaoInicia(String prDescricaoCidade){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT c.cod_cidade, c.descricao FROM cidades c WHERE UPPER(c.descricao) LIKE UPPER(?) AND c.ativo = true ORDER BY c.descricao ASC ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoCidade+"%");
            rs = stmt.executeQuery();
            List <Cidades> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Cidades(rs.getInt("cod_cidade"), rs.getString("descricao")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar c pela descrção, entre em contato com o suporte do sistema ");
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
