package supermarket.products;

public class DairyProduct extends GroceryProduct {
    private Fat fat;

    public DairyProduct(String name, double discount, double price, Fat fat)
    {
        super(name, price, discount);
        this.fat = fat;
    }
    
}
