package clasesinstanciables;
import java.util.GregorianCalendar;
import java.io.Serializable;

import excepciones.DniNoValidoException;
import excepciones.LongitudNoValidaException;
public class Empleado extends Persona implements Serializable {
	
	//PROPIEDADES
	private GregorianCalendar faltaempresa;
	private Oficina ofitrabajador;
	
	//CONSTRUCTORES
	
	/**Constructor con datos de persona mas la fecha de alta en la empresa
* @param dni
	 * @param nombre
	 * @param ap1
	 * @param ap2
	 */
	public Empleado(String dni, String nombre, String ap1, String ap2,GregorianCalendar faltaempresa) throws DniNoValidoException,LongitudNoValidaException {
		super(dni, nombre, ap1, ap2);
		this.setFaltaempresa(faltaempresa);
	}
	/**
	 * constructor con todas las propiedades
	 * @param dni
	 * @param nombre
	 * @param ap1
	 * @param ap2
	 * @param faltaempresa
	 * @param ofitrabajador
	 */
	public Empleado(String dni, String nombre, String ap1, String ap2,GregorianCalendar faltaempresa,Oficina ofitrabajador) throws DniNoValidoException,LongitudNoValidaException {
		super(dni, nombre, ap1, ap2);
		this.setFaltaempresa(faltaempresa);
		this.setOfitrabajador(ofitrabajador);
	}
	/**
	 * constructor de copia
	 * @param e
	 */
	public Empleado(Empleado e) throws DniNoValidoException,LongitudNoValidaException {
		super(e.getDni(),e.getNombre(),e.getAp1(),e.getAp2());
		this.setFaltaempresa(e.getFaltaempresa());
		this.setOfitrabajador(e.getOfitrabajador());
	}
	
	//TODO METODOS
	
	//GETTERS Y SETTERS
	/**
	 * @return the faltaempresa
	 */
	public GregorianCalendar getFaltaempresa() {
		return faltaempresa;
	}
	/**
	 * @param faltaempresa the faltaempresa to set
	 */
	public void setFaltaempresa(GregorianCalendar faltaempresa) {
		this.faltaempresa = faltaempresa;
	}
	/**
	 * @return the ofitrabajador
	 */
	public Oficina getOfitrabajador() {
		return ofitrabajador;
	}
	/**
	 * @param ofitrabajador the ofitrabajador to set
	 */
	public void setOfitrabajador(Oficina ofitrabajador) {
		this.ofitrabajador = ofitrabajador;
	}
	

}
