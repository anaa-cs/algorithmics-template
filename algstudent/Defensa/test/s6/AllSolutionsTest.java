package s6;

import org.junit.jupiter.api.Test;

class AllSolutionsTest {

	NumericSquareAll n;

	@Test
	void test00() {
		n = new NumericSquareAll("test/files/test00.txt");
	}

	@Test
	void test01() {
		n = new NumericSquareAll("test/files/test01.txt");
	}

	@Test
	void test02() {
		n = new NumericSquareAll("test/files/test02.txt");
	}
}
