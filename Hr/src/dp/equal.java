package dp;

import java.util.Arrays;
import java.util.Scanner;

public class equal {

	//wrong!!
	private static int ops;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for(int t=0;t<tests;t++){
			ops = 0;
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++){
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);
			int added = 0;
			ops = 0;
			for(int i=0;i<n-1;i++){
				if(a[i]!=(a[i+1]+added)){
					ops += count(a[i+1]+added-a[i]);
					added += a[i+1]+added-a[i];
					//System.out.println(added);
				}
			}
			System.out.println(ops);
		}
	}

	private static int count(int i) {
		int f = i/5;
		int rem = i%5;
		int t = rem/2;
		rem = rem%2;
		int o = rem;
		return f+t+o;
		
	}

}
