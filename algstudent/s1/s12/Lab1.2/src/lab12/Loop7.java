package lab12;

public class Loop7 {

	public static void main(String arg[]) {
		long t1, t2;
		int nTimes = Integer.parseInt(arg[0]);

		System.out.println("n\ttime\trepetions\tcounter");

		for (long n = 100; n <= 819200; n *= 2) {
			long c = 0;
			t1 = System.currentTimeMillis();

			for (int repetitions = 1; repetitions <= nTimes; repetitions++)
				c = loop1(n);

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1) + "\t" + nTimes + "\t\t" + c);
		} // for
	} // main

	public static long loop1(long n) {
		long cont = 0;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= i; j++)
				for (int k = 1; k <= j; k++)
					for(int l=1; l<= k; l++)
						cont++;
		return cont;
	}
}
