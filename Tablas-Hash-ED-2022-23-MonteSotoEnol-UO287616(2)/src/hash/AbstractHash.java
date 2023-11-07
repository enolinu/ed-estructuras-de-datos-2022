package hash;

public abstract class AbstractHash <T> {
	
	abstract public int getNumOfElems();
	abstract public int getSize();
	
	/**
	 * Método que añade un elemento a la estructura.
	 * @param elemento
	 * @return true si lo inserta, NullPointerException si el elemento es null (solo sin redispersión).
	 */
	abstract public boolean add(T elemento);
	
	/**
	 * Métrodo que encuentra un elemento en la tabla.
	 * @param elemento si lo encuentra, null en caso contrario. NullPointerException si es null.
	 * @return El elemento
	 */
	abstract public T find(T elemento);
	
	/**
	 * Método que borra un elemento de la estructura.
	 * @param elemento
	 * @return true si lo borra, false si la tabla está vacía NullPointerException si el elemento es null.
	 */
	abstract public boolean remove(T elemento);
	abstract public String toString();
	
	protected int fHash(T elemento) {
		int pos = elemento.hashCode()%getSize();
		if(pos<0) return pos+getSize();
		else return pos;
	}
	
	protected boolean isPositivePrime(int numero) {
		if(numero == 0 || numero == 1 || numero == 4) {
			return false;
		}
		
		for (int i = 2; i < numero / 2; i++) {
		    if (numero % i == 0)
		      return false;
		}
		return true;
	}
	
	protected int nextPrimeNumber(int n) {
		int numero = n+1;
		while(!isPositivePrime(numero)) {
			numero++;
		}
		return numero;
	}
	
	protected int previousPrimeNumber(int n) {
		if(n<=3) {
			return 3;
		}
		int numero = n-1;
		while(!isPositivePrime(numero)) {
			numero--;
		}
		return numero;
	}
	protected abstract void reDispersion();
	protected abstract void inverseRedispersion();

}
