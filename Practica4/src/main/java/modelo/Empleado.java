package modelo;

import java.time.LocalDate;

public class Empleado {

	public String nombre;
	public LocalDate fechaContratación;
	public boolean baja;
	public enum Categoria{DIRECTIVO,GESTOR,OBRERO};
	public Categoria categoriaEmpleado;

	public Empleado(Categoria cat,String nombre, LocalDate date) {
		this.categoriaEmpleado=cat;
		this.nombre=nombre;
		this.fechaContratación=date;
		this.baja=false;

	}
	public double sueldoBruto() {
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
