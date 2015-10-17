package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class grid_challenger {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t=0;t<test;t++){
			int n = sc.nextInt();
			sc.nextLine();
			char[][] s = new char[n][n];
			for(int i=0;i<n;i++){
				String a = sc.nextLine();
				s[i] = a.toCharArray();
			}
			Check(s,n);
			
		}
		
	}
	
	public static void Check(char[][] s,int n){
		Arrays.sort(s[0]);
		boolean flag = true;
		for(int i=1;i<n;i++){
			Arrays.sort(s[i]);
			for(int j=0;j<n;j++){
				if(s[i][j]<s[i-1][j]){
					System.out.println("NO");
					return;
				}
			}
		}
		
		System.out.println("YES");
	}

}
