package supermarket.products;

public class Beverage extends GroceryProduct{
    private SugerLevel sugerLevel;

    public Beverage(String name, double discount, double price, SugerLevel sugerLevel)
    {
        super(name, price, discount);
        this.sugerLevel = sugerLevel;
    }
}
