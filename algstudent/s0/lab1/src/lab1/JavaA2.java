package lab1;

import java.util.ArrayList;

public class JavaA2 {

	public static boolean primoA2(int m) {
		for (int i = 2; i < m; i++) {
			if (m % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static ArrayList<Integer> listadoPrimos(long n) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < n; i++) {
			if (primoA2(i)) {
				primes.add(i);
			}
		}
		return primes;

	}

	public static void main(String[] args) {
		long n = 10000;
		for (int i = 0; i < 7; i++) {
			long t1 = System.currentTimeMillis();
			ArrayList<Integer> primes = listadoPrimos(n);
			long t2 = System.currentTimeMillis();
			System.out.println(("n =" + n + "*** time =" + (t2 - t1) + "milliseconds)"));
			n = n * 2;
		}
	}

}
