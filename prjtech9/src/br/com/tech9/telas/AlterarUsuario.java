/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.tech9.telas;

import br.com.tech9.dal.SistemaDao;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class AlterarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form AlterarUsuario
     */
    public AlterarUsuario() {
        initComponents();
    }
    public AlterarUsuario(String usuario, String senha, String nome, String cargo) {
        initComponents();
        txtUsuario.setText(usuario);
        txtSenha.setText(senha);
        txtName.setText(nome);
        cmbCargo.setSelectedItem(cargo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        cmbCargo = new javax.swing.JComboBox<>();
        lblFundo = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Usuario");
        setResizable(false);
        getContentPane().setLayout(null);

        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(60, 60, 130, 28);

        txtName.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtName);
        txtName.setBounds(60, 110, 130, 28);

        txtSenha.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtSenha);
        txtSenha.setBounds(60, 160, 130, 28);

        cmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "usuario" }));
        getContentPane().add(cmbCargo);
        cmbCargo.setBounds(60, 210, 130, 26);

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tech9/icones/Altuser.png"))); // NOI18N
        getContentPane().add(lblFundo);
        lblFundo.setBounds(0, 0, 600, 370);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(310, 120, 63, 28);

        setSize(new java.awt.Dimension(606, 401));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
         String u, s, n, c;
        u = txtUsuario.getText();
        s = txtSenha.getText();
        n = txtName.getText();
        c = cmbCargo.getSelectedItem().toString();
        //2 - Verificar se os campos txtUsuario e txtSenha do formulário, não estão vazios.
        if (u.isEmpty()) { // se usuário está vazio
            JOptionPane.showMessageDialog(null, "É obrigatório digitar o usuário");
            txtUsuario.requestFocus();
            return; // stop
        }
        if (s.isEmpty()) { // se senha está vazia
            JOptionPane.showMessageDialog(null, "É obrigatório digitar a senha");
            txtSenha.requestFocus();
            return; // stop
        }

        try {
            // Alterar os dados do usuário
            SistemaDao dao;
            dao = new SistemaDao();
            dao.alterarUsuario(s, n, c, u);

            //4.1 Mostrar a mensagem "Usuário alterado com sucesso" e limpar os campos.
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso");

            dispose();
        } 
        catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Mensagem de erro:" + ex.getMessage());
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JComboBox<String> cmbCargo;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNome1;
    private javax.swing.JTextField txtNome2;
    private javax.swing.JTextField txtNome3;
    private javax.swing.JTextField txtNome4;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}