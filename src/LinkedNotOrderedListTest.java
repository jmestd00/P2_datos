import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import org.junit.*;


public class LinkedNotOrderedListTest {
	private LinkedNotOrderedList<String> lista;
	
	@Before
	public void setUp() {
		 lista= new LinkedNotOrderedList<String>();
	}

	@Test
	public void LinkedVaciaTest() {
		assertEquals(0,lista.size());
	}
	
	// test addFirst comprueba que dispara excepción
	@Test(expected=NullPointerException.class)
	public void LinkedAddFirstElementoNuloTest() {
			lista.addFirst(null);
	}
	
	@Test
	public void LinkedAddFirstTest() {
		lista.addFirst("2");
		Assert.assertFalse(lista.isEmpty());
		Assert.assertEquals("(2 )", lista.toString());
		lista.addFirst("3");
		Assert.assertEquals("(3 2 )", lista.toString());
		lista.addFirst("7");
		Assert.assertEquals("(7 3 2 )", lista.toString());
	}
	

	//test de iteradores
	@Test
	public void LinkedIteratorTest() {
		lista.addFirst("2");
		Assert.assertFalse(lista.isEmpty());
		Assert.assertEquals("(2 )", lista.toString());
		lista.addFirst("3");
		Assert.assertEquals("(3 2 )", lista.toString());
		lista.addFirst("7");
		Assert.assertEquals("(7 3 2 )", lista.toString());
		Iterator<String>  iter=lista.iterator();
		assertTrue(iter.hasNext());
		assertEquals("7", iter.next());
		assertTrue(iter.hasNext());
		assertEquals("3", iter.next());
		assertTrue(iter.hasNext());
		assertEquals("2", iter.next());
		assertFalse(iter.hasNext());
	}
	
	@Test
	public void LinkedEvenIteratorNElemsParTest() {
		lista.addFirst("2");
		Assert.assertFalse(lista.isEmpty());
		Assert.assertEquals("(2 )", lista.toString());
		lista.addFirst("3");
		Assert.assertEquals("(3 2 )", lista.toString());
		lista.addFirst("7");
		Assert.assertEquals("(7 3 2 )", lista.toString());
		lista.addFirst("8");
		Assert.assertEquals("(8 7 3 2 )", lista.toString());

		Iterator<String>  iter=lista.evenPosIterator();
		assertTrue(iter.hasNext());
		assertEquals("7", iter.next());
		assertTrue(iter.hasNext());
		assertEquals("2", iter.next());
		assertFalse(iter.hasNext());
	}
	
	
	
	
	// TEST ITERADORES EN LISTA VACÍA
	@Test(expected=NoSuchElementException.class)
	public void LinkedNextListaVaciaTest() {
			lista.iterator().next();	}
	
	
	//TEST reverse
	@Test
	public void LinkedtestReverse() {
	
	lista.addFirst("6");
	Assert.assertFalse(lista.isEmpty());
	Assert.assertEquals("(6 )", lista.toString());
	lista.addFirst("5");
	Assert.assertEquals("(5 6 )", lista.toString());
	lista.addFirst("4");
	Assert.assertEquals("(4 5 6 )", lista.toString());
	lista.addFirst("4");
	Assert.assertEquals("(4 4 5 6 )", lista.toString());
	Assert.assertEquals("(6 5 4 4 )", lista.reverse().toString());
	Assert.assertEquals("(4 4 5 6 )", lista.toString()); // queda en el mismo estado
	
	}
}

		
				
