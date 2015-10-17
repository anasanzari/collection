package numbertheory;

import java.util.Scanner;

public class fibonacci_finding {

	private static long mod;


	//figuring out fibonnacci in o(logn)
	
	static long[][] multiply(long[][] a, long[][] b){
		long[][] m = new long[2][2];
		m[0][0] = ((a[0][0]*b[0][0])%mod+(a[0][1]*b[1][0])%mod)%mod;
		m[0][1] = ((a[0][0]*b[0][1])%mod+(a[0][1]*b[1][1])%mod)%mod;
		m[1][0] = ((a[1][0]*b[0][0])%mod+(a[1][1]*b[1][0])%mod)%mod;
		m[1][1] = ((a[1][0]*b[0][1])%mod+(a[1][1]*b[1][1])%mod)%mod;
		return m;
	}

   static  long[][] findNthPower( long[][] M , int n ){
	    if( n == 1 ) return M;
	    long[][] R = findNthPower ( M , n/2 );
	    R = multiply(R, R);
	    if( n%2 == 1 ) R = multiply(R, M); 
	    return R;
    }

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
	    mod = (long) (Math.pow(10, 9)+7);
		for(int t=0;t<tests;t++){
			long a = sc.nextLong();
			long b = sc.nextLong();
			int n = sc.nextInt();
			if(n==0){
				System.out.println(a);
				continue;
			}else if(n==1){
				System.out.println(b);
				continue;
			}
			long[][] m = {{1,1},{1,0}};
			
			long[][] p = findNthPower(m, n-1);
			System.out.println(((p[0][0]*b)%mod+(p[0][1]*a)%mod)%mod);
		}
	}

}
