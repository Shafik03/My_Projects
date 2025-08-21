import java.util.Scanner;
public class linear_search {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of an array: ");
		int size = sc.nextInt();
		if(size == 0) {
            System.out.println("Array is empty, nothing to search.");
            return;
		}
		int arr[] = new int[size];
		for(int i=0;i<size;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.print("Enter the key element to search in an array: ");
		int key = sc.nextInt();
		int result = linearsearch(arr,arr.length,key);
		if(result!=-1) {
			System.out.println("The element "+key+" is found at "+ result+" index of an array");
		}
		else {
			System.out.println("The element "+key+" is not found");
		}
		sc.close();
	}
static int linearsearch(int arr[],int size,int key) {
	if(arr[size-1] == key) {
		return size-1;
	}
	return linearsearch(arr, size-1, key);
}
}
