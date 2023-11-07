package p2Grafos;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GraphFloydTest {
	
	/**
	 * Tests correspondientes al algoritmo de Floyd-Warshall.
	 */
	@Test
	public void T1_testFloyd() {
		System.out.println("Pruebas evaluación Floyd");
		Graph<String> G = new Graph<String>(8);
		
		// Grafo vacio
		assertFalse(G.floyd());
		
		// Insertar nodos
		for (int i = 0; i < 8; i++) {
			assertTrue(G.addNode("Nodo " + (char) ('A' + i)));
		}

		assertTrue(G.addEdge("Nodo A", "Nodo C", 3));
		assertTrue(G.addEdge("Nodo A", "Nodo D", 3));
		assertTrue(G.addEdge("Nodo A", "Nodo E", 8));
		
		assertTrue(G.addEdge("Nodo B", "Nodo C", 2));
		assertTrue(G.addEdge("Nodo B", "Nodo D", 5));
		
		assertTrue(G.addEdge("Nodo C", "Nodo A", 6));
		assertTrue(G.addEdge("Nodo C", "Nodo G", 2));
		
		assertTrue(G.addEdge("Nodo D", "Nodo F", 9));
		assertTrue(G.addEdge("Nodo D", "Nodo H", 1));
		
		assertTrue(G.addEdge("Nodo E", "Nodo C", 4));
		assertTrue(G.addEdge("Nodo E", "Nodo G", 2));
		
		assertTrue(G.addEdge("Nodo F", "Nodo D", 1));
		assertTrue(G.addEdge("Nodo F", "Nodo H", 9));
		
		assertTrue(G.addEdge("Nodo H", "Nodo F", 3));
		System.out.println(G.toString());

		// Floyd
		G.floyd();
		System.out.println("FLOYD\n");
		double A[][] = G.getFloydA();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (A[i][j] == Float.POSITIVE_INFINITY)
					System.out.print("--\t");
				else
					System.out.print(A[i][j] + "\t");
			}
			System.out.println();
		}

		double salida[][] = {
				{ 0.0, Float.POSITIVE_INFINITY, 3.0, 3.0, 8.0, 7.0, 5.0, 4.0 },
				{ 8.0, 0.0, 2.0, 5.0, 16.0, 9.0, 4.0, 6.0 },
				{ 6.0, Float.POSITIVE_INFINITY, 0.0, 9.0, 14.0, 13.0, 2.0, 10.0 },
				{ Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY,
						Float.POSITIVE_INFINITY, 0.0, Float.POSITIVE_INFINITY,
						4.0, Float.POSITIVE_INFINITY, 1.0 },
				{ 10.0, Float.POSITIVE_INFINITY,4.0, 13.0, 0.0, 17.0, 2.0, 14.0 },
				{ Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY,
						Float.POSITIVE_INFINITY, 1.0 ,
						Float.POSITIVE_INFINITY, 0.0, Float.POSITIVE_INFINITY,
						2.0 },
				{ Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY,
						Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY,
						Float.POSITIVE_INFINITY, 0.0, Float.POSITIVE_INFINITY },
				{ Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY,
						Float.POSITIVE_INFINITY, 4.0,
						Float.POSITIVE_INFINITY, 3.0, Float.POSITIVE_INFINITY,
						0.0 } };
		assertArrayEquals(salida,A);
	}
	
	/**
	 * Tests correspondientes al metodo del camino de coste mínimo.
	 */
	@Test
	public void T2_testMinCostPath() {
		System.out.println("Pruebas evaluación MinCostPath");
		Graph<String> G = new Graph<String>(8);

		// Insertar nodos
		for (int i = 0; i < 8; i++) {
			assertTrue(G.addNode("Nodo " + (char) ('A' + i)));
		}

		assertTrue(G.addEdge("Nodo A", "Nodo C", 3));
		assertTrue(G.addEdge("Nodo A", "Nodo D", 3));
		assertTrue(G.addEdge("Nodo A", "Nodo E", 8));
		
		assertTrue(G.addEdge("Nodo B", "Nodo C", 2));
		assertTrue(G.addEdge("Nodo B", "Nodo D", 5));
		
		assertTrue(G.addEdge("Nodo C", "Nodo A", 6));
		assertTrue(G.addEdge("Nodo C", "Nodo G", 2));
		
		assertTrue(G.addEdge("Nodo D", "Nodo F", 9));
		assertTrue(G.addEdge("Nodo D", "Nodo H", 1));
		
		assertTrue(G.addEdge("Nodo E", "Nodo C", 4));
		assertTrue(G.addEdge("Nodo E", "Nodo G", 2));
		
		assertTrue(G.addEdge("Nodo F", "Nodo D", 1));
		assertTrue(G.addEdge("Nodo F", "Nodo H", 9));
		
		assertTrue(G.addEdge("Nodo H", "Nodo F", 3));
		System.out.println(G.toString());

		// minCostPath
		assertEquals(8.0,G.minCostPath("Nodo B", "Nodo A"),0);
		assertEquals(3.0,G.minCostPath("Nodo H", "Nodo F"),0);
		assertEquals(Float.POSITIVE_INFINITY,G.minCostPath("Nodo H", "Nodo A"),0);
		// El primer nodo no existe
		try {
			G.minCostPath("Nodo J", "Nodo A");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("Uno de los nodos no existe.",e.getMessage());
		}
		
		// El segundo nodo no existe
		try {
			G.minCostPath("Nodo A", "Nodo P");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("Uno de los nodos no existe.",e.getMessage());
		}

		
	}
	
	/**
	 * Tests correspondientes al método Path.
	 */
	@Test
	public void T3_testPath() {
		System.out.println("Pruebas evaluación Path");
		Graph<String> G = new Graph<String>(8);

		// Insertar nodos
		for (int i = 0; i < 8; i++) {
			assertTrue(G.addNode("Nodo " + (char) ('A' + i)));
		}

		assertTrue(G.addEdge("Nodo A", "Nodo C", 3));
		assertTrue(G.addEdge("Nodo A", "Nodo D", 3));
		assertTrue(G.addEdge("Nodo A", "Nodo E", 8));
		
		assertTrue(G.addEdge("Nodo B", "Nodo C", 2));
		assertTrue(G.addEdge("Nodo B", "Nodo D", 5));
		
		assertTrue(G.addEdge("Nodo C", "Nodo A", 6));
		assertTrue(G.addEdge("Nodo C", "Nodo G", 2));
		
		assertTrue(G.addEdge("Nodo D", "Nodo F", 9));
		assertTrue(G.addEdge("Nodo D", "Nodo H", 1));
		
		assertTrue(G.addEdge("Nodo E", "Nodo C", 4));
		assertTrue(G.addEdge("Nodo E", "Nodo G", 2));
		
		assertTrue(G.addEdge("Nodo F", "Nodo D", 1));
		assertTrue(G.addEdge("Nodo F", "Nodo H", 9));
		
		assertTrue(G.addEdge("Nodo H", "Nodo F", 3));
		System.out.println(G.toString());
		
		// Mismo nodo
		System.out.print("De Nodo A a Nodo A --> ");
		System.out.println(G.path("Nodo A", "Nodo A"));
		assertEquals("Nodo A",G.path("Nodo A", "Nodo A"));
		// No hay camino
		System.out.print("De Nodo A a Nodo B --> ");
		System.out.println(G.path("Nodo A", "Nodo B"));
		assertEquals("Nodo A\t(infinito)\tNodo B",G.path("Nodo A", "Nodo B"));
		// No existen los nodos
		System.out.print("De Nodo A a Nodo J --> ");
		System.out.println(G.path("Nodo A", "Nodo J"));
		assertEquals("",G.path("Nodo A", "Nodo J"));
		System.out.print("De Nodo J a Nodo A --> ");
		System.out.println(G.path("Nodo J", "Nodo A"));
		assertEquals("",G.path("Nodo J", "Nodo A"));
		System.out.print("De Nodo J a Nodo K --> ");
		System.out.println(G.path("Nodo J", "Nodo K"));
		assertEquals("",G.path("Nodo J", "Nodo K"));

		// Existen los nodos y hay camino
		System.out.print("De Nodo E a Nodo D --> ");
		System.out.println(G.path("Nodo E", "Nodo D"));
		System.out.println(G.minCostPath("Nodo E", "Nodo D"));
		assertEquals("Nodo E\t(4.0)\tNodo C\t(6.0)\tNodo A\t(3.0)\tNodo D",G.path("Nodo E", "Nodo D"));
	}
}
	

