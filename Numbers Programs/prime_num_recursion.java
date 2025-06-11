import java.util.Scanner;
public class prime_num_recursion {
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
        Syatem.out.print("Enter the number: ");
		int n= sc.nextInt();
		if(isprime(n,2)) {
		System.out.println(n +" is a prime number");
		}
		else {
			System.out.println(n+" is not a prime number");
		}
		sc.close();
	}

	public static boolean isprime(int n,int div) {
		if(n<=1) {
			return false;
		}
		if(n==div) { // checking prime
			return true;
		}
		if(n%div==0) {
			return false;
		}
		return isprime(n,div+1);
	}
}
