import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAlgorithms {
	
	@Test
	void test() {
		
		Algorithms a = new Algorithms();
		
		assertEquals(1, a.powIter(0));
		assertEquals(1, a.powIter(0));
		assertEquals(8, a.powIter(3));
		assertEquals(-1, a.powIter(-3));
		
		assertEquals(-1, a.sumaIter(0));
		assertEquals(-1, a.sumaIter(-3));
		assertEquals(1, a.sumaIter(1));
		assertEquals(6, a.sumaIter(3));
		
		assertEquals(-1, a.sumaRec(0));
		assertEquals(-1, a.sumaRec(-3));
		assertEquals(1, a.sumaRec(1));
		assertEquals(6, a.sumaRec(3));
		
		assertEquals(0, a.fibonacciIter(0));
		assertEquals(1, a.fibonacciIter(1));
		assertEquals(1, a.fibonacciIter(2));
		assertEquals(2, a.fibonacciIter(3));
		
		assertEquals(0, a.fibonacciRec(0));
		assertEquals(1, a.fibonacciRec(1));
		assertEquals(1, a.fibonacciRec(2));
		assertEquals(2, a.fibonacciRec(3));
		
		assertEquals(1, a.powRec1(0));
		assertEquals(8, a.powRec1(3));
		//assertEquals(1, a.powRec2(0));
		//assertEquals(8, a.powRec2(3));
		assertEquals(1, a.powRec3(0));
		assertEquals(8, a.powRec3(3));
	}

}
