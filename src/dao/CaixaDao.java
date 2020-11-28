/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import conexao.Conexao;
import excecoes.ExcecaoDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Caixa;
import modelo.Usuario;
/**
 *
 * @author Gabriel
 */
public abstract class CaixaDao {
    
    private static Connection conexao = null;
    
    
    public static void Inserir(Caixa prCaixa){
        CriarConexoes();
        String sql = "INSERT INTO caixa(cod_caixa, cod_usuario, fechamento_data, valor, ativo) VALUES (null, ?, CURRENT_TIMESTAMP, ?, true)";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCaixa.getUsuario().getCod_Usuario());
            stmt.setDouble(2, prCaixa.getValor());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao salvar caixa, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
            
    public static Double PesquisaSaldoAtual(Caixa prCaixa){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = 
                  "SELECT                                                           " +
                  "       (SELECT COALESCE(SUM(cp.total_liquido), 0)                " +
                  "	   FROM   referencia_produto ref1                           " +
                  "        INNER JOIN produto_compra pc ON                          " +
                  "		pc.cod_rastreio_produto = ref1.cod_rastreio_produto " +
                  "	   INNER JOIN compras cp ON                                 " +
                  "		cp.cod_compra = pc.cod_compra                       ";
        if (!(prCaixa == null || prCaixa.getAuxFechamentoData() == null))
            sql += "	   WHERE cp.data > ?                                        ";        
        sql += "       ) AS COMPRAS, " +
                  "       (SELECT COALESCE(SUM(vd.valor_total), 0)                  " +
                  "        FROM   referencia_produto ref2                           " +
                  "        INNER JOIN produtos_venda pv ON                          " +
                  "		pv.cod_rastreio_produto = ref2.cod_rastreio_produto " +
                  "	   INNER JOIN vendas vd ON                                  " +
                  "		vd.cod_venda = pv.cod_venda                         ";
        if (!(prCaixa == null || prCaixa.getAuxFechamentoData() == null))
            sql += "	   WHERE vd.data_venda > ?                                  ";                  
        sql += "       ) AS VENDAS                                                  ";        
        try {
            stmt = conexao.prepareStatement(sql);
            if (!(prCaixa == null || prCaixa.getAuxFechamentoData()== null)){
                stmt.setTimestamp(1, prCaixa.getAuxFechamentoData());
                stmt.setTimestamp(2, prCaixa.getAuxFechamentoData());
            }
            rs = stmt.executeQuery();            
            if(rs.next())            
                return ((rs.getDouble("VENDAS")) - (rs.getDouble("COMPRAS")));
            else
                return null;            
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar saldo, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static Caixa PesquisaUltimoCaixa(){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM caixa ORDER BY cod_caixa DESC LIMIT 1";
        try {
            stmt = conexao.prepareStatement(sql);            
            rs = stmt.executeQuery();            
            if(rs.next())
                return new Caixa(rs.getInt("cod_caixa"), new Usuario(rs.getInt("cod_usuario")), rs.getString("fechamento_data"), rs.getDouble("valor"), rs.getBoolean("ativo"));                                            
            else 
                return null;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar caixa, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static Caixa PesquisaUltimoCaixaComTimesTamp(){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM caixa ORDER BY cod_caixa DESC LIMIT 1";
        try {
            stmt = conexao.prepareStatement(sql);            
            rs = stmt.executeQuery();            
            Caixa caixa = null;
            if(rs.next()){
                caixa = new Caixa();
                caixa.setCodCaixa(rs.getInt("cod_caixa"));
                caixa.setUsuario(new Usuario(rs.getInt("cod_usuario")));
                caixa.setAuxFechamentoData(rs.getTimestamp("fechamento_data"));
                caixa.setValor(rs.getDouble("valor"));
                caixa.setAtivo(rs.getBoolean("ativo"));
                return caixa;
            }   
            else 
                return null;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar caixa, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<Caixa> PesquisaTodos(){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT cx.*, u.login FROM caixa cx INNER JOIN usuarios u ON u.cod_usuario = cx.cod_usuario ORDER BY cx.cod_caixa";
        try {
            stmt = conexao.prepareStatement(sql);            
            rs = stmt.executeQuery();            
            List<Caixa> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Caixa(rs.getInt("cod_caixa"), new Usuario(rs.getInt("cod_usuario"), rs.getString("login")), rs.getString("fechamento_data"), rs.getDouble("valor"), rs.getBoolean("ativo")));                                            
            }
            return lista;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar caixas, entre em contato com o suporte do sistema ");
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
