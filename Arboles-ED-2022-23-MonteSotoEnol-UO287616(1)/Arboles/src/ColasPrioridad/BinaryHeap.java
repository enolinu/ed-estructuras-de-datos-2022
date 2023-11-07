package ColasPrioridad;

import EXC.ElementNotPresentException;
import EXC.FullStructureException;

public class BinaryHeap <T extends Comparable<T>> {
	
	private static final int RAIZ  = 0;
	private T[] monticulo;
	private int numElementos;
	
	@SuppressWarnings("unchecked")
	
	public BinaryHeap(int n) {
		monticulo = (T[]) new Comparable[n];
		numElementos = 0;
	}
	
	/**
	 * Método que añade un elemento a la estructura.
	 * @param elemento, El elemento a añadir.
	 * @return true si lo añade, false en caso contrario, NullPointetException si
	 * se intenta añadir un elemento nulo.
	 */
	public boolean add(T elemento) {
		if(elemento == null) 
			throw new NullPointerException("Element to insert is null.");
		if(exist(elemento))
			return false;
		if(numElementos >= monticulo.length) 
			throw new FullStructureException("La estructura está llena.");
		monticulo[numElementos] = elemento;
		numElementos++;
		filtradoAscendente(numElementos-1);
		return true;
	}
	
	/**
	 * Método que saca el elemento de máxima prioridad de la cola
	 * y actualiza la estructura.
	 * @return elementoASacar, El elemento que se extrajo de la cola.
	 */
	public T sacar() {
		T elementoASacar = monticulo[0];
		monticulo[0] = monticulo[numElementos-1];
		numElementos--;
		filtradoDescendente(0);
		return elementoASacar;
		
	}
	
	/**
	 * Método que elimina un elemento de la estructura.
	 * @param elemento, El elemento a eliminar.
	 * @return true si se eliminó correctamente, false en caso contrario, ElementNotPresentException
	 * si se intenta eliminar un elemento no presente en la estructura.
	 */
	public boolean remove(T elemento) {
		if(numElementos == 0) {
			return false;
		}
		int posElementoABorrar = -1;
		for(int i=0; i<numElementos; i++) {
			if(elemento.compareTo(monticulo[i]) == 0) {
				posElementoABorrar = i;
				break;
			}
		}
		if(posElementoABorrar == -1) {
			throw new ElementNotPresentException("El elemento no existe en la estructura.");
		}
		T elementoABorrar = monticulo[posElementoABorrar];
		monticulo[posElementoABorrar] = monticulo[numElementos-1];
		numElementos--;
		if(monticulo[posElementoABorrar].compareTo(elementoABorrar) < 0) {
			filtradoAscendente(posElementoABorrar);
		}
		if(monticulo[posElementoABorrar].compareTo(elementoABorrar) > 0) {
			filtradoDescendente(posElementoABorrar);
		}
		return true;
	}
	
	/**
	 * Método que comprueba si la cola está vacía.
	 * @return true si la ola está vacía, false en caso contrario.
	 */
	public boolean isEmpty() {
		for(int i=0; i<numElementos; i++) {
			if(monticulo[i] != null) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Método que limpia la estructura, eliminando todos los elementos de la misma.
	 */
	public void clear() {
		for(int i=0; i<numElementos; i++) {
			monticulo[i] = null;
		}
		numElementos = 0;
	}
	
	/**
	 * Método que cambia la prioridad del elemento que se pasa por parámetro.
	 * @param pos, La posición.
	 * @param elemento, El elemento.
	 * @return true si se ha realizado la operación correctamente, false en caso contrario.
	 */
	public boolean cambiarPrioridad(int pos, T elemento) {
		T elementoACambiar = monticulo[pos];
		if(elemento.compareTo(elementoACambiar) > 0) {
			filtradoAscendente(pos);
		}
		if(elemento.compareTo(elementoACambiar) < 0) {
			filtradoDescendente(pos);
		}
		return true;
	}
	
	// Filtrados y métodos auxiliares.
	
	private void filtradoAscendente(int n) {
		int posPadre = (n-1)/2;
		if(n >= RAIZ) {
			if(monticulo[posPadre].compareTo(monticulo[n]) > 0) {
				swap(n, posPadre);
				filtradoAscendente(posPadre);
			}
		}
	}
	
	private void filtradoDescendente(int n) {
		int posHijo1 = 2*n+1;
		int posHijo2 = 2*n+2;
		System.out.println(" Hijo1: "+posHijo1+" Hijo2: "+posHijo2+" numElementos: "+numElementos);
		if(n >= numElementos || (posHijo1 >= numElementos && posHijo2 >= numElementos)) {
			return;
		}
		if(posHijo1 >= numElementos) {
			if(posHijo2 < numElementos && monticulo[posHijo2].compareTo(monticulo[n]) < 0) {
				swap(n, posHijo2);
				filtradoDescendente(posHijo2);
				return;
			}
		}
		if(posHijo2 >= numElementos) {
			if(posHijo1 < numElementos && monticulo[posHijo1].compareTo(monticulo[n]) < 0) {
				swap(n, posHijo1);
				filtradoDescendente(posHijo1);
				return;
			}
		}
		if(monticulo[posHijo1].compareTo(monticulo[posHijo2]) < 0) {
			if(posHijo1 < numElementos && monticulo[posHijo1].compareTo(monticulo[n]) < 0) {
				swap(n, posHijo1);
				filtradoDescendente(posHijo1);
			}
		} else {
			if(posHijo2 < numElementos && monticulo[posHijo2].compareTo(monticulo[n]) < 0) {
				swap(n, posHijo2);
				filtradoDescendente(posHijo2);
			}
		}
	}
	
	private void swap(int posA, int posB) {
		T aux = monticulo[posA];
		monticulo[posA] = monticulo[posB];
		monticulo[posB] = aux;
	}
	
	/**
	 * Método que devuelve una cadena de caracteres representativa del montículo.
	 * @return cadena, Cadena de caracteres con los elementos del montículo separados por tabuladores.
	 */
	@Override
	public String toString() {
		String cadena = "";
		for(int i=0; i<numElementos; i++) {
			if(i != numElementos-1) {
				cadena = cadena + monticulo[i]+"\t";
			} else {
				cadena = cadena + monticulo[i];
			}
		}
		return cadena;
	}
	
	private boolean exist(T elemento) {
		for(int i=0; i<numElementos; i++) {
			if(elemento.compareTo(monticulo[i]) == 0)
				return true;
		}
		return false;
	}
}
