package clasesinstanciables;
import java.io.Serializable;

import comparadores.RecargoComparator;
import excepciones.LongitudNoValidaException;
public class Categoria implements Serializable{

	//PROPIEDADES
	private static final long serialVersionUID = 8799656478674716636L;
	private String codcategoria;
	private String descripcion;
	private int recargoalquileres;
	private int longicodcat=8;
	private int longidescrip=300;
	private int longirecargo=1000;
	public static final RecargoComparator rc=new RecargoComparator();
	
	//CONSTRUCTORES
	/**
	 * constructor con todos los parametros
	 * @param codcategoria
	 * @param descripcion
	 * @param recargoalquileres
	 */
	public Categoria(String codcategoria,String descripcion,int recargoalquileres) throws LongitudNoValidaException {
		this.setCodcategoria(codcategoria);
		this.setDescripcion(descripcion);
		this.setRecargoalquileres(recargoalquileres);
	}
	/**
	 * constructor solo con codigo y descripcion
	 * @param codcategoria
	 * @param descripcion
	 */
	public Categoria(String codcategoria,String descripcion) throws LongitudNoValidaException {
		this.setCodcategoria(codcategoria);
		this.setDescripcion(descripcion);
	}
	/**
	 * constructor de copia
	 * @param categoria
	 */
	public Categoria(Categoria categoria) throws LongitudNoValidaException {
		this.setCodcategoria(categoria.getCodcategoria());
		this.setDescripcion(categoria.getDescripcion());
		this.setRecargoalquileres(categoria.getRecargoalquileres());
	}
	
	//TODO METODOS
	
	@Override
	public String toString()
	{
		return codcategoria+" - "+descripcion+" - Con un recargo del "+recargoalquileres+"%.";
	}
	
	//GETTERS Y SETTERS 
	/**
	 * @return the codcategoria
	 */
	public String getCodcategoria() {
		return codcategoria;
	}
	/**
	 * @param codcategoria the codcategoria to set
	 */
	public void setCodcategoria(String codcategoria) throws LongitudNoValidaException {
		if (codcategoria.length()<=longicodcat)
		{	
			this.codcategoria = codcategoria;
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
	 * @return the recargoalquileres
	 */
	public int getRecargoalquileres() {
		return recargoalquileres;
	}
	/**
	 * @param recargoalquileres the recargoalquileres to set
	 */
	public void setRecargoalquileres(int recargoalquileres) {
		if (recargoalquileres<=longirecargo)
		{	
			this.recargoalquileres = recargoalquileres;
		}
		else 
		{
			//TODO EXCEPTION
		}
		
	}
	
	
}
