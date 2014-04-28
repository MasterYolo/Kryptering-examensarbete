/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

/**
 *
 * @author Mikey
 */
public class Filehandler {

    public int buffersize = 512; //Change this variable to change the buffersize.
    public String readFileAsString(String filePath) throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }
    
    public String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }

        return stringBuilder.toString();
    }
    public void RSAwriteToFile(String filename,String content)
    {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write(content);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Filehandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String ReadFromFileAES(File inputFile, File outputFile, Cipher cipher) throws FileNotFoundException, IOException {
        String decryptedString = "";
        FileOutputStream fos = null;
        CipherInputStream cis = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(inputFile);
            cis = new CipherInputStream(fis, cipher);
            fos = new FileOutputStream(outputFile);
            byte[] data = new byte[buffersize];
            int read = cis.read(data);
            while (read != -1) {
                fos.write(data, 0, read);
                read = cis.read(data);
                decryptedString = new String(data, "UTF-8").trim();
            }
        } finally {
            if (fos != null) {
                fos.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return decryptedString;
    }

    public void WriteToFileAES(File inputFile, File outputFile, Cipher cipher) throws FileNotFoundException, IOException {
        FileOutputStream fos = null;
        CipherOutputStream cos = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream(outputFile);
            cos = new CipherOutputStream(fos, cipher);
            byte[] data = new byte[buffersize];
            int read = fis.read(data);
            while (read != -1) {
                cos.write(data, 0, read);
                read = fis.read(data);
                //System.out.println(new String(data, "UTF-8").trim());
            }
            cos.flush();
        } finally {
            if (cos != null) {
                cos.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
    }
}
