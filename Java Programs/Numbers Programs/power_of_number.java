import java.util.Scanner;
public class power_of_number {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the base: ");
		int base= sc.nextInt();
		System.out.print("Enter the power: ");
		int power = sc.nextInt();
		System.out.println(power(base,power));
		sc.close();
	}
 static int power(int base,int power) {
	 if(power==0) {
		 return 1;
	 }
	 else {
		 return base *power(base,power-1);
	 }
 }
}
