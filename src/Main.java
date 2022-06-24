import landingPage.landingPageForms;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws Exception {
       splash s = new splash();

        File credential = new File("usercredential.txt");
        if (credential.exists()){
            landingPageForms landingPageForms = new landingPageForms(null);
            landingPageForms.setVisible(true);
        }
        else {
            Login login = new Login(null);
        }
//        Authentification authentification = new Authentification();
//        String input = "baeldung";
//
//        String cipherText = authentification.encrypt(input,"scdp");
//        String plainText = authentification.decrypt(cipherText,"scdp");
//
//        System.out.println(cipherText);
//        System.out.println(plainText);
        //SplashPage splashPage = new SplashPage();





    }
}
