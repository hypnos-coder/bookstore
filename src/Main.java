import landingPage.landingPageForms;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Here is the beginning of our journey");
        Login loginForm = new Login(null);
        //Authentification authentification = new Authentification();
        //System.out.println(authentification.encription("password"));
        //boolean test = authentification.login("amen","merbelle");
        //String test = authentification.register("hafsa9","hafsabadullahi1@gmail.com","password123","password123", "6123091958","ok lets go");
        //System.out.print(test);
        RegistrationForm registrationForm = new RegistrationForm(null);
        //landingPageForms land = new landingPageForms(null);
        registrationForm.setVisible(true);



    }
}
