package clasesinstanciables;
import java.util.GregorianCalendar;
import mismetodosgenerales.*;
import java.util.Objects;

import excepciones.LongitudNoValidaException;
import excepciones.ValorNoValidoException;

import java.io.Serializable;
import java.util.ArrayList;
public abstract class Vehiculo implements Comparable<Vehiculo>, Serializable {

	private static final long serialVersionUID = 8799656478674716777L;
	private String nbastidor;
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private GregorianCalendar faltaoadqui;
	private int kms;
	private Categoria categoria;
	private Oficina ubicacion;
	private int longinbasti=17;
	private int longimatricula=7;
	private int longimarca=35;
	private int longimodelo=35;
	private int longicolor=20;
	private int longikms=2000000;
	
	//CONSTRUCTORES
	/**Constructor con todos los parametros
	 * @param nbastidor
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param color
	 * @param faltaoadqui
	 * @param kms
	 * @param categoria
	 * @param ubicacion
	 * @param tiposdecarnet
	 */
	public Vehiculo(String nbastidor, String matricula, String marca, String modelo, String color,
			GregorianCalendar faltaoadqui, int kms, Categoria categoria, Oficina ubicacion) throws LongitudNoValidaException,ValorNoValidoException {
		super();
		this.setNbastidor(nbastidor);
		this.setMatricula(matricula);
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setColor(color);
		this.setFaltaoadqui(faltaoadqui);
		this.setKms(kms);
		this.setCategoria (categoria);
		this.setUbicacion(ubicacion);
	}
	
	/**
	 * Constructor de copia
	 * @param v
	 */
	public Vehiculo(Vehiculo v) throws LongitudNoValidaException,ValorNoValidoException {
		this.setNbastidor(v.getNbastidor());
		this.setMatricula(v.getMatricula());
		this.setMarca(v.getMarca());
		this.setModelo(v.getModelo());
		this.setColor(v.getColor());
		this.setFaltaoadqui(v.getFaltaoadqui());
		this.setKms(v.getKms());
		this.setCategoria(v.getCategoria());
		this.setUbicacion(v.getUbicacion());
	}
	
	//TODO METODOS
	public int compareTo(Vehiculo v) {
		int resultado=0;
		if (this.marca.compareToIgnoreCase(v.marca)==-1)
		{
			resultado=-1;
		}
		else if (this.marca.compareToIgnoreCase(v.marca)==1)
		{
			resultado=1;
		}
		else 
		{
			if (this.modelo.compareToIgnoreCase(v.modelo)==-1)
			{
				resultado=-1;
			}
			else if(this.modelo.compareToIgnoreCase(v.modelo)==1)
			{
				resultado=1;
			}
			else 
			{
				if (this.matricula.compareToIgnoreCase(v.matricula)==-1)
				{
					resultado=-1;
				}
				else if(this.matricula.compareToIgnoreCase(v.matricula)==1)
				{
					resultado=1;
				}
				else 
				{
					resultado=0;
				}
			}
		}
		return resultado;
	
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(nbastidor, other.nbastidor);
	}
	
	/**
	 * Metodo toString que junta la matricula, el numero de bastidor, la marca, el modelo, el color y los kilometros.
	 */
	public String toString()
	{
		return matricula+" - "+nbastidor+" - "+marca+" - "+" - "+modelo+" - "+color+" - "+kms+"kms - ";
	}
	
	//GETTERS Y SETTERS
	
	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}
	/**
	 * @return the nbastidor
	 */
	public String getNbastidor() {
		return nbastidor;
	}
	/**
	 * @param nbastidor the nbastidor to set
	 */
	public void setNbastidor(String nbastidor) throws LongitudNoValidaException {
		if (nbastidor.length()<=longinbasti)
		{	
			this.nbastidor = nbastidor;
		}
		else 
		{
			throw new LongitudNoValidaException();
		};
	}
	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) throws LongitudNoValidaException {
		
		if (matricula.length()<=longimatricula)
		{
			this.matricula = matricula;
		}
		else
		{
			throw new LongitudNoValidaException();
		}
	}
	/**
	 * @return the marca
	 */
	public String getMarca() {
		
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) throws LongitudNoValidaException {
		if (marca.length()<=longimarca)
		{	
			this.marca = marca;
		}
		else 
		{
			throw new LongitudNoValidaException();

		}
	
	}
	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) throws LongitudNoValidaException {
		if (modelo.length()<=longimodelo)
		{	
			this.modelo = modelo;
		}
		else 
		{
			throw new LongitudNoValidaException();
		}
		
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) throws LongitudNoValidaException {
		if (color.length()<=longicolor)
		{	
			this.color = color;
		}
		else 
		{
			throw new LongitudNoValidaException();
		}
		
	}
	/**
	 * @return the faltaoadqui
	 */
	public GregorianCalendar getFaltaoadqui() {
		return faltaoadqui;
	}
	/**
	 * @param faltaoadqui the faltaoadqui to set
	 */
	public void setFaltaoadqui(GregorianCalendar faltaoadqui) {
		this.faltaoadqui = faltaoadqui;
	}
	/**
	 * @return the kms
	 */
	public int getKms() {
		return kms;
	}
	/**
	 * @param kms the kms to set
	 */
	public void setKms(int kms) throws ValorNoValidoException {
		if (kms<=longikms)
		{	
			this.kms = kms;
		}
		else 
		{
			throw new ValorNoValidoException();
		}
		
	}
	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	/**
	 * @return the ubicacion
	 */
	public Oficina getUbicacion() {
		return ubicacion;
	}
	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(Oficina ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
	
	
}
