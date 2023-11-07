package TEST;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ColasPrioridad.BinaryHeap;

class ColasPrioridadTest {

	@Test
	void test_Add_Int() {
		BinaryHeap<Integer> l = new BinaryHeap<Integer>(9);
		
		try {
			l.add(null);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("Element to insert is null.",e.getMessage());
		}
		
		// Inserta el elemento 8
		assertTrue(l.add(8));
		assertEquals("8",l.toString());

		// Inserta el elemento 5
		assertTrue(l.add(5));
		assertEquals("5\t8",l.toString());
		
		// Inserta el elemento 10
		assertTrue(l.add(10));
		assertEquals("5\t8\t10",l.toString());
		
		// Inserta el elemento 2
		assertTrue(l.add(2));
		assertEquals("2\t5\t10\t8",l.toString());
		
		// Inserta el elemento 1
		assertTrue(l.add(1));
		assertEquals("1\t2\t10\t8\t5",l.toString());
		
		// Inserta el elemento 6
		assertTrue(l.add(6));
		assertEquals("1\t2\t6\t8\t5\t10",l.toString());
		
		// Inserta el elemento 12
		assertTrue(l.add(12));
		assertEquals("1\t2\t6\t8\t5\t10\t12",l.toString());
		
		// Inserta el elemento 9
		assertTrue(l.add(9));
		assertEquals("1\t2\t6\t8\t5\t10\t12\t9",l.toString());		
		
		// Inserta el elemento 11
		assertTrue(l.add(11));
		assertEquals("1\t2\t6\t8\t5\t10\t12\t9\t11",l.toString());	
		
		// El elemento ya existe
		assertFalse(l.add(11));
		
		// No hay espacio
		try{
			assertTrue(l.add(45));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("La estructura está llena.",e.getMessage());
		}
		
	}
	
	@Test
	void test_Remove_Int() {
		BinaryHeap<Integer> l = new BinaryHeap<Integer>(9);
		
		// Borro en en una cola vac�a
		assertFalse(l.remove(8));
		
		// La clave es null
		try {
			l.remove(null);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("Element to insert is null.",e.getMessage());
		}
		
		// Inserta elemento3
		assertTrue(l.add(8));
		assertTrue(l.add(5));
		assertTrue(l.add(10));
		assertTrue(l.add(2));
		assertTrue(l.add(1));
		assertTrue(l.add(6));
		assertTrue(l.add(12));
		assertTrue(l.add(9));
		assertTrue(l.add(11));
		assertEquals("1\t2\t6\t8\t5\t10\t12\t9\t11",l.toString());		
		
		// Borro un elemento que no existe
		try{
			assertTrue(l.remove(45));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("El elemento no existe en la estructura.",e.getMessage());
		}
		
		// Borro la raiz 
		assertEquals(1,l.sacar());
		assertEquals("2\t5\t6\t8\t11\t10\t12\t9",l.toString());
		
		// Borro una clave con un s�lo hijo 
		assertTrue(l.remove(8));
		assertEquals("2\t5\t6\t9\t11\t10\t12",l.toString());
		
		// Borro una clave con dos hijos, la ra�z 
		assertTrue(l.remove(2));
		assertEquals("5\t9\t6\t12\t11\t10",l.toString());
		
		// Borro una clave con dos hijos 
		assertTrue(l.remove(9));
		assertEquals("5\t10\t6\t12\t11",l.toString());
		
		// Borro una clave con dos hijos 
		assertTrue(l.remove(5));
		assertEquals("6\t10\t11\t12",l.toString());
		
		// Borro una clave con dos hijos 
		assertTrue(l.remove(6));
		assertEquals("10\t12\t11",l.toString());
		
		// Borro una clave con dos hijos 
		assertTrue(l.remove(12));
		assertEquals("10\t11",l.toString());
		
		// Borro la raiz ([10,"tema1.pdf"]) 
		assertEquals(10,l.sacar());
		assertEquals("11",l.toString());
		
		// Borro la raiz ([11,"apuntes.pdf"]) 
		assertEquals(11,l.sacar());
				
	}	
	
