package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class mark_and_toys {

	//classical knapsack problem
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long k = sc.nextLong();
		int[] prices = new int[n];
		for(int i=0;i<n;i++){
			prices[i] = sc.nextInt();
		}
		Arrays.sort(prices);
		long total = 0;
		int count = 0;
		for(int i=0;i<n;i++){
			if(total+prices[i]>k){
				break;
			}
			total += prices[i];
			count++;
		}
		System.out.println(count);

	}

}
