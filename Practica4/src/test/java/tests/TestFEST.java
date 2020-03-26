package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Empleado.Categoria;
import principal.EmpleadosGUI;

import org.fest.swing.fixture.FrameFixture;
public class TestFEST {
	private String[] listaFechas= 
		{LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
		 LocalDate.now().minusYears(3).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
		 LocalDate.now().minusYears(5).plusDays(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
		 LocalDate.now().minusYears(5).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
		 LocalDate.now().minusYears(7).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
		 LocalDate.now().minusYears(10).plusDays(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
		 LocalDate.now().minusYears(10).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
		 LocalDate.now().minusYears(15).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
		 LocalDate.now().minusYears(20).plusDays(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
		 LocalDate.now().minusYears(20).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
		 LocalDate.now().minusYears(50).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))};
	private Categoria[] listaCategorias=
		{Categoria.DIRECTIVO,
		 Categoria.GESTOR,
		 Categoria.OBRERO,
		 Categoria.DIRECTIVO,
		 Categoria.GESTOR,
		 Categoria.OBRERO,
		 Categoria.GESTOR,
		 Categoria.DIRECTIVO,
		 Categoria.GESTOR,
		 Categoria.GESTOR,
		 Categoria.GESTOR}; 
	private boolean[] listaBajas= 
		{true,false,true,false,true,false,true,false,true,false,true};
	private String[] resultados=
		{"1125.0","1200.0","750.0","1550.0","937.5","1050.0","975.0","1600.0","975.0","1400.0","1050.0"};
	private FrameFixture demo;
	@Before
	public void setUp() {
		EmpleadosGUI gui =new EmpleadosGUI();
		demo=new FrameFixture(gui);
		gui.setVisible(true);
	}
	@After
	public void tearDown() {
		demo.cleanUp();
	}
	@Test
	public void test() {
		
		demo.textBox("txtFechaContratacion").requireText("dd-mm-yyyy");
		demo.button("btnCalcular").requireText("CALCULAR");
		//Tests de caja negra
		for(int i=0;i<listaFechas.length;i++) {
			demo.textBox("txtFechaContratacion").deleteText();
			demo.textBox("txtFechaContratacion").enterText(listaFechas[i]);
			if(listaBajas[i]) {
				demo.radioButton("btnBaja").click();
			}
			demo.comboBox().selectItem(listaCategorias[i].toString());
			demo.button("btnCalcular").click();
			demo.textBox("txtSueldo").requireText(resultados[i]);
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			if(listaBajas[i]) {
				demo.radioButton("btnBaja").click();
			}
		}
	}

}
