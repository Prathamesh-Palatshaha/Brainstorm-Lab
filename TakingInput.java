import java.nio.channels.ScatteringByteChannel;
import java.util.*;

public class TakingInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input your age: ");
        int age = sc.nextInt();
        System.out.println(age);

        // strings

        System.out.print("Input your name:");
        // accept only tokens
        String name = sc.next();
        System.out.println(name); 

        String namee = sc.nextLine();
        System.out.println(namee);

    }
}
