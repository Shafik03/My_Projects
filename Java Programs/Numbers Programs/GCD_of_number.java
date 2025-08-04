import java.util.Scanner;
public class GCD_of_number {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the 1st number: ");
		int n1 = sc.nextInt();
		System.out.print("Enter the 2st number: ");
		int n2 = sc.nextInt();
        System.out.print("GCD of "+n1+" and "+n2+" is ");
		System.out.println(gcd(n1,n2));
		sc.close();
	}
static int gcd(int n1,int n2) {
	int result = Math.min(n1, n2);
	while(result>0) {
		if(n1 % result==0 && n2 % result ==0) {
			break;
		}
		result --;
	}
	return result;
}
}
