import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;


public class LinkedNotOrderedListTest {
	private LinkedNotOrderedList<String> listaVacia;
	private LinkedNotOrderedList<String> listaCompleta;

	@Before
	public void setUp() {
		 listaVacia = new LinkedNotOrderedList<String>();
		 listaCompleta = new LinkedNotOrderedList<String>();

		 listaCompleta.addFirst("2");
		 listaCompleta.addFirst("5");
		 listaCompleta.addFirst("5");
		 listaCompleta.addFirst("6");
		 listaCompleta.addFirst("5");
		 listaCompleta.addFirst("7");
		 listaCompleta.addFirst("4");
		 listaCompleta.addFirst("1");
		 listaCompleta.addFirst("5");
		 listaCompleta.addFirst("8");
	}

	@Test
	public void LinkedVaciaTest() {
		assertEquals(0,listaVacia.size());
	}
	
	//add
	@Test(expected=NullPointerException.class)
	public void LinkedAddFirstElementoNuloTest() {
		listaVacia.addFirst(null);
	}

	@Test(expected = NullPointerException.class)
	public void addNullTest() {
		listaVacia.addPos(null, 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addIllegalTest() {
		listaVacia.addPos("3", -4);
	}

	@Test
	public void addTest() {
		listaVacia.addFirst("2");
		listaVacia.addFirst("4");
		assertEquals("(4 2 )", listaVacia.toString());

		listaVacia.addLast("8");
		assertEquals("(4 2 8 )", listaVacia.toString());

		listaVacia.addPenult("6");
		assertEquals("(4 2 6 8 )", listaVacia.toString());

		listaVacia.addPos("1", 2);
		listaVacia.addPos("3", 15);
		assertEquals("(4 1 2 6 8 3 )", listaVacia.toString());

		listaVacia.addPos("0", 5);
		assertEquals("(4 1 2 6 0 8 3 )", listaVacia.toString());
	}

	//Remove
	@Test
	public void removeTest() throws EmptyCollectionException {
		//8 5 1 4 7 5 6 5 5 2
		assertEquals("8", listaCompleta.removeFirst());
		assertEquals("(5 1 4 7 5 6 5 5 2 )", listaCompleta.toString());

		assertEquals("2", listaCompleta.removelast());
		assertEquals("(5 1 4 7 5 6 5 5 )", listaCompleta.toString());

		assertEquals("5", listaCompleta.removePenult());
		assertEquals("(5 1 4 7 5 6 5 )", listaCompleta.toString());

		assertEquals("1", listaCompleta.removeElemPos(2));
		assertEquals("(5 4 7 5 6 5 )", listaCompleta.toString());

		assertEquals(3, listaCompleta.removeAll("5"));
		assertEquals("(4 7 6 )", listaCompleta.toString());

		assertEquals(2, listaCompleta.removeElem("7"));
		assertEquals("(4 6 )", listaCompleta.toString());
	}

	@Test
	public void elemPosTest() throws EmptyCollectionException {
		assertEquals("8", listaCompleta.removeElemPos(1));
		assertEquals("(5 1 4 7 5 6 5 5 2 )", listaCompleta.toString());

		assertEquals("2", listaCompleta.removeElemPos(9));
		assertEquals("(5 1 4 7 5 6 5 5 )", listaCompleta.toString());

		assertEquals("5", listaCompleta.removeElemPos(7));
		assertEquals("(5 1 4 7 5 6 5 )", listaCompleta.toString());

		assertEquals("1", listaCompleta.removeElemPos(2));
		assertEquals("(5 4 7 5 6 5 )", listaCompleta.toString());

		assertEquals(1, listaCompleta.removeElem("5"));
		assertEquals("(4 7 5 6 5 )", listaCompleta.toString());

		assertEquals(3, listaCompleta.removeElem("5"));
		assertEquals("(4 7 6 5 )", listaCompleta.toString());

		assertEquals(4, listaCompleta.removeElem("5"));
		assertEquals("(4 7 6 )", listaCompleta.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void illegalTest() throws EmptyCollectionException {
		listaCompleta.removeElemPos(-5);
	}

	@Test
	public void LinkedAddFirstTest() {
		listaVacia.addFirst("2");
		Assert.assertFalse(listaVacia.isEmpty());
		Assert.assertEquals("(2 )", listaVacia.toString());
		listaVacia.addFirst("3");
		Assert.assertEquals("(3 2 )", listaVacia.toString());
		listaVacia.addFirst("7");
		Assert.assertEquals("(7 3 2 )", listaVacia.toString());
	}

	//Reverse
	@Test
	public void reverseTest() {
		assertEquals("(2 5 5 6 5 7 4 1 5 8 )", listaCompleta.reverse().toString());
	}

	//Getters
	@Test
	public void getterTest() {
		assertEquals("4", listaCompleta.getElemPos(4));
		assertEquals(9, listaCompleta.getPosLast("5"));
	}

	//test de iteradores
	@Test
	public void LinkedIteratorTest() {
		listaVacia.addFirst("2");
		Assert.assertFalse(listaVacia.isEmpty());
		Assert.assertEquals("(2 )", listaVacia.toString());
		listaVacia.addFirst("3");
		Assert.assertEquals("(3 2 )", listaVacia.toString());
		listaVacia.addFirst("7");
		Assert.assertEquals("(7 3 2 )", listaVacia.toString());
		Iterator<String>  iter=listaVacia.iterator();
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
		listaVacia.addFirst("2");
		Assert.assertFalse(listaVacia.isEmpty());
		Assert.assertEquals("(2 )", listaVacia.toString());
		listaVacia.addFirst("3");
		Assert.assertEquals("(3 2 )", listaVacia.toString());
		listaVacia.addFirst("7");
		Assert.assertEquals("(7 3 2 )", listaVacia.toString());
		listaVacia.addFirst("8");
		Assert.assertEquals("(8 7 3 2 )", listaVacia.toString());

		Iterator<String>  iter=listaVacia.evenPosIterator();
		assertTrue(iter.hasNext());
		assertEquals("7", iter.next());
		assertTrue(iter.hasNext());
		assertEquals("2", iter.next());
		assertFalse(iter.hasNext());
	}
	
	
	
	
	// TEST ITERADORES EN LISTA VACÍA
	@Test(expected=NoSuchElementException.class)
	public void LinkedNextListaVaciaTest() {
			listaVacia.iterator().next();	}
	
	
	//TEST reverse
	@Test
	public void LinkedtestReverse() {
	
	listaVacia.addFirst("6");
	Assert.assertFalse(listaVacia.isEmpty());
	Assert.assertEquals("(6 )", listaVacia.toString());
	listaVacia.addFirst("5");
	Assert.assertEquals("(5 6 )", listaVacia.toString());
	listaVacia.addFirst("4");
	Assert.assertEquals("(4 5 6 )", listaVacia.toString());
	listaVacia.addFirst("4");
	Assert.assertEquals("(4 4 5 6 )", listaVacia.toString());
	Assert.assertEquals("(6 5 4 4 )", listaVacia.reverse().toString());
	Assert.assertEquals("(4 4 5 6 )", listaVacia.toString()); // queda en el mismo estado
	}
}

		
				
