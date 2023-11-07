package hash;

public class HashNode <T> {
	
	/**
	 * Constante que indica que el nodo está borrado.
	 */
	public static final int BORRADO = -1;
	/**
	 * Constante que indica que el nodo está vacío.
	 */
	public static final int VACIO = 0;
	/**
	 * Constante que indica que el nodo está lleno.
	 */
	public static final int LLENO = 1;
	
	private T info; // Contenido.
	private int estado; // Estado
	
	/**
	 * Contructor por defecto. Pone la info a null y es estado a vacío.
	 */
	public HashNode() {
		info = null;
		estado = VACIO;
	}
	
	/**
	 * Método get de la información del nodo.
	 * @return info
	 */
	public T getInfo() {
		return info;
	}
	
	/**
	 * Método set de la información del nodo.
	 * @param info
	 */
	public void setInfo(T info) {
		this.info = info;
		this.estado = LLENO;
	}
	
	/**
	 * Métoddo que devueve el estado del nodo,
	 * @return -1 si borrado, 0 si vacío, 1si lleno.
	 */
	public int getEstado() {
		return estado;
	}
	
	/**
	 * Método set del estado.
	 * @param estado
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	/**
	 * Método que pone un nodo como borrado.
	 */
	public void remove() {
		this.estado = BORRADO;
	}
	
	/**
	 * Método que devuelve una cadena representativa del nodo.
	 * @return cadena
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder("{");
		switch (getEstado()) {
		case LLENO:
			cadena.append(info);
			break;
		case VACIO:
			cadena.append("_E_");
			break;
		case BORRADO:
			cadena.append("_D_");
		}
		cadena.append("}");
		return cadena.toString();
	}
}
