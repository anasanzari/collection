package greedy;

import java.util.HashSet;
import java.util.Scanner;

public class largest_permutation {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		int[] pos = new int[n+1];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
			pos[a[i]] = i;
		}
		int swaps = 0;
		int p = 0;
		while(swaps<k&&p<n){
			if(a[p]!=(n-p)){
				swap(a,pos,p,n);
				swaps++;
				p++;
			}else{
				p++;
			}
		}
		for(int i=0;i<n;i++){
			System.out.print(a[i]+" ");
		}
		
		
	}

	private static void swap(int[] a, int[] pos,int c,int n) {
		int p = pos[n-c];
		int temp = a[c];
		a[c] = a[p];
		a[p] = temp;
		pos[a[p]] = c;
		pos[temp] = p;
	}

	

}
