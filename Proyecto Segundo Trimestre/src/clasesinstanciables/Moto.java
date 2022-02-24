package clasesinstanciables;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.GregorianCalendar;

import excepciones.LongitudNoValidaException;
import excepciones.ValorNoValidoException;

public class Moto extends Electrico  implements Serializable {

	//PARAMETROS
	private int cilindrada;
	private Carnet carnetrequerido;
	private int longicilindrada=3000;
	
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
	 * @param autonomia
	 * @param tiempocarga
	 */
	public Moto(String nbastidor, String matricula, String marca, String modelo, String color,
			GregorianCalendar faltaoadqui, int kms, Categoria categoria, Oficina ubicacion, int autonomia, int tiempocarga,int cilindrada,Carnet carnetrequerido)
					throws LongitudNoValidaException,ValorNoValidoException {
		super(nbastidor, matricula, marca, modelo, color, faltaoadqui, kms, categoria, ubicacion, autonomia,
				tiempocarga);
		this.setCilindrada(cilindrada);
		this.setCarnetrequerido(carnetrequerido);
	}
	/**
	 * Constructor de copia
	 * @param m
	 */
	public Moto(Moto m) throws LongitudNoValidaException,ValorNoValidoException  {
		super(m.getNbastidor(),m.getMatricula(),m.getMarca(),m.getModelo(),
				m.getColor(),m.getFaltaoadqui(),m.getKms(),m.getCategoria(),
				m.getUbicacion(), m.getAutonomia(),m.getTiempocarga());	
		this.setCilindrada(m.getCilindrada());
		this.setCarnetrequerido(m.getCarnetrequerido());
		}
	
	//TODO METODOS

	//GETTERS Y SETTERS
	/**
	 * @return the cilindrada
	 */
	public int getCilindrada() {
		return cilindrada;
	}

	/**
	 * @param cilindrada the cilindrada to set
	 */
	public void setCilindrada(int cilindrada) throws ValorNoValidoException {
		if (cilindrada<=longicilindrada)
		{	
			this.cilindrada = cilindrada;
		}
		else 
		{
			throw new ValorNoValidoException();
		}
	
	}

	/**
	 * @return the carnetrequerido
	 */
	public Carnet getCarnetrequerido() {
		return carnetrequerido;
	}

	/**
	 * @param carnetrequerido the carnetrequerido to set
	 */
	public void setCarnetrequerido(Carnet carnetrequerido) {
		this.carnetrequerido = carnetrequerido;
	}

	
}
