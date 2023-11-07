package hash;

import java.lang.reflect.Array;

public class ClosedHashTable<T> extends AbstractHash<T> {
	
	private final static int LINEAL = 0;
	private final static int CUADRATICA = 1;
	private final static int DISPERSION_DOBLE = 2;
	
	//private static final double MINIMUM_LF = 0.16;
	//private static final double MAXIMUM_LF = 0.5;

	
	private HashNode<T> tabla[];
	private int hashSize;
	private int numElementos;
	private int tipoExploracion;
	private double minlf;
	private double maxlf;
	
	/**
	 * Método constructor con los parámetros tamaño y tipo de dispersión.
	 * @param tam
	 * @param tipo
	 */
	@SuppressWarnings("unchecked")
	public ClosedHashTable(int tam, int tipo) {
		this.numElementos = 0;
		this.hashSize = tam;
		this.tipoExploracion = tipo;
		if(!isPositivePrime(tam)) {
			tam = nextPrimeNumber(tam);
			hashSize = tam;
		}
		this.tabla = (HashNode<T>[])Array.newInstance(HashNode.class, tam);
		for(int i=0; i<tam; i++) {
			tabla[i] = new HashNode<T>();
		}
	}
	
	/**
	 * Método constructor con los parámetros tamaño, tipo de dispersión y límites del factor de carga.
	 * @param tam
	 * @param tipo
	 * @param minlf
	 * @param maxlf
	 */
	@SuppressWarnings("unchecked")
	public ClosedHashTable(int tam, int tipo, double minlf, double maxlf) {
		this.numElementos = 0;
		this.hashSize = tam;
		this.tipoExploracion = tipo;
		this.minlf = minlf;
		this.maxlf = maxlf;
		if(!isPositivePrime(tam)) {
			tam = nextPrimeNumber(tam);
			hashSize = tam;
		}
		this.tabla = (HashNode<T>[])Array.newInstance(HashNode.class, tam);
		for(int i=0; i<tam; i++) {
			tabla[i] = new HashNode<T>();
		}
	}

	/**
	 * Método que devuelve el número de elementos de la tabla.
	 * @return Numero de elementos de la tabla.
	 */
	@Override
	public int getNumOfElems() {
		return this.numElementos;
	}
	
	/**
	 * Método que devuelve el tamaño de la tabla.
	 * @return Tamaño de la tabla.
	 */
	@Override
	public int getSize() {
		return this.hashSize;
	}

	/**
	 * Método que añade un elemento a la estructura.
	 * @param El elemento a añadir.
	 * @return true si se añade satisfactoriamente, false en caso contrario, NullPointerException si se le pasa un parámetro nulo.
	 */
	@Override
	public boolean add(T elemento) {
		if(elemento == null) {
			throw new NullPointerException("Element to insert is null.");
		}	
		numElementos++;
		System.out.println("Se añadió el elemento: "+elemento+" numero "+numElementos
						   +" fHash: "+fHash(elemento) +" Size: "+getSize());
		int posicion = fHash(elemento);
		int intento = 0;
		while(tabla[posicion].getEstado() == HashNode.LLENO) {
			posicion = calcularPosicion(fHash(elemento), intento);
			intento++;
			System.out.println("Posicion: "+posicion+" Intento: "+intento);
		}
		
		tabla[posicion].setInfo(elemento);
		reDispersion();
		return true;
	}
	
	/**
	 * Método que busca un elemento de la esructura.
	 * @param El elemento a buscar.
	 * @return El elemento, si lo encuentra, null si no, NullPointerException si se le pasa un parámetro nulo.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T find(T elemento) {
		return (T) tabla[findPos(elemento)];
	}
	
	/**
	 * Método que elimina un elemento de la tabla hash.
	 * @param El elemento a eliminar.
	 * @return true si se elimina satisfactoriamente, false en caso contrario, NullPointerException si se le pasa un parámetro nulo.
	 */
	@Override
	public boolean remove(T elemento) {
		if(elemento == null) {
			throw new NullPointerException("Element to insert is null.");
		}
		int posicion = findPos(elemento);
		if(posicion >= 0) {
			tabla[posicion].setEstado(HashNode.BORRADO);
			numElementos--;
			inverseRedispersion();
		} else {
			return false;
		}
		return true;
	}
	
	private int findPos(T elemento) {
		int posicion = fHash(elemento);
		int intento = 0;
		while(tabla[posicion].getEstado() != HashNode.VACIO && intento < hashSize && !tabla[posicion].getInfo().equals(elemento)) {
			posicion = calcularPosicion(fHash(elemento), intento);
			System.out.println(posicion+"->"+tabla[posicion].getInfo()+" "+ elemento);
			intento++;
		}
		System.out.println(posicion);
		if(tabla[posicion].getEstado() == HashNode.LLENO && tabla[posicion].getInfo().equals(elemento)) {
			return posicion;
		} else {
			return -1;
		}
	}
	
	/**
	 * Método que devuelve una cadena representativa de la tabla.
	 * @return cadena
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		for (int i = 0; i < getSize(); i++) {
			cadena.append(tabla[i]);
			cadena.append(";");
		}
		cadena.append("[Size: ");
		cadena.append(getSize());
		cadena.append(" Num.Elems.: ");
		cadena.append(getNumOfElems());
		cadena.append("]");
		return cadena.toString();
	}
	
	private int calcularPosicion(int posicion, int intento) {
		if(tipoExploracion == LINEAL) {
			posicion = (posicion + intento) % hashSize;
		}
		if(tipoExploracion == CUADRATICA) {
			posicion = (int)((posicion + Math.pow(intento, 2)) % hashSize);
		}
		if(tipoExploracion == DISPERSION_DOBLE) {
			posicion = (int) (posicion + intento * 2) % hashSize;
		}
		return posicion;
	}

	// Redispersión.
	@SuppressWarnings("unchecked")
	@Override
	protected void reDispersion() {
		if((double)(numElementos)/hashSize > maxlf) {
			HashNode<T>[] tablaAux = tabla;
			int nuevoTamano = nextPrimeNumber(hashSize*2);
			this.tabla = (HashNode<T>[])Array.newInstance(HashNode.class, nuevoTamano);
			for(int i=0; i<nuevoTamano; i++) {
				tabla[i] = new HashNode<T>();
			}
			numElementos = 0;
			hashSize = nuevoTamano;
			for(int i=0; i<tablaAux.length; i++) {
				if(tablaAux[i].getEstado() == HashNode.LLENO) {
					add(tablaAux[i].getInfo());
				}
			}
		}
		
		
	}
	
	// Redispersión inversa.
	@SuppressWarnings("unchecked")
	@Override
	protected void inverseRedispersion() {
		System.out.println((double)numElementos/hashSize);
		if((double)numElementos/hashSize < minlf) {
			HashNode<T>[] tablaAux = tabla;
			int nuevoTamano = previousPrimeNumber(hashSize/2+1);
			this.tabla = (HashNode<T>[])Array.newInstance(HashNode.class, nuevoTamano);
			for(int i=0; i<nuevoTamano; i++) {
				tabla[i] = new HashNode<T>();
			}
			System.out.println(nuevoTamano);
			numElementos = 0;
			hashSize = nuevoTamano;
			for(int i=0; i<tablaAux.length; i++) {
				if(tablaAux[i].getEstado() == HashNode.LLENO) {
					add(tablaAux[i].getInfo());
				}
			}
		}
		
		
	}
}
