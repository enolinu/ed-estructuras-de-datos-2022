package AVL;


public class AVLTree <T extends Comparable <T>> {
	
	private AVLNode<T> raiz;
	
	public AVLTree() {
		setRaiz(null);
	}

	public AVLNode<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(AVLNode<T> raiz) {
		this.raiz = raiz;
	}
	
	public AVLNode<T> searchNode(T clave) {
		if(clave == null) {
			return null;
		} else {
			return searchNodeRec(raiz, clave);
		}
	}
	
	public AVLNode<T> searchNodeRec(AVLNode<T> nodo, T clave) {
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
	 * Método que añade un nodo al árbol, equilibrándolo si es necesario.
	 * @param clave, La del nodo a añadir.
	 * @return true si consigue añadir el nodo correctamente, false en caso
	 * contrario, NullPointerException si se intenta añadir un nodo nulo.
	 */
	public boolean addNode(T clave) {
		if(clave == null) {
			throw new NullPointerException("No se admiten valores nulos");
		}
		
		if(searchNode(clave) != null) {
			return false;
		}
		
		if(raiz == null) {
			raiz = new AVLNode<T>(clave);
			return true;
		}
		
		else {
			raiz = updateAndBalanceIfNecessary(addRec(raiz, clave));
			return true;
		}
	}
	
	private AVLNode<T> addRec(AVLNode<T> nodo, T clave) {
		if(nodo == null) {
			return null;
		}
		if(clave.compareTo(nodo.getInfo()) > 0) {
			if(nodo.getRight() == null) {
				nodo.setRight(new AVLNode<T>(clave));
			} else {
				nodo.setRight(addRec(nodo.getRight(), clave));
			}
		} if (clave.compareTo(nodo.getInfo()) < 0) {
			if(nodo.getLeft() == null) {
				nodo.setLeft(new AVLNode<T>(clave));
			} else {
				nodo.setLeft(addRec(nodo.getLeft(), clave));
			}
			
		}
		return updateAndBalanceIfNecessary(nodo);
		
	}
	
	private AVLNode<T> removeNodeAux(T clave) {
		AVLNode<T> nodo = searchNode(clave);
		if(nodo.getRight() == null && nodo.getLeft() == null) {
			return null;
		}
		if(nodo.getRight() == null) {
			return nodo.getLeft();
		}
		if(nodo.getLeft() == null) {
			return nodo.getLeft();
		}
		
		T contenido = nodo.getLeft().getInfo();
		nodo.setLeft(removeNodeRec(nodo.getLeft(), contenido));
		nodo.setInfo(contenido);
		return updateAndBalanceIfNecessary(nodo);
	}
	
	/**
	 * Método que elimina un nodo de la estructura.
	 * @param clave, La del nodo a eliminar.
	 * @return true si consigue eliminarlo, false en caso contrario,
	 * NullPointerException si se le pasa una clave nula.
	 */
	public boolean removeNode(T clave) {
		// No me salió
		if(clave == null) {
			throw new NullPointerException("No se admiten valores nulos");
		} if(raiz == null || searchNode(clave) == null) {
			return false;
		} 
		removeNodeAux(clave);
		return true;
	}
	
	public AVLNode<T> removeNodeRec(AVLNode<T> nodo, T clave) {
		if(nodo.getInfo().compareTo(clave) < 0) {
			if(nodo.getLeft() != null) {
				nodo.setLeft(removeNodeRec(nodo.getLeft(), clave));
			}
		}
		if(nodo.getInfo().compareTo(clave) < 0) {
			if(nodo.getRight() != null) {
				nodo.setRight(removeNodeRec(nodo.getRight(), clave));
			}
		}
		else {
			return removeNodeAux(nodo.getInfo());
		}
		return updateAndBalanceIfNecessary(nodo);
	}
	
	private AVLNode<T> updateAndBalanceIfNecessary(AVLNode<T> nodo) {
		if(nodo.getLeft()!= null) {
            nodo.getLeft().updateBFHeight();
        }
        if(nodo.getRight()!=null) {
        	nodo.getRight().updateBFHeight();
        }
        nodo.updateBFHeight();
		if(nodo.getBalanceFactor() == -2) {
			if(nodo.getLeft().getBalanceFactor() == 1) {
				nodo = doubleLeftRotation(nodo);
			} else {
				nodo = singleLeftRotation(nodo);
			}
		} 
			if(nodo.getBalanceFactor() == 2) {
				if(nodo.getRight().getBalanceFactor() == -1) {
					nodo = doubleRightRotation(nodo);
				} else {
					nodo = singleRightRotation(nodo);
				}
			}
		return nodo;
	}
	
	/**
	 * Devuelve una cadena con el recorrido en pre-orden del árbol.
	 * @return cadena
	 */
	public String preOrder() {
		String cadena = preOrderRec(raiz);
		return cadena.substring(0, cadena.length()-1);
	}
	
	private String preOrderRec(AVLNode<T> nodo) {
		if(nodo == null) {
			return "";
		} else {	
			return nodo.toString() + "\t" + preOrderRec(nodo.getLeft()) + preOrderRec(nodo.getRight());
		}
	}


	/**
	 * Devuelve una cadena con el recorrido en in-order del árbol.
	 * @return cadena
	 */
	public String inOrder() {
		String cadena = inOrderRec(raiz);
		return cadena.substring(0, cadena.length()-1);
	}
	
	private String inOrderRec(AVLNode<T> nodo) {
		if(nodo == null) {
			return "";
		} else {	
			return inOrderRec(nodo.getLeft()) + nodo.toString() + "\t" + inOrderRec(nodo.getRight());
		}
	}

	
	/**
	 * Devuelve una cadena con el recorrido en post-orden del árbol.
	 * @return cadena
	 */
	public String postOrder() {
		String cadena = postOrderRec(raiz);
		return cadena.substring(0, cadena.length()-1);
	}
	
	private String postOrderRec(AVLNode<T> nodo) {
		if(nodo == null) {
			return "";
		} else {	
			return postOrderRec(nodo.getLeft()) + postOrderRec(nodo.getRight()) + nodo.toString() + "\t";
		}
	}
	
	// Rotaciones
	
	private AVLNode<T> singleRightRotation(AVLNode<T> nodo) {
		AVLNode<T> aux = nodo.getRight();
		nodo.setRight(aux.getLeft());
		aux.setLeft(nodo);
		nodo.updateBFHeight();
		aux.updateBFHeight();
		return aux;
	}

	private AVLNode<T> doubleRightRotation(AVLNode<T> nodo) {
		nodo.setRight(singleLeftRotation(nodo.getRight()));
		return singleRightRotation(nodo);
	}

	private AVLNode<T> singleLeftRotation(AVLNode<T> nodo) {
		AVLNode<T> aux = nodo.getLeft();
		nodo.setLeft(aux.getRight());
		aux.setRight(nodo);
		nodo.updateBFHeight();
		aux.updateBFHeight();
		return aux;
	}

	private AVLNode<T> doubleLeftRotation(AVLNode<T> nodo) {
		nodo.setLeft(singleRightRotation(nodo.getLeft()));
		return singleLeftRotation(nodo);
	}
	
	/**
	 * Método que devuelve un String con el árbol tumbado.
	 * @param p
	 * @param esp
	 * @return
	 */
	public String tumbarArbol(AVLNode<T> p, int esp) {
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
	
	public String toString() {
		return tumbarArbol(raiz,1);
	}

}
