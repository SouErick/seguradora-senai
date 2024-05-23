/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package seguradora.VIEW;

import javax.swing.Icon;
import javax.swing.JOptionPane;
import seguradora.DAL.ModuloConexao;
import java.sql.*;


public class TelaAutomovel extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaClienteCad
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaAutomovel() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    private void cadastrar() {
        String sql = "INSERT INTO e1_automovel(COD, PLACA, RENAVAM, FABRICANTE, MODELO, ANO, COR) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCod.getText());
            pst.setString(2, txtPlaca.getText());
            pst.setString(3, txtRenavam.getText());
            pst.setString(4, txtFab.getText());
            pst.setString(5, txtModelo.getText());
            pst.setString(6, txtAno.getText());
            pst.setString(7, txtCor.getText());
            System.out.println("Resultado");
            System.out.println(pst);
            int resultado = pst.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Carro Cadastrado");
                txtCod.setText(null);
                txtPlaca.setText(null);
                txtRenavam.setText(null);
                txtFab.setText(null);
                txtModelo.setText(null);
                txtAno.setText(null);
                txtCor.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "Carro Não Cadastrado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void consultar() {
        String sql = "SELECT * FROM e1_automovel WHERE cod=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCod.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Carro Encontrado");
                txtPlaca.setText(rs.getString("placa"));
                txtRenavam.setText(rs.getString("renavam"));
                txtFab.setText(rs.getString("fabricante"));
                txtModelo.setText(rs.getString("modelo"));
                txtAno.setText(rs.getString("ano"));
                txtCor.setText(rs.getString("cor"));
            } else {
                JOptionPane.showMessageDialog(null, "Carro Não Encontrado");
                txtCod.setText(null);
                txtPlaca.setText(null);
                txtRenavam.setText(null);
                txtFab.setText(null);
                txtModelo.setText(null);
                txtAno.setText(null);
                txtCor.setText(null);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void editar() {
        int atualizar = JOptionPane.showConfirmDialog(null, "Deseja editar?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (atualizar == JOptionPane.YES_NO_OPTION) {
            String sql = "UPDATE e1_automovel SET placa=?, renavam=?, fabricante=?, modelo=?, ano=?, cor=? WHERE cod=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtPlaca.getText());
                pst.setString(2, txtRenavam.getText());
                pst.setString(3, txtFab.getText());
                pst.setString(4, txtModelo.getText());
                pst.setString(5, txtAno.getText());
                pst.setString(6, txtCor.getText());
                pst.setString(7, txtCod.getText());
                int apagado = pst.executeUpdate();
                if (apagado >= 1) {
                    JOptionPane.showMessageDialog(null, "Carro Editado Com Sucesso!");
                    txtCod.setText(null);
                    txtPlaca.setText(null);
                    txtRenavam.setText(null);
                    txtFab.setText(null);
                    txtModelo.setText(null);
                    txtAno.setText(null);
                    txtCor.setText(null);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void deletar() {
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja remover?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_NO_OPTION) {
            String sql = "DELETE FROM e1_automovel WHERE cod=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtCod.getText());
                int apagado = pst.executeUpdate();
                if (apagado >= 1) {
                    JOptionPane.showMessageDialog(null, "Carro Apagado Com Sucesso!");
                    txtCod.setText(null);
                    txtPlaca.setText(null);
                    txtRenavam.setText(null);
                    txtFab.setText(null);
                    txtModelo.setText(null);
                    txtAno.setText(null);
                    txtCor.setText(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Carro Não Apagado");
                    txtCod.setText(null);
                    txtPlaca.setText(null);
                    txtRenavam.setText(null);
                    txtFab.setText(null);
                    txtModelo.setText(null);
                    txtAno.setText(null);
                    txtCor.setText(null);
                }
            } catch (SQLException e) {
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        txtRenavam = new javax.swing.JTextField();
        txtFab = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        txtCor = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnProcurar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("TC - Cadastro de Automóveis");
        setPreferredSize(new java.awt.Dimension(700, 380));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Placa");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Renavam");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Fabricante");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Modelo");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Ano");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Cor");

        txtCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorActionPerformed(evt);
            }
        });

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seguradora/VIEW/carAdicionar.png"))); // NOI18N
        btnAdicionar.setToolTipText("CADASTRAR");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seguradora/VIEW/carPesquisa.png"))); // NOI18N
        btnProcurar.setToolTipText("PROCURAR");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seguradora/VIEW/carExcluir.png"))); // NOI18N
        btnExcluir.setToolTipText("DELETAR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seguradora/VIEW/carEditar.png"))); // NOI18N
        btnEditar.setToolTipText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)))
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnProcurar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir))
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFab, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnProcurar))
                    .addComponent(btnExcluir))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        setBounds(0, 0, 476, 454);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        cadastrar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        deletar();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtFab;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtRenavam;
    // End of variables declaration//GEN-END:variables
}
