/**
 * FUNÇÕES ÚTEIS, GENÉRICAS E ABSTRATAS
 */
package utilitarios;

import excecoes.ExcecaoFiles;
import excecoes.ExcecaoGenerica;
import excecoes.ExcecaoNetWork;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**Classe de funções úteis 
 * @author Gabriel
 * @version %I%, %G%
 * @since v1.0
 */
public abstract class Funcoes {
   
    /**Método para criptografar com hash md5
     * @param pTexto texto a ser criptografado
     * @return String - hash md5 gerado do texto passado como parâmetro
     * @since v1.0
     */
    public static String getEncrypt (String pTexto){
        try{
            // hash armazena senha encriptada com instancia MD5
            BigInteger hash = new BigInteger (1, MessageDigest.getInstance("MD5").digest(pTexto.getBytes()));
            return hash.toString(16); // retorna senha encriptada em forma de string
        }catch(Exception e){
            throw new ExcecaoFiles(e, "Falha ao realizar criptografia, entre em contato com o suporte do sistema");
        }
    } 
   
   
    /**Método para pegar os valores das propriedades de um arquivo properties de configuração
     * @param pPath diretório onde se encontra o arquivo
     * @return Properties - propriedades do arquivo
     * @since v1.0
     */  
    public static Properties getProperties(String pPath){
        Properties props = new Properties();
        // instancia um objeto properties
        try {
            props.load(new FileInputStream(pPath)); // lê o arquivo de configurações
            return props;                          // retorna as propriedades do arquivo de configurações
        } catch (Exception e) {
            throw new ExcecaoFiles(e, "Falha ao ler arquivo de configurações, entre em contato com o suporte do sistema");
        }
    }
   
    /**Método para pegar o endereço de ip da máquina
     * @return String - endereço de ip da máquina
     * @since v1.0
     */
    public static String getIpHost (){
        try {
           return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            throw new ExcecaoNetWork(e, "Falha ao reconhecer endereço ip da máquina, entre em contato com o suporte do sistema");
        }
    }
    
    /**Método para pegar o hostname da máquina
     * @return String - hostname na máquina
     * @since v1.0
     */
    public static String getNameHost (){
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            throw new ExcecaoNetWork(e, "Falha ao reconhecer nome da máquina, entre em contato com o suporte do sistema");
        }
    }
    
    /**Método para tratar data para que possa ser enviada para o Banco, ex.: dd/MM/yyyy passada como parâmetro será retornada como yyyy-MM-dd
     * @return String - data em yyyy-MM-dd
     * @param prData data em dd/MM/yyyy
     * @since v1.0
     */
    public static String trataDataParaDb(String prData) {
        try {
            String dia = prData.substring(0, 2);
            String mes = prData.substring(3, 5);
            String ano = prData.substring(6, 10);
            return ano + "-" + mes + "-" + dia;
        } catch(Exception e){
            throw new ExcecaoGenerica(e);
        }
    }
    
    /**Método para tratar data que está armazenada no banco de dados, ex.: yyyy-MM-dd passada como parâmetro será retornada como dd/MM/yyyy
     * @return String - data em dd/MM/yyyy
     * @param prData data em yyyy-MM-dd
     * @since v1.0
     */
    public static String trataDataDoDb(String prData) {
        try {
            String ano = prData.substring(0, 4);
            String mes = prData.substring(5, 7);
            String dia = prData.substring(8, 10);
            return dia + "/" + mes + "/" + ano;
        } catch(Exception e){
            throw new ExcecaoGenerica(e);
        }
    }
    
    /**Método para tratar data e hora que será enviada para o banco de dados
     * @return String - data e hora em YYYY-MM-dd HH:mm
     * @param prDataHora data e hora em dd/MM/yyyy HH:mm
     * @since v1.0
     */
    public static String trataDataHoraParaDb(String prDataHora){
        try {
            String dia    = prDataHora.substring(0, 2);
            String mes    = prDataHora.substring(3, 5);
            String ano    = prDataHora.substring(6, 10);
            String hora   = prDataHora.substring(11, 13);
            String minuto = prDataHora.substring(14, 16);
            return ano + "-" + mes + "-" + dia + " " + hora + ":" + minuto;
        } catch(Exception e){
            throw new ExcecaoGenerica(e);
        }
    }
    
    /**Método que trata data e hora do banco de dados
     * @return String - data e hora em dd/MM/yyyy HH:mm
     * @param prDataHora data e hora em yyyy-MM-dd HH:mm
     * @since v1.0
     */
    public static String trataDataHoraDoDb(String prDataHora){
        try {
            String ano    = prDataHora.substring(0, 4);
            String mes    = prDataHora.substring(5, 7);
            String dia    = prDataHora.substring(8, 10);
            String hora   = prDataHora.substring(11, 13);
            String minuto = prDataHora.substring(14, 16);
            return dia + "/" + mes + "/" + ano + " " + hora + ":" + minuto;
        } catch(Exception e){
            throw new ExcecaoGenerica(e);
        }
    }    
    
    /**Método que verifica se a data passada como String é válida
     * @return  boolean - true para data válida, false para data inválida
     * @param prData data para ser validada em formato dd/MM/yyyy
     * @since v1.0
     */
    public static boolean validaData(String prData){
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            try {
                df.parse(prData);
                return true;
            } catch (ParseException ex) {
                return false;
            }        
        } catch(Exception e){
            throw new ExcecaoGenerica(e);
        }
    }
    
    /**Método que compara duas datas passadas como String
     * @return Integer - retorna valor menor que 0 caso prDataInical for menor que prDataFinal; retorna 0 caso prDataInical for igual a prDataFinal; retorna maior que 0 caso prDataInical for maior que prDataFinal
     * @param prDataInicial data inicial para comparação em formato dd/MM/yyyy
     * @param prDataFinal data final para comparação em formato dd/MM/yyyy
     * @since v1.0
     */
    public static Integer comparaDatas(String prDataInicial, String prDataFinal){
        try {
            Date dataInicial, dataFinal;
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            try {
                dataInicial = formato.parse(prDataInicial);
                dataFinal   = formato.parse(prDataFinal);
                if (dataInicial.compareTo(dataFinal) < 0)
                    return -1;
                else if (dataInicial.compareTo(dataFinal) == 0)
                    return 0;
                else 
                    return 1;
            } catch (ParseException ex) {
                return null;
            }
        } catch(Exception e){
            throw new ExcecaoGenerica(e);
        }
    }
    
    /**Método que valida cpf
     * @return boolean - true cpf para válido false para inválido
     * @param cpf String contendo cpf que será validado
     * @since v1.0
     */
    public static boolean validaCpf(String cpf) {
        return Cnp.isValidCPF(cpf);
    }
   
    /**Método que valida cnpj
     * @return boolean - true para cnpj válido e false para inválido
     * @param cnpj Sring contendo cnpj que será validado
     * @since v1.0
     */
    public static boolean validaCnpj(String cnpj) {
        return Cnp.isValidCNPJ(cnpj);
    }
}
