package refactoring;

import java.util.Enumeration;
import java.util.Vector;

import org.apache.log4j.Logger;
/**
 * @author M.Fowler traducci�n: Manuel Garc�a
 * 1. Buscar variables locales para Extract Method: cadaVezQueRento y pagoUnitario
 * 2. Retirar el switch en un m�todo pagoDe(AlquilerR) con retorno de precioUnitario
 * 3. En donde se retir� el switch se hace la invocaci�n al m�todo pagoDe(AlquilerR)
 * 4. Movemos pagoDe(AlquilerR) para la clase AlquilerR pues los datos son del objeto AlquilerR
 * 5. Invocamos el m�todo getPrecio() creado en AlquilerR desde el m�todo pagoDe(AlquilerR)
 * 6. Usamos la misma invocaci�n a partir de la variable cadaVezQueRento y se elimina el m�todo pagoDe(Alquiler)
 * 7. ReplaceTempVarByQuery pagoUnitario ya que s�lo se usa en invocaciones de resultado
 * 8. Extract Method para puntosClienteFrecuente
 * 9. Creamos el m�todo getPuntosClienteFrecuente en la clase AlquilerR (envy)
 * 10. Invocamos a partir de la VAR cadaVezQueRento y asignamos los puntosClienteFrecuente
 * 11. Creamos el m�todo getPagoTotal() para reemplazar la variable pagoTotal y luego la invocamos
 * 12. Creamos el m�todo getPuntosClienteFrecuente() para reemplazar la variable puntosClienteFrecuente y luego la invocamos.
 */
public class ClienteRefactoring {
	
private static final Logger log = Logger.getLogger(ClienteRefactoring.class);
	
	private String nombre;
	private Vector alquileres = new Vector();
	
	public ClienteRefactoring(String nombre) {
		this.nombre=nombre;
	}
	
	public void agregarAlquiler(AlquilerRefactoring alquiler) {
		alquileres.addElement(alquiler);
	}
	
	public String cuenta() {
		
		Enumeration alquileresDelCliente = alquileres.elements();
		String resultado= "Reporte de Alquiler de "+getNombre();
		
		while(alquileresDelCliente.hasMoreElements()) {
			AlquilerRefactoring cadaVezQueRento = (AlquilerRefactoring) alquileresDelCliente.nextElement();
			
			//Mostrar valores por este Alquiler
			resultado += " >>> " + cadaVezQueRento.getPelicula().getTitulo() + " $/"+String.valueOf(cadaVezQueRento.getPrecio());
		}
		
		// Agregar detalle final
		resultado += " Pago Total: "+String.valueOf(getPagoTotal())+" -  Usted gan� : "+String.valueOf(getTotalPuntosClienteFrecuente())+" puntos de Cliente Frecuente";
		
		log.debug("resultado => "+resultado);
		return resultado;
		
	}
	
	private int getTotalPuntosClienteFrecuente() {
		int puntosClienteFrecuente = 0;
		Enumeration alquileresDelCliente = alquileres.elements();
		while(alquileresDelCliente.hasMoreElements()) {
			AlquilerRefactoring cadaVezQueRento = (AlquilerRefactoring) alquileresDelCliente.nextElement();
			puntosClienteFrecuente += cadaVezQueRento.getPuntosClienteFrecuente();
		}
		return puntosClienteFrecuente;
		
	}
	
	private double getPagoTotal() {
		double pagoTotal=0;
		Enumeration alquileresDelCliente = alquileres.elements();
		while(alquileresDelCliente.hasMoreElements()) {
			AlquilerRefactoring cadaVezQueRento = (AlquilerRefactoring) alquileresDelCliente.nextElement();
			pagoTotal += cadaVezQueRento.getPrecio();
		}
		return pagoTotal;
	}

	public String getNombre() {
		return nombre;
	}

}
