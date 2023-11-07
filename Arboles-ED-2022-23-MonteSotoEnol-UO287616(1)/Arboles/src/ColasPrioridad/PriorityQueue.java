package ColasPrioridad;

public interface PriorityQueue <T extends Comparable<T>> {
	
	public boolean add(T elemento);
	
	public T sacar();
	
	public boolean remove(T elemento);
	
	public boolean isEmpty();
	
	public void clear();
		    
	public boolean cambiarPrioridad(int pos, T elemento);
	
	public String toString();


}
