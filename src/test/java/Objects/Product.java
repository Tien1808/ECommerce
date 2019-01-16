package Objects;

public class Product {
    // Ở đây sẽ được thêm thuộc tính hình ảnh sau.
    private String name;
    private double discount = 0.0;
    private int amount = 0;
    private double unitPrice = 0.0;
    private double subTotal = 0.0;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, double discount, int amount, double unitPrice, double subTotal) {
        this.name = name;
        this.discount = discount;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.subTotal = subTotal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getName() {
        return name;
    }

    public double getDiscount() {
        return discount;
    }

    public int getAmount() {
        return amount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getSubTotal() {
        return subTotal;
    }
}
