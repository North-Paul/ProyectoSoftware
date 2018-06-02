package Proyecto;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int idEmpresa=101, idUsuario=7007;
		Usuario u = Usuario.crearUsuario(idUsuario, "Paquito Perez");
		Oferta o = Oferta.crearOferta(idEmpresa, "Proyecto Software");
		
		u.setExperiencia(2);
		o.setExperiencia(4);
		
		List<Boolean> lenguajesO = new ArrayList<Boolean>();
		lenguajesO.add(true);
		lenguajesO.add(false);
		lenguajesO.add(true);
		o.setLenguajes(lenguajesO);
		List<Boolean> lenguajesU = new ArrayList<Boolean>();
		lenguajesU.add(true);
		lenguajesU.add(false);
		lenguajesU.add(true);
		u.setLenguajes(lenguajesU);
		
		List<Boolean> idiomas = new ArrayList<Boolean>();
		idiomas.add(true);
		idiomas.add(false);
		u.setIdiomas(idiomas);
		o.setIdiomas(idiomas);
		
		Propuesta p = new Propuesta(u,o);
	}

}
