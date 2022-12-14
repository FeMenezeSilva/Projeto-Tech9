/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.tech9.telas;

import br.com.tech9.dal.SistemaDao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
public class Alterar extends javax.swing.JFrame {

    /**
     * Creates new form Alterar
     */
    public Alterar() {
        initComponents();
    }
    public Alterar(String idprod, String nome, String preco, String quantidade) {
        initComponents();
        txtIdProd.setText(idprod);
        txtNome.setText(nome);
        txtPreco.setText(preco);
        txtQuantidade.setText(quantidade);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNome = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        txtIdProd = new javax.swing.JTextField();
        lblFundo = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Produto");
        setResizable(false);
        getContentPane().setLayout(null);

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome);
        txtNome.setBounds(70, 130, 140, 28);
        getContentPane().add(txtPreco);
        txtPreco.setBounds(70, 180, 140, 28);
        getContentPane().add(txtQuantidade);
        txtQuantidade.setBounds(70, 230, 140, 28);

        txtIdProd.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtIdProd);
        txtIdProd.setBounds(70, 80, 140, 28);

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tech9/icones/Alterar.png"))); // NOI18N
        getContentPane().add(lblFundo);
        lblFundo.setBounds(0, 0, 610, 410);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(310, 140, 63, 28);

        setSize(new java.awt.Dimension(616, 371));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        String id, n, p, q;
        id = txtIdProd.getText();
        n = txtNome.getText();
        p = txtPreco.getText();
        q = txtQuantidade.getText();
        //2 - Verificar se os campos txtUsuario e txtSenha do formul??rio, n??o est??o vazios.
        if (id.isEmpty()) { // se usu??rio est?? vazio
            JOptionPane.showMessageDialog(null, "?? obrigat??rio digitar o usu??rio");
            txtIdProd.requestFocus();
            return; // stop
        }
        if (n.isEmpty()) { // se senha est?? vazia
            JOptionPane.showMessageDialog(null, "?? obrigat??rio digitar a senha");
            txtNome.requestFocus();
            return; // stop
        }

        try {
            // Alterar os dados do usu??rio
            SistemaDao dao;
            dao = new SistemaDao();
            dao.alterarProduto(id, n, p, q);

            //4.1 Mostrar a mensagem "Usu??rio alterado com sucesso" e limpar os campos.
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");

            dispose();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Mensagem de erro:" + ex.getMessage());
        } catch (SQLException ex) {
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
            java.util.logging.Logger.getLogger(Alterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alterar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JTextField txtIdProd;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
