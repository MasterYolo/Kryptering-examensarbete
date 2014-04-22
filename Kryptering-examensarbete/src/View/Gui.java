/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import controller.Controller;
import filehandler.Filehandler;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.RSAclass;

/**
 *
 * @author Mikey
 */
public class Gui extends javax.swing.JFrame {

    /**
     * Creates new form Gui
     */
    private Controller controller;
    private String fileName;

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
        timerField = new javax.swing.JTextField();
        eventOutput = new java.awt.TextArea();

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

            timerField.setEditable(false);
            timerField.setText("Time flies..");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                        .addComponent(timerField)
                        .addComponent(input, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                        .addComponent(eventOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(timerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(eventOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private void openFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileButtonActionPerformed

        int r = fileChooser.showOpenDialog(new JFrame());
        if (r == JFileChooser.APPROVE_OPTION) {
            setFileName(fileChooser.getSelectedFile().getAbsolutePath());
        }


    }//GEN-LAST:event_openFileButtonActionPerformed

    private void fileOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileOptionActionPerformed
        // TODO add your handling code here:
        if (fileOption.isSelected()) {
            textOption.setSelected(false);
            input.setEnabled(false);
            openFileButton.setEnabled(true);
            timerField.setEditable(false);
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
        Progressbar.setValue(Progressbar.getMinimum());
        Object selected = CryptoMethod.getSelectedItem();
        if (textOption.isSelected()) {

            if (selected.toString().equals("AES")) {
                eventOutput.setText(controller.encryptAES(input.getText()));
                timerField.setText(controller.getTime());
            } else if (selected.toString().equals("RSA")) {
                eventOutput.setText(controller.EncryptRSA(input.getText()));
                timerField.setText(controller.getTime());
            }
            Progressbar.setValue(Progressbar.getMaximum());
        } else if (fileOption.isSelected()) {
            if (getFileName() != null) {
                if (selected.toString().equals("AES")) {
                    eventOutput.setText(controller.encryptAESToFile(getFileName()));
                    timerField.setText(controller.getTime());
                    //System.out.println(getFileName());
                } else if (selected.toString().equals("RSA")) {
                    eventOutput.setText(controller.EncryptRSAFromFile(getFileName()));
                    timerField.setText(controller.getTime());
                    //System.out.println(getFileName());
                }
                Progressbar.setValue(Progressbar.getMaximum());
            } else {
                JOptionPane.showMessageDialog(null, "You must select a file!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "You must select either textmode or filemode", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_EncryptActionPerformed

    private void DecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptActionPerformed

        Object selected = CryptoMethod.getSelectedItem();
        if (textOption.isSelected()) {
            Progressbar.setValue(Progressbar.getMinimum());
            if (selected.toString().equals("AES")) {
                eventOutput.setText(controller.decryptAES(input.getText()));
                timerField.setText(controller.getTime());
            } else if (selected.toString().equals("RSA")) {
                eventOutput.setText(controller.decryptRSA(input.getText()));
            }
            Progressbar.setValue(Progressbar.getMaximum());
        } else if (fileOption.isSelected()) {
            Progressbar.setValue(Progressbar.getMinimum());
            if (selected.toString().equals("AES")) {
                eventOutput.setText(controller.decryptAESFromFile(getFileName()));
                timerField.setText(controller.getTime());
                //System.out.println(getFileName());
            } else if (selected.toString().equals("RSA")) {
                eventOutput.setText(controller.decryptRSAFromFile(getFileName()));
                //System.out.println(getFileName());
            }
            Progressbar.setValue(Progressbar.getMaximum());
        } else {
            JOptionPane.showMessageDialog(null, "You must select either textmode or filemode", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_DecryptActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CryptoMethod;
    private javax.swing.JButton Decrypt;
    private javax.swing.JButton Encrypt;
    private javax.swing.JProgressBar Progressbar;
    private java.awt.TextArea eventOutput;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JCheckBox fileOption;
    private javax.swing.JTextField input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton openFileButton;
    private javax.swing.JCheckBox textOption;
    private javax.swing.JTextField timerField;
    // End of variables declaration//GEN-END:variables
}
