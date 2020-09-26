/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controllers.CtrlCondicaoPagamento;
import javax.swing.table.DefaultTableModel;
import mensagens.Informacao;
import modelo.CondicaoPagamento;

/**
 *
 * @author Guilherme
 */
public class FrmCadCondicaoPagamento extends javax.swing.JFrame {

    private CondicaoPagamento CONDICAO_PAGAMENTO = null;
    
    /**
     * Creates new form FrmTipoPagamento
     */
    public FrmCadCondicaoPagamento() {
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
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCondicoesPagamentos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtQtdParcelas = new javax.swing.JTextField();
        ButonNovo = new javax.swing.JLabel();
        ButonSalvar1 = new javax.swing.JLabel();
        ButtonExcluir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastros | Condições de Pagamentos");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        jLabel1.setText("Código");

        txtCodigo.setEditable(false);

        jLabel2.setText("Descrição");

        tblCondicoesPagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Qtd Parcelas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCondicoesPagamentos.getTableHeader().setReorderingAllowed(false);
        tblCondicoesPagamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCondicoesPagamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCondicoesPagamentos);

        jLabel3.setText("Quantidade de Parcels");

        ButonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Novo.png"))); // NOI18N
        ButonNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButonNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButonNovoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButonNovoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButonNovoMouseExited(evt);
            }
        });

        ButonSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salvar.png"))); // NOI18N
        ButonSalvar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButonSalvar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButonSalvar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButonSalvar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButonSalvar1MouseExited(evt);
            }
        });

        ButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Inativar.png"))); // NOI18N
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQtdParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ButonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButonSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(ButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtQtdParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ButonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButonSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButonNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButonNovoMouseEntered
        ButonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Novo2.png")));
    }//GEN-LAST:event_ButonNovoMouseEntered

    private void ButonNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButonNovoMouseExited
        ButonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Novo.png")));
    }//GEN-LAST:event_ButonNovoMouseExited

    private void ButonSalvar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButonSalvar1MouseEntered
        ButonSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salvar2.png")));
    }//GEN-LAST:event_ButonSalvar1MouseEntered

    private void ButonSalvar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButonSalvar1MouseExited
        ButonSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salvar.png")));
    }//GEN-LAST:event_ButonSalvar1MouseExited

    private void ButtonExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonExcluirMouseEntered
        ButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Inativar2.png")));
    }//GEN-LAST:event_ButtonExcluirMouseEntered

    private void ButtonExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonExcluirMouseExited
        ButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Inativar.png")));
    }//GEN-LAST:event_ButtonExcluirMouseExited

    private void ButonNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButonNovoMouseClicked
        limparTodosCampos();
        CONDICAO_PAGAMENTO = null;
    }//GEN-LAST:event_ButonNovoMouseClicked

    private void ButonSalvar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButonSalvar1MouseClicked
        if (txtDescricao.getText() == null || txtDescricao.getText().isEmpty()){
            Informacao.show("Informe a descrição");
            return;
        }
        if (txtQtdParcelas.getText() == null || txtQtdParcelas.getText().isEmpty()){
            Informacao.show("Informe a quantidade de parcelas");
            return;
        }
        if (CONDICAO_PAGAMENTO == null)
            CONDICAO_PAGAMENTO = new CondicaoPagamento();
        CONDICAO_PAGAMENTO.setAtivo(true);
        CONDICAO_PAGAMENTO.setDesc_condicao_pagamento(txtDescricao.getText());
        CONDICAO_PAGAMENTO.setQuantidade_parcelas(Integer.parseInt(txtQtdParcelas.getText()));
        if (txtCodigo.getText() == null || txtCodigo.getText().isEmpty()){
            CtrlCondicaoPagamento.SalvarTodosCampos(CONDICAO_PAGAMENTO);
            Informacao.show("Condição de pagamento salva com sucesso ");
        } else {
            CONDICAO_PAGAMENTO.setCod_condicao_pagamento(Integer.parseInt(txtCodigo.getText()));
            CtrlCondicaoPagamento.AtualizarTodosCampos(CONDICAO_PAGAMENTO);
            Informacao.show("Condição de pagamento atualizada com sucesso ");
        }
        carregarRegistros();
        limparTodosCampos();
    }//GEN-LAST:event_ButonSalvar1MouseClicked

    private void ButtonExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonExcluirMouseClicked
        if (txtCodigo.getText() == null || txtCodigo.getText().isEmpty())
            return;
        if (CONDICAO_PAGAMENTO == null)
            CONDICAO_PAGAMENTO = new CondicaoPagamento();
        CONDICAO_PAGAMENTO.setCod_condicao_pagamento(Integer.parseInt(txtCodigo.getText()));
        CtrlCondicaoPagamento.Excluir(CONDICAO_PAGAMENTO);
        carregarRegistros();
        limparTodosCampos();
    }//GEN-LAST:event_ButtonExcluirMouseClicked

    private void tblCondicoesPagamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCondicoesPagamentosMouseClicked
        if (evt.getClickCount() >= 2){
            txtCodigo.setText((String.valueOf(tblCondicoesPagamentos.getModel().getValueAt(tblCondicoesPagamentos.getSelectedRow(), 0))));
            txtDescricao.setText((String.valueOf(tblCondicoesPagamentos.getModel().getValueAt(tblCondicoesPagamentos.getSelectedRow(), 1))));
            txtQtdParcelas.setText((String.valueOf(tblCondicoesPagamentos.getModel().getValueAt(tblCondicoesPagamentos.getSelectedRow(), 2))));
        }
    }//GEN-LAST:event_tblCondicoesPagamentosMouseClicked

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
            java.util.logging.Logger.getLogger(FrmCadCondicaoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadCondicaoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadCondicaoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadCondicaoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadCondicaoPagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ButonNovo;
    private javax.swing.JLabel ButonSalvar1;
    private javax.swing.JLabel ButtonExcluir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCondicoesPagamentos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtQtdParcelas;
    // End of variables declaration//GEN-END:variables
    
    private void limparTodosCampos() {
        txtCodigo.setText("");
        txtDescricao.setText("");
        txtQtdParcelas.setText("");
    }
    
    private void carregarRegistros() {
        DefaultTableModel modelo = (DefaultTableModel) tblCondicoesPagamentos.getModel();
        modelo.setNumRows(0);
        CtrlCondicaoPagamento.PesquisarTodos().forEach((cp) -> {
            modelo.addRow(new Object []{
                cp.getCod_condicao_pagamento(),
                cp.getDesc_condicao_pagamento(),
                cp.getQuantidade_parcelas()
            });
        });
    }
    
}
