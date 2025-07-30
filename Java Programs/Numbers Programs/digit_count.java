import java.util.Scanner;
public class digit_count {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int n= sc.nextInt();
		System.out.println(count(n));
		sc.close();
	}
 static int count(int n) {
	 int num = n/10;
	 if(num==0) {
		 return 1;
	 }
	 return 1+count(num);
 }
}
