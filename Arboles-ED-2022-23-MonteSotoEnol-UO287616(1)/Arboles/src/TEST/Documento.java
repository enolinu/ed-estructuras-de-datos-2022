package TEST;


//Clase que crea objetos de tipo documento.

class Documento implements Comparable<Documento>{
	private int prioridad;
	private String nombre;

	
	/**
	 * @param clave Prioridad del documento.
	 * @param n Nombre de la persona
	 */
	public Documento(int clave, String n){
		prioridad=clave;
		nombre=n;
	}

	/**
	 * @return Prioridad del documento.
	 */
	public int getPrioridad() {
		return prioridad;
	}
	
	
	/**
	 * @return Nombre del documento.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Compara la prioridad del objeto
	 */
	@Override
	public int compareTo(Documento p) {
		
		if (prioridad < (p.prioridad))
			return -1;
		else if (prioridad > (p.prioridad))
			return 1;
		else
			return 0;
	}
	
	/**
	 * Muestra un objeto con la prioridad y el nombre entre corchetes
	 */
	public String toString() {
		return "["+prioridad+":"+nombre+"]";
	}
}
