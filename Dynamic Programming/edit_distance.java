import java.io.*;
import java.util.Arrays;

public class edit_distance 
{
	static void edit_operation(String s1,String s2,int[][] table)
	{
		
		int i=s1.length(),j=s2.length();
		System.out.println(Arrays.deepToString(table));
		//System.out.println("hello "+table[i-4][j-4]+" 2nd "+table[i-3][j-3]);
		while(i>0 && j>0)
		{
			if(s1.charAt(i-1)==s2.charAt(j-1))
			{
				//System.out.print(s1.charAt(i-1)+" ");
				i--;j--;
			} 
			else if(table[i][j]==table[i-1][j]+1)
			{
				System.out.println("Delete in string 1 :"+s1.charAt(i-1));
			i--;
			j--;
			}
			else if(table[i][j]==table[i][j-1]+1)
			{
				System.out.println("Delete in string 2:"+s2.charAt(j-1));
			i--;
			j--;
			}
			else if(table[i][j]==table[i-1][j-1])
			{
			      System.out.println("Edit " + s2.charAt(j-1) + " in string2 to " + s1.charAt(i-1) + " in string1");
			i--;
			j--;
			}
			//System.out.println(table[i][j]+" "+table[i-1][j]+" "+table[i-1][j-1]+" "+table[i][j-1]+" "+i+" "+j);
		}
		
	}
	static void min_edit_distance(String s1,String s2)
	{
		int m=s1.length();
		int n=s2.length();
		int[][] table=new int[m+1][n+1];
		for(int i=0;i<=m;i++)
			table[i][0]=i;//delete
		for(int i=0;i<=n;i++)
			table[0][i]=i;//insert
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
					table[i][j]=table[i-1][j-1];
				else
					table[i][j]=1+Math.min(table[i][j-1],Math.min(table[i-1][j],table[i-1][j-1]));
				//i-1 delete
				//j-1 insert
				//i-1 j-1 substitute
				/*
				 If you are inserting in first string (original length i) 
				 it will be same char as last char of string 2.
				  So last character of string 2 is matched so 
				  we need to match remaining ( len - 1 i.e., j-1) and
				   none of the old character of string one is matched
				    so its all character should be matched.
				 */
			}
		}
		//System.out.println(Arrays.deepToString(table));
		System.out.println("The minimum edit dsitance is:"+table[m][n]);
		edit_operation(s1,s2,table);
		
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf=new BufferedReader(new FileReader("../Dynamic Programming/src/edit_distance1.txt"));
	//	System.out.println("Enter length of string 1");
		int m=Integer.parseInt(bf.readLine());
	//	System.out.println("Enter length of string 2");
		int n=Integer.parseInt(bf.readLine());
	//	System.out.println("Enter string 1");
		String str1=bf.readLine();
	//	System.out.println("Enter string 2");
		String str2=bf.readLine();
		min_edit_distance(str1,str2);
	}

}
