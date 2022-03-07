package comparadores;

import java.util.Comparator;

import clasesinstanciables.Cliente;

public class NsocioComparator implements Comparator<Cliente> {

	@Override
	public int compare(Cliente cliente1, Cliente cliente2) {
		
		int respuesta;
		if (cliente1.getNtarjetacliente()>cliente2.getNtarjetacliente())
		{
			respuesta=1;
		}
		else if (cliente1.getNtarjetacliente()<cliente2.getNtarjetacliente())
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
