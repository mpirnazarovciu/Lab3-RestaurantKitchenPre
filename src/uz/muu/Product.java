package uz.muu;

public class Product {
    private String productName;
    private double amount;

    public Product(String productName, double amount) {
        this.productName = productName;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
