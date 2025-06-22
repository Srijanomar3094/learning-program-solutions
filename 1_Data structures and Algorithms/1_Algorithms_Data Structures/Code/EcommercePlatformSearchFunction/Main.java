package EcommercePlatformSearchFunction;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Smartphone", "Electronics"),
            new Product(203, "Laptop", "Electronics"),
            new Product(302, "Shoes", "Fashion"),
            new Product(410, "Book", "Education"),
            new Product(501, "Watch", "Accessories")
        };

        int targetId = 302;

        int index = SearchAlgorithms.linearSearch(products, targetId);
        if (index != -1)
            System.out.println("Linear Search: Found " + products[index]);
        else
            System.out.println("Linear Search: Product not found");

        SearchAlgorithms.sortProducts(products);
        index = SearchAlgorithms.binarySearch(products, targetId);
        if (index != -1)
            System.out.println("Binary Search: Found " + products[index]);
        else
            System.out.println("Binary Search: Product not found");
    }
}
