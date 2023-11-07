package algoritmia;

public class Algorithms {
	
	/**
	 * Constante que indica el tiempo que el hilo está detenido.
	 */
	public static int SLEEP_TIME = 250;
	
	/**
	 * Eleva a 2 el dato "n" que se pase por parámetro.
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
	 * Hace el sumatorio desde el 1 hasta el número que se pasa por parámetro (Iterativo).
	 * @param n, hasta qué numero calcula el sumatorio.
	 * @return resultado, el resultado del sumatorio
	 */
	public int sumaIter(int n) {
		
		if(n == 1) {
			return 1;
		} else {
			int resultado = 0;
			for(int i=1; i<n; i++) {
				resultado = resultado + n;
			}
			return resultado;
		}
		
	}
	
	/**
	 * Hace el sumatorio desde el 1 hasta el número que se pasa por parámetro (Recursivo).
	 * @param n, hasta qué numero calcula el sumatorio.
	 * @return resultado, el resultado del sumatorio
	 */
	public long sumaRec(long n) {
		
		if(n == 1) {
			return 1;
		}if(n == 0) {
			return 0;
		} if(n < 0) {
				return -1;		
		} else {
			return n + sumaRec(n-1);
		}
		
	}
	
	/**
	 * Calcula el término n-ésimo de la sucesión de Fibonacci.
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
		 * Calcula el término n-ésimo de la sucesión de Fibonacci (recursivo).
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
		 * Método que calcula el factorial del número que se pase por parámetro.
		 * @param n, El número a calcular su factorial.
		 * @return El factorial de n
		 */
		public int factorialIter(int n) {
			
			if(n == 0 || n == 1) {
				return 1;
			}
			
			int resultado = 1;
			for(int i=1; i<=n; i++) {
				resultado = resultado*i;
			}
			return resultado;
		}
		
		/**
		 * Método que calcula el factorial del número que se pase por parámetro (Recursivo).
		 * @param n, El número a calcular su factorial.
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
		 * Método que calcula 2 elevado al exponente que se pase por parámetro de forma recursiva.
		 * @param n, Exponente
		 * @return Resultado.
		 */
		public long  powRec1(int n) {
			
			if(n == 0) {
				return 1;
			}if(n < 0 ) {
				return -1;
			} else {
				return 2 * powRec1(n-1);
			}
			
		}
		
		/**
		 * Método que calcula 2 elevado al exponente que se pase por parámetro de forma recursiva.
		 * @param n, Exponente
		 * @return Resultado.
		 */
		public double powRec2(int n) {
			
			//doNothing();
			
			if(n == 0) {
				return 1;
			} if(n == 1) {
				return 1;
			} if(n < 0) {
				return -1;
			} else {
				return powRec2(n-1) * powRec2(n-1);
			}
			
		}
		
		/**
		 * Método que calcula 2 elevado al exponente que se pase por parámetro de forma recursiva.
		 * @param n, Exponente
		 * @return Resultado.
		 */
		public double powRec3(int n) {
			
			//doNothing();
			
			if(n == 0) {
				return 1;
			}if (n<0) {
				return -1;
			}else if (n % 2 == 0) {
				return powRec3(n/2) * powRec2(n/2);
			}else {
				return powRec3(n/2) * powRec2(n/1)*2;
			}
			
		}
		
		/**
		 * Método genérico de complejidad lineal.
		 * @param n, veces que se ejecuta el bucle.
		 */
		public void lineal (int n) {
			for (int i=1; i<=n; i++) {
				System.out.println("Ejecutando");
			}
		}
		
		/**
		 * Método genérico de complejidad cuadrática.
		 * @param n, veces que se ejecuta el bucle.
		 */
		public void cuadratic(int n) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.println("Ejecutando");
				}
			}
		}
		
		/**
		 * Método genérico de complejidad cúbica.
		 * @param n, veces que se ejecuta el bucle.
		 */
		public void cubic(int n) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					for(int k=0; k<n; k++) {
						System.out.println("Ejecutando");
					}
				}
			}
		}
		
		/**
		 * Método genérico de complejidad exponencial.
		 * @param n, veces que se ejecuta el bucle.
		 */
		public void exponential(int n) {
			for (int i=1; i<=n; i= i*i) {
				System.out.println("Ejecutando");
			}
		}
		
		/**
		 * Método genérico de complejidad logarítmica.
		 * @param n, veces que se ejecuta el bucle.
		 */
		public void logarithmic(int n) {
			for (int i=1; i<=n; i= i/2) {
				System.out.println("Ejecutando");
			}
		}
		
		/**
		 * Método que invoca al método doNothing() con complejidad lineal.
		 * @param n, las veces que se invoca al método doNothing().
		 */
		public void linealDoNothing(int n) {
			for(int i=1; i<=n; i++) {
				doNothing();
			}
		}
		
		/**
		 * Método que invoca al método doNothing() con complejidad cuadrática.
		 * @param n, las veces que se invoca al método doNothing().
		 */
		public void cuadraticDoNothing(int n) {
			for(int i=1; i<=n; i++) {
				for(int j=0; j<n; j++) {
					doNothing();
				}
			}
		}
		
		/**
		 * Método que invoca al método doNothing() con complejidad cúbica.
		 * @param n, las veces que se invoca al método doNothing().
		 */
		public void cubicDoNothing(int n) {
			for(int i=1; i<=n; i++) {
				for(int j=0; j<n; j++) {
					for(int k=0; k<n; k++) {
						doNothing();
					}
				}
			}
		}
		
		/**
		 * Método genérico de complejidad logarítmica.
		 * @param n, veces que se ejecuta el bucle.
		 */
		public void logarithmicDoNothing(int n) {
			for (int i=1; i<=n; i++) {
				i=i*2;
				doNothing();
			}
		}
		
		/**
		 * Método que detiene la actividad del hilo durante un tiempo determinado.
		 */
		public void doNothing() {
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	
	

}
