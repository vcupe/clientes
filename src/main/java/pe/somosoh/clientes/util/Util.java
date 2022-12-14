package pe.somosoh.clientes.util;

public class Util {
	
	public static boolean esPrimo(int numero) {	  
	  if (numero == 0 || numero == 1 || numero == 4) {
	    return false;
	  }
	  for (int x = 2; x < numero / 2; x++) {
	    if (numero % x == 0)
	      return false;
	  }
	  return true;
	}

}
