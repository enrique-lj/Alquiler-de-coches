package clasesinstanciables;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.GregorianCalendar;

import excepciones.LongitudNoValidaException;
import excepciones.ValorNoValidoException;

public class Cocheelectrico extends Electrico implements Serializable{
	//PARAMETROS
	private static final long serialVersionUID = 8799656478674716633L;
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
	 * @param tiposdecarnet
	 * @param autonomia
	 * @param tiempocarga
	 */
	public Cocheelectrico(String nbastidor, String matricula, String marca, String modelo, String color,
			GregorianCalendar faltaoadqui, int kms, Categoria categoria, Oficina ubicacion,
			int autonomia, int tiempocarga,int nplazas,String tipo) throws LongitudNoValidaException,ValorNoValidoException  {
		super(nbastidor, matricula, marca, modelo, color, faltaoadqui, kms, categoria, ubicacion,autonomia,
				tiempocarga);
		this.setNplazas(nplazas);
		this.setTipo(tipo);
	}
	/**
	 * Constructor de copia
	 * @param celect
	 */
	public Cocheelectrico(Cocheelectrico celect) throws LongitudNoValidaException,ValorNoValidoException  {
		super(celect.getNbastidor(),celect.getMatricula(),celect.getMarca(),celect.getModelo(),
				celect.getColor(),celect.getFaltaoadqui(),celect.getKms(),celect.getCategoria(),
				celect.getUbicacion(),celect.getAutonomia(),celect.getTiempocarga());	
		this.setNplazas(celect.getNplazas());
		this.setTipo(celect.getTipo());
		}
	
	//TODO METODOS
	/**
	 * Metodo toString que junta la matricula, el numero de bastidor, la marca, el modelo, el color y los kilometros.
	 */
	public String toString()
	{
		return   getMatricula()+" - "+getNbastidor()+" - "+getMarca()+" - "+" - "+getModelo()+" - "+getColor()+" - "+getKms()+"kms - "+nplazas+" plazas - "+tipo;
	}
	
	@Override
	public double CalculaImporte(int diasalquilado,int recargo,boolean ofiaeropuerto)
	{
		double preciofinal=0;
		double preciobase=50;
		//se multiplica por 15 por ser electrico y 50 por ser coche 
		double incrementoelect=(15*preciobase)/100;
		//precio base mas incremento
		double precionuevo=preciobase+incrementoelect;
		//al precio ya incrementado se le suma el recargo correspondiente por categoria
		double importerecargo=(recargo*precionuevo)/100;
		double preciotrasrecargo=importerecargo+precionuevo;
		//si es oficina de aeropuerto se le suma un recargo del 10% y se multiplica por los dias alquilado
		if (ofiaeropuerto==true)
		{
			double incremento=(10*preciotrasrecargo)/100;
			double preciototal=incremento+preciotrasrecargo;
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
	public void setTipo(String tipo) throws LongitudNoValidaException{
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
