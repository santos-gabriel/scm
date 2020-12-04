package modelo;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Gabriel
 */
public class JasperViewerExtend extends JasperViewer {
    
    public JasperViewerExtend(JasperPrint jasperPrint, boolean isXMLFile) throws JRException {
        super(jasperPrint, isXMLFile);
        super.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png")).getImage());        
    }
    
    public JasperViewerExtend(JasperPrint jasperPrint, boolean isXMLFile, String title) throws JRException {
        super(jasperPrint, isXMLFile);
        super.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        super.setTitle(title);
    }
    
}
