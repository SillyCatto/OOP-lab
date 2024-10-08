package ProductManager;

public class Furniture extends Product {
    private final double taxRate = 0.08;

    private String name;
    private double unitPrice;
    private int quantity;

    public Furniture(String name, double unitPrice, int quantity) {
        super(name, unitPrice, quantity);
    }

    @Override
    public double getTaxRate() {
        return 0.08;
    }
}
