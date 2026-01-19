import java.util.Scanner;
public class array_creation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of an array: ");
        int ln=sc.nextInt();
        int[] arr = new int[ln];
		for(int i=0;i<ln;i++) {
			arr[i]=sc.nextInt();
		}
		for(int j=0;j<ln;j++) {
			System.out.print(arr[j]+" ");
		}
		sc.close();
	}

}
