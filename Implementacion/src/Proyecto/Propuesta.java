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
	
	// La clase propuesta se encargará de asignar a cada demanda una puntuación con respecto a
	// una oferta dada. Para el cálculo de dicha puntuación, hemos asignado una ponderación a cada
	// requisito. A mayor sea esta ponderación, más importancia tendrá el requisito para el
	// cálculo de dicha puntuación
	
	public Propuesta (Demanda d, Oferta ofer){
		dem=d;
		o=ofer;
		
		anyoExperiencia();
		lenguajesProgramacion();
		idiomas();
		
		puntuacion=(10*contador)/total;
		
		System.out.println("Al usuario "+dem.getId()+" se le ha asignado una puntuacion en el proyecto ->"+o.getNombre()+"<- de: "+puntuacion);
	}
	
	// El calculo de la puntucion la realizaremos mediante la suma acumulada de requisitos exigidos
	// en la oferta (almacenado en la variable total) y la suma de los requisitos los cuales 
	// cumple el usuario (almacenado en contador). Una vez obtenidos dichos valores, realizamos
	// una simple regla de 3 para obtener una puntuación sobre 10.
	
	private void idiomas() {
		Iterator<Boolean> itDemanda = dem.getIdiomas().iterator();
		Iterator<Boolean> itOferta = o.getIdiomas().iterator();
		boolean aux1, aux2;
		while(itOferta.hasNext()){
			aux1 = itOferta.next();
			aux2 = itDemanda.next();
			if(aux1==true){
				total = total+PONDERACION_IDIOMAS;
				if(aux2==true){
					contador = contador+PONDERACION_IDIOMAS;
				}
			}
		}
	}
	
	private void lenguajesProgramacion() {
		Iterator<Boolean> itDemanda = dem.getLenguajes().iterator();
		Iterator<Boolean> itOferta = o.getLenguajes().iterator();
		boolean aux1, aux2;
		while(itOferta.hasNext()){
			aux1 = itOferta.next();
			aux2 = itDemanda.next();
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
