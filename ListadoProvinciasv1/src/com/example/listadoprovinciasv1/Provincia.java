package com.example.listadoprovinciasv1;


public class Provincia {
	private int idImagen; 
	private String nombre; 
	private String capital;  
	private String url;
	  
	public Provincia (int idImagen, String nombre, String capital,String url) { 
	    this.idImagen = idImagen; 
	    this.nombre = nombre; 
	    this.capital = capital; 
	    this.url=url;
	}
	
	public String get_nombre() { 
	    return nombre; 
	}
	
	public String get_capital() { 
	    return capital; 
	}
	
	public int get_idImagen() {
	    return idImagen; 
	} 
	
	public String get_url(){
		return url;
	}
}
