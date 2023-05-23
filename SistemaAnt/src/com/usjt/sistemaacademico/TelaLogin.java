/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.usjt.sistemaacademico;


import com.usjt.dao.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author erica
 */
public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public TelaLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btLogar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        txtLogin = new javax.swing.JTextField();
        ckMostrarSenha = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(358, 412));
        setMinimumSize(new java.awt.Dimension(358, 412));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(null);

        btLogar.setText("Logar");
        btLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogarActionPerformed(evt);
            }
        });
        getContentPane().add(btLogar);
        btLogar.setBounds(40, 340, 300, 44);

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        getContentPane().add(btSair);
        btSair.setBounds(40, 390, 300, 44);
        getContentPane().add(txtLogin);
        txtLogin.setBounds(40, 200, 300, 30);

        ckMostrarSenha.setText("Mostrar senha");
        ckMostrarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckMostrarSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(ckMostrarSenha);
        ckMostrarSenha.setBounds(40, 290, 140, 20);

        jLabel2.setText("Usuário");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 180, 100, 16);

        jLabel3.setText("Senha");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 240, 150, 16);

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(txtSenha);
        txtSenha.setBounds(40, 260, 300, 30);

        setSize(new java.awt.Dimension(396, 477));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogarActionPerformed
        // TODO add your handling code here:
        String login, senha;
        

        login = txtLogin.getText();
        senha = txtSenha.getText();
        System.out.println(senha);
        
        Usuario lg = new Usuario(login, senha);
        
        if(lg.Entrar(lg))
        {
            JOptionPane.showMessageDialog(null, "Seja bem vindo, " + login);
            TelaInicial menu = new TelaInicial();
            menu.setVisible(true);
            dispose();
        }
        else
           JOptionPane.showMessageDialog(null, "ERRO. Senha Inválida!");

    }//GEN-LAST:event_btLogarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:

        System.exit(0);
    }//GEN-LAST:event_btSairActionPerformed

    private void ckMostrarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckMostrarSenhaActionPerformed
        // TODO add your handling code here:
        if(ckMostrarSenha.isSelected())
        txtSenha.setEchoChar('\u0000');
        else
        txtSenha.setEchoChar('\u2022');
    }//GEN-LAST:event_ckMostrarSenhaActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogar;
    private javax.swing.JButton btSair;
    private javax.swing.JCheckBox ckMostrarSenha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
