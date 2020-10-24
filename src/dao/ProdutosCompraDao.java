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
import java.util.ArrayList;
import java.util.List;
import modelo.ProdutosCompra;

/**
 *
 * @author Gabriel
 */
public abstract class ProdutosCompraDao {
    private static Connection conexao = null;
    
    
    public static void Inserir(ProdutosCompra prProdutosCompra){
       CriarConexoes();
       String sql = "INSERT INTO produto_compra(cod_compra, cod_rastreio_produto, ativo) VALUES (?, ?, true)";
       PreparedStatement stmt = null;
       try {
           stmt = conexao.prepareStatement(sql);
           stmt.setInt(1, prProdutosCompra.getCompra().getCodCompra());
           stmt.setInt(2, prProdutosCompra.getRastreioProduto().getCod_rastreio_produto());
           stmt.executeUpdate();
       } catch (Exception e) {
           throw new ExcecaoDB(e, "Falha ao salvar comissao, entre em contato com o suporte do sistema ");
       }finally{
           FecharConexoes(conexao, stmt, null);
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
