/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

/**
 *
 * @author sgoug
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form MainScreenMockUp
     */
    public Interface() {
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

        LoginScreen = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        LoginPgBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NavigationScreen = new javax.swing.JPanel();
        BGPanel = new javax.swing.JPanel();
        NavMenu1 = new javax.swing.JPanel();
        PortunusLogo1 = new javax.swing.JLabel();
        PasswordsBtn = new javax.swing.JButton();
        SettingsBtn = new javax.swing.JButton();
        LoginOutBtn = new javax.swing.JButton();
        ChangingPanel = new javax.swing.JPanel();
        PasswordsPan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SettingsPan = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new java.awt.CardLayout());

        LoginScreen.setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPasswordField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Password");

        LoginPgBtn.setBackground(new java.awt.Color(0, 0, 0));
        LoginPgBtn.setText("Login!");
        LoginPgBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LoginPgBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginPgBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel4.setText("Welcome to Portunus!");

        jLabel5.setText("Username");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(LoginPgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel4)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(LoginPgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout LoginScreenLayout = new javax.swing.GroupLayout(LoginScreen);
        LoginScreen.setLayout(LoginScreenLayout);
        LoginScreenLayout.setHorizontalGroup(
            LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginScreenLayout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(306, Short.MAX_VALUE))
        );
        LoginScreenLayout.setVerticalGroup(
            LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginScreenLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        getContentPane().add(LoginScreen, "card3");

        NavigationScreen.setBackground(new java.awt.Color(153, 153, 153));
        NavigationScreen.setForeground(new java.awt.Color(153, 153, 153));
        NavigationScreen.setMaximumSize(new java.awt.Dimension(600, 900));

        BGPanel.setBackground(new java.awt.Color(153, 153, 153));

        NavMenu1.setBackground(new java.awt.Color(51, 204, 255));
        NavMenu1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        PortunusLogo1.setIcon(new javax.swing.ImageIcon("C:\\Users\\sgoug\\Desktop\\CS 321\\PortunusLogo15.png")); // NOI18N

        PasswordsBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PasswordsBtn.setText("Passwords");
        PasswordsBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        PasswordsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PasswordsBtnMouseClicked(evt);
            }
        });
        PasswordsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordsBtnActionPerformed(evt);
            }
        });

        SettingsBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SettingsBtn.setText("Settings");
        SettingsBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        SettingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsBtnActionPerformed(evt);
            }
        });

        LoginOutBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        LoginOutBtn.setText("Log In/out");
        LoginOutBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        javax.swing.GroupLayout NavMenu1Layout = new javax.swing.GroupLayout(NavMenu1);
        NavMenu1.setLayout(NavMenu1Layout);
        NavMenu1Layout.setHorizontalGroup(
            NavMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavMenu1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(NavMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PasswordsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SettingsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LoginOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PortunusLogo1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        NavMenu1Layout.setVerticalGroup(
            NavMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavMenu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PortunusLogo1)
                .addGap(30, 30, 30)
                .addComponent(PasswordsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(SettingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(LoginOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ChangingPanel.setBackground(new java.awt.Color(153, 153, 153));
        ChangingPanel.setLayout(new java.awt.CardLayout());

        PasswordsPan.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setText("Passwords");

        javax.swing.GroupLayout PasswordsPanLayout = new javax.swing.GroupLayout(PasswordsPan);
        PasswordsPan.setLayout(PasswordsPanLayout);
        PasswordsPanLayout.setHorizontalGroup(
            PasswordsPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PasswordsPanLayout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jLabel1)
                .addContainerGap(403, Short.MAX_VALUE))
        );
        PasswordsPanLayout.setVerticalGroup(
            PasswordsPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PasswordsPanLayout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jLabel1)
                .addContainerGap(359, Short.MAX_VALUE))
        );

        ChangingPanel.add(PasswordsPan, "card2");

        SettingsPan.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setText("Settings");

        javax.swing.GroupLayout SettingsPanLayout = new javax.swing.GroupLayout(SettingsPan);
        SettingsPan.setLayout(SettingsPanLayout);
        SettingsPanLayout.setHorizontalGroup(
            SettingsPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsPanLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabel2)
                .addContainerGap(377, Short.MAX_VALUE))
        );
        SettingsPanLayout.setVerticalGroup(
            SettingsPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsPanLayout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel2)
                .addContainerGap(306, Short.MAX_VALUE))
        );

        ChangingPanel.add(SettingsPan, "card3");

        javax.swing.GroupLayout BGPanelLayout = new javax.swing.GroupLayout(BGPanel);
        BGPanel.setLayout(BGPanelLayout);
        BGPanelLayout.setHorizontalGroup(
            BGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NavMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ChangingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BGPanelLayout.setVerticalGroup(
            BGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NavMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ChangingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout NavigationScreenLayout = new javax.swing.GroupLayout(NavigationScreen);
        NavigationScreen.setLayout(NavigationScreenLayout);
        NavigationScreenLayout.setHorizontalGroup(
            NavigationScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationScreenLayout.createSequentialGroup()
                .addComponent(BGPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        NavigationScreenLayout.setVerticalGroup(
            NavigationScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(NavigationScreen, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordsBtnActionPerformed
        PasswordsPan.setVisible(true);
        SettingsPan.setVisible(false);
    }//GEN-LAST:event_PasswordsBtnActionPerformed

    private void PasswordsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordsBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordsBtnMouseClicked

    private void SettingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsBtnActionPerformed
        SettingsPan.setVisible(true);
        PasswordsPan.setVisible(false);
    }//GEN-LAST:event_SettingsBtnActionPerformed

    private void LoginPgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginPgBtnActionPerformed
        NavigationScreen.setVisible(true);
        LoginScreen.setVisible(false);
    }//GEN-LAST:event_LoginPgBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BGPanel;
    private javax.swing.JPanel ChangingPanel;
    private javax.swing.JButton LoginOutBtn;
    private javax.swing.JButton LoginPgBtn;
    private javax.swing.JPanel LoginScreen;
    private javax.swing.JPanel NavMenu1;
    private javax.swing.JPanel NavigationScreen;
    private javax.swing.JButton PasswordsBtn;
    private javax.swing.JPanel PasswordsPan;
    private javax.swing.JLabel PortunusLogo1;
    private javax.swing.JButton SettingsBtn;
    private javax.swing.JPanel SettingsPan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
