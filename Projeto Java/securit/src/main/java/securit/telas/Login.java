package securit.telas;

import securit.database.Banco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends javax.swing.JFrame {

    Banco banco = new Banco();
    Dashboard dash;
    
    public Login() {
        initComponents();
        cbSistemas.setVisible(false);
        lbSistema.setVisible(false);
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
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        btnEntrar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cbSistemas = new javax.swing.JComboBox<>();
        lbSistema = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Senha");

        txtLogin.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        txtSenha.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        btnEntrar.setBackground(java.awt.Color.orange);
        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.setBorder(null);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        jPanel6.setBackground(java.awt.Color.orange);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(254, 254, 254));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("securIT");
        jLabel20.setToolTipText("");
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(254, 254, 254));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("A SEGURANÇA QUE VOCÊ MERECE");
        jLabel21.setToolTipText("");
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbSistemas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSistemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSistemasActionPerformed(evt);
            }
        });

        lbSistema.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbSistema.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSistema.setText("Escolha o Sistema:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addComponent(txtSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSistemas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSistema, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(lbSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSistemas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        String response = banco.validateLogin(txtLogin.getText(), txtSenha.getText());
        if(response.equals("Logado")){
            if(banco.getClientSystems().size() > 0){
                List lista = banco.getClientSystems();
                
                cbSistemas.setModel(new DefaultComboBoxModel(lista.toArray()));
                lbSistema.setVisible(true);
                cbSistemas.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null, 
                        "Não foi encontrado nenhum sistema cadastrado. "
                                + "Por favor entre no seu dashboard e "
                                + "faça o cadastro do sistema e seus dispositivos.");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, response);
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void cbSistemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSistemasActionPerformed
//        JOptionPane.showMessageDialog(null, cbSistemas.getSelectedIndex());
        
        String idSistema = banco.getClientSystemsId().get(cbSistemas.getSelectedIndex()).toString();
        this.dispose();
        try {
            dash = new Dashboard(cbSistemas.getSelectedItem().toString(), idSistema);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        dash.setVisible(true);
    }//GEN-LAST:event_cbSistemasActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JComboBox<String> cbSistemas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbSistema;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
