package Model;

/**
 * a model class that represents Model.Customer.
 */
public class Customer {
    public String name;
    public double cash;
    public Customer(String name, double cash){
        this.name = name;
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "Model.Customer{" +
                "name='" + name + '\'' +
                ", cash=" + cash +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
