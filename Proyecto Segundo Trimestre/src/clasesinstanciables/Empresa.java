package clasesinstanciables;
import java.util.ArrayList;
import java.util.TreeMap;

import excepciones.LongitudNoValidaException;
import excepciones.ValorNoValidoException;
import metodosinterfazusuario.MetodosConcretos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import mismetodosgenerales.*;
public class Empresa implements Serializable {

	
	//PROPIEDADES
	private static final long serialVersionUID = 8799656478674716111L;
	private String nif;
	private String nombre;
	private TreeMap <String, Oficina> listaoficinas=new TreeMap <String, Oficina>();
	private TreeMap <String, Cliente> listaclientes=new TreeMap <String, Cliente>();
	private TreeMap <String, Empleado> plantilla=new TreeMap <String, Empleado>();
	private TreeMap <String, Vehiculo> listavehiculos=new TreeMap <String, Vehiculo>();
	private TreeMap <String, Carnet>tiposdecarnet=new TreeMap<String, Carnet>();
	private TreeMap <String, Categoria>listacategorias=new TreeMap<String, Categoria>();
	private TreeMap <String, Vehiculo> vehiculosalquilados=new TreeMap <String, Vehiculo>();
	private TreeMap <String, Moto> listamotos=new TreeMap <String, Moto>();
	private TreeMap <String, Furgoneta>listafurgonetas=new TreeMap<String, Furgoneta>();
	private TreeMap <String, Cochecomb>listaccomb=new TreeMap<String, Cochecomb>();
	private TreeMap <String, Cocheelectrico> listacelect=new TreeMap <String, Cocheelectrico>();
	int longinombre=75;
	int longinif=9;


	//CONSTRUCTORES
	
	public Empresa(String nif,String nombre)throws LongitudNoValidaException {
		this.setNif(nif);
		this.setNombre(nombre);
		inicializaempresa();
	}
	
	/**
	 * Constructor con todos los parametros
	 * @param _listaoficinas
	 * @param _listaclientes
	 * @param _listaempleados
	 * @param _listacelect
	 * @param _listaccomb
	 * @param _listafurgonetas
	 * @param _listamotos
	 */
	public Empresa(String nif,TreeMap<String, Oficina> listaoficinas,TreeMap<String, Cliente> listaclientes,TreeMap<String, Empleado> plantilla,
			TreeMap<String, Carnet>tiposdecarnet,TreeMap<String, Categoria>listacategorias)throws LongitudNoValidaException {
	this.setNif(nif);
	this.setListaoficinas(listaoficinas);
	this.setListaclientes(listaclientes);
	this.setPlantilla(plantilla);
	this.setTiposdecarnet(tiposdecarnet);
	this.setListacategorias(listacategorias);
	}
	
	/**
	 * Constructor de copia
	 * @param e
	 */
	public Empresa(Empresa e) throws LongitudNoValidaException
	{
		this.setNif(e.getNif());
		this.setListaoficinas(e.getListaoficinas());
		this.setListaclientes(e.getListaclientes());
		this.setPlantilla(e.getPlantilla());
		this.setTiposdecarnet(e.getTiposdecarnet());
		this.setListacategorias(e.getListacategorias());
	}
	
	//TODO METODOS}
	/**
	 * Metodo para inicializar los TreeMap de empresa, que despues ira en el primero constructor de empresa.
	 */
	private void inicializaempresa()
	{
		listaoficinas=new TreeMap <String, Oficina>();
		listaclientes=new TreeMap <String, Cliente>();
		plantilla=new TreeMap <String, Empleado>();
		listavehiculos=new TreeMap <String, Vehiculo>();
		tiposdecarnet=new TreeMap<String, Carnet>();
		listacategorias=new TreeMap<String, Categoria>();
		listamotos=new TreeMap <String, Moto>();
		listafurgonetas=new TreeMap<String, Furgoneta>();
		listaccomb=new TreeMap<String, Cochecomb>();
		listacelect=new TreeMap <String, Cocheelectrico>();
	}
	/**
	 * Metodo para grabar la empresa, cogiendo el archivo empresa.ser y mediantoe el metodo writeObject grabandola.
	 * @param empresa
	 */
	public static void grabaEmpresa(Empresa empresa)
	{
		FileOutputStream f=null;
		ObjectOutputStream o=null;
		
		try
		{
			f=new FileOutputStream ("empresa.ser");
			o=new ObjectOutputStream(f);
			o.writeObject(empresa);
		} 
		catch (FileNotFoundException e) {
			System.out.println("Error al intentar grabar: "+ e.getLocalizedMessage());
		}
		catch (IOException e)
		{
			System.out.println("Error al intentar grabar: "+ e.getLocalizedMessage());
		}
	}
	
