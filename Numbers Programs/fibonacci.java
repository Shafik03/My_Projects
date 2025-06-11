package java_project;

import java.util.Scanner;
public class fibonacci {
	static void fiboseries(int N) {
		int n1=0,n2=1;
		for(int i=0;i<N;i++) {
			System.out.print(n1 +" ");
			int n3=n2+n1;
			n1=n2;
			n2=n3;
		}
	}
public static void main(String args[]) {
	Scanner sc= new Scanner(System.in);
    System.out.print("Enter the size of the series": );
	int N=sc.nextInt();
	fiboseries(N);
	sc.close();
}
}
