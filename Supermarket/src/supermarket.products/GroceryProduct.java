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

    // Getter and Setter for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for 'discount'
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // Getter and Setter for 'price'
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public double getActualPrice()
    {
        return price - (price*discount/100);
    }

    public String display()
    {
        return (
            "Name: "+ name +"\n" + "Price: "+ price+"\n"+"Discount: "+discount+"%"
        );
    }
}
