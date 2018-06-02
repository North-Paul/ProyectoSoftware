package Proyecto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Usuario {

	private static Usuario u;
	private int id;
	private String nombre;
	
	private int anyoExperiencia=0;
	private List<Boolean> lenguajesP = new ArrayList<Boolean>();
	private List<Boolean> idiomas = new ArrayList<Boolean>();
	
	private Usuario (int id, String nom) {
		this.id = id;
		nombre = nom;
		System.out.println("Al usuario "+nombre+" se le ha asignado el id "+id);
	}
	
	public static Usuario crearUsuario (int id, String nom){
		if(u == null){
			u = new Usuario(id, nom);
		}
		return u;
	}
	public int getId (){
		return id;
	}
	public void setExperiencia ( int experiencia){
		anyoExperiencia = experiencia;
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