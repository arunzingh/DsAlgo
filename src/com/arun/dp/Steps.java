package com.arun.dp;

public class Steps {
	
	int countWaysUtil(int n, int m)
	{
	    int res[] = new int[n];
	    res[0] = 1; res[1] = 1;
	    for (int i=2; i<n; i++)
	    {
	       res[i] = 0;
	       for (int j=1; j<=m; j++)
	         res[i] += res[i-j];
	    }
	    return res[n-1];
	}
	 
	// Returns number of ways to reach s'th stair
	int countWays(int s, int m)
	{
	    return countWaysUtil(s+1, m);
	}
	
	
	public static void main(String[] args) {
		Steps st = new Steps();
		int s = 4, m = 2;
	    System.out.println("Number of ways : " + st.countWays(s, m));
	}
}
