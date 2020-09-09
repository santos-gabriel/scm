/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import mensagens.Erro;
import utilitarios.UsuariosUtil;

/**
 *
 * @author Gabriel
 */
public class FrmPrincipal extends javax.swing.JFrame {
    
    private FrmCadUsuario FRM_CAD_USUARIO;
    private FrmCadCargo   FRM_CAD_CARGO;
    
    private Timer TIMER;
    
    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        lblUsuario.setText(UsuariosUtil.getUsuario().getLogin());
        TIMER = new Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                lblTime.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()));
            }
        };
        TIMER.schedule(tk, 0, 1000);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        lblCadastroUsuarios = new javax.swing.JLabel();
        panelBody = new javax.swing.JPanel();
        imgPrincipalCenter = new javax.swing.JLabel();
        panelFooter = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        menuSuperior = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        subMenuCadastroUsuarios = new javax.swing.JMenuItem();
        subMenuCadastroCargos = new javax.swing.JMenuItem();
        menuMovimentacoes = new javax.swing.JMenu();
        subMenuEntradas = new javax.swing.JMenuItem();
        subMenuSaidas = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stock Control Manager");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelHeader.setBackground(new java.awt.Color(255, 255, 255));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-sistema-150-75.png"))); // NOI18N

        lblCadastroUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuarios-90-90.png"))); // NOI18N
        lblCadastroUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCadastroUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadastroUsuariosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCadastroUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgLogo)
                .addContainerGap())
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblCadastroUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );

        panelBody.setBackground(new java.awt.Color(102, 153, 255));

        imgPrincipalCenter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgPrincipalCenter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-emporio-cardoso.png"))); // NOI18N

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgPrincipalCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgPrincipalCenter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );

        panelFooter.setBackground(new java.awt.Color(255, 255, 255));

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUsuario.setText("USUARIO_LOGIN");

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTime.setText("dd/MM/yyyy hh:MM");

        javax.swing.GroupLayout panelFooterLayout = new javax.swing.GroupLayout(panelFooter);
        panelFooter.setLayout(panelFooterLayout);
        panelFooterLayout.setHorizontalGroup(
            panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFooterLayout.createSequentialGroup()
                .addContainerGap(606, Short.MAX_VALUE)
                .addComponent(lblUsuario)
                .addGap(65, 65, 65)
                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        panelFooterLayout.setVerticalGroup(
            panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFooterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(lblTime))
                .addContainerGap())
        );

        menuSuperior.setBackground(new java.awt.Color(255, 255, 255));

        menuCadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/application_add.png"))); // NOI18N
        menuCadastros.setText("Cadastros");

        subMenuCadastroUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        subMenuCadastroUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/user_orange.png"))); // NOI18N
        subMenuCadastroUsuarios.setText("Usuários");
        subMenuCadastroUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCadastroUsuariosActionPerformed(evt);
            }
        });
        menuCadastros.add(subMenuCadastroUsuarios);

        subMenuCadastroCargos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/vcard.png"))); // NOI18N
        subMenuCadastroCargos.setText("Cargos");
        subMenuCadastroCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCadastroCargosActionPerformed(evt);
            }
        });
        menuCadastros.add(subMenuCadastroCargos);

        menuSuperior.add(menuCadastros);

        menuMovimentacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/basket.png"))); // NOI18N
        menuMovimentacoes.setText("Movimentações");

        subMenuEntradas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/basket_go.png"))); // NOI18N
        subMenuEntradas.setText("Entradas");
        menuMovimentacoes.add(subMenuEntradas);

        subMenuSaidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/basket_go.png"))); // NOI18N
        subMenuSaidas.setText("Saídas");
        menuMovimentacoes.add(subMenuSaidas);

        menuSuperior.add(menuMovimentacoes);

        menuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/information.png"))); // NOI18N
        menuSobre.setText("Sobre");
        menuSuperior.add(menuSobre);

        setJMenuBar(menuSuperior);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelFooter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        TIMER.cancel();
    }//GEN-LAST:event_formWindowClosing

    private void subMenuCadastroUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCadastroUsuariosActionPerformed
        List<String> permissoes = UsuariosUtil.getPermissao("SIS_MODULO_USUARIOS");
        if (permissoes.isEmpty()){
            Erro.show("Você não tem permissão para acessar este módulo");
            return;
        }else{
            if (FRM_CAD_USUARIO == null)
                FRM_CAD_USUARIO = new FrmCadUsuario();
            for (String permissao : permissoes){
                switch(permissao){
                    case "INSERIR":
                        FRM_CAD_USUARIO.setINSERIR(true);
                        break;
                    case "ATUALIZAR":
                        FRM_CAD_USUARIO.setATUALIZAR(true);
                        break;
                    case "INATIVAR":
                        FRM_CAD_USUARIO.setINATIVAR(true);
                        break;
                    case "CONSULTAR":
                        FRM_CAD_USUARIO.setCONSULTAR(true);
                        break;
                }
            }
            FRM_CAD_USUARIO.carregarPermissoes();
            FRM_CAD_USUARIO.setVisible(true);
        }
    }//GEN-LAST:event_subMenuCadastroUsuariosActionPerformed

    private void lblCadastroUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastroUsuariosMouseClicked
        subMenuCadastroUsuariosActionPerformed(null);
    }//GEN-LAST:event_lblCadastroUsuariosMouseClicked

    private void subMenuCadastroCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCadastroCargosActionPerformed
        List<String> permissoes = UsuariosUtil.getPermissao("SIS_MODULO_CARGOS");
        if (permissoes.isEmpty()){
            Erro.show("Você não tem permissão para acessar este módulo");
            return;
        }else{
            if (FRM_CAD_CARGO == null)
                FRM_CAD_CARGO = new FrmCadCargo();
            for (String permissao : permissoes){
                switch(permissao){
                    case "INSERIR":
                        FRM_CAD_CARGO.setINSERIR(true);
                        break;
                    case "ATUALIZAR":
                        FRM_CAD_CARGO.setATUALIZAR(true);
                        break;
                    case "INATIVAR":
                        FRM_CAD_CARGO.setINATIVAR(true);
                        break;
                    case "CONSULTAR":
                        FRM_CAD_CARGO.setCONSULTAR(true);
                        break;
                }
            }
            FRM_CAD_CARGO.carregarPermissoes();
            FRM_CAD_CARGO.setVisible(true);
        }
    }//GEN-LAST:event_subMenuCadastroCargosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel imgPrincipalCenter;
    private javax.swing.JLabel lblCadastroUsuarios;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuMovimentacoes;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JMenuBar menuSuperior;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelFooter;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JMenuItem subMenuCadastroCargos;
    private javax.swing.JMenuItem subMenuCadastroUsuarios;
    private javax.swing.JMenuItem subMenuEntradas;
    private javax.swing.JMenuItem subMenuSaidas;
    // End of variables declaration//GEN-END:variables
}
