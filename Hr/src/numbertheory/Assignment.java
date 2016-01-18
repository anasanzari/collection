package numbertheory;
import java.security.*;
import java.math.*;
import java.util.*;

public class Assignment {
	
	public static BigInteger ONE = new BigInteger("1");
	public static BigInteger TWO = new BigInteger("2");
	public static Random RAND = new SecureRandom();
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
			BigInteger a = sc.nextBigInteger();
			if(a.equals(ONE)){
				print("Composite");
			}else if (a.equals(TWO)){
				print("Prime");
			}else{
				if(millerRabin(a,25)){
					print("Probably prime.");
				}else{
					print("Composite.");
				}
			}
		}
			
	}
	public static void print(String s){
		System.out.println(s);
	}
	public static BigInteger getRandom(BigInteger n){
		BigInteger random;
		random = new BigInteger(n.bitLength(),RAND);
		if(random.compareTo(ONE)<=0||random.compareTo(n)>=0){
			return getRandom(n);
		}
		return random;
	}
	public static boolean millerRabin(BigInteger n, int s) {
		BigInteger a;
		BigInteger sqroot = n.subtract(ONE);
		BigInteger u =  n.subtract(ONE);
		int l = u.getLowestSetBit();
		u = u.shiftRight(l);
		for(int i=0;i<s;i++){ 
			 a = getRandom(n);
			 BigInteger c = a.modPow(u, n);
			 for(int j=0;j<l;j++){
				 BigInteger d = c.modPow(TWO, n);
				 if(d.equals(ONE)&& !c.equals(ONE) && !c.equals(sqroot)){
					 return false;
				 }
				 c = d;
			 }
			
			 if(!c.equals(ONE)){
				 return false;
			 }
		}
		return true;
	}


}

