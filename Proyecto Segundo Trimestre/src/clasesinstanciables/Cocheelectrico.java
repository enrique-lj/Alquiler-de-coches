package clasesinstanciables;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.GregorianCalendar;

import excepciones.LongitudNoValidaException;
import excepciones.ValorNoValidoException;

public class Cocheelectrico extends Electrico implements Serializable{
	//PARAMETROS
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
