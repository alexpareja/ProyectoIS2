package model;

import java.util.ArrayList;

public class ListaUsuarios {
	private ArrayList<Usuario> lista;
	private static Tienda tienda;
	
	public ListaUsuarios(Tienda tienda) {
		this.tienda = tienda;
		lista = new ArrayList<Usuario>();
	}
	
	public void anadirUsuario(Usuario s) {
		lista.add(s);
	}
	
	public void eliminarUsuario(Usuario s) {
		lista.remove(s);
	}
	
	public boolean buscarUsuario(String usuario) {
		for (Usuario s : lista)
			if (s.getUsuario() == usuario) return true;
		
		return false;
	}
}
