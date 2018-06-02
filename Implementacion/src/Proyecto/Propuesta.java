package Proyecto;

import java.util.Iterator;

public class Propuesta {

	private Demanda dem;
	private Oferta o;
	private double total=0;
	private double contador=0;
	private double puntuacion;
	
	private final int PONDERACION_IDIOMAS = 5;
	private final int PONDERACION_EXPERIENCIA = 6;
	private final int PONDERACION_LENGUAJESP = 8;
	
	// Debido a que a la hora de asignar a un programador, hay requisitos que no son tan 
	// importantes como otros, hemos asignado el orden de importancia:
	// lenguajeProgramacion > añosExperienza > idiomas
	
	public Propuesta (Demanda d, Oferta ofer){
		dem=d;
		o=ofer;
		
		anyoExperiencia();
		lenguajesProgramacion();
		idiomas();
		
		puntuacion=(10*contador)/total;
		
		System.out.println("Al usuario "+dem.getId()+" se le ha asignado una puntuacion en el proyecto ->"+o.getNombre()+"<- de: "+puntuacion);
	}
	
	// El calculo de la puntucion la realizaremos la suma acumulada de requisitos exigidos en la
	// oferta y la suma de los requisitos los cuales cumple el usuario. Una vez obtenidos
	// estos valores, realizamos una simple regla de 3 para obtener una puntuación sobre 10.
	
	private void idiomas() {
		Iterator<Boolean> itUsuario = dem.getIdiomas().iterator();
		Iterator<Boolean> itOferta = o.getIdiomas().iterator();
		boolean aux1, aux2;
		while(itOferta.hasNext()){
			aux1 = itOferta.next();
			aux2 = itUsuario.next();
			if(aux1==true){
				total = total+PONDERACION_IDIOMAS;
				if(aux2==true){
					contador = contador+PONDERACION_IDIOMAS;
				}
			}
		}
	}
	
	private void lenguajesProgramacion() {
		Iterator<Boolean> itUsuario = dem.getLenguajes().iterator();
		Iterator<Boolean> itOferta = o.getLenguajes().iterator();
		boolean aux1, aux2;
		while(itOferta.hasNext()){
			aux1 = itOferta.next();
			aux2 = itUsuario.next();
			if(aux1==true){
				total = total+PONDERACION_LENGUAJESP;
				if(aux2==true){
					contador = contador+PONDERACION_LENGUAJESP;
				}
			}
		}
	}

	private void anyoExperiencia() {
		int diferencia=dem.getExperiencia()-o.getExperiencia();
		total=total+6;
		if(diferencia>=0){
			contador=contador+PONDERACION_EXPERIENCIA;
		}else if(diferencia<0 && diferencia>-2){
			contador=contador+PONDERACION_EXPERIENCIA-2;
		}else if(diferencia<0 && diferencia>-4){
			contador=contador+PONDERACION_EXPERIENCIA-4;
		}
	}
}
