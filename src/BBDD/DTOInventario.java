package BBDD;

public class DTOInventario {

	// dao debe devolver array de dtos, y en inventario creacion de clases con
	// switch y el array de dtos
	protected String id;
	protected double precio;
	protected boolean activo;
	protected int stock;
	protected int udsvendidas;
	protected int reservados;
	protected int tallaZ;
	protected String modelo;
	protected String marca;
	protected String color;
	protected int adherencia;
	protected String talla;
	protected String nombre;
	protected int dorsal;

	public DTOInventario(String id, double precio, boolean activo, int stock, int udsvendidas, int reservados,
			String talla, String nombre, int dorsal) {
		this.id = id;
		this.precio = precio;
		this.activo = activo;
		this.stock = stock;
		this.udsvendidas = udsvendidas;
		this.reservados = reservados;
		this.talla = talla;
		this.nombre = nombre;
		this.dorsal = dorsal;
	}

	public DTOInventario(String id, double precio, boolean activo, int stock, int udsvendidas, int reservados,
			String talla, int dorsal) {
		this.id = id;
		this.precio = precio;
		this.activo = activo;
		this.stock = stock;
		this.udsvendidas = udsvendidas;
		this.reservados = reservados;
		this.talla = talla;
		this.dorsal = dorsal;
	}

	public DTOInventario(String id, double precio, boolean activo, int stock, int udsvendidas, int reservados,
			int talla, String modelo, String marca, String color) {
		this.id = id;
		this.precio = precio;
		this.activo = activo;
		this.stock = stock;
		this.udsvendidas = udsvendidas;
		this.reservados = reservados;
		this.tallaZ = talla;
		this.modelo = modelo;
		this.marca = marca;
		this.color = color;
	}

	public DTOInventario(String id, double precio, boolean activo, int stock, int udsvendidas, int reservados,
			String talla, String modelo, String marca, String color, int adherencia) {
		this.id = id;
		this.precio = precio;
		this.activo = activo;
		this.stock = stock;
		this.udsvendidas = udsvendidas;
		this.reservados = reservados;
		this.talla = talla;
		this.modelo = modelo;
		this.marca = marca;
		this.color = color;
		this.adherencia = adherencia;
	}

	public String getId() {
		return id;
	}

	public double getPrecio() {
		return precio;
	}

	public boolean isActivo() {
		return activo;
	}

	public int getStock() {
		return stock;
	}

	public int getUdsvendidas() {
		return udsvendidas;
	}

	public int getReservados() {
		return reservados;
	}

	public int getTallaZ() {
		return tallaZ;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

	public String getColor() {
		return color;
	}

	public int getAdherencia() {
		return adherencia;
	}

	public String getTalla() {
		return talla;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDorsal() {
		return dorsal;
	}

}
