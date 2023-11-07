package algoritmia;

public class Algorithms {
	
	/**
	 * Constante que indica el tiempo que el hilo est� detenido.
	 */
	public static int SLEEP_TIME = 250;
	
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
		}if(n == 0) {
			return 0;
		} if(n < 0) {
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
				resultado = resultado*i;
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
		 * M�todo que calcula 2 elevado al exponente que se pase por par�metro de forma recursiva.
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
		 * M�todo que calcula 2 elevado al exponente que se pase por par�metro de forma recursiva.
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
		 * M�todo que calcula 2 elevado al exponente que se pase por par�metro de forma recursiva.
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
		 * M�todo gen�rico de complejidad lineal.
		 * @param n, veces que se ejecuta el bucle.
		 */
		public void lineal (int n) {
			for (int i=1; i<=n; i++) {
				System.out.println("Ejecutando");
			}
		}
		
		/**
		 * M�todo gen�rico de complejidad cuadr�tica.
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
		 * M�todo gen�rico de complejidad c�bica.
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
		 * M�todo gen�rico de complejidad exponencial.
		 * @param n, veces que se ejecuta el bucle.
		 */
		public void exponential(int n) {
			for (int i=1; i<=n; i= i*i) {
				System.out.println("Ejecutando");
			}
		}
		
		/**
		 * M�todo gen�rico de complejidad logar�tmica.
		 * @param n, veces que se ejecuta el bucle.
		 */
		public void logarithmic(int n) {
			for (int i=1; i<=n; i= i/2) {
				System.out.println("Ejecutando");
			}
		}
		
		/**
		 * M�todo que invoca al m�todo doNothing() con complejidad lineal.
		 * @param n, las veces que se invoca al m�todo doNothing().
		 */
		public void linealDoNothing(int n) {
			for(int i=1; i<=n; i++) {
				doNothing();
			}
		}
		
		/**
		 * M�todo que invoca al m�todo doNothing() con complejidad cuadr�tica.
		 * @param n, las veces que se invoca al m�todo doNothing().
		 */
		public void cuadraticDoNothing(int n) {
			for(int i=1; i<=n; i++) {
				for(int j=0; j<n; j++) {
					doNothing();
				}
			}
		}
		
		/**
		 * M�todo que invoca al m�todo doNothing() con complejidad c�bica.
		 * @param n, las veces que se invoca al m�todo doNothing().
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
		 * M�todo gen�rico de complejidad logar�tmica.
		 * @param n, veces que se ejecuta el bucle.
		 */
		public void logarithmicDoNothing(int n) {
			for (int i=1; i<=n; i++) {
				i=i*2;
				doNothing();
			}
		}
		
		/**
		 * M�todo que detiene la actividad del hilo durante un tiempo determinado.
		 */
		public void doNothing() {
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	
	

}
