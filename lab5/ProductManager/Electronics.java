package ProductManager;

public class Electronics extends Product {
    private final double taxRate = 0.15;

    private String name;
    private double unitPrice;
    private int quantity;

    public Electronics(String name, double unitPrice, int quantity) {
        super(name, unitPrice, quantity);
    }

    @Override
    public double getTaxRate() {
        return 0.15;
    }
}
