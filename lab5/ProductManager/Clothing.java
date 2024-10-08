package ProductManager;

public class Clothing extends Product {
    private final double taxRate = 0.10;

    private String name;
    private double unitPrice;
    private int quantity;

    public Clothing(String name, double unitPrice, int quantity) {
        super(name, unitPrice, quantity);
    }

    @Override
    public double getTaxRate() {
        return 0.10;
    }
}
