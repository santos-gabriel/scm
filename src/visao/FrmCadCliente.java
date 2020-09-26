/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controllers.CtrlCidade;
import controllers.CtrlCliente;
import controllers.CtrlEstado;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mensagens.Erro;
import mensagens.Informacao;
import modelo.Cidades;
import modelo.Cliente;
import modelo.Estados;

/**
 *
 * @author Suporte T.I 2
 */
public class FrmCadCliente extends javax.swing.JFrame {

    FrmSelecionaRegistro FRM_SELECIONA_REGISTRO = null;
    private Cliente CLIENTE = null;
    String DataBR, DataISO;

    public FrmCadCliente() {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        jRFisica.setSelected(true);
        VerificarTipoPessoa();
        CarregarTabela();
        carregarTodosCombobox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGTipoPessoa = new javax.swing.ButtonGroup();
        BGPesquisa = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtDataNasc = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtCPF = new javax.swing.JFormattedTextField();
        TxtRG = new javax.swing.JFormattedTextField();
        ButonNovo = new javax.swing.JLabel();
        ButtonExcluir = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaCliente = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        TxtCNPJ = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jRFisica = new javax.swing.JRadioButton();
        jRJuridica = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        TxtCep = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TxtLogradouro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TxtBairro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TxtCodCidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtCodEstado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TxtNumero = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtWhatsapp = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        TxtTelefone = new javax.swing.JFormattedTextField();
        ButonSalvar1 = new javax.swing.JLabel();
        jCEstado = new javax.swing.JComboBox<>();
        jCCidade = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro | Clientes");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel1.setText("Código");

        TxtCod.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel3.setText("Data Nascimento");

        try {
            TxtDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel4.setText("RG");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel5.setText("CPF");

        try {
            TxtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            TxtRG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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

        TabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "WhatsApp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TabelaCliente.getTableHeader().setReorderingAllowed(false);
        TabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaCliente);

        jLabel14.setText("CNPJ");

        try {
            TxtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de pessoa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12))); // NOI18N

