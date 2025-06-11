import java.util.Scanner;
public class countoddnumbers{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int oddcount=0;
        for(int i=1;i<=num;i++){
            if(i%2!=0){
                oddcount=oddcount+1;
                System.out.println(i+ " is a odd number");
            }
        }
        System.out.println("Total count of odd numbers is: "+oddcount);
    }
}