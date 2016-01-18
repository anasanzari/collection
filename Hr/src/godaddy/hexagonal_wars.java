package godaddy;

import java.util.Scanner;

public class hexagonal_wars {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] g = new int[n][n];
		int m = sc.nextInt();
		
		boolean v = true;
		for(int i=0;i<n;i++){
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			if(v){
				g[x][y] = 1;
				check(g,x,y,1);
			}else{
				g[x][y] = 2;
				check(g,x,y,2);
			}
		}
		
		
	}

	private static void check(int[][] g, int x, int y, int v) {
		
	}

}
