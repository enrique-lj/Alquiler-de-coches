package principal;

import java.io.IOException;
import java.util.ArrayList;

import clasesinstanciables.*;
import excepciones.LongitudNoValidaException;
import metodosinterfazusuario.*;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		Empresa.leeEmpresa();
		
		MetodosConcretos.MenuPrincipal();
		
		
	
	}

}
