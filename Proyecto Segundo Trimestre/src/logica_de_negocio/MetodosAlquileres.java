package logica_de_negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import clasesinstanciables.*;
import excepciones.ValorNoValidoException;
import metodosinterfazusuario.MetodosConcretos;
import mismetodosgenerales.interfazusuario;

public class MetodosAlquileres {

	/**
	 * Metodo que te calcula el precio previsto del alquiler a traves del metodo de calcula importe, en funcion
	 * del tipo de vehiculo que sea.
	 * @param empresa
	 * @param matricula
	 * @param diasalquilado
	 * @param tipo
	 * @return
	 */
	public static double CalcularPrecioPrevisto(Empresa empresa,String matricula,int diasalquilado,int tipo)
	{
		double precio=0;
		switch (tipo)
		{
			case 1://COCHE ELECTRICO
				Cocheelectrico celec=empresa.BuscaCocheelect(matricula);
				precio=celec.CalculaImporte(diasalquilado, celec.getCategoria().getRecargoalquileres(), celec.getUbicacion().isOfiaeropuerto());
				break;
			case 2://MOTO
				Moto moto=empresa.BuscaMoto(matricula);
				precio=moto.CalculaImporte(diasalquilado, moto.getCategoria().getRecargoalquileres(), moto.getUbicacion().isOfiaeropuerto());
				break;
			case 3://COCHE COMBUSTION
				Cochecomb ccomb=empresa.BuscaCochecomb(matricula);
				precio=ccomb.CalculaImporte(diasalquilado, ccomb.getCategoria().getRecargoalquileres(),ccomb.getUbicacion().isOfiaeropuerto());
				break;
			case 4://FURGONETA
				Furgoneta furgo=empresa.BuscaFurgoneta(matricula);
				precio=furgo.CalculaImporte(diasalquilado, furgo.getCategoria().getRecargoalquileres(), furgo.getUbicacion().isOfiaeropuerto());
				break;
		}
		return precio;
	}
	
	/**
	 * Metodo que se encarga de modificar los distintos vehiculos en funcion del tipo al que pertenezcan,
	 * cambiando sus kms y su oficina en la devolucion y despues añadiendolo a la lista de stock
	 * @param empresa
	 * @param matricula
	 * @param kmsrecorridos
	 * @param tipo
	 * @param ofidevolucion
	 * @throws ValorNoValidoException
	 */
	public static void ModificacionesDevolucion(Empresa empresa,String matricula,int kmsrecorridos,int tipo,Oficina ofidevolucion)throws ValorNoValidoException
	{
		switch (tipo)
		{
			case 1://COCHE ELECTRICO
				Cocheelectrico celec=empresa.BuscaCocheelect(matricula);
				celec.setKms(celec.getKms()+kmsrecorridos);
				celec.setUbicacion(ofidevolucion);
				empresa.AñadeVehiculo(empresa, celec);
				break;
			case 2://MOTO
				Moto moto=empresa.BuscaMoto(matricula);
				moto.setKms(moto.getKms()+kmsrecorridos);
				moto.setUbicacion(ofidevolucion);
				empresa.AñadeVehiculo(empresa, moto);
				break;
			case 3://COCHE COMBUSTION
				Cochecomb ccomb=empresa.BuscaCochecomb(matricula);
				ccomb.setKms(ccomb.getKms()+kmsrecorridos);
				ccomb.setUbicacion(ofidevolucion);
				empresa.AñadeVehiculo(empresa, ccomb);
				break;
			case 4://FURGONETA
				Furgoneta furgo=empresa.BuscaFurgoneta(matricula);
				furgo.setKms(furgo.getKms()+kmsrecorridos);
				furgo.setUbicacion(ofidevolucion);
				empresa.AñadeVehiculo(empresa, furgo);
				break;
		}
	}

	
	
	
	
}
