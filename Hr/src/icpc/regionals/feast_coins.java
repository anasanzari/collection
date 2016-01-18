package icpc.regionals;

import java.util.Scanner;

public class feast_coins {
	
	public static void p(String s, boolean n){
		if(n){
			System.out.println(s);
		}else{
			System.out.print(s);
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for(int t=0;t<tests;t++){
			int s = sc.nextInt();
			int n = sc.nextInt();
			int[] values = new int[n];
			int[] coins = new int[n];
			int[][] sums = new int[n][n];
			for(int i=0;i<n;i++){
				values[i] = sc.nextInt();
				coins[i] = sc.nextInt();
			}
			//brute force
			long val = (long) Math.pow(2, n);
			int count = 0;
			for(long i=1;i<val;i++){
				int sum = 0;
				for(int j=0;j<n;j++){
					if((i&(1<<j))!=0){
						sum += values[j];
					}
				}
				
				if(s%sum==0){
					//check
					int v = s/sum;
					boolean okay = true;
					for(int j=0;j<n;j++){
						if((i&(1<<j))!=0){
							if(v>coins[j]){
								okay = false;
								break;
							}
						}
					}
					if(okay)count++;
				}
			}
			p("Case "+(t+1)+": "+count,true);
			
		}
		
	}

}
