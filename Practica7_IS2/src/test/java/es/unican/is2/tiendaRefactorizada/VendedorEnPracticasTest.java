package es.unican.is2.tiendaRefactorizada;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class VendedorEnPracticasTest {
	
	private static Vendedor sut;

	@Before
	public void setUp(){
		sut = new Vendedor("Ana", "1",TipoVendedor.PRACTICAS);
	}
	
	@Test
	public void testConstructor() {
		assertEquals(sut.getId(), "1");
		assertEquals(sut.getNombre(), "Ana");
		assertTrue(sut.getTotalVentas()==0.0);
	}
	
	@Test
	public void testSetTotalVentas() {
		sut.setT(100);
		assertTrue(sut.getTotalVentas()==100.0);
		
		sut.setT(230);
		assertTrue(sut.getTotalVentas()==230.0);
		
		sut.setT(0);
		assertTrue(sut.getTotalVentas()==0.0);
	}

	@Test
	public void testAnhadeVenta() {
		sut.anhade(200);
		assertTrue(sut.getTotalVentas() == 200.0);
		
		sut.anhade(300);
		assertTrue(sut.getTotalVentas() == 500.0);	
		
		sut.anhade(0);
		assertTrue(sut.getTotalVentas() == 500.0);
		
		
	}
	
	@Test
	public void testEquals() {
		Vendedor igual = new Vendedor("Ana", "1", TipoVendedor.PRACTICAS);
		Vendedor distintoId = new Vendedor("Ana", "2",TipoVendedor.PRACTICAS);
		Vendedor distintoNombre = new Vendedor("Pepe", "1",TipoVendedor.PRACTICAS);
		Vendedor distintoTipo =new Vendedor("Ana","1", TipoVendedor.JUNIOR);
		Vendedor distinto = new Vendedor("Pepe", "6",TipoVendedor.JUNIOR);
		
		assertTrue(sut.equals(igual));
		assertFalse(sut.equals(distintoId));
		assertFalse(sut.equals(distintoNombre));
		assertFalse(sut.equals(distintoTipo));
		assertFalse(sut.equals(distinto));
	}
	
	
	
}
