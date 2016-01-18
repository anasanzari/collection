package hackathon.adobe;

import java.util.Arrays;
import java.util.Scanner;

public class perfectarray {
	
	public static int bin(long[] arr,int low,int high,long k){
		if(low>high){
			return -1;
		}else{
			int mid = (low+high)/2;
			if(arr[mid]==k) return mid;
			else if(arr[mid]<k){
				return bin(arr,mid+1,high,k);
			}else{
				return bin(arr,low,mid-1,k);
			}
		}
	}

	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		long[] even = new long[n/2];
		long[] odd = new long[n/2];
		long[] sorted = new long[n];
		int j=0,k=0;
		for(int i=0;i<n;i++){
			long a = sc.nextLong();
			arr[i] = a;
			if(a%2==0){
				even[j] = a;
				j++;
			}else{
				odd[k] = a;
				k++;
			}
		}
		Arrays.sort(even);
		Arrays.sort(odd);
		int m = 0;
		for(int i=0;i<n/2;i++){
			sorted[m++] = odd[i];
			sorted[m++] = even[i];
		}
	
		System.out.println(m+" "+sorted[0]+":"+sorted[1]);
		int c = 0;
		int d = 0;
		for(int i=0;i<n;i++){
			if(arr[i]==sorted[i]){
				c++;
				continue;
			}
			long e = arr[i];
			int h = bin(sorted, 0, n-1, e);
			if(h==-1) {
				System.out.println(e+" "+i);
				continue;
			}
			if(arr[h]==sorted[i]){
				d++;
			}
		}
		int val = (n-c-d)==0? 0: n-c-d-1;
		val += d/2;
	System.out.println(val);
		
		
	}

}
