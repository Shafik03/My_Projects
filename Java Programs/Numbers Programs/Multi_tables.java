import java.util.Scanner;
public class Multi_tables {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a table number: ");
		int n=sc.nextInt();
	for(int i=1;i<=10;i++) {
		System.out.println(i+"*"+n+"="+i*n);
	}
	}
}