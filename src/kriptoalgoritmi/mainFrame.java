/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kriptoalgoritmi;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Njamb
 */
public class mainFrame extends javax.swing.JFrame implements ActionListener {
    
    private JFileChooser fileChooser;
    
    /** Creates new form mainFrame */
    public mainFrame() {
        // Setting location for main form to be displayed at:
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/4, dim.height/4);
        initComponents();
        
        // Setting button listeners:
        encSrcBtn.addActionListener(this);
        encDstBtn.addActionListener(this);
        decSrcBtn.addActionListener(this);
        decDstBtn.addActionListener(this);
        encBtn.addActionListener(this);
        decBtn.addActionListener(this);
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvt) {
                // TO-DO:
                // Add window closing handler
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        encriptionPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        encSrcDir = new javax.swing.JTextField();
        encSrcBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        encDstDir = new javax.swing.JTextField();
        encDstBtn = new javax.swing.JButton();
        encCheckBox = new javax.swing.JCheckBox();
        encBtn = new javax.swing.JButton();
        encProgressBar = new javax.swing.JProgressBar();
        encProgressLabel = new javax.swing.JLabel();
        decriptionPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        decSrcDir = new javax.swing.JTextField();
        decSrcBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        decDstDir = new javax.swing.JTextField();
        decDstBtn = new javax.swing.JButton();
        decBtn = new javax.swing.JButton();
        decProgressBar = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        decProgressLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Njamb's Cryptography");
        setResizable(false);

        encriptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Encryption"));
        encriptionPanel.setName(""); // NOI18N

        jLabel1.setText("Source directory for encryption:");

        encSrcDir.setEditable(false);
        encSrcDir.setToolTipText("");

        encSrcBtn.setText("Choose");

        jLabel2.setText("Destination directory for encrypted files:");

        encDstDir.setEditable(false);

        encDstBtn.setText("Choose");

        encCheckBox.setText("Turn On/Off automatic encryption.");
        encCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                encCheckBoxStateChanged(evt);
            }
        });

        encBtn.setText("Encrypt");

        encProgressLabel.setText("Progress:");

        javax.swing.GroupLayout encriptionPanelLayout = new javax.swing.GroupLayout(encriptionPanel);
        encriptionPanel.setLayout(encriptionPanelLayout);
        encriptionPanelLayout.setHorizontalGroup(
            encriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encriptionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(encriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(encProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                    .addGroup(encriptionPanelLayout.createSequentialGroup()
                        .addComponent(encDstDir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(encDstBtn))
                    .addGroup(encriptionPanelLayout.createSequentialGroup()
                        .addComponent(encSrcDir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(encSrcBtn))
                    .addGroup(encriptionPanelLayout.createSequentialGroup()
                        .addGroup(encriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(encriptionPanelLayout.createSequentialGroup()
                                .addComponent(encBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(encCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(encProgressLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        encriptionPanelLayout.setVerticalGroup(
            encriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encriptionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(encriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encSrcDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(encSrcBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(encriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encDstDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(encDstBtn))
                .addGap(18, 18, 18)
                .addGroup(encriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encBtn)
                    .addComponent(encCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(encProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(encProgressLabel)
                .addGap(6, 6, 6))
        );

        decriptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Decryption"));

        jLabel3.setText("Source directory for decryption:");

        decSrcDir.setEditable(false);

        decSrcBtn.setText("Choose");

        jLabel4.setText("Destination directory for decription:");

        decDstDir.setEditable(false);

        decDstBtn.setText("Choose");

        decBtn.setText("Decrypt");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("* Default directory is destination directory for encrypted files");

        decProgressLabel.setText("Progress:");

        javax.swing.GroupLayout decriptionPanelLayout = new javax.swing.GroupLayout(decriptionPanel);
        decriptionPanel.setLayout(decriptionPanelLayout);
        decriptionPanelLayout.setHorizontalGroup(
            decriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decriptionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(decriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(decProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(decriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addComponent(decBtn)
                        .addComponent(decProgressLabel)
                        .addGroup(decriptionPanelLayout.createSequentialGroup()
                            .addGroup(decriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(decDstDir, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                                .addComponent(decSrcDir))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(decriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(decSrcBtn)
                                .addComponent(decDstBtn)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        decriptionPanelLayout.setVerticalGroup(
            decriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decriptionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(decriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(decSrcDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decSrcBtn))
                .addGap(1, 1, 1)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(decriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(decDstDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decDstBtn))
                .addGap(18, 18, 18)
                .addComponent(decBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(decProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decProgressLabel)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(encriptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decriptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(encriptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decriptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        encriptionPanel.getAccessibleContext().setAccessibleName("");
        encriptionPanel.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void encCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_encCheckBoxStateChanged
        if (encCheckBox.isSelected())
            encBtn.setEnabled(false);
        else
            encBtn.setEnabled(true);
    }//GEN-LAST:event_encCheckBoxStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton decBtn;
    private javax.swing.JButton decDstBtn;
    private javax.swing.JTextField decDstDir;
    private javax.swing.JProgressBar decProgressBar;
    private javax.swing.JLabel decProgressLabel;
    private javax.swing.JButton decSrcBtn;
    private javax.swing.JTextField decSrcDir;
    private javax.swing.JPanel decriptionPanel;
    private javax.swing.JButton encBtn;
    private javax.swing.JCheckBox encCheckBox;
    private javax.swing.JButton encDstBtn;
    private javax.swing.JTextField encDstDir;
    private javax.swing.JProgressBar encProgressBar;
    private javax.swing.JLabel encProgressLabel;
    private javax.swing.JButton encSrcBtn;
    private javax.swing.JTextField encSrcDir;
    private javax.swing.JPanel encriptionPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO add your handling code here:
        Object sender = e.getSource();
        
        if (sender == encBtn || sender == decBtn) {
            // 'Encript' button
            if (sender == encBtn) {
                if (!encSrcDir.getText().isEmpty() && 
                        !encDstDir.getText().isEmpty()) {

                }
                else {
                    JOptionPane.showMessageDialog(null, "Please choose "
                            + "encription source & destination folders before "
                            + "retrying to encript files.",
                            "Folders not specified", 
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            // 'Decript' button
            else {
                if (!decSrcDir.getText().isEmpty() && 
                        !decDstDir.getText().isEmpty()) {
                    
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please choose "
                            + "decription source & destination folders before "
                            + "retrying to encript files.",
                            "Folders not specified",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            }
        else {
            fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose directory");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);

            if (fileChooser.showOpenDialog(null) == 
                    JFileChooser.APPROVE_OPTION) {
                String path = fileChooser.getSelectedFile().toString();
                // Encription source directory button
                if (sender == encSrcBtn) {
                    encSrcDir.setText(path);
                }
                // Encription destination directory button
                else if (sender == encDstBtn) {
                    encDstDir.setText(path);
                    if (decSrcDir.getText().isEmpty())
                        decSrcDir.setText(path);
                }
                // Decription source directory button
                else if (sender == decSrcBtn) {
                    decSrcDir.setText(path);
                }
                // Decription destination directory button
                else if (sender == decDstBtn) {
                    decDstDir.setText(path);
                }

            }
        }
    }

}
