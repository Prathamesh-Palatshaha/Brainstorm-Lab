import java.util.*;

/**
 * MiniProject
 */
public class MiniProject {
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Guess The Number Game");
        
        Random rand = new Random();
        int number = rand.nextInt(0,101);
        // System.out.println(number);
        while (true) {
            System.out.print("Enter -1 to exit else keep guessing: ");
            int guess = input.nextInt();
            if (guess == -1) {
                System.out.println("Exiting...");
                break;  
            }
            else if (guess > number)
            {
                System.out.println("Number is lesser than guessed value.");
            }
            else if (guess < number)
            {
                System.out.println("Number is greater than guessed value.");
            }
            else
            {
                System.out.println("You Won!!!");
                System.out.println("To play again type 1\n Else 0 to exit");
                if (input.nextInt() == 1) {
                    number = rand.nextInt(0,101);   
                }
                else break;
                
            }              
        }
    }
    
}


