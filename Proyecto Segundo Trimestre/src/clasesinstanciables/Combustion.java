package clasesinstanciables;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.GregorianCalendar;

import excepciones.LongitudNoValidaException;
import excepciones.ValorNoValidoException;

public abstract class Combustion extends Vehiculo implements Serializable{

	//PROPIEDADES
	private static final long serialVersionUID = 8799656478674716632L;
	private int consumo;
	private int potencia;
	private String nivemisiones;
	private int longiconsumo=100;
	private int longipotencia=1000;
	private int longiemisiones=6;
	
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
	 */
	public Combustion(String nbastidor, String matricula, String marca, String modelo, String color,
			GregorianCalendar faltaoadqui, int kms, Categoria categoria, Oficina ubicacion,
			int consumo,int potencia,String nivemisiones)throws LongitudNoValidaException,ValorNoValidoException {
		super(nbastidor, matricula, marca, modelo, color, faltaoadqui, kms, categoria, ubicacion);
		this.consumo=consumo;
		this.potencia=potencia;
		this.nivemisiones=nivemisiones;
	}
	/**
	 * Constructor de copia
	 * @param comb
	 */
	public Combustion(Combustion comb) throws LongitudNoValidaException,ValorNoValidoException {
		super(comb.getNbastidor(),comb.getMatricula(),comb.getMarca(),comb.getModelo(),comb.getColor(),
				comb.getFaltaoadqui(),comb.getKms(),comb.getCategoria(),comb.getUbicacion());
		this.setConsumo(comb.getConsumo());
		this.setPotencia(comb.getPotencia());
		this.setNivemisiones(comb.getNivemisiones());
	}
	
	//TODO METODOS
	
	
	//GETTERS Y SETTERS
	/**
	 * @return the consumo
	 */
	public int getConsumo() {
		return consumo;
	}

	/**
	 * @param consumo the consumo to set
	 */
	public void setConsumo(int consumo) throws ValorNoValidoException {
		if (consumo<=longiconsumo)
		{	
			this.consumo = consumo;
		}
		else 
		{
			throw new ValorNoValidoException();
		}
	}

	/**
	 * @return the potencia
	 */
	public int getPotencia() {
		return potencia;
	}

	/**
	 * @param potencia the potencia to set
	 */
	public void setPotencia(int potencia) throws ValorNoValidoException {
		if (potencia<=longipotencia)
		{	
			this.potencia = potencia;
		}
		else 
		{
			throw new ValorNoValidoException();
		}
		this.potencia = potencia;
	}

	/**
	 * @return the nivemisiones
	 */
	public String getNivemisiones() {
		return nivemisiones;
	}

	/**
	 * @param nivemisiones the nivemisiones to set
	 */
	public void setNivemisiones(String nivemisiones) throws LongitudNoValidaException {
		if (nivemisiones.length()<=longiemisiones)
		{	
			this.nivemisiones = nivemisiones;
		}
		else 
		{
			throw new LongitudNoValidaException();
		}
	
	}
	
	
}
