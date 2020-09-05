/**
 * FUNÇÕES ÚTEIS, GENÉRICAS E ABSTRATAS
 */
package utilitarios;

import excecoes.ExcecaoFiles;
import excecoes.ExcecaoNetWork;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.util.Properties;

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
    
}
