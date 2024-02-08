package lab2;

public class Vector5 {

	static int[] v;

	public static void main(String[] args) {
		int repetitions = Integer.parseInt(args[0]);
		long t1, t2;
		int[] m = null;

		for (int n = 10000; n <= Integer.MAX_VALUE; n *= 2) { // n is increased *5
			v = new int[n];
			Vector1.fillIn(v);

			t1 = System.currentTimeMillis();
			// We have to repeat the whole process to be measured
			for (int repetition = 10; repetition <= repetitions; repetition++) {
				m = new int[2];
				Vector1.maximum(v, m);
			}
			t2 = System.currentTimeMillis();
			System.out.printf("SIZE=%d TIME=%d milliseconds MAX=%d NTIMES=%d\n", n, t2 - t1, m[1], repetitions);
		} // for
	}

}
