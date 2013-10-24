package org.fosls.db;

/**
 *
 * @author jesus
 */

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Formatter;

public class Hash{    

    public final static String MD5 = "MD5";
    public final static String SHA1 = "SHA1";
    public final static String SHA256 = "SHA256";
    public final static String SHA512 = "SHA512";
    
    public static String createFromFile(String strAlgorithm,
            String fileName) throws Exception{
        
        MessageDigest algorithm = MessageDigest.getInstance(strAlgorithm);
        
        FileInputStream     fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        DigestInputStream   dis = new DigestInputStream(bis, algorithm);

        // read the file and update the hash calculation
        while (dis.read() != -1);
        
        // get the hash value as byte array
        byte[] hash = algorithm.digest();

        return byteArray2Hex(hash);
    }
    
    public static String createFromString(String strAlgorithm,
            String text) throws Exception{
        
        MessageDigest algorithm = MessageDigest.getInstance(strAlgorithm);
        
        byte[] array = algorithm.digest(text.getBytes());
        
        return byteArray2Hex(array);
    }
        
    private static String byteArray2Hex(byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    /*
    public static void main(String[] args) throws Exception {
        String fileName = "javablogging.png";

        MessageDigest sha1 = MessageDigest.getInstance("SHA1");
        MessageDigest md5  = MessageDigest.getInstance("MD5");        

        System.out.println(calculateHash(sha1, fileName));
        System.out.println(calculateHash(md5, fileName));
    }
    */
}
