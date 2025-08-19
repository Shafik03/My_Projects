import java.util.Scanner;
public class Decimal_to_Binary {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the decimal number: ");
		int dec = sc.nextInt();	
		System.out.println("Decimal - "+dec);
		System.out.print("Binary - ");
		System.out.println(decimaltobinary(dec));
		sc.close();
	}
static int decimaltobinary(int dec) {
	int B_number = 0;
	int count = 0;
	while(dec!=0) {
		int rem = dec%2;
		double c= Math.pow(10,count);
		B_number += rem*c;
		dec/=2;
		count++;
	}
	return B_number;
}
}
