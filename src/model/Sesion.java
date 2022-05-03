package model;

import BBDD.DAOXMLUsuarios;
import BBDD.DTOUsuarios;

public class Sesion {

	private DAOXMLUsuarios dao;
	private Usuario userActual;
	protected UsuariosObserver observer;

	public Sesion() {
		userActual = new Usuario("Invitado", "", false, "invitado@ucm.es");
	}

//Iniciar sesion en el programa (mediante un usuario y contrasena)
	public boolean iniciaSesion(String n, String p) {
		dao = new DAOXMLUsuarios();
		DTOUsuarios dto = dao.cargarUsuario(n, p);
		if (dto != null) {
			userActual = new Usuario(dto.getUsuario(), dto.getContrasena(), dto.isDueno(), dto.getCorreo());
			observer.iniciaSesion(userActual);
			return true;
		} else
			return false;
	}

//Registrar nuevo usuario
	public void registrarse(String n, String p, String correo) {
		dao = new DAOXMLUsuarios();
		DTOUsuarios dto = new DTOUsuarios(n, p, false, correo);
		userActual = new Usuario(n, p, false, correo);
		dao.guardarUsuarios(dto);
		observer.iniciaSesion(userActual);
	}

//Registrar nuevo vendedor
	public void registrarseVendedor(String n, String p, String correo) {
		dao = new DAOXMLUsuarios();
		DTOUsuarios dto = new DTOUsuarios(n, p, true, correo);
		userActual = new Usuario(n, p, true, correo);
		dao.guardarUsuarios(dto);
		observer.iniciaSesion(userActual);
	}

	public boolean esDueno() {
		return userActual.esDueno();
	}

	public void addObserver(UsuariosObserver o) {
		observer = o;
		o.iniciaSesion(userActual);
	}

	public Usuario getUsuarioActual() {
		return userActual;
	}

}
