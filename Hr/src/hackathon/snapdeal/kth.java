package hackathon.snapdeal;

import java.util.HashMap;
import java.util.Scanner;

public class kth {
	
	public static int bin(int[] arr,int low,int high,int k,boolean l){
		if(low>high){
			if(l)return high;
			else return low;
			
		}else{
			int mid = (low+high)/2;
			if(arr[mid]==k) return mid;
			else if(arr[mid]<k){
				return bin(arr,mid+1,high,k,l);
			}else{
				return bin(arr,low,mid-1,k,l);
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] arr = new int[n];
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
			map.put(arr[i], i);
		}
		
		
		for(int i=0;i<q;i++){
			int x = sc.nextInt();
			int k = sc.nextInt();
			int t = sc.nextInt();
			if(t==0){
			   int index = bin(arr,0,n-1,x, true); //map.get(x);
			   if(index+k>=n){
				   System.out.println("-1");
			   }else{
				   System.out.println(arr[index+k]);
			   }
			}else{
				int index = bin(arr,0,n-1,x, false); 
				   if(index-k<0){
					   System.out.println("-1");
				   }else{
					   System.out.println(arr[index-k]);
				   }
			}
		}
	}
	
	

}
