package clasesinstanciables;
import java.io.Serializable;

import java.util.Objects ;

public class Carnet implements Serializable {
	
	//PROPIEDADES
	private static final long serialVersionUID = 8799656478674716637L;
	private String tipo;
	private String descripcion;
	private int longitipo =3;
	private int longidescrip=300;
	
	//CONSTRUCTORES
	/**
	 * Constructor con los dos parametros
	 * @param tipo
	 * @param descripcion
	 */
	public Carnet(String tipo,String descripcion) {
		this.setTipo(tipo);
		this.setDescripcion(descripcion);
	}
	/**
	 * Constructor solo con el tipo
	 * @param tipo
	 */
	public Carnet(String tipo) {
		this.setTipo(tipo);
	}
	/**
	 * Constructor de copia
	 * @param c
	 */
	public Carnet(Carnet c) {
		this.setTipo(c.getTipo());
		this.setDescripcion(c.getDescripcion());
	}
	
	//METODOS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carnet other = (Carnet) obj;
		return Objects.equals(tipo, other.tipo);
	}
	@Override
	public String toString()
	{
		return "Tipo: "+tipo+". "+descripcion;
	}
	
	//GETTERS Y SETTERS
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		if (tipo.length()<=longitipo)
		{	
			this.tipo = tipo;
		}
		else 
		{
			//TODO EXCEPTION
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
	public void setDescripcion(String descripcion) {
		if (descripcion.length()<=longidescrip)
		{	
			this.descripcion = descripcion;
		}
		else 
		{
			//TODO EXCEPTION
		}
	}
	
	//CONSTRUCTORES
	
	
}
