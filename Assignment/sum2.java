import java.util.Arrays;

//a[i]+a[j]=a[k] in o(n^2)
public class sum2 {



		public static void main(String args[])
		{
			int arr[]={5,3,6,8,2,1};
			//int x=7;
			int flag=0;
			Arrays.sort(arr);
			int l=0,r=arr.length-1;
			for(int k=0;k<arr.length-1;k++)
			{
			while(l<=r)
			{
				if(arr[l]+arr[r]==arr[k]) 
				{
					System.out.println("true");
					flag=1;
					break;
				}
				 if(arr[l]+arr[r]<arr[k]) l++;
				 if(arr[l]+arr[r]>arr[k]) r--;
				
				
			}
			 if(flag==0) 
				{
				
					System.out.println("sum not found");
					break;
					
				}
			
		}}

	

}
