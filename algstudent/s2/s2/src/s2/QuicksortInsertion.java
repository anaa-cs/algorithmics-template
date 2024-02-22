package s2;

public class QuicksortInsertion {
	public static final int threshold = 5;

	public static void quicksortWithInsertion(int[] a, int right, int left) {
		int i = left;
		int j = right - 1;
		
		if (right < left) {
			if (right-left + 1 <= threshold) {
				Insertion.insertion(a,i,j);
			} else {
				int center = median_of_three(a, left, right);
				// if there are less than or equal to 3 elements, there are just ordered
				if ((right - left) >= 3) {
					int pivot = a[center]; // choose the pivot
					Vector.interchange(a, center, right); // hide the pivot

					do {
						while (a[i] <= pivot && i < right)
							i++; // first element > pivot
						while (a[j] >= pivot && j > left)
							j--; // first element < pivot
						if (i < j)
							Vector.interchange(a, i, j);
					} while (i < j); // end while

					// we set the position of the pivot
					Vector.interchange(a, i, right);
					quicksortWithInsertion(a, left, i - 1);
					quicksortWithInsertion(a, i + 1, right);
				} // if
			}
		}
	}
	
	public static int median_of_three(int[] a, int left, int right) {
		int center = (left + right) / 2;
		if (a[left] > a[center])
			Vector.interchange(a, left, center);
		if (a[left] > a[right])
			Vector.interchange(a, left, right);
		if (a[center] > a[right])
			Vector.interchange(a, center, right);
		return center;
	}
}
