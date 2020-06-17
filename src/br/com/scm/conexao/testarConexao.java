/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scm.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class testarConexao {
    
    
     public static void main (String [] args){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        
        try{
            
            conn = ConexaoMySql.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COD_BAIRRO, NOME_BAIRRO, COD_CIDADE FROM BAIRRO ");
            
            while(rs.next()){
                System.out.println(rs.getInt("COD_BAIRRO")+", "+rs.getString("NOME_BAIRRO")+", "+rs.getString("COD_CIDADE"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ConexaoMySql.closeConnection(conn);
            try {
                st.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(testarConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
