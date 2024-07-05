public class StringMethods {
public static void main(String[] args) {
    String name = "Naruto";
    //concat
    String name2 = "Uzumaki";
    System.out.println("Char at position 0 "+name + " " +name2);

    //charAt

    System.out.println(name.charAt(0));

    //length of string

    System.out.println(name.length());

    //replace
    String repl = name.replace('N', 'B');
    System.out.println(repl);

    //substring
    System.out.println(name.substring(0, 4)); //end index is not included 

}
}
