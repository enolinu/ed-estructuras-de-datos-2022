package hash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class ClosedHashTableSinRedispersionTest {

	@Test
	public void T1_testAddInt() {
		System.out.println("Pruebas con enteros");
		// Crea una tabla del tama�o 11
		ClosedHashTable<Integer> tabla = new ClosedHashTable<Integer>(11,1);
		// Muestra la tabla. Debera estar vacia y ser de tama�o 11
		System.out.println(tabla.toString());
		assertEquals("{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};[Size: 11 Num.Elems.: 0]",tabla.toString());
		
		// Inserta un null
		try {
			tabla.add(null);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			assertEquals("Element to insert is null.",e.getMessage());
		}

		// Inserta elementos
		assertTrue(tabla.add(8));
		assertTrue(tabla.add(10));
		System.out.println(tabla.toString());
		assertEquals("{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{8};{_E_};{10};[Size: 11 Num.Elems.: 2]",tabla.toString());
		
		assertTrue(tabla.add(66));
		System.out.println(tabla.toString());		
		assertEquals("{66};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{8};{_E_};{10};[Size: 11 Num.Elems.: 3]",tabla.toString());
		
		// Inserta elementos con colision
		assertTrue(tabla.add(77));
		System.out.println(tabla.toString());	
		assertEquals("{66};{77};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{8};{_E_};{10};[Size: 11 Num.Elems.: 4]",tabla.toString());

		assertTrue(tabla.add(88));
		System.out.println(tabla.toString());	
		assertEquals("{66};{77};{_E_};{_E_};{88};{_E_};{_E_};{_E_};{8};{_E_};{10};[Size: 11 Num.Elems.: 5]",tabla.toString());

		assertTrue(tabla.add(89));
		System.out.println(tabla.toString());
		assertEquals("{66};{77};{89};{_E_};{88};{_E_};{_E_};{_E_};{8};{_E_};{10};[Size: 11 Num.Elems.: 6]",tabla.toString());
		
		
		// Sigue insertando elementos
		assertTrue(tabla.add(3));
		assertTrue(tabla.add(6));
		assertTrue(tabla.add(7));
		assertTrue(tabla.add(20));
		assertTrue(tabla.add(16));
		System.out.println(tabla.toString());
		assertEquals("{66};{77};{89};{3};{88};{16};{6};{7};{8};{20};{10};[Size: 11 Num.Elems.: 11]",tabla.toString());
		
	}

	@Test
	public void T2_testRemoveInt() {
		System.out.println("Pruebas con enteros");
		// Crea una tabla del tamaño 11 
		ClosedHashTable<Integer> tabla = new ClosedHashTable<Integer>(11,1);
		// Inserta elementos
		assertTrue(tabla.add(8));
		assertTrue(tabla.add(10));
		assertTrue(tabla.add(66));
		assertTrue(tabla.add(77));
		assertTrue(tabla.add(88));
		assertTrue(tabla.add(89));
		assertTrue(tabla.add(3));
		assertTrue(tabla.add(6));
		assertTrue(tabla.add(7));
		assertTrue(tabla.add(20));
		assertTrue(tabla.add(16));
		System.out.println(tabla.toString());
		assertEquals("{66};{77};{89};{3};{88};{16};{6};{7};{8};{20};{10};[Size: 11 Num.Elems.: 11]",tabla.toString());

		//Borra un elemento que existe
		assertTrue(tabla.remove(7));
		System.out.println(tabla.toString());
		assertEquals("{66};{77};{89};{3};{88};{16};{6};{_D_};{8};{20};{10};[Size: 11 Num.Elems.: 10]",tabla.toString());
		
		// Borra un null
		try {
			tabla.remove(null);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			assertEquals("Element to insert is null.",e.getMessage());
		}
		
		//Borra un elemento que no existe
		try {
			tabla.remove(2);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			assertEquals("El elemento 2 no existe en la estructura",e.getMessage());
		}
		

		//Borrar elementos
		assertTrue(tabla.remove(77));
		System.out.println(tabla.toString());
		assertEquals("{66};{_D_};{89};{3};{88};{16};{6};{_D_};{8};{20};{10};[Size: 11 Num.Elems.: 9]",tabla.toString());

		assertTrue(tabla.remove(89));
		System.out.println(tabla.toString());
		assertEquals("{66};{_D_};{_D_};{3};{88};{16};{6};{_D_};{8};{20};{10};[Size: 11 Num.Elems.: 8]",tabla.toString());

		assertTrue(tabla.remove(88));
		System.out.println(tabla.toString());
		assertEquals("{66};{_D_};{_D_};{3};{_D_};{16};{6};{_D_};{8};{20};{10};[Size: 11 Num.Elems.: 7]",tabla.toString());

		assertTrue(tabla.remove(20));
		System.out.println(tabla.toString());	
		assertEquals("{66};{_D_};{_D_};{3};{_D_};{16};{6};{_D_};{8};{_D_};{10};[Size: 11 Num.Elems.: 6]",tabla.toString());
	
		// Inserta un elemento que ocupar�a una posisi�n ya borrada
		assertTrue(tabla.add(44));
		System.out.println(tabla.toString());	
		assertEquals("{66};{44};{_D_};{3};{_D_};{16};{6};{_D_};{8};{_D_};{10};[Size: 11 Num.Elems.: 7]",tabla.toString());
	}
	

}

