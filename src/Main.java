import landingPage.landingPageForms;

import java.io.File;


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





    }
}
