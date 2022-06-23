import landingPage.landingPageForms;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        File credential = new File("usercredential.txt");
        if (credential.exists()){
            landingPageForms landingPageForms = new landingPageForms(null);
        }
        else {
            Login login = new Login(null);
        }





    }
}
