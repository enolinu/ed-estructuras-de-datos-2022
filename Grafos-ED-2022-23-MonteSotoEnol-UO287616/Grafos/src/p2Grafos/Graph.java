package p2Grafos;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Proyecto De Grafos - Estructuras de datos | EII 2022
 * @author Enol Monte Soto (Grupo PL-06)
 * @param <T>, el tipo de dato que maneja el grafo (genérico).
 */
public class Graph<T> {
	
	final double INFINITO = Double.POSITIVE_INFINITY;
	
	private T[] nodos; // Contenido de cada nodo.
	private boolean[][] ejes; // Filas = origen, Columnas = destino.
	private double[][] pesos; // Pesos de los ejes (>0)
	int numNodos; // Número de nodos insertados hasta el momento.
	
	private double[][] A;
	private int[][] P;
	
	
	
	/**
	 * Método constructor de la clase. Inicializa el tamaño del grafo.
	 * Crea los arrays que definen los pesos y los ejes con el tamaño del grafo.
	 * @param n, dimensión de los arrays creados para los ejes y pesos.
	 */
	@SuppressWarnings("unchecked")
	public Graph(int n) {
		
		nodos = (T[]) new Object[n];
		ejes = new boolean[n][n];
		pesos = new double[n][n];
		numNodos = 0;
		
	}
	
	/**
	 * Método que devuelve la posición donde se encuentra el nodo que queremos buscar.
	 * @param nodo, el nodo a buscar.
	 * @return Posición del nodo, -1 si no existe.
	 */
	protected int getNode(T nodo) {
		
		for(int i=0; i<numNodos; i++) {
			if(!(nodo.equals(null)) && nodo.equals(nodos[i])) { // IMPORTANTE verificar que no sea null antes de comparar con equals.
				return i;
			}
		}
		
		return -1;
	}
	
	
	/**
	 * Método que añade un nodo al grafo, creando los valores por defecto "INFINITO" y "false"
	 * en su posición de las matrices de pesos y ejes respectivamente. 
	 * @param nodo, el nodo a añadir, de tipo genérico.
	 * @return true si lo inserta correctamente, si no cabe lanza una excepción de tipo "FullStructureException",
	 * si el nodo es nulo lanza un "NullPointerException" y si ya existe devuelve false.
	 */
	public boolean addNode(T nodo) {
		
		if(nodo == null) {
			throw new NullPointerException("El elemento a añadir es nulo.");
		}
		
		if(existNode(nodo)) {
			return false;
		}
	
		if(numNodos == nodos.length) {
			throw new FullStructureException(nodo);
		}
		
		// Actualizamos las matrices de pesos y ejes así como el vector de nodos.
		nodos[numNodos] = nodo;
		pesos[numNodos][numNodos] = INFINITO;
		ejes[numNodos][numNodos] = false;
		
		// Incrementamos la variable que indica el número de nodos.
		numNodos++;
		return true;
	}
	
	/**
	 * Método que elimina un nodo del grafo.
	 * @param nodo, el nodo a eliminar, de tipo genérico.
	 * @return true si lo elimina correctamente, false si no existe y NullPointerException si es null.
	 */
	public boolean removeNode(T nodo) {
		
		// Si el nodo es nulo salta excepci�n NullPointerException.
		if(nodo == null) {
			throw new NullPointerException("Element to insert is null.");
		}
		
		// Comprobamos que existe el nodo en el grafo.
		if(!existNode(nodo)) {
			return false;
		}
		
		T ultimoNodo;
		int posNodoABorrar = getNode(nodo); 
		ultimoNodo = nodos[numNodos-1];
		int posicionUltimoNodo = numNodos-1;
		
		numNodos--;
		
		for(int i=0; i<=numNodos; i++) {
			
			ejes[posNodoABorrar][i] = ejes[posicionUltimoNodo][i];
			ejes[i][posNodoABorrar] = ejes[i][posicionUltimoNodo];
			pesos[posNodoABorrar][i] = pesos[posicionUltimoNodo][i];
			pesos[i][posNodoABorrar] = pesos[i][posicionUltimoNodo];
			
		}
		
		ejes[posNodoABorrar][posNodoABorrar] = ejes[posicionUltimoNodo][posicionUltimoNodo];
		pesos[posNodoABorrar][posNodoABorrar] = pesos[posicionUltimoNodo][posicionUltimoNodo];
		
		nodos[posNodoABorrar] = ultimoNodo;
		nodos[numNodos] = null;
		
		return true;
	}
	
