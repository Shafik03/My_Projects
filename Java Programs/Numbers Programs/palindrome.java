import java.util.Scanner;
public class palindrome {
	public static int reversNumber(int n) {
		int reversed_n=0;
		while(n>0) {
			reversed_n=reversed_n*10+n%10;
			n=n/10;
		}
		return reversed_n;
	}
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n=sc.nextInt();
		
		System.out.println( "reverse of "+n+" is "+ reversNumber(n));
		if(n==reversNumber(n)) {
			System.out.println("it is a palindrome number");
		}
		else {
			System.out.println("not palindrome");
		}
	}

}
