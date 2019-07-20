import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class Main {

    public static void main(String[] args) throws Exception{
//        Cipher c = Cipher.getInstance("");
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(4096); // key size specified here.
        KeyPair pair = keyGen.generateKeyPair();
        for(int i=0;i<pair.getPrivate().getEncoded().length;i++){
            System.out.print(pair.getPrivate().getEncoded()[i]);
        }
        System.out.println("\nPublic Key : " +  "\n" +pair.getPublic());
    }
}
