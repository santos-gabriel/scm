/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controllers.CtrlFuncionario;
import controllers.CtrlRelatorios;
import excecoes.ExcecaoGenerica;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import mensagens.Erro;
import mensagens.Informacao;
import modelo.Funcionario;
import net.sf.jasperreports.view.JasperViewer;
import utilitarios.Funcoes;

/**
 *
 * @author Gabriel
 */
public class FrmRelVendas extends javax.swing.JFrame {

    /**
     * Creates new form FrmRelVendas
     */
    public FrmRelVendas() {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
        Date hoje = new Date();
        txtDataInicial.setText(sdf.format(Funcoes.alteraDias(-30, hoje)));
        txtDataFinal.setText(sdf.format(hoje));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ckFuncionario = new javax.swing.JCheckBox();
        txtDataInicial = new javax.swing.JFormattedTextField();
        txtDataFinal = new javax.swing.JFormattedTextField();
        cbxFuncionario = new javax.swing.JComboBox<>();
        btnGerarRelatorio = new javax.swing.JButton();
        ckRelDetalhado = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatórios | Relatório de Vendas");
        setResizable(false);

        jLabel1.setText("Data Inicial");

        jLabel2.setText("Data Final");

        ckFuncionario.setText("Filtrar por Funcionário");
        ckFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckFuncionarioActionPerformed(evt);
            }
        });

        try {
            txtDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/report_magnify.png"))); // NOI18N
        btnGerarRelatorio.setText("Gerar Relatório");
        btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioActionPerformed(evt);
            }
        });

        ckRelDetalhado.setText("Relatório Detalhado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ckRelDetalhado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGerarRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cbxFuncionario, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(ckFuncionario)
                            .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(ckFuncionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckRelDetalhado)
                    .addComponent(btnGerarRelatorio))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ckFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckFuncionarioActionPerformed
        if (ckFuncionario.isSelected())
            carregarCombobox();
        else
            cbxFuncionario.removeAllItems();        
    }//GEN-LAST:event_ckFuncionarioActionPerformed

    private void btnGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelatorioActionPerformed
        if (txtDataInicial.getText() == null || txtDataInicial.getText().isEmpty() || txtDataInicial.getText().equals("  /  /    ")){
            Erro.show("Informe a data inicial ");
            return;
        } else if (!Funcoes.validaData(txtDataInicial.getText())){
            Erro.show("Data inicial inválida");
            return;
        }
        if (txtDataFinal.getText() == null || txtDataFinal.getText().isEmpty() || txtDataFinal.getText().equals("  /  /    ")){
            Erro.show("Informe a data final ");
            return;
        } else if (!Funcoes.validaData(txtDataFinal.getText())) {
            Erro.show("Data final inválida");
            return;
        }
        if (Funcoes.comparaDatas(txtDataInicial.getText(), txtDataFinal.getText()) > 0){
            Erro.show("Datas inválidas");
            return;
        }
        if (ckFuncionario.isSelected()){
            if (!(cbxFuncionario.getSelectedIndex() > 0)){
                Erro.show("Informe o funcionário ");
                return;
            }
        }   
        try {
            Map parametros = new HashMap();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataFinal = Funcoes.alteraDias(1, formato.parse(txtDataFinal.getText()));
            parametros.put("prDataIni", Funcoes.trataDataParaDb(txtDataInicial.getText()));
            parametros.put("prDataFim", Funcoes.trataDataParaDb(formato.format(dataFinal)));
            if (ckFuncionario.isSelected()){
                String codFuncionario = Integer.toString(((Funcionario)cbxFuncionario.getSelectedItem()).getCod_Funcionario());
                parametros.put("prFuncionario", "vend.cod_funcionario = "+codFuncionario);
            }else 
                parametros.put("prFuncionario", "1 = 1");                
            JasperViewer jasperViewer = null;
            if (ckRelDetalhado.isSelected())
                jasperViewer = CtrlRelatorios.gerarRelatorio("src/relatorios/rel-vendas-detalhado.jasper", parametros, "Relatório Detalhado de Vendas");            
            else 
                jasperViewer = CtrlRelatorios.gerarRelatorio("src/relatorios/rel-vendas.jasper", parametros, "Relatório de Vendas");        
            if (jasperViewer == null)
                Informacao.show("Relatório sem páinas");
            else
                jasperViewer.setVisible(true);
        } catch(Exception e){
            throw new ExcecaoGenerica(e);
        }
    }//GEN-LAST:event_btnGerarRelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRelVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRelVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRelVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRelVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRelVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JComboBox<Funcionario> cbxFuncionario;
    private javax.swing.JCheckBox ckFuncionario;
    private javax.swing.JCheckBox ckRelDetalhado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txtDataFinal;
    private javax.swing.JFormattedTextField txtDataInicial;
    // End of variables declaration//GEN-END:variables
    
    private void limparTodosCampos(){
        txtDataFinal.setText("");
        txtDataInicial.setText("");
    }
    
    private void carregarCombobox(){
        try {
            cbxFuncionario.removeAllItems();
            cbxFuncionario.addItem(new Funcionario(0, "Selecione"));
            CtrlFuncionario.PesquisarTodos().forEach(funcionario -> {
                cbxFuncionario.addItem(funcionario);
            });
        } catch(Exception e){
            throw new ExcecaoGenerica(e);
        }
    }    
    
}
