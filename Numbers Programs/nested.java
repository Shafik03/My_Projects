import java.util.Scanner;
public class nested {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your monthly salary: ");
		int salary=sc.nextInt();
		System.out.print("Enter your age: ");
		int age=sc.nextInt();
		if(salary>=20000 && age>=20) {
			System.out.println("you are eligible for loan");
			System.out.println("How much loan do you need?");
			int loan = sc.nextInt();
			if(loan<100000) {
				System.out.println("Loan available");
			}
			else {
				System.out.println("Loan unavailable");
			}
		}
		else {
			System.out.println("You are not eligible for loan");
		}
	}
}