	@Test
	void test_Add_Doc() {
		BinaryHeap<Documento> l = new BinaryHeap<Documento>(9);
		
		try {
			l.add(null);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("Element to insert is null.",e.getMessage());
		}
		
		// Inserta el elemento 8:trabajo.txt
		assertTrue(l.add(new Documento(8,"trabajo.txt")));
		assertEquals("[8:trabajo.txt]",l.toString());

		// Inserta el elemento 5:examen.pdf
		assertTrue(l.add(new Documento(5,"examen.pdf")));
		assertEquals("[5:examen.pdf]\t[8:trabajo.txt]",l.toString());
		
		// Inserta el elemento 10:tema1.pdf
		assertTrue(l.add(new Documento(10,"tema1.pdf")));
		assertEquals("[5:examen.pdf]\t[8:trabajo.txt]\t[10:tema1.pdf]",l.toString());
		
		// Inserta el elemento 2:calculos.xls
		assertTrue(l.add(new Documento(2,"calculos.xls")));
		assertEquals("[2:calculos.xls]\t[5:examen.pdf]\t[10:tema1.pdf]\t[8:trabajo.txt]",l.toString());
		
		// Inserta el elemento 1:notas.xls
		assertTrue(l.add(new Documento(1,"notas.xls")));
		assertEquals("[1:notas.xls]\t[2:calculos.xls]\t[10:tema1.pdf]\t[8:trabajo.txt]\t[5:examen.pdf]",l.toString());
		
		// Inserta el elemento 6:tema2.doc
		assertTrue(l.add(new Documento(6,"tema2.doc")));
		assertEquals("[1:notas.xls]\t[2:calculos.xls]\t[6:tema2.doc]\t[8:trabajo.txt]\t[5:examen.pdf]\t[10:tema1.pdf]",l.toString());
		
		// Inserta el elemento 12:tarea.txt
		assertTrue(l.add(new Documento(12,"tarea.txt")));
		assertEquals("[1:notas.xls]\t[2:calculos.xls]\t[6:tema2.doc]\t[8:trabajo.txt]\t[5:examen.pdf]\t[10:tema1.pdf]\t[12:tarea.txt]",l.toString());
		
		// Inserta el elemento 9:tema3.doc
		assertTrue(l.add(new Documento(9,"tema2.doc")));
		assertEquals("[1:notas.xls]\t[2:calculos.xls]\t[6:tema2.doc]\t[8:trabajo.txt]\t[5:examen.pdf]\t[10:tema1.pdf]\t[12:tarea.txt]\t[9:tema2.doc]",l.toString());		
		
		// Inserta el elemento 11:apuntes.pdf
		assertTrue(l.add(new Documento(11,"apuntes.pdf")));
		assertEquals("[1:notas.xls]\t[2:calculos.xls]\t[6:tema2.doc]\t[8:trabajo.txt]\t[5:examen.pdf]\t[10:tema1.pdf]\t[12:tarea.txt]\t[9:tema2.doc]\t[11:apuntes.pdf]",l.toString());		
		
		// No hay espacio
		try{
			assertTrue(l.add(new Documento(20,"cv.pdf")));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("La estructura está llena.",e.getMessage());
		}
		
		// Ya existe
		assertFalse(l.add(new Documento(11,"apuntes.pdf")));
	}

