package metodosinterfazusuario;
import mismetodosgenerales.*;
import clasesinstanciables.*;
import excepciones.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
public class MetodosConcretos {
	/**
	 * Metodo que se encarga de pedir los datos de un cliente y crear un objeto de tipo
	 * cliente con esos datos.
	 * @return Devuelve un objeto de tipo cliente
	 */
	public static Cliente PideDatosCliente()
	{
		Cliente _cliente =null;
		String _dni=interfazusuario.PideDniValidad();
		String _nombre=interfazusuario.PideCadenaValidada(35, "Introduzca su nombre:");
		String _ap1=interfazusuario.PideCadenaValidada(35, "Introduzca su primer apellido:");
		String _ap2=interfazusuario.PideCadenaValidada(35, "Introduzca su segundo apellido:");
		/*opccarnet es el tipo de carnet que tiene el cliente, el cual luego se introducirá en el
		 * TreeMap, para ver si hay un objeto Carnet con el mismo tipo. Si lo hay, lo saca y lo
		 * introduce en la variable _carnet.
		*/
		String _opccarnet=interfazusuario.PideCadenaValidada(3, "Introduzca su tipo de carnet:");
		//Metodo.BuscaCarnet(_opccarnet)
		Carnet _carnet=null;
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
	public static Empleado PideDatosEmpleado()
	{
		Empleado _empleado=null;
		String _dni=interfazusuario.PideDniValidad();
		String _nombre=interfazusuario.PideCadenaValidada(35, "Introduzca su nombre:");
		String _ap1=interfazusuario.PideCadenaValidada(35, "Introduzca su primer apellido:");
		String _ap2=interfazusuario.PideCadenaValidada(35, "Introduzca su segundo apellido:");
		GregorianCalendar _faltaempresa=interfazusuario.PideFechaValidada("Introduzca la fecha de alta en la empresa: ");
		Oficina _oficina=PideDatosOficina();
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
	public static Vehiculo PideDatosVehiculo()
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
		Categoria _categoria=PideDatosCategoria();
		Oficina _oficina=PideDatosOficina();
		int _autonomia;
		int _tiempodecarga;
		int _nplazas;
		String _tipo;
		Carnet _carnetrequerido;
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
				_carnetrequerido=null;
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
				_carnetrequerido=null;
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
	
	/**
	 * Menu principal del programa el cual va a dictar el flujo de nuestro programa. Se compone de
	 * varios menus conectados entre si, que gestionan el mantenimiento de ficheros, los alquileres,
	 * muestra informes y serializa la empresa cuando se elige la opcion de salir.
	 */
	public static void MenuPrincipal(Empresa empresa)
	{
		System.out.println("BIENVENIDO");
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		String opc;
		do 
		{
			opciones.clear();
			opciones.add("MANTENIMIENTO DE FICHEROS MAESTROS");
			opciones.add("ALQUILERES");
			opciones.add("MOSTRAR INFORMES");
			opciones.add("SALIR");
			opcion=interfazusuario.MenuInt("CONFIGURACIÓN", opciones, 1, 4);
			switch (opcion) {
				case 1:
					do 
					{
						opciones.clear();
						opciones.add("OFICINA");
						opciones.add("CATEGORIA");
						opciones.add("EMPLEADO");
						opciones.add("VEHICULO");
						opciones.add("VOLVER");
						opcion=interfazusuario.MenuInt("ELIJA UNA OPCION", opciones, 1, 5);
						switch (opcion)
						{
							case 1:
								do
								{
									opc=interfazusuario.PideCadenaValidada(8,"Introduzca el codigo de la oficina: ");
									if(empresa.BuscaOficina(opc)!=null)
									{
										opciones.clear();
										opciones.add("MODIFICAR");
										opciones.add("BORRAR");
										opcion=interfazusuario.MenuInt("¿QUE QUIERES HACER?", opciones, 1, 2);
										if (opcion==1)
										{
											do
											{
												//Metodo.Modifica.Oficina			
											}
											while (interfazusuario.MenuSioNo("¿Desea modificar otra oficina?")==1);
										}
										else
										{
											do
											{
												empresa.BorraOficina(opc);			
											}
											while (interfazusuario.MenuSioNo("¿Desea borrar otra oficina?")==1);
										}
									}
									else
									{
										do
										{
											empresa.AñadeOficina();			
										}
										while (interfazusuario.MenuSioNo("¿Desea añadir otra oficina?")==1);
									}
									
								}
								while (interfazusuario.MenuSioNo("¿Desea buscar otra oficina?")==1);
								opcion=0;
								break;
							case 2:
								do
								{
									opc=interfazusuario.PideCadenaValidada(8,"Introduzca el codigo de la categoria: ");
									if(empresa.BuscaCategoria(opc)!=null)
									{
										opciones.clear();
										opciones.add("MODIFICAR");
										opciones.add("BORRAR");
										opcion=interfazusuario.MenuInt("¿QUE QUIERES HACER?", opciones, 1, 2);
										if (opcion==1)
										{
											do
											{
												//Metodo.Modifica.Categoria			
											}
											while (interfazusuario.MenuSioNo("¿Desea modificar otra categoria?")==1);
										}
										else
										{
											do
											{
												empresa.BorraCategoria(opc);			
											}
											while (interfazusuario.MenuSioNo("¿Desea borrar otra categoria?")==1);
										}
									}
									else
									{
										do
										{
											empresa.AñadeCategoria();			
										}
										while (interfazusuario.MenuSioNo("¿Desea añadir otra categoria?")==1);
									}
									
								}
								while (interfazusuario.MenuSioNo("¿Desea buscar otra categoria?")==1);
								opcion=0;
								break;
							case 3:
								do
								{
									opc=interfazusuario.PideDniValidad();
									if(empresa.BuscaEmpleado(opc)!=null)
									{
										opciones.clear();
										opciones.add("MODIFICAR");
										opciones.add("BORRAR");
										opcion=interfazusuario.MenuInt("¿QUE QUIERES HACER?", opciones, 1, 2);
										if (opcion==1)
										{
											do
											{
												//Metodo.Modifica.Empleado			
											}
											while (interfazusuario.MenuSioNo("¿Desea modificar otro empleado?")==1);
										}
										else
										{
											do
											{
												empresa.BorraEmpleado(opc);		
											}
											while (interfazusuario.MenuSioNo("¿Desea borrar otro empleado?")==1);
										}
									}
									else
									{
										do
										{
											empresa.AñadeEmpleado();		
										}
										while (interfazusuario.MenuSioNo("¿Desea dar de alta otro empleado?")==1);
									}
									
								}
								while (interfazusuario.MenuSioNo("¿Desea buscar otro empleado?")==1);
								opcion=0;
								break;
							case 4:
								do
								{
									opc=interfazusuario.PideCadenaValidada(7,"Introduzca la matricula: ");
									if(empresa.BuscaVehiculo(opc)!=null)
									{
										opciones.clear();
										opciones.add("MODIFICAR");
										opciones.add("BORRAR");
										opcion=interfazusuario.MenuInt("¿QUE QUIERES HACER?", opciones, 1, 2);
										if (opcion==1)
										{
											do
											{
												//Metodo.Modifica.Vehiculo			
											}
											while (interfazusuario.MenuSioNo("¿Desea modificar otro vehiculo?")==1);
										}
										else
										{
											do
											{
												empresa.BorraVehiculo(opc);		
											}
											while (interfazusuario.MenuSioNo("¿Desea borrar otro vehiculo?")==1);
										}
									}
									else
									{
										do
										{
											empresa.AñadeVehiculo();	
										}
										while (interfazusuario.MenuSioNo("¿Desea añadir otro vehiculo?")==1);
									}
									
								}
								while (interfazusuario.MenuSioNo("¿Desea buscar otro vehiculo?")==1);
								opcion=0;
								break;
						}
					}
					while (opcion!=5);
					break;
				case 2:
					opciones.clear();
					opciones.add("ALQUILAR");
					opciones.add("DEVOLVER");
					opcion=interfazusuario.MenuInt("OPCIONES", opciones, 1, 2);
					if (opcion==1)
					{
						//TODO METODO.ALQUILER
					}
					else 
					{
						//TODO METODO.DEVOLUCION
					}
					break;
				case 3:
					opciones.clear();
					opciones.add("ALQUILERES REALIZADOS SEGUN FECHA");
					opciones.add("ALQUILERES REALIZADOS SEGUN VEHICULO");
					opciones.add("LISTADO DE STOCK");
					opcion=interfazusuario.MenuInt("¿QUE DESEA MOSTRAR?", opciones, 1, 3);
					switch (opcion) {
					case 1:
						//TODO METODO.MUESTRA_SEGUN_FECHA
						break;
					case 2:
						//TODO METODO.MUESTRA_SEGUN_VEHICULO
						break;
					case 3:
						//TODO METODO.MUESTRA_LISTADO_STOCK	
						break;
					}
					break;
				case 4:
					Empresa.grabaEmpresa(empresa);
					break;
			}
		}
		while(opcion!=4);
	}
}
