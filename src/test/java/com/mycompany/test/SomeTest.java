package com.mycompany.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SomeTest {
	@Test
	void test1() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> setAge(-1));
	}

	private void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("age can't be less than 0");
		}
	}
}
