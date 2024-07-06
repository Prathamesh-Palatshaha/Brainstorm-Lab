package OOPs;

class Sum
{
    public void sum(int a, int b)
    {
        System.out.println(a+b);
    }
    public void sum(int a)
    {
        System.out.println(a+10);
    }
    public double sum(double a, double b)
    {
        return a+b;
    }
}
public class CompileTime {
public static void main(String[] args) {
    /* 
     Poly - many
     Morphism - form

     Same task can be done in many ways
     There are two types of polymorphism:
     1. Function Overloading
     2. Function Overriding

     -Compile Time Polymorphism (Method Overloading)
     :function will have same name but it will perform different task.
     :no two function can have same datatype if so then one must have difference in number of args or it must contain additional datatype.
     Example: fun(str name) then fun(str lname, str midname) or fun(str name, str age)

     > it is called Compile time becz error are detected during compilation phase
    */


    Sum s = new Sum();
    s.sum(10);
    s.sum(10,20);
    System.out.println(s.sum(10.52545452540,202.5352525250));

}
}
