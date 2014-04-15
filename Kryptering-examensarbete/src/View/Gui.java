/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import controller.Controller;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Mikey
 */
public class Gui extends javax.swing.JFrame {

    /**
     * Creates new form Gui
     */
    private Controller controller;

    public Gui() {
        initComponents();
        controller = new Controller();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        input = new javax.swing.JTextField();
        Encrypt = new javax.swing.JButton();
        Decrypt = new javax.swing.JButton();
        CryptoMethod = new javax.swing.JComboBox();
        textOption = new javax.swing.JCheckBox();
        fileOption = new javax.swing.JCheckBox();
        openFileButton = new javax.swing.JButton();
        Progressbar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        output = new javax.swing.JTextField();

        fileChooser.setCurrentDirectory(new java.io.File("C:\\"));

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            input.setText("Enter string to encrypt/decrypt");

            Encrypt.setText("Encrypt");
            Encrypt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    EncryptActionPerformed(evt);
                }
            });

            Decrypt.setText("Decrypt");
            Decrypt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    DecryptActionPerformed(evt);
                }
            });

            CryptoMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AES", "RSA" }));

            textOption.setText("Text");
            textOption.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    textOptionActionPerformed(evt);
                }
            });

            fileOption.setText("File");
            fileOption.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    fileOptionActionPerformed(evt);
                }
            });

            openFileButton.setText("Open file..");
            openFileButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    openFileButtonActionPerformed(evt);
                }
            });

            jLabel1.setText("Progress:");

            output.setText("Output..");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Encrypt)
                            .addGap(18, 18, 18)
                            .addComponent(Decrypt)
                            .addGap(18, 18, 18)
                            .addComponent(CryptoMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(textOption)
                            .addGap(18, 18, 18)
                            .addComponent(fileOption)
                            .addGap(18, 18, 18)
                            .addComponent(openFileButton))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(output, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)))
                    .addContainerGap(47, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Encrypt)
                        .addComponent(Decrypt)
                        .addComponent(CryptoMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textOption)
                        .addComponent(fileOption)
                        .addComponent(openFileButton))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(output, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void openFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileButtonActionPerformed

        int r = fileChooser.showOpenDialog(new JFrame());
        if (r == JFileChooser.APPROVE_OPTION) {
            String name = fileChooser.getSelectedFile().getName();
        }


    }//GEN-LAST:event_openFileButtonActionPerformed

    private void fileOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileOptionActionPerformed
        // TODO add your handling code here:
        if (fileOption.isSelected()) {
            textOption.setSelected(false);
            input.setEnabled(false);
            openFileButton.setEnabled(true);
        }
    }//GEN-LAST:event_fileOptionActionPerformed

    private void textOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textOptionActionPerformed
        // TODO add your handling code here:
        if (textOption.isSelected()) {
            fileOption.setSelected(false);
            openFileButton.setEnabled(false);
            input.setEnabled(true);
        }
    }//GEN-LAST:event_textOptionActionPerformed

    private void EncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptActionPerformed
        Object selected = CryptoMethod.getSelectedItem();
        if (textOption.isSelected()) {
            if (selected.toString().equals("AES")) {
                output.setText(controller.encryptAES(input.getText()));
            } else if (selected.toString().equals("RSA")) {
                output.setText(controller.EncryptRSA(input.getText()));
            }
            Progressbar.setValue(Progressbar.getMaximum());
        } else if (fileOption.isSelected()) {

        } else {
            JOptionPane.showMessageDialog(null, "You must select either textmode or filemode", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_EncryptActionPerformed

    private void DecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptActionPerformed
        // TODO add your handling code here:
        Object selected = CryptoMethod.getSelectedItem();
        if (textOption.isSelected()) {

            if (selected.toString().equals("AES")) {
                output.setText(controller.decryptAES(input.getText()));
            } else if (selected.toString().equals("RSA")) {
                output.setText(controller.decryptRSA(input.getText()));
            }
            Progressbar.setValue(Progressbar.getMaximum());
        } else if (fileOption.isSelected()) {

        } else {
            JOptionPane.showMessageDialog(null, "You must select either textmode or filemode", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_DecryptActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CryptoMethod;
    private javax.swing.JButton Decrypt;
    private javax.swing.JButton Encrypt;
    private javax.swing.JProgressBar Progressbar;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JCheckBox fileOption;
    private javax.swing.JTextField input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton openFileButton;
    private javax.swing.JTextField output;
    private javax.swing.JCheckBox textOption;
    // End of variables declaration//GEN-END:variables
}
