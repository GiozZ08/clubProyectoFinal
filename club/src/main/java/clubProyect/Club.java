package clubProyect;

import clubProyect.config.MySQLConnection;
import clubProyect.controller.ControllerInterface;
import clubProyect.controller.LoginController;

public class Club {
    public static void main(String[] args) {
        ControllerInterface controller = new LoginController();
        try {
            controller.session();
            MySQLConnection.getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}