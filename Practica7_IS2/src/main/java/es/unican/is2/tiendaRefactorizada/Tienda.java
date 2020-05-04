package es.unican.is2.tiendaRefactorizada;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase que representa una tienda con un conjunto de vendedores y que permite
 * llevar la gestión de las ventas realizadas y las comisiones asignadas a cada
 * vendedor. Los datos de la tienda se almacenan en un fichero de texto
 * que se pasa como parámetro al crear la tienda
 */
public class Tienda {

	private LinkedList<Vendedor> lista = new LinkedList<Vendedor>();
	private String direccion;
	private String nombre;

	private String datos;

	/**
	 * Crea la tienda cargando los datos desde el fichero indicado
	 * 
	 * @param datos Path absoluto del fichero de datos
	 */
	public Tienda(String datos) {//WMC+1
		this.datos = datos;
	}

	/**
	 * Retorna la dirección de la tienda
	 * @return Dirección de la tienda
	 */
	public String direccion() {//WMC+1
		return direccion;
	}

	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 */
	public String nombre() {//WMC+1
		return nombre;
	}

	/**
	 * Añade un nuevo vendedor a la tienda
	 * 
	 * @param nuevoVendedor
	 * @return true si el vendedor se ha anhadido 
	 *         false si ya había un vendedor con el mismo id
	 */
	public boolean anhade(Vendedor nuevoVendedor) throws IOException {//WMC+1
		Vendedor v = buscaVendedor(nuevoVendedor.getId());
		if (v != null) {//WMC+1
			return false;
		}
		lista.add(nuevoVendedor);
		vuelcaDatos();
		return true;
	}

	/**
	 * Elimina el vendedor cuyo dni se pasa como parámetro
	 * 
	 * @param id
	 * @return true si se elimina el vendedor 
	 *         false si no existe ningún vendedor con el id indicado
	 */
	public boolean eliminaVendedor(String id) throws IOException {//WMC+1
		Vendedor v = buscaVendedor(id);
		if (v == null) {//WMC+1
			return false;
		}
		lista.remove(v);
		vuelcaDatos();
		return true;
	}

	/**
	 * Añade una venta a un vendedor
	 * 
	 * @param id
	 *            Id del vendedor
	 * @param importe
	 *            Importe de la venta
	 * @return true si se añade la venta false si no se encuentra el vendedor
	 */
	public boolean anhadeVenta(String id, double importe) throws IOException {//WMC+1
		Vendedor v = buscaVendedor(id);
		if (v == null) {//WMC+1 CCog+1
			return false;
		}
		double importeFinal = importe;//WMC+1 CCog+1
		switch (v.tipo()) {//WMC+2 CCog+2
		case JUNIOR:
			importeFinal += importeFinal * 0.005;
			break;
		case SENIOR:
			importeFinal += importeFinal * 0.01;
			break;
		case PRACTICAS:
			break;				
		}
		v.anhade(importeFinal);
		vuelcaDatos();
		return true;
	}

	private void leeVendedores(LinkedList<Vendedor> lista, Scanner in, String tipo, TipoVendedor t) {
		Vendedor ven = null;
		while (in.hasNext() && !in.next().equals(tipo)) {//WMC+2  CCog+1
			String nombre = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			double totalVentas = in.nextDouble();
			ven = new Vendedor(nombre, idIn, t);
			ven.setT(totalVentas);
			lista.add(ven);
		}
	}

	/**
	 * Retorna el vendedor con el id indicado
	 * 
	 * @param id
	 *            Id del vendedor
	 * @return vendedor con ese id o null si no existe ninguno
	 */
	public Vendedor buscaVendedor(String id) {//WMC+1

		lista = new LinkedList<Vendedor>();
		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de números
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			// lee los vendedores senior
			leeVendedores(lista, in, "Junior", TipoVendedor.SENIOR);
			leeVendedores(lista, in, "Prácticas",TipoVendedor.JUNIOR);
			leeVendedores(lista, in, null,TipoVendedor.PRACTICAS);
		} catch (FileNotFoundException e) {//WMC+1 CCog+1
		} finally {
			if (in != null) {//WMC+1 CCog+1
				in.close();
			}
		} // try

		for (Vendedor v : lista) {//WMC+1 CCog+1
			if (v.getId().equals(id)) {//WMC+1 CCog+2
				return v;
			}
		}
		return null;
	}

	/**
	 * Retorna la lista de vendedores actuales de la tienda
	 * 
	 * @return La lista de vendedores
	 */
	public List<Vendedor> vendedores() {//WMC+1
		lista = new LinkedList<Vendedor>();

		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de números
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			// lee los vendedores senior
			leeVendedores(lista, in, "Junior", TipoVendedor.SENIOR);
			leeVendedores(lista, in, "Prácticas",TipoVendedor.JUNIOR);
			leeVendedores(lista, in, null,TipoVendedor.PRACTICAS);

		} catch (FileNotFoundException e) {//WMC+1 CCog+1

		} finally {
			if (in != null) {//WMC+1 CCog+1
				in.close();
			}
		} // try

		return lista;

	}

	/**
	 * Método que genera el fichero datosTienda.txt con los datos actualizados de
	 * los vendedores
	 */
	private void vuelcaDatos() throws IOException {//WMC+1
		PrintWriter out = null;
		List<Vendedor> senior = new LinkedList<Vendedor>();
		List<Vendedor> junior = new LinkedList<Vendedor>();
		List<Vendedor> practicas = new LinkedList<Vendedor>();

		for (Vendedor v : lista) {//WMC+1 CCog+1
			switch(v.tipo()) {
			case JUNIOR:
				junior.add(v);
				break;
			case PRACTICAS:
				practicas.add(v);
				break;
			case SENIOR:
				senior.add(v);
				break;

			}
			try {
				out = new PrintWriter(new FileWriter(datos));
				parseWorkers(out, senior, "    Senior");
				parseWorkers(out, junior, "    Junior");
				parseWorkers(out, practicas, "    Practicas");
			} finally {
				if (out != null)//WMC+1 CCog+1
					out.close();
			}
		}
	}
		private void parseWorkers(PrintWriter out, List<Vendedor> lista, String tipo) {
			out.println(tipo);
			for (Vendedor v : lista)//WMC+1 CCog+1
				out.println("      Nombre: " + v.getNombre() + "   Id: " + v.getId() + "   TotalVentasMes: "
						+ v.getTotalVentas());
			out.println();

		}

	}
