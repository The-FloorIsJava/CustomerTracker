import Controller.CustomerController;

public class Application {
    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        customerController.startAPI();
    }
}
