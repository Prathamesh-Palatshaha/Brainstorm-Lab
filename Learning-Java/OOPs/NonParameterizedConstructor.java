package OOPs;

class Stud
{
    String name;
    int age;

    public void printInfo()
    {
        System.out.println(this.name);
        System.out.println(this.age);
    }

    //Non-parameterized Constructor
    /*
    if we do not define our non para constructor then java will automatically define its own constructor
    */
    Stud()
    {
        System.out.println("Non-param Constructor initialized");
    }
}

public class NonParameterizedConstructor {
public static void main(String[] args) {
    Stud s1 = new Stud();
    s1.name = "Prathamesh P";
    s1.age = 21;

    s1.printInfo();
}
}
