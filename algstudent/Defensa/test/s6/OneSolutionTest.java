package s6;

import org.junit.jupiter.api.Test;

class OneSolutionTest {

	NumericSquareOne n;

	@Test
	void test00() {
		n = new NumericSquareOne("test/files/test00.txt");
	}

	@Test
	void test01() {
		n = new NumericSquareOne("test/files/test01.txt");
	}

	@Test
	void test02() {
		n = new NumericSquareOne("test/files/test02.txt");
	}
}
