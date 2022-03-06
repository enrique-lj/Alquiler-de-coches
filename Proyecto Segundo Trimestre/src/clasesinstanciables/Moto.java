package clasesinstanciables;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.GregorianCalendar;

import excepciones.LongitudNoValidaException;
import excepciones.ValorNoValidoException;

public class Moto extends Electrico  implements Serializable {

	//PARAMETROS
	private static final long serialVersionUID = 8799656478674716333L;
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
	/**
	 * Metodo toString que junta la matricula, el numero de bastidor, la marca, el modelo, el color y los kilometros.
	 */
	public String toString()
	{
		return   getMatricula()+" - "+getNbastidor()+" - "+getMarca()+" - "+" - "+getModelo()+" - "+getColor()+" - "+getKms()+"kms - "+cilindrada+"cm3 - Carnet("+carnetrequerido.getTipo()+") - Moto.";
	}
	
	@Override
	public double CalculaImporte(int diasalquilado,int recargo,boolean ofiaeropuerto)
	{
		double preciofinal=0;
		double preciobase=10;
		//se multiplica por 15 por ser electrico y 10 por ser moto 
		double incrementoelect=(15*preciobase)/100;
		//precio base mas incremento
		double precionuevo=preciobase+incrementoelect;
		//al precio ya incrementado se le suma el recargo correspondiente por categoria
		double importerecargo=(recargo*precionuevo)/100;
		double preciotrasrecargo=precionuevo+importerecargo;
		//si es oficina de aeropuerto se le suma un recargo del 10% y se multiplica por los dias alquilado
		if (ofiaeropuerto==true)
		{
			double importe=(10*preciotrasrecargo)/100;
			double preciototal=importe+preciotrasrecargo;
			preciofinal=preciototal*diasalquilado;
		}
		else
		{
			preciofinal=preciotrasrecargo*diasalquilado;
		}	
		return preciofinal;	
	}
	
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
