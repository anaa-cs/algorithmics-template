package s2;

public class QuicksortInsertionTimes {

	static int[] v;

	public static void main(String arg[]) {
		long t1, t2;

		
		
		int[] k = {0,5,10,20,30,50,100,200,500,1000};
		
		for(int i=0; i<k.length; i++) {
			v = new int[16000000];
			Vector.randomSorted(v);
			
			t1 = System.currentTimeMillis();

			QuicksortInsertion.quicksortWithInsertion(v, 0, v.length-1, k[i]);
			//QuicksortInsertion.quicksortWithInsertion(v, 0, v.length-1, k[k.length-1]);
			t2 = System.currentTimeMillis();

			System.out.println(16000000 + "\t" + (t2 - t1) + "\t" + k[i]);
		}
		
	}
}
