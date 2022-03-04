package metodosinterfazusuario;
import mismetodosgenerales.*;
import clasesinstanciables.*;
import excepciones.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Map.Entry;
public class MetodosConcretos {
	/**
	 * Metodo que se encarga de pedir los datos de un cliente y crear un objeto de tipo
	 * cliente con esos datos.
	 * @return Devuelve un objeto de tipo cliente
	 */
	public static Cliente PideDatosCliente(Empresa empresa)
	{
		Cliente _cliente =null;
		Carnet _carnet=null;
		String _opccarnet=null;
		String _dni=interfazusuario.PideDniValidad();
		String _nombre=interfazusuario.PideCadenaValidada(35, "Introduzca su nombre:");
		String _ap1=interfazusuario.PideCadenaValidada(35, "Introduzca su primer apellido:");
		String _ap2=interfazusuario.PideCadenaValidada(35, "Introduzca su segundo apellido:");
		do
		{
			_opccarnet=interfazusuario.PideCadenaValidada(3, "Introduzca su tipo de carnet:");
			if (empresa.BuscaCarnet(_opccarnet)!=null)
			{
				 _carnet=empresa.BuscaCarnet(_opccarnet);
			}
			else
			{
				System.out.println("Tipo de carnet no valido.");
			}
		} 
		while (empresa.BuscaCarnet(_opccarnet)==null);
		 
		try 
		{
			_cliente=new Cliente(_dni,_nombre,_ap1,_ap2,_carnet);
		} catch (DniNoValidoException e)
		{
			System.out.println("Dni no valido.");
		} catch (LongitudNoValidaException e)
		{
			System.out.println("Longitud no valida.");
		}		

		if (interfazusuario.MenuSioNo("¿Es usted cliente habitual?")==1)
		{
			try
			{
			int _ntarjetacliente=interfazusuario.PideNumeroValidado(1, 100000, "Introduzca su nº de cliente habitual: ");
			_cliente.setNtarjetacliente(_ntarjetacliente);
			}
			catch (ValorNoValidoException e)
			{
				System.out.println("Valor no valido");
			}
		}
		
		return _cliente;
	}
	/**
	 * Metodo que se encarga de pedir los datos de una categoria y crear un objeto categoria con esos datos
	 * @return Devuelve un objeto de tipo categoria
	 */
	public static Categoria PideDatosCategoria()
	{
		Categoria _categoria=null;
		String _codcategoria=interfazusuario.PideCadenaValidada(8, "Introduzca el codigo de la categoria: ");
		String _descripcion=interfazusuario.PideCadenaValidada(300, "Introduzca una descripcion para la categoria: ");
		int _recargoalquileres=interfazusuario.PideNumeroValidado(1, 100000, "Introduzca el recargo del alquiler: ");
		try
		{
			_categoria=new Categoria(_codcategoria,_descripcion,_recargoalquileres);
		}
		catch (LongitudNoValidaException e)
		{
			System.out.println("Longitud no valida.");

		}
		return _categoria;
	}
	/**
	 * Metodo que pide los datos de una oficina, y los introduce en un objeto oficina. 
	 * Tambien pregunta si es una oficina de aeropuerto, y si es asi se lo manda al objeto 
	 * creado con un set.
	 * @return Devuelve un objeto de tipo oficina
	 */
	public static Oficina PideDatosOficina()
	{
		Oficina _oficina=null;
		String _codigoofi=interfazusuario.PideCadenaValidada(8, "Introduzca el codigo de la oficina: ");
		String _descripcion=interfazusuario.PideCadenaValidada(300, "Introduzca una descripcion para la oficina: ");
		String _localidad=interfazusuario.PideCadenaValidada(75, "Introduzca la localidad en que se encuentra la oficina: ");
		String _provincia=interfazusuario.PideCadenaValidada(35, "Introduzca la provincia en que se encuentra la oficina: ");
		try
		{
			_oficina=new Oficina(_codigoofi,_descripcion,_localidad,_provincia);
		}
		catch (LongitudNoValidaException e)
		{
			System.out.println("Longitud no valida.");

		}
		if (interfazusuario.MenuSioNo("¿Es una oficina de aeropuerto?")==1)
		{
			boolean _ofiaeropuerto=true;
			_oficina.setOfiaeropuerto(_ofiaeropuerto);
		}
		return _oficina;
	}
	/*
	 * Metodo que se encarga de pedir los datos de un empleado. Crea un objeto de este tipo 
	 * e introduce los datos pedidos.
	 * @return Devuelve el objeto empleado.
	 */
	public static Empleado PideDatosEmpleado(Empresa empresa)
	{
		Empleado _empleado=null;
		String _opcofi=null;
		Oficina _oficina=null;
		String _dni=interfazusuario.PideDniValidad();
		String _nombre=interfazusuario.PideCadenaValidada(35, "Introduzca su nombre:");
		String _ap1=interfazusuario.PideCadenaValidada(35, "Introduzca su primer apellido:");
		String _ap2=interfazusuario.PideCadenaValidada(35, "Introduzca su segundo apellido:");
		GregorianCalendar _faltaempresa=interfazusuario.PideFechaValidada("Introduzca la fecha de alta en la empresa: ");
		do
		{
			_opcofi=interfazusuario.PideCadenaValidada(8, "Introduzca el codigo de la oficina: ");
			if (empresa.BuscaOficina(_opcofi)!=null)
			{
				 _oficina=empresa.BuscaOficina(_opcofi);
			}
			else
			{
				System.out.println("Codigo de oficina no existente.");
			}
		} 
		while (empresa.BuscaOficina(_opcofi)==null);
		try
		{
		_empleado=new Empleado(_dni,_nombre,_ap1,_ap2,_faltaempresa,_oficina);
		}
		catch (DniNoValidoException e)
		{
			System.out.println("Dni no valido.");

		}
		catch (LongitudNoValidaException e)
		{
			System.out.println("Longitud no valida.");
		}
		return _empleado;
	}
	/**
	 * Metodo que se encarga de pedir los datos de un vehiculo, pregunta a través de menus,
	 * si es electrico o de combustion. Si es electrico, pregunta si es coche o moto y pide los
	 * datos del que se haya elegido, para despues crear un objeto de ese tipo. Si es de combustion,
	 * hace lo mismo, pero con los datos referentes a furgoneta y coche de combustión.
	 * @return Devuelve un objeto de tipo vehiculo
	 */
	public static Vehiculo PideDatosVehiculo(Empresa empresa)
	{
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		opciones.add("Electrico");
		opciones.add("Combustión");
		Vehiculo _vehiculo=null;
		String _nbastidor=interfazusuario.PideCadenaValidada(17, "Numero de bastidor: ");
		String _matricula=interfazusuario.PideCadenaValidada(7, "Matricula: ");
		String _marca=interfazusuario.PideCadenaValidada(35, "Marca: ");
		String _modelo=interfazusuario.PideCadenaValidada(35, "Modelo: ");
		String _color=interfazusuario.PideCadenaValidada(20, "Color: ");
		int _kms=interfazusuario.PideNumeroValidado(0, 2000000, "Kilometros del vehiculo: ");
		GregorianCalendar _faltaoadqui=interfazusuario.PideFechaValidada("Fecha de adquisicion: ");
		Categoria _categoria=null;
		String _opccat;
		do
		{
			_opccat=interfazusuario.PideCadenaValidada(8, "Introduzca el tipo de categoria: ");
			if (empresa.BuscaCategoria(_opccat)!=null)
			{
				 _categoria=empresa.BuscaCategoria(_opccat);
			}
			else
			{
				System.out.println("Categoria no existente.");
			}
		} 
		while (empresa.BuscaCategoria(_opccat)==null);
		String _opcofi=null;
		Oficina _oficina=null;
		do
		{
			_opcofi=interfazusuario.PideCadenaValidada(8, "Introduzca el codigo de la oficina: ");
			if (empresa.BuscaOficina(_opcofi)!=null)
			{
				 _oficina=empresa.BuscaOficina(_opcofi);
			}
			else
			{
				System.out.println("Codigo de oficina no existente.");
			}
		} 
		while (empresa.BuscaOficina(_opcofi)==null);
		int _autonomia;
		int _tiempodecarga;
		int _nplazas;
		String _tipo;
		Carnet _carnetrequerido=null;
		String _opccarnet=null;
		int _consumo;
		int _potencia;
		int _cilindrada;
		String _nvemisiones;
		
		opcion=interfazusuario.MenuInt("¿Que tipo de vehiculo es?", opciones, 1, 4);
		if (opcion==1)
		{
			_autonomia=interfazusuario.PideNumeroValidado(1, 600, "Kms de autonomia: ");
			_tiempodecarga=interfazusuario.PideNumeroValidado(1, 600, "Tiempo de carga en minutos: ");
			opciones.clear();
			opciones.add("Coche Electrico");
			opciones.add("Moto");
			opcion=interfazusuario.MenuInt("SELECCIONE UNO.", opciones, 1, 2);
			if (opcion==1)
			{
				_nplazas=interfazusuario.PideNumeroValidado(1, 9, "Nº de plazas: ");
				_tipo=interfazusuario.PideCadenaValidada(15, "Tipo de coche: ");
				try
				{
				_vehiculo=new Cocheelectrico(_nbastidor,_matricula,_marca,_modelo, _color,
						_faltaoadqui, _kms,_categoria,_oficina,_autonomia,_tiempodecarga,_nplazas,_tipo);
				}
				catch (LongitudNoValidaException e)
				{
					System.out.println("Longitud no valida.");
				}
				catch (ValorNoValidoException e)
				{
					System.out.println("Valor no valido");
				}
			}
			else
			{
				_cilindrada=interfazusuario.PideNumeroValidado(1, 3000, "Cilindrada: ");
				do
				{
					_opccarnet=interfazusuario.PideCadenaValidada(3, "Introduzca su tipo de carnet:");
					if (empresa.BuscaCarnet(_opccarnet)!=null)
					{
						 _carnetrequerido=empresa.BuscaCarnet(_opccarnet);
					}
					else
					{
						System.out.println("Tipo de carnet no valido.");
					}
				} 
				while (empresa.BuscaCarnet(_opccarnet)==null);
				try
				{
				_vehiculo=new Moto(_nbastidor,_matricula,_marca,_modelo, _color,
						_faltaoadqui, _kms,_categoria,_oficina,_autonomia,_tiempodecarga,_cilindrada,_carnetrequerido);
				}
				catch (LongitudNoValidaException e)
				{
					System.out.println("Longitud no valida.");
				}
				catch (ValorNoValidoException e)
				{
					System.out.println("Valor no valido");
				}
			}	
		}
		else
		{
			_consumo=interfazusuario.PideNumeroValidado(1, 600, "Consumo: ");
			_potencia=interfazusuario.PideNumeroValidado(1, 600, "Potencia: ");
			_nvemisiones=interfazusuario.PideCadenaValidada(6, "Nivel de emisiones: ");
			opciones.clear();
			opciones.add("Coche Combustión");
			opciones.add("Furgoneta");
			opcion=interfazusuario.MenuInt("SELECCIONE UNO.", opciones, 1, 2);
			if (opcion==1)
			{
				_nplazas=interfazusuario.PideNumeroValidado(1, 9, "Nº de plazas: ");
				_tipo=interfazusuario.PideCadenaValidada(15, "Tipo de coche: ");
				try
				{
				_vehiculo=new Cochecomb(_nbastidor,_matricula,_marca,_modelo, _color,
						_faltaoadqui, _kms,_categoria,_oficina,_consumo,_potencia,_nvemisiones,_nplazas,_tipo);
				}
				catch (LongitudNoValidaException e)
				{
					System.out.println("Longitud no valida.");
				}
				catch (ValorNoValidoException e)
				{
					System.out.println("Valor no valido");
				}
			}
			else
			{
				double _capacidad=interfazusuario.PideNumeroValidadoDouble(1.00, 10.00, "Capacidad: ");
				do
				{
					_opccarnet=interfazusuario.PideCadenaValidada(3, "Introduzca su tipo de carnet:");
					if (empresa.BuscaCarnet(_opccarnet)!=null)
					{
						 _carnetrequerido=empresa.BuscaCarnet(_opccarnet);
					}
					else
					{
						System.out.println("Tipo de carnet no valido.");
					}
				} 
				while (empresa.BuscaCarnet(_opccarnet)==null);
				try
				{
				_vehiculo=new Furgoneta(_nbastidor,_matricula,_marca,_modelo, _color,
						_faltaoadqui, _kms,_categoria,_oficina,_consumo,_potencia,_nvemisiones,_capacidad,_carnetrequerido);
				}
				catch (LongitudNoValidaException e)
				{
					System.out.println("Longitud no valida.");
				}
				catch (ValorNoValidoException e)
				{
					System.out.println("Valor no valido");
				}
			}
		}
		return _vehiculo;	
	}
	
