package supermarket.products;

public class DairyProduct extends GroceryProduct {
    private Fat fat;

    public DairyProduct(String name, double discount, double price, Fat fat)
    {
        super(name, price, discount);
        this.fat = fat;
    }
    // Getter and Setter for 'SugerLevel'
    public Fat getFat() {
        return fat;
    }

    public void setFat(Fat fat)  {
        this.fat = fat;
    }
    public String display()
    {
        return (super.display()+ "\nFat level: "+ fat);
    }

}
