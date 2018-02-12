package refactoring;
/**
 * @author M.Fowler traducci�n: Manuel Garc�a
 *4.1 Creamos el m�todo getPrecio a partir del m�todo pagoDe(Alquiler) de la clase ClienteR
 *13. Movemos getPrecio() para clase PeliculaR como getPrecio(int diasAlquilados) porque usa el objeto PeliculaR
 *14. Invocamos el m�todo getPrecio(int) a partir de la instancia pelicula en el m�todo getPrecio().
 *15. Movemos getPuntosClienteFrecuente  para clase PeliculaR como getPuntosClienteFrecuente(int diasAlquilados) porque usa el objeto Pelicula R.
 *16. Invocamos el m�todo getPuntosClienteFrecuente(int) a partir de la instancia pel�cula en el m�todo getPuntosClienteFrecuente()
 *17. ReplaceConditionalByPolimorphism Para cambiar el m�todo SWITCH.
 */
public class AlquilerRefactoring {
	
	private PeliculaRefactoring pelicula;
	private int diasAlquilados;
	
	public AlquilerRefactoring(PeliculaRefactoring pelicula, int diasAlquilados) {
		this.pelicula=pelicula;
		this.diasAlquilados=diasAlquilados;
	}
	
	double getPrecio() {
		return pelicula.getPrecio(diasAlquilados);
	}
	
	int getPuntosClienteFrecuente() {
		return pelicula.getPuntosClienteFrecuente(diasAlquilados);
	}
	

	public PeliculaRefactoring getPelicula() {
		return pelicula;
	}

	public int getDiasAlquilados() {
		return diasAlquilados;
	}


}
