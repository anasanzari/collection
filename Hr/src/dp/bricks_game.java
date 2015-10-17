package dp;

import java.util.Scanner;

public class bricks_game {

	
	
	private static int score1;
	private static int score2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for(int t=0;t<tests;t++){
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++){
				a[i] = sc.nextInt();
			}
			score1 = 0;
			score2 = 0;
			//cant figure it out.
		}
	}

	private static int play(int[] a, int i,boolean turn) {
		if(i+3>=a.length){
			int val =  a[i]+((i+1<a.length)?a[i+1]:0) + ((i+2<a.length)?a[i+2]:0);
			if(turn){
				score1 += val;
			}else{
				score2+= val;
			}
			return 0;
		}
		
		return 0;
	}

}
