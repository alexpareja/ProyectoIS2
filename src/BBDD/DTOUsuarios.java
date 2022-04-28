package BBDD;

public class DTOUsuarios {
	private String usuario;
    private String contrasena;
    private boolean dueno;
    private String correo;
    
    public DTOUsuarios() {
    	
    }
    
    public DTOUsuarios(String us,String pass, boolean d, String cor) {
    	this.contrasena=pass;
    	this.usuario=us;
    	this.dueno=d;
    	this.correo=cor;
    }
    
	public String getUsuario() {
		return usuario;
	}
	public String getContrasena() {
		return contrasena;
	}

	public boolean isDueno() {
		return dueno;
	}
	public String getCorreo() {
		return correo;
	}
}
