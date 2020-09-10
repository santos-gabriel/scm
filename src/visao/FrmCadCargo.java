/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controllers.CtrlCargo;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mensagens.Erro;
import mensagens.Informacao;
import modelo.Cargo;

/**
 *
 * @author Gabriel
 */
public class FrmCadCargo extends javax.swing.JFrame {

    
    FrmSelecionaRegistro FRM_SELECIONA_REGISTRO = null;
    private Cargo    CARGO                      = null;
    private boolean  INSERIR                    = false;
    private boolean  ATUALIZAR                  = false;
    private boolean  INATIVAR                   = false;
    private boolean  CONSULTAR                  = false;
    
    
    /**
     * Creates new form FrmCadCargo
     */
    public FrmCadCargo() {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        carregarPermissoes();
        carregarRegistros();
    }
    
    public FrmCadCargo(String prInserir, String prAtualizar, String prInativar, String prConsultar) {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        carregarPermissoes();
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
        pnlOpcoes = new javax.swing.JPanel();
        btnInserir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnInativar = new javax.swing.JButton();
        pnlDadosCadastrais = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodCargo = new javax.swing.JTextField();
        txtDescCargo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarCargo = new javax.swing.JTextField();
        btnBuscarCargo = new javax.swing.JButton();
        pnlRegistros = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCargos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro | Cargos");
        setResizable(false);

        pnlOpcoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções"));

        btnInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/add.png"))); // NOI18N
        btnInserir.setText("Novo");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
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
                    .addComponent(btnInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInativar, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlOpcoesLayout.setVerticalGroup(
            pnlOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcoesLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInativar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDadosCadastrais.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Código");

        jLabel3.setText("Descrição");

        txtCodCargo.setEditable(false);

        javax.swing.GroupLayout pnlDadosCadastraisLayout = new javax.swing.GroupLayout(pnlDadosCadastrais);
        pnlDadosCadastrais.setLayout(pnlDadosCadastraisLayout);
        pnlDadosCadastraisLayout.setHorizontalGroup(
            pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosCadastraisLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtCodCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtDescCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDadosCadastraisLayout.setVerticalGroup(
            pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosCadastraisLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel1.setText("Buscar Cargo");

        txtBuscarCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarCargoKeyPressed(evt);
            }
        });

        btnBuscarCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/magnifier.png"))); // NOI18N
        btnBuscarCargo.setText("Buscar");
        btnBuscarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCargoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeralLayout.createSequentialGroup()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGeralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCargo))
                    .addGroup(pnlGeralLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(pnlDadosCadastrais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGeralLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtBuscarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCargo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(pnlDadosCadastrais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblCargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCargos.getTableHeader().setReorderingAllowed(false);
        tblCargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCargosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCargos);

        javax.swing.GroupLayout pnlRegistrosLayout = new javax.swing.GroupLayout(pnlRegistros);
        pnlRegistros.setLayout(pnlRegistrosLayout);
        pnlRegistrosLayout.setHorizontalGroup(
            pnlRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnlRegistrosLayout.setVerticalGroup(
            pnlRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnBuscarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCargoActionPerformed
        JTable tabela = new JTable();
        List<String[]> dados = new ArrayList<>();
        
        Cargo cargo = new Cargo();
        cargo.setDesc_Cargo(txtBuscarCargo.getText());
        List<Cargo> cargoPesquisa = CtrlCargo.PesquisarViaDescricaoInicia(cargo);
        
        for (Cargo c : cargoPesquisa){
            dados.add(new String[]{String.valueOf(c.getCod_Cargo()), c.getDesc_Cargo()});
        }
        
        tabela.setModel(new DefaultTableModel(
            dados.toArray(new String[dados.size()][]),
            new String [] {"CODIGO", "DESCRICAO"}){
                boolean[] canEdit = new boolean []{false, false};
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }                
            });
        tabela.getTableHeader().setReorderingAllowed(false);
        
        if (FRM_SELECIONA_REGISTRO == null)
            FRM_SELECIONA_REGISTRO = new FrmSelecionaRegistro(this, true);
        FRM_SELECIONA_REGISTRO.preencheTabela(tabela.getModel(), tabela);
        FRM_SELECIONA_REGISTRO.setTitle("Cargos | Seleção ");
        
        FRM_SELECIONA_REGISTRO.setVisible(true);
        
        String[] registroSelecionado = FRM_SELECIONA_REGISTRO.getDadosSelecao();
        if (registroSelecionado != null){
            txtCodCargo.setText(registroSelecionado[0]);
            txtDescCargo.setText(registroSelecionado[1]);
        }
    }//GEN-LAST:event_btnBuscarCargoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (txtDescCargo.getText().isEmpty()){
            Erro.show("Informe a descrição do cargo");
            return;
        }
        
        if (CARGO == null)
            CARGO = new Cargo();
        CARGO.setDesc_Cargo(txtDescCargo.getText());
        CARGO.setAtivo(true);
        if (txtCodCargo.getText().isEmpty()){
            
            Integer codCargoSalvo = CtrlCargo.SalvarTodosCampos(CARGO);
            if (codCargoSalvo != null){
                Informacao.show("Cargo salvo com sucesso");
                txtCodCargo.setText(Integer.toString(codCargoSalvo));
            }
            
        } else{
            if (!isATUALIZAR()){
                Erro.show("Você não tem permissão para atualizar");
                return;
            }
            CARGO.setCod_Cargo(Integer.parseInt(txtCodCargo.getText()));
            CtrlCargo.AtualizarTodosCampos(CARGO);
            Informacao.show("Cargo atualizado com sucesso");
        }
        carregarRegistros();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInativarActionPerformed
        if (!(txtCodCargo.getText() == null || txtCodCargo.getText().isEmpty())){
            if (CARGO == null)
                CARGO = new Cargo();
            CARGO.setCod_Cargo(Integer.parseInt(txtCodCargo.getText()));
            CtrlCargo.Excluir(CARGO);
            Informacao.show("Cargo inativado com sucesso");
            limparCampos();
            carregarRegistros();
        }
    }//GEN-LAST:event_btnInativarActionPerformed

