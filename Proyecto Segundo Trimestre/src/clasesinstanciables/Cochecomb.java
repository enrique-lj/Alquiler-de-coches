package clasesinstanciables;

import java.util.ArrayList;

import java.io.Serializable;
import java.util.GregorianCalendar;

import excepciones.LongitudNoValidaException;
import excepciones.ValorNoValidoException;

public class Cochecomb extends Combustion implements Serializable {

	//PROPIEDADES
	private static final long serialVersionUID = 8799656478674716634L;
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
	/**
	 * Metodo toString que junta la matricula, el numero de bastidor, la marca, el modelo, el color y los kilometros.
	 */
	public String toString()
	{
		return   getMatricula()+" - "+getNbastidor()+" - "+getMarca()+" - "+getModelo()+" - "+getColor()+" - "+getKms()+"kms - "+nplazas+" plazas - "+tipo+" - Oficina:"+getUbicacion().getCodigoofi();
	}
	
	@Override
	public double CalculaImporte(int diasalquilado)
	{
		double preciofinal=0;
		double preciobase=50;
		//se calcula el recargo que se le tiene que hacer segun la categoria
		double importerecargo=(getCategoria().getRecargoalquileres()*preciobase)/100;
		//se le suma el recargo al precio base
		double preciotrasrecargo=importerecargo+preciobase;
		//se le suma el recargo de oficina de aeropuerto en caaso de que lo fuese
		if (getUbicacion().isOfiaeropuerto()==true)
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
