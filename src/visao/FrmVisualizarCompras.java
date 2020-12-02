/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controllers.CtrlCompras;
import controllers.CtrlFornecedor;
import excecoes.ExcecaoGenerica;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import mensagens.Erro;
import modelo.Compras;
import modelo.Fornecedor;
import modelo.Usuario;
import utilitarios.Funcoes;

/**
 *
 * @author Gabriel
 */
public class FrmVisualizarCompras extends javax.swing.JFrame {

    private FrmCompras FRM_COMPRAS = null;
    
    
    /**
     * Creates new form FrmVisualizarCompras
     */
    public FrmVisualizarCompras() {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFiltros = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDataInicial = new javax.swing.JFormattedTextField();
        txtDataFinal = new javax.swing.JFormattedTextField();
        ckFiltrarFornecedor = new javax.swing.JCheckBox();
        cbxFornecedor = new javax.swing.JComboBox<>();
        btnRealizarPesquisa = new javax.swing.JButton();
        pnlDadosPesquisa = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDadosCompras = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimentações | Visualizar Compras");

        jLabel1.setText("Data Inicial");

        jLabel2.setText("Data Final");

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

        ckFiltrarFornecedor.setText("Filtrar por Fornecedor");
        ckFiltrarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckFiltrarFornecedorActionPerformed(evt);
            }
        });

        btnRealizarPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/magnifier.png"))); // NOI18N
        btnRealizarPesquisa.setText("Realizar Pesquisa");
        btnRealizarPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFiltrosLayout = new javax.swing.GroupLayout(pnlFiltros);
        pnlFiltros.setLayout(pnlFiltrosLayout);
        pnlFiltrosLayout.setHorizontalGroup(
            pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltrosLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckFiltrarFornecedor)
                    .addGroup(pnlFiltrosLayout.createSequentialGroup()
                        .addComponent(cbxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRealizarPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        pnlFiltrosLayout.setVerticalGroup(
            pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltrosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(ckFiltrarFornecedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRealizarPesquisa))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        tblDadosCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Compra", "Cod. Fornecedor", "Fornecedor", "Cod. Usuario", "Usuario", "Data", "Total Bruto", "Desconto", "Total Líquido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDadosCompras.getTableHeader().setReorderingAllowed(false);
        tblDadosCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDadosComprasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDadosCompras);

        javax.swing.GroupLayout pnlDadosPesquisaLayout = new javax.swing.GroupLayout(pnlDadosPesquisa);
        pnlDadosPesquisa.setLayout(pnlDadosPesquisaLayout);
        pnlDadosPesquisaLayout.setHorizontalGroup(
            pnlDadosPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnlDadosPesquisaLayout.setVerticalGroup(
            pnlDadosPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlDadosPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDadosPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ckFiltrarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckFiltrarFornecedorActionPerformed
        if (ckFiltrarFornecedor.isSelected())
            carregarCombobox();
        else
            cbxFornecedor.removeAllItems();
    }//GEN-LAST:event_ckFiltrarFornecedorActionPerformed

    private void btnRealizarPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPesquisaActionPerformed
        if(txtDataInicial.getText() == null || txtDataInicial.getText().isEmpty() || txtDataInicial.getText().equals("  /  /    ")){
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
        if (ckFiltrarFornecedor.isSelected() && (cbxFornecedor.getSelectedIndex() == -1 || cbxFornecedor.getSelectedIndex() == 0)){
            Erro.show("Informe o fornecedor");
            return;
        }
        if (Funcoes.comparaDatas(txtDataInicial.getText(), txtDataFinal.getText()) > 0) {
            Erro.show("Datas inválidas");
            return;
        }
        carregarPesquisa();
    }//GEN-LAST:event_btnRealizarPesquisaActionPerformed

    private void tblDadosComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDadosComprasMouseClicked
        if (tblDadosCompras.getSelectedRow() == -1)
            return;
        if (evt.getClickCount() >= 2){
            try {
                if (FRM_COMPRAS == null)
                    FRM_COMPRAS = new FrmCompras();

                Compras compra = new Compras();

                compra.setCodCompra((Integer)tblDadosCompras.getModel().getValueAt(tblDadosCompras.getSelectedRow(), 0));
                compra.setFornecedor(new Fornecedor((Integer)tblDadosCompras.getModel().getValueAt(tblDadosCompras.getSelectedRow(), 1), String.valueOf(tblDadosCompras.getModel().getValueAt(tblDadosCompras.getSelectedRow(), 2))));
                compra.setUsuario(new Usuario((Integer)tblDadosCompras.getModel().getValueAt(tblDadosCompras.getSelectedRow(), 3), String.valueOf(tblDadosCompras.getModel().getValueAt(tblDadosCompras.getSelectedRow(), 4))));
                compra.setData(String.valueOf(tblDadosCompras.getModel().getValueAt(tblDadosCompras.getSelectedRow(), 5)));
                compra.setTotalBruto((Double)tblDadosCompras.getModel().getValueAt(tblDadosCompras.getSelectedRow(), 6));
                compra.setDesconto((Double)tblDadosCompras.getModel().getValueAt(tblDadosCompras.getSelectedRow(), 7));
                compra.setTotalLiquido((Double)tblDadosCompras.getModel().getValueAt(tblDadosCompras.getSelectedRow(), 8));

                FRM_COMPRAS.carregarCompra(compra);
                FRM_COMPRAS.setVisible(true);
            } catch (Exception e){
                throw new ExcecaoGenerica(e);
            }
        }    
    }//GEN-LAST:event_tblDadosComprasMouseClicked

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
            java.util.logging.Logger.getLogger(FrmVisualizarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVisualizarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVisualizarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVisualizarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVisualizarCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRealizarPesquisa;
    private javax.swing.JComboBox<Fornecedor> cbxFornecedor;
    private javax.swing.JCheckBox ckFiltrarFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlDadosPesquisa;
    private javax.swing.JPanel pnlFiltros;
    private javax.swing.JTable tblDadosCompras;
    private javax.swing.JFormattedTextField txtDataFinal;
    private javax.swing.JFormattedTextField txtDataInicial;
    // End of variables declaration//GEN-END:variables

    private void carregarCombobox(){
        try {    
            cbxFornecedor.removeAllItems();
            cbxFornecedor.addItem(new Fornecedor(0, "Selecione"));
            CtrlFornecedor.PesquisarTodos().forEach(funcionario -> {
                cbxFornecedor.addItem(funcionario);
            });
        } catch (Exception e){
            throw new ExcecaoGenerica(e);
        }
    }
    
    private void carregarPesquisa(){
        try { 
            DefaultTableModel modelo = (DefaultTableModel) tblDadosCompras.getModel();
            modelo.setNumRows(0);

            String dataInicial = Funcoes.trataDataParaDb(txtDataInicial.getText());
            String dataFinal = Funcoes.trataDataParaDb(txtDataFinal.getText());    
            List<Compras> lista = null;
            if (ckFiltrarFornecedor.isSelected()){
                Fornecedor fornecedor = (Fornecedor) cbxFornecedor.getSelectedItem();
                lista = CtrlCompras.PesquisarVendasPorPeriodoFuncionario(dataInicial, dataFinal, fornecedor);
            } else {
                lista = CtrlCompras.PesquisarVendasPorPeriodoFuncionario(dataInicial, dataFinal, null);
            }

            for(Compras compra : lista){
                modelo.addRow(new Object [] {
                    compra.getCodCompra(),
                    compra.getFornecedor().getCod_Fornecedor(),
                    compra.getFornecedor().getNome_Fornecedor(),
                    compra.getUsuario().getCod_Usuario(),
                    compra.getUsuario().getLogin(),
                    compra.getData(),
                    compra.getTotalBruto(),
                    compra.getDesconto(),
                    compra.getTotalLiquido()
                });
            }
        } catch (Exception e){
            throw new ExcecaoGenerica(e);
        }
    }
    
}
