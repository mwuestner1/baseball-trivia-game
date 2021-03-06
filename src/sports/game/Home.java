package sports.game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mattw
 */

public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        home_panel = new javax.swing.JPanel();
        home_label = new javax.swing.JLabel();
        login_radio = new javax.swing.JRadioButton();
        register_radio = new javax.swing.JRadioButton();
        go_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        home_panel.setBackground(java.awt.Color.red);
        home_panel.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(255, 255, 255)));

        home_label.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        home_label.setForeground(new java.awt.Color(255, 255, 255));
        home_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home_label.setText("Home Page");

        login_radio.setBackground(java.awt.Color.red);
        buttonGroup1.add(login_radio);
        login_radio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        login_radio.setForeground(new java.awt.Color(255, 255, 255));
        login_radio.setSelected(true);
        login_radio.setText("Login");
        login_radio.setBorder(null);

        register_radio.setBackground(java.awt.Color.red);
        buttonGroup1.add(register_radio);
        register_radio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        register_radio.setForeground(new java.awt.Color(255, 255, 255));
        register_radio.setText("Register");
        register_radio.setBorder(null);

        go_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        go_btn.setForeground(java.awt.Color.red);
        go_btn.setText("GO");
        go_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                go_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout home_panelLayout = new javax.swing.GroupLayout(home_panel);
        home_panel.setLayout(home_panelLayout);
        home_panelLayout.setHorizontalGroup(
            home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_panelLayout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addGroup(home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(register_radio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login_radio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, home_panelLayout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addGroup(home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(home_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(go_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(250, 250, 250))
        );
        home_panelLayout.setVerticalGroup(
            home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(home_label)
                .addGap(85, 85, 85)
                .addComponent(login_radio)
                .addGap(67, 67, 67)
                .addComponent(register_radio)
                .addGap(87, 87, 87)
                .addComponent(go_btn)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(home_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(home_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void go_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_go_btnMouseClicked
        if (login_radio.isSelected()) {
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        } else {
            Register register = new Register();
            register.setVisible(true);
            this.dispose();
        } 
    }//GEN-LAST:event_go_btnMouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton go_btn;
    private javax.swing.JLabel home_label;
    private javax.swing.JPanel home_panel;
    private javax.swing.JRadioButton login_radio;
    private javax.swing.JRadioButton register_radio;
    // End of variables declaration//GEN-END:variables
}
