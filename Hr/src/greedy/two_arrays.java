package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class two_arrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for(int t=0;t<tests;t++){
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			for(int i=0;i<n;i++){
				a[i] = sc.nextInt();
			}
			for(int i=0;i<n;i++){
				b[i] = sc.nextInt();
			}
			Arrays.sort(a);
			Arrays.sort(b);
			check(a,b,n,k);
			
		}
	}

	private static void check(int[] a, int[] b, int n,int k) {
		for(int i=0;i<n;i++){
			if((a[i]+b[n-(i+1)])<k){
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}