	@Test
	void test_Remove_Doc() {
		BinaryHeap<Documento> l = new BinaryHeap<Documento>(9);

		// Borro en en una cola vac�a
		assertFalse(l.remove(new Documento(8,"trabajo.txt")));
		
		// La clave es null
		try {
			l.remove(null);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("Element to insert is null.",e.getMessage());
		}

		
		// Inserta elemento3
		assertTrue(l.add(new Documento(8,"trabajo.txt")));
		assertTrue(l.add(new Documento(5,"examen.pdf")));
		assertTrue(l.add(new Documento(10,"tema1.pdf")));
		assertTrue(l.add(new Documento(2,"calculos.xls")));
		assertTrue(l.add(new Documento(1,"notas.xls")));
		assertTrue(l.add(new Documento(6,"tema2.doc")));
		assertTrue(l.add(new Documento(12,"tarea.txt")));
		assertTrue(l.add(new Documento(9,"tema2.doc")));
		assertTrue(l.add(new Documento(11,"apuntes.pdf")));
		assertEquals("[1:notas.xls]\t[2:calculos.xls]\t[6:tema2.doc]\t[8:trabajo.txt]\t[5:examen.pdf]\t[10:tema1.pdf]\t[12:tarea.txt]\t[9:tema2.doc]\t[11:apuntes.pdf]",l.toString());		
		
		// Borro la raiz ([1,"notas.xls"]) --> poll
		assertEquals(1,l.sacar().getPrioridad());
		assertEquals("[2:calculos.xls]\t[5:examen.pdf]\t[6:tema2.doc]\t[8:trabajo.txt]\t[11:apuntes.pdf]\t[10:tema1.pdf]\t[12:tarea.txt]\t[9:tema2.doc]",l.toString());
		
		// Borro una clave con un s�lo hijo --> [8,"trabajo.txt"]
		assertTrue(l.remove(new Documento(8,"trabajo.txt")));
		assertEquals("[2:calculos.xls]\t[5:examen.pdf]\t[6:tema2.doc]\t[9:tema2.doc]\t[11:apuntes.pdf]\t[10:tema1.pdf]\t[12:tarea.txt]",l.toString());
		
		// Borro una clave con dos hijos, la ra�z --> [2,"calculos.xls"]
		assertTrue(l.remove(new Documento(2,"calculos.xls")));
		assertEquals("[5:examen.pdf]\t[9:tema2.doc]\t[6:tema2.doc]\t[12:tarea.txt]\t[11:apuntes.pdf]\t[10:tema1.pdf]",l.toString());
		
		// Borro una clave con dos hijos --> [9,"tema2.doc"]
		assertTrue(l.remove(new Documento(9,"tema2.doc")));
		assertEquals("[5:examen.pdf]\t[10:tema1.pdf]\t[6:tema2.doc]\t[12:tarea.txt]\t[11:apuntes.pdf]",l.toString());
		
		// Borro una clave con dos hijos --> [5,"examen.pdf"]
		assertTrue(l.remove(new Documento(5,"examen.pdf")));
		assertEquals("[6:tema2.doc]\t[10:tema1.pdf]\t[11:apuntes.pdf]\t[12:tarea.txt]",l.toString());
		
		// Borro una clave con dos hijos --> [6:tema2.doc]
		assertTrue(l.remove(new Documento(6,"tema2.doc")));
		assertEquals("[10:tema1.pdf]\t[12:tarea.txt]\t[11:apuntes.pdf]",l.toString());
		
		// Borro un elemnto que no existe
		try{
			assertTrue(l.remove(new Documento(6,"tema2.doc")));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("El elemento no existe en la estructura.",e.getMessage());
		}
		
		// Borro una clave con dos hijos --> [12:tarea.txt]
		assertTrue(l.remove(new Documento(12,"tarea.txt")));
		assertEquals("[10:tema1.pdf]\t[11:apuntes.pdf]",l.toString());
		
		// Borro la raiz ([10,"tema1.pdf"]) --> poll
		assertEquals(10,l.sacar().getPrioridad());
		assertEquals("[11:apuntes.pdf]",l.toString());
		
		// Borro la raiz ([11,"apuntes.pdf"]) --> poll
		assertEquals(11,l.sacar().getPrioridad());
		
		// Borro en una cola vac�a
		assertFalse(l.remove(new Documento(12,"tarea.txt")));			
	}
}
