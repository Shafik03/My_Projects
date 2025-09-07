import java.util.Scanner;
public class Binary_search {
	public static void main (String[] args) {
		Scanner sc =  new Scanner(System.in);
		System.out.print("Enter the array size: ");
		int n=sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			System.out.print("Enter the element: ");
			arr[i] = sc.nextInt();
		}
		System.out.print("Enter the target value: ");
		int tar = sc.nextInt();
		int res = binarysearch(arr,0,n-1,tar);
		System.out.println("Element to be searched is : "+ tar);
		if(res == -1) {
			System.out.println("Element is not present in array");
		}
		else {
			 System.out.println("Element is present at index: " + res);
		}
		sc.close();
	}
static int binarysearch(int arr[], int l, int r, int tar) {
	while(l<=r) {
	int m = (l+r)/2;
	if(arr[m]== tar) {
		return m;
	}
	else if(arr[m] > tar) {
		r = m-1;
	}
	else {
		l = m+1;
	}
}
return -1;
}
}
