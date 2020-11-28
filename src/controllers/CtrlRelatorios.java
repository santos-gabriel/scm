package controllers;

import conexao.Conexao;
import excecoes.ExcecaoFiles;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Gabriel
 */
public abstract class CtrlRelatorios {
            
    public static JasperViewer gerarRelatorio(String caminhoArquivo){
        Connection conexao = null;
        JasperPrint jasperPrint = null;
        try{
            conexao = Conexao.conectar();
            jasperPrint = JasperFillManager.fillReport(caminhoArquivo, null, conexao);
            return new JasperViewer(jasperPrint, false);
        }catch (JRException ex){
            throw new ExcecaoFiles(ex, "Erro ao emitir relatório, entre em contato com o suporte do sistema");
        }finally{
            Conexao.desconectar(conexao);
        }
    }
    
    public static JasperViewer gerarRelatorio(String caminhoArquivo, Map parametros){
        Connection conexao = null;
        JasperPrint jasperPrint = null;
        try{
            conexao = Conexao.conectar();
            jasperPrint = JasperFillManager.fillReport(caminhoArquivo, parametros, conexao);
            if (jasperPrint.getPages().size() == 0)
                return null;
            else 
                return new JasperViewer(jasperPrint, false);
        }catch (JRException ex){
            throw new ExcecaoFiles(ex, "Erro ao emitir relatório, entre em contato com o suporte do sistema");
        }finally{
            Conexao.desconectar(conexao);
        }
    }
    
}
