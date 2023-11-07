package hash;

public class HashNode <T> {
	
	/**
	 * Constante que indica que el nodo est� borrado.
	 */
	public static final int BORRADO = -1;
	/**
	 * Constante que indica que el nodo est� vac�o.
	 */
	public static final int VACIO = 0;
	/**
	 * Constante que indica que el nodo est� lleno.
	 */
	public static final int LLENO = 1;
	
	private T info; // Contenido.
	private int estado; // Estado
	
	/**
	 * Contructor por defecto. Pone la info a null y es estado a vac�o.
	 */
	public HashNode() {
		info = null;
		estado = VACIO;
	}
	
	/**
	 * M�todo get de la informaci�n del nodo.
	 * @return info
	 */
	public T getInfo() {
		return info;
	}
	
	/**
	 * M�todo set de la informaci�n del nodo.
	 * @param info
	 */
	public void setInfo(T info) {
		this.info = info;
		this.estado = LLENO;
	}
	
	/**
	 * M�toddo que devueve el estado del nodo,
	 * @return -1 si borrado, 0 si vac�o, 1si lleno.
	 */
	public int getEstado() {
		return estado;
	}
	
	/**
	 * M�todo set del estado.
	 * @param estado
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	/**
	 * M�todo que pone un nodo como borrado.
	 */
	public void remove() {
		this.estado = BORRADO;
	}
	
	/**
	 * M�todo que devuelve una cadena representativa del nodo.
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
