package menus;
import mismetodosgenerales.*;
import clasesinstanciables.*;
import excepciones.LongitudNoValidaException;
import logica_de_negocio.Mantenimiento;
import metodosinterfazusuario.MetodosConcretos;
import java.util.ArrayList;
public class Menus {
	
	/**
	 * Menu principal del programa el cual va a dictar el flujo de nuestro programa. Se compone de
	 * varios menus conectados entre si, que gestionan el mantenimiento de ficheros, los alquileres,
	 * muestra informes y serializa la empresa cuando se elige la opcion de salir.
	 * @throws LongitudNoValidaException 
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
					Mantenimiento.MantenimientoOficinas(empresa);
					opcion=0;
					break;
				case 2:
					Mantenimiento.MantenimientoCategorias(empresa);
					opcion=0;
					break;
				case 3:
					Mantenimiento.MantenimientoEmpleados(empresa);
					opcion=0;
					break;
				case 4:
					Mantenimiento.MantenimientoVehiculos(empresa);
					opcion=0;
					break;
				case 5:
					Mantenimiento.MantenimientoCarnets(empresa);
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
		opciones.add("ALQUILERES REALIZADOS SEGUN FECHA");
		opciones.add("ALQUILERES REALIZADOS SEGUN VEHICULO");
		opciones.add("LISTADO DE STOCK");
		opciones.add("MOSTRAR PLANTILLA");
		opciones.add("MOSTRAR CLIENTES");
		opciones.add("MOSTRAR TIPOS DE CARNET");
		opciones.add("MOSTRAR LISTA DE OFICINAS");
		opciones.add("MOSTRAR CATEGORIAS");
		opciones.add("MOSTRAR LISTA MOTOS");
		opciones.add("MOSTRAR LISTA FURGONETAS");
		opcion=interfazusuario.MenuInt("¿QUE DESEA MOSTRAR?", opciones, 1, 10);
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
			break;
		case 9:
			MetodosConcretos.MostrarListaMotos(empresa);
			break;
		case 10:
			MetodosConcretos.MostrarListaFurgonetas(empresa);
			break;
		}

	}

}
