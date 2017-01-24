
public class majorityelement {
	public static void main(String[] args)
	{
		int arr[]={2,3,4,2,2,4,4,4,4,4,4,3,7,2,2,2,2};
		int a=0,b=0;
		int c1=0,c2=0;
		for(int i=0;i<arr.length;i++)
		{
			if(c1>0 && a==arr[i]) c1++;
			else if(c2>0 && b==arr[i]) c2++;
		else if(c1==0) 
			{
			a=arr[i];
				c1++;
				
			}
		else if(c2==0)
		{
			b=arr[i];
			c2++;
		}
			// if element dont match like a and arr[i] or b and arr[i]
		else
		{
			c1--;
			c2--;
		}
		}// end of for loop
		if(c1>0||c2>0)
		{
			c1=0;c2=0;
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i]==a)
					c1++;
					else if(arr[i]==b)
						  c2++;
			}
			if(c1>((arr.length/3)+1))
				{System.out.println("majority element exist");
					  System.out.println(a);}
			
				 if(c2>((arr.length/3)+1))
					 System.out.println(b);
				
			else
				System.out.println("majority element not exist");
				
		}
		else 
			System.out.println("majority element not exist");
	}

}
