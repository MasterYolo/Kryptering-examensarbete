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
    public long starttime, endtime, time;
    private Filehandler filehandler = new Filehandler();

    public String getTime() {
        String s = String.valueOf(time);
        return "Time To Encrypt: " + s + " Milliseconds";
    }

    public String EncryptRSA(String originalText) {
       if (!areKeysPresent()) {
        // Method generates a pair of keys using the RSA algorithm and stores it
        // in their respective files
        rsas.generateKey();
      }
        starttime = System.currentTimeMillis();
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
        endtime = System.currentTimeMillis();
        time = (endtime - starttime);

        return encrytedtext;
    }

    public String EncryptRSAFromFile(String FileName) {
          if (!areKeysPresent()) {
        // Method generates a pair of keys using the RSA algorithm and stores it
        // in their respective files
        rsas.generateKey();
      }
        starttime = System.currentTimeMillis();
        String encryptedtext = "";
        String newfile = FileName + ".RSA";
        try {
            ObjectInputStream inputStream = null;

            // Encrypt the string using the public key
            inputStream = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));
            final PublicKey publicKey = (PublicKey) inputStream.readObject();
            encryptedtext = rsas.encrypt(filehandler.readFile(FileName), publicKey);
            filehandler.RSAwriteToFile(newfile, encryptedtext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        endtime = System.currentTimeMillis();
        time = (endtime - starttime);
        return "File : " + FileName + " was successfully encrypted and saved into " + newfile;
    }

    public String decryptRSA(String text) {
          if (!areKeysPresent()) {
        // Method generates a pair of keys using the RSA algorithm and stores it
        // in their respective files
        rsas.generateKey();
      }

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

    public String decryptRSAFromFile(String FileName) {
          if (!areKeysPresent()) {
        // Method generates a pair of keys using the RSA algorithm and stores it
        // in their respective files
        rsas.generateKey();
      }
        starttime = System.currentTimeMillis();
        String plainText = "";
        String newfile = FileName + ".txt";
        try {
            ObjectInputStream inputStream = null;

            // Decrypt the cipher text using the private key.
            inputStream = new ObjectInputStream(new FileInputStream(PRIVATE_KEY_FILE));
            final PrivateKey privateKey = (PrivateKey) inputStream.readObject();
            plainText = rsas.decrypt(filehandler.readFileAsString(FileName), privateKey);
            filehandler.RSAwriteToFile(newfile, plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        endtime = System.currentTimeMillis();
        time = (endtime - starttime);
        return "File : " + FileName + " was successfully encrypted and saved into " + newfile;
    }

    public String encryptAES(String plainText) {
        starttime = System.currentTimeMillis();
        String encrypt = "";
        try {
            encrypt = aes.encrypt(plainText);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        endtime = System.currentTimeMillis();
        time = (endtime - starttime);
        return encrypt;
    }

    public String encryptAESToFile(String inputFileName) {
        starttime = System.currentTimeMillis();
        String outFileName = inputFileName + ".aes";
        String encrypt = "";
        try {
            Cipher cipher = aes.getEncryptedCipher();
            filehandler.WriteToFileAES(new File(inputFileName), new File(outFileName), cipher);
            encrypt = "File : " + outFileName + " was successfully encrypted!";
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        endtime = System.currentTimeMillis();
        time = (endtime - starttime);
        return encrypt;
    }

    public String decryptAESFromFile(String inputFileName) {
        starttime = System.currentTimeMillis();
        String decrypt = "";
        String outFileName = inputFileName + ".txt";
        try {
            Cipher cipher = aes.getDecryptedCipher();
            decrypt = filehandler.ReadFromFileAES(new File(inputFileName), new File(outFileName), cipher);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        endtime = System.currentTimeMillis();
        time = (endtime - starttime);
        return "File : " + inputFileName + " are successfully decrypted and saved into : " + outFileName;
    }

    public String decryptAES(String encryptedText) {
        starttime = System.currentTimeMillis();
        String decrypt = "";
        try {
            decrypt = aes.decrypt(encryptedText);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        endtime = System.currentTimeMillis();
        time = (endtime - starttime);
        return decrypt;
    }
}