        BGTipoPessoa.add(jRFisica);
        jRFisica.setText("Física");
        jRFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRFisicaActionPerformed(evt);
            }
        });

        BGTipoPessoa.add(jRJuridica);
        jRJuridica.setText("Jurídica");
        jRJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRJuridicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jRFisica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRJuridica))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jRFisica)
                .addComponent(jRJuridica))
        );

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel7.setText("CEP");

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel11.setText("Logradouro");

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel12.setText("Bairro");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel10.setText("Cidade");

        TxtCodCidade.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel8.setText("Estado");

        TxtCodEstado.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel13.setText("Número");

        jLabel6.setText("WhatsApp");

        try {
            TxtWhatsapp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel15.setText("Telefone");

        try {
            TxtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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

        jCEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCEstadoItemStateChanged(evt);
            }
        });

        jCCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCCidadeItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TxtCodCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TxtCodEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TxtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel12))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(TxtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(19, 19, 19)
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(TxtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel14))
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TxtWhatsapp, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(TxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButonNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButonSalvar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(ButonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButonSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(TxtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(TxtWhatsapp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(TxtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(TxtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(TxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(TxtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(TxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(TxtCodCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(TxtCodEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(TxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCCidadeItemStateChanged
        if (jCCidade.getSelectedIndex() > 0)
        TxtCodCidade.setText(Integer.toString(((Cidades)jCCidade.getSelectedItem()).getCodCidade()));
        else
        TxtCodCidade.setText("");
    }//GEN-LAST:event_jCCidadeItemStateChanged

    private void jCEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCEstadoItemStateChanged
        if (jCEstado.getSelectedIndex() > 0)
        TxtCodEstado.setText(Integer.toString(((Estados)jCEstado.getSelectedItem()).getCodEstado()));
        else
        TxtCodEstado.setText("");
    }//GEN-LAST:event_jCEstadoItemStateChanged

    private void ButonSalvar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButonSalvar1MouseExited
        ButonSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salvar.png")));
    }//GEN-LAST:event_ButonSalvar1MouseExited

    private void ButonSalvar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButonSalvar1MouseEntered
        ButonSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salvar2.png")));
    }//GEN-LAST:event_ButonSalvar1MouseEntered

    private void ButonSalvar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButonSalvar1MouseClicked
        if (jRFisica.isSelected()) {
            ClienteFisico();
        } else if (jRJuridica.isSelected()) {
            ClienteJuridico();
        }
    }//GEN-LAST:event_ButonSalvar1MouseClicked

    private void jRJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRJuridicaActionPerformed
        if (jRJuridica.isSelected()) {
            LimparCampos();
            HabilitaCamposJuridica();
        }
    }//GEN-LAST:event_jRJuridicaActionPerformed

    private void jRFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRFisicaActionPerformed
        if (jRFisica.isSelected()) {
            LimparCampos();
            HabilitaCamposFisica();
        }
    }//GEN-LAST:event_jRFisicaActionPerformed

    private void TabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaClienteMouseClicked
        LimparCampos();
        if (!(evt.getClickCount() >= 2))
            return;
        if (TabelaCliente.getSelectedRow() != -1) {
            CtrlCliente.PesquisarTodosPorCodigo(Integer.parseInt(String.valueOf(TabelaCliente.getModel().getValueAt(TabelaCliente.getSelectedRow(), 0)))).forEach((c) -> {
                TxtCod.setText(Integer.toString(c.getCod_Cliente()));
                TxtNome.setText(c.getNome_Cliente());

                if (!(c.getData_Nascimento_Cliente() == null || c.getData_Nascimento_Cliente().isEmpty()))
                    TxtDataNasc.setText(ConverteData(c.getData_Nascimento_Cliente()));

                TxtWhatsapp.setText(c.getWhatsApp_Cliente());
                TxtTelefone.setText(c.getTelefone_Cliente());
                TxtRG.setText(c.getRG_Cliente());
                TxtCNPJ.setText(c.getCNPJ_Cliente());
                TxtCPF.setText(c.getCPF_Cliente());
                TxtCodCidade.setText(Integer.toString(c.getCod_Cidade()));
                jCCidade.setSelectedItem(new Cidades(Integer.parseInt(TxtCodCidade.getText())));
                TxtCodEstado.setText(Integer.toString(c.getCod_Estado()));
                jCEstado.setSelectedItem(new Estados(Integer.parseInt(TxtCodEstado.getText())));
                String[] EnderecoSeparado = c.getEndereco_Cliente().split(",");
                if (EnderecoSeparado.length > 0)
                    TxtCep.setText(EnderecoSeparado[0]);
                if (EnderecoSeparado.length > 1)
                    TxtLogradouro.setText(EnderecoSeparado[1]);
                if (EnderecoSeparado.length > 2)
                    TxtNumero.setText(EnderecoSeparado[2]);
                if (EnderecoSeparado.length > 3)
                    TxtBairro.setText(EnderecoSeparado[3]);

            });
            if (TxtCPF.getText().equals("   .   .   -  ")) {
                jRJuridica.setSelected(true);
                HabilitaCamposJuridica();
            }else if(TxtCNPJ.getText().equals("  .   .   /    -  ")){
                jRFisica.setSelected(true);
                HabilitaCamposFisica();
            }
        }
    }//GEN-LAST:event_TabelaClienteMouseClicked

    private void ButtonExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonExcluirMouseExited
        ButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Inativar.png")));
    }//GEN-LAST:event_ButtonExcluirMouseExited

    private void ButtonExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonExcluirMouseEntered
        ButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Inativar2.png")));
    }//GEN-LAST:event_ButtonExcluirMouseEntered

    private void ButtonExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonExcluirMouseClicked
        if (CLIENTE == null)
            CLIENTE = new Cliente();
        CLIENTE.setCod_Cliente(Integer.parseInt(TxtCod.getText()));
        CtrlCliente.Excluir(CLIENTE);
        CarregarTabela();
        LimparCampos();
    }//GEN-LAST:event_ButtonExcluirMouseClicked

    private void ButonNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButonNovoMouseExited
        ButonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Novo.png")));
    }//GEN-LAST:event_ButonNovoMouseExited

    private void ButonNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButonNovoMouseEntered
        ButonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Novo2.png")));
    }//GEN-LAST:event_ButonNovoMouseEntered

    private void ButonNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButonNovoMouseClicked
        LimparCampos();
        carregarTodosCombobox();
    }//GEN-LAST:event_ButonNovoMouseClicked

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
            java.util.logging.Logger.getLogger(FrmCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadCliente().setVisible(true);
            }
        });
    }

    public void CarregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) TabelaCliente.getModel();
        modelo.setNumRows(0);
        CtrlCliente.PesquisarTodos().forEach((c) -> {
            modelo.addRow(new Object[]{
                c.getCod_Cliente(),
                c.getNome_Cliente(),
                c.getWhatsApp_Cliente()
            });
        });

    }

    public void LimparCampos() {
        TxtCod.setText("");
        TxtNome.setText("");
        TxtDataNasc.setText("");
        TxtWhatsapp.setText("");
        TxtRG.setText("");
        TxtCPF.setText("");
        TxtCNPJ.setText("");
        TxtCep.setText("");
        TxtLogradouro.setText("");
        TxtBairro.setText("");
        TxtCodCidade.setText("");
        TxtCodEstado.setText("");
        TxtNumero.setText("");
        TxtTelefone.setText("");
        jCCidade.setSelectedItem(new Cidades(0, "Selecione"));;
        jCEstado.setSelectedItem(new Cidades(0, "Selecione"));;
    }
    
    public void HabilitaCamposFisica(){
        TxtCNPJ.setEditable(false);
        TxtCNPJ.setEnabled(false);
        TxtDataNasc.setEnabled(true);
        TxtDataNasc.setEditable(true);
        TxtRG.setEnabled(true);
        TxtRG.setEditable(true);
        TxtCPF.setEnabled(true);
        TxtCPF.setEditable(true); 
    }
    
    public void HabilitaCamposJuridica(){
        TxtCNPJ.setEditable(true);
        TxtCNPJ.setEnabled(true);
        TxtDataNasc.setEditable(false);
        TxtDataNasc.setEnabled(false);
        TxtRG.setEditable(false);
        TxtRG.setEnabled(false);
        TxtCPF.setEditable(false);           
        TxtCPF.setEnabled(false);
    }

    public void VerificarTipoPessoa() {
        if (jRJuridica.isSelected()) {
            HabilitaCamposJuridica();
        } else if (jRFisica.isSelected()) {
            HabilitaCamposFisica();
        }
    }

    public void ClienteFisico() {
        if (TxtNome.getText().isEmpty()) {
            Erro.show("Informe o Nome!");
            return;
        } else if (TxtDataNasc.getText().equals("  /  /    ")) {
            Erro.show("Informe a Data de Nascimento!");
            return;
        } else if (TxtWhatsapp.getText().equals("(  )      -    ")) {
            Erro.show("Informe o WhatsApp!");
            return;
        } else if (TxtTelefone.getText().equals("   .   .   -  ")) {
            Erro.show("Informe o Telefone!");
            return;
        } else if (TxtRG.getText().equals("       ")) {
            Erro.show("Informe o RG!");
            return;
        } else if (TxtCPF.getText().equals("   .   .   -  ")) {
            Erro.show("Informe o CPF!");
            return;
        } else if (TxtCep.getText().isEmpty()) {
            Erro.show("Informe o CEP!");
            return;
        } else if (TxtLogradouro.getText().isEmpty()) {
            Erro.show("Informe o Logradouro!");
            return;
        } else if (TxtBairro.getText().isEmpty()) {
            Erro.show("Informe o Bairro!");
            return;
        } else if (TxtCodCidade.getText().isEmpty()) {
            Erro.show("Informe a Cidade!");
            return;
        } else if (TxtCodEstado.getText().isEmpty()) {
            Erro.show("Informe o Estado");
            return;
        }

        if (CLIENTE == null) {
            CLIENTE = new Cliente();
        }
        CLIENTE.setNome_Cliente(TxtNome.getText());
        ConverteDataPISO();
        CLIENTE.setData_Nascimento_Cliente(DataISO);
        CLIENTE.setWhatsApp_Cliente(TxtWhatsapp.getText());
        CLIENTE.setRG_Cliente(TxtRG.getText());
        CLIENTE.setCPF_Cliente(TxtCPF.getText());
        CLIENTE.setTelefone_Cliente(TxtTelefone.getText());
        CLIENTE.setCod_Estado(Integer.parseInt(TxtCodEstado.getText()));
        CLIENTE.setCod_Cidade(Integer.parseInt(TxtCodCidade.getText()));
        CLIENTE.setEndereco_Cliente(TxtCep.getText() + "," + TxtLogradouro.getText() + ", " + TxtNumero.getText() + ", " + TxtBairro.getText() + ", " + jCCidade.getToolTipText() + ", " + jCEstado.getToolTipText());

        if (TxtCod.getText() == null || TxtCod.getText().equals("")) {

            Informacao.show("Cliente Físico salvo com sucesso!");
            CtrlCliente.SalvarTodosCamposFisica(CLIENTE);

        } else {

            CLIENTE.setCod_Cliente(Integer.parseInt(TxtCod.getText()));
            CtrlCliente.AtualizarTodosCamposFisica(CLIENTE);
            Informacao.show("Cliente Físico atualizado com sucesso!");
        }
        CarregarTabela();
        LimparCampos();
    }

    public void ClienteJuridico() {

        if (TxtNome.getText().isEmpty()) {
            Erro.show("Informe o Nome!");
            return;
        } else if (TxtWhatsapp.getText().equals("(  )      -    ")) {
            Erro.show("Informe o WhatsApp!");
            return;
        } else if (TxtCNPJ.getText().equals("  .   .   /    -  ")) {
            Erro.show("Informe o CNPJ!");
            return;
        } else if (TxtCep.getText().isEmpty()) {
            Erro.show("Informe o CEP!");
            return;
        } else if (TxtLogradouro.getText().isEmpty()) {
            Erro.show("Informe o Logradouro!");
            return;
        } else if (TxtBairro.getText().isEmpty()) {
            Erro.show("Informe o Bairro!");
            return;
        } else if (TxtCodCidade.getText().isEmpty()) {
            Erro.show("Informe a Cidade!");
            return;
        } else if (TxtCodEstado.getText().isEmpty()) {
            Erro.show("Informe o Estado");
            return;
        }

        if (CLIENTE == null) {
            CLIENTE = new Cliente();
        }
        CLIENTE.setNome_Cliente(TxtNome.getText());
        CLIENTE.setWhatsApp_Cliente(TxtWhatsapp.getText());
        String cnpj = TxtCNPJ.getText().replaceAll("\\D", "");
        CLIENTE.setCNPJ_Cliente(cnpj);
        CLIENTE.setTelefone_Cliente(TxtTelefone.getText());
        CLIENTE.setCod_Estado(Integer.parseInt(TxtCodEstado.getText()));
        CLIENTE.setCod_Cidade(Integer.parseInt(TxtCodCidade.getText()));
        CLIENTE.setEndereco_Cliente(TxtCep.getText() + "," + TxtLogradouro.getText() + ", " + TxtNumero.getText() + ", " + TxtBairro.getText() + ", " + jCCidade.getToolTipText() + ", " + jCEstado.getToolTipText());
        if (TxtCod.getText() == null || TxtCod.getText().equals("")) {

            Informacao.show("Cliente Jurídico salvo com sucesso!");
            CtrlCliente.SalvarTodosCamposJuridica(CLIENTE);

        } else {
            
            CLIENTE.setCod_Cliente(Integer.parseInt(TxtCod.getText()));
            CtrlCliente.AtualizarTodosCamposJuridica(CLIENTE);
            Informacao.show("Cliente Jurídico atualizado com sucesso!");
        }
        CarregarTabela();
        LimparCampos();
    }

    public void ConverteDataPISO() {
        String dia = TxtDataNasc.getText().substring(0, 2);
        String mes = TxtDataNasc.getText().substring(3, 5);
        String ano = TxtDataNasc.getText().substring(6, 10);

        DataISO = ano + "-" + mes + "-" + dia;

    }
    
    public String ConverteData(String prData) {
        String ano = prData.substring(0, 4);
        String mes = prData.substring(5, 7);
        String dia = prData.substring(8, 10);
        return dia + "/" + mes + "/" + ano;
    }
    
    private void carregarTodosCombobox(){   
        if (TxtCodCidade.getText() == null || TxtCodCidade.getText().isEmpty()){
            jCCidade.removeAllItems();
            jCCidade.addItem(new Cidades(0, "Selecione"));
            CtrlCidade.PesquisarTodos().forEach(cidade -> {
                jCCidade.addItem(cidade);
            });
        }
        if (TxtCodEstado.getText() == null || TxtCodEstado.getText().isEmpty()){
            jCEstado.removeAllItems();
            jCEstado.addItem(new Estados(0, "Selecione"));
            CtrlEstado.PesquisarTodos().forEach(estado -> {
                jCEstado.addItem(estado);
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BGPesquisa;
    private javax.swing.ButtonGroup BGTipoPessoa;
    private javax.swing.JLabel ButonNovo;
    private javax.swing.JLabel ButonSalvar1;
    private javax.swing.JLabel ButtonExcluir;
    private javax.swing.JTable TabelaCliente;
    private javax.swing.JTextField TxtBairro;
    private javax.swing.JFormattedTextField TxtCNPJ;
    private javax.swing.JFormattedTextField TxtCPF;
    private javax.swing.JTextField TxtCep;
    private javax.swing.JTextField TxtCod;
    private javax.swing.JTextField TxtCodCidade;
    private javax.swing.JTextField TxtCodEstado;
    private javax.swing.JFormattedTextField TxtDataNasc;
    private javax.swing.JTextField TxtLogradouro;
    private javax.swing.JTextField TxtNome;
    private javax.swing.JTextField TxtNumero;
    private javax.swing.JFormattedTextField TxtRG;
    private javax.swing.JFormattedTextField TxtTelefone;
    private javax.swing.JFormattedTextField TxtWhatsapp;
    private javax.swing.JComboBox<Cidades> jCCidade;
    private javax.swing.JComboBox<Estados> jCEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRFisica;
    private javax.swing.JRadioButton jRJuridica;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
