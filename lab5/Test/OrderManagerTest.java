package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import ProductManager.*;

class OrderManagerTest {
    private OrderManager orderManager;

    @BeforeEach
    public void setUp() {
        orderManager = new OrderManager();
    }

    @Test
    public void testAddProduct() {
        Product p = new Electronics("laptop", 1000.0, 10);
        orderManager.addProduct(p);
        assertEquals(1, orderManager.getProducts().size());
    }

    @Test
    public void testSortByPrice() {
        Product p1 = new Electronics("laptop", 1000.0, 10);
        Product p2 = new Clothing("Shirt", 20.0, 100);

        orderManager.addProduct(p1);
        orderManager.addProduct(p2);

        orderManager.sortProducts();
        ArrayList<Product> sortedProducts = orderManager.getProducts();

        assertEquals(p2, sortedProducts.get(0));
        assertEquals(p1, sortedProducts.get(1));
    }

    @Test
    public void testSortByNameWhenPriceEqual() {
        Product p1 = new Electronics("asus laptop", 1000.0, 10);
        Product p2 = new Electronics("dell laptop", 1000.0, 10);

        orderManager.addProduct(p1);
        orderManager.addProduct(p2);

        orderManager.sortProducts();
        ArrayList<Product> sortedProducts = orderManager.getProducts();

        assertEquals(p1, sortedProducts.get(0));
        assertEquals(p2, sortedProducts.get(1));
    }

    @Test
    public void testSortByQuantityWhenNameAndPriceEqual() {
        Product p1 = new Electronics("asus laptop", 1000.0, 10);
        Product p2 = new Electronics("asus laptop", 1000.0, 5);

        orderManager.addProduct(p1);
        orderManager.addProduct(p2);

        orderManager.sortProducts();
        ArrayList<Product> sortedProducts = orderManager.getProducts();

        assertEquals(p2, sortedProducts.get(0));
        assertEquals(p1, sortedProducts.get(1));
    }


    @Test
    public void testSortByMixedCriteria(){
        Product p1 = new Electronics("smartphone", 500.0, 5);
        Product p2 = new Electronics("smartwatch", 500.0, 10);
        Product p3 = new Clothing("Jacket", 100.0, 50);

        orderManager.addProduct(p1);
        orderManager.addProduct(p2);
        orderManager.addProduct(p3);

        orderManager.sortProducts();
        ArrayList<Product> sortedProducts = orderManager.getProducts();

        assertEquals(p3, sortedProducts.get(0));
        assertEquals(p1, sortedProducts.get(1));
        assertEquals(p2, sortedProducts.get(2));

    }

    @Test
    public void testSortWhenNothingSimilar(){
        Product p1 = new Electronics("asus laptop", 10000.0, 10);
        Product p2 = new Clothing("Shirt", 100.00, 1000);
        Product p3 = new Furniture("Table", 300.0, 50);

        orderManager.addProduct(p1);
        orderManager.addProduct(p2);
        orderManager.addProduct(p3);

        orderManager.sortProducts();
        ArrayList<Product> sortedProducts = orderManager.getProducts();

        assertEquals(p2, sortedProducts.get(0));
        assertEquals(p3, sortedProducts.get(1));
        assertEquals(p1, sortedProducts.get(2));
    }

    @Test
    public void testEmptyProduct(){
        orderManager.sortProducts();
        assertEquals(0, orderManager.getProducts().size());
    }


    @Test
    public void testTotalPriceForElectronics() {
        Product p1 = new Electronics("asus laptop", 1000.0, 10);
        assertEquals(1150, p1.getTotalPrice());
    }

    @Test
    public void testTotalPriceForClothing() {
        Product p1 = new Clothing("shirt", 100.0, 10);
        assertEquals(110, p1.getTotalPrice());
    }

    @Test
    public void testTotalPriceForFurniture() {
        Product p1 = new Furniture("Small chair", 100.0, 10);
        assertEquals(108, p1.getTotalPrice());
    }



}