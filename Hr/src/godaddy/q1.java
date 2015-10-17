package godaddy;

import java.util.Scanner;

public class q1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long d = sc.nextLong();
		if(n%2==0){
			System.out.println((n/2+d));
		}else{
			System.out.println((1+n/2+d));
		}
	}

}
