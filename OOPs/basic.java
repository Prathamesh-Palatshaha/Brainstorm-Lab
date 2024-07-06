package OOPs;
class Pen
{
    String color;
    String type;

    public void writing()
    {
        System.out.println("writing...");
    }

    public void printColor()
    {
        System.out.println(this.color);
    }
}
public class basic {

    public static void main(String[] args) {
        Pen pen1 = new Pen();
        Pen pen2 = new Pen();

        pen1.color = "blue";
        pen1.type = "ball";

        pen2.color = "red";
        pen2.type = "ink";

        // calling color fn of penx

        pen1.printColor();
        pen2.printColor();
    }

}
