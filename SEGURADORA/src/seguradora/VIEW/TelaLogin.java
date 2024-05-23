/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package seguradora.VIEW;

import java.awt.Toolkit;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import seguradora.DAL.ModuloConexao;

public class TelaLogin extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    //';

    public void logar() {
        String sql = "SELECT * from e5_usuarios WHERE LOGIN=? AND SENHA=?";
        // Preparo para consulta ao BD onde o ?(acima) será substituido
        // pelo campo a ser consultado na tela de Login(
        // ou seja as variáveis do usuário e senha.
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuario.getText());
            pst.setString(2, txtSenha.getText());

            rs = pst.executeQuery();

            if (rs.next()) {
                Principal principal = new Principal();
                principal.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "usuário inválido");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
   

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        conexao = ModuloConexao.conector();
        //System.out.println(conexao);        
        if (conexao != null) {
            // Mensagem para usuário
            lblStatus2.setText("Conectado!!");
            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("dbok.png")));
        } else {
            // Mensagem para usuário
            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("dberro.png")));
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
        btnLogin = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        lblStatus = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnUsuario = new javax.swing.JButton();
        lblStatus2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuário");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Senha");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setOpaque(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, -1));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 192, 30));
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 192, 30));

        lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seguradora/VIEW/dbok.png"))); // NOI18N
        lblStatus.setText("Status");
        getContentPane().add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 58, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seguradora/VIEW/Cadeado_Login.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 11, 144, -1));

        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seguradora/VIEW/userAdicionar.png"))); // NOI18N
        btnUsuario.setToolTipText("CADASTRAR USUÁRIO");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 70, 70));

        lblStatus2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStatus2.setForeground(new java.awt.Color(51, 255, 51));
        getContentPane().add(lblStatus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 130, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seguradora/VIEW/FundoLogin.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 310));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        logar();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        // TODO add your handling code here:
        TelaUsuario usuario = new TelaUsuario();
        usuario.setVisible(true);
    }//GEN-LAST:event_btnUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatus2;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private String getResource(String bokpng) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}