	public static Empresa PideDatosEmpresa()
	{
		Empresa empresa=null;
		String _nif;
		String _nombre;
		_nif=interfazusuario.PideCadenaValidada(9, "Nif de la empresa: ");
		_nombre=interfazusuario.PideCadenaValidada(75, "Nombre de la empresa: ");
		try
		{
			empresa=new Empresa(_nif,_nombre);
		}
		catch (LongitudNoValidaException e)
		{
			System.out.println("Longitud no valida.");

		}
		return empresa;
	}
	
	public static Carnet PideDatosCarnet()
	{
		Carnet carnet=null;
		String _tipo;
		String _descripcion;
		_tipo=interfazusuario.PideCadenaValidada(3, "Introduzca el tipo de carnet: ");
		_descripcion=interfazusuario.PideCadenaValidada(300, "Introduzca una descripción: ");
		carnet=new Carnet(_tipo,_descripcion);
		return carnet;
		
	}
	
	public static void MostrarPlantilla(Empresa empresa)
	{
		for(Entry<String, Empleado> item:empresa.getPlantilla().entrySet())
		{
			String dni= item.getKey();
			Empleado empleado=item.getValue();
			System.out.println(empleado);
		}
	}
	
	public static void MostrarTiposCarnet(Empresa empresa)
	{
		for(Entry<String, Carnet> item:empresa.getTiposdecarnet().entrySet())
		{
			String tipo= item.getKey();
			Carnet carnet=item.getValue();
			System.out.println(carnet);
		}
	}
	
	public static void MostrarListaOficinas(Empresa empresa)
	{
		for(Entry<String, Oficina> item:empresa.getListaoficinas().entrySet())
		{
			String codigoofi= item.getKey();
			Oficina oficina=item.getValue();
			System.out.println(oficina);
		}
	}
	
	public static void MostrarStockVehiculos(Empresa empresa)
	{
		for(Entry<String, Vehiculo> item:empresa.getListavehiculos().entrySet())
		{
			String matricula= item.getKey();
			Vehiculo vehiculo=item.getValue();
			System.out.println(vehiculo);
		}
	}
	
	public static void MostrarListaCategorias(Empresa empresa)
	{
		for(Entry<String, Categoria> item:empresa.getListacategorias().entrySet())
		{
			String codcategoria= item.getKey();
			Categoria categoria=item.getValue();
			System.out.println(categoria);
		}
	}
	
	
}
