package principal;

import java.time.LocalDate;

import modelo.Empleado;
import modelo.Empleado.Categoria;

public class prueba {
	public static void main(String[]args) {
		Empleado em=new Empleado(Categoria.GESTOR, "--", LocalDate.now().plusMonths(1),true);
	}

}
