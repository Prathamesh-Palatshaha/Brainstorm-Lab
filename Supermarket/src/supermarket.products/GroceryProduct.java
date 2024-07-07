package supermarket.products;
import java.util.*;
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

    public static void main(String[] args) {
        ArrayList <GroceryProduct> cart = new ArrayList<GroceryProduct>();
        GroceryProduct toast = new GroceryProduct("Toast", 100, 10);
        cart.add(toast);
        System.out.println("Price post discount: "+ toast.getActualPrice());

        Beverage coke = new Beverage("Coke", 0, 60,SugarLevel.ADDED_SUGAR);

        cart.add(coke);
        System.out.println("Price post discount: "+ coke.getActualPrice());
        DairyProduct milk = new DairyProduct("Milk", 0, 72, Fat.FULLCREAM);

        cart.add(milk);
        System.out.println("Price post discount: "+ milk.getActualPrice());
        double totalPrice = 0;

        for (int i = 0; i < cart.size(); i++) {
            totalPrice += cart.get(i).getActualPrice();
        }

        System.out.println("Total Price of the cart is: "+ totalPrice);

    }
}
