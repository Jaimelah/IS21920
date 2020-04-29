package tests;

import static org.junit.Assert.assertTrue;


import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.*;

import modelo.Empleado;
import modelo.Empleado.Categoria;
import modelo.Empleado.DatoIncorrectoException;

public class EmpleadoTest {
	Empleado empleado;
	@Test
	public void testCalculoSueldoBruto() throws DatoIncorrectoException {
		//C1 {hoy}
		System.out.println("Test empleado 1");
		empleado=new Empleado(Categoria.DIRECTIVO, "Pepe", LocalDate.now(),true);
		assertTrue(empleado.sueldoBruto()==1125.0);
		
		//C2 {hace 3 años}
		System.out.println("Test empleado 2");
		empleado=new Empleado(Categoria.GESTOR, "n", LocalDate.now().minusYears(3),false);
		assertTrue(empleado.sueldoBruto()==1200.0);
		
		//C3 {hace 4.9 años}
		System.out.println("Test empleado 3");
		empleado=new Empleado(Categoria.OBRERO, "n", LocalDate.now().minusYears(5).plusDays(1),true);
		assertTrue(empleado.sueldoBruto()==750.0);
		
		//C4 {hace 5 años}
		System.out.println("Test empleado 4");
		empleado=new Empleado(Categoria.DIRECTIVO, "n", LocalDate.now().minusYears(5),false);
		assertTrue(empleado.sueldoBruto()==1550.0);
		
		//C5 {hace 7 años}
		System.out.println("Test empleado 5");
		empleado=new Empleado(Categoria.GESTOR, "n", LocalDate.now().minusYears(7),true);
		assertTrue(empleado.sueldoBruto()==937.5);
		
		//C6 {hace 9.9 años}
		System.out.println("Test empleado 6");
		empleado=new Empleado(Categoria.OBRERO, "n", LocalDate.now().minusYears(10).plusDays(1),false);
		assertTrue(empleado.sueldoBruto()==1050.0);
		
		//C7 {hace 10 años}
		System.out.println("Test empleado 7");
		empleado=new Empleado(Categoria.GESTOR, "n", LocalDate.now().minusYears(10),true);
		assertTrue(empleado.sueldoBruto()==975.0);
		
		//C8 {hace 15 años}
		System.out.println("Test empleado 8");
		empleado=new Empleado(Categoria.DIRECTIVO, "n", LocalDate.now().minusYears(15),false);
		assertTrue(empleado.sueldoBruto()==1600.0);
		
		//C9 {hace 19.9 años}
		System.out.println("Test empleado 9");
		empleado=new Empleado(Categoria.GESTOR, "n", LocalDate.now().minusYears(20).plusDays(1),true);
		assertTrue(empleado.sueldoBruto()==975.0);
		
		//C10 {hace 20 años}
		System.out.println("Test empleado 10");
		empleado=new Empleado(Categoria.GESTOR, "n", LocalDate.now().minusYears(20),false);
		assertTrue(empleado.sueldoBruto()==1400.0);
		
		//C11 {hace 50 años}
		System.out.println("Test empleado 11");
		empleado=new Empleado(Categoria.GESTOR, "n", LocalDate.now().minusYears(50),true);
		assertTrue(empleado.sueldoBruto()==1050.0);
		
		//C12
		System.out.println("Test empleado 12");
		try {
			empleado=new Empleado(Categoria.GESTOR, "n", LocalDate.now().plusDays(1), true);
			empleado.sueldoBruto();
			fail("Error prueba 12");
			}catch(DatoIncorrectoException e){}
		
		//C13
		System.out.println("Test empleado 13");
		try {
			empleado=new Empleado(Categoria.GESTOR, "n",null, true);
			empleado.sueldoBruto();
			fail("Error prueba 13");
		}catch(NullPointerException e) {
		}catch(DatoIncorrectoException e) {
		}
		
		//C14
		System.out.println("Test empleado 14");
		try {
			empleado=new Empleado(null, "n", LocalDate.now(), true);
			empleado.sueldoBruto();
			fail("Error prueba 14");
		}catch(NullPointerException e) {	
		}catch (DatoIncorrectoException e) {
		}
		//C15
		//try {
		//	empleado=new Empleado(Categoria.PEPE, "n", LocalDate.now(), true);
		//}catch(){
 

		//}
		//C16
		//try {
		//	empleado=new Empleado(Categoria.GESTOR, "n", LocalDate.now(), nullwo);
		//}catch(NullPointerException e){

		//}

	}
	@Test
	public void testDarDeAlta() throws DatoIncorrectoException {
		//1
		System.out.println("Test darDeAlta 1");
		empleado=new Empleado(Categoria.DIRECTIVO,"n",LocalDate.now(),true);
		empleado.darDeAlta();
		assertTrue(empleado.baja==false);
		
		//2
		System.out.println("Test darDeAlta 2");
		try {
			empleado=new Empleado(Categoria.DIRECTIVO, "n", LocalDate.now().minusDays(10), false);
			empleado.darDeAlta();
			fail("Error prueba darDeAlta 2");
		} catch (DatoIncorrectoException e) {
		}
	}

	@Test
	public void testDarDeBaja() throws DatoIncorrectoException {
		//1
		System.out.println("Test darDeBaja 1");
		empleado=new Empleado(Categoria.DIRECTIVO,"n",LocalDate.now(),false);
		empleado.darDeBaja();
		assertTrue(empleado.baja);
		
		//2
		System.out.println("Test darDeBaja 2");
		try {
			empleado=new Empleado(Categoria.DIRECTIVO, "n", LocalDate.now().minusDays(10), true);
			empleado.darDeBaja();
			fail("Error prueba darDeBaja 2");
		} catch (DatoIncorrectoException e) {
			// TODO: handle exception
		}
	}


}
