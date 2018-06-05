package Proyecto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Oferta {

	private static Oferta oferta;
	private int id;
	private String nOferta;
	
	private int anyoExperiencia=0;
	private List<Boolean> lenguajesP = new ArrayList<Boolean>();
	private List<Boolean> idiomas = new ArrayList<Boolean>();
	
	private Oferta (int id, String nombre) {
		this.id = id;
		nOferta = nombre;
		System.out.println("A la oferta ->"+nOferta+"<- se le ha asignado el id: "+this.id);
	}
	
	public static Oferta crearOferta (int id, String nombre){
		if(oferta == null){
			oferta = new Oferta(id, nombre);
		}
		return oferta;
	}
	public String getNombre (){
		return nOferta;
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
