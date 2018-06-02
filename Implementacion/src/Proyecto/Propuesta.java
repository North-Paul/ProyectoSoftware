package Proyecto;

import java.util.Iterator;

public class Propuesta {

	private Usuario us;
	private Oferta o;
	private double total=0;
	private double contador=0;
	private double puntuacion;
	
	public Propuesta (Usuario u, Oferta ofer){
		us=u;
		o=ofer;
		
		anyoExperiencia();
		lenguajesProgramacion();
		idiomas();
		
		puntuacion=(10*contador)/total;
		
		System.out.println("Al usuario "+us.getId()+" se le ha asignado una puntuacion en el proyecto ->"+o.getNombre()+"<- de: "+puntuacion);
	}
	
	// Debido a que a la hora de asignar a un programador, hay requisitos que no son tan 
	// importantes como otros, hemos asignado el orden de importancia:
	// lenguajeProgramacion > añosExperienza > idiomas
	
	private void idiomas() {
		Iterator<Boolean> itUsuario = us.getIdiomas().iterator();
		Iterator<Boolean> itOferta = o.getIdiomas().iterator();
		boolean aux1, aux2;
		while(itOferta.hasNext()){
			aux1 = itOferta.next();
			aux2 = itUsuario.next();
			if(aux1==true){
				total = total+5;
				if(aux2==true){
					contador = contador+5;
				}
			}
		}
	}
	
	private void lenguajesProgramacion() {
		Iterator<Boolean> itUsuario = us.getLenguajes().iterator();
		Iterator<Boolean> itOferta = o.getLenguajes().iterator();
		boolean aux1, aux2;
		while(itOferta.hasNext()){
			aux1 = itOferta.next();
			aux2 = itUsuario.next();
			if(aux1==true){
				total = total+8;
				if(aux2==true){
					contador = contador+8;
				}
			}
		}
	}

	private void anyoExperiencia() {
		int diferencia=us.getExperiencia()-o.getExperiencia();
		total=total+6;
		if(diferencia>=0){
			contador=contador+6;
		}else if(diferencia<0 && diferencia>-2){
			contador=contador+4;
		}else if(diferencia<0 && diferencia>-4){
			contador=contador+2;
		}
	}
}
