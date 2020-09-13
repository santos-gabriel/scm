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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Estados;

/**
 *
 * @author Gabriel
 */
public abstract class EstadoDao {
    
    private static Connection conexao = null;
    
    public static Integer SalvarTodosCampos (Estados prEstado){
        CriarConexoes();
        String sql = "INSERT INTO estados(cod_estado, descricao, uf, ativo) VALUES(null, ?, ?, true)";
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, prEstado.getDescricao());
            stmt.setString(2, prEstado.getUf().toUpperCase());
            stmt.executeUpdate();
            ResultSet rsKeys = stmt.getGeneratedKeys();
            if (rsKeys.next())
                return rsKeys.getInt(1);
            else
                return null;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao salvar estado, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static void AtualizarTodosCampos(Estados prEstado){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE estados SET descricao = ?, uf = ? WHERE cod_estado = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prEstado.getDescricao());
            stmt.setString(2, prEstado.getUf().toUpperCase());
            stmt.setInt(3, prEstado.getCodEstado());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao atualizar estado, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static void Excluir(Integer prCodigo){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE estados SET ativo = false WHERE cod_estado = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigo);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao excluir estado, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static Estados PesquisarViaCodigo(Integer prCodigo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT e.* FROM estados e WHERE e.cod_estado = ? AND e.ativo = true ORDER BY e.descricao ASC ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigo);
            rs = stmt.executeQuery();
            if (rs.next())
                return new Estados(rs.getInt("cod_estado"), rs.getString("descricao"), rs.getString("uf"), rs.getBoolean("ativo"));
            else
                return null;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar estado pelo código, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<Estados> PesquisarTodos(){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT e.* FROM estados e WHERE e.ativo = true ORDER BY e.descricao ASC ";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            List <Estados> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Estados(rs.getInt("cod_estado"), rs.getString("descricao"), rs.getString("uf"), rs.getBoolean("ativo")));
            }
            return lista;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar estados pela descrção, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<Estados> PesquisarViaDescricaoExata(String prDescricao){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT e.* FROM estados e WHERE UPPER(e.descricao) LIKE UPPER(?) AND e.ativo = true ORDER BY e.descricao ASC ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricao);
            rs = stmt.executeQuery();
            List <Estados> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Estados(rs.getInt("cod_estado"), rs.getString("descricao"), rs.getString("uf"), rs.getBoolean("ativo")));
            }
            return lista;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar estados pela descrção, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<Estados> PesquisarViaDescricaoInicia(String prDescricao){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT e.* FROM estados e WHERE UPPER(e.descricao) LIKE UPPER(?) AND e.ativo = true ORDER BY e.descricao ASC ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricao+"%");
            rs = stmt.executeQuery();
            List <Estados> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Estados(rs.getInt("cod_estado"), rs.getString("descricao"), rs.getString("uf"), rs.getBoolean("ativo")));
            }
            return lista;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar estados pela descrção, entre em contato com o suporte do sistema ");
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
