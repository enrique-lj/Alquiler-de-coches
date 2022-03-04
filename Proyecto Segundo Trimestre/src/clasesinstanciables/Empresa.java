package clasesinstanciables;
import java.util.ArrayList;
import java.util.TreeMap;

import excepciones.LongitudNoValidaException;
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
	
	private void inicializaempresa()
	{
		listaoficinas=new TreeMap <String, Oficina>();
		listaclientes=new TreeMap <String, Cliente>();
		plantilla=new TreeMap <String, Empleado>();
		listavehiculos=new TreeMap <String, Vehiculo>();
		tiposdecarnet=new TreeMap<String, Carnet>();
		listacategorias=new TreeMap<String, Categoria>();
	}
	
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
	public void AñadeVehiculo(Empresa empresa) 
	{
		Vehiculo vehiculo=MetodosConcretos.PideDatosVehiculo(empresa);
		listavehiculos.put(vehiculo.getMatricula(), vehiculo);
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
		listavehiculos.remove(matricula);
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


}
