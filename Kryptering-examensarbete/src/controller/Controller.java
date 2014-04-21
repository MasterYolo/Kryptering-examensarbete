/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import filehandler.Filehandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import model.AESclass;
import model.RSAclass;
import static model.RSAclass.PRIVATE_KEY_FILE;
import static model.RSAclass.PUBLIC_KEY_FILE;
import static model.RSAclass.areKeysPresent;

/**
 *
 * @author Mikey
 */
public class Controller {

    private RSAclass rsas = new RSAclass();
    private AESclass aes = new AESclass();

    private Filehandler filehandler = new Filehandler();

    public String EncryptRSA(String originalText) {
        String encrytedtext = "";
        try {
            ObjectInputStream inputStream = null;

            // Encrypt the string using the public key
            inputStream = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));
            final PublicKey publicKey = (PublicKey) inputStream.readObject();
            encrytedtext = rsas.encrypt(originalText, publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrytedtext;
    }

    public String decryptRSA(String text) {

        String plainText = "";
        try {
            ObjectInputStream inputStream = null;

            // Decrypt the cipher text using the private key.
            inputStream = new ObjectInputStream(new FileInputStream(PRIVATE_KEY_FILE));
            final PrivateKey privateKey = (PrivateKey) inputStream.readObject();
            plainText = rsas.decrypt(text, privateKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return plainText;
    }

    public String encryptAES(String plainText) {

        String encrypt = "";
        try {
            encrypt = aes.encrypt(plainText);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encrypt;
    }

    public String encryptAESToFile(String inputFileName) {

        String outFileName = inputFileName + ".aes";
        String encrypt = "";
        try {
            Cipher cipher = aes.getEncryptedCipher();
            filehandler.WriteToFileAES(new File(inputFileName), new File(outFileName), cipher);
            encrypt = "File : " + outFileName + " are successfully encrypted!";
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encrypt;
    }

    public String decryptAESFromFile(String inputFileName) {
        String decrypt = "";
        String outFileName = inputFileName + ".aes";
        try {
            Cipher cipher = aes.getDecryptedCipher();
            decrypt = filehandler.ReadFromFileAES(new File(inputFileName), new File(outFileName), cipher);
            //decrypt = aes.decrypt(encryptedText);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return decrypt;
    }

    public String decryptAES(String encryptedText) {
        String decrypt = "";
        try {
            decrypt = aes.decrypt(encryptedText);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return decrypt;
    }
}
