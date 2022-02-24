package clasesinstanciables;

import java.util.ArrayList;

import java.io.Serializable;
import java.util.GregorianCalendar;

import excepciones.LongitudNoValidaException;
import excepciones.ValorNoValidoException;

public class Cochecomb extends Combustion implements Serializable {

	//PROPIEDADES
	private int nplazas;
	private String tipo;
	private int longinplazas=9;
	private int longitipo=15;
	
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
	 * @param consumo
	 * @param potencia
	 * @param nivemisiones
	 */
	public Cochecomb(String nbastidor, String matricula, String marca, String modelo, String color,
			GregorianCalendar faltaoadqui, int kms, Categoria categoria, Oficina ubicacion,
			int consumo, int potencia, String nivemisiones,int nplazas,String tipo)
					throws LongitudNoValidaException,ValorNoValidoException {
		super(nbastidor, matricula, marca, modelo, color, faltaoadqui, kms, categoria, ubicacion,consumo,
				potencia, nivemisiones);
		this.setNplazas(nplazas);
		this.setTipo(tipo);
	}
	/**
	 * Constructor de copia
	 * @param ccomb
	 */
	public Cochecomb(Cochecomb ccomb)throws LongitudNoValidaException,ValorNoValidoException  {
		super(ccomb.getNbastidor(),ccomb.getMatricula(),ccomb.getMarca(),ccomb.getModelo(),ccomb.getColor(),
				ccomb.getFaltaoadqui(),ccomb.getKms(),ccomb.getCategoria(),ccomb.getUbicacion(),
				ccomb.getConsumo(),ccomb.getPotencia(),ccomb.getNivemisiones());
		this.setNplazas(ccomb.getNplazas());
		this.setTipo(ccomb.getTipo());
	}
	//TODO METODOS
	
	//GETTERS Y SETTERS
	/**
	 * @return the nplazas
	 */
	public int getNplazas() {
		return nplazas;
	}

	/**
	 * @param nplazas the nplazas to set
	 */
	public void setNplazas(int nplazas) throws ValorNoValidoException {
		if (nplazas<=longinplazas)
		{	
			this.nplazas = nplazas;
		}
		else 
		{
			throw new ValorNoValidoException();
		}
		
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) throws LongitudNoValidaException {
		if (tipo.length()<=longitipo)
		{	
			this.tipo = tipo;
		}
		else 
		{
			throw new LongitudNoValidaException();
		}
		
	}


}
