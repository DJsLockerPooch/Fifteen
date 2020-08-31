package fifteen;

public class FifteenFrame extends javax.swing.JFrame {

    public FifteenFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        attemps = new javax.swing.JTextField();
        newGame = new javax.swing.JButton();
        fifteenPanel1 = new fifteen.fifteenPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 450));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(400, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        attemps.setEditable(false);
        attemps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attempsActionPerformed(evt);
            }
        });
        jPanel1.add(attemps);

        newGame.setText("New Game");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        jPanel1.add(newGame);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        fifteenPanel1.setFont(new java.awt.Font("Chalkboard", 0, 24)); // NOI18N
        fifteenPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fifteenPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout fifteenPanel1Layout = new javax.swing.GroupLayout(fifteenPanel1);
        fifteenPanel1.setLayout(fifteenPanel1Layout);
        fifteenPanel1Layout.setHorizontalGroup(
            fifteenPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        fifteenPanel1Layout.setVerticalGroup(
            fifteenPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );

        getContentPane().add(fifteenPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void attempsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attempsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attempsActionPerformed

    private void fifteenPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fifteenPanel1MouseClicked

    }//GEN-LAST:event_fifteenPanel1MouseClicked

    private void fifteenPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fifteenPanel1MousePressed
        guessNum++;
        updateControls();
    }//GEN-LAST:event_fifteenPanel1MousePressed

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        restartGame();
    }//GEN-LAST:event_newGameActionPerformed

    private void updateControls() {
        attemps.setText(Integer.toString(guessNum));
    }

    private void restartGame() {
        fifteenPanel1.restartTiles();
        guessNum = 0;
        updateControls();
    }

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
            java.util.logging.Logger.getLogger(FifteenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FifteenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FifteenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FifteenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FifteenFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField attemps;
    private fifteen.fifteenPanel fifteenPanel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton newGame;
    // End of variables declaration//GEN-END:variables

    private int guessNum;
}
