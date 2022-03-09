package comparadores;

import java.util.Comparator;

import clasesinstanciables.Vehiculo;

public class MarcaComparator implements Comparator <Vehiculo> {

	@Override
	public int compare(Vehiculo o1, Vehiculo o2) {
		int respuesta;
		if (o1.getMarca().compareToIgnoreCase(o2.getMarca())>0)
		{
			respuesta=1;
		}
		else if (o1.getMarca().compareToIgnoreCase(o2.getMarca())<0)
		{
			respuesta=-1;
		}
		else
		{
			if (o1.getModelo().compareToIgnoreCase(o2.getModelo())>0)
			{
				respuesta=1;
			}
			else if (o1.getModelo().compareToIgnoreCase(o2.getModelo())<0)
			{
				respuesta=-1;
			}
			else
			{
				if(o1.getColor().compareToIgnoreCase(o2.getColor())>0)
				{
					respuesta=1;
				}
				else if (o1.getColor().compareToIgnoreCase(o2.getColor())<0)
				{
					respuesta=-1;
				}
				else
				{
					respuesta=0;
				}
			}
		}
		return respuesta;
	}

	

}
