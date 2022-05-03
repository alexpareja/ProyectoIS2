package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.PantalonChandal;

class PantalonChandalTest {

	@Test
	void testMostrar() {
		PantalonChandal pc = new PantalonChandal(30.0, true, 20, 0, 0, "M", 3);
		String resultado[] = {
				"Dorsal:3",
				"Talla: M",
				"Precio: 30.0"
				};
		
		for(int i = 0; i < resultado.length; i++) {
			assertEquals(resultado[i], pc.mostrar()[i]);
		}
		
	}

	@Test
	void testMostrarEnInv() {
		PantalonChandal pc = new PantalonChandal(30.0, true, 20, 0, 0, "M", 3);
		String info = "Dorsal:" + "3 "  + "Talla: " + "M";
		String resultado[] = {
				"PantChandal", 
				info,
				"20",
				"30.0"
				};
		
		for(int i = 0; i < resultado.length; i++) {
			assertEquals(resultado[i], pc.mostrarEnInv()[i]);
		}
	}

	@Test
	void testMostrarEnCarrito() {
		PantalonChandal pc = new PantalonChandal(30.0, true, 20, 0, 0, "M", 3);
		String resultado = "Dorsal:3" + "\n" +  " Talla: M" + "\n";
		assertEquals(resultado, pc.mostrarEnCarrito());

	}

}
