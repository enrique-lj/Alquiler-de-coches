package menus;
import mismetodosgenerales.*;
import clasesinstanciables.*;
import excepciones.LongitudNoValidaException;
import excepciones.ValorNoValidoException;
import metodosinterfazusuario.MetodosConcretos;
import java.util.ArrayList;
public class Menus {
	
	/**
	 * Menu principal del programa el cual va a dictar el flujo de nuestro programa. Se compone de
	 * varios menus conectados entre si, que gestionan el mantenimiento de ficheros, los alquileres,
	 * muestra informes y serializa la empresa cuando se elige la opcion de salir.
	 * @throws ValorNoValidoException 
	 * @throws LongitudNoValidaException 
	 */
	public static void MenuPrincipal(Empresa empresa) throws LongitudNoValidaException, ValorNoValidoException
	{
		//CAMBIAR EL MENSAJE POR UN METODO DE MENSAJE DE INICIO
		//System.out.println("BIENVENIDO");
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
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
					MenuMantenimiento(empresa);
					break;
				case 2:
					MenuAlquileres(empresa);
					break;
				case 3:
					MenuInformes(empresa);
					break;
				case 4:
					Empresa.grabaEmpresa(empresa);
					break;
			}
		}
		while(opcion!=4);
	}
	
	/**
	 * Metodo que muestra el menu de mantenimiento y te lleva a los distintos tipos de mantenimiento.
	 * @param empresa
	 * @throws ValorNoValidoException 
	 * @throws LongitudNoValidaException 
	 */
	public static void MenuMantenimiento(Empresa empresa) throws LongitudNoValidaException, ValorNoValidoException
	{
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		do 
		{
			opciones.clear();
			opciones.add("OFICINA");
			opciones.add("CATEGORIA");
			opciones.add("EMPLEADO");
			opciones.add("VEHICULO");
			opciones.add("CARNETS");
			opciones.add("VOLVER");
			opcion=interfazusuario.MenuInt("ELIJA UNA OPCION", opciones, 1, 6);
			switch (opcion)
			{
				case 1:
					MantenimientoOficinas(empresa);
					opcion=0;
					break;
				case 2:
					MantenimientoCategorias(empresa);
					opcion=0;
					break;
				case 3:
					MantenimientoEmpleados(empresa);
					opcion=0;
					break;
				case 4:
					MantenimientoVehiculos(empresa);
					opcion=0;
					break;
				case 5:
					MantenimientoCarnets(empresa);
					opcion=0;
					break;
			}
		}
		while (opcion!=6);
		
	}
	
	/**
	 * Metodo que muestra el menu de los alquileres y te lleva a su correspondiente metodo.
	 * @param empresa
	 */
	public static void MenuAlquileres(Empresa empresa)
	{
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		opciones.add("ALQUILAR");
		opciones.add("DEVOLVER");
		opcion=interfazusuario.MenuInt("OPCIONES", opciones, 1, 2);
		if (opcion==1)
		{
			empresa.AńadeAlquiler(MetodosConcretos.RealizaAlquiler(empresa));
		}
		else 
		{
			MetodosConcretos.RealizarDevolucion(empresa);
		}
	}
	
	
	/**
	 * Metodo que muestra el menu de los informes y te lleva a su correspondiente metodo.
	 * @param empresa
	 */
	public static void MenuInformes(Empresa empresa)
	{
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		
			opciones.add("ALQUILERES REALIZADOS SEGUN FECHA");
			opciones.add("ALQUILERES REALIZADOS SEGUN VEHICULO");
			opciones.add("LISTADO DE STOCK");
			opciones.add("MOSTRAR PLANTILLA");
			opciones.add("MOSTRAR CLIENTES");
			opciones.add("MOSTRAR TIPOS DE CARNET");
			opciones.add("MOSTRAR LISTA DE OFICINAS");
			opciones.add("MOSTRAR CATEGORIAS");
			opciones.add("MOSTRAR VEHICULOS ALQUILADOS");
			opciones.add("MOSTRAR HISTORIAL DE ALQUILERES");
			opciones.add("MOSTRAR ALQUILERES PENDIENTES DE PAGO");
			opcion=interfazusuario.MenuInt("żQUE DESEA MOSTRAR?", opciones, 1, 11);
			switch (opcion) {
			case 1:
				MetodosConcretos.MostrarAlqSegunFechas(empresa);
				break;
			case 2:
				MetodosConcretos.MostrarAlqSegunVehiculo(empresa);
				break;
			case 3:
				MetodosConcretos.MostrarStockVehiculos(empresa);	
				break;
			case 4:
				MetodosConcretos.MostrarPlantilla(empresa);
				break;
			case 5:
				MetodosConcretos.MostrarClientesHabituales(empresa);
				break;
			case 6:
				MetodosConcretos.MostrarTiposCarnet(empresa);
				break;
			case 7:
				MetodosConcretos.MostrarListaOficinas(empresa);
				break;
			case 8:
				MetodosConcretos.MostrarListaCategorias(empresa);
				break;
			case 9:
				MetodosConcretos.MostrarListaVehiculosAlquilados(empresa);
				break;
			case 10:
				MetodosConcretos.MostrarHistorialAlquileres(empresa);
				break;
			case 11:
				MetodosConcretos.MostrarAalquileresPendienteDePago(empresa);
				break;
			}	
	}
	
	/**
	 * Metodo que se encarga del mantenimiento de la oficina, pidiendo primero un codigo de oficina, llama al metodo busca oficina y si 
	 * devuelve un nulo(no existe es oficina), te lleva a la opcion de ańadir oficina. Si no devuelve un nulo, te pregunta si quieres 
	 * modificar o borrar, si se escoge modificar te lleva al metodo modificar oficina y si se escoge borrar, al metodo borrar oficina.
	 * @param empresa
	 * @throws LongitudNoValidaException 
	 */
	public static void MantenimientoOficinas(Empresa empresa) throws LongitudNoValidaException
	{
		do
		{
			ArrayList<String>opciones=new ArrayList<String>();
			int opcion;
			String opc;
			opc=interfazusuario.PideCadenaValidada(8,"Introduzca el codigo de la oficina a buscar: ");
			if(empresa.BuscaOficina(opc)!=null)
			{
				opciones.clear();
				opciones.add("MODIFICAR");
				opciones.add("BORRAR");
				opcion=interfazusuario.MenuInt("żQUE QUIERES HACER?", opciones, 1, 2);
				if (opcion==1)
				{
					do
					{
						
							empresa.ModificarOficina(opc);
						
					}
					while (interfazusuario.MenuSioNo("żDesea modificar otra cosa?")==1);
				}
				else
				{
					do
					{
						if (interfazusuario.MenuSioNo("żEsta seguro de que desea borrar?")==1)
						{
							empresa.BorraOficina(opc);	
						}				
					}
					while (interfazusuario.MenuSioNo("żDesea borrar otra oficina?")==1);
				}
			}
			else
			{
				do
				{
					empresa.AńadeOficina(empresa);			
				}
				while (interfazusuario.MenuSioNo("żDesea ańadir otra oficina?")==1);
			}
			
		}
		while (interfazusuario.MenuSioNo("żDesea buscar otra oficina?")==1);
	}
	/**
	 * Metodo que se encarga del mantenimiento de los empleados, pidiendo primero un dni del empleado, llama al metodo busca empleado y si 
	 * devuelve un nulo(no existe el empleado), te lleva a la opcion de ańadir empleado. Si no devuelve un nulo, te pregunta si quieres 
	 * modificar o borrar, si se escoge modificar te lleva al metodo modificar empleado y si se escoge borrar, al metodo borrar empleado.
	 * @param empresa
	 * @throws LongitudNoValidaException 
	 */
	public static void MantenimientoEmpleados(Empresa empresa) throws LongitudNoValidaException
	{
		do
		{
			ArrayList<String>opciones=new ArrayList<String>();
			int opcion;
			String opc;
			opc=interfazusuario.PideDniValidad("Introduzca un DNI a buscar: ");
			if(empresa.BuscaEmpleado(opc)!=null)
			{
				opciones.clear();
				opciones.add("MODIFICAR");
				opciones.add("BORRAR");
				opcion=interfazusuario.MenuInt("żQUE QUIERES HACER?", opciones, 1, 2);
				if (opcion==1)
				{
					do
					{
						
							empresa.ModificarEmpleado(opc);
									
					}
					while (interfazusuario.MenuSioNo("żDesea modificar otra cosa?")==1);
				}
				else
				{
					do
					{
						if (interfazusuario.MenuSioNo("żEsta seguro de que desea borrar?")==1)
						{
							empresa.BorraEmpleado(opc);
						}		
					}
					while (interfazusuario.MenuSioNo("żDesea borrar otro empleado?")==1);
				}
			}
			else
			{
				do
				{
					empresa.AńadeEmpleado(empresa);	
				}
				while (interfazusuario.MenuSioNo("żDesea dar de alta otro empleado?")==1);
			}
			
		}
		while (interfazusuario.MenuSioNo("żDesea buscar otro empleado?")==1);
	}
	/**
	 * Metodo que se encarga del mantenimiento de las categorias, pidiendo primero un codigo de la categoria, llama al metodo busca categoria y si 
	 * devuelve un nulo(no existe esa categoria), te lleva a la opcion de ańadir categoria. Si no devuelve un nulo, te pregunta si quieres 
	 * modificar o borrar, si se escoge modificar te lleva al metodo modificar categoria y si se escoge borrar, al metodo borrar categoria.
	 * @param empresa
	 * @throws LongitudNoValidaException 
	 */
	public static void MantenimientoCategorias(Empresa empresa) throws LongitudNoValidaException
	{
		do
		{
			ArrayList<String>opciones=new ArrayList<String>();
			int opcion;
			String opc;
			opc=interfazusuario.PideCadenaValidada(8,"Introduzca el codigo de la categoria a buscar: ");
			if(empresa.BuscaCategoria(opc)!=null)
			{
				opciones.clear();
				opciones.add("MODIFICAR");
				opciones.add("BORRAR");
				opcion=interfazusuario.MenuInt("żQUE QUIERES HACER?", opciones, 1, 2);
				if (opcion==1)
				{
					do
					{
						
							empresa.ModificarCategoria(opc);
								
					}
					while (interfazusuario.MenuSioNo("żDesea modificar otra cosa?")==1);
				}
				else
				{
					do
					{
						if (interfazusuario.MenuSioNo("żEsta seguro de que desea borrar?")==1)
						{
							empresa.BorraCategoria(opc);
						}				
					}
					while (interfazusuario.MenuSioNo("żDesea borrar otra categoria?")==1);
				}
			}
			else
			{
				do
				{
					empresa.AńadeCategoria(empresa);			
				}
				while (interfazusuario.MenuSioNo("żDesea ańadir otra categoria?")==1);
			}
			
		}
		while (interfazusuario.MenuSioNo("żDesea buscar otra categoria?")==1);
	}
	/**
	 * Metodo que se encarga del mantenimiento de los carnets, pidiendo primero un codigo del carnet, llama al metodo busca carnet y si 
	 * devuelve un nulo(no existe ese carnet), te lleva a la opcion de ańadir carnet. Si no devuelve un nulo, te pregunta si quieres 
	 * modificar o borrar, si se escoge modificar te lleva al metodo modificar carnet y si se escoge borrar, al metodo borrar carnet.
	 * @param empresa
	 */
	public static void MantenimientoCarnets(Empresa empresa)
	{
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		String opc;
		do
		{
			opc=interfazusuario.PideCadenaValidada(7,"Introduzca el tipo de carnet que desea buscar: ");
			if(empresa.BuscaCarnet(opc)!=null)
			{
				opciones.clear();
				opciones.add("MODIFICAR");
				opciones.add("BORRAR");
				opcion=interfazusuario.MenuInt("żQUE QUIERES HACER?", opciones, 1, 2);
				if (opcion==1)
				{
					do
					{
						empresa.ModificarCarnet(opc);			
					}
					while (interfazusuario.MenuSioNo("żDesea modificar otra cosa?")==1);
				}
				else
				{
					do
					{
						if (interfazusuario.MenuSioNo("żEsta seguro de que desea borrar?")==1)
						{
							empresa.BorraCarnet(opc);
						}		
					}
					while (interfazusuario.MenuSioNo("żDesea borrar otro carnet?")==1);
				}
			}
			else
			{
				do
				{
					empresa.AńadeCarnet(empresa);	
				}
				while (interfazusuario.MenuSioNo("żDesea ańadir otro carnet?")==1);
			}
			
		}
		while (interfazusuario.MenuSioNo("żDesea buscar otro carnet?")==1);
	}
	/**
	 * Metodo que se encarga del mantenimiento de los vehiculos, pidiendo primero la matricula del vehiculo, llama al metodo busca vehiculo y si 
	 * devuelve un nulo(no existe ese vehiculo), te lleva a la opcion de ańadir vehiculo. Si no devuelve un nulo, te pregunta si quieres 
	 * modificar o borrar, si se escoge modificar te lleva al metodo modificar vehiculo y si se escoge borrar, al metodo borrar vehiculo.
	 * @param empresa
	 * @throws ValorNoValidoException 
	 */
	public static void MantenimientoVehiculos(Empresa empresa)throws LongitudNoValidaException, ValorNoValidoException
	{
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		String opc;
		do
		{
			opc=interfazusuario.PideCadenaValidada(7,"Introduzca la matricula del vehiculo que desea buscar: ");
			if(empresa.BuscaVehiculo(opc)!=null)
			{
				opciones.clear();
				opciones.add("MODIFICAR");
				opciones.add("BORRAR");
				opcion=interfazusuario.MenuInt("żQUE QUIERES HACER?", opciones, 1, 2);
				if (opcion==1)
				{
					do
					{
						
							empresa.ModificarVehiculo(opc);
							
					}
					while (interfazusuario.MenuSioNo("żDesea modificar otra cosa?")==1);
				}
				else
				{
					do
					{
						if (interfazusuario.MenuSioNo("żEsta seguro de que desea borrar?")==1)
						{
							empresa.BorraVehiculo(opc);
						}		
					}
					while (interfazusuario.MenuSioNo("żDesea borrar otro vehiculo?")==1);
				}
			}
			else
			{
				do
				{
					opciones.clear();
					opciones.add("MOTO");
					opciones.add("COCHE ELECTRICO");
					opciones.add("COCHE COMBUSTIÓN");
					opciones.add("FURGONETA");
					opcion=interfazusuario.MenuInt("żQUE TIPO DE VEHICULO ES?", opciones, 1, 4);
					switch (opcion)
					{
					case 1:
						empresa.AńadeMoto(empresa);
						break;
					case 2:
						empresa.AńadeCocheElec(empresa);
						break;
					case 3:
						empresa.AńadeCocheComb(empresa);
						break;
					case 4:
						empresa.AńadeFurgoneta(empresa);
						break;
					}	
				}
				while(interfazusuario.MenuSioNo("żDesea ańadir otro vehiculo?")==1);	
			}
			
		}
		while (interfazusuario.MenuSioNo("żDesea buscar otro vehiculo?")==1);
	}

}
