/**
 * FUNÇÕES ÚTEIS, GENÉRICAS E ABSTRATAS
 */
package UTILITARIOS;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Properties;

/**
 * @author Gabriel
 */
public abstract class Funcoes {
   
// MÉTODO QUE CRIPTGRAFA UMA STRING
   public static String getEncrypt (String pTexto){
        try{
            // hash armazena senha encriptada com instancia MD5
            BigInteger hash = new BigInteger (1, MessageDigest.getInstance("MD5").digest(pTexto.getBytes()));
            return hash.toString(16); // retorna senha encriptada em forma de string
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
   } 
   
   
// MÉTODO PARA PEGAR OS VALORES DE UM ARQUIVO DE CONFIGURÇÕES  
   public static Properties getProperties(String path){
        Properties props = new Properties();
        // instancia um objeto properties
        try {
            props.load(new FileInputStream(path)); // lê o arquivo de configurações
            return props;                          // retorna as propriedades do arquivo de configurações
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
   }
    
}
