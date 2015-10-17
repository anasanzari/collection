package greedy;

import java.util.Scanner;

public class algorithmic_crush {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		//incomplete
		
		for(int i=0;i<m;i++){
			int o = sc.nextInt();
			int p = sc.nextInt();
			int k = sc.nextInt();
			a[o-1] += k;
			if(p+1<n){
				a[p+1] -= k;
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(a[i]>max){
				max = a[i];
			}
		}
		System.out.println(max);
	}

}
