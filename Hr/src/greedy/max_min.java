package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class max_min {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k =sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int min = Integer.MAX_VALUE;
		for(int i=0;i<=n-k;i++){
			
			if(a[i+k-1]-a[i]<min){
				min = a[i+k-1]-a[i];
			}
		}
		System.out.println(min);
	}

}
