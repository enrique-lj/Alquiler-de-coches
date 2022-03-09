package comparadores;

import java.util.Comparator;

import clasesinstanciables.Persona;

public  class NombreComparator implements Comparator<Persona> {

	@Override
	public int compare(Persona p1,Persona p2) {
		
		return p1.getNombre().compareTo(p2.getNombre());
	}

	

}
