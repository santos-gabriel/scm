/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controllers.CtrlCategoriasProdutos;
import controllers.CtrlProduto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mensagens.Erro;
import mensagens.Informacao;
import modelo.CategoriasProdutos;
import modelo.Produto;
import utilitarios.UsuariosUtil;

/**
 *
 * @author Gabriel
 */
public class FrmCadProduto extends javax.swing.JFrame {

    private FrmSelecionaRegistro     FRM_SELECIONA_REGISTRO = null;
    private List<CategoriasProdutos> CATEGORIAS             = null;
    private CategoriasProdutos       CATEGORIASELECIONADA   = null;
    private Produto                  PRODUTO                = null;
    
    
    /**
     * Creates new form FrmCadProduto
     */
    public FrmCadProduto() {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        carregarPermissoes();
        carregarRegistros();
        carregarCombobox();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodProduto = new javax.swing.JTextField();
        txtDescProduto = new javax.swing.JTextField();
        txtCodCategoria = new javax.swing.JTextField();
        cbxCategorias = new javax.swing.JComboBox<>();
        txtValorCusto = new javax.swing.JFormattedTextField();
        txtValorVenda = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        pnlOpcoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnInativar = new javax.swing.JButton();
        pnlRegistros = new javax.swing.JPanel();
        tblProdutos = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro | Produtos");
        setResizable(false);

        pnlDadosCadastrais.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Código");

        jLabel3.setText("Descrição");

        jLabel4.setText("Cod. Categoria");

        jLabel5.setText("Categoria");

        jLabel6.setText("Valor de Custo");

        jLabel7.setText("Valor de Venda");

        txtCodProduto.setEditable(false);

        txtCodCategoria.setEditable(false);

        cbxCategorias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCategoriasItemStateChanged(evt);
            }
        });

        txtValorCusto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        txtValorVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        javax.swing.GroupLayout pnlDadosCadastraisLayout = new javax.swing.GroupLayout(pnlDadosCadastrais);
        pnlDadosCadastrais.setLayout(pnlDadosCadastraisLayout);
        pnlDadosCadastraisLayout.setHorizontalGroup(
            pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosCadastraisLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCodProduto, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(pnlDadosCadastraisLayout.createSequentialGroup()
                        .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtValorCusto))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtDescProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDadosCadastraisLayout.setVerticalGroup(
            pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosCadastraisLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jLabel1.setText("Buscar Produtos");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/magnifier.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDadosCadastrais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlGeralLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnBuscar)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(27, 27, 27)
                .addComponent(pnlDadosCadastrais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOpcoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInativar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Código Categoria", "Categoria", "Descrição", "Valor de Custo", "Valor de Venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        tblProdutos.setViewportView(jTable1);

        javax.swing.GroupLayout pnlRegistrosLayout = new javax.swing.GroupLayout(pnlRegistros);
        pnlRegistros.setLayout(pnlRegistrosLayout);
        pnlRegistrosLayout.setHorizontalGroup(
            pnlRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblProdutos)
        );
        pnlRegistrosLayout.setVerticalGroup(
            pnlRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrosLayout.createSequentialGroup()
                .addComponent(tblProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOpcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnlRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addComponent(pnlRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        CATEGORIASELECIONADA = null;
        CATEGORIAS           = null;
        PRODUTO              = null;
        
        limparCamposTextos();
        carregarCombobox();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInativarActionPerformed
        if (txtCodProduto.getText() == null || txtCodProduto.getText().isEmpty())
            return;
        
        if (PRODUTO == null)
            PRODUTO = new Produto();
        PRODUTO.setCod_Produto(Integer.parseInt(txtCodProduto.getText()));
    }//GEN-LAST:event_btnInativarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        JTable tabela = new JTable();
                List<String[]> dados = new ArrayList<>();

                Produto produto = new Produto();
                produto.setDesc_Produto(txtBuscar.getText());
                List<Produto> resultadoPesquisa = CtrlProduto.PesquisarViaDescricaoInicia(produto);

                for (Produto p : resultadoPesquisa){
                    dados.add(new String[]{
                                            String.valueOf(p.getCod_Produto()), 
                                            p.getDesc_Produto(),
                                            String.valueOf(p.getCategoria_Produto().getCod_Categoria()),
                                            p.getCategoria_Produto().getDesc_Categoria(),
                                            String.valueOf(p.getValor_Custo()),
                                            String.valueOf(p.getValor_Venda())
                                          });
                }

                tabela.setModel(new DefaultTableModel(
                    dados.toArray(new String[dados.size()][]),
                    new String [] {"CODIGO", "DESCRICAO", "COD. CATEGORIA", "CATEGORIA", "VALOR DE CUSTO", "VALOR DE VENDA"}){
                        boolean[] canEdit = new boolean []{false, false, false, false, false, false};
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit[columnIndex];
                        }                
                    });
                tabela.getTableHeader().setReorderingAllowed(false);

                if (FRM_SELECIONA_REGISTRO == null)
                    FRM_SELECIONA_REGISTRO = new FrmSelecionaRegistro(this, true);
                FRM_SELECIONA_REGISTRO.preencheTabela(tabela.getModel(), tabela);
                FRM_SELECIONA_REGISTRO.setTitle("Produtos | Seleção ");

                FRM_SELECIONA_REGISTRO.setVisible(true);

                String[] registroSelecionado = FRM_SELECIONA_REGISTRO.getDadosSelecao();
                if (registroSelecionado != null){
                    txtCodProduto.setText(registroSelecionado[0]);
                    txtDescProduto.setText(registroSelecionado[1]);
                    txtCodCategoria.setText(registroSelecionado[2]);
                    // registroSelecionado[3];
                    txtValorCusto.setText(registroSelecionado[4]);
                    txtValorVenda.setText(registroSelecionado[5]);
                }  
                carregarCombobox();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtDescProduto.getText() == null || txtDescProduto.getText().isEmpty()){
            Erro.show("Informe a descrição do produto");
            return;
        }
        if (txtCodCategoria.getText() == null || txtCodCategoria.getText().isEmpty()){
            Erro.show("Informe a categoria");
            return;
        }
        if (txtValorCusto.getText() == null || txtValorCusto.getText().isEmpty()){
            Erro.show("Informe o valor de custo");
            return;
        }
        if (txtValorVenda.getText() == null || txtValorVenda.getText().isEmpty()){
            Erro.show("Informe o valor de venda");
            return;
        }
        
        
        if (PRODUTO == null)
            PRODUTO = new Produto();
        
        PRODUTO.setAtivo(true);
        PRODUTO.setCategoria_Produto(new  CategoriasProdutos(Integer.parseInt(txtCodCategoria.getText()), "tem que adicionar código ..."));
        PRODUTO.setDesc_Produto(txtDescProduto.getText());
        PRODUTO.setUsuario(UsuariosUtil.getUsuario());
        PRODUTO.setValor_Custo(Double.parseDouble(txtValorCusto.getText()));
        PRODUTO.setValor_Venda(Double.parseDouble(txtValorVenda.getText()));
        
        if (txtCodProduto.getText() == null || txtCodProduto.getText().isEmpty()){
            Integer codProdutoInserido = CtrlProduto.SalvarTodosCampos(PRODUTO);
            txtCodProduto.setText(Integer.toString(codProdutoInserido));
            Informacao.show("Produto salvo com sucesso");
        } else {
            PRODUTO.setCod_Produto(Integer.parseInt(txtCodProduto.getText()));
            CtrlProduto.AtualizarTodosCampos(PRODUTO);
            Informacao.show("Produto atualizado com sucesso");
        }
        carregarRegistros();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cbxCategoriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCategoriasItemStateChanged
        CATEGORIASELECIONADA = CATEGORIAS.get(cbxCategorias.getSelectedIndex());
        txtCodCategoria.setText(Integer.parseInt(CATEGORIASELECIONADA.getCod_Categoria()));
    }//GEN-LAST:event_cbxCategoriasItemStateChanged

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
            java.util.logging.Logger.getLogger(FrmCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnInativar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnlDadosCadastrais;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlOpcoes;
    private javax.swing.JPanel pnlRegistros;
    private javax.swing.JScrollPane tblProdutos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodCategoria;
    private javax.swing.JTextField txtCodProduto;
    private javax.swing.JTextField txtDescProduto;
    private javax.swing.JFormattedTextField txtValorCusto;
    private javax.swing.JFormattedTextField txtValorVenda;
    // End of variables declaration//GEN-END:variables
    
    
    
    private void carregarPermissoes() {
    
    }

    private void carregarRegistros() {
    
    }

    private void limparCamposTextos() {
        txtCodCategoria.setText("");
        txtCodProduto.setText("");
        txtDescProduto.setText("");
        txtValorCusto.setText("");
        txtValorVenda.setText("");
    }
    
    private void carregarCombobox(){
        if (txtCodCategoria.getText() == null || txtCodCategoria.getText().isEmpty()){
            CtrlCategoriasProdutos.PesquisarTodos().forEach(categoria -> {
                cbxCategorias.addItem(categoria.getDesc_Categoria());
            });
        } else {
            if (CATEGORIASELECIONADA == null)
                CATEGORIASELECIONADA = new CategoriasProdutos();
            CATEGORIASELECIONADA = CtrlCategoriasProdutos.PesquisarViaCodigo(new CategoriasProdutos(Integer.parseInt(txtCodCategoria.getText())));
            List<CategoriasProdutos> listaCategoriaProdutosExeto = CtrlCategoriasProdutos.PesquisarTodosExecto(CATEGORIASELECIONADA);
        }
    }
    
    
    
}
