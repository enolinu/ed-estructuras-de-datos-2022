package AVL;

public class AVLNode <T extends Comparable<T>> {
	
	private T info;
	private AVLNode<T> left;
	private AVLNode<T> right;
	private int balanceFactor;
	private int height;
 	
	/**
	 * Método constructor de la clase AVLNode. Le asigna a info el valor que se le
	 * pasa mediante el parámetro y se asigna null tanto al hijo izquierdo como al
	 * hijo derecho,
	 * @param clave, El valor de la info del nodo.
	 */
	public AVLNode(T clave) {
		info = clave;
		left = null;
		right = null;
	}
	
	/**
	 * Método get del atributo info
	 * @return El contenido del nodo que es de tipo genérico.
	 */
	public T getInfo() {
		return info;
	}
	
	/**
	 * Método set del atributo info del nodo.
	 * @param info, El valor que le asignamos al atributo info del nodo.
	 */
	public void setInfo(T info) {
		this.info = info;
	}
	
	/**
	 * Método get del hijo izquierdo.
	 * @return El nodo del hijo izquierdo.
	 */
	public AVLNode<T> getLeft() {
		return left;
	}
	
	/**
	 * Método set del atributo del hijo izquierdo.
	 * @param left (El nodo que se le asignará al hijo izquierdo).
	 */
	public void setLeft(AVLNode<T> left) {
		this.left = left;
	}
	
	/**
	 * Método get del hijo derecho.
	 * @return El nodo del hijo derecho.
	 */
	public AVLNode<T> getRight() {
		return right;
	}
	
	/**
	 * Método set del atributo del hijo derecho.
	 * @param right (El nodo que se le asignará al hijo derecho).
	 */
	public void setRight(AVLNode<T> right) {
		this.right = right;
	}
	
	/**
	 * Método get del factor de balance.
	 * @return El factor de balance del nodo.
	 */
	public int getBalanceFactor() {
		return balanceFactor;
	}
	
	/**
	 * Método set del atributo factor de balance.
	 * @param balanceFactor (El factor de balance del nodo).
	 */
	public void setBalanceFactor(int balanceFactor) {
		this.balanceFactor = balanceFactor;
	}
	
	/**
	 * Método get del atributo altura.
	 * @return La altura del subarbol.
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Método set del atributo altura.
	 * @param height (La altura).
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void updateBFHeight() {
		if(right == null && left == null){
			  setHeight(0);
			  setBalanceFactor(0);
			}else{
			  if(right != null && left != null){
			    setHeight(Math.max(right.getHeight(),left.getHeight())+1);
			    setBalanceFactor(right.getHeight()-left.getHeight());
			  }else{
			    if(right != null){
			      setHeight(right.getHeight() + 1);
			      setBalanceFactor(getHeight());
			    }else{
			      setHeight(left.getHeight() + 1);
			      setBalanceFactor(-getHeight());
			    }
			  }
		}
	}
	
	/**
	 * Método que devuelve una cadena representativa del nodo.
	 * @return Cadena representativa con el factor de balance del nodo.
	 */
	public String toString() {
		return info.toString()+":BF="+getBalanceFactor();
	}
	

}
