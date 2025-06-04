import java.util.*;

public class Operators {

public static void main(String[] args) {
    int a,b;
    a = 10;
    b = 4;
    int add = a+b;
    int sub = a-b;
    int mul = a * b;
    int div =  a/b;
    int rem = a%b;
    System.out.println("Add: "+ add);
    System.out.println("Mul: "+ mul);
    System.out.println("Divide: "+ div);
    System.out.println("Rem: "+ rem);
    System.out.println("Subtract : "+ sub);


    //uniary operator ++ or --

    int num = 1;
    // num++; //equals num = num + 1
    System.out.println(num++); // first execute then add 1
    System.out.println(num);

    int num2 = 1;
    System.out.println(++ num2); // first add then execute
}
}
