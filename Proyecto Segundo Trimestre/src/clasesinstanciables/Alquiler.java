package clasesinstanciables;
import java.util.GregorianCalendar;

import metodosinterfazusuario.MetodosConcretos;

import java.io.Serializable;
public class Alquiler implements Serializable{

	//PROPIEDADES 
	private static final long serialVersionUID = 8799656478674716638L;
	private String codalquiler;
	private Vehiculo _vehiculo;
	private Empleado _empleado;
	private Cliente _cliente;
	private GregorianCalendar _finialquiler;
	private GregorianCalendar _ffinalquiler;
	private Oficina _lugaralquiler;
	private double precioprevisto;
	private Empleado empleadodev;
	private GregorianCalendar fdevolucion;
	private int kmsrecorridos;
	private double preciofinal;
	
	//CONSTRUCTORES
	
	/**
	 * Constructor con todos los parametros
	 * @param _vehiculo
	 * @param _empleado
	 * @param _cliente
	 * @param _finialquiler
	 * @param _ffinalquiler
	 * @param _lugaralquiler
	 */
	public Alquiler(String codalquiler,Vehiculo _vehiculo,Empleado _empleado,Cliente _cliente,GregorianCalendar _finialquiler,
			GregorianCalendar _ffinalquiler,Oficina _lugaralquiler,double precioprevisto) {
		this.setCodalquiler(codalquiler);
		this.set_vehiculo(_vehiculo);
		this.set_empleado(_empleado);
		this.set_cliente(_cliente);
		this.set_finialquiler(_finialquiler);
		this.set_ffinalquiler(_ffinalquiler);
		this.set_lugaralquiler(_lugaralquiler);
		this.setPrecioprevisto(precioprevisto);
	}
	
	/**
	 * Constructor de copia
	 * @param alquiler
	 */
	public Alquiler(Alquiler alquiler) {
		this.setCodalquiler(alquiler.getCodalquiler());
		this.set_vehiculo(alquiler.get_vehiculo());
		this.set_empleado(alquiler.get_empleado());
		this.set_cliente(alquiler.get_cliente());
		this.set_ffinalquiler(alquiler.get_ffinalquiler());
		this.set_finialquiler(alquiler.get_ffinalquiler());
		this.set_lugaralquiler(alquiler.get_lugaralquiler());
		this.setPrecioprevisto(alquiler.getPrecioprevisto());
	}
	
	//TODO METODOS
	
	@SuppressWarnings("deprecation")
	public String toString()
	{
		return "CODIGO: "+codalquiler+" - VEHICULO: "+_vehiculo.getMatricula()+" - EMPLEADO: "+_empleado.getDni()+
				" - CLIENTE: "+_cliente.getDni()+"; "+_cliente.NombreCompleto()+" - FECHA INCIO: "+_finialquiler.getTime().getDate()+
				"/"+_finialquiler.getTime().getMonth()+"/"+(_finialquiler.getTime().getYear()+1900)+
				" - FECHA FIN ALQUILER: "+_ffinalquiler.getTime().getDate()+"/"+_ffinalquiler.getTime().getMonth()+
				"/"+(_ffinalquiler.getTime().getYear()+1900)+" - OFICINA DE DEVOLUCION: "+_lugaralquiler.getCodigoofi()+
				" - PRECIO PREVISTO A PAGAR: "+String.format("%.2f", precioprevisto)+"€";
	}
	
	//GETTERS Y SETTERS
	/**
	 * @return the _vehiculo
	 */
	public Vehiculo get_vehiculo() {
		return _vehiculo;
	}
	/**
	 * @param _vehiculo the _vehiculo to set
	 */
	public void set_vehiculo(Vehiculo _vehiculo) {
		this._vehiculo = _vehiculo;
	}
	/**
	 * @return the _empleado
	 */
	public Empleado get_empleado() {
		return _empleado;
	}
	/**
	 * @param _empleado the _empleado to set
	 */
	public void set_empleado(Empleado _empleado) {
		this._empleado = _empleado;
	}
	/**
	 * @return the _cliente
	 */
	public Cliente get_cliente() {
		return _cliente;
	}
	/**
	 * @param _cliente the _cliente to set
	 */
	public void set_cliente(Cliente _cliente) {
		this._cliente = _cliente;
	}
	/**
	 * @return the _finialquiler
	 */
	public GregorianCalendar get_finialquiler() {
		return _finialquiler;
	}
	/**
	 * @param _finialquiler the _finialquiler to set
	 */
	public void set_finialquiler(GregorianCalendar _finialquiler) {
		this._finialquiler = _finialquiler;
	}
	/**
	 * @return the _ffinalquiler
	 */
	public GregorianCalendar get_ffinalquiler() {
		return _ffinalquiler;
	}
	/**
	 * @param _ffinalquiler the _ffinalquiler to set
	 */
	public void set_ffinalquiler(GregorianCalendar _ffinalquiler) {
		this._ffinalquiler = _ffinalquiler;
	}
	/**
	 * @return the _lugaralquiler
	 */
	public Oficina get_lugaralquiler() {
		return _lugaralquiler;
	}
	/**
	 * @param _lugaralquiler the _lugaralquiler to set
	 */
	public void set_lugaralquiler(Oficina _lugaralquiler) {
		this._lugaralquiler = _lugaralquiler;
	}

	/**
	 * @return the codalquiler
	 */
	public String getCodalquiler() {
		return codalquiler;
	}

	/**
	 * @param codalquiler the codalquiler to set
	 */
	public void setCodalquiler(String codalquiler) {
		this.codalquiler = codalquiler;
	}

	/**
	 * @return the precioprevisto
	 */
	public double getPrecioprevisto() {
		return precioprevisto;
	}

	/**
	 * @param precioprevisto the precioprevisto to set
	 */
	public void setPrecioprevisto(double precioprevisto) {
		this.precioprevisto = precioprevisto;
	}

	/**
	 * @return the empleadodev
	 */
	public Empleado getEmpleadodev() {
		return empleadodev;
	}

	/**
	 * @param empleadodev the empleadodev to set
	 */
	public void setEmpleadodev(Empleado empleadodev) {
		this.empleadodev = empleadodev;
	}

	/**
	 * @return the fdevolucion
	 */
	public GregorianCalendar getFdevolucion() {
		return fdevolucion;
	}

	/**
	 * @param fdevolucion the fdevolucion to set
	 */
	public void setFdevolucion(GregorianCalendar fdevolucion) {
		this.fdevolucion = fdevolucion;
	}

	/**
	 * @return the kmsrecorridos
	 */
	public int getKmsrecorridos() {
		return kmsrecorridos;
	}

	/**
	 * @param kmsrecorridos the kmsrecorridos to set
	 */
	public void setKmsrecorridos(int kmsrecorridos) {
		this.kmsrecorridos = kmsrecorridos;
	}

	/**
	 * @return the preciofinal
	 */
	public double getPreciofinal() {
		return preciofinal;
	}

	/**
	 * @param preciofinal the preciofinal to set
	 */
	public void setPreciofinal(double preciofinal) {
		this.preciofinal = preciofinal;
	}
	
	
}
