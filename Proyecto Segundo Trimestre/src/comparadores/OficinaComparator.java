package comparadores;

import java.util.Comparator;

import clasesinstanciables.Empleado;

public class OficinaComparator implements Comparator <Empleado> {

	@Override
	public int compare(Empleado o1, Empleado o2) {
		int respuesta;
		if(o1.getOfitrabajador().getCodigoofi().compareToIgnoreCase(o2.getOfitrabajador().getCodigoofi())>0)
		{
			respuesta=1;
		}
		else if (o1.getOfitrabajador().getCodigoofi().compareToIgnoreCase(o2.getOfitrabajador().getCodigoofi())<0)
		{
			respuesta=-1;
		}
		else
		{
			if(o1.NombreCompleto().compareToIgnoreCase(o2.NombreCompleto())>0)
			{
				respuesta=1;
			}
			else if(o2.NombreCompleto().compareToIgnoreCase(o2.NombreCompleto())<0)
			{
				respuesta=-1;
			}
			else
			{
				respuesta=0;
			}
		}
		return respuesta;
	}

}
