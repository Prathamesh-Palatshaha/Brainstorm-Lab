public class Loops {
public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
        System.out.print(i+" ");
    }
    System.out.println(" ");
    for (int i =10; i >=0; i--) {
        System.out.print(i+" ");
    }
    System.out.println(" ");

    //using while loop
    int i =10;
    while (i >=0)
    {
        System.out.print(i + " ");
        i--;
    }

    //do while loop

    int k = 10;
    System.out.println(" ");
    do {
        System.out.print(k + " ");
        k--;
    } while (k>=1);


    //break and continue statment usage
    int j = 0;
    while (true) {
        if (j == 3)
        {
            j++;
            continue;
        }

        System.out.print(j+ " ");
        j++;

        if (j == 5) break;
        
    }
}
}
