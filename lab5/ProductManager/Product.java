package ProductManager;

public abstract class Product {

    protected String name;
    protected double unitPrice;
    protected int quantity;

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product(String name, double unitPrice, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public abstract double getTaxRate();

    public double getTotalPrice() {
        return (unitPrice + (unitPrice * getTaxRate()));
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", unitPrice=" + unitPrice + ", quantity=" + quantity + "]";
    }
}
