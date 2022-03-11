package principal;

import java.io.IOException;
import java.util.ArrayList;

import clasesinstanciables.*;
import excepciones.LongitudNoValidaException;
import excepciones.ValorNoValidoException;
import menus.Menus;
import metodosinterfazusuario.*;

public class Principal {

	public static void main(String[] args) throws IOException, LongitudNoValidaException, ValorNoValidoException {
		
		Empresa empresa=Empresa.leeEmpresa();
		Menus.MenuPrincipal(empresa);
		//quitarlo despues
		System.out.println(empresa.getNif()+empresa.getNombre());
	}

}
