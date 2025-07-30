import java.util.Scanner;
public class Sum_of_digit{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the digit: ");
        int n=sc.nextInt();
        System.out.println(getsum(n));
        sc.close();
    }
    static int getsum(int n){
        int sum=0;
        while(n!=0){
            sum=sum+n%10;
            n=n/10;
        }
        return sum;
    }
}