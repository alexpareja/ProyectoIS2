package BBDD;

public class DTOUsuarios {

	//en esta clase tenemos todos los atributos de los usuarios
	
	private String usuario;
	private String contrasena;
	private boolean dueno;
	private String correo;

	public DTOUsuarios() {

	}

	public DTOUsuarios(String us, String pass, boolean d, String cor) {
		this.contrasena = pass;
		this.usuario = us;
		this.dueno = d;
		this.correo = cor;
	}

	public boolean isDueno() {
		return dueno;
	}

	public String getCorreo() {
		return correo;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

}
