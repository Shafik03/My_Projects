import java.util.Scanner;
public class elseifcondition {
	public static void main(String asgs[]) {
		Scanner sc = new Scanner(System.in);
		int mark=sc.nextInt();
		if(mark>35 && mark<60) {
			System.out.println("you will get video game");
		}
			if(mark>60 && mark<90) {
				System.out.println("you will get iphone");
			}
			if(mark>90 && mark<=100) {
				System.out.println("you will get Macbook pro");
			}
	}
}
