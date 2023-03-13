import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;


public class ArrayNotOrderedListTest {
    private ArrayNotOrderedList<String> lista;

    @Before
    public void setUp() {
        lista = new ArrayNotOrderedList<String>();
    }

    @Test
    public void ArrayVaciaTest() {
        assertEquals(0, lista.size());
    }

    // test addFirst comprueba que dispara excepción
    @Test(expected = NullPointerException.class)
    public void ArrayAddFirstElementoNuloTest() {
        lista.addFirst(null);
    }

    @Test
    public void ArrayAddWhenIsFull() {
        ArrayNotOrderedList<String> lista = new ArrayNotOrderedList<>(1);

        lista.addLast("2");
        lista.addLast("4");

        Assert.assertEquals("(2 4 )", lista.toString());
    }

    @Test
    public void ArrayAddFirstTest() {
        lista.addFirst("2");
        Assert.assertFalse(lista.isEmpty());
        Assert.assertEquals("(2 )", lista.toString());
        lista.addFirst("3");
        Assert.assertEquals("(3 2 )", lista.toString());
        lista.addFirst("7");
        Assert.assertEquals("(7 3 2 )", lista.toString());
    }

    @Test
    public void ArrayAddLastTest() {
        lista.addLast("2");
        Assert.assertEquals("(2 )", lista.toString());

        lista.addLast("4");
        Assert.assertEquals("(2 4 )", lista.toString());
    }

    @Test
    public void ArrayAddFirstExpandCapacityTest() {
        lista = new ArrayNotOrderedList<String>(3);

        lista.addFirst("2");
        Assert.assertFalse(lista.isEmpty());
        Assert.assertEquals("(2 )", lista.toString());
        lista.addFirst("3");
        Assert.assertEquals("(3 2 )", lista.toString());
        lista.addFirst("7");
        Assert.assertEquals("(7 3 2 )", lista.toString());
        lista.addFirst("10");
        Assert.assertEquals("(10 7 3 2 )", lista.toString());
    }


    //test de iteradores
    @Test
    public void ArrayIteratorTest() {
        lista.addFirst("2");
        Assert.assertFalse(lista.isEmpty());
        Assert.assertEquals("(2 )", lista.toString());
        lista.addFirst("3");
        Assert.assertEquals("(3 2 )", lista.toString());
        lista.addFirst("7");
        Assert.assertEquals("(7 3 2 )", lista.toString());
        Iterator<String> iter = lista.iterator();
        assertTrue(iter.hasNext());
        assertEquals("7", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("3", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("2", iter.next());
        assertFalse(iter.hasNext());
    }

    @Test
    public void ArrayEvenIteratorNElemesParTest() {
        lista.addFirst("2");
        Assert.assertFalse(lista.isEmpty());
        Assert.assertEquals("(2 )", lista.toString());
        lista.addFirst("3");
        Assert.assertEquals("(3 2 )", lista.toString());
        lista.addFirst("7");
        Assert.assertEquals("(7 3 2 )", lista.toString());
        lista.addFirst("8");
        Assert.assertEquals("(8 7 3 2 )", lista.toString());

        Iterator<String> iter = lista.evenPosIterator();
        assertTrue(iter.hasNext());
        assertEquals("7", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("2", iter.next());
        assertFalse(iter.hasNext());
    }


    // TEST ITERADORES EN LISTA VACÍA
    @Test(expected = NoSuchElementException.class)
    public void ArrayNextListaVaciaTest() {
        lista.iterator().next();
    }

    @Test
    public void addPos() {
        lista.addFirst("2");
        lista.addFirst("5");
        lista.addPos("7", 2);
        lista.addPenult("8");
        lista.addLast("4");

        Assert.assertEquals("(5 2 7 8 4 )", lista.toString());
    }

    //TEST reverse
    @Test
    public void ArraytestReverse() {
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
	
				
				

