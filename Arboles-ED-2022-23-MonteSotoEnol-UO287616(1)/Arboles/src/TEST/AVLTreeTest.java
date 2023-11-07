package TEST;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import AVL.AVLTree;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class AVLTreeTest {

	@Test
	void T1_addNode() {
		AVLTree<Integer> b = new AVLTree<Integer>();

		// 5, 18 10 -- RDD(10)
		assertTrue(b.addNode(5));
		assertTrue(b.addNode(18));
		assertTrue(b.addNode(10));
		assertEquals("5:BF=0\t10:BF=0\t18:BF=0",b.inOrder());
		
		// 40, 50 -- RSD(18)
		assertTrue(b.addNode(40));
		assertTrue(b.addNode(50));
		System.out.println(b.toString());
		assertEquals("5:BF=0\t10:BF=1\t18:BF=0\t40:BF=0\t50:BF=0",b.inOrder());
		
		
		// 15 -- RDD(10)
		assertTrue(b.addNode(15));
		assertEquals("5:BF=0\t10:BF=0\t15:BF=0\t18:BF=0\t40:BF=1\t50:BF=0",b.inOrder());
		
		// 16 
		assertTrue(b.addNode(16));
		assertEquals("5:BF=0\t10:BF=1\t15:BF=1\t16:BF=0\t18:BF=-1\t40:BF=1\t50:BF=0",b.inOrder());
		
		// 12 
		assertTrue(b.addNode(12));
		assertEquals("5:BF=0\t10:BF=1\t12:BF=0\t15:BF=0\t16:BF=0\t18:BF=-1\t40:BF=1\t50:BF=0",b.inOrder());
		
		// 14 -- RDD(10)
		assertTrue(b.addNode(14));
		assertEquals("5:BF=0\t10:BF=-1\t12:BF=0\t14:BF=0\t15:BF=0\t16:BF=0\t18:BF=-1\t40:BF=1\t50:BF=0",b.inOrder());
		
		// 17 -- RDI(18)
		assertTrue(b.addNode(17));
		assertEquals("5:BF=0\t10:BF=-1\t12:BF=-1\t14:BF=0\t15:BF=0\t16:BF=1\t17:BF=0\t18:BF=0\t40:BF=1\t50:BF=0",b.inOrder());
		
		// Inserta un nodo null
		try {
			b.addNode(null);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("No se admiten valores nulos",e.getMessage());
		}

		// Inserta un elemento que ya existe
		assertFalse(b.addNode(15));
	}
	
	@Test
	public void T2_searchNode() {
		AVLTree<Integer> b = new AVLTree<Integer>();
		
		//Buscar en un árbol vacío
		assertNull(b.searchNode(50));
		
		assertTrue(b.addNode(10));
		assertTrue(b.addNode(100));
		assertTrue(b.addNode(60));
		assertTrue(b.addNode(30));
		assertTrue(b.addNode(2));
		assertTrue(b.addNode(-43));
		assertTrue(b.addNode(70));
		assertTrue(b.addNode(90));
		assertTrue(b.addNode(23));
		assertTrue(b.addNode(43));
		assertTrue(b.addNode(65));
		assertTrue(b.addNode(13));
		assertTrue(b.addNode(230));
		assertTrue(b.addNode(49));
		assertTrue(b.addNode(7));
		assertTrue(b.addNode(40));
		assertTrue(b.addNode(50));
		assertTrue(b.addNode(20));
		assertTrue(b.addNode(15));
		assertTrue(b.addNode(3));
		
		//Busca un nodo que no existe
		assertNull(b.searchNode(500));
		
		//Buscar un nodo
		assertEquals(b.searchNode(15).getInfo(), new Integer(15));
		assertEquals(b.searchNode(43).getInfo(), new Integer(43));
	}

	@Test
	void T3_removeNode() {
		AVLTree<Integer> b = new AVLTree<Integer>();
		//Intenta borrar de un árbol vacío
		assertFalse(b.removeNode(50));
		
		// Insertar 5, 18 10, 40, 50, 15, 16, 12, 14, 17
		b.addNode(5);
		b.addNode(18);
		b.addNode(10);
		b.addNode(40);
		b.addNode(50);
		b.addNode(15);
		b.addNode(16);
		b.addNode(12);
		b.addNode(14);
		b.addNode(17);
		assertEquals("5:BF=0\t10:BF=-1\t12:BF=-1\t14:BF=0\t15:BF=0\t16:BF=1\t17:BF=0\t18:BF=0\t40:BF=1\t50:BF=0",b.inOrder());
		
		// Borrar un nodo null
		try {
			b.removeNode(null);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			assertEquals("No se admiten valores nulos",e.getMessage());
		}
		
		//Borra un nodo que no existe
		//assertFalse(b.removeNode(500));
		
		// Borra una clave sin hijos --> 50
		assertTrue(b.removeNode(50));
		assertEquals("5:BF=0\t10:BF=-1\t12:BF=-1\t14:BF=0\t15:BF=0\t16:BF=1\t17:BF=0\t18:BF=-1\t40:BF=0",b.inOrder());
		
		// Borra un elemento que no existe
		assertFalse(b.removeNode(50));
		
		// Borra una clave con un hijo izquierdo --> 10
		assertTrue(b.removeNode(10));
		assertEquals("5:BF=0\t12:BF=0\t14:BF=0\t15:BF=1\t16:BF=1\t17:BF=0\t18:BF=-1\t40:BF=0",b.inOrder());
	
		// Borra la raíz que tiene dos hijos --> 15
		assertTrue(b.removeNode(15));
		assertEquals("5:BF=0\t12:BF=-1\t14:BF=1\t16:BF=1\t17:BF=0\t18:BF=-1\t40:BF=0",b.inOrder());
	
		// Borra la raíz que tiene dos hijos --> 14
		assertTrue(b.removeNode(14));
		assertEquals("5:BF=0\t12:BF=-1\t16:BF=0\t17:BF=0\t18:BF=0\t40:BF=0",b.inOrder());
		
		// Borra una clave que es hoja --> 17
		assertTrue(b.removeNode(17));
		assertEquals("5:BF=0\t12:BF=-1\t16:BF=0\t18:BF=1\t40:BF=0",b.inOrder());
		
		// Borra una clave que tiene un hijo derecho --> 18
		assertTrue(b.removeNode(18));
		assertEquals("5:BF=0\t12:BF=-1\t16:BF=-1\t40:BF=0",b.inOrder());
		
		// Borra una clave que es hoja --> 40
		assertTrue(b.removeNode(40));
		assertEquals("5:BF=0\t12:BF=0\t16:BF=0",b.inOrder());
		
		// Borra la raíz que tiene dos hijos --> 12
		assertTrue(b.removeNode(12));
		assertEquals("5:BF=1\t16:BF=0",b.inOrder());
		
		// Borra un hijo que es hoja --> 16
		assertTrue(b.removeNode(16));
		assertEquals("5:BF=0",b.inOrder());
		
		// Borra la raíz que no tiene hijos
		assertTrue(b.removeNode(5));
		
		// Borra el 5 que no existe
		assertFalse(b.removeNode(5));
	}
}
