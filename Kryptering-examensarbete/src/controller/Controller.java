/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.RSAclass;
import static model.RSAclass.PRIVATE_KEY_FILE;
import static model.RSAclass.PUBLIC_KEY_FILE;
import static model.RSAclass.areKeysPresent;

import model.AESclass;

/**
 *
 * @author Mikey
 */
public class Controller {

    private RSAclass rsas = new RSAclass();
    private AESclass aes = new AESclass();

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
