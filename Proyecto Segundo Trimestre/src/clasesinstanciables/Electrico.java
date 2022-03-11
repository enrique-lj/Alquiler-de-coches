package clasesinstanciables;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.GregorianCalendar;

import excepciones.LongitudNoValidaException;
import excepciones.ValorNoValidoException;

public abstract class Electrico extends Vehiculo implements Serializable{
	//PROPIEDADES
	private static final long serialVersionUID = 8799656478674716631L;
	private int autonomia;
	private int tiempocarga;
	private int recargo=15;
	private int longiautonomia=600;
	private int longirecarga=600;
	
	//CONSTRUCTORES
	/**Constructor con todas las propiedades
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
	public Electrico(String nbastidor, String matricula, String marca, String modelo, String color,
			GregorianCalendar faltaoadqui, int kms, Categoria categoria, Oficina ubicacion,int autonomia,int tiempocarga)throws LongitudNoValidaException,ValorNoValidoException {
		super(nbastidor, matricula, marca, modelo, color, faltaoadqui, kms, categoria, ubicacion);
		this.setAutonomia(autonomia);
		this.setTiempocarga(tiempocarga);
	}
	/**
	 * Constructor de copia
	 * @param elec
	 */
	public Electrico(Electrico elec) throws LongitudNoValidaException,ValorNoValidoException {
		super(elec.getNbastidor(),elec.getMatricula(),elec.getMarca(),elec.getModelo(),elec.getColor(),
				elec.getFaltaoadqui(),elec.getKms(),elec.getCategoria(),elec.getUbicacion());
		this.setAutonomia(elec.getAutonomia());
		this.setTiempocarga(elec.getTiempocarga());
	}
	
	//TODO METODOS
	
	//GETTERS Y SETTERS
	/**
	 * @return the autonomia
	 */
	public int getAutonomia() {
		return autonomia;
	}

	/**
	 * @param autonomia the autonomia to set
	 */
	public void setAutonomia(int autonomia) throws ValorNoValidoException {
		if (autonomia<=longiautonomia)
		{	
			this.autonomia = autonomia;
		}
		else 
		{
			throw new ValorNoValidoException();
		}
		
	}

	/**
	 * @return the tiempocarga
	 */
	public int getTiempocarga() {
		return tiempocarga;
	}

	/**
	 * @param tiempocarga the tiempocarga to set
	 */
	public void setTiempocarga(int tiempocarga) throws ValorNoValidoException {
		if (tiempocarga<=longirecarga)
		{	
			this.tiempocarga = tiempocarga;
		}
		else 
		{
			throw new ValorNoValidoException();
		}
		
	}
	/**
	 * @return the recargo
	 */
	public int getRecargo() {
		return recargo;
	}
	/**
	 * @param recargo the recargo to set
	 */
	public void setRecargo(int recargo) {
		this.recargo = recargo;
	}
	
	

	
}
