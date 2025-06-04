
package OOPs;

class Student
{
    String name;
    int age;
    /*
    You initialize the class with given params
    */
    Student(String name, int age)
    {
        System.out.println("Param Constructor Initialized");
        this.name = name;
        this.age = age;
    }

    public void printInfo()
    {
        System.out.println(this.name);
        System.out.println(this.age);
    }
}

public class ParamConstructor
{
    public static void main(String[] args) {
        Student s1 = new Student("Prathmesh P", 21);
        s1.printInfo();

    }
}