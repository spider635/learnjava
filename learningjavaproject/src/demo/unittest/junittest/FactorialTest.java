package demo.unittest.junittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class FactorialTest {

	@Test
	void testFact() {
		assertEquals(1, Factorial.fact(1));
		assertEquals(2, Factorial.fact(2));
		assertEquals(6, Factorial.fact(3));
		assertEquals(3628800, Factorial.fact(10));
		assertEquals(2432902008176640000L, Factorial.fact(20));
	}

	@Test
	void testNegative() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Factorial.fact(-1);
			}
		});
	}
}
