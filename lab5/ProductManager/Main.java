package ProductManager;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Electronics("asus laptop", 12000.0, 10);
        Product p2 = new Clothing("Shirt", 100.00, 1000);
        Product p3 = new Furniture("Table", 300.0, 50);
        Product p4 = new Electronics("asus monitor", 10000.0, 5);

        OrderManager orderManager = new OrderManager();

        orderManager.addProduct(p1);
        orderManager.addProduct(p2);
        orderManager.addProduct(p3);
        orderManager.addProduct(p4);

        orderManager.sortProducts();
        orderManager.printProducts();
    }
}