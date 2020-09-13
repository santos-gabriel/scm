/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import com.sun.glass.events.KeyEvent;
import controllers.CtrlEstado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mensagens.Erro;
import mensagens.Informacao;
import modelo.Estados;

/**
 *
 * @author Gabriel
 */
public class FrmCadEstado extends javax.swing.JFrame {

    private FrmSelecionaRegistro FRM_SELECIONA_REGISTRO = null;
    private Estados              ESTADO                 = null;
    
    
    /**
     * Creates new form FrmCadEstado
     */
    public FrmCadEstado() {
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

        pnlGeral = new javax.swing.JPanel();
        pnlDadosCadastrais = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodEstado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescEstado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUfEstado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtBuscaEstado = new javax.swing.JTextField();
        btnBuscaEstado = new javax.swing.JButton();
        pnlOpcoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnInativar = new javax.swing.JButton();
        pnlRegistros = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro | Estados");
        setResizable(false);

        pnlDadosCadastrais.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Código");

        txtCodEstado.setEditable(false);

        jLabel3.setText("Descrição");

        jLabel4.setText("UF");

        javax.swing.GroupLayout pnlDadosCadastraisLayout = new javax.swing.GroupLayout(pnlDadosCadastrais);
        pnlDadosCadastrais.setLayout(pnlDadosCadastraisLayout);
        pnlDadosCadastraisLayout.setHorizontalGroup(
            pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosCadastraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtCodEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosCadastraisLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtDescEstado))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(21, 21, 21))
        );
        pnlDadosCadastraisLayout.setVerticalGroup(
            pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosCadastraisLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jLabel1.setText("Buscar Estados");

        txtBuscaEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaEstadoKeyPressed(evt);
            }
        });

        btnBuscaEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/magnifier.png"))); // NOI18N
        btnBuscaEstado.setText("Buscar");
        btnBuscaEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDadosCadastrais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlGeralLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscaEstado)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeralLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscaEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(pnlDadosCadastrais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pnlOpcoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções"));

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/add.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/disk.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnInativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/delete.png"))); // NOI18N
        btnInativar.setText("Inativar");
        btnInativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInativarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpcoesLayout = new javax.swing.GroupLayout(pnlOpcoes);
        pnlOpcoes.setLayout(pnlOpcoesLayout);
        pnlOpcoesLayout.setHorizontalGroup(
            pnlOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInativar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlOpcoesLayout.setVerticalGroup(
            pnlOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcoesLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInativar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Decrição", "UF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEstados.getTableHeader().setReorderingAllowed(false);
        tblEstados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEstadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEstados);

        javax.swing.GroupLayout pnlRegistrosLayout = new javax.swing.GroupLayout(pnlRegistros);
        pnlRegistros.setLayout(pnlRegistrosLayout);
        pnlRegistrosLayout.setHorizontalGroup(
            pnlRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnlRegistrosLayout.setVerticalGroup(
            pnlRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlRegistros, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlOpcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        ESTADO = null;
        limparCamposTexto();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        if (txtDescEstado.getText() == null || txtDescEstado.getText().isEmpty()){
            Erro.show("Informe a descrição");
            return;
        }
        if (txtUfEstado.getText() == null || txtUfEstado.getText().isEmpty()){
            Erro.show("Informe uf");
            return;
        }
        
        
        if (ESTADO == null)
            ESTADO = new Estados();
        
        ESTADO.setDescricao(txtDescEstado.getText());
        ESTADO.setUf(txtUfEstado.getText());
        ESTADO.setAtivo(true);
        if (txtCodEstado.getText() == null || txtCodEstado.getText().isEmpty()){
            Integer codEstadoSalvo = CtrlEstado.SalvarTodosCampos(ESTADO);
            Informacao.show("Estado salvo com sucesso");
            txtCodEstado.setText(Integer.toString(codEstadoSalvo));
        } else{
            ESTADO.setCodEstado(Integer.parseInt(txtCodEstado.getText()));
            CtrlEstado.AtualizarTodosCampos(ESTADO);
            Informacao.show("Estado atualizado com sucesso");
        }
        carregarRegistros();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInativarActionPerformed
        if (txtCodEstado.getText() == null || txtCodEstado.getText().isEmpty())
            return;
        
        if (ESTADO == null)
            ESTADO = new Estados();
        ESTADO.setCodEstado(Integer.parseInt(txtCodEstado.getText()));
        CtrlEstado.Excluir(ESTADO);
        Informacao.show("Estado inativado com sucesso");
        carregarRegistros();
    }//GEN-LAST:event_btnInativarActionPerformed

    private void btnBuscaEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaEstadoActionPerformed
        JTable tabela = new JTable();
        List<String[]> dados = new ArrayList<>();
        
        Estados estado = new Estados();
        estado.setDescricao(txtBuscaEstado.getText());
        List<Estados> estadoPesquisa = CtrlEstado.PesquisarViaDescricaoInicia(estado);
        
        estadoPesquisa.forEach((e) -> {
            dados.add(new String[]{String.valueOf(e.getCodEstado()), e.getDescricao(), e.getUf()});
        });
        
        tabela.setModel(new DefaultTableModel(
            dados.toArray(new String[dados.size()][]),
            new String [] {"CODIGO", "DESCRICAO", "UF"}){
                boolean[] canEdit = new boolean []{false, false, false};
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }                
            });
        tabela.getTableHeader().setReorderingAllowed(false);
        
        if (FRM_SELECIONA_REGISTRO == null)
            FRM_SELECIONA_REGISTRO = new FrmSelecionaRegistro(this, true);
        FRM_SELECIONA_REGISTRO.preencheTabela(tabela.getModel(), tabela);
        FRM_SELECIONA_REGISTRO.setTitle("Estados | Seleção ");
        
        FRM_SELECIONA_REGISTRO.setVisible(true);
        
        String[] registroSelecionado = FRM_SELECIONA_REGISTRO.getDadosSelecao();
        if (registroSelecionado != null){
            txtCodEstado.setText(registroSelecionado[0]);
            txtDescEstado.setText(registroSelecionado[1]);
            txtUfEstado.setText(registroSelecionado[2]);
        }
    }//GEN-LAST:event_btnBuscaEstadoActionPerformed

    private void txtBuscaEstadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaEstadoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            btnBuscaEstadoActionPerformed(null);
    }//GEN-LAST:event_txtBuscaEstadoKeyPressed

    private void tblEstadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstadosMouseClicked
        if (evt.getClickCount() >= 2){
            txtCodEstado.setText(String.valueOf(tblEstados.getModel().getValueAt(tblEstados.getSelectedRow(), 0)));
            txtDescEstado.setText(String.valueOf(tblEstados.getModel().getValueAt(tblEstados.getSelectedRow(), 1)));
            txtUfEstado.setText(String.valueOf(tblEstados.getModel().getValueAt(tblEstados.getSelectedRow(), 2)));
        }
    }//GEN-LAST:event_tblEstadosMouseClicked

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
            java.util.logging.Logger.getLogger(FrmCadEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadEstado().setVisible(true);
            }
        });
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscaEstado;
    private javax.swing.JButton btnInativar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlDadosCadastrais;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlOpcoes;
    private javax.swing.JPanel pnlRegistros;
    private javax.swing.JTable tblEstados;
    private javax.swing.JTextField txtBuscaEstado;
    private javax.swing.JTextField txtCodEstado;
    private javax.swing.JTextField txtDescEstado;
    private javax.swing.JTextField txtUfEstado;
    // End of variables declaration//GEN-END:variables

    private void limparCamposTexto() {
        txtCodEstado.setText("");
        txtDescEstado.setText("");
        txtUfEstado.setText("");
    }
    
    private void carregarRegistros() {
        DefaultTableModel modelo = (DefaultTableModel) tblEstados.getModel();
        modelo.setNumRows(0);
        CtrlEstado.PesquisarTodos().forEach((e) -> {
            modelo.addRow(new Object []{
                e.getCodEstado(),
                e.getDescricao(),
                e.getUf()
            });
        });
    }
}
