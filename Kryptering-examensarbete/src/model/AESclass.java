package model;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

import sun.misc.*;

/**
 *
 * @author Mikey
 */
public class AESclass {

    private static String algorithm = "AES/CTR/NoPadding";
    private static byte[] keyValue = new byte[]{'A', 'S', 'e', 'c', 'u', 'r', 'e', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y',};
    
    private byte[] ivBytes = new byte[]{0x00, 0x01, 0x02, 0x03, 0x00, 0x01, 0x02, 0x03, 0x00, 0x00, 0x00,
        0x00, 0x00, 0x00, 0x00, 0x01}; 
    private static SecretKeySpec secretKey;
    private IvParameterSpec ivSpec;
    
    private static byte[] key;

    public AESclass() {
        ivSpec = new IvParameterSpec(ivBytes);
    }
    
    // Performs Encryption
    public String encrypt(String plainText) throws Exception {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Key key = generateKey();
        Cipher chiper = Cipher.getInstance(algorithm, "BC");
        chiper.init(Cipher.ENCRYPT_MODE, key, ivSpec);
        byte[] encVal = chiper.doFinal(plainText.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    public Cipher getEncryptedCipher() throws Exception {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
        return cipher;
    }

    // Performs decryption
    public String decrypt(String encryptedText) throws Exception {
        // generate key 
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Key key = generateKey();
        Cipher chiper = Cipher.getInstance(algorithm, "BC");
        chiper.init(Cipher.DECRYPT_MODE, key, ivSpec);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedText);
        byte[] decValue = chiper.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    public Cipher getDecryptedCipher() throws Exception {
        Key key = generateKey();
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(algorithm, "BC");
        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
        return cipher;
    }

    //generateKey() is used to generate a secret key for AES algorithm
    private Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, algorithm);
        return key;
    }

}
