package logica_de_negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import clasesinstanciables.*;
import excepciones.ValorNoValidoException;
import metodosinterfazusuario.MetodosConcretos;
import mismetodosgenerales.interfazusuario;

public class MetodosAlquileres {

	public static Alquiler RealizaAlquiler(Empresa empresa)
	{
		Alquiler alquiler=null;
		/*Creamos dos arraylist, para poder trabajar con ellos, uno sera de los vehiculos que tenemos disponibles,
		 * y el otro sera para los que tenemos alquilados.
		 * Para poder tener actualizada la lista de vehiculos disponibles lo que hago es hacer un bucle dentro de otro
		 * el primero recorre los vehiculos alquilados y el de dentro los disponibles(que sera igual a los de la lista de stock 
		 * que le pasa el treemap), lo que hace el bucle es buscar lo vehiculos alquilados y quitarselos a los disponibles.*/
		ArrayList<Vehiculo>vehiculosdisponibles=new ArrayList<Vehiculo>(empresa.getListavehiculos().values());
		ArrayList<Vehiculo>vehiculosalquilados=new ArrayList<Vehiculo>(empresa.getVehiculosalquilados().values());
		for (int i=0;i<vehiculosalquilados.size();i++)
		{
			for (int j=0;j<vehiculosdisponibles.size();j++)
			{
				vehiculosdisponibles.remove(vehiculosalquilados.get(i));
			}
		}
		String _codalquiler=interfazusuario.PideCadenaValidada(10, "Introduzca el codigo del alquiler: ");
		String _dni=interfazusuario.PideDniValidad();
		Empleado _empleado=empresa.BuscaEmpleado(_dni);
		Vehiculo vehiculo;
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		String codigoofi;
		String codigocat;
		opciones.add("OFICINA");
		opciones.add("CATEGORIA");
		opcion=interfazusuario.MenuInt("¿COMO QUIERE BUSCAR EL VEHICULO?", opciones, 1, 2);
		if (opcion==1)
		{
			codigoofi=interfazusuario.PideCadenaValidada(8, "Introduzca el codigo de la oficina: ");
			vehiculo=MetodosConcretos.BuscaVehiculoPorOficina(empresa, codigoofi, vehiculosdisponibles);
		}
		else
		{
			codigocat=interfazusuario.PideCadenaValidada(8, "Introduzca el codigo de la categoria: ");
			vehiculo=MetodosConcretos.BuscaVehiculoPorCategoria(empresa, codigocat, vehiculosdisponibles);
		}
		empresa.AñadeVehiculoAlquilado(vehiculo);//AQUI AÑADIMOS EL VEHICULO A LA LISTA DE VEHICULOS ALQUILADOS
		//HAY QUE CREAR UNA LISTA DE STOCK DISPONIBLE Y CAMBIARLA POR LAS LISTAS DE ABAJO (BUSCA VEHICULO POR
		//OFICINA Y CATEGORIA) Y TAMBIEN HAY QUE BORRAR EL VEHICULO K SE ALQUILA DE ESA LISTA CUANDO SE HACE UN ALQUILER
		
		Cliente _cliente=MetodosConcretos.PideDatosCliente(empresa);
		GregorianCalendar _finialquiler=interfazusuario.PideFechaValidada("¿En que fecha quiere alquilarlo?");
		GregorianCalendar _ffinalquiler=interfazusuario.PideFechaValidada("¿En que fecha tiene previsto devolverlo?");
		
		//Calculamos los dias transcurridos entre las dos fechas
		//pasamos la fecha final a milisegundos y hacemos lo mismo con la fecha de inicio
		long finMS=_ffinalquiler.getTimeInMillis();
		long inicioMS=_finialquiler.getTimeInMillis();
		//restamos los resultados, y lo pasamos a dias
		int diasalquilado= (int)((Math.abs(finMS-inicioMS))/(1000*60*60*24));
		
		int tipo=vehiculo.getTipovehiculo();
		
		double precio=CalcularPrecioPrevisto(empresa,vehiculo.getMatricula(),diasalquilado,tipo);
		
		String _opcofi=interfazusuario.PideCadenaValidada(8, "Introduzca el codigo de la oficina en donde lo devolverá: ");
		Oficina lugardevolucion=empresa.BuscaOficina(_opcofi);
		
		alquiler=new Alquiler(_codalquiler,vehiculo,_empleado,_cliente,_finialquiler,_ffinalquiler,lugardevolucion,precio);
		
		return alquiler;
	}
	
