package ProductManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrderManager {

    private final ArrayList<Product> products;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public OrderManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void sortProducts() {
        Collections.sort(products, new Comparator<Product>() {

            @Override
            public int compare(Product p1, Product p2) {
                int priceCompare = Double.compare(p1.getTotalPrice(), p2.getTotalPrice());
                if (priceCompare != 0) {
                    return priceCompare;
                }

                int nameCompare = p1.getName().compareToIgnoreCase(p2.getName());
                if (nameCompare != 0) {
                    return nameCompare;
                }
                return Integer.compare(p1.getQuantity(), p2.getQuantity());
            }
        });
    }

    public void printProducts() {
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
