import Controller.CustomerController;
import Controller.MenuItemController;
import io.javalin.Javalin;

public class Application {
    public static void main(String[] args) {

        Javalin app = Javalin.create().start(8080);

        new CustomerController(app).customerEndpoint();
        MenuItemController menuItemController = new MenuItemController();

        menuItemController.menuItemEndpoint(app);
    }
}
