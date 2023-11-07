package p2Grafos;

import static org.junit.Assert.*;

import org.junit.Test;


public class GraphDijkstraTest {
	
	/**
	 * Tests correspondientes al algoritmo de Dijkstra.
	 */
	@Test
	public void test() {
		System.out.println("Pruebas evaluación Dijkstra");
		Graph<String> G=new Graph<String>(8);
		// Insertar nodos
		for (int i=0;i<8;i++){
			assertTrue(G.addNode("Nodo "+(char)('A'+i)));			
		}
		
		assertTrue(G.addEdge("Nodo A","Nodo C", 5));
		assertTrue(G.addEdge("Nodo A","Nodo E", 5));
		
		assertTrue(G.addEdge("Nodo B","Nodo A", 4));
		assertTrue(G.addEdge("Nodo B","Nodo F", 4));
		assertTrue(G.addEdge("Nodo B","Nodo G", 2));

		assertTrue(G.addEdge("Nodo C","Nodo B", 4));
		assertTrue(G.addEdge("Nodo C","Nodo E", 1));
		assertTrue(G.addEdge("Nodo C","Nodo G", 7));
		
		assertTrue(G.addEdge("Nodo D","Nodo F", 6));
		
		assertTrue(G.addEdge("Nodo F","Nodo H", 9));
		System.out.println(G.toString());
		
		// Dijkstra
		DijkstraDataClass D= G.dijkstra("Nodo A");
		System.out.print("Dijkstra - Nodo A ->  D[");
		//Obtiene el vector D
		double d[]=D.getdDijkstra();
		for (int i=0; i<d.length-1; i++) 
			System.out.print(d[i]+",");
		System.out.println(d[d.length-1]+"]");
		System.out.println("\n");
		//assertEquals(d[0],Float.POSITIVE_INFINITY,0.0001);
		assertEquals(d[1],9.0,0.0001);
		assertEquals(d[2],5.0,0.0001);
		assertEquals(d[3],Float.POSITIVE_INFINITY,0.0001);
		assertEquals(d[4],5.0,0.0001);
		assertEquals(d[5],13.0,0.0001);
		assertEquals(d[6],11.0,0.0001);
		assertEquals(d[7],22.0,0.0001);
		
		System.out.print("Dijkstra - Nodo A ->  P[");
		//Obtiene el vector P
		int p[]=D.getpDijkstra();
		for (int i=0; i<p.length-1; i++) 
			System.out.print(p[i]+",");
		System.out.println(p[p.length-1]+"]");
		//assertEquals(p[0],0);
		assertEquals(p[1],2);
		assertEquals(p[2],-1);
		assertEquals(p[3],-1);
		assertEquals(p[4],-1);
		assertEquals(p[5],1);
		assertEquals(p[6],1);
		assertEquals(p[7],5);
	}
}
