package menus;
import mismetodosgenerales.*;
import clasesinstanciables.*;
import metodosinterfazusuario.MetodosConcretos;
import java.util.ArrayList;
public class Menus {
	
	/**
	 * Menu principal del programa el cual va a dictar el flujo de nuestro programa. Se compone de
	 * varios menus conectados entre si, que gestionan el mantenimiento de ficheros, los alquileres,
	 * muestra informes y serializa la empresa cuando se elige la opcion de salir.
	 */
	public static void MenuPrincipal(Empresa empresa)
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
	

	public static void MenuMantenimiento(Empresa empresa)
	{
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		String opc;
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
									if (interfazusuario.MenuSioNo("¿Esta seguro de que desea borrar?")==1)
									{
										empresa.BorraOficina(opc);	
									}				
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
									if (interfazusuario.MenuSioNo("¿Esta seguro de que desea borrar?")==1)
									{
										empresa.BorraCategoria(opc);
									}				
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
									if (interfazusuario.MenuSioNo("¿Esta seguro de que desea borrar?")==1)
									{
										empresa.BorraEmpleado(opc);
									}		
								}
								while (interfazusuario.MenuSioNo("¿Desea borrar otro empleado?")==1);
							}
						}
						else
						{
							do
							{
								empresa.AñadeEmpleado(empresa);	
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
									if (interfazusuario.MenuSioNo("¿Esta seguro de que desea borrar?")==1)
									{
										empresa.BorraVehiculo(opc);
									}		
								}
								while (interfazusuario.MenuSioNo("¿Desea borrar otro vehiculo?")==1);
							}
						}
						else
						{
							do
							{
								empresa.AñadeVehiculo(empresa);	
							}
							while (interfazusuario.MenuSioNo("¿Desea añadir otro vehiculo?")==1);
						}
						
					}
					while (interfazusuario.MenuSioNo("¿Desea buscar otro vehiculo?")==1);
					opcion=0;
					break;
				case 5:
					do
					{
						opc=interfazusuario.PideCadenaValidada(7,"Introduzca el tipo de carnet que desea buscar: ");
						if(empresa.BuscaCarnet(opc)!=null)
						{
							opciones.clear();
							opciones.add("MODIFICAR");
							opciones.add("BORRAR");
							opcion=interfazusuario.MenuInt("¿QUE QUIERES HACER?", opciones, 1, 2);
							if (opcion==1)
							{
								do
								{
									//Metodo.Modifica.Carnet			
								}
								while (interfazusuario.MenuSioNo("¿Desea modificar otro carnet?")==1);
							}
							else
							{
								do
								{
									if (interfazusuario.MenuSioNo("¿Esta seguro de que desea borrar?")==1)
									{
										empresa.BorraCarnet(opc);
									}		
								}
								while (interfazusuario.MenuSioNo("¿Desea borrar otro carnet?")==1);
							}
						}
						else
						{
							do
							{
								empresa.AñadeCarnet();	
							}
							while (interfazusuario.MenuSioNo("¿Desea añadir otro carnet?")==1);
						}
						
					}
					while (interfazusuario.MenuSioNo("¿Desea buscar otro carnet?")==1);
					opcion=0;
					break;
			}
		}
		while (opcion!=6);
		
	}
	
	
	public static void MenuAlquileres(Empresa empresa)
	{
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
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
	}
	
	public static void MenuInformes(Empresa empresa)
	{
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		opciones.clear();
		opciones.add("ALQUILERES REALIZADOS SEGUN FECHA");
		opciones.add("ALQUILERES REALIZADOS SEGUN VEHICULO");
		opciones.add("LISTADO DE STOCK");
		opciones.add("MOSTRAR PLANTILLA");
		opciones.add("MOSTRAR CLIENTES");
		opciones.add("MOSTRAR TIPOS DE CARNET");
		opciones.add("MOSTRAR LISTA DE OFICINAS");
		opciones.add("MOSTRAR CATEGORIAS");
		opcion=interfazusuario.MenuInt("¿QUE DESEA MOSTRAR?", opciones, 1, 8);
		switch (opcion) {
		case 1:
			//TODO METODO.MUESTRA_SEGUN_FECHA
			break;
		case 2:
			//TODO METODO.MUESTRA_SEGUN_VEHICULO
			break;
		case 3:
			MetodosConcretos.MostrarStockVehiculos(empresa);	
			break;
		case 4:
			MetodosConcretos.MostrarPlantilla(empresa);
			break;
		case 5:
			//TODO METODO.MUESTRA_CLIENTES
			break;
		case 6:
			MetodosConcretos.MostrarTiposCarnet(empresa);
			break;
		case 7:
			MetodosConcretos.MostrarListaOficinas(empresa);
			break;
		case 8:
			MetodosConcretos.MostrarListaCategorias(empresa);
		}

	}

}
