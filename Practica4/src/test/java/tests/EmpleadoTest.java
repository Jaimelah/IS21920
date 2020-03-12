package tests;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.*;

import modelo.Empleado;
import modelo.Empleado.Categoria;

public class EmpleadoTest {
	Empleado empleado;
	@Test
	public void testCalculoSueldoBruto() {
		//C1 {hoy}
		empleado=new Empleado(Categoria.DIRECTIVO, "Pepe", LocalDate.now(),true);
		assertTrue(empleado.sueldoBruto()==0.0);
		//C2 {hace 3 años}
		empleado=new Empleado(Categoria.GESTOR, "n", LocalDate.now().minusYears(3),false);
		assertTrue(empleado.sueldoBruto()==0.0);
		//C3 {hace 4.9 años}
		empleado=new Empleado(Categoria.OBRERO, "n", LocalDate.now().minusYears(5).plusDays(1),true);
		assertTrue(empleado.sueldoBruto()==0.0);
		//C4 {hace 5 años}
		empleado=new Empleado(Categoria.DIRECTIVO, "n", LocalDate.now().minusYears(5),false);
		assertTrue(empleado.sueldoBruto()==0.0);
		//C5 {hace 7 años}
		empleado=new Empleado(Categoria.GESTOR, "n", LocalDate.now().minusYears(7),true);
		assertTrue(empleado.sueldoBruto()==0.0);
		//C6 {hace 9.9 años}v
		empleado=new Empleado(Categoria.OBRERO, "n", LocalDate.now().minusYears(10).plusDays(1),false);
		assertTrue(empleado.sueldoBruto()==0.0);
		//C7 {hace 10 años}
		empleado=new Empleado(Categoria.GESTOR, "n", LocalDate.now().minusYears(10),true);
		assertTrue(empleado.sueldoBruto()==0.0);
		//C8 {hace 15 años}
		empleado=new Empleado(Categoria.DIRECTIVO, "n", LocalDate.now().minusYears(15),false);
		assertTrue(empleado.sueldoBruto()==0.0);
		//C9 {hace 19.9 años}
		empleado=new Empleado(Categoria.GESTOR, "n", LocalDate.now().minusYears(20).plusDays(1),true);
		assertTrue(empleado.sueldoBruto()==0.0);
		//C10 {hace 20 años}
		empleado=new Empleado(Categoria.GESTOR, "n", LocalDate.now().minusYears(20),false);
		assertTrue(empleado.sueldoBruto()==0.0);
		//C11 {hace 50 años}
		empleado=new Empleado(Categoria.GESTOR, "n", LocalDate.now().minusYears(50),true);
		assertTrue(empleado.sueldoBruto()==0.0);
		//C12
		try {
			empleado=new Empleado(Categoria.GESTOR, "n", LocalDate.now().plusDays(1), true);
		}catch(){

		}
		//C13
		try {
			empleado=new Empleado(Categoria.GESTOR, "n",null, true);
		}catch(){

		}
		//C14
		try {
			empleado=new Empleado(null, "n", LocalDate.now(), true);
		}catch(){

		}
		//C15
		//try {
		//	empleado=new Empleado(Categoria.PEPE, "n", LocalDate.now(), true);
		//}catch(){

		//}
		//C16
		//try {
		//	empleado=new Empleado(Categoria.GESTOR, "n", LocalDate.now(), );
		//}catch(NullPointerException e){

		//}

	}



}
