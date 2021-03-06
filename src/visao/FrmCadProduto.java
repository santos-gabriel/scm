/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import com.sun.glass.events.KeyEvent;
import controllers.CtrlCategoriasProdutos;
import controllers.CtrlProduto;
import excecoes.ExcecaoGenerica;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mensagens.Confirmacao;
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
    private CategoriasProdutos       CATEGORIASELECIONADA   = null;
    private Produto                  PRODUTO                = null;
    
    
    /**
     * Creates new form FrmCadProduto
     */
    public FrmCadProduto() {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png")).getImage());
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
        jPanel1 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnInativar = new javax.swing.JButton();
        pnlRegistros = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos | Cadastro");
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

        txtValorCusto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        txtValorVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

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

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsUtils/magnifier.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções"));

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Novo.png"))); // NOI18N
        btnNovo.setBorderPainted(false);
        btnNovo.setContentAreaFilled(false);
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovo.setFocusPainted(false);
        btnNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNovoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNovoMouseExited(evt);
            }
        });
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salvar.png"))); // NOI18N
        btnSalvar.setBorderPainted(false);
        btnSalvar.setContentAreaFilled(false);
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.setFocusPainted(false);
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalvarMouseExited(evt);
            }
        });
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnInativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Inativar.png"))); // NOI18N
        btnInativar.setBorderPainted(false);
        btnInativar.setContentAreaFilled(false);
        btnInativar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInativar.setFocusPainted(false);
        btnInativar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInativarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInativarMouseExited(evt);
            }
        });
        btnInativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInativarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnInativar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(15, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnNovo)
                .addGap(0, 170, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(btnSalvar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnInativar)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDadosCadastrais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeralLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnBuscar)))
                .addGap(62, 62, 62)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGeralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlGeralLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(pnlDadosCadastrais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))))
                .addContainerGap())
        );

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProdutos.getTableHeader().setReorderingAllowed(false);
        tblProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutosMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(tblProdutos);

        javax.swing.GroupLayout pnlRegistrosLayout = new javax.swing.GroupLayout(pnlRegistros);
        pnlRegistros.setLayout(pnlRegistrosLayout);
        pnlRegistrosLayout.setHorizontalGroup(
            pnlRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane)
        );
        pnlRegistrosLayout.setVerticalGroup(
            pnlRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrosLayout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        CATEGORIASELECIONADA = null;
        PRODUTO              = null;
        carregarCombobox();
        limparCamposTextos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInativarActionPerformed
        if (txtCodProduto.getText() == null || txtCodProduto.getText().isEmpty())
            return;
        try {
            if (!Confirmacao.show("Deseja excluir este registro? "))
                return;
            if (PRODUTO == null)
                PRODUTO = new Produto();
            PRODUTO.setCod_Produto(Integer.parseInt(txtCodProduto.getText()));
            CtrlProduto.Excluir(PRODUTO);
            Informacao.show("Produto inativado com sucesso");
            limparCamposTextos();
            carregarRegistros();
        } catch(Exception e){
            throw new ExcecaoGenerica(e);
        }
    }//GEN-LAST:event_btnInativarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
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
                cbxCategorias.setSelectedItem(new CategoriasProdutos(Integer.parseInt(txtCodCategoria.getText())));
                txtValorCusto.setText(registroSelecionado[4]);
                txtValorVenda.setText(registroSelecionado[5]);
            }  
            carregarCombobox();
        } catch(Exception e){
            throw new ExcecaoGenerica(e);
        }
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
        
        try {
            if (PRODUTO == null)
                PRODUTO = new Produto();

            PRODUTO.setAtivo(true);
            PRODUTO.setCategoria_Produto(new  CategoriasProdutos(Integer.parseInt(txtCodCategoria.getText()), "tem que adicionar código ..."));
            PRODUTO.setDesc_Produto(txtDescProduto.getText());
            PRODUTO.setUsuario(UsuariosUtil.getUsuario());
            PRODUTO.setValor_Custo(trataValor(txtValorCusto.getText()));
            PRODUTO.setValor_Venda(trataValor(txtValorVenda.getText()));

            if (txtCodProduto.getText() == null || txtCodProduto.getText().isEmpty()){
                Integer codProdutoInserido = CtrlProduto.SalvarTodosCampos(PRODUTO);
                txtCodProduto.setText(Integer.toString(codProdutoInserido));
                Informacao.show("Produto salvo com sucesso");
            } else {
                PRODUTO.setCod_Produto(Integer.parseInt(txtCodProduto.getText()));
                CtrlProduto.AtualizarTodosCampos(PRODUTO);
                Informacao.show("Produto atualizado com sucesso");
            }
            limparCamposTextos();
            carregarRegistros();
        } catch(Exception e){
            throw new ExcecaoGenerica(e);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cbxCategoriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCategoriasItemStateChanged
        if (cbxCategorias.getSelectedIndex() > 0){
            
            if (CATEGORIASELECIONADA == null)
                CATEGORIASELECIONADA = new CategoriasProdutos();
        
            CATEGORIASELECIONADA = (CategoriasProdutos) cbxCategorias.getSelectedItem();
            txtCodCategoria.setText(Integer.toString(CATEGORIASELECIONADA.getCod_Categoria()));
        } else
            txtCodCategoria.setText("");
        
    }//GEN-LAST:event_cbxCategoriasItemStateChanged

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            btnBuscarActionPerformed(null);
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void tblProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutosMouseClicked
        if (tblProdutos.getSelectedRow() != -1){
            try {
                limparCamposTextos();
                txtCodProduto.setText(String.valueOf(tblProdutos.getModel().getValueAt(tblProdutos.getSelectedRow(), 0)));
                txtCodCategoria.setText(String.valueOf(tblProdutos.getModel().getValueAt(tblProdutos.getSelectedRow(), 1)));
                cbxCategorias.setSelectedItem(new CategoriasProdutos(Integer.parseInt(txtCodCategoria.getText())));
                txtDescProduto.setText(String.valueOf(tblProdutos.getModel().getValueAt(tblProdutos.getSelectedRow(), 3)));
                txtValorCusto.setText(String.valueOf(tblProdutos.getModel().getValueAt(tblProdutos.getSelectedRow(), 4)));
                txtValorVenda.setText(String.valueOf(tblProdutos.getModel().getValueAt(tblProdutos.getSelectedRow(), 5)));
            } catch(Exception e){
                throw new ExcecaoGenerica(e);
            }
        }
    }//GEN-LAST:event_tblProdutosMouseClicked

    private void btnNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMouseEntered
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Novo2.png")));
    }//GEN-LAST:event_btnNovoMouseEntered

    private void btnNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMouseExited
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Novo.png")));
    }//GEN-LAST:event_btnNovoMouseExited

    private void btnSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseEntered
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salvar2.png")));
    }//GEN-LAST:event_btnSalvarMouseEntered

    private void btnSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseExited
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salvar.png")));
    }//GEN-LAST:event_btnSalvarMouseExited

    private void btnInativarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInativarMouseEntered
        btnInativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Inativar2.png")));
    }//GEN-LAST:event_btnInativarMouseEntered

    private void btnInativarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInativarMouseExited
        btnInativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Inativar.png")));
    }//GEN-LAST:event_btnInativarMouseExited

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
    private javax.swing.JComboBox<CategoriasProdutos> cbxCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlDadosCadastrais;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlRegistros;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodCategoria;
    private javax.swing.JTextField txtCodProduto;
    private javax.swing.JTextField txtDescProduto;
    private javax.swing.JFormattedTextField txtValorCusto;
    private javax.swing.JFormattedTextField txtValorVenda;
    // End of variables declaration//GEN-END:variables
    

    private void carregarRegistros() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
            modelo.setNumRows(0);
            CtrlProduto.PesquisarTodos().forEach((p) -> {
                modelo.addRow(new Object []{
                    p.getCod_Produto(),
                    p.getCategoria_Produto().getCod_Categoria(),
                    p.getCategoria_Produto().getDesc_Categoria(),
                    p.getDesc_Produto(),
                    p.getValor_Custo(),
                    p.getValor_Venda()

                });
            });
        } catch(Exception e){
            throw new ExcecaoGenerica(e);
        }
    }

    private void limparCamposTextos() {
        txtCodProduto.setText("");
        txtDescProduto.setText("");
        txtValorCusto.setText("");
        txtValorVenda.setText("");
        cbxCategorias.setSelectedItem(new CategoriasProdutos(0, "Selecione"));
    }
    
    private void carregarCombobox(){
        if (txtCodCategoria.getText() == null || txtCodCategoria.getText().isEmpty()){
            try {
                cbxCategorias.removeAllItems();
                cbxCategorias.addItem(new CategoriasProdutos(0, "Selecione"));
                CtrlCategoriasProdutos.PesquisarTodos().forEach(categoria -> {
                    cbxCategorias.addItem(categoria);
                });
            } catch(Exception e){
                throw new ExcecaoGenerica(e);
            }
        }
    }

    private Double trataValor(String prValor){
        try {
            return Double.parseDouble(prValor.replaceAll(",", "."));
        } catch(Exception e){
            throw new ExcecaoGenerica(e);
        }
    }

    private String formataValor(Double prValor){
        try {
            return Double.toString(prValor).replaceAll(".", ",");
        } catch(Exception e){
            throw new ExcecaoGenerica(e);
        }
    }
    
}
