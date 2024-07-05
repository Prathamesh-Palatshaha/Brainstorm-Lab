import java.util.*;

public class Array {
    public static void main(String[] args) {
        // to declare array we need to used new keyword as it is non primitive datatype
        int[] marks = new int[3];
        marks[0] = 79;
        marks[1] = 38;
        marks[2] = 100;

        System.out.println(marks); // wont output values

        System.out.println(marks[0]);

        //len of array
        System.out.println("length of array: "+ marks.length);

        //sorting array
        Arrays.sort(marks);
        System.out.println(marks[0]);
        
        //2D Array

        int[][] finalmarks = {{99,98} , {100,99}};

        System.out.println("2D array: " + finalmarks[1][1]);
    }
}
