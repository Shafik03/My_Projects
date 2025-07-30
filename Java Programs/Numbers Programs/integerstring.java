import java.util.Scanner;
public class integerstring{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int age = sc.nextInt();
        sc.nextLine();
        String address = sc.nextLine();
        System.out.println("My name is "+name);
        System.out.println("My age is "+age);
        System.out.println("My address is "+address);
    }
}