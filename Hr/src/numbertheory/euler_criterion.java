package numbertheory;

import java.util.Scanner;

public class euler_criterion {

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for(int t=0;t<tests;t++){
			int a = sc.nextInt();
			int m = sc.nextInt();
			//a^((p-1)/2) == 1
			
			if(a==0){
				System.out.println("YES");
			}else{
				long v = wa(a,(m-1)/2,m);
				if(v==1){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}
			
			
		}
	}

	public static long wa(int n,int pow,int m){
		if(pow==0){
			return 1;
		}else if(pow==1)return n;
		else{
			if(pow%2==0){
				long v = wa(n,pow/2,m)%(m);
				
				return (v*v)%(m);
			}else{
				long v = wa(n,(pow-1)/2,m)%(m);
				
				return ((n*v)%(m)*v)%m;
			}
		}
	}

}
