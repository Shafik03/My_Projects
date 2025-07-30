import java.util.*;
public class stringcount
{
	public static void main(String[] args) {
		Scanner TA=new Scanner(System.in);
		String s=TA.next();
		int len=s.length();
        boolean flag=true;
        int count=0;
        int max=0;
        char ans='0';
        for(int i=0;i<len;i++)
        {
            count=0;
            for(int j=0;j<len;j++)
            {
                if(s.charAt(i)==s.charAt(j))
                {
                    count++;
                }
            }
            if(count==1)
            {
                System.out.println(s.charAt(i));
                flag=false;
                break;
            }
            if(count>max)
            {
                max=count;
                ans=s.charAt(i);
            }
        }
        if(flag)
        {
            System.out.println("None");
        }
		System.out.println(ans);
	}
}