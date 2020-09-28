/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controllers.CtrlComissoes;
import javax.swing.table.DefaultTableModel;
import mensagens.Erro;
import mensagens.Informacao;
import modelo.Comissoes;

/**
 *
 * @author Guilherme
 */
public class FrmCadComissoes extends javax.swing.JFrame {
    
    private Comissoes COMISSAO = null;
    
    /**
     * Creates new form FrmTipoPagamento
     */
    public FrmCadComissoes() {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        carregarRegistros();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComissoes = new javax.swing.JTable();
        ButonSalvar = new javax.swing.JLabel();
        ButtonExcluir = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ButtonNovo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        undMedida = new javax.swing.JComboBox<>();
        TxtValor = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro | Comissões");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        jLabel1.setText("Código");

        TxtCodigo.setEditable(false);

        tblComissoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Medida", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblComissoes.getTableHeader().setReorderingAllowed(false);
        tblComissoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblComissoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblComissoes);

        ButonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salvar.png"))); // NOI18N
        ButonSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButonSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButonSalvarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButonSalvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButonSalvarMouseExited(evt);
            }
        });

        ButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        ButtonExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonExcluirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonExcluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonExcluirMouseExited(evt);
            }
        });

        jLabel3.setText("Valor");

        ButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Novo.png"))); // NOI18N
        ButtonNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonNovoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonNovoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonNovoMouseExited(evt);
            }
        });

        jLabel4.setText("Und. Medida");

        undMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "R$", "U$" }));
        undMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undMedidaActionPerformed(evt);
            }
        });

        TxtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(undMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(ButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(undMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ButonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ButtonExcluir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButonSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButonSalvarMouseEntered
        ButonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salvar2.png")));
    }//GEN-LAST:event_ButonSalvarMouseEntered

    private void ButonSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButonSalvarMouseExited
        ButonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salvar.png")));
    }//GEN-LAST:event_ButonSalvarMouseExited

    private void ButtonExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonExcluirMouseEntered
        ButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir2.png")));
    }//GEN-LAST:event_ButtonExcluirMouseEntered

    private void ButtonExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonExcluirMouseExited
        ButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png")));
    }//GEN-LAST:event_ButtonExcluirMouseExited

    private void ButtonNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonNovoMouseEntered
        ButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Novo2.png")));
    }//GEN-LAST:event_ButtonNovoMouseEntered

    private void ButtonNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonNovoMouseExited
        ButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Novo.png")));
    }//GEN-LAST:event_ButtonNovoMouseExited

    private void ButtonNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonNovoMouseClicked
        COMISSAO = null;
        limpaCamposTextos();
    }//GEN-LAST:event_ButtonNovoMouseClicked

    private void ButtonExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonExcluirMouseClicked
        if (TxtCodigo.getText() == null || TxtCodigo.getText().isEmpty())
            return;
        if (COMISSAO == null)
            COMISSAO = new Comissoes();
        COMISSAO.setCod_comissao(Integer.parseInt(TxtCodigo.getText()));
        CtrlComissoes.Excluir(COMISSAO);
        limpaCamposTextos();
        carregarRegistros();
        Informacao.show("Comissão inativada com sucesso! ");
    }//GEN-LAST:event_ButtonExcluirMouseClicked

    private void ButonSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButonSalvarMouseClicked
        
        if (TxtValor.getText() == null || TxtValor.getText().isEmpty()){
            Erro.show("Informe o valor! ");
            return;
        }
        
        if (COMISSAO == null)
            COMISSAO = new Comissoes();
        COMISSAO.setAtivo(true);
        COMISSAO.setUnidade_medida(undMedida.getSelectedItem().toString());
        COMISSAO.setValor_comisssao(trataValor(TxtValor.getText()));
        
        if (TxtCodigo.getText() == null || TxtCodigo.getText().isEmpty()){
            CtrlComissoes.SalvarTodosCampos(COMISSAO);
            Informacao.show("Comissão salva com sucesso! ");
        } else {
            COMISSAO.setCod_comissao(Integer.parseInt(TxtCodigo.getText()));
            CtrlComissoes.AtualizarTodosCampos(COMISSAO);
            Informacao.show("Comissão atualizada com sucesso! ");
        }
        carregarRegistros();
        limpaCamposTextos();
    }//GEN-LAST:event_ButonSalvarMouseClicked

    private void undMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_undMedidaActionPerformed

    private void tblComissoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComissoesMouseClicked
        if (tblComissoes.getSelectedRow() != -1){
            limpaCamposTextos();
            TxtCodigo.setText(String.valueOf(tblComissoes.getModel().getValueAt(tblComissoes.getSelectedRow(), 0)));
            if (String.valueOf(tblComissoes.getModel().getValueAt(tblComissoes.getSelectedRow(), 1)).equals("R$"))
                undMedida.setSelectedIndex(0);
            else if (String.valueOf(tblComissoes.getModel().getValueAt(tblComissoes.getSelectedRow(), 1)).equals("U$"))
                undMedida.setSelectedIndex(1);
            TxtValor.setText(String.valueOf(tblComissoes.getModel().getValueAt(tblComissoes.getSelectedRow(), 2)));
        }
    }//GEN-LAST:event_tblComissoesMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCadComissoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadComissoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadComissoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadComissoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadComissoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ButonSalvar;
    private javax.swing.JLabel ButtonExcluir;
    private javax.swing.JLabel ButtonNovo;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JFormattedTextField TxtValor;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblComissoes;
    private javax.swing.JComboBox<String> undMedida;
    // End of variables declaration//GEN-END:variables

    private void carregarRegistros(){
        DefaultTableModel modelo = (DefaultTableModel) tblComissoes.getModel();
        modelo.setNumRows(0);
        CtrlComissoes.PesquisarTodos().forEach((c) -> {
            modelo.addRow(new Object []{
                c.getCod_comissao(),
                c.getUnidade_medida(),
                c.getValor_comisssao()
            });
        });
    }
    
    private Double trataValor(String prValor){
        return Double.parseDouble(prValor.replaceAll(",", "."));
    }

    private String formataValor(Double prValor){
        return Double.toString(prValor).replaceAll(".", ",");
    }

    private void limpaCamposTextos() {
        TxtCodigo.setText("");
        TxtValor.setText("");
    }
    
}
