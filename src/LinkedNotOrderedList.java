import static org.junit.Assert.assertNotNull;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;


public class LinkedNotOrderedList<T> implements INotOrderedList<T>{

	//	referencia al primer  de la lista
	private Node<T> front;

	// NO SE PUEDEN AÑADIR MÁS ATRIBUTOS A LA LISTA

	private class Node<T> {

		Node(T element) {
			this.elem = element;
			this.next = null;
		}

		T elem;

		Node<T> next;
	}
	///////
	///// ITERADOR normal //////////

	//@SuppressWarnings("hiding")
	private class LinkedListIterator<T> implements Iterator<T> {
		// declarar atributos del iterador
		
		public LinkedListIterator(Node<T> aux) {
			//TODO
		}

		@Override
		public boolean hasNext() {
			//TODO
			
			return false;
		}

		@Override
		public T next() {
	  // TODO
			
			return null;

			
		}	
	}
	
	/// TODO :  AÑADIR OTRAS CLASES PARA LOS OTROS ITERADORES
	
		// FIN ITERADORES
		
	


	@Override
	public int size() {
		// TODO 
		
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO 
		return false;
	}

	@Override
	public void addFirst(T elem) {
		// TODO 
	}

	@Override
	public void addLast(T elem) {
		// TODO 
	}

	@Override
	public void addPenult(T elem) {
		// TODO 
	}

	@Override
	public void addPos(T elem, int position) {
		// TODO 
	}

	@Override
	public T removeFirst() throws EmptyCollectionException {
		// TODO 
	    
		return null;
	}

	@Override
	public T removelast() throws EmptyCollectionException {
		// TODO 
		return null;
	}

	@Override
	public T removePenult() throws EmptyCollectionException {
		// TODO 
		return null;
		
	}
	
	@Override
	public T getElemPos(int position) {
		// TODO 
		return null;
	}

	@Override
	public int getPosLast(T elem) {
		// TODO	
		return 0;
	 }
	

	@Override
	public int removeAll(T elem) throws EmptyCollectionException {
		// TODO 	
		return 0;

	}

	@Override
	public INotOrderedList<T> reverse() {
		// TODO 		
		return null;
	}

	
	@Override
	public String toString() {
		// TODO
		
		return "";
	}


		@Override
		public int removeElem(T elem) throws EmptyCollectionException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public T removeElemPos(int position) {
			// TODO 
			return null;
		}

		@Override
		public int removePosLast(T elem) {
			// TODO 
			return 0;
		}

		@Override
		public String FromUntilNotIncluded(int from, int until) {
			// TODO 
			return null;
		}

		@Override
		public Iterator<T> iterator() {
			// TODO 
			return new LinkedListIterator<T>(front);
		}
		
		@Override
		public Iterator<T> evenPosIterator() {
			// TODO 
			return null;
		}

		@Override
		public Iterator<T> fromUntilIterator(int from, int until) {
			// TODO 
			return null;
		}
	
}

	