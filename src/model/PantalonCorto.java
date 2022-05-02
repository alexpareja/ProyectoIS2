package model;

import javax.swing.ImageIcon;

public class PantalonCorto extends Pantalon {
	
	public static final String id = "PantCorto";

	public PantalonCorto(double precio, boolean activo, int stock, int udsvendidas, int reservados, String talla, int dorsal){
		super(id, precio, activo, stock, udsvendidas, reservados, talla, dorsal);
		this.foto= new ImageIcon( "resources/icons/pantaloncorto.png");
    
		if (talla == "" || talla == null) throw new IllegalArgumentException("[ERROR] Pantalon: talla no puede ser vacio");
		else this.talla = talla;
     
		if (dorsal < 0) throw new IllegalArgumentException("[ERROR] Pantalon: dorsal no puede ser negativo");
		else this.dorsal = dorsal;
	}

	public String[] mostrar() {
	    return super.mostrar();
	}

    public String mostrarEnCarrito() {
    	String s;
    	s = "\nProducto: Pantalon Corto\n" + super.mostrarEnCarrito();
    	return s;
    }
  
}