	/**
	 * Método que añade un eje al grafo. 
	 * @param origen, El nodo origen
	 * @param destino, El nodo destino
	 * @param peso, El peso
	 * @return true si lo inserta correctamente, IllegalArgumentException si el peso es negativo, ElementNotPresentException si alguno de los 2 nodos no existe o es null, false si ya existe.
	 */
	public boolean addEdge(T origen, T destino, double peso) {
		
		// Comprobamos que no sea "null" ninguno de los dos nodos a asociar.
		if(origen == null || origen == null) {
			throw new NullPointerException("El elemento a añadir es nulo.");
		}
		if(!existNode(origen)) {
			throw new ElementNotPresentException(origen);
		}
		
		if(!existNode(destino)) {
			throw new ElementNotPresentException(destino);
		}
		
		// Verifica que no existe ya el eje a añadir.
		if(existEdge(origen,   destino)) {
			return false;
		}
		
		// Comprueba que el peso no sea negativo.
		if(peso < 0) {
			throw new IllegalArgumentException("Los pesos negativos no son válidos");
		}
		
		// Actualizamos las matrices de pesos y de asociaciones.
		pesos[getNode(origen)][getNode(destino)] = peso;
		ejes[getNode(origen)][getNode(destino)] = true;
		return true;
	}
	
	/**
	 * Método que elimina un eje del grafo.
	 * @param origen
	 * @param destino
	 * @return  ElementNotPresentException si alguno de los no nodos existe o  NullPointerException si es null, false si no existe el eje.
	 */
	public boolean removeEdge(T origen, T destino) {
		
		// Comprobamos que no sea "null" ninguno de los dos nodos.
		if(origen == null || destino == null) {
			throw new NullPointerException("Element to insert is null.");
		}
		
		// Comprobamos ámbos nodos (origen y destino) están en la estructura.
		if(!existNode(origen)) {
			throw new ElementNotPresentException(origen);
		}
		
		if(!existNode(destino)) {
			throw new ElementNotPresentException(destino);
		}
		
		// Comprobamos que el eje exista.
		if(!existEdge(origen, destino) ) {
			return false;
		}
		
		// Eliminamos el eje de la matriz de ejes y hacemos que el peso del origen al destino sea infinito.
		pesos[getNode(origen)][getNode(destino)] = INFINITO;
		ejes[getNode(origen)][getNode(destino)] = false;
		return true;
		
		
	}
	
