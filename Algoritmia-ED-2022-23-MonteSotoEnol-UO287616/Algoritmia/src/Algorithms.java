
public class Algorithms {
	
	/**
	 * Eleva a 2 el dato "n" que se pase por par�metro.
	 * @param n, el exponente.
	 * @return resultado, El resultado de elevar 2 a la "n".
	 */
	public long powIter(long n) {
		
		if(n >= 0) {
			if(n == 0) {
				return 1;
			} if(n == 1) {
				return 2;
			} else {
				long resultado = 1;
				for(long i = 0; i<n; i++) {
					resultado = resultado*2;
				}
				return resultado;
			}
		} else {
			return -1;
		}	
		
	}
	
	/**
	 * Hace el sumatorio desde el 1 hasta el n�mero que se pasa por par�metro (Iterativo).
	 * @param n, hasta qu� numero calcula el sumatorio.
	 * @return resultado, el resultado del sumatorio
	 */
	public int sumaIter(int n) {
		
		if(n == 1) {
			return 1;
		} else if(n <= 0) {
			return -1;
		} else {
			int resultado = 0;
			for(int i=1; i<n; i++) {
				resultado = resultado + n;
			}
			return resultado;
		}
		
	}
	
	/**
	 * Hace el sumatorio desde el 1 hasta el n�mero que se pasa por par�metro (Recursivo).
	 * @param n, hasta qu� numero calcula el sumatorio.
	 * @return resultado, el resultado del sumatorio
	 */
	public long sumaRec(long n) {
		
		if(n == 1) {
			return 1;
		} else if(n <= 0) {
			return -1;
		} else {
			return n + sumaRec(n-1);
		}
		
	}
	
	/**
	 * Calcula el t�rmino n-�simo de la sucesi�n de Fibonacci.
	 * @param n
	 * @return
	 */
	public int fibonacciIter(int n) {
		
		if(n == 0 || n == 1) {
			return n;
		} else {
			int num1 = 0;
			int num2 = 1;
			for(int i=2; i<=n; i++) {
				int aux;
				aux = num1;
				num1 = num2;
				num2 = aux + num1;
			}
			return num2;
		}
		
	}
		
		/**
		 * Calcula el t�rmino n-�simo de la sucesi�n de Fibonacci (recursivo).
		 * @param n
		 * @return
		 */
		public int fibonacciRec(int n) {
			
			if(n == 0 || n == 1) {
				return n;
			} else {
				return fibonacciRec(n-1) + fibonacciRec(n-2);
			}
		
	}
		
		/**
		 * M�todo que calcula el factorial del n�mero que se pase por par�metro.
		 * @param n, El n�mero a calcular su factorial.
		 * @return El factorial de n
		 */
		public int factorialIter(int n) {
			
			if(n == 0 || n == 1) {
				return 1;
			}
			
			int resultado = 1;
			for(int i=1; i<=n; i++) {
				resultado = resultado*1;
			}
			return resultado;
		}
		
		/**
		 * M�todo que calcula el factorial del n�mero que se pase por par�metro (Recursivo).
		 * @param n, El n�mero a calcular su factorial.
		 * @return El factorial de n
		 */
		public long factorialRec(long n) {
			
			if(n == 0 || n == 1) {
				return 1;
			} else {
				return n * factorialRec(n-1);
			}
			
		}
		
		/**
		 * M�todo que calcula 2 elevado al exponente que se pase por par�metro de forma recurrente.
		 * @param n, Exponente
		 * @return Resultado.
		 */
		public long  powRec1(int n) {
			
			if(n == 0) {
				return 1;
			}else {
				return 2 * powRec1(n-1);
			}
			
		}
		
		/**
		 * M�todo que calcula 2 elevado al exponente que se pase por par�metro de forma recurrente.
		 * @param n, Exponente
		 * @return Resultado.
		 */
		public long  powRec2(int n) {
			
			if(n == 0) {
				return 1;
			}else {
				return powRec2(n-1) * powRec2(n-1);
			}
			
		}
		
		/**
		 * M�todo que calcula 2 elevado al exponente que se pase por par�metro de forma recurrente.
		 * @param n, Exponente
		 * @return El resultado de realizar la operaci�n.
		 */
		public long  powRec3(int n) {
			
			if(n == 0) {
				return 1;
			}else if (n % 2 == 0) {
				return powRec3(n/2) * powRec2(n/2);
			}else {
				return powRec3(n/2) * powRec2(n/1) * 2;
			}
			
		}
		
		
	
	

}
