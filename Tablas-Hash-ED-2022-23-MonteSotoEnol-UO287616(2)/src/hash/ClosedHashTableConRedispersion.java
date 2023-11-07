package hash;

import static org.junit.Assert.*;

import org.junit.Test;


public class ClosedHashTableConRedispersion {

	@Test
	public void T1_testAddRemoveInt() {
		System.out.println("Pruebas con enteros");
		//Crea una tabla del tama�o 4 (numero no primo)
		ClosedHashTable<Integer> tabla = new ClosedHashTable<Integer>(4,1,0.16,0.5);
		//Muestra la tabla. Debera estar vacia y ser de tama�o 5
		System.out.println(tabla.toString());
		assertEquals("{_E_};{_E_};{_E_};{_E_};{_E_};[Size: 5 Num.Elems.: 0]",tabla.toString());
		
		// Inserta un null
		try {
			tabla.add(null);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			assertEquals("Element to insert is null.",e.getMessage());
		}

		//Inserta elementos
		assertTrue(tabla.add(8));
		assertTrue(tabla.add(10));
		System.out.println(tabla.toString());
		assertEquals("{10};{_E_};{_E_};{8};{_E_};[Size: 5 Num.Elems.: 2]",tabla.toString());

		
		//Inserta y redispersi�n
		assertTrue(tabla.add(66));
		System.out.println(tabla.toString());		
		assertEquals("{66};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{8};{_E_};{10};[Size: 11 Num.Elems.: 3]",tabla.toString());
		
		//Sigue insertando elementos
		assertTrue(tabla.add(77));
		System.out.println(tabla.toString());
		assertTrue(tabla.add(7));
		
		//Inserta y redispersi�n
		assertTrue(tabla.add(9));
		System.out.println(tabla.toString());
		assertEquals("{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{7};{77};{8};{9};{10};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{66};{_E_};{_E_};[Size: 23 Num.Elems.: 6]",tabla.toString());
		
		//Sigue insertando elementos
		assertTrue(tabla.add(88));
				
		//Borra un elemento que existe
		
		assertTrue(tabla.remove(8));
		System.out.println(tabla.toString());
		assertEquals("{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{7};{77};{_D_};{9};{10};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{88};{66};{_E_};{_E_};[Size: 23 Num.Elems.: 6]",tabla.toString());
				
		//Sigue insertando elementos
		assertTrue(tabla.add(13));
		assertTrue(tabla.add(19));
		
		//Inserta elemetos que ya existen
		assertTrue(tabla.add(66));
		assertTrue(tabla.add(88));
		
		//Borra un elemento que no existe
		try {
			tabla.remove(2);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			assertEquals("El elemento 2 no existe en la estructura",e.getMessage());
		}
		
		// Borra un null
		try {
			tabla.remove(null);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			assertEquals("Element to insert is null.",e.getMessage());
		}

		//Borrar elementos
		System.out.println(tabla.toString());
		assertTrue(tabla.remove(19));
		assertTrue(tabla.remove(7));
		assertTrue(tabla.remove(77));
		assertTrue(tabla.remove(9));
		System.out.println(tabla.toString());	
	
		//Borra 
		assertTrue(tabla.remove(10));
		assertTrue(tabla.remove(13));
		assertTrue(tabla.remove(88));
		System.out.println(tabla.toString());	
		assertEquals("{88};{66};{_E_};{_E_};{66};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};[Size: 11 Num.Elems.: 3]",tabla.toString());
		
		assertTrue(tabla.add(-3));
		System.out.println(tabla.toString());	
		assertEquals("{88};{66};{_E_};{_E_};{66};{_E_};{_E_};{_E_};{-3};{_E_};{_E_};[Size: 11 Num.Elems.: 4]",tabla.toString());
}
	
