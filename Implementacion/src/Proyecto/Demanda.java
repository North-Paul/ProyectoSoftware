package Proyecto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demanda {

	private static Demanda dem;
	private int id;
	private String nombre;
	
	private int anyoExperiencia=0;
	private List<Boolean> lenguajesP = new ArrayList<Boolean>();
	private List<Boolean> idiomas = new ArrayList<Boolean>();
	
	private Demanda (int id, String nom) {
		this.id = id;
		nombre = nom;
		System.out.println("El usuario "+nombre+" ha emitido una nueva demanda, cuyo id es "+id);
	}
	
	public static Demanda crearDemanda (int id, String nom){
		if(dem == null){
			dem = new Demanda(id, nom);
		}
		return dem;
	}
	public int getId (){
		return id;
	}
	public void setExperiencia ( int experiencia) throws Exception{
		if(experiencia >= 0){
			anyoExperiencia = experiencia;
		}else{
			throw new Exception ("Experiencia "+experiencia+" incorrecta");
		}
	}
	public int getExperiencia (){
		return anyoExperiencia;
	}
	public void setLenguajes (List<Boolean> l){
		Iterator<Boolean> it = l.iterator();
		boolean aux1;
		while(it.hasNext()){
			aux1=it.next();
			lenguajesP.add(aux1);
		}
	}
	public List<Boolean> getLenguajes (){
		return lenguajesP;
	}
	public void setIdiomas (List<Boolean> l){
		Iterator<Boolean> it = l.iterator();
		boolean aux1;
		while(it.hasNext()){
			aux1=it.next();
			idiomas.add(aux1);
		}
	}
	public List<Boolean> getIdiomas (){
		return idiomas;
	}
}
