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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Njamb
 */
public class A5_1Frame extends javax.swing.JFrame implements ActionListener {

    private JFileChooser fileChooser;
    private directoryClass dir = directoryClass.getInstance();
    
    /**
     * Creates new form A5_1Frame
     */
    public A5_1Frame() {
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
        
        checkButtons();        
        dir.clearListeners();
        dir.setA5_1Listener(this);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        encriptionPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        encSrcDir = new javax.swing.JTextField();
        encSrcBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        encDstDir = new javax.swing.JTextField();
        encDstBtn = new javax.swing.JButton();
        encCheckBox = new javax.swing.JCheckBox();
        encBtn = new javax.swing.JButton();
        keyTextField = new javax.swing.JTextField();
        wordsPerGroupLabel = new javax.swing.JLabel();
        decriptionPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        decSrcDir = new javax.swing.JTextField();
        decSrcBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        decDstDir = new javax.swing.JTextField();
        decDstBtn = new javax.swing.JButton();
        decBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel7.setText("A5/1");
        jPanel1.add(jLabel7);

        encriptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Encryption"));
        encriptionPanel.setName(""); // NOI18N

        jLabel1.setText("Source directory for encryption:");

        encSrcDir.setEditable(false);
        encSrcDir.setToolTipText("");

        encSrcBtn.setText("Choose");

        jLabel2.setText("Destination directory for encrypted files:");

        encDstDir.setEditable(false);

        encDstBtn.setText("Choose");

        encCheckBox.setText("Turn on automatic encryption.");
        encCheckBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                encCheckBoxMouseClicked(evt);
            }
        });

        encBtn.setText("Encrypt");

        keyTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        keyTextField.setToolTipText("");
        keyTextField.setMinimumSize(new java.awt.Dimension(462, 24));
        keyTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyTextFieldMouseClicked(evt);
            }
        });
        keyTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                keyTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keyTextFieldKeyReleased(evt);
            }
        });

        wordsPerGroupLabel.setText("Enter 64bit key:");

        javax.swing.GroupLayout encriptionPanelLayout = new javax.swing.GroupLayout(encriptionPanel);
        encriptionPanel.setLayout(encriptionPanelLayout);
        encriptionPanelLayout.setHorizontalGroup(
            encriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, encriptionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(encriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(keyTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, encriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addGroup(encriptionPanelLayout.createSequentialGroup()
                            .addComponent(encBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(encCheckBox))
                        .addComponent(wordsPerGroupLabel)
                        .addGroup(encriptionPanelLayout.createSequentialGroup()
                            .addGroup(encriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(encDstDir, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(encSrcDir, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(encriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(encSrcBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(encDstBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wordsPerGroupLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(encriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encBtn)
                    .addComponent(encCheckBox))
                .addContainerGap())
        );

        decriptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Decryption"));
        decriptionPanel.setPreferredSize(new java.awt.Dimension(484, 239));

        jLabel3.setText("Source directory for decryption:");

        decSrcDir.setEditable(false);

        decSrcBtn.setText("Choose");

        jLabel4.setText("Destination directory for decription:");

        decDstDir.setEditable(false);

        decDstBtn.setText("Choose");

        decBtn.setText("Decrypt");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("* Default directory is destination directory for encrypted files");

        javax.swing.GroupLayout decriptionPanelLayout = new javax.swing.GroupLayout(decriptionPanel);
        decriptionPanel.setLayout(decriptionPanelLayout);
        decriptionPanelLayout.setHorizontalGroup(
            decriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, decriptionPanelLayout.createSequentialGroup()
                .addGroup(decriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(decriptionPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(decriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(decDstDir, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(decSrcDir, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(decriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(decSrcBtn)
                            .addComponent(decDstBtn)))
                    .addGroup(decriptionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(decriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(decBtn))))
                .addContainerGap())
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
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(encriptionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(decriptionPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(encriptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(decriptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void encCheckBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_encCheckBoxMouseClicked
        if (encCheckBox.isSelected()) {
            if (keyTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter "
                                    + "64bit key before trying to encrypt.",
                                        "Folders not specified", 
                                        JOptionPane.INFORMATION_MESSAGE);
                encCheckBox.setSelected(false);
                encCheckBox.setText("Turn on automatic encryption.");
            }
            else
                if (keyTextField.getText().length() != 64) {
                    JOptionPane.showMessageDialog(null,
                        "Please enter array of 64 ones & zeros as a key.", 
                        "You've done goofed!", JOptionPane.INFORMATION_MESSAGE);
                    encCheckBox.setSelected(false);
                    encCheckBox.setText("Turn on automatic encryption.");
                }
                else {
            
                    encCheckBox.setText("Turn off automatic encryption.");

                    // Get the paths from GUI and store them in 'dir' variable:
                    fillDirClass();

                    // Read the content of the encryption source folder:
                    dir.readAllFromDirectory(dir.getEncSrc(), true);

                    // Start a new thread so GUI doesn't get blocked:
                    Thread t = new Thread(dir);
                    t.start();
                }
        }
        else
        encCheckBox.setText("Turn on automatic encryption.");
    }//GEN-LAST:event_encCheckBoxMouseClicked

    private void keyTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keyTextFieldMouseClicked

        if (keyTextField.getText()
            .equals("# of words per group"))
        keyTextField.setText("");
    }//GEN-LAST:event_keyTextFieldMouseClicked

    private void keyTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyTextFieldKeyReleased
        if (!keyTextField.getText().isEmpty()) {
            if (keyTextField.getText()
                .charAt(keyTextField.getText().length()-1) != '1' 
                    && keyTextField.getText()
                            .charAt(keyTextField
                                    .getText().length()-1) != '0')
            {
                JOptionPane.showMessageDialog(null,
                        "You're trying to enter something other than '1' or '0'."
                            + " Please try again using only '1's and '0's.", 
                        "You've done goofed!", JOptionPane.INFORMATION_MESSAGE);
                
                keyTextField.setText("");
            }
            else {
                dir.setKey(keyTextField.getText());
            }
        }
    }//GEN-LAST:event_keyTextFieldKeyReleased

    private void keyTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyTextFieldKeyPressed
        if (keyTextField.getText().length() > 64) {
            String tmp = keyTextField.getText().substring(0, 64);
            keyTextField.setText(tmp);
        }
    }//GEN-LAST:event_keyTextFieldKeyPressed

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
            java.util.logging.Logger.getLogger(A5_1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A5_1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A5_1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A5_1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A5_1Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton decBtn;
    private javax.swing.JButton decDstBtn;
    private javax.swing.JTextField decDstDir;
    private javax.swing.JButton decSrcBtn;
    private javax.swing.JTextField decSrcDir;
    private javax.swing.JPanel decriptionPanel;
    private javax.swing.JButton encBtn;
    private javax.swing.JCheckBox encCheckBox;
    private javax.swing.JButton encDstBtn;
    private javax.swing.JTextField encDstDir;
    private javax.swing.JButton encSrcBtn;
    private javax.swing.JTextField encSrcDir;
    private javax.swing.JPanel encriptionPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField keyTextField;
    private javax.swing.JLabel wordsPerGroupLabel;
    // End of variables declaration//GEN-END:variables

    // Getter for checkbox's status (selected or not):
    public boolean isChecked() {
        return encCheckBox.isSelected();
    }
    
    // Setter method for paths from GUI:
    private void fillDirClass() {
        dir.setEncSrc(encSrcDir.getText());
        dir.setEncDst(encDstDir.getText());
        dir.setDecSrc(decSrcDir.getText());
        dir.setDecDst(decDstDir.getText());
    }
    
    // Method used for disabling controls if source & destination folders
    // are not specified, otherwise enable them: 
    private void checkButtons() {
        // Disable 'Encrypt' button and automatic encryption checkbox if source 
        // & destination folders aren't chosen.
        if (encSrcDir.getText().equals("") || encDstDir.getText().equals("")) {
            encBtn.setEnabled(false);
            encCheckBox.setEnabled(false);
        }
        else {
            encBtn.setEnabled(true);
            encCheckBox.setEnabled(true);
        }
        
        // Disable 'Decrypt' button if source & destination folders aren't
        // chosen. 
        if (decSrcDir.getText().equals("") || decDstDir.getText().equals("")) {
            decBtn.setEnabled(false);
        }
        else
            decBtn.setEnabled(true);
    }
    
    // Method used to disable GUI while encrypting/decrypting:
    public void blockGUI(boolean bool) {
        if (bool) {
            encSrcBtn.setEnabled(false);
            encDstBtn.setEnabled(false);
            encBtn.setEnabled(false);
            decSrcBtn.setEnabled(false);
            decDstBtn.setEnabled(false);
            
            decBtn.setEnabled(false);
            encCheckBox.setEnabled(false);
            keyTextField.setEnabled(false);
        }
        else {
            encSrcBtn.setEnabled(true);
            encDstBtn.setEnabled(true);
            decSrcBtn.setEnabled(true);
            decDstBtn.setEnabled(true);
            keyTextField.setEnabled(true);  
            
            if (encSrcDir.getText().isEmpty() || encDstDir.getText().isEmpty()){
                encBtn.setEnabled(false);
                encCheckBox.setEnabled(false);
            }
            else {
                encBtn.setEnabled(true);
                encCheckBox.setEnabled(true);
            }
            
            if (decSrcDir.getText().isEmpty() || decDstDir.getText().isEmpty())
                decBtn.setEnabled(false);
            else
                decBtn.setEnabled(true);
        }
    }
    
    // Method for checking which button was pressed, and doing the necessary:
    @Override
    public void actionPerformed(ActionEvent e) {
        Object sender = e.getSource();
        
        if (sender == encBtn || sender == decBtn) {
            // If 'Encrypt' button was clicked:
            
            try {
                if (sender == encBtn) {
                    
                    if (!keyTextField.getText().isEmpty()) {
                        if (keyTextField.getText().length() != 64) {
                            JOptionPane.showMessageDialog(null,
                        "Please enter array of 64 ones & zeros as a key.", 
                        "You've done goofed!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {
                            String strKey = keyTextField.getText();
                            dir.setKey(strKey);




                            // And source & destination folders are selected:
                            if (!encSrcDir.getText().isEmpty() && 
                                    !encDstDir.getText().isEmpty()) {
                                // Call "Encrypt"'s button method:
                                clickEncBtn();
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Please choose "
                                        + "encription source & destination folders "
                                        + "before retrying to encript files.",
                                        "Folders not specified", 
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                    else
                        if (keyTextField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter "
                                    + "64bit key before trying to encrypt.",
                                        "Folders not specified", 
                                        JOptionPane.INFORMATION_MESSAGE);
                        }
                }

                // If 'Decrypt' button was clicked:
                else {
                    // And source & destination folders are selected:
                    if (!decSrcDir.getText().isEmpty() && 
                            !decDstDir.getText().isEmpty()) {
                        // Call "Decrypt"'s button method:
                        clickDecBtn();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please choose "
                                + "decription source & destination folders "
                                + "before retrying to encript files.",
                                "Folders not specified",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, 
                    "You're trying to enter a NON-NUMERAL value. "
                        + "Please try again using a number.", 
                    "You've done goofed!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else {
            // If one of the 'Choose' buttons has been clicked:
            fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose directory");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);

            if (fileChooser.showOpenDialog(null) == 
                    JFileChooser.APPROVE_OPTION) {
                String path = fileChooser.getSelectedFile().toString();
                // If button for encryption's source folder was clicked:
                if (sender == encSrcBtn) {
                    // Set selected path to the textfield:
                    encSrcDir.setText(path);
                    // Save selected path for later use:
                    dir.setEncSrc(path);
                }
                // If button for encryption's destination folder was clicked:
                else if (sender == encDstBtn) {
                    // Set selected path to the textfield:
                    encDstDir.setText(path);
                    // Save selected path for later use:
                    dir.setEncDst(path);
                    // If source folder for decryption hasn't been chosen yet,
                    // set it to be encryption's destination folder:
                    if (decSrcDir.getText().isEmpty()) {
                        decSrcDir.setText(path);
                        dir.setDecSrc(path);
                    }
                }
                // If button for decryption's source folder was clicked:
                else if (sender == decSrcBtn) {
                    // Set selected path to the textfield:
                    decSrcDir.setText(path);
                    // Save selected path for later use:
                    dir.setDecSrc(path);
                }
                // If button for decryption's destination folder was clicked:
                else if (sender == decDstBtn) {
                    // Set selected path to the textfield:
                    decDstDir.setText(path);
                    // Save selected path for later use:
                    dir.setDecDst(path);
                }
            }
            // In the end, enable button's if necessary:
            checkButtons();
        }
    }
    
    // Method for setting the text on the 'Encrypt' button:
    public void setEncBtnLabel(String txt) {
        encBtn.setText(txt);
    }
    
    // Method for setting the text on the 'Decrypt' button:
    public void setDecBtnLabel(String txt) {
        decBtn.setText(txt);
    }
    
    // Method used by the 'Encrypt' button:
    public void clickEncBtn() {
        try {
            if (!keyTextField.getText().isEmpty()) {
                String tmpKey = keyTextField.getText();
                dir.setKey(tmpKey);
            }
            
            // Get the paths from GUI and store them in 'dir' variable:
            fillDirClass();
            // Read the content of the encryption source folder:
            dir.readAllFromDirectory(dir.getEncSrc(), true);

            // Start new thread so the GUI doesn't block:
            Thread t = new Thread(dir);
            t.start();
        }
        catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, 
                    "You're trying to enter a NON-NUMERAL value. "
                        + "Please try again using a number.", 
                    "You've done goofed!", JOptionPane.INFORMATION_MESSAGE);
            }
    }
    
    // Method used by the 'Decrypt' button:
    public void clickDecBtn() {
        // Get the paths from GUI and store them in 'dir' variable:
        fillDirClass();
        // Read the content of the decryption source folder:
        dir.readAllFromDirectory(dir.getDecSrc(), false);
        
        // Start new thread so the GUI doesn't block:
        Thread t = new Thread(dir);
        t.start();
    }
}