    private void txtBuscarCargoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCargoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            btnBuscarCargoActionPerformed(null);
    }//GEN-LAST:event_txtBuscarCargoKeyPressed

    private void tblCargosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCargosMouseClicked
        if (evt.getClickCount() >= 2){
            txtCodCargo.setText(String.valueOf(tblCargos.getModel().getValueAt(tblCargos.getSelectedRow(), 0)));
            txtDescCargo.setText(String.valueOf(tblCargos.getModel().getValueAt(tblCargos.getSelectedRow(), 1)));
        }
    }//GEN-LAST:event_tblCargosMouseClicked

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
            java.util.logging.Logger.getLogger(FrmCadCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadCargo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCargo;
    private javax.swing.JButton btnInativar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlDadosCadastrais;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlOpcoes;
    private javax.swing.JPanel pnlRegistros;
    private javax.swing.JTable tblCargos;
    private javax.swing.JTextField txtBuscarCargo;
    private javax.swing.JTextField txtCodCargo;
    private javax.swing.JTextField txtDescCargo;
    // End of variables declaration//GEN-END:variables
    
    private void limparCampos(){
        txtCodCargo.setText("");
        txtDescCargo.setText("");
    }
    
    public void carregarPermissoes (){
        btnInserir.setEnabled(isINSERIR());
        btnInativar.setEnabled(isINATIVAR());
        btnBuscarCargo.setEnabled(isCONSULTAR());
        btnSalvar.setEnabled(isINSERIR() && isATUALIZAR());
    }

    public boolean isINSERIR() {
        return INSERIR;
    }

    public void setINSERIR(boolean INSERIR) {
        this.INSERIR = INSERIR;
    }

    public boolean isATUALIZAR() {
        return ATUALIZAR;
    }

    public void setATUALIZAR(boolean ATUALIZAR) {
        this.ATUALIZAR = ATUALIZAR;
    }

    public boolean isINATIVAR() {
        return INATIVAR;
    }

    public void setINATIVAR(boolean INATIVAR) {
        this.INATIVAR = INATIVAR;
    }

    public boolean isCONSULTAR() {
        return CONSULTAR;
    }

    public void setCONSULTAR(boolean CONSULTAR) {
        this.CONSULTAR = CONSULTAR;
    }
    
    private void carregarRegistros(){
        DefaultTableModel modelo = (DefaultTableModel) tblCargos.getModel();
        modelo.setNumRows(0);
        CtrlCargo.PesquisarTodos().forEach((c) -> {
            modelo.addRow(new Object []{
                c.getCod_Cargo(),
                c.getDesc_Cargo()
            });
        });
    }
    
}
