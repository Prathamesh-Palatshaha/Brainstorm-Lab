/**
 * areaofrect
 */
import java.util.*;
public class areaofrect {

    public static void main(String[] args) {
        // int a,b;
        Scanner input = new Scanner(System.in);
        double area,length,breath;
        System.out.println("Enter lenght and breath: ");
        length = input.nextDouble();
        breath = input.nextDouble();
        area =  length*breath;
        System.out.println("Area of the rectangle is : " + area);  
    }
}