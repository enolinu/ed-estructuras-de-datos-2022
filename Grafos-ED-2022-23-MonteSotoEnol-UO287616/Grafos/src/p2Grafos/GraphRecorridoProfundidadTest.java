package p2Grafos;

import static org.junit.Assert.*;

import org.junit.Test;


public class GraphRecorridoProfundidadTest {
	
	/**
	 * Tests correspondientes al recorrido en profundidad.
	 */
	@Test
	public void test() {
		System.out.println("Pruebas evaluación Recorrido en profundidad");
		Graph<String> G = new Graph<String>(8);
		// Insertar nodos
		for (int i = 0; i < 8; i++) {
			assertTrue(G.addNode("Nodo " + (char) ('A' + i)));
		}

		assertTrue(G.addEdge("Nodo A", "Nodo B", 1));
		assertTrue(G.addEdge("Nodo A", "Nodo E", 1));
		assertTrue(G.addEdge("Nodo B", "Nodo A", 1));
		assertTrue(G.addEdge("Nodo B", "Nodo C", 1));
		assertTrue(G.addEdge("Nodo B", "Nodo F", 1));
		assertTrue(G.addEdge("Nodo C", "Nodo A", 1));
		assertTrue(G.addEdge("Nodo C", "Nodo F", 1));
		assertTrue(G.addEdge("Nodo C", "Nodo E", 1));
		assertTrue(G.addEdge("Nodo D", "Nodo B", 1));
		assertTrue(G.addEdge("Nodo D", "Nodo F", 1));
		assertTrue(G.addEdge("Nodo E", "Nodo H", 1));
		assertTrue(G.addEdge("Nodo F", "Nodo B", 1));
		assertTrue(G.addEdge("Nodo G", "Nodo F", 1));
		assertTrue(G.addEdge("Nodo G", "Nodo E", 1));
		assertTrue(G.addEdge("Nodo H", "Nodo F", 1));
		assertTrue(G.addEdge("Nodo H", "Nodo G", 1));
		System.out.println(G.toString());
		
		//El nodo no existe
		assertEquals("",G.recorridoProfundidad("Nodo W"));
		
		//El nodo existe
		System.out.println("\nRecorrido desde el nodo C:");
		System.out.println(G.recorridoProfundidad("Nodo C"));
		assertEquals("Nodo C\tNodo A\tNodo B\tNodo F\tNodo E\tNodo H\tNodo G\t",G.recorridoProfundidad("Nodo C"));
		
		System.out.println("\nRecorrido desde el nodo D:");
		System.out.println(G.recorridoProfundidad("Nodo D"));
		assertEquals("Nodo D\tNodo B\tNodo A\tNodo E\tNodo H\tNodo F\tNodo G\tNodo C\t",G.recorridoProfundidad("Nodo D"));
		
		System.out.println("\nRecorrido desde el nodo H:");
		System.out.println(G.recorridoProfundidad("Nodo H"));
		assertEquals("Nodo H\tNodo F\tNodo B\tNodo A\tNodo E\tNodo C\tNodo G\t",G.recorridoProfundidad("Nodo H"));
	}

}
