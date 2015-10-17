package dp;

import java.util.Scanner;

public class red_john_is_back {

	//prime numbers less than n
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
			int t = sc.nextInt();
			int count = count(t);
		    int v = sieve(count);
		    System.out.println(v);
		}
	}

	private static int sieve(int n) {
		if(n<2)return 0;
		boolean[] a = new boolean[n];
		int count = 0;
		for(int i=1;i<n;i++){
			if(!a[i]){
				count++;
				mark(a,i+1,n);
			}
		}
		return count;
	}

	private static void mark(boolean[] arr, int a, int n) {
		 	int i = 2, num;
		    while ( (num = i*a) <= n ){
		        arr[ num-1 ] = true; 
		        ++i;
		    }
	}

	private static int count(int t) {
		int[] ways = new int[t+1];
		if(t<=3){
			return 1;
		}
		ways[0] = ways[1] = ways[2] = ways [3] = 1;
		for(int i=4;i<=t;i++){
			ways[i] = ways[i-1] + ways[i-4];
		}
 		return ways[t];
	}

}
