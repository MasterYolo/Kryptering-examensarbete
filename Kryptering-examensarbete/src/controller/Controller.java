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
import model.RSAclass;
import static model.RSAclass.PRIVATE_KEY_FILE;
import static model.RSAclass.PUBLIC_KEY_FILE;
import static model.RSAclass.areKeysPresent;
import static model.RSAclass.decrypt;
import static model.RSAclass.encrypt;
import static model.RSAclass.generateKey;

/**
 *
 * @author Mikey
 */
public class Controller 
{
    RSAclass rsa;
    public void EncryptRSA()
    {

    try {

      // Check if the pair of keys are present else generate those.
      if (!areKeysPresent()) {
        // Method generates a pair of keys using the RSA algorithm and stores it
        // in their respective files
        generateKey();
      }
      
      final String originalText="";
      ObjectInputStream inputStream = null;

      // Encrypt the string using the public key
      inputStream = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));
      final PublicKey publicKey = (PublicKey) inputStream.readObject();
      final byte[] cipherText = rsa.encrypt(originalText, publicKey);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
    public void decryptRSA()
    {
         

    try {

      // Check if the pair of keys are present else generate those..
      if (!areKeysPresent()) {
        // Method generates a pair of keys using the RSA algorithm and stores it
        // in their respective files
        generateKey();
      }

      byte[] cipherText={};
      ObjectInputStream inputStream = null;

      // Decrypt the cipher text using the private key.
      inputStream = new ObjectInputStream(new FileInputStream(PRIVATE_KEY_FILE));
      final PrivateKey privateKey = (PrivateKey) inputStream.readObject();
      final String plainText = rsa.decrypt(cipherText, privateKey);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }
    
}