	@Test
	public void T2_testAddRemoveCadenas() {
		System.out.println("\n\nPruebas con cadenas");
		//Crea una tabla del tama�o 4 (numero no primo)
		ClosedHashTable<String> hashTable = new ClosedHashTable<String>(4,0,0.16,0.5);
		//Muestra la tabla. Debera estar vacia y ser de tama�o 5
		assertEquals("{_E_};{_E_};{_E_};{_E_};{_E_};[Size: 5 Num.Elems.: 0]",hashTable.toString());
		System.out.println(hashTable.toString());
		//Inserta elementos
		assertTrue(hashTable.add("Pedro")); 
		assertTrue(hashTable.add("Marta")); 
		System.out.println(hashTable.toString());
		assertEquals("{_E_};{Pedro};{Marta};{_E_};{_E_};[Size: 5 Num.Elems.: 2]",hashTable.toString());
		
		
		//Inserta y redispersi�n
		assertTrue(hashTable.add("Leo")); 
		System.out.println(hashTable.toString());
		assertEquals("{_E_};{_E_};{_E_};{_E_};{Leo};{_E_};{_E_};{Pedro};{Marta};{_E_};{_E_};[Size: 11 Num.Elems.: 3]",hashTable.toString());
				
		
		//Sigue insertando elementos
		assertTrue(hashTable.add("Lucia")); 
		assertTrue(hashTable.add("Eva")); 
		
		//Inserta y redispersi�n
		assertTrue(hashTable.add("Luis")); 
		System.out.println(hashTable.toString());
		assertEquals("{_E_};{Pedro};{_E_};{_E_};{_E_};{_E_};{Eva};{_E_};{Lucia};{_E_};{Leo};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{Marta};{_E_};{_E_};{Luis};{_E_};[Size: 23 Num.Elems.: 6]",hashTable.toString());
		
		
		//Sigue insertando elementos
		assertTrue(hashTable.add("Jose")); 	
		System.out.println(hashTable.toString());
		
		//Borra un elemento que existe
		assertTrue(hashTable.remove("Jose")); 
		System.out.println(hashTable.toString());
		
		//Sigue insertando elementos
		assertTrue(hashTable.add("Lia")); 
		assertTrue(hashTable.add("Eli")); 
		assertTrue(hashTable.add("aLi")); 
		System.out.println(hashTable.toString());
		
	
		//Borra un elemento que no existe
		try {
			hashTable.remove("Alejandro");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			assertEquals("El elemento Alejandro no existe en la estructura",e.getMessage());
		}
		
		//Borrar elementos
		assertTrue(hashTable.remove("Eli"));
		assertTrue(hashTable.remove("Lia"));
		assertTrue(hashTable.remove("Marta"));
		assertTrue(hashTable.remove("Luis"));
		
		//Borra y redispersi�n inversa
		assertTrue(hashTable.remove("Eva"));
		System.out.println(hashTable.toString());
		assertEquals("{_E_};{Pedro};{_E_};{_D_};{_E_};{_D_};{_D_};{_E_};{Lucia};{_E_};{Leo};{_E_};{_E_};{_D_};{_E_};{_E_};{_E_};{_E_};{_D_};{_E_};{_E_};{_D_};{aLi};[Size: 23 Num.Elems.: 4]",hashTable.toString());
		
		
		//Inserta un elemento que ya est�
		assertTrue(hashTable.add("Lucia"));
		System.out.println(hashTable.toString());
		assertEquals("{_E_};{Pedro};{_E_};{_D_};{_E_};{_D_};{_D_};{_E_};{Lucia};{Lucia};{Leo};{_E_};{_E_};{_D_};{_E_};{_E_};{_E_};{_E_};{_D_};{_E_};{_E_};{_D_};{aLi};[Size: 23 Num.Elems.: 5]",hashTable.toString());

		//Borra Pedro y Lucia y redispensi�n inversa
		assertTrue(hashTable.remove("Pedro"));
		assertTrue(hashTable.remove("Lucia"));
		System.out.println(hashTable.toString());
		assertEquals("{aLi};{_E_};{Lucia};{_E_};{Leo};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};[Size: 11 Num.Elems.: 3]",hashTable.toString());
		
		//Borra Leo y aLi y redispensi�n inversa
		assertTrue(hashTable.remove("Leo"));
		assertTrue(hashTable.remove("aLi"));
		System.out.println(hashTable.toString());
		assertEquals("{_E_};{_E_};{_E_};{_E_};{Lucia};[Size: 5 Num.Elems.: 1]",hashTable.toString());
	}
}
