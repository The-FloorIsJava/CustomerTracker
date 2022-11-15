import Controller.CustomerController;
import Controller.MenuItemController;
import io.javalin.Javalin;

public class Application {
    public static void main(String[] args) {

        Javalin app = Javalin.create().start(8080);

        CustomerController customerController = new CustomerController();
        customerController.customerEndpoint(app);

        MenuItemController menuItemController = new MenuItemController();
        menuItemController.menuItemEndpoint(app);
    }
}
