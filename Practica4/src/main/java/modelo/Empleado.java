package modelo;

import java.time.LocalDate;

public class Empleado {

	public String nombre;
	public LocalDate fechaContrataci�n;
	public boolean baja;
	public enum Categoria{DIRECTIVO,GESTOR,OBRERO};
	public Categoria categoriaEmpleado;
	@SuppressWarnings("serial")
	public class ErrorEnLaFecha extends Exception{};
	@SuppressWarnings("serial")
	public class ErrorBaja extends Exception{};
	

	public Empleado(Categoria cat,String nombre, LocalDate date,boolean baja) {
		this.categoriaEmpleado=cat;
		this.nombre=nombre;
		this.fechaContrataci�n=date;
		this.baja=baja;

	}
	public double sueldoBruto() throws ErrorBaja, ErrorEnLaFecha {
		if(fechaContrataci�n.isAfter(LocalDate.now()) || fechaContrataci�n==null) {
			System.out.println("1");
			throw new ErrorEnLaFecha();
		}
		double sueldo=0.0;
		switch(categoriaEmpleado) {
		case DIRECTIVO:
			System.out.println("4");
			sueldo=1500;
			break;
		case GESTOR:
			System.out.println("5");
			sueldo=1200;
			break;
		case OBRERO:
			System.out.println("6");
			sueldo=1000;
			break;
		}
		if(fechaContrataci�n.isBefore(LocalDate.now().minusYears(5).plusDays(1))&&fechaContrataci�n.isAfter(LocalDate.now().minusYears(10))) {
			System.out.println("7");
			sueldo+=50;
		}else if(fechaContrataci�n.isBefore(LocalDate.now().minusYears(10).plusDays(1))&&fechaContrataci�n.isAfter(LocalDate.now().minusYears(20))) {
			System.out.println("8");
			sueldo+=100;
		}else if(fechaContrataci�n.isBefore(LocalDate.now().minusYears(20).plusDays(1))) {
			System.out.println("9");
			sueldo+=200;
		}
		if(baja) {
			System.out.println("10");
			sueldo*=0.75;
		}
		return sueldo;
	}
	public boolean darDeAlta() throws ErrorBaja {
		if(baja!=true) {
			throw new ErrorBaja();
		}
		baja=false;
		return true;
	}
	public boolean darDeBaja() throws ErrorBaja {
		if(baja!=false) {
			throw new ErrorBaja();
		}
		baja=true;
		return true;
	}
}
