package AVL;

public class AVLNode <T extends Comparable<T>> {
	
	private T info;
	private AVLNode<T> left;
	private AVLNode<T> right;
	private int balanceFactor;
	private int height;
 	
	/**
	 * M�todo constructor de la clase AVLNode. Le asigna a info el valor que se le
	 * pasa mediante el par�metro y se asigna null tanto al hijo izquierdo como al
	 * hijo derecho,
	 * @param clave, El valor de la info del nodo.
	 */
	public AVLNode(T clave) {
		info = clave;
		left = null;
		right = null;
	}
	
	/**
	 * M�todo get del atributo info
	 * @return El contenido del nodo que es de tipo gen�rico.
	 */
	public T getInfo() {
		return info;
	}
	
	/**
	 * M�todo set del atributo info del nodo.
	 * @param info, El valor que le asignamos al atributo info del nodo.
	 */
	public void setInfo(T info) {
		this.info = info;
	}
	
	/**
	 * M�todo get del hijo izquierdo.
	 * @return El nodo del hijo izquierdo.
	 */
	public AVLNode<T> getLeft() {
		return left;
	}
	
	/**
	 * M�todo set del atributo del hijo izquierdo.
	 * @param left (El nodo que se le asignar� al hijo izquierdo).
	 */
	public void setLeft(AVLNode<T> left) {
		this.left = left;
	}
	
	/**
	 * M�todo get del hijo derecho.
	 * @return El nodo del hijo derecho.
	 */
	public AVLNode<T> getRight() {
		return right;
	}
	
	/**
	 * M�todo set del atributo del hijo derecho.
	 * @param right (El nodo que se le asignar� al hijo derecho).
	 */
	public void setRight(AVLNode<T> right) {
		this.right = right;
	}
	
	/**
	 * M�todo get del factor de balance.
	 * @return El factor de balance del nodo.
	 */
	public int getBalanceFactor() {
		return balanceFactor;
	}
	
	/**
	 * M�todo set del atributo factor de balance.
	 * @param balanceFactor (El factor de balance del nodo).
	 */
	public void setBalanceFactor(int balanceFactor) {
		this.balanceFactor = balanceFactor;
	}
	
	/**
	 * M�todo get del atributo altura.
	 * @return La altura del subarbol.
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * M�todo set del atributo altura.
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
	 * M�todo que devuelve una cadena representativa del nodo.
	 * @return Cadena representativa con el factor de balance del nodo.
	 */
	public String toString() {
		return info.toString()+":BF="+getBalanceFactor();
	}
	

}
