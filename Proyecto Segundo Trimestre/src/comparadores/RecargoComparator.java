package comparadores;

import java.util.Comparator;

import clasesinstanciables.Categoria;
import clasesinstanciables.Cliente;

public class RecargoComparator implements Comparator <Categoria> {

	@Override
	public int compare(Categoria o1, Categoria o2) {
		int respuesta;
		if (o1.getRecargoalquileres()<o2.getRecargoalquileres())
		{
			respuesta=1;
		}
		else if (o1.getRecargoalquileres()>o2.getRecargoalquileres())
		{
			respuesta=-1;
		}
		else
		{
			respuesta=0;
		}
		return respuesta;
	}
	

}
