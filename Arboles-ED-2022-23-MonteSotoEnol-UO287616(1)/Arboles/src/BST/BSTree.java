package BST;

public class BSTree<T extends Comparable<T>> {
	
	private BSTNode<T> raiz; // Nodo ra�z del arbol BST.
	
	/**
	 * Crea un �rbol vac�o.
	 */
	public BSTree() {
		raiz = null;
	}
	
	
	/**
	 * M�todo que busca la clave que se pasa por par�metro dentro del �rbol.
	 * @param clave
	 * @return El nodo completo (con los sub�rboles), si no lo encuentra devuelve null.
	 */
	public BSTNode<T> searchNode(T clave) {
		
		if(clave == null) {
			return null;
		} else {
			return searchNodeRec(raiz, clave);
		}
		
	}
	
	private BSTNode<T> searchNodeRec(BSTNode<T> nodo, T clave) {
		
		if(nodo == null) {
			return null;
		}
		
		if(clave.equals(nodo.getInfo())) {
			return nodo;
		}
		
		if(clave.compareTo(nodo.getInfo()) > 0) {
			return searchNodeRec(nodo.getRight(), clave);
		}
		if(clave.compareTo(nodo.getInfo()) < 0) {
			return searchNodeRec(nodo.getLeft(), clave);
		}
		
		return null;
	}
	
	/**
	 * A�ade un nodo al �rbol.
	 * @param clave
	 * @return true si lo a�ade, false si no existe, Excepci�n si la clave es null.
	 */
	public boolean addNode(T clave) {
		
		if(clave == null) {
			throw new NullPointerException("No se admiten valores nulos");
		}
		
		if(raiz == null) {
			raiz = new BSTNode<T>(clave);
			return true;
		} 
		
		else {
			return addRec(raiz, clave);
		}
		
	}
	
	private boolean addRec(BSTNode<T> raiz, T clave) {
		
		if(clave.compareTo(raiz.getInfo()) > 0) {
			if(raiz.getRight() == null) {
				raiz.setRight(new BSTNode<T>(clave));
				return true;
			} else {
				return addRec(raiz.getRight(), clave);
			}
		}
		
		if (clave.compareTo(raiz.getInfo()) < 0) {
			if(raiz.getLeft() == null) {
				raiz.setLeft(new BSTNode<T>(clave));
				return true;
			} else {
				return addRec(raiz.getLeft(), clave);
			}
			
		} else {
			return false;
		}
		
	}
	
	/**
	 * Borra el nodo que se pasa por par�metro.
	 * @param clave
	 * @return true si lo borra correctamente, false si intenta borrar un elemento que no existe.
	 */
	public boolean removeNode(T clave) {
		if(clave == null) {
			return false;
		}
		if(searchNode(clave) == null) {
			return false;
		}
		removeNodeRec(raiz, clave);
		return true;
	}
	
	public BSTNode<T> removeNodeRec(BSTNode<T> nodo, T clave) {
		if(nodo == null) {
			return null;
		}
		if(clave.compareTo(nodo.getInfo()) < 0) {
			nodo.setLeft(removeNodeRec(nodo.getLeft(), clave));
		} 
		if(clave.compareTo(nodo.getInfo()) > 0) {
			nodo.setRight(removeNodeRec(nodo.getRight(), clave));
		}
		if(clave.compareTo(nodo.getInfo()) == 0) {
			if(nodo.getLeft() == null && nodo.getRight() == null) {
				return null;
			}
			if(nodo.getRight() == null) {
				return nodo.getLeft();
			}
			if(nodo.getLeft() == null) {
				return nodo.getRight();
			}
			BSTNode<T> max = nodo.getLeft();
			while(max.getRight() != null) {
				max = max.getRight();
			}
			nodo.setInfo(max.getInfo());
			nodo.setLeft(removeNodeRec(nodo.getLeft(), max.getInfo()));
		}
		return nodo;
	}
	
	/**
	 * Devuelve una cadena con el recorrido en pre-orden del �rbol.
	 * @return
	 */
	public String preOrder() {
		String cadena = preOrderRec(raiz);
		return cadena.substring(0, cadena.length()-1);
	}
	
	private String preOrderRec(BSTNode<T> nodo) {
		if(nodo == null) {
			return "";
		} else {	
			return nodo.toString() + "\t" + preOrderRec(nodo.getLeft()) + preOrderRec(nodo.getRight());
		}
	}


	/**
	 * Devuelve una cadena con el recorrido en in-orden del �rbol.
	 * @return
	 */
	public String inOrder() {
		String cadena = inOrderRec(raiz);
		return cadena.substring(0, cadena.length()-1);
	}
	
	private String inOrderRec(BSTNode<T> nodo) {
		if(nodo == null) {
			return "";
		} else {	
			return inOrderRec(nodo.getLeft()) + nodo.toString() + "\t" + inOrderRec(nodo.getRight());
		}
	}

	
	/**
	 * Devuelve una cadena con el recorrido en post-orden del �rbol.
	 * @return
	 */
	public String postOrder() {
		String cadena = postOrderRec(raiz);
		return cadena.substring(0, cadena.length()-1);
	}
	
	private String postOrderRec(BSTNode<T> nodo) {
		if(nodo == null) {
			return "";
		} else {	
			return postOrderRec(nodo.getLeft()) + postOrderRec(nodo.getRight()) + nodo.toString() + "\t";
		}
	}
	
	/**
	 * M�todo que devuelve un String representativo del �rbol.
	 * @return String representando el arbol tumbado.
	 */
	public String toString() {
		return tumbarArbol(raiz,1);
	}
	
	/**
	 * Representaci�n del �rbol en forma de cadena.
	 * @param p
	 * @param esp
	 * @return
	 */
	private String tumbarArbol(BSTNode<T> p, int esp) {
		StringBuilder cadena = new StringBuilder();

		if (p != null) {
			cadena.append(tumbarArbol(p.getRight(), esp + 1));
			for (int i = 0; i < esp; i++)
				cadena.append("\t");
			cadena.append(p + "\n");
			cadena.append(tumbarArbol(p.getLeft(), esp + 1));
		}
		return cadena.toString();
	}
}
