package modelo;

import java.time.LocalDate;

public class Empleado {

	public String nombre;
	public LocalDate fechaContratación;
	public boolean baja;
	public enum Categoria{DIRECTIVO,GESTOR,OBRERO};
	public Categoria categoriaEmpleado;
	@SuppressWarnings("serial")
	public class ErrorEnLaFecha extends Exception{};
	@SuppressWarnings("serial")
	public class ErrorCategoria extends Exception{};
	@SuppressWarnings("serial")
	public class ErrorBooleano extends Exception{};
	

	public Empleado(Categoria cat,String nombre, LocalDate date,boolean baja) {
		this.categoriaEmpleado=cat;
		this.nombre=nombre;
		this.fechaContratación=date;
		this.baja=baja;

	}
	public double sueldoBruto() throws ErrorBooleano, ErrorCategoria, ErrorEnLaFecha {
		double sueldoBase=0.0;
		switch(categoriaEmpleado) {

		case DIRECTIVO:
			sueldoBase=1500;
			if(fechaContratación.)
			break;

		case GESTOR:
			sueldoBase=1200;
			break;

		case OBRERO:
			sueldoBase=1000;
			break;
		default:
			System.out.println("ERROR");
		}

	}

	public boolean darDeAlta() {
		this.baja=false;
		return true;
	}
	public boolean darDeBaja() {
		this.baja=true;
		return true;
	}
}
