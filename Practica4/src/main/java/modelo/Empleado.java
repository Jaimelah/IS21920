package modelo;

import java.time.LocalDate;

public class Empleado {

	public String nombre;
	public LocalDate fechaContratación;
	public boolean baja;
	public enum Categoria{DIRECTIVO,GESTOR,OBRERO};
	public Categoria categoriaEmpleado;
	@SuppressWarnings("serial")
	public class DatoIncorrectoException extends Exception{};
	

	public Empleado(Categoria cat,String nombre, LocalDate date,boolean baja) {
		this.categoriaEmpleado=cat;
		this.nombre=nombre;
		this.fechaContratación=date;
		this.baja=baja;

	}
	public double sueldoBruto() throws DatoIncorrectoException{
		//Decisión 1 
		if(fechaContratación.isAfter(LocalDate.now()) || fechaContratación==null) {
			throw new DatoIncorrectoException();
		}
		double sueldo=0.0;
		switch(categoriaEmpleado) {
		case DIRECTIVO:
			sueldo=1500;
			break;
		case GESTOR:
			sueldo=1200;
			break;
		case OBRERO:
			sueldo=1000;
			break;
		}
		if(fechaContratación.isBefore(LocalDate.now().minusYears(5).plusDays(1))&&fechaContratación.isAfter(LocalDate.now().minusYears(10))) {
			sueldo+=50;
		}else if(fechaContratación.isBefore(LocalDate.now().minusYears(10).plusDays(1))&&fechaContratación.isAfter(LocalDate.now().minusYears(20))) {
			sueldo+=100;
		}else if(fechaContratación.isBefore(LocalDate.now().minusYears(20).plusDays(1))) {
			sueldo+=200;
		}
		if(baja) {
			sueldo*=0.75;
		}
		return sueldo;
	}
	public boolean darDeAlta() throws DatoIncorrectoException {
		if(!baja) {
			throw new DatoIncorrectoException();
		}
		baja=false;
		return true;
	}
	public boolean darDeBaja() throws DatoIncorrectoException {
		if(baja) {
			throw new DatoIncorrectoException();
		}
		baja=true;
		return true;
	}
}
