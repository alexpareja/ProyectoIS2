package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BotasTest {

	@Test
	void testMostrar() {
		Botas b = new Botas(30, true, 20, 0, 0, 35, "Fake", "Nike", "Verde");
		String resultado[] = {
				"Marca: " + "Nike", 
				"Modelo:" + "Fake", 
				"Talla: " + 35, 
				"Color: " + "Verde",
				"Precio: " + 30.0};
		
		for(int i = 0; i < resultado.length; i++) {
			assertEquals(resultado[i], b.mostrar()[i]);
		}
		
	}

	@Test
	void testMostrarEnInv() {
		Botas b = new Botas(30, true, 20, 0, 0, 35, "Fake", "Nike", "Verde");
		String info = "Marca:" + "Nike"  + "Modelo: " + "Fake" + "Talla:" + 35 + "Color: " + "Verde";
		String resultado[] = {
				"Botas", 
				info, 
				"20",
				"30.0" 
				};
		
		for(int i = 0; i < resultado.length; i++) {
			assertEquals(resultado[i], b.mostrarEnInv()[i]);
		}
	}

	@Test
	void testMostrarEnCarrito() {
		Botas b = new Botas(30, true, 20, 0, 0, 35, "Fake", "Nike", "Verde");
		String resultado = "Marca: " + "Nike" + 
				" " + " Modelo: " + "Fake" +
				" " + " Talla:" + 35 + " " 
				+ " Color: "+ "Verde";
			
				;
		
			assertEquals(resultado, b.mostrarEnCarrito());

	}

}
