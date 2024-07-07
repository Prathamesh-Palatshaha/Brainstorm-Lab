package supermarket.products;

public class GroceryProduct {
    private String name;
    private double discount;
    private double price;

    public GroceryProduct(String name, double price, double discount )
    {
        this.name = name;
        this.discount = discount;
        this.price = price;
    }
}
