package p2Grafos;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Test;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GraphTest2 {
	@Test 
	public void T1_testGrafoVacio() {
		System.out.println("T1 -->TestGrafoVacio ********************\n");
		Graph<String> G=new Graph<String>(8);
		
		// Mostrar el grafo vacío
		assertEquals("VECTOR NODOS\n\n\nMATRIZ ARISTAS\n\nMATRIZ PESOS\n",G.toString());
		System.out.println(G.toString());
		System.out.println("-------------------------\n");
			
		// Borra un nodo en un árbol vacío
		try {
			G.removeNode("A");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		// Borra un eje en un árbol vacío
		try {
			G.removeEdge("A", "B");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void T2_testAdd() {
		System.out.println("T2 -->TestAdd ********************\n");
		Graph<String> G=new Graph<String>(8);
		
		// Insertar nodos correctamente
		for (int i=0;i<8;i++){
			assertTrue(G.addNode("Nodo "+(char)('A'+i)));			
		}
		
		// Muestra el grafo
		System.out.print(G.toString());

		//Inserta un Null
		try {
			G.addNode(null);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			assertEquals("El elemento a añadir es nulo.",e.getMessage());
		}
		//Insertar un nodo que ya existe
		assertFalse(G.addNode("Nodo A"));

		//No hay espacio
		try{
			assertTrue(G.addNode("E"));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("Element E could not be inserted since the data structure is full.",e.getMessage());
		}
	}		

	@Test
	public void T3_testGetNode() {
		System.out.println("T3 -->TestGetNode ********************\n");
		Graph<String> G=new Graph<String>(8);
		
		// Insertar nodos correctamente
		for (int i=0;i<8;i++){
			assertTrue(G.addNode("Nodo "+(char)('A'+i)));			
		}
		
		// El nodo no existe
		assertEquals(-1,G.getNode("Nodo W"));
		
		// El nodo existe
		for (int i=0;i<8;i++){
			assertEquals(i,G.getNode("Nodo "+(char)('A'+i)));			
		}
	}
	
	@Test
	public void T4_testAddEdge() {
		System.out.println("T4 -->TestAddEdge ********************\n");
		Graph<String> G=new Graph<String>(8);
		
		// Insertar nodos correctamente
		for (int i=0;i<8;i++){
			assertTrue(G.addNode("Nodo "+(char)('A'+i)));			
		}
		
		// No exiSten los nodos
		try {
			G.addEdge("W","I",5.0);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			assertEquals("Element W is not present in the current structure.",e.getMessage());
		}
		
		// Existen los nodos pero el peso es negativo
		try {
			assertTrue(G.addEdge("Nodo A", "Nodo B",-2));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("Los pesos negativos no son válidos",e.getMessage());
		}
		
		// Inserta ejes
		assertTrue(G.addEdge("Nodo A", "Nodo B",2));
		assertTrue(G.addEdge("Nodo A", "Nodo D",2));
		assertTrue(G.addEdge("Nodo A", "Nodo F",4));
		
		assertTrue(G.addEdge("Nodo B", "Nodo C",2));
		assertTrue(G.addEdge("Nodo B", "Nodo H",5));
		
		assertTrue(G.addEdge("Nodo D", "Nodo E",1));
		assertTrue(G.addEdge("Nodo D", "Nodo F",4));
		
		assertTrue(G.addEdge("Nodo E", "Nodo G",6));
		
		assertTrue(G.addEdge("Nodo F", "Nodo C",2));
		assertTrue(G.addEdge("Nodo F", "Nodo G",3));
		
		assertTrue(G.addEdge("Nodo G", "Nodo H",2));
		
		assertTrue(G.addEdge("Nodo H", "Nodo C",1));
		
		// Muestra el grafo
		System.out.print(G.toString());
		
		//Inserta un eje que ya existe
		assertFalse(G.addEdge("Nodo H", "Nodo C",1));
		
		// No exiten el primer nodo
		try {
			G.getEdge("Nodo W","Nodo I");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			assertEquals("Element Nodo W is not present in the current structure.",e.getMessage());
		}
		
		// Existe el primer nodo pero no el segundo
		try {
			G.getEdge("Nodo A","Nodo I");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			assertEquals("Element Nodo I is not present in the current structure.",e.getMessage());
		}
		
		//Existen los nodos pero no el eje
		assertEquals(-1, G.getEdge("Nodo A","Nodo H"),0.0);
	}		
	
	@Test
	public void T5_testGetEdge() {
		System.out.println("T5 -->TestGetEdge ********************\n");
		Graph<String> G=new Graph<String>(8);
		
		// Insertar nodos correctamente
		for (int i=0;i<8;i++){
			assertTrue(G.addNode("Nodo "+(char)('A'+i)));			
		}
		
		// Inserta ejes
		assertTrue(G.addEdge("Nodo A", "Nodo B",2));
		assertTrue(G.addEdge("Nodo A", "Nodo D",2));
		assertTrue(G.addEdge("Nodo A", "Nodo F",4));
		
		assertTrue(G.addEdge("Nodo B", "Nodo C",2));
		assertTrue(G.addEdge("Nodo B", "Nodo H",5));
		
		assertTrue(G.addEdge("Nodo D", "Nodo E",1));
		assertTrue(G.addEdge("Nodo D", "Nodo F",4));
		
		assertTrue(G.addEdge("Nodo E", "Nodo G",6));
		
		assertTrue(G.addEdge("Nodo F", "Nodo C",2));
		assertTrue(G.addEdge("Nodo F", "Nodo G",3));
		
		assertTrue(G.addEdge("Nodo G", "Nodo H",2));
		
		assertTrue(G.addEdge("Nodo H", "Nodo C",1));
		
		// El eje existe
		assertEquals(2,G.getEdge("Nodo A", "Nodo B"),0.0);
		assertEquals(2,G.getEdge("Nodo A", "Nodo D"),0.0);
		assertEquals(4,G.getEdge("Nodo A", "Nodo F"),0.0);
		
		assertEquals(2,G.getEdge("Nodo B", "Nodo C"),0.0);
		assertEquals(5,G.getEdge("Nodo B", "Nodo H"),0.0);
		
		assertEquals(1,G.getEdge("Nodo D", "Nodo E"),0.0);
		assertEquals(4,G.getEdge("Nodo D", "Nodo F"),0.0);
		
		assertEquals(6,G.getEdge("Nodo E", "Nodo G"),0.0);
		
		assertEquals(2,G.getEdge("Nodo F", "Nodo C"),0.0);
		assertEquals(3,G.getEdge("Nodo F", "Nodo G"),0.0);
		
		assertEquals(2,G.getEdge("Nodo G", "Nodo H"),0.0);
		
		assertEquals(1,G.getEdge("Nodo H", "Nodo C"),0.0);
	}
	

	@Test
	public void T6_testGRemoveNode() {
		System.out.println("T6 -->TestRemoveNode ********************\n");
		Graph<String> G=new Graph<String>(8);
		
		// Insertar nodos correctamente
		for (int i=0;i<8;i++){
			assertTrue(G.addNode("Nodo "+(char)('A'+i)));			
		}
		
		// Inserta ejes
		assertTrue(G.addEdge("Nodo A", "Nodo B",2));
		assertTrue(G.addEdge("Nodo A", "Nodo D",2));
		assertTrue(G.addEdge("Nodo A", "Nodo F",4));
		
		assertTrue(G.addEdge("Nodo B", "Nodo C",2));
		assertTrue(G.addEdge("Nodo B", "Nodo H",5));
		
		assertTrue(G.addEdge("Nodo D", "Nodo E",1));
		assertTrue(G.addEdge("Nodo D", "Nodo F",4));
		
		assertTrue(G.addEdge("Nodo E", "Nodo G",6));
		
		assertTrue(G.addEdge("Nodo F", "Nodo C",2));
		assertTrue(G.addEdge("Nodo F", "Nodo G",3));
		
		assertTrue(G.addEdge("Nodo G", "Nodo H",2));
		
		assertTrue(G.addEdge("Nodo H", "Nodo C",1));
		
		// Nodo null
		try {
			G.removeNode(null);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("Element to insert is null.",e.getMessage());
		}
		
		// El nodo no existe
		assertFalse(G.removeNode("Nodo W"));
		
		//Borrar Nodo A: Borra el eje de A a B de A a D y de A a F
		assertTrue(G.removeNode("Nodo A"));
		System.out.println("DESPUES DE BORRAR EL NODO A");
		System.out.println(G.toString());
		
		//Borrar Nodo G: Borra el eje de G a H, de F a G y de E a G
		assertTrue(G.removeNode("Nodo G"));
		System.out.println("DESPUES DE BORRAR EL NODO G");
		System.out.println(G.toString());
		
		//Borrar Nodo H: Borra el eje de H a C y de B a H
		assertTrue(G.removeNode("Nodo H"));
		System.out.println("DESPUES DE BORRAR EL NODO H");
		System.out.println(G.toString());
	}
	
	
	
	@Test
	public void T7_testGRemoveEdge() {
		System.out.println("T1 -->TestRemoveEdge ********************\n");
		Graph<String> G=new Graph<String>(8);
		
		// Insertar nodos correctamente
		for (int i=0;i<8;i++){
			assertTrue(G.addNode("Nodo "+(char)('A'+i)));			
		}
		
		// Inserta ejes
		assertTrue(G.addEdge("Nodo A", "Nodo B",2));
		assertTrue(G.addEdge("Nodo A", "Nodo D",2));
		assertTrue(G.addEdge("Nodo A", "Nodo F",4));
		
		assertTrue(G.addEdge("Nodo B", "Nodo C",2));
		assertTrue(G.addEdge("Nodo B", "Nodo H",5));
		
		assertTrue(G.addEdge("Nodo D", "Nodo E",1));
		assertTrue(G.addEdge("Nodo D", "Nodo F",4));
		
		assertTrue(G.addEdge("Nodo E", "Nodo G",6));
		
		assertTrue(G.addEdge("Nodo F", "Nodo C",2));
		assertTrue(G.addEdge("Nodo F", "Nodo G",3));
		
		assertTrue(G.addEdge("Nodo G", "Nodo H",2));
		
		assertTrue(G.addEdge("Nodo H", "Nodo C",1));
		
		// El primer nodo ya no existe
		try {
			G.removeEdge("Nodo W","Nodo X");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("Element Nodo W is not present in the current structure.",e.getMessage());
		}
		
		// El primer nodo existe pero el segundo no
		try {
			G.removeEdge("Nodo A","Nodo X");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("Element Nodo X is not present in the current structure.",e.getMessage());
		}
		
		//Existen los nodos pero no el eje
		assertFalse(G.removeEdge("Nodo A","Nodo H"));

		
		//Borrar el eje de A a F
		assertTrue(G.removeEdge("Nodo A","Nodo F"));
		System.out.println("DESPUES DE BORRAR EL EJE DE A a F");
		System.out.println(G.toString());
		
		//Borrar el eje de E a G
		assertTrue(G.removeEdge("Nodo E","Nodo G"));
		System.out.println("DESPUES DE BORRAR EL EJE DE E a G");
		System.out.println(G.toString());
		
		//Borrar el eje de H a C
		assertTrue(G.removeEdge("Nodo H","Nodo C"));
		System.out.println("DESPUES DE BORRAR EL EJE DE H a C");
		System.out.println(G.toString());
	}

}
