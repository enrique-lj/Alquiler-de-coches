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
			vehiculo=BuscaVehiculoPorOficina(empresa, codigoofi, vehiculosdisponibles);
		}
		else
		{
			codigocat=interfazusuario.PideCadenaValidada(8, "Introduzca el codigo de la categoria: ");
			vehiculo=BuscaVehiculoPorCategoria(empresa, codigocat, vehiculosdisponibles);
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
	
	public static void RealizarDevolucion(Empresa empresa)
	{
		String _codalquiler=interfazusuario.PideCadenaValidada(10, "Introduzca el codigo del alquiler: ");
		Alquiler a=empresa.BuscaAlquiler(_codalquiler);
		Empleado _empleadodev=null;
		Empleado _empleadoaux;
		do
		{
			String _dni=interfazusuario.PideDniValidad();
			 _empleadoaux=empresa.BuscaEmpleado(_dni);
			if (_empleadoaux.getOfitrabajador().getCodigoofi().equals(a.get_lugaralquiler().getCodigoofi()))
			{
				_empleadodev=_empleadoaux;
			}
			else
			{
				System.out.println("Usuario u oficina incorrecto.");
				System.out.println("Es necesario que el DNI del empleado corresponda a su oficina.");
			}
		}
		while (!(_empleadoaux.getOfitrabajador().getCodigoofi().equals(a.get_lugaralquiler().getCodigoofi())));
		
		GregorianCalendar _fdevolucion=interfazusuario.PideFechaValidada("Fecha de devolución: ");
		//Calculamos los dias transcurridos entre las dos fechas
		//pasamos la fecha final a milisegundos y hacemos lo mismo con la fecha de inicio
		long finMS=_fdevolucion.getTimeInMillis();
		long inicioMS=a.get_finialquiler().getTimeInMillis();
		//restamos los resultados, y lo pasamos a dias
		int diasalquilado= (int)((Math.abs(finMS-inicioMS))/(1000*60*60*24));
		//Sacamos el tipo de vehiculo que es, para pasarselo al metodo de calcular precio;
		int tipo=a.get_vehiculo().getTipovehiculo();
		double _preciofinal=CalcularPrecioPrevisto(empresa,a.get_vehiculo().getMatricula(), diasalquilado, tipo);
		
		int _kmsrecorridos=interfazusuario.PideNumeroValidado(1, 1000000, "Introduzca los kilometros que ha recorrido: ");
		try {
			ModificacionesDevolucion(empresa, a.get_vehiculo().getMatricula(), _kmsrecorridos, tipo,a.get_lugaralquiler());
		} catch (ValorNoValidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		empresa.BorraCocheAlquilado(a.get_vehiculo().getMatricula());
		a.setEmpleadodev(_empleadodev);
		a.setFdevolucion(_fdevolucion);
		a.setKmsrecorridos(_kmsrecorridos);
		a.setPreciofinal(_preciofinal);
	}
	
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

	public static Vehiculo BuscaVehiculoPorOficina(Empresa empresa,String codigoofi,ArrayList<Vehiculo>vehiculosdisponibles)
	{
		Vehiculo vehiculo=null;
		ArrayList<Vehiculo>vehiculosvalidos=new ArrayList<Vehiculo>();
		for (int i=0; i<vehiculosdisponibles.size();i++)
		{
			if (vehiculosdisponibles.get(i).getUbicacion().getCodigoofi().equals(codigoofi))
			{
				vehiculosvalidos.add(vehiculosdisponibles.get(i));
			}
		}
		for (int i=0; i<vehiculosvalidos.size();i++)
		{
			System.out.println((i+1)+".-"+(vehiculosvalidos.get(i)));
		}
		int opcion=interfazusuario.PideNumeroValidado(0, vehiculosvalidos.size()+1,"ESCOJA UN VEHICULO");//HAY QUE AJUSTAR ESTO XK ME SALE FUERA DE RANGO
		opcion=opcion-1;
		for (int i=0; i<vehiculosvalidos.size();i++)
		{
			vehiculo=vehiculosvalidos.get(opcion);
		}
		return vehiculo;
	}
	
	
	public static Vehiculo BuscaVehiculoPorCategoria(Empresa empresa,String codigocategoria,ArrayList<Vehiculo>vehiculosdisponibles)
	{
		Vehiculo vehiculo=null;
		ArrayList<Vehiculo>vehiculosvalidos=new ArrayList<Vehiculo>();
		for (int i=0; i<vehiculosdisponibles.size();i++)
		{
			if (vehiculosdisponibles.get(i).getCategoria().getCodcategoria().equals(codigocategoria))
			{
				vehiculosvalidos.add(vehiculosdisponibles.get(i));
			}
		}
		for (int i=0; i<vehiculosvalidos.size();i++)
		{
			System.out.println((i+1)+".-"+(vehiculosvalidos.get(i)));
		}
		
		int opcion=interfazusuario.PideNumeroValidado(0, vehiculosvalidos.size()+1,"ESCOJA UN VEHICULO");//HAY QUE AJUSTAR ESTO XK ME SALE FUERA DE RANGO
		opcion=opcion-1;
		for (int i=0; i<vehiculosvalidos.size();i++)
		{
			vehiculo=vehiculosvalidos.get(opcion);
		}
		return vehiculo;
	}
	
}
