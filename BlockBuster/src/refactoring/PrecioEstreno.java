package refactoring;
/**
 * @author M.Fowler traducci�n: Manuel Garc�a
 *21.2 Precio Estreno Creaci�n de m�todo override getPrecio(int)
 *25.1 Se crea un override para puntosClienteFrecuente
 */
class PrecioEstreno extends PrecioRefactoring{

	@Override
	int getCodigoPrecio() {
		return PeliculaRefactoring.ESTRENO;
	}
	
	@Override
	double getPrecio(int diasAlquilados) {
		return diasAlquilados*3;
	}
	
	@Override
	int getPuntosClienteFrecuente(int diasAlquilados) {
		return (diasAlquilados>1)?2:1;
	}
}
