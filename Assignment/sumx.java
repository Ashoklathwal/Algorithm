import java.util.Arrays;

public class sumx {
	public static void main(String args[])
	{
		int arr[]={5,3,6,8,2,1};
		int x=79;
		Arrays.sort(arr);
		int l=0,r=arr.length-1;
		while(l<=r)
		{
			if(arr[l]+arr[r]==x) 
			{
				System.out.println("sum found");
				break;
			}
			 if(arr[l]+arr[r]<x) l++;
			 if(arr[l]+arr[r]>x) r--;
			//else System.out.println("sum not found");
			 if(arr[l]+arr[r]!=x) 
				{
					System.out.println("sum not found");
					break;
					
				}
		}
		
	}

}
