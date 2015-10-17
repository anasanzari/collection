package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class flowers {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int bought = 0;
		int total = 0;
		int c = 0;
		for(int i=n-1;i>=0;i--){
			total += (bought+1)*a[i];
			c++;
			if(c==k){
				bought++;
				c=0;
			}
		}
		System.out.println(total);
	}

}
