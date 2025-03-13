// Class representing a Customer
class CustomerName {
    private String name;

    public CustomerName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Class representing a Product
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getProductDetails() {
        return name + "(" + price + ")";
    }
}

// Class representing an Order (Aggregation with Products)
class Order {
    private int orderId;
    private Customer customer;
    private Product product1;
    private Product product2;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public void addProduct(Product product) {
        if (product1 == null) {
            product1 = product;
        } else if (product2 == null) {
            product2 = product;
        }
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());

        if (product1 != null) {
            System.out.println(" Product: " + product1.getProductDetails());
        }

        if (product2 != null) {
            System.out.println(" Product: " + product2.getProductDetails());
        }
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Customer customer = new Customer("Yagyata");

        Product product1 = new Product("Laptop", 60000);
        Product product2 = new Product("Smartphone", 30000);

        Order order = new Order(326, customer);
        order.addProduct(product1);
        order.addProduct(product2);

        order.displayOrderDetails();
    }
}

