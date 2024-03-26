package lab2;

public class Vector6 {
	
	static int[] v;
	static int[] w;

	public static void main(String[] args) {
		int repetitions = Integer.parseInt(args[0]);
		long t1, t2;
		int m = 0;

		for (int n = 10000; n <= Integer.MAX_VALUE; n *= 2) { // n is increased *5
			v = new int[n];
			Vector1.fillIn(v);
			w = new int[n];
			Vector1.fillIn(w);

			t1 = System.currentTimeMillis();
			// We have to repeat the whole process to be measured
			for (int repetition = 1; repetition <= repetitions; repetition++) {
				m = Vector1.matches1(w, v);
			}
			t2 = System.currentTimeMillis();
			System.out.printf("SIZE=%d TIME=%d milliseconds MATCHES=%d NTIMES=%d\n", n, t2 - t1, m, repetitions);
		} // for
	}

}
