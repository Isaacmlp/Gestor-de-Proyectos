import Controller.Controller_Login;
import View.Login;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        Controller_Login controller = new Controller_Login(login);
        controller.start_login();
    }
}
