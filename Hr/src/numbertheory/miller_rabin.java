package numbertheory;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import java.security.*;

public class miller_rabin {
	
	
	public static boolean isProbablyPrime(BigInteger n, int k){
		if(n.equals(new BigInteger("2"))){
			return true;
		}
		if(!n.testBit(0)||n.equals(new BigInteger("1"))){
			return false;
		}
		return millerRabin(n, k);
	}

	public static boolean millerRabin(BigInteger n, int k) {
		
		// values for witness function (for saving time).
		BigInteger nMinusOne = n.subtract(new BigInteger("1")); // n-1
		BigInteger u = nMinusOne;
		int lowsetbit = u.getLowestSetBit();
		u = u.shiftRight(lowsetbit); // n-1 = (2^lowsetbit)*u
		
		for(int i=0;i<k;i++){
			Random rand = new SecureRandom();
			BigInteger a;
			
			do{
			  a = new BigInteger(n.bitLength(),rand); // a between (1,n)
			}while(a.compareTo(new BigInteger("1"))<=0||a.compareTo(n)>=0);
			
			if(witness(a,n,nMinusOne,u,lowsetbit)){
				return false;
			}
		}
		return true;
	}

	

	private static boolean witness(BigInteger a, BigInteger n,
			BigInteger nMinusOne, BigInteger u, int lowsetbit) {
		 
		 BigInteger ONE = new BigInteger("1");
		 BigInteger TWO = new BigInteger("2");
		 BigInteger x0 = a.modPow(u, n); //x0 = a^u % n
		 for(int i=0;i<lowsetbit;i++){
			 BigInteger x1 = x0.modPow(TWO, n);
			 if(x1.equals(ONE)&& !x0.equals(ONE) && !x0.equals(nMinusOne)){
				 return true;
			 }
			 x0 = x1;
		 }
		
		 if(!x0.equals(ONE)){
			 return true;
		 }
		
		return false;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int k = 10;  //integer denoting the certainity;
		BigInteger n;
		
		int testcases = sc.nextInt();
		for(int i=0;i<testcases;i++){
			n = sc.nextBigInteger();
			if(isProbablyPrime(n,k)){
				System.out.println("Probably prime.");
			}else{
				System.out.println("Composite.");
			}
			
		}
				
				

	}

}
