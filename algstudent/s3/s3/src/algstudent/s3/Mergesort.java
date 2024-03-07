package algstudent.s3;

public class Mergesort {
	static int[] v;

	public static void mergesort(int[] v) {
		mergesort(v, 0, v.length - 1);
	}

	private static void mergesort(int[] v, int left, int right) {
		if (right > left) {
			int center = (left + right) / 2;
			mergesort(v, left, center);
			mergesort(v, center + 1, right);
			combine(v, left, center, center + 1, right);
		}
	}

	private static void combine(int[] elements, int x1, int x2, int y1, int y2) {
		int sizeX = x2 - x1 + 1;
		int sizeY = y2 - y1 + 1;

		int[] x = new int[sizeX];
		int[] y = new int[sizeY];

		for (int i = 0; i < sizeX; i++) {
			x[i] = elements[x1 + i];
		}

		for (int i = 0; i < sizeY; i++) {
			y[i] = elements[y1 + i];
		}

		int counterX = 0;
		int counterY = 0;
		int elementsX = 0;
		int elementsY = 0;

		for (int i = 0; i < elements.length; i++) {
			while (elementsX != sizeX || elementsY != sizeY) {
				System.out.println(elementsX);
				if (x[counterX] <= y[counterY]) {
					elements[i] = x[counterX];
					counterX++;
					elementsX++;
					break;
				} else {
					elements[i] = y[counterY];
					counterY++;
					elementsY++;
					break;
				}
			}
		}
	}
}
