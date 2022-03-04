package clasesinstanciables;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.GregorianCalendar;

import excepciones.LongitudNoValidaException;
import excepciones.ValorNoValidoException;

public class Furgoneta extends Combustion implements Serializable {

	//PROPIEDADES
	private static final long serialVersionUID = 8799656478674716222L;
	private double capacidad;
	private Carnet carnetrequerido;
	private double longicapacidad=10.0;
	
	//CONSTRUCTOR
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
	public Furgoneta(String nbastidor, String matricula, String marca, String modelo, String color,
			GregorianCalendar faltaoadqui, int kms, Categoria categoria, Oficina ubicacion,
			int consumo, int potencia, String nivemisiones,
			double capacidad,Carnet carnetrequerido) throws LongitudNoValidaException,ValorNoValidoException  {
		super(nbastidor, matricula, marca, modelo, color, faltaoadqui, kms, categoria, ubicacion,consumo,
				potencia, nivemisiones);
		this.setCapacidad(capacidad);
		this.setCarnetrequerido(carnetrequerido);
	}
	/**
	 * Constructor de copia
	 * @param furgo
	 */
	public Furgoneta(Furgoneta furgo) throws LongitudNoValidaException,ValorNoValidoException  {
		super(furgo.getNbastidor(),furgo.getMatricula(),furgo.getMarca(),furgo.getModelo(),furgo.getColor(),
				furgo.getFaltaoadqui(),furgo.getKms(),furgo.getCategoria(),furgo.getUbicacion(),
				furgo.getConsumo(),furgo.getPotencia(),furgo.getNivemisiones());
		this.setCapacidad(furgo.getCapacidad());
		this.setCarnetrequerido(furgo.getCarnetrequerido());
	}
	
	//TODO METODOS
	/**
	 * Metodo toString que junta la matricula, el numero de bastidor, la marca, el modelo, el color y los kilometros.
	 */
	public String toString()
	{
		return   getMatricula()+" - "+getNbastidor()+" - "+getMarca()+" - "+" - "+getModelo()+" - "+getColor()+" - "+getKms()+"kms - "+capacidad+"m3 - Carnet("+carnetrequerido.getTipo()+") - Furgoneta.";
	}
	
	//GETTERS Y SETTERS
	/**
	 * @return the capacidad
	 */
	public double getCapacidad() {
		return capacidad;
	}

	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(double capacidad) throws ValorNoValidoException {
		if (capacidad<=longicapacidad)
		{	
			this.capacidad = capacidad;
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
