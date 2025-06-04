class Animal
{
    void eat()
    {
        System.out.println("eating...");
    }
}

class Dog extends Animal
{
    void bark(){
        System.out.println("barking...");
    }
}
// Till this single level inheritance


class Mammal extends Animal {
    void run() {
        System.out.println("Mammal is running");
    }
}

class Cat extends Mammal
{
    void meow(){
        System.out.println("meowing...");
    }
}
// Till this multilevel

class Horse extends Animal
{
    void run()
    {
        System.out.println("Horse is running...");
    }
}
// Till this hierarchical 

public class Inheritance {
public static void main(String[] args) {
    // Single level inheritance
    Dog dog = new Dog();
    dog.eat();
    dog.bark();

    // Multilevel Inheritance

    Cat cat = new Cat();
    cat.run();
    cat.meow();

    // Hierarchical Inheritance
    Dog d1 = new Dog();
    Horse h = new Horse();

    System.out.print("Dog is ");
    dog.eat();

    System.out.print("Horse is ");
    h.eat();
    
    d1.bark();
    h.run();

}
}
