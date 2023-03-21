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
    public void ArrayAddWhenIsFull() {
        ArrayNotOrderedList<String> lista = new ArrayNotOrderedList<>(1);

        lista.addLast("2");
        lista.addLast("4");

        assertEquals("(2 4 )", lista.toString());
    }

    @Test
    public void ArrayVacioTest() {
        assertEquals(0, lista.size());
        assertTrue(lista.isEmpty());

        lista.addFirst("3");
        assertFalse(lista.isEmpty());
    }

    // test addFirst comprueba que dispara excepción
    @Test(expected = NullPointerException.class)
    public void ArrayAddLastElementoNuloTest() {
        lista.addLast(null);
    }

    @Test(expected = NullPointerException.class)
    public void ArrayAddPenultElementoNuloTest() {
        lista.addPenult(null);
    }

    @Test(expected = NullPointerException.class)
    public void ArrayAddPosElementoNuloTest() {
        lista.addPos(null, 1);
    }

    @Test
    public void addTest() {
        assertTrue(lista.isEmpty());

        lista.addFirst("3");
        lista.addFirst("7");
        assertEquals("(7 3 )", lista.toString());

        lista.addLast("4");
        lista.addLast("5");
        assertEquals("(7 3 4 5 )", lista.toString());

        lista.addPos("1", -1);
        lista.addPos("8", 8);
        lista.addPos("0", 2);
        assertEquals("(1 0 7 3 4 5 8 )", lista.toString());

    }



    @Test
    public void removeTest() throws EmptyCollectionException {
        lista.addFirst("1");
        lista.addFirst("2");
        lista.addFirst("3");
        lista.addFirst("4");
        lista.addFirst("2");
        lista.addFirst("1");
        lista.addFirst("5");
        lista.addFirst("8");
        lista.addFirst("1");
        lista.addFirst("1");
        assertEquals("(1 1 8 5 1 2 4 3 2 1 )", lista.toString());

        assertEquals("1", lista.removeFirst());
        assertEquals("(1 8 5 1 2 4 3 2 1 )", lista.toString());

        assertEquals(3, lista.removeAll("1"));
        assertEquals("(8 5 2 4 3 2 )", lista.toString());

        assertEquals(6, lista.removePosLast("2"));
        assertEquals("(8 5 2 4 3 )", lista.toString());

        assertEquals("3", lista.removelast());
        assertEquals("(8 5 2 4 )", lista.toString());

        assertEquals("2", lista.removePenult());
        assertEquals("(8 5 4 )", lista.toString());

        assertEquals(2, lista.removeElem("5"));
        assertEquals("(8 4 )", lista.toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegalTest() throws EmptyCollectionException {
        lista.addFirst("4");
        lista.removeElemPos(-4);
    }

    @Test (expected = EmptyCollectionException.class)
    public void removeAllEmptyTest() throws EmptyCollectionException {
        lista.removeAll("3");
    }



    @Test
    public void getterTest() {
        lista.addFirst("5");
        lista.addFirst("4");
        lista.addFirst("2");
        lista.addFirst("5");
        assertEquals("(5 2 4 5 )", lista.toString());

        assertEquals("2", lista.getElemPos(2));
        assertEquals(4, lista.getPosLast("5"));
    }



    @Test
    public void ArraytestReverse() {
        lista.addFirst("6");
        assertFalse(lista.isEmpty());
        assertEquals("(6 )", lista.toString());
        lista.addFirst("5");
        assertEquals("(5 6 )", lista.toString());
        lista.addFirst("4");
        assertEquals("(4 5 6 )", lista.toString());
        lista.addFirst("4");
        assertEquals("(4 4 5 6 )", lista.toString());
        assertEquals("(6 5 4 4 )", lista.reverse().toString());
        assertEquals("(4 4 5 6 )", lista.toString()); // queda en el mismo estado
    }



    //test de iteradores
    @Test
    public void ArrayIteratorTest() {
        lista.addFirst("2");
        assertFalse(lista.isEmpty());
        assertEquals("(2 )", lista.toString());
        lista.addFirst("3");
        assertEquals("(3 2 )", lista.toString());
        lista.addFirst("7");
        assertEquals("(7 3 2 )", lista.toString());
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
        assertFalse(lista.isEmpty());
        assertEquals("(2 )", lista.toString());
        lista.addFirst("3");
        assertEquals("(3 2 )", lista.toString());
        lista.addFirst("7");
        assertEquals("(7 3 2 )", lista.toString());
        lista.addFirst("8");
        assertEquals("(8 7 3 2 )", lista.toString());

        Iterator<String> iter = lista.evenPosIterator();
        assertTrue(iter.hasNext());
        assertEquals("7", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("2", iter.next());
        assertFalse(iter.hasNext());
    }

    @Test
    public void fromUntilTest() {
        Iterator<String> iter = lista.fromUntilIterator(1, 4);
        assertTrue(lista.isEmpty());
        assertFalse(iter.hasNext());

        lista.addFirst("3");
        lista.addFirst("6");
        lista.addFirst("5");
        lista.addFirst("9");

        assertTrue(iter.hasNext());
        iter.next();
    }

    @Test
    public void untilBiggerFromTest() {
        Iterator<String> iter = lista.fromUntilIterator(4, 2);
    }


    // TEST ITERADORES EN LISTA VACÍA
    @Test(expected = NoSuchElementException.class)
    public void ArrayNextListaVaciaTest() {
        lista.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void emptyIteratorPar() {
        Iterator<String> iter = lista.evenPosIterator();
        iter.next();
    }
}