	/**
	 * Metodo que te calcula el precio previsto del alquiler a traves del metodo de calcula importe, en funcion
	 * del tipo de vehiculo que sea.
	 * @param empresa
	 * @param matricula
	 * @param diasalquilado
	 * @param tipo
	 * @return
	 */
	public static double CalcularPrecioPrevisto(Empresa empresa,String matricula,int diasalquilado,int tipo)
	{
		double precio=0;
		switch (tipo)
		{
			case 1://COCHE ELECTRICO
				Cocheelectrico celec=empresa.BuscaCocheelect(matricula);
				precio=celec.CalculaImporte(diasalquilado, celec.getCategoria().getRecargoalquileres(), celec.getUbicacion().isOfiaeropuerto());
				break;
			case 2://MOTO
				Moto moto=empresa.BuscaMoto(matricula);
				precio=moto.CalculaImporte(diasalquilado, moto.getCategoria().getRecargoalquileres(), moto.getUbicacion().isOfiaeropuerto());
				break;
			case 3://COCHE COMBUSTION
				Cochecomb ccomb=empresa.BuscaCochecomb(matricula);
				precio=ccomb.CalculaImporte(diasalquilado, ccomb.getCategoria().getRecargoalquileres(),ccomb.getUbicacion().isOfiaeropuerto());
				break;
			case 4://FURGONETA
				Furgoneta furgo=empresa.BuscaFurgoneta(matricula);
				precio=furgo.CalculaImporte(diasalquilado, furgo.getCategoria().getRecargoalquileres(), furgo.getUbicacion().isOfiaeropuerto());
				break;
		}
		return precio;
	}
	
	/**
	 * Metodo que se encarga de modificar los distintos vehiculos en funcion del tipo al que pertenezcan,
	 * cambiando sus kms y su oficina en la devolucion y despues añadiendolo a la lista de stock
	 * @param empresa
	 * @param matricula
	 * @param kmsrecorridos
	 * @param tipo
	 * @param ofidevolucion
	 * @throws ValorNoValidoException
	 */
	public static void ModificacionesDevolucion(Empresa empresa,String matricula,int kmsrecorridos,int tipo,Oficina ofidevolucion)throws ValorNoValidoException
	{
		switch (tipo)
		{
			case 1://COCHE ELECTRICO
				Cocheelectrico celec=empresa.BuscaCocheelect(matricula);
				celec.setKms(celec.getKms()+kmsrecorridos);
				celec.setUbicacion(ofidevolucion);
				empresa.AñadeVehiculo(empresa, celec);
				break;
			case 2://MOTO
				Moto moto=empresa.BuscaMoto(matricula);
				moto.setKms(moto.getKms()+kmsrecorridos);
				moto.setUbicacion(ofidevolucion);
				empresa.AñadeVehiculo(empresa, moto);
				break;
			case 3://COCHE COMBUSTION
				Cochecomb ccomb=empresa.BuscaCochecomb(matricula);
				ccomb.setKms(ccomb.getKms()+kmsrecorridos);
				ccomb.setUbicacion(ofidevolucion);
				empresa.AñadeVehiculo(empresa, ccomb);
				break;
			case 4://FURGONETA
				Furgoneta furgo=empresa.BuscaFurgoneta(matricula);
				furgo.setKms(furgo.getKms()+kmsrecorridos);
				furgo.setUbicacion(ofidevolucion);
				empresa.AñadeVehiculo(empresa, furgo);
				break;
		}
	}

	
	
	
	
}
