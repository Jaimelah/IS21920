package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import modelo.ListaOrdenadaAcotada;


public class TestLista {
	ListaOrdenadaAcotada<Integer>lista;

	@Test
	public void testListaOrdenada() {
		lista=new ListaOrdenadaAcotada<Integer>(3);
		
		lista.add(4);
		printaListaEntera(lista);
		lista.add(3);
		printaListaEntera(lista);
		lista.add(5);
		printaListaEntera(lista);
		lista.remove(0);
		printaListaEntera(lista);
		lista.remove(1);
		printaListaEntera(lista);
		lista.remove(0);
		printaListaEntera(lista);
		
		
		//1 Add {}
		System.out.println("Test lista 1");
		lista=new ListaOrdenadaAcotada<Integer>(3);
		lista.add(1);
		printaListaEntera(lista);
		assertTrue(lista.get(0)==1);
		
		//2 (Añadiendo un elemento mayor, con 1 elemento ya en la lista)
		System.out.println("Test lista 2");
		lista=new ListaOrdenadaAcotada<Integer>(3);
		lista.add(1);
		lista.add(2);
		printaListaEntera(lista);
		assertTrue(lista.get(0)==1 &&lista.get(1)==2);
		
		//3 ERROR (Añadiendo un elemento menor, con un elemento ya en la lista)
		System.out.println("Test lista 3");
		lista=new ListaOrdenadaAcotada<Integer>(3);
		lista.add(1);
		lista.add(0);
		printaListaEntera(lista);
		assertTrue(lista.get(0)==0 && lista.get(1)==1);
		
		//4
		System.out.println("Test lista 4");
		lista=new ListaOrdenadaAcotada<Integer>(3);
		System.out.println(lista.get(0));
		assertTrue(lista.get(0)==null);
		
		//5
		System.out.println("Test lista 5");
		lista=new ListaOrdenadaAcotada<Integer>(3);
		lista.add(0);
		System.out.println(lista.get(0));
		assertTrue(lista.get(0)==0);
		
		//6
		System.out.println("Test lista 6");
		lista=new ListaOrdenadaAcotada<Integer>(3);
		lista.add(0);
		System.out.println(lista.get(0));
		lista.add(1);
		System.out.println(lista.get(1));
		lista.add(2);
		System.out.println(lista.get(2));
		assertTrue(lista.get(0)==0 &&lista.get(1)==1 && lista.get(2)==2);
		
		//7
		System.out.println("Test lista 7");
		lista=new ListaOrdenadaAcotada<Integer>(3);
		System.out.println(lista.size());
		assertTrue(lista.size()==0);
		
		//8
		System.out.println("Test lista 8");
		lista=new ListaOrdenadaAcotada<Integer>(3);
		lista.add(0);
		System.out.println(lista.size());
		assertTrue(lista.size()==1);
		
		//9
		System.out.println("Test lista 9");
		lista=new ListaOrdenadaAcotada<Integer>(3);
		lista.add(0);
		lista.add(1);
		lista.add(2);
		System.out.println(lista.size());
		assertTrue(lista.size()==3);
		
		//10
		System.out.println("Test lista 10");
		lista=new ListaOrdenadaAcotada<Integer>(3);
		lista.add(0);
		lista.remove(0);
		assertTrue(lista.size()==0);
		
		//11
		System.out.println("Test lista 11");
		lista=new ListaOrdenadaAcotada<Integer>(3);
		lista.add(1);
		lista.add(2);
		lista.remove(0);
		System.out.println(lista.size());
		lista.remove(0);
		System.out.println(lista.size());
		assertTrue(lista.size()==0);
		
		//12
		System.out.println("Test lista 12");
		lista=new ListaOrdenadaAcotada<Integer>(3);
		printaListaEntera(lista);
		lista.clear();
		printaListaEntera(lista);
		assertTrue(lista.size()==0);
		
		
		//13
		System.out.println("Test lista 13");
		lista=new ListaOrdenadaAcotada<Integer>(3);
		lista.add(0);
		lista.add(1);
		lista.add(2);
		printaListaEntera(lista);
		lista.clear();
		printaListaEntera(lista);
		assertTrue(lista.size()==0  &&lista.get(0)==null && lista.get(1)==null && lista.get(2)==null);
		//14
		System.out.println("Test lista 14");
		try {
			lista=new ListaOrdenadaAcotada<Integer>(3);
			lista.add(null);
			fail("Error prueba 4");
		}catch(NullPointerException e) {}
				
		
		//15
		System.out.println("Test lista 15");
		lista=new ListaOrdenadaAcotada<Integer>(3);
		lista.add(1);
		lista.add(2);
		lista.add(3);
		try {
			lista.add(4);
			fail("ERROR en prueba 15");
		}catch(IllegalStateException e) {}
		
		//16
		System.out.println("Test lista 16");
		lista=new ListaOrdenadaAcotada<Integer>(3);
		lista.add(0);
		lista.add(1);
		lista.add(2);
		try {
			lista.get(-1);
			fail("Error en prueba 16");
		}catch(IndexOutOfBoundsException e) {
		}
		
		//17
		System.out.println("Test lista 17");
		lista=new ListaOrdenadaAcotada<Integer>(3);
		try {
			lista.remove(0);
			fail("Error prueba 17");
		}catch(IndexOutOfBoundsException e) {
			
		}
		//18
		System.out.println("Test lista 18");
		lista=new ListaOrdenadaAcotada<Integer>();
		System.out.println(lista.size());
		for(int i=0;i<ListaOrdenadaAcotada.MAX_POR_OMISION;i++) {
			lista.add(i);
		}
		assertTrue(lista.size()==10);
		//19
		System.out.println("Test lista 1");
		try {
			lista.add(11);
			fail("Error prueba 19");
		}catch(IllegalStateException e) {}
	}	

	public void printaListaEntera(ListaOrdenadaAcotada<Integer> lista) {
		String resultado="[ ";
		for(int i=0; i<lista.size();i++) {
			resultado=resultado+lista.get(i)+" ";
		}
		resultado=resultado+"]";
		System.out.println(resultado);
	}
}
