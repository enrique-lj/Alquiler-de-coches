package clasesinstanciables;

import java.io.Serializable;
import java.util.ArrayList;

import excepciones.LongitudNoValidaException;
public class Oficina implements Serializable {

	//PROPIEDADES
	private String codigoofi;
	private String descripcion;
	private String localidad;
	private String provincia;
	private ArrayList<Empleado>listaempleados=new ArrayList<Empleado>();
	private boolean ofiaeropuerto;
	private int longicodigo=8;
	private int longidescrip=300;
	private int longilocalidad=75;
	private int longiprovincia=35;
	
	
	//CONSTRUCTORES
	/**
	 * constructor con todos los parametros
	 * @param codigo
	 * @param descripcion
	 * @param localidad
	 * @param provincia
	 * @param listaempleados
	 * @param ofiaeropuerto
	 */
	public Oficina (String codigoofi,String descripcion,String localidad,String provincia,ArrayList<Empleado>listaempleados,boolean ofiaeropuerto) throws LongitudNoValidaException {
		this.setCodigoofi(codigoofi);
		this.setDescripcion(descripcion);
		this.setLocalidad(localidad);
		this.setProvincia(provincia);
		this.setListaempleados(listaempleados);
		this.setOfiaeropuerto(ofiaeropuerto);
	}
	/**
	 * constructor con todos los parametros menos la plantilla
	 * @param codigo
	 * @param descripcion
	 * @param localidad
	 * @param provincia
	 * @param listaempleados
	 * @param ofiaeropuerto
	 */
	public Oficina (String codigoofi,String descripcion,String localidad,String provincia,boolean ofiaeropuerto) throws LongitudNoValidaException{
		this.setCodigoofi(codigoofi);
		this.setDescripcion(descripcion);
		this.setLocalidad(localidad);
		this.setProvincia(provincia);
		this.setOfiaeropuerto(ofiaeropuerto);
	}
	/**
	 * constructor con todos los parametros menos la plantilla y la oficina de aeropuerto
	 * @param codigo
	 * @param descripcion
	 * @param localidad
	 * @param provincia
	 * @param listaempleados
	 * @param ofiaeropuerto
	 */
	public Oficina (String codigoofi,String descripcion,String localidad,String provincia) throws LongitudNoValidaException {
		this.setCodigoofi(codigoofi);
		this.setDescripcion(descripcion);
		this.setLocalidad(localidad);
		this.setProvincia(provincia);
	}
	/**
	 * constructor con el codigo,localidad y provincia
	 * @param codigo
	 * @param localidad
	 * @param provincia
	 */
	public Oficina (String codigoofi,String localidad,String provincia) throws LongitudNoValidaException {
		this.setCodigoofi(codigoofi);
		this.setLocalidad(localidad);
		this.setProvincia(provincia);
	}
	/**
	 * constructor sin el boolean de ofiaeropuerto
	 * @param codigo
	 * @param descripcion
	 * @param localidad
	 * @param provincia
	 * @param listaempleados
	 */
	public Oficina (String codigoofi,String descripcion,String localidad,String provincia,ArrayList<Empleado>listaempleados) throws LongitudNoValidaException {
		this.setCodigoofi(codigoofi);
		this.setDescripcion(descripcion);
		this.setLocalidad(localidad);
		this.setProvincia(provincia);
		this.setListaempleados(listaempleados);
	}
	/**
	 * constructor de copia
	 * @param ofi
	 */
	public Oficina(Oficina ofi) throws LongitudNoValidaException {
		this.setCodigoofi(ofi.getCodigoofi());
		this.setDescripcion(ofi.getDescripcion());
		this.setLocalidad(ofi.getLocalidad());
		this.setProvincia(ofi.getProvincia());
		this.setListaempleados(ofi.getListaempleados());
	}//falta la ofiaeropuerto xk no tiene geter, preguntarlo en clase
	
	
	//TODO METODOS

	//GETTERS Y SETTERS
	/**
	 * @return the codigo
	 */
	public String getCodigoofi() {
		return codigoofi;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigoofi(String codigoofi) throws LongitudNoValidaException {
		if (codigoofi.length()<=longicodigo)
		{	
			this.codigoofi = codigoofi;
		}
		else 
		{
			throw new LongitudNoValidaException();

		}
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) throws LongitudNoValidaException {
		if (descripcion.length()<=longidescrip)
		{	
			this.descripcion = descripcion;
		}
		else 
		{
			throw new LongitudNoValidaException();

		}
	
	}

	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) throws LongitudNoValidaException{
		if (localidad.length()<=longilocalidad)
		{	
			this.localidad = localidad;
		}
		else 
		{
			throw new LongitudNoValidaException();
		}
	
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) throws LongitudNoValidaException {
		if (provincia.length()<=longiprovincia)
		{	
			this.provincia = provincia;
		}
		else 
		{
			throw new LongitudNoValidaException();
		}
	}

	/**
	 * @return the listaempleados
	 */
	public ArrayList<Empleado> getListaempleados() {
		return listaempleados;
	}

	/**
	 * @param listaempleados the listaempleados to set
	 */
	public void setListaempleados(ArrayList<Empleado> listaempleados) {
		this.listaempleados = listaempleados;
	}

	/**
	 * @return the ofiaeropuerto
	 */
	public boolean isOfiaeropuerto() {
		return ofiaeropuerto;
	}

	/**
	 * @param ofiaeropuerto the ofiaeropuerto to set
	 */
	public void setOfiaeropuerto(boolean ofiaeropuerto) {
		this.ofiaeropuerto = ofiaeropuerto;
	}

	
}
