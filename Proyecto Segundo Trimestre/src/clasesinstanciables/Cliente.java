package clasesinstanciables;
import java.io.Serializable;
import excepciones.DniNoValidoException;
import excepciones.LongitudNoValidaException;
import excepciones.ValorNoValidoException;

public class Cliente extends Persona implements Serializable {
	
	//PROPIEDADES
	private static final long serialVersionUID = 8799656478674716635L;
	private Carnet tipocarnet;//he cambiado el tipo de Carnet a String, si no vale volver a cambiarlo.
	private int ntarjetacliente;
	private int longintarjeta=100000;
	
	//CONSTRUCTORES
	/**
	 * @param dni

	 * @param nombre
	 * @param ap1
	 * @param ap2
	 */
	public Cliente(String dni, String nombre, String ap1, String ap2 ,Carnet tipocarnet,int ntarjetacliente) throws DniNoValidoException,LongitudNoValidaException,ValorNoValidoException {
		super(dni, nombre, ap1, ap2);
		this.setTipocarnet(tipocarnet);
		this.setNtarjetacliente(ntarjetacliente);
	}
	public Cliente(String dni, String nombre, String ap1, String ap2 ,Carnet tipocarnet) throws DniNoValidoException,LongitudNoValidaException {
		super(dni, nombre, ap1, ap2);
		this.setTipocarnet(tipocarnet);
	}
	/**
	 * constructor de copia de cliente
	 * @param 
	 */
	public Cliente(Cliente c) throws Exception {
		super(c.getDni(),c.getNombre(),c.getAp1(),c.getAp2());
		this.setTipocarnet(c.getTipocarnet());
		this.setNtarjetacliente(c.getNtarjetacliente());
	}
	
	//TODO METODOS
	/*
	@Override
	public String toString()
	{
		return ;
	}*/
	public String toString()
	{
		return getDni()+" - "+NombreCompleto()+", con carnet "+tipocarnet.getTipo();
	}
	
	//GETTERS Y SETTERS
	/**
	 * @return the tipocarnet
	 */
	public Carnet getTipocarnet() {
		return tipocarnet;
	}
	/**
	 * @param tipocarnet the tipocarnet to set
	 */
	public void setTipocarnet(Carnet tipocarnet) {
		
	}
	/**
	 * @return the ntarjetacliente
	 */
	public int getNtarjetacliente() {
		return ntarjetacliente;
	}
	/**
	 * @param ntarjetacliente the ntarjetacliente to set
	 */
	public void setNtarjetacliente(int ntarjetacliente)throws ValorNoValidoException {
		if (ntarjetacliente<=longintarjeta)
		{	
			this.ntarjetacliente = ntarjetacliente;
		}
		else 
		{
			throw new ValorNoValidoException();

		}	
	}
	
	
	

}
