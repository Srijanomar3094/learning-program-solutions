package EcommercePlatformSearchFunction;

public class Product implements Comparable<Product> {
    public int productId;
    public String productName;
    public String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }

    @Override
    public String toString() {
        return "[" + productId + ", " + productName + ", " + category + "]";
    }
}
