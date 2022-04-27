package model;

import java.util.ArrayList;

import BBDD.DAOXMLUsuarios;

public class ListaUsuarios {
	private ArrayList<Usuario> lista;
	private DAOXMLUsuarios dao;
	
	
	public ListaUsuarios() {
		lista = new ArrayList<Usuario>();
		this.dao=new DAOXMLUsuarios();
	}
	
	public void anadirUsuario(Usuario s) {
		lista.add(s);
		
	}
	
	
	public boolean buscarUsuario(String usuario) {
		for (Usuario s : lista)
			if (s.getUsuario() == usuario) return true;
		
		return false;
	}
}
