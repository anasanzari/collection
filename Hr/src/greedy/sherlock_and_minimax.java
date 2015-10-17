package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class sherlock_and_minimax {
	
	public static int search(int[] a, int low, int high,int k){
		if(low>high){
			return Math.min(Math.abs(a[low]-k), Math.abs(a[high]-k));
		}else{
			int mid = (low+high)/2;
			if(a[mid]==k){
				return 0;
			}else if(a[mid]>k){
				return search(a,low,mid-1,k);
			}else{
				return search(a,mid+1,high,k);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		int p = sc.nextInt();
		int q = sc.nextInt();
		//this question is interesting-- answer will be p or q or (a[i]+a[j])/2  property of median.
		
	}

	

}
