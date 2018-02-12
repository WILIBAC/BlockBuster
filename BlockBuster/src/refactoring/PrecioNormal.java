package refactoring;
/**
 * @author M.Fowler traducci�n: Manuel Garc�a
 *21.1 Precio Normal Creaci�n de m�todo override getPrecio(int)
 */
class PrecioNormal extends PrecioRefactoring {

	@Override
	int getCodigoPrecio() {
		return PeliculaRefactoring.NORMAL;
	}
	
	@Override
	double getPrecio(int diasAlquilados) {
		double resultado=2;
		if(diasAlquilados > 2) {
			resultado+= (diasAlquilados - 2)*1.5;
		}
		return resultado;
	}
	
}
