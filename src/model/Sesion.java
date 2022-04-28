package model;

import BBDD.DAOXMLUsuarios;
import BBDD.DTOUsuarios;

public class Sesion {
	private DAOXMLUsuarios dao;
	private Usuario userActual;
	
	public Sesion() {
		userActual= new Usuario("invitado","",false,"invitado@ucm.es");
	}
	
	public boolean iniciaSesion(String n, String p) {
		this.dao=new DAOXMLUsuarios();
		DTOUsuarios dto=dao.cargarUsuario(n, p);
		if(dto!=null)
		{
			
		this.userActual=new Usuario(dto.getUsuario(),dto.getContrasena(),dto.isDueno(),dto.getCorreo());
		return true;
		}
		else {
			return false;
		}
		
		
	}
	
	public void registrarse(String n, String p, String correo) {
		this.dao=new DAOXMLUsuarios();
		DTOUsuarios dto=new DTOUsuarios(n,p,false,correo);
		this.userActual=new Usuario(n,p,false,correo);
		dao.guardarUsuarios(dto);
	}
	
	public void registrarseVendedor(String n, String p, String correo) {
		this.dao=new DAOXMLUsuarios();
		DTOUsuarios dto=new DTOUsuarios(n,p,true,correo);
		this.userActual=new Usuario(n,p,true,correo);
		dao.guardarUsuarios(dto);
	}
	
	public Usuario getUsuarioActual() {
		return this.userActual;
	}
	
	public boolean esDueno() {
		return userActual.esDueno();
	}
	public void setDueno() {
		 userActual.setDueno();
	}
}