	/**
	 * Busca el fichero "empresa.ser" y si existe, lee el objeto y lo devuelve, y si no existe llama
	 * al constructor de empresa y lo crea.
	 * @return Devuelve un objeto tipo empresa
	 * @throws IOException
	 */
	public static Empresa leeEmpresa() throws IOException
	{
		Empresa empresa=null;
		File f=new File ("empresa.ser");
		if (f.exists())
		{
		try
		{
			FileInputStream file = new FileInputStream("empresa.ser");
			ObjectInputStream input = new ObjectInputStream (file);
			empresa=(Empresa)input.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-genera");
			System.out.println("Error al intentar leer: "+e.getLocalizedMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al intentar leer: "+e.getLocalizedMessage());
		}
		}
		else
		{
			empresa=MetodosConcretos.PideDatosEmpresa();
			grabaEmpresa(empresa);
			
		}
	
		return empresa;
	}
	/**
	 * Metodo que junta los TreeMap de motos,coches y furgonetas en uno solo.
	 * @param empresa
	 */
	public  void RellenarStock(Empresa empresa)
	{
			listavehiculos.putAll(listacelect);
			listavehiculos.putAll(listamotos);
			listavehiculos.putAll(listaccomb);
			listavehiculos.putAll(listafurgonetas);	
	}
	/**
	 * Metodo que se encarga de buscar un empleado en el TreeMap de plantilla pasandole 
	 * como clave el dni
	 * @param dni
	 * @return Un objeto empleado
	 */
	public  Empleado BuscaEmpleado(String dni) 
	{
		return plantilla.get(dni);
	}
	/**
	 * Metodo que se encarga de buscar un cliente en el TreeMap de listaclientes pasandole 
	 * como clave el dni
	 * @param dni
	 * @return Un objeto cliente
	 */
	public  Cliente BuscaCliente(String dni) 
	{
		return listaclientes.get(dni); 
	}
	/**
	 * Metodo que se encarga de buscar un vehiculo en el TreeMap de listavehiculos pasandole 
	 * como clave la matricula
	 * @param matricula
	 * @return Un objeto vehiculo
	 */
	public Vehiculo BuscaVehiculo(String matricula) 
	{
		return listavehiculos.get(matricula);
	}
	/**
	 * Metodo que se encarga de buscar una moto en el TreeMap de listamotos pasandole 
	 * como clave la matricula
	 * @param matricula
	 * @return Un objeto moto
	 */
	public Moto BuscaMoto(String matricula) 
	{
		return listamotos.get(matricula);
	}
	/**
	 * Metodo que se encarga de buscar un coche electrico en el TreeMap de listacelect pasandole 
	 * como clave la matricula
	 * @param matricula
	 * @return Un objeto coche electrico
	 */
	public Cocheelectrico BuscaCocheelect(String matricula) 
	{
		return listacelect.get(matricula);
	}
	/**
	 * Metodo que se encarga de buscar un coche combustion en el TreeMap de listaccomb pasandole 
	 * como clave la matricula
	 * @param matricula
	 * @return Un objeto coche combustion
	 */
	public Cochecomb BuscaCochecomb(String matricula) 
	{
		return listaccomb.get(matricula);
	}
	/**
	 * Metodo que se encarga de buscar una furgoneta en el TreeMap de listafurgonetas pasandole 
	 * como clave la matricula
	 * @param matricula
	 * @return Un objeto furgoneta
	 */
	public Furgoneta BuscaFurgoneta(String matricula) 
	{
		return listafurgonetas.get(matricula);
	}
	/**
	 * Metodo que se encarga de buscar una oficina en el TreeMap de listaoficinas pasandole 
	 * como clave el codigo de la oficina
	 * @param codigoofi
	 * @return Un objeto oficina
	 */
	public Oficina BuscaOficina(String codigoofi) 
	{
		return listaoficinas.get(codigoofi);
	}
	/**
	 * Metodo que se encarga de buscar un carnet en el TreeMap de tiposdecarnet pasandole 
	 * como clave el tipo
	 * @param tipo
	 * @return Un objeto carnet
	 */
	public Carnet BuscaCarnet(String tipo) 
	{
		return tiposdecarnet.get(tipo);
	}
	/**
	 * Metodo que se encarga de buscar un carnet en el TreeMap de tiposdecarnet pasandole 
	 * como clave el tipo
	 * @param tipo
	 * @return Un objeto carnet
	 */
	public Categoria BuscaCategoria(String codcategoria) 
	{
		return listacategorias.get(codcategoria);
	}
	/**
	 * Metodo que se encarga de llamar al metodo PideDatosCliente para introducir los datos
	 * en un objeto de tipo cliente y éste introducirlo en el TreeMap de listaclientes.
	 */
	public void AñadeCliente(Empresa empresa) 
	{
		Cliente c=MetodosConcretos.PideDatosCliente(empresa);
		listaclientes.put(c.getDni(), c);
	}
	/**
	 * Metodo que se encarga de llamar al metodo PideDatosEmpleado para introducir los datos
	 * en un objeto de tipo empleado y éste introducirlo en el TreeMap de plantilla.
	 */
	public void AñadeEmpleado(Empresa empresa) 
	{
		Empleado e=MetodosConcretos.PideDatosEmpleado(empresa);
		plantilla.put(e.getDni(), e);
	}
	/**
	 * Metodo que se encarga de llamar al metodo PideDatosCategoria para introducir los datos
	 * en un objeto de tipo categoria y éste introducirlo en el TreeMap de listacategorias.
	 */
	public void AñadeCategoria() 
	{
		Categoria cat=MetodosConcretos.PideDatosCategoria();
		listacategorias.put(cat.getCodcategoria(), cat);
	}
	/**
	 * Metodo que se encarga de crear un objeto de tipo carnet, pasandole como parametros 
	 * una string con el tipo y otra string con la descripcion, para introducir este
	 * objeto en el TreeMap de tiposdecarnet.
	 * @param tipo
	 * @param descripcion
	 */
	public void AñadeCarnet() 
	{
		Carnet carnet=MetodosConcretos.PideDatosCarnet();
		tiposdecarnet.put(carnet.getTipo(), carnet);
	}
	/**
	 * Metodo que se encarga de crear un objeto de tipo vehiculo, para introducir este
	 * objeto en el TreeMap de tiposdecarnet.
	 * @param tipo
	 * @param descripcion
	 */
	public void AñadeMoto(Empresa empresa) 
	{
		Moto moto=MetodosConcretos.PideDatosMoto(empresa);
		listamotos.put(moto.getMatricula(), moto);
		listavehiculos.put(moto.getMatricula(), moto);
	}
	public void AñadeCocheElec(Empresa empresa) 
	{
		Cocheelectrico celect=MetodosConcretos.PideDatosCocheElec(empresa);
		listacelect.put(celect.getMatricula(), celect);
		listavehiculos.put(celect.getMatricula(), celect);
	}
	public void AñadeCocheComb(Empresa empresa) 
	{
		Cochecomb ccomb=MetodosConcretos.PideDatosCocheComb(empresa);
		listaccomb.put(ccomb.getMatricula(), ccomb);
		listavehiculos.put(ccomb.getMatricula(), ccomb);
	}
	public void AñadeFurgoneta(Empresa empresa) 
	{
		Furgoneta furgoneta=MetodosConcretos.PideDatosFurgoneta(empresa);
		listafurgonetas.put(furgoneta.getMatricula(), furgoneta);
		listavehiculos.put(furgoneta.getMatricula(), furgoneta);
	}
	/**
	 * Metodo que se encarga de llamar al metodo PideDatosOficina para introducirlos datos
	 * en un objeto de tipo oficina y éste introducirlo en el TreeMap de listaoficinas.
	 */
	public void AñadeOficina() 
	{
		Oficina o=MetodosConcretos.PideDatosOficina();
		listaoficinas.put(o.getCodigoofi(), o);
	}
	/**
	 * Método que borra un Cliente de la lista de clientes, pasándole su clave principal.
	 */
	public void BorraCliente(String dni) 
	{
		listaclientes.remove(dni);
	}
	/**
	 * Método que borra un Empleado de la plantilla, pasándole su clave principal.
	 */
	public void BorraEmpleado(String dni) 
	{
		plantilla.remove(dni);
	}
	/**
	 * Método que borra una Categoria de la lista de categorias, pasándole su clave principal.
	 */
	public void BorraCategoria(String codcategoria) 
	{
		listacategorias.remove(codcategoria);
	}
	/**
	 * Método que borra un Carnet de la lista de tripos de carnet, pasándole su clave principal.
	 */
	public void BorraCarnet(String tipo) 
	{
		tiposdecarnet.remove(tipo);
	}
	/**
	 * Método que borra una Oficina de la lista de oficinas, pasándole su clave principal.
	 */
	public void BorraOficina(String codigoofi) 
	{
		listaoficinas.remove(codigoofi);
	}
	/**
	 * Método que borra un vehiculo de la lista de vehiculos, pasándole su clave principal.
	 * @param matricula
	 */
	public void BorraVehiculo(String matricula)
	{
		listamotos.remove(matricula);
		listacelect.remove(matricula);
		listaccomb.remove(matricula);
		listafurgonetas.remove(matricula);
		listavehiculos.remove(matricula);
	}
	
	/**
	 * Metodo que sirve para modificar los valores de una oficina. Muestra un menu donde el usuario elige que desea modificar, 
	 * modificando el contenido a traves de los setters.
	 * @param codigoofi Un string con la clave de la oficina
	 * @throws LongitudNoValidaException
	 */
	public void ModificarOficina(String codigoofi)throws LongitudNoValidaException
	{
		Oficina oficina=BuscaOficina(codigoofi);
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		opciones.add("DESCRIPCION");
		opciones.add("LOCALIDAD");
		opciones.add("PROVINCIA");
		opciones.add("OFICINA AEROPUERTO");
		opcion=interfazusuario.MenuInt("OPCIONES", opciones, 1, 4);
		switch (opcion)
		{
			case 1:
				oficina.setDescripcion(interfazusuario.PideCadenaValidada(300, "Introduzca una descripcion para la oficina: "));
				listaoficinas.put(codigoofi, oficina);
				break;
			case 2:
				oficina.setLocalidad(interfazusuario.PideCadenaValidada(75, "Introduzca la localidad en que se encuentra la oficina: "));
				listaoficinas.put(codigoofi, oficina);
				break;
			case 3:
				oficina.setProvincia(interfazusuario.PideCadenaValidada(35, "Introduzca la provincia en que se encuentra la oficina: "));
				listaoficinas.put(codigoofi, oficina);
				break;
			case 4:
				if (oficina.isOfiaeropuerto()==false)
				{
					oficina.setOfiaeropuerto(true);
					listaoficinas.put(codigoofi, oficina);
				}
				else
				{
					oficina.setOfiaeropuerto(false);
					listaoficinas.put(codigoofi, oficina);
				}
				break;	
		}
	}
	
	public void ModificarCarnet(String tipo)
	{
		Carnet carnet=BuscaCarnet(tipo);
		carnet.setDescripcion(interfazusuario.PideCadenaValidada(300, "Introduzca una descripción: "));
		tiposdecarnet.put(tipo, carnet);
	}
	
	public void ModificarCategoria(String codcategoria)throws LongitudNoValidaException
	{
		Categoria categoria=BuscaCategoria(codcategoria);
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		opciones.add("DESCRIPCION");
		opciones.add("RECARGO");
		opcion=interfazusuario.MenuInt("OPCIONES", opciones, 1, 2);
		if (opcion==1)
		{
			categoria.setDescripcion(interfazusuario.PideCadenaValidada(300, "Introduzca una descripcion para la categoria: "));
			listacategorias.put(codcategoria, categoria);
		}
		else
		{
			categoria.setRecargoalquileres(interfazusuario.PideNumeroValidado(1, 100000, "Introduzca el recargo del alquiler: "));
			listacategorias.put(codcategoria, categoria);
		}
	}
	
	
	public void ModificarEmpleado(String dni) throws LongitudNoValidaException
	{
		Empleado empleado=BuscaEmpleado(dni);
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		opciones.add("NOMBRE");
		opciones.add("PRIMER APELLIDO");
		opciones.add("SEGUNDO APELLIDO");
		opciones.add("FECHA DE ALTA");
		opciones.add("UBICACION");
		opcion=interfazusuario.MenuInt("OPCIONES", opciones, 1, 5);
		switch (opcion)
		{
			case 1:
				empleado.setNombre(interfazusuario.PideCadenaValidada(35, "Introduzca su nombre:"));
				plantilla.put(dni, empleado);
				break;
			case 2:
				empleado.setAp1(interfazusuario.PideCadenaValidada(35, "Introduzca su primer apellido:"));
				plantilla.put(dni, empleado);
				break;
			case 3:
				empleado.setAp2(interfazusuario.PideCadenaValidada(35, "Introduzca su segundo apellido:"));
				plantilla.put(dni, empleado);
				break;
			case 4:
				empleado.setFaltaempresa(interfazusuario.PideFechaValidada("Introduzca la fecha de alta en la empresa: "));
				plantilla.put(dni, empleado);
				break;
			case 5:
				String _opcofi=null;
				_opcofi=interfazusuario.PideCadenaValidada(8, "Introduzca el codigo de la oficina: ");
				//aqui faltaria validar la opcion, por si introducen una oficina incorrecta
				empleado.setOfitrabajador(BuscaOficina(_opcofi));
				plantilla.put(dni, empleado);
				break;
		}
	}
	
	public void ModificarMoto(Moto moto,String matricula)throws LongitudNoValidaException,ValorNoValidoException
	{
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		opciones.add("MARCA");
		opciones.add("MODELO");
		opciones.add("COLOR");
		opciones.add("FECHA ADQUISICION");
		opciones.add("KILOMETROS");
		opciones.add("CATEGORIA");
		opciones.add("UBICACION");
		opciones.add("AUTONOMIA");
		opciones.add("TIEMPO DE RECARGA");
		opciones.add("CILINDRADA");
		opciones.add("CARNET REQUERIDO");
		opcion=interfazusuario.MenuInt("OPCIONES", opciones, 1, 11);
		switch (opcion)
		{
		case 1:
			moto.setMarca(interfazusuario.PideCadenaValidada(35, "Marca: "));
			listamotos.put(matricula, moto);
			break;
		case 2:
			moto.setModelo(interfazusuario.PideCadenaValidada(35, "Modelo: "));
			listamotos.put(matricula, moto);
			break;
		case 3:
			moto.setColor(interfazusuario.PideCadenaValidada(20, "Color: "));
			listamotos.put(matricula, moto);
			break;
		case 4:
			moto.setFaltaoadqui(interfazusuario.PideFechaValidada("Fecha de adquisicion: "));
			listamotos.put(matricula, moto);
			break;
		case 5:
			moto.setKms(interfazusuario.PideNumeroValidado(0, 2000000, "Kilometros del vehiculo: "));
			listamotos.put(matricula, moto);
			break;
		case 6:
			String _codcategoria;
			_codcategoria=interfazusuario.PideCadenaValidada(8, "Introduzca el tipo de categoria: ");
			moto.setCategoria(BuscaCategoria(_codcategoria));
			listamotos.put(matricula, moto);
			break;
		case 7:
			String _opcofi=null;
			_opcofi=interfazusuario.PideCadenaValidada(8, "Introduzca el codigo de la oficina: ");
			//aqui faltaria validar la opcion, por si introducen una oficina incorrecta
			moto.setUbicacion(BuscaOficina(_opcofi));
			listamotos.put(matricula, moto);
			break;
		case 8:
			moto.setAutonomia(interfazusuario.PideNumeroValidado(1, 600, "Kms de autonomia: "));
			listamotos.put(matricula, moto);
			break;
		case 9:
			moto.setTiempocarga(interfazusuario.PideNumeroValidado(1, 600, "Tiempo de carga en minutos: "));
			listamotos.put(matricula, moto);
			break;
		case 10:
			moto.setCilindrada(interfazusuario.PideNumeroValidado(1, 3000, "Cilindrada: "));
			listamotos.put(matricula, moto);
			break;
		case 11:
			String _opccarnet=null;
			_opccarnet=interfazusuario.PideCadenaValidada(3, "Introduzca su tipo de carnet:");
			moto.setCarnetrequerido(BuscaCarnet(_opccarnet));
			listamotos.put(matricula, moto);
			break;
		}
		
	}
	
	public void ModificarCocheElect(Cocheelectrico celect,String matricula)throws LongitudNoValidaException,ValorNoValidoException
	{
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		opciones.add("MARCA");
		opciones.add("MODELO");
		opciones.add("COLOR");
		opciones.add("FECHA ADQUISICION");
		opciones.add("KILOMETROS");
		opciones.add("CATEGORIA");
		opciones.add("UBICACION");
		opciones.add("AUTONOMIA");
		opciones.add("TIEMPO DE RECARGA");	
		opciones.add("NºPLAZAS");
		opciones.add("TIPO");	
		opcion=interfazusuario.MenuInt("OPCIONES", opciones, 1, 11);
		switch (opcion)
		{
		case 1:
			celect.setMarca(interfazusuario.PideCadenaValidada(35, "Marca: "));
			listacelect.put(matricula, celect);
			break;
		case 2:
			celect.setModelo(interfazusuario.PideCadenaValidada(35, "Modelo: "));
			listacelect.put(matricula, celect);
			break;
		case 3:
			celect.setColor(interfazusuario.PideCadenaValidada(20, "Color: "));
			listacelect.put(matricula, celect);
			break;
		case 4:
			celect.setFaltaoadqui(interfazusuario.PideFechaValidada("Fecha de adquisicion: "));
			listacelect.put(matricula, celect);
			break;
		case 5:
			celect.setKms(interfazusuario.PideNumeroValidado(0, 2000000, "Kilometros del vehiculo: "));
			listacelect.put(matricula, celect);
			break;
		case 6:
			String _codcategoria;
			_codcategoria=interfazusuario.PideCadenaValidada(8, "Introduzca el tipo de categoria: ");
			celect.setCategoria(BuscaCategoria(_codcategoria));
			listacelect.put(matricula, celect);
			break;
		case 7:
			String _opcofi=null;
			_opcofi=interfazusuario.PideCadenaValidada(8, "Introduzca el codigo de la oficina: ");
			//aqui faltaria validar la opcion, por si introducen una oficina incorrecta
			celect.setUbicacion(BuscaOficina(_opcofi));
			listacelect.put(matricula, celect);
			break;
		case 8:
			celect.setAutonomia(interfazusuario.PideNumeroValidado(1, 600, "Kms de autonomia: "));
			listacelect.put(matricula, celect);
			break;
		case 9:
			celect.setTiempocarga(interfazusuario.PideNumeroValidado(1, 600, "Tiempo de carga en minutos: "));
			listacelect.put(matricula, celect);
			break;
		case 10:
			celect.setNplazas(interfazusuario.PideNumeroValidado(1, 9, "Nº de plazas: "));
			listacelect.put(matricula, celect);
			break;
		case 11:
			celect.setTipo(interfazusuario.PideCadenaValidada(15, "Tipo de coche: "));
			listacelect.put(matricula, celect);
			break;
		}
	}
	
	public void ModificarCocheComb(Cochecomb ccomb,String matricula)throws LongitudNoValidaException,ValorNoValidoException
	{
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		opciones.add("MARCA");
		opciones.add("MODELO");
		opciones.add("COLOR");
		opciones.add("FECHA ADQUISICION");
		opciones.add("KILOMETROS");
		opciones.add("CATEGORIA");
		opciones.add("UBICACION");
		opciones.add("POTENCIA");
		opciones.add("CONSUMO");
		opciones.add("NIVEL DE EMISIONES");
		opciones.add("Nº DE PLAZAS");
		opciones.add("TIPO");
		opcion=interfazusuario.MenuInt("OPCIONES", opciones, 1, 12);
		switch (opcion)
		{
		case 1:
			ccomb.setMarca(interfazusuario.PideCadenaValidada(35, "Marca: "));
			listaccomb.put(matricula, ccomb);
			break;
		case 2:
			ccomb.setModelo(interfazusuario.PideCadenaValidada(35, "Modelo: "));
			listaccomb.put(matricula, ccomb);
			break;
		case 3:
			ccomb.setColor(interfazusuario.PideCadenaValidada(20, "Color: "));
			listaccomb.put(matricula, ccomb);
			break;
		case 4:
			ccomb.setFaltaoadqui(interfazusuario.PideFechaValidada("Fecha de adquisicion: "));
			listaccomb.put(matricula, ccomb);
			break;
		case 5:
			ccomb.setKms(interfazusuario.PideNumeroValidado(0, 2000000, "Kilometros del vehiculo: "));
			listaccomb.put(matricula, ccomb);
			break;
		case 6:
			String _codcategoria;
			_codcategoria=interfazusuario.PideCadenaValidada(8, "Introduzca el tipo de categoria: ");
			ccomb.setCategoria(BuscaCategoria(_codcategoria));
			listaccomb.put(matricula, ccomb);
			break;
		case 7:
			String _opcofi=null;
			_opcofi=interfazusuario.PideCadenaValidada(8, "Introduzca el codigo de la oficina: ");
			//aqui faltaria validar la opcion, por si introducen una oficina incorrecta
			ccomb.setUbicacion(BuscaOficina(_opcofi));
			listaccomb.put(matricula, ccomb);
			break;
		case 8:
			ccomb.setPotencia(interfazusuario.PideNumeroValidado(1, 600, "Potencia: "));
			listaccomb.put(matricula, ccomb);
			break;
		case 9:
			ccomb.setConsumo(interfazusuario.PideNumeroValidado(1, 600, "Consumo: "));
			listaccomb.put(matricula, ccomb);
			break;
		case 10:
			ccomb.setNivemisiones(interfazusuario.PideCadenaValidada(6, "Nivel de emisiones: "));
			listaccomb.put(matricula, ccomb);
			break;
		case 11:
			ccomb.setNplazas(interfazusuario.PideNumeroValidado(1, 9, "Nº de plazas: "));
			listaccomb.put(matricula, ccomb);
			break;
		case 12:
			ccomb.setTipo(interfazusuario.PideCadenaValidada(15, "Tipo de coche: "));
			listaccomb.put(matricula, ccomb);
			break;
		
		}
	}
	
	public void ModificarFurgoneta(Furgoneta furgoneta,String matricula)throws LongitudNoValidaException,ValorNoValidoException
	{
		ArrayList<String>opciones=new ArrayList<String>();
		int opcion;
		opciones.add("MARCA");
		opciones.add("MODELO");
		opciones.add("COLOR");
		opciones.add("FECHA ADQUISICION");
		opciones.add("KILOMETROS");
		opciones.add("CATEGORIA");
		opciones.add("UBICACION");
		opciones.add("POTENCIA");
		opciones.add("CONSUMO");
		opciones.add("NIVEL DE EMISIONES");
		opciones.add("CAPACICAD");
		opciones.add("CARNET REQUERIDO");
		opcion=interfazusuario.MenuInt("OPCIONES", opciones, 1, 12);
		switch (opcion)
		{
		case 1:
			furgoneta.setMarca(interfazusuario.PideCadenaValidada(35, "Marca: "));
			listafurgonetas.put(matricula, furgoneta);
			break;
		case 2:
			furgoneta.setModelo(interfazusuario.PideCadenaValidada(35, "Modelo: "));
			listafurgonetas.put(matricula, furgoneta);
			break;
		case 3:
			furgoneta.setColor(interfazusuario.PideCadenaValidada(20, "Color: "));
			listafurgonetas.put(matricula, furgoneta);
			break;
		case 4:
			furgoneta.setFaltaoadqui(interfazusuario.PideFechaValidada("Fecha de adquisicion: "));
			listafurgonetas.put(matricula, furgoneta);
			break;
		case 5:
			furgoneta.setKms(interfazusuario.PideNumeroValidado(0, 2000000, "Kilometros del vehiculo: "));
			listafurgonetas.put(matricula, furgoneta);
			break;
		case 6:
			String _codcategoria;
			_codcategoria=interfazusuario.PideCadenaValidada(8, "Introduzca el tipo de categoria: ");
			furgoneta.setCategoria(BuscaCategoria(_codcategoria));
			listafurgonetas.put(matricula, furgoneta);
			break;
		case 7:
			String _opcofi=null;
			_opcofi=interfazusuario.PideCadenaValidada(8, "Introduzca el codigo de la oficina: ");
			//aqui faltaria validar la opcion, por si introducen una oficina incorrecta
			furgoneta.setUbicacion(BuscaOficina(_opcofi));
			listafurgonetas.put(matricula, furgoneta);
			break;
		case 8:
			furgoneta.setPotencia(interfazusuario.PideNumeroValidado(1, 600, "Potencia: "));
			listafurgonetas.put(matricula, furgoneta);
			break;
		case 9:
			furgoneta.setConsumo(interfazusuario.PideNumeroValidado(1, 600, "Consumo: "));
			listafurgonetas.put(matricula, furgoneta);
			break;
		case 10:
			furgoneta.setNivemisiones(interfazusuario.PideCadenaValidada(6, "Nivel de emisiones: "));
			listafurgonetas.put(matricula, furgoneta);
			break;
		case 11:
			furgoneta.setCapacidad(interfazusuario.PideNumeroValidadoDouble(1.00, 10.00, "Capacidad: "));
			listafurgonetas.put(matricula, furgoneta);
			break;
		case 12:
			String _opccarnet=null;
			_opccarnet=interfazusuario.PideCadenaValidada(3, "Introduzca su tipo de carnet:");
			furgoneta.setCarnetrequerido(BuscaCarnet(_opccarnet));
			listafurgonetas.put(matricula, furgoneta);
			break;
		
		}	
	}
	
	public void ModificarVehiculo(String matricula) throws LongitudNoValidaException, ValorNoValidoException
	{
		switch (BuscaVehiculo(matricula).getTipovehiculo())
		{
			case 1:
				ModificarCocheElect(BuscaCocheelect(matricula), matricula);
				break;
			case 2:
				ModificarMoto(BuscaMoto(matricula), matricula);
				break;
			case 3:
				ModificarCocheComb(BuscaCochecomb(matricula), matricula);
				break;
			case 4:
				ModificarFurgoneta(BuscaFurgoneta(matricula), matricula);
				break;
		}
		
		
	}
	
	
	//GETTERS Y SETTERS
	
	/**
	 * @return the _listaoficinas
	 */
	public TreeMap<String, Oficina> getListaoficinas() {
		return listaoficinas;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) throws LongitudNoValidaException {
		if (nombre.length()<=longinombre)
		{
		this.nombre = nombre;
		}
		else
		{
			throw new LongitudNoValidaException();
		}
	}

	/**
	 * @return the listacategorias
	 */
	public TreeMap<String, Categoria> getListacategorias() {
		return listacategorias;
	}

	/**
	 * @param listacategorias the listacategorias to set
	 */
	public void setListacategorias(TreeMap<String, Categoria> listacategorias) {
		this.listacategorias = listacategorias;
	}

	/**
	 * @return the listavehiculos
	 */
	public TreeMap<String, Vehiculo> getListavehiculos() {
		return listavehiculos;
	}

	/**
	 * @param listavehiculos the listavehiculos to set
	 */
	public void setListavehiculos(TreeMap<String, Vehiculo> listavehiculos) {
		this.listavehiculos = listavehiculos;
	}

	/**
	 * @param _listaoficinas the _listaoficinas to set
	 */
	public void setListaoficinas(TreeMap<String, Oficina> listaoficinas) {
		this.listaoficinas = listaoficinas;
	}
	/**
	 * @return the _listaclientes
	 */
	public TreeMap<String, Cliente> getListaclientes() {
		return listaclientes;
	}
	/**
	 * @param _listaclientes the _listaclientes to set
	 */
	public void setListaclientes(TreeMap<String, Cliente> listaclientes) {
		this.listaclientes = listaclientes;
	}
	/**
	 * @return the _listaempleados
	 */
	public TreeMap<String, Empleado> getPlantilla() {
		return plantilla;
	}
	/**
	 * @param _listaempleados the _listaempleados to set
	 */
	public void setPlantilla(TreeMap<String, Empleado> plantilla) {
		this.plantilla = plantilla;
	}

	/**
	 * @return the _nif
	 */
	public String getNif() {
		return nif;
	}

	/**
	 * @param _nif the _nif to set
	 */
	public void setNif(String nif) throws LongitudNoValidaException {
		if(nif.length()<=longinif)
		{
		this.nif = nif;
		}
		else
		{
			throw new LongitudNoValidaException();
		}
		
	}
	/**
	 * @return the tiposdecarnet
	 */
	public TreeMap<String, Carnet> getTiposdecarnet() {
		return tiposdecarnet;
	}

	/**
	 * @param tiposdecarnet the tiposdecarnet to set
	 */
	public void setTiposdecarnet(TreeMap<String, Carnet> tiposdecarnet) {
		this.tiposdecarnet = tiposdecarnet;
	}

	/**
	 * @return the vehiculosalquilados
	 */
	public TreeMap<String, Vehiculo> getVehiculosalquilados() {
		return vehiculosalquilados;
	}

	/**
	 * @param vehiculosalquilados the vehiculosalquilados to set
	 */
	public void setVehiculosalquilados(TreeMap<String, Vehiculo> vehiculosalquilados) {
		this.vehiculosalquilados = vehiculosalquilados;
	}

	/**
	 * @return the listamotos
	 */
	public TreeMap<String, Moto> getListamotos() {
		return listamotos;
	}

	/**
	 * @param listamotos the listamotos to set
	 */
	public void setListamotos(TreeMap<String, Moto> listamotos) {
		this.listamotos = listamotos;
	}

	/**
	 * @return the listafurgonetas
	 */
	public TreeMap<String, Furgoneta> getListafurgonetas() {
		return listafurgonetas;
	}

	/**
	 * @param listafurgonetas the listafurgonetas to set
	 */
	public void setListafurgonetas(TreeMap<String, Furgoneta> listafurgonetas) {
		this.listafurgonetas = listafurgonetas;
	}

	/**
	 * @return the listaccomb
	 */
	public TreeMap<String, Cochecomb> getListaccomb() {
		return listaccomb;
	}

	/**
	 * @param listaccomb the listaccomb to set
	 */
	public void setListaccomb(TreeMap<String, Cochecomb> listaccomb) {
		this.listaccomb = listaccomb;
	}

	/**
	 * @return the listacelect
	 */
	public TreeMap<String, Cocheelectrico> getListacelect() {
		return listacelect;
	}

	/**
	 * @param listacelect the listacelect to set
	 */
	public void setListacelect(TreeMap<String, Cocheelectrico> listacelect) {
		this.listacelect = listacelect;
	}


}
