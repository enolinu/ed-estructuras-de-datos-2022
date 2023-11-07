package BST;

public class BSTNode <T extends Comparable <T>> {
	
	private T info; // Contenido del nodo, de tipo gen�rico.
	private BSTNode<T> left; // Nodo hijo izquierdo.
	private BSTNode<T> right; // Nodo hijo derecho.
	
	/**
	 * M�todo constructor de la clase. Asigna al atributo info la clave que se pasa por par�metro.
	 * A las propiedades left y right les asigna null.
	 * @param clave
	 */
	public BSTNode(T clave) {
		info = clave;
		left = null;
		right = null; 
	}
	
	/**
	 * M�todo set del atributo info.
	 * @param clave
	 */
	public void setInfo(T clave) {
		info = clave;
	}
	
	/**
	 * M�todo get del atributo info.
	 * @return
	 */
	public T getInfo() {
		return info;
	}
	
	/**
	 * M�todo set del atributo.
	 * @param clave
	 */
	public void setLeft(BSTNode<T> clave) {
		left = clave;
	}
	
	/**
	 * M�todo set del atributo right;
	 * @param clave
	 */
	public void setRight(BSTNode<T> clave) {
		right = clave;
	}
	
	/**
	 * M�todo get del atributo left.
	 * @return
	 */
	public BSTNode<T> getLeft() {
		return left;
	}
	
	/**
	 * M�todo get del atributo right.
	 * @return
	 */
	public BSTNode<T> getRight() {
		return right;
	}
	
	/**
	 * Cadena representativa del nodo.
	 */
	@Override
	public String toString() {
		return info.toString();
	}
	
	
}
