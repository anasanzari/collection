package greedy;

import java.util.*;

public class priyanka_and_toys {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int units = 1;
		int current = a[0];
		for(int i=1;i<n;i++){
			if(a[i]>(current+4)){
				units++;
				current=a[i];
			}
		}
		System.out.println(units);
	}

}
