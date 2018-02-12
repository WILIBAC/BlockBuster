package refactoring;
/**
 * @author M.Fowler traducci�n: Manuel Garc�a
 *21.2 Precio Infantil Creaci�n de m�todo override getPrecio(int)
 */
class PrecioInfantil extends PrecioRefactoring {

	@Override
	int getCodigoPrecio() {
		return PeliculaRefactoring.INFANTIL;
	}
	
	@Override
	double getPrecio(int diasAlquilados) {
		double resultado=1.5;
		if(diasAlquilados > 3) {
			resultado+= (diasAlquilados - 3)*1.5;
		}
		return resultado;
	}

}
