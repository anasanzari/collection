package hackathon.snapdeal;

import java.util.Scanner;

public class byteland {
	
	public static int val = 1000000007;
						

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				a[i][j] = sc.nextInt();
			}
		}
		long[][] t = new long[n][m];
		t[0][0] = a[0][0];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(i==0&&j==0)continue;
				long tot = 0;
				for(int k=i-1,l=j-1;k>=0&&l>=0;k--,l--){
					 tot += t[k][l]%val;
				}
				for(int k=i-1;k>=0;k--){
					 tot +=  t[k][j]%val;
				}
				for(int k=j-1;k>=0;k--){
					 tot +=  t[i][k]%val;
				}
				
				t[i][j] = (tot*a[i][j])%val;
			}
		}
		System.out.println(t[n-1][m-1]);
		/*for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(t[i][j]+" ");
			}
			System.out.println("");
			
		}*/
		
	}

}
