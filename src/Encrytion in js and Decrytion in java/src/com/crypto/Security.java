//$Id$
package com.crypto;

import java.security.*;
import java.security.spec.KeySpec;

import javax.crypto.*;
import javax.crypto.spec.*;

import sun.misc.BASE64Decoder;

public class Security {

	/**
     * Hex string to byte array.
     *
     * @param s the s
     * @return the byte[]
     */
    public static byte [] hexStringToByteArray ( String s )
    {
        int len = s.length ();
        byte [] data = new byte[len / 2];
        for ( int i = 0; i < len; i += 2 )
        {
            data[i / 2] = (byte) ( ( Character.digit ( s.charAt ( i ), 16 ) << 4 ) + Character.digit ( s.charAt ( i + 1 ), 16 ) );
        }
        return data;
    }

    
    /**
     * Generate key from password with salt.
     *
     * @param password the password
     * @param saltBytes the salt bytes
     * @return the secret key
     * @throws GeneralSecurityException the general security exception
     */
    public static SecretKey generateKeyFromPasswordWithSalt ( String password, byte [] saltBytes ) throws GeneralSecurityException
    {
        KeySpec keySpec = new PBEKeySpec ( password.toCharArray (), saltBytes, 100, 128 );
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance ( "PBKDF2WITHHMACSHA1" );
        SecretKey secretKey = keyFactory.generateSecret ( keySpec );

        return new SecretKeySpec ( secretKey.getEncoded (), "AES" );
    }

    /**
     * Decrypt aes encrypt with salt and iv.
     *
     * @param encryptedData the encrypted data
     * @param key the key
     * @param salt the salt
     * @param iv the iv
     * @return the string
     * @throws Exception the exception
     */
    public static String decryptAESEncryptWithSaltAndIV ( String encryptedData, String key, String salt, String iv ) throws Exception
    {

        byte [] saltBytes = hexStringToByteArray ( salt );
        byte [] ivBytes = hexStringToByteArray ( iv );
        IvParameterSpec ivParameterSpec = new IvParameterSpec ( ivBytes );
        SecretKeySpec sKey = (SecretKeySpec) generateKeyFromPasswordWithSalt ( key, saltBytes );

        Cipher c = Cipher.getInstance ( "AES/CBC/PKCS5PADDING" );
        c.init ( Cipher.DECRYPT_MODE, sKey, ivParameterSpec );
        byte [] decordedValue = new BASE64Decoder ().decodeBuffer ( encryptedData );
        byte [] decValue = c.doFinal ( decordedValue );
        String decryptedValue = new String ( decValue );

        return decryptedValue;
    }

public static String generateSecret (  ) 
{
    return "1234455553dsfdfdsfdsf";   //generate always random number and send for each request
}
}
