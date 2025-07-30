import java.util.Scanner;
public class Third_largest_element_array {
	public static void main(String[] args) {
		System.out.print("Enter the size of an array: ");
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt()	;
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		sc.close();
		thirdLargest(arr, n);
	}
	static void thirdLargest(int arr[],int n) {
		int max=arr[0];
		for(int i=1;i<n;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		int second = Integer.MIN_VALUE;
		for(int i=1;i<n;i++) {
			if(arr[i]>second && arr[i]<max) {
				second = arr[i];
			}
		}
		int third = Integer.MIN_VALUE;
		for(int i=1;i<n;i++){
			if(arr[i]>third && arr[i]<second) {
				third=arr[i];
			}
		}
		System.out.println("First element is " +max );
		System.out.println("2nd element is " +second);
		System.out.println("3rd element is " +third );
	}
}