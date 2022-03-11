package clasesinstanciables;

import java.io.Serializable;
import java.util.Objects;

import comparadores.NombreComparator;
import excepciones.DniNoValidoException;
import excepciones.LongitudNoValidaException;
import mismetodosgenerales.*;

public abstract class Persona implements Comparable<Persona>, Serializable{

	//PROPIEDADES 
	private static final long serialVersionUID = 8799656478674716555L;
	private String dni;
	private String nombre;
	private String ap1;
	private String ap2;
	private int longinomb=35;
	private int longiap1=35;
	private int longiap2=35;
	public static final NombreComparator nc = new NombreComparator ();
	
	//CONSTRUCTORES
	/**
	 * @param dni
	 * @param nombre
	 * @param ap1
	 * @param ap2
	 */
	public Persona(String dni, String nombre, String ap1, String ap2) throws DniNoValidoException,LongitudNoValidaException {
		super();
		this.setDni(dni);
		this.setNombre(nombre);
		this.setAp1(ap1);
		this.setAp2(ap2);
	}
	
	/**
	 * Constructor de copia
	 */
	public Persona(Persona p) throws DniNoValidoException,LongitudNoValidaException {
		this.setDni(p.getDni());
		this.setNombre(p.getNombre());
		this.setAp1(p.getAp1());
		this.setAp2(p.getAp2());
	}
	
	//METODOS 
	/**
	 * Metodo comparTo que sirve para ordena las personas en base a su nombre
	 * en el caso de que se llamen igual, las compara en base a su dni.
	 */
	public int compareTo(Persona p)
	{
		int resultado=0;
		if (this.NombreCompleto().compareToIgnoreCase(p.NombreCompleto())==-1)
		{
			resultado=-1;
		}
		else if (this.NombreCompleto().compareToIgnoreCase(p.NombreCompleto())==1)
		{
			resultado=1;
		}
		else 
		{
			if (this.dni.compareToIgnoreCase(p.dni)==-1)
			{
				resultado=-1;
			}
			else if(this.dni.compareToIgnoreCase(p.dni)==1)
			{
				resultado=1;
			}
			else 
			{
				resultado=0;
			}
		}
		return resultado;
	}
	/**
	 * Metodo toString que junta el dni con el mobre completo
	 */
	public String toString()
	{
		return dni+" - "+NombreCompleto();
	}
	/**
	 * Metodo que dice si dos personas son iguales en base a su dni.
	 * Si el dni es el mismo, las personas son la misma.
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}
	/**
	 * Metodo que devuelve que junta el nombre y los apellidos 
	 * @return Devuelve un String con los datos.
	 */
	public String NombreCompleto()
	{
		String nombrecompleto=ap1+" "+ap2+", "+nombre;
		return nombrecompleto;
	}
	/**
	 * Metodo que devuelve el dni mas el nombre completo
	 * @return
	 */
	public String DatosPersona()
	{
		return dni+" - "+NombreCompleto();
	}
	//GETTERS Y SETTERS
	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	/**Un valida dni en el setter para darle mayor seguridad.
	 * @param dni the dni to set
	 */
	private void setDni(String dni) throws DniNoValidoException 
	{
		if (Validadores.Comprueba_dni(dni))
		{
			this.dni = dni;
		}
		else
		{
			throw new DniNoValidoException();
		}
	
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
	public void setNombre(String nombre) throws LongitudNoValidaException 
	{
		if (nombre.length()<=longinomb)
		{	
			this.nombre = nombre;
		}
		else 
		{
			throw new LongitudNoValidaException();
		}
	}
	/**
	 * @return the ap1
	 */
	public String getAp1() {
		return ap1;
	}
	/**
	 * @param ap1 the ap1 to set
	 */
	public void setAp1(String ap1) throws LongitudNoValidaException
	{
		if (ap1.length()<=longiap1)
		{	
			this.ap1 = ap1;
		}
		else 
		{
			throw new LongitudNoValidaException();
		}
	}
	/**
	 * @return the ap2
	 */
	public String getAp2() {
		return ap2;
	}
	/**
	 * @param ap2 the ap2 to set
	 */
	public void setAp2(String ap2) throws LongitudNoValidaException 
	{
		if (ap2.length()<=longiap2)
		{	
			this.ap2 = ap2;
		}
		else 
		{
			throw new LongitudNoValidaException();
		}
	}
	
	
}
