package logica_de_negocio;

import java.util.ArrayList;

import clasesinstanciables.Empresa;
import excepciones.LongitudNoValidaException;
import excepciones.ValorNoValidoException;
import mismetodosgenerales.interfazusuario;

public class Mantenimiento {

	/**
	 * Metodo que se encarga del mantenimiento de la oficina, pidiendo primero un codigo de oficina, llama al metodo busca oficina y si 
	 * devuelve un nulo(no existe es oficina), te lleva a la opcion de añadir oficina. Si no devuelve un nulo, te pregunta si quieres 
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
				opcion=interfazusuario.MenuInt("¿QUE QUIERES HACER?", opciones, 1, 2);
				if (opcion==1)
				{
					do
					{
						
							empresa.ModificarOficina(opc);
						
					}
					while (interfazusuario.MenuSioNo("¿Desea modificar otra cosa?")==1);
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
					empresa.AñadeOficina(empresa);			
				}
				while (interfazusuario.MenuSioNo("¿Desea añadir otra oficina?")==1);
			}
			
		}
		while (interfazusuario.MenuSioNo("¿Desea buscar otra oficina?")==1);
	}
	/**
	 * Metodo que se encarga del mantenimiento de los empleados, pidiendo primero un dni del empleado, llama al metodo busca empleado y si 
	 * devuelve un nulo(no existe el empleado), te lleva a la opcion de añadir empleado. Si no devuelve un nulo, te pregunta si quieres 
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
				opcion=interfazusuario.MenuInt("¿QUE QUIERES HACER?", opciones, 1, 2);
				if (opcion==1)
				{
					do
					{
						
							empresa.ModificarEmpleado(opc);
									
					}
					while (interfazusuario.MenuSioNo("¿Desea modificar otra cosa?")==1);
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
	}
	/**
	 * Metodo que se encarga del mantenimiento de las categorias, pidiendo primero un codigo de la categoria, llama al metodo busca categoria y si 
	 * devuelve un nulo(no existe esa categoria), te lleva a la opcion de añadir categoria. Si no devuelve un nulo, te pregunta si quieres 
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
				opcion=interfazusuario.MenuInt("¿QUE QUIERES HACER?", opciones, 1, 2);
				if (opcion==1)
				{
					do
					{
						
							empresa.ModificarCategoria(opc);
								
					}
					while (interfazusuario.MenuSioNo("¿Desea modificar otra cosa?")==1);
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
					empresa.AñadeCategoria(empresa);			
				}
				while (interfazusuario.MenuSioNo("¿Desea añadir otra categoria?")==1);
			}
			
		}
		while (interfazusuario.MenuSioNo("¿Desea buscar otra categoria?")==1);
	}
	/**
	 * Metodo que se encarga del mantenimiento de los carnets, pidiendo primero un codigo del carnet, llama al metodo busca carnet y si 
	 * devuelve un nulo(no existe ese carnet), te lleva a la opcion de añadir carnet. Si no devuelve un nulo, te pregunta si quieres 
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
				opcion=interfazusuario.MenuInt("¿QUE QUIERES HACER?", opciones, 1, 2);
				if (opcion==1)
				{
					do
					{
						empresa.ModificarCarnet(opc);			
					}
					while (interfazusuario.MenuSioNo("¿Desea modificar otra cosa?")==1);
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
					empresa.AñadeCarnet(empresa);	
				}
				while (interfazusuario.MenuSioNo("¿Desea añadir otro carnet?")==1);
			}
			
		}
		while (interfazusuario.MenuSioNo("¿Desea buscar otro carnet?")==1);
	}
	/**
	 * Metodo que se encarga del mantenimiento de los vehiculos, pidiendo primero la matricula del vehiculo, llama al metodo busca vehiculo y si 
	 * devuelve un nulo(no existe ese vehiculo), te lleva a la opcion de añadir vehiculo. Si no devuelve un nulo, te pregunta si quieres 
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
				opcion=interfazusuario.MenuInt("¿QUE QUIERES HACER?", opciones, 1, 2);
				if (opcion==1)
				{
					do
					{
						
							empresa.ModificarVehiculo(opc);
							
					}
					while (interfazusuario.MenuSioNo("¿Desea modificar otra cosa?")==1);
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
					opciones.clear();
					opciones.add("MOTO");
					opciones.add("COCHE ELECTRICO");
					opciones.add("COCHE COMBUSTIÓN");
					opciones.add("FURGONETA");
					opcion=interfazusuario.MenuInt("¿QUE TIPO DE VEHICULO ES?", opciones, 1, 4);
					switch (opcion)
					{
					case 1:
						empresa.AñadeMoto(empresa);
						break;
					case 2:
						empresa.AñadeCocheElec(empresa);
						break;
					case 3:
						empresa.AñadeCocheComb(empresa);
						break;
					case 4:
						empresa.AñadeFurgoneta(empresa);
						break;
					}	
				}
				while(interfazusuario.MenuSioNo("¿Desea añadir otro vehiculo?")==1);	
			}
			
		}
		while (interfazusuario.MenuSioNo("¿Desea buscar otro vehiculo?")==1);
	}

}
