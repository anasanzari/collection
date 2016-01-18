package ds;

import java.util.LinkedList;
import java.util.Scanner;

public class LargestRectangle {
	
	//largest area in a histogram

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		LinkedList<Integer> stack = new LinkedList<Integer>();
	
		int i=0;
		int max = -1;
		while(i<n){
			if(stack.isEmpty()||arr[stack.peek()]<=arr[i]){
				stack.push(i++);
			}else{
				int tp = stack.pop();
				int area = arr[tp] * ((stack.isEmpty())? i : i-stack.peek()-1);
				if(area>max) max = area;
			}
		}
		while(!stack.isEmpty()){
			int tp = stack.pop();
			int area = arr[tp] * ((stack.isEmpty())? i : i-stack.peek()-1);
			if(area>max) max = area;
		}
		System.out.println(max);
		
	}
	
	public static void ordernsquared(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		int[][] min = new int[n][n];
		long max = -1;
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				min[i][j] = (j==i) ? arr[i] : Math.min(arr[j], min[i][j-1]);
				long check = min[i][j] * (j-i+1);
				if(check>max){
					max = check;
				}
			}
		}
		
		System.out.println(max);
	}

}
