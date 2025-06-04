import java.util.Scanner;

public class Basic {
public static void main(String[] args) {
    /*
    Comparison Operators
    ==
    >
    <
    >=
    <=

    */
    System.out.println(" Comparison Operators: ");
    boolean isDay = false;
    if (isDay) System.out.println("Day");
    else System.out.println("Night");

    int age = 30;

    if (age > 18) System.out.println("Eligible to vote!");
    else System.out.println("Sorry.");

    //Logical Operators
    System.out.println("Logical Operators: ");
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter cash: ");
    int cash = sc.nextInt();

    // pen = 10 and nb = 30

    if (cash < 10)
    {
        System.out.println("Cannot buy anything.");
        System.out.println("Bring more cash");
    }

    else if (cash <40  && cash > 10){
        System.out.println("Can buy 1 thing ");
    }

    else
    {
        System.out.println("Can buy any one or both");
    }


    // swtich statement
    System.out.println("SWITCH: ");
    int day = 1;
    // 1 - monday 2 - tues

    switch (day) {
        case 1:
            System.out.println("Monday");
            break;
        case 2:
        System.out.println("tuesday");
        break;
        default:
            break;
    }

}
}
