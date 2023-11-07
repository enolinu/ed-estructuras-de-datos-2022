package algoritmia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class TestBench {
	
	public static void main(String[] args) {
		
		TestBench tb = new TestBench();
		tb.test4("logarithmic.csv", 10, 20, 5, "algoritmia.Algorithms", "logarithmicDoNothing");
		
	}
	
	//Metodos para la reflectividad

	/**
	 * @param className
	 *            Nombre de la clase que contiene un método que se quiere
	 *            invocar
	 * @param methodName
	 *            Nombre del método que se quiere invocar
	 * @param n
	 *            Parámetro que se le pasa al método invocado
	 */
	public void testAlgorithm(String className, String methodName, int n) {
		Class<?> clase;
		Object miclase;
		Method metodo;
		
		// Localiza la clase
		try {
			clase = Class.forName(className);
			// Crear una nueva instancia de la clase
			try {
				miclase = clase.newInstance();
				// Obtiene el metodo indicando y el tipo de parámetro
				// param[0]=int.class;
				try {
					metodo = clase.getMethod(methodName, int.class);
					// Invocar al método
					try {
						metodo.invoke(miclase, new Integer(n));
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * @param output Nombre del fichero de salida
	 * @param startN Valor inicial de carga
	 * @param endN Valor final de carga
	 * @param times Veces que se ejecuta un algoritmo para un determinado valor de carga
	 * @param clase Clase donde se encuentra el métod a invocar
	 * @param metodo Método a invocar
	 */
	public void test4(String output, int startN, int endN, int times, String clase, String metodo) {

		FileWriter file = null;
		PrintWriter pw;
		double time_ini, time_fin, tiempo;

		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			for (int carga = startN; carga <= endN; carga++) {
				time_ini = System.nanoTime();
				for (int veces = 1; veces <= times; veces++)
					testAlgorithm(clase, metodo,carga);
				time_fin = System.nanoTime();
				tiempo = time_fin - time_ini;
				System.out.println("Ejecutando " + carga);
				pw.print(carga + "; ");
				pw.format(Locale.FRANCE, "%f%n", tiempo / (double) times);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null)
				try {
					file.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}
	
	

}
