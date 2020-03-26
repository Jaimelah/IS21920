package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import es.unican.is2.listaOrdenadaAcotada.ListaOrdenadaAcotada;

public class TestLista {

	@Test
	public void testListaOrdenada() {
		ListaOrdenadaAcotada<Integer> lista;
		lista=new ListaOrdenadaAcotada<Integer>(3);
		//Con 0 elementos
		//Prueba con get 0 elementos
		assertTrue(lista.get(0)==null);
		try {
			lista.remove(0);
		}catch(IndexOutOfBoundsException e) {
			
		}
		//Prueba size 1
		assertTrue(lista.size()==0);
		//Prueba clear
		lista.clear();
		assertTrue(lista.size()==0);
		
		lista.add(1);
		assertTrue(lista.size()==1);
		lista.add(2);
		lista.add(3);
		assertTrue(lista.size()==3);
		try {
			lista.add(4);
			fail("No salta la excepcion de add");
		}catch(IllegalStateException e) {
			
		}
		assertTrue(lista.get(0)==1);
		assertTrue(lista.get(1)==2);
		assertTrue(lista.get(2)==3);
		lista.remove(2);
		assertTrue(lista.size()==2);
		lista.clear();
	}

}
