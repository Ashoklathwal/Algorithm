	import java.util.*;
class egg_drop_problem
{
    public static void  main(String args[] )
    {
        int  building=8,eggs=2;
       int trials[][] = new int[eggs+1][building+1];
       for (int j = 1; j <= building; j++)
           	trials[1][j] = j;      
       for (int i = 1; i <= eggs; i++)
           {
           	 trials[i][1] = 1;
           	 trials[i][0] = 0;
           }       
       for (int i = 2; i <= eggs; i++)
          {
           for (int j = 2; j <= building; j++)
           {
           	trials[i][j] = Integer.MAX_VALUE;
               for (int m = 1; m <= j; m++)
               {
                  int  output = 1 +Integer.max(trials[i-1][m-1], trials[i][j-m]);
                    if (output < trials[i][j])
                   	 trials[i][j] =output;
               }
           }
       }
       System.out.println(Arrays.deepToString(trials));
       System.out.println("min number of trials :"+trials[eggs][building]); 
       
    }
}