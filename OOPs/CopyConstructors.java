package OOPs;

class Std
{
    String name;
    int age;
    /*
    You will copy the values of differnet class into your initialized class
    */
    Std()
    {

    }
    Std(Std s2)
    {
        System.out.println("Copy Constructor Initialized");
        this.name = s2.name;
        this.age = s2.age;
    }

    public void printInfo()
    {
        System.out.println(this.name);
        System.out.println(this.age);
    }
}


public class CopyConstructors {
    public static void main(String[] args) {
        Std s1 = new Std();
        s1.name = "Student";
        s1.age = 21;
        // s1.printInfo();

        Std s2 = new Std(s1);
        s2.printInfo();

    }
}

