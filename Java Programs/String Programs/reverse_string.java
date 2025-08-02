import java.util.Scanner;
public class reverse_string {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String str = sc.nextLine();
		System.out.println("reversed string is: "+reverse(str));
		sc.close();
	}
public static String reverse(String str) {
	if(str.isEmpty()) {
		return str;
	}
	return reverse(str.substring(1)) + str.charAt(0);
}
}
