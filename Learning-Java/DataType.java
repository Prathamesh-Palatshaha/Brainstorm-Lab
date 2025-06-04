import java.util.*;

/**
 * DataType
 */
public class DataType {

     public static void main(String[] args) {
          // Primitive type

          /*

          Primitive data types are the base-level data structures used in programming languages. Examples of primitive types include integers, floats, booleans, and strings. Primitive data types can only store a single value at a time.

          -fixed size

          byte - 1
          short - 2
          int - 4
          long - 8
          float - 4
          double - 8
          char - 2
          boolean - true/false
          */

          byte age = 10;
          int phone = 1234567890;
          long phone2 = 12345678900L; // L is used to 
          float pi = 3.14F;
          char letter = '@'; // a-zA-z sp chars
          boolean isAdult = false;


          // Non - Primitive types
          /*
          
          Non-primitive data types, on the other hand, are derived from existing primitive types and consist of complex data structures. Examples of non-primitive data types include arrays and objects. These data types can store multiple values at once and provide a layer of abstraction from the underlying logic used to store those values.
          
          -new keyword is used to declare non prim type
          -variable size
          */
          String name = "Naruto";
          System.out.println(name.length());

     }
}