	/**
	 * Método que devuelve el peso del eje del grafo que une el origen con el destino.
	 * @param origen
	 * @param destino
	 * @return El peso del eje del grafo que une el origen con el destino, -1 si no existe o es null.
	 */
	public int getEdge(T origen, T destino) {
		
		// Comprobamos que ámbos nodos (origen y destino) existen en la estructura.
		if(!existNode(origen)) {
			throw new ElementNotPresentException(origen);
		}
		
		if(!existNode(destino)) {
			throw new ElementNotPresentException(destino);
		}
		
		// Comprobamos que existe el eje que queremos obtener.
		if(!ejes[getNode(origen)][getNode(destino)]) {
			return -1;
		}
		
		// Si todo es correcto, devuelve el peso del eje como entero.
		return (int)pesos[getNode(origen)][getNode(destino)];
	}
	
	
	/**
	 * Método que indica si existe en la estructura el nodo que se pasa por parámetro.
	 * @param nodo
	 * @return true si existe, false en cualquier otro caso.
	 */
	public boolean existNode(T nodo) {
		for(int i=0; i<numNodos; i++) {
			if(!(nodo.equals(null)) && nodo.equals(nodos[i])) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que indica si existe en la estructura el eje entre dos nodos pasados como parámetro.
	 * @param origen, destino
	 * @return true si existe, false en cualquier otro caso.
	 */
	public boolean existEdge(T origen, T destino)  {
		if(ejes[getNode(origen)][getNode(destino)]) {
			return true;
		}
		return false;
	}
	
	/**
	 * @return Devuelve un String con la informacion del grafo
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		String cadena = "";

		cadena += "VECTOR NODOS\n";
		for (int i = 0; i < numNodos; i++) {
			cadena += nodos[i].toString() + "\t";
		}
		cadena += "\n\nMATRIZ ARISTAS\n";
		for (int i = 0; i < numNodos; i++) {
			for (int j = 0; j < numNodos; j++)
				if (ejes[i][j])
					cadena += "T\t";
				else
					cadena += "F\t";
			cadena += "\n";
		}
		cadena += "\nMATRIZ PESOS\n";
		for (int i = 0; i < numNodos; i++) {
			for (int j = 0; j < numNodos; j++) {
				if (ejes[i][j]) cadena += df.format(pesos[i][j])+"\t";
				else cadena += "-" + "\t";
			}
			cadena += "\n";
		}
		return cadena;
	}
	
	// Método auxiliar que busca el camino de menor coste dentro del vector de pesos ("D").
	private int buscarMenorCoste(boolean[] nodosProcesados, double[] D, int[] P) {
		
		double menor = INFINITO;
		int indiceDelMenor = -1;
	
		for(int i=0; i<numNodos; i++) {
			if(!(nodosProcesados[i]) && D[i] < menor) {
				menor = D[i];
				indiceDelMenor = i;
			}
		}
		
		return indiceDelMenor;
	}
	
	/**
	 * Método que realiza el algoritmo de Dijkstra tomando como nodo de partida aquel que se pase por parámero.
	 * Determina la ruta más corta, desde el nodo origen, hasta cualquier nodo del grafo
	 * @param nodoOrigen, En nodo de partida.
	 * @return Una instancia de la clase DijkstraDataClass con los vectores "D" y "P" correspondientes, null
	 * en el caso de que no se pueda aplicar el algoritmo.
	 */
	public DijkstraDataClass dijkstra(T nodoOrigen) {
		
		if(!existNode(nodoOrigen)) {
			return null;
		}
		
		double[] D = new double[numNodos];
		int[] P = new int[numNodos];
		boolean[] nodosProcesados = new boolean[numNodos];
		
		for(int i=0; i<numNodos; i++) {
			
			if(ejes[getNode(nodoOrigen)][i]) {
				D[i] = pesos[getNode(nodoOrigen)][i];
			} else {
				D[i] = INFINITO;
			}
			P[i] = -1;
			nodosProcesados[i] = false;
			
		}
		
		D[getNode(nodoOrigen)] = INFINITO;
		nodosProcesados[getNode(nodoOrigen)] = true;
		int indiceMenor = buscarMenorCoste(nodosProcesados, D, P);
		
		while(indiceMenor != -1) {
			
			nodosProcesados[indiceMenor] = true;
			for(int i=0; i<numNodos; i++) {
				if(D[indiceMenor]+pesos[indiceMenor][i] < D[i] && ejes[indiceMenor][i]) {
					D[i] = D[indiceMenor] + pesos[indiceMenor][i];
					P[i] = indiceMenor;
				}
			}
			indiceMenor = buscarMenorCoste(nodosProcesados, D, P);
			
		}
		return new DijkstraDataClass(numNodos, getNode(nodoOrigen), D,P);
	}
	
	
	
	/**
	 * Método que devuelve el coste mínimo del camino entre dos nodos que se pasan como parámetro.
	 * @param origen
	 * @param destino
	 * @return Coste mínimo del camino entre dos nodos que se pasan como parámetro.
	 */
	public double minCostPath(T origen, T destino) {
		floyd();
		if(!existNode(origen) || !existNode(destino)) {
			throw new ElementNotPresentException("Uno de los nodos no existe.");
		}
		return A[getNode(origen)][getNode(destino)];
	}
	
	/**
	 * Método que devuelve el camino de coste minimo entre dos nodos que se pasan por parámetro.
	 * Lo hace en forma de un String indicando la ruta mas corta, nodo a nodo.s
	 * @param origen
	 * @param destino
	 * @return String que muestra el camino entre los dos nodos, la cadena vacía si no hay camino.
	 */
	public String path(T origen, T destino) {
		
		floyd();
		if(!existNode(origen) || !existNode(destino)) {
			return "";
		}
		if(origen.equals(destino)) {
			return origen.toString();
		}		
		if(P[getNode(origen)][getNode(destino)] == -1) {
			return origen.toString()+"	(infinito)	"+destino.toString();
			
		} else {
			return origen.toString() + "\t" + pathR(getNode(origen), getNode(destino)) + "\t" + destino.toString();
		}
		
	}
	
	// Método auxiliar recursivo.
	private String pathR(int origen, int destino) {
		
		if(ejes[origen][destino]) {
			return ""+"("+pesos[origen][destino]+")";
		} else {
			int pivote = P[origen][destino];
			return pathR(origen, pivote)+"\t"+nodos[pivote].toString()+"\t"+pathR(pivote, destino);
		}
		
	}
	
	/**
	 * Método cuya función es realizar el recorrido en profundidad de un grafo desde un nodo determinado.
	 * @param nodo, El nodo desde el cual se empieza el recorrido.
	 * @return Una cadena con el recorrido, y la cadena vacía en caso de que no exista.
	 */
	public String recorridoProfundidad(T nodo) {
		
		if(!existNode(nodo)) {
			return "";
		}
		
		ArrayList<Integer> candidatos = new ArrayList<Integer>();
		ArrayList<Integer> recorrido =  new ArrayList<Integer>();
		boolean[] visitados = new boolean[numNodos];
		
		candidatos.add(getNode(nodo));
		
		for(int i=0; i<numNodos; i++) {
			visitados[i] = false;
		}
		
		while(!candidatos.isEmpty()) {
			if(!visitados[candidatos.get(0)]) {
				recorrido.add(candidatos.get(0));
				int posicionAEvaluar = candidatos.get(0);
				visitados[candidatos.get(0)] = true;
				candidatos.remove(0);
				
				int contador = 0;
				for(int i=0; i<numNodos; i++) {
					if(ejes[posicionAEvaluar][i] && !visitados[i]) {
						candidatos.add(contador, i);
						contador++;
					}
				}
			} else {
				candidatos.remove(0);
			}
		}
		
		String camino = "";
		
		for(Integer i: recorrido) {
			camino=camino+nodos[i]+"\t";
		}
		return camino;
	}
	
	/**
	 * Algoritmo de floyd sobre el grafo definifo. Modifica los valores de las patrices A y P.
	 * @return true si se ejecutó correctamente, false en caso contrario.
	 */
	public boolean floyd() {
		
		if(numNodos == 0) {
			return false;
		}
		
		inicializarA();
		inicializarP();
		
		for(int pivote=0; pivote<numNodos; pivote++) {
			for(int j=0; j<numNodos; j++) {
				for(int k=0; k<numNodos; k++) {	
					if(A[j][pivote]+A[pivote][k] < A[j][k]) {
						A[j][k] = A[j][pivote]+A[pivote][k];
						P[j][k] = pivote;
					}
				}
			}
		}
		
		return true;
	}
	
	// Método privado que inicializa A.
	private void inicializarA() {
		A = new double[numNodos][numNodos];
		for(int i=0; i<numNodos; i++) {
			for(int j=0; j<numNodos; j++) {
				if(i != j) {
					if(ejes[i][j]) {
						A[i][j] = pesos[i][j];
					} else {
						A[i][j] = INFINITO;
					}
				} else {
					A[i][j] = 0;
				}
			}
		}
	}
	
	// Método privado que inicializa P.
	private void inicializarP() {
		P = new int[numNodos][numNodos];
		for(int i=0; i<numNodos; i++) {
			for(int j=0; j<numNodos; j++) {
				P[i][j] = -1;
			}
		}
	}
	
	/**
	 * Método que devuelve el valor de la matriz "A" tras ejecutar floyd().
	 * @return el valor de la matriz "A".
	 */
	public double[][] getFloydA() {
		floyd();
		return A;
	}
	
	/**
	 * Método que devuelve el valor de la matriz "A" tras ejecutar floyd().
	 * @return el valor de la matriz "P".
	 */
	public int[][] getFloydP() {
		floyd();
		return P;
	}
	
	
}
