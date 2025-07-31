import java.util.Scanner;
public class print_natural_number_between_two_number {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the intial number: ");
	int n1= sc.nextInt();
	System.out.print("Enter the ending number: ");
	int n2=sc.nextInt();
	naturalnum(n1,n2);
	sc.close();
	}
 static void naturalnum(int n1,int n2) {
	 if(n1>n2) {
		 return;
	 }
	 System.out.print(n1+" ");
	 naturalnum(n1+1,n2);
 }
}
