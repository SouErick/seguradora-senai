/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package seguradora.VIEW;

import javax.swing.Icon;
import javax.swing.JOptionPane;
import seguradora.DAL.ModuloConexao;
import java.sql.*;

public class TelaCliente extends javax.swing.JInternalFrame {

    /**
     * PREPARAÇÃO PARA CONEXAO
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;  //exibe resultados do BD         

    public TelaCliente() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    private void cadastrar() {
        String sql = "INSERT INTO e2_clientes(COD, NOME, RG, CPF, TEL, BAIRRO, CEP, "
                + "LOGRADOURO, CIDADE, UF, COMPLEMENTO, NR) VALUES (?,?,?,?,?,?,?,?,"
                + "?,?,?,?)";
        //String sql="INSERT INTO e2_clientes(COD, NOME) VALUES(?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCliCod.getText());
            pst.setString(2, txtCliNome.getText());
            pst.setString(3, txtCliRg.getText());
            pst.setString(4, txtCliCpf.getText());
            pst.setString(5, txtCliFone.getText());
            pst.setString(6, txtCliBai.getText());
            pst.setString(7, txtCliCep.getText());
            pst.setString(8, txtCliLou.getText());
            pst.setString(9, txtCliCid.getText());
            pst.setString(10, cbbCliUf.getSelectedItem().toString());
            pst.setString(11, txtCliCom.getText());
            pst.setString(12, txtCliNr.getText());
            //pst.setString(12, txtCliNr.getText());
            //rs = pst.executeUpdate(); //executeQuery();
            System.out.println("Resultado");
            System.out.println(pst);
            int resultado = pst.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado");
                txtCliCod.setText(null);
                txtCliNome.setText(null);
                txtCliRg.setText(null);
                txtCliCpf.setText(null);
                txtCliFone.setText(null);
                txtCliBai.setText(null);
                txtCliCep.setText(null);
                txtCliLou.setText(null);
                txtCliCid.setText(null);
                cbbCliUf.setSelectedItem(null);
                txtCliCom.setText(null);
                txtCliNr.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    ////      CONSULTAR
    private void consultar() {
        String sql = "SELECT * FROM e2_clientes WHERE Cod=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCliCod.getText());

            rs = pst.executeQuery();
            if (rs.next()) {
                txtCliNome.setText(rs.getString("nome"));
                txtCliRg.setText(rs.getString("rg"));
                txtCliCpf.setText(rs.getString("cpf"));
                txtCliFone.setText(rs.getString("tel"));
                txtCliBai.setText(rs.getString("bairro"));
                txtCliCep.setText(rs.getString("cep"));
                txtCliLou.setText(rs.getString("logradouro"));
                txtCliCid.setText(rs.getString("cidade"));
                txtCliCom.setText(rs.getString("complemento"));
                txtCliNr.setText(rs.getString("nr"));

                JOptionPane.showMessageDialog(null, "Cliente encontrado");

            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado");

                txtCliNome.setText(null);
                txtCliRg.setText(null);
                txtCliCpf.setText(null);
                txtCliFone.setText(null);
                txtCliBai.setText(null);
                txtCliCep.setText(null);
                txtCliLou.setText(null);
                txtCliCid.setText(null);
                cbbCliUf.setSelectedItem(null);
                txtCliCom.setText(null);
                txtCliNr.setText(null);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja remover?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_NO_OPTION) {
            String sql = "DELETE FROM e2_clientes WHERE cod=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtCliCod.getText());
                int apagado = pst.executeUpdate();

                if (apagado >= 1) {
                    JOptionPane.showMessageDialog(null, "Cadastro apagado com sucesso!");
                    txtCliCod.setText(null);
                    txtCliNome.setText(null);
                    txtCliRg.setText(null);
                    txtCliCpf.setText(null);
                    txtCliFone.setText(null);
                    txtCliBai.setText(null);
                    txtCliCep.setText(null);
                    txtCliLou.setText(null);
                    txtCliCid.setText(null);
                    cbbCliUf.setSelectedItem(null);
                    txtCliCom.setText(null);
                    txtCliNr.setText(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void editar() {
        int atualizar = JOptionPane.showConfirmDialog(null, "Deseja editar?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (atualizar == JOptionPane.YES_NO_OPTION) {
            String sql = "UPDATE e2_clientes SET nome=?,rg=?, cpf=?, tel=?, bairro=?, cep=?, logradouro=?, "
                    + "cidade=?, uf=?, complemento=?, nr=? WHERE cod=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtCliNome.getText());
                pst.setString(2, txtCliRg.getText());
                pst.setString(3, txtCliCpf.getText());
                pst.setString(4, txtCliFone.getText());
                pst.setString(5, txtCliBai.getText());
                pst.setString(6, txtCliCep.getText());
                pst.setString(7, txtCliLou.getText());
                pst.setString(8, txtCliCid.getText());
                pst.setString(9, cbbCliUf.getSelectedItem().toString());
                pst.setString(10, txtCliCom.getText());
                pst.setString(11, txtCliNr.getText());
                pst.setString(12, txtCliCod.getText());
                int atualizado = pst.executeUpdate();
                if (atualizado >= 1) {
                    JOptionPane.showMessageDialog(null, "Cadastro editado com sucesso!");
                    txtCliCod.setText(null);
                    txtCliNome.setText(null);
                    txtCliRg.setText(null);
                    txtCliCpf.setText(null);
                    txtCliFone.setText(null);
                    txtCliBai.setText(null);
                    txtCliCep.setText(null);
                    txtCliLou.setText(null);
                    txtCliCid.setText(null);
                    cbbCliUf.setSelectedItem(null);
                    txtCliCom.setText(null);
                    txtCliNr.setText(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCliCod = new javax.swing.JTextField();
        txtCliNome = new javax.swing.JTextField();
        txtCliRg = new javax.swing.JTextField();
        btnCliCad = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCliLou = new javax.swing.JTextField();
        txtCliCom = new javax.swing.JTextField();
        txtCliNr = new javax.swing.JTextField();
        txtCliBai = new javax.swing.JTextField();
        txtCliCid = new javax.swing.JTextField();
        cbbCliUf = new javax.swing.JComboBox<>();
        txtCliCep = new javax.swing.JTextField();
        btnCliPes = new javax.swing.JButton();
        btnCliEdi = new javax.swing.JButton();
        btnCliExc = new javax.swing.JButton();
        txtCliCpf = new javax.swing.JTextField();
        txtCliFone = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("TC - Cadastro De Clientes");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("NOME");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("RG");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("CPF");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("TELEFONE");

        txtCliRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliRgActionPerformed(evt);
            }
        });

        btnCliCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seguradora/VIEW/userAdicionar.png"))); // NOI18N
        btnCliCad.setToolTipText("CADASTRAR");
        btnCliCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliCadActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(133, 133, 226));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Logradouro");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Bairro");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Cidade");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Cep");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("UF");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Complemento");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Nº");

        cbbCliUf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbbCliUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DF", "MG", "GO", "SP", "RJ", "RN", "BH", "PA", "PR", "PI", "TO", "MS", "MT", "RS" }));
        cbbCliUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbCliUfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliLou, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliCom, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel13)
                                .addGap(29, 29, 29)
                                .addComponent(txtCliNr, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliBai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliCid, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbCliUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCliCep))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCliLou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(txtCliNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(txtCliCid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliBai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbCliUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnCliPes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seguradora/VIEW/userPesquisar.png"))); // NOI18N
        btnCliPes.setToolTipText("PROCURAR");
        btnCliPes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliPesActionPerformed(evt);
            }
        });

        btnCliEdi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seguradora/VIEW/userEditar.png"))); // NOI18N
        btnCliEdi.setToolTipText("EDITAR");
        btnCliEdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliEdiActionPerformed(evt);
            }
        });

        btnCliExc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seguradora/VIEW/userDeletar.png"))); // NOI18N
        btnCliExc.setToolTipText("DELETAR");
        btnCliExc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliExcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCliRg)
                                        .addGap(162, 162, 162))
                                    .addComponent(txtCliCod, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(40, 40, 40)
                                    .addComponent(txtCliCpf))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCliFone, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCliCad)
                        .addGap(18, 18, 18)
                        .addComponent(btnCliPes, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCliEdi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCliExc)
                        .addGap(98, 98, 98)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCliRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCliFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnCliEdi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCliPes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCliCad))
                    .addComponent(btnCliExc))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        setBounds(0, 0, 576, 524);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCliRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliRgActionPerformed

    private void btnCliCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliCadActionPerformed
        // TODO add your handling code here:
        cadastrar();
    }//GEN-LAST:event_btnCliCadActionPerformed

    private void btnCliPesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliPesActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_btnCliPesActionPerformed

    private void cbbCliUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbCliUfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbCliUfActionPerformed

    private void btnCliExcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliExcActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_btnCliExcActionPerformed

    private void btnCliEdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliEdiActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_btnCliEdiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliCad;
    private javax.swing.JButton btnCliEdi;
    private javax.swing.JButton btnCliExc;
    private javax.swing.JButton btnCliPes;
    private javax.swing.JComboBox<String> cbbCliUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCliBai;
    private javax.swing.JTextField txtCliCep;
    private javax.swing.JTextField txtCliCid;
    private javax.swing.JTextField txtCliCod;
    private javax.swing.JTextField txtCliCom;
    private javax.swing.JTextField txtCliCpf;
    private javax.swing.JTextField txtCliFone;
    private javax.swing.JTextField txtCliLou;
    private javax.swing.JTextField txtCliNome;
    private javax.swing.JTextField txtCliNr;
    private javax.swing.JTextField txtCliRg;
    // End of variables declaration//GEN-END:variables
}
