import java.util.Iterator;
import java.util.NoSuchElementException;


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

	@SuppressWarnings("hiding")
	private class LinkedListIterator<T> implements Iterator<T> {
		Node<T> current;

		public LinkedListIterator(Node<T> aux) {
			current = aux;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}

			T elem = current.elem;
			current = current.next;

			return elem;
		}
	}

	private class LinkedListIteratorPar<T> implements Iterator<T> {
		Node<T> current;

		public LinkedListIteratorPar(Node<T> aux) {
			if(isEmpty()){
				current = null;
			}
			else{
				current = aux.next;
			}
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}

			T elem;

			if(current.next != null){
				elem = current.elem;
				current = current.next.next;
			}
			else{
				elem = current.elem;
				current = current.next;
			}

			return elem;
		}
	}

	private class LinkedListIteratorFromUntil<T> implements Iterator<T> {
		Node<T> current;
		int from, until;

		public LinkedListIteratorFromUntil(int from, int until, Node<T> aux) {
			current = aux;
			this.from = from;
			this.until = until;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}

			T elem = current.elem;
			current = current.next;

			return elem;
		}
	}


	private void comprobation(T elem){
		if (elem == null) {
			throw new NullPointerException();
		}

		if(isEmpty()){
			addFirst(elem);
		}
	}

	@Override
	public int size() {
		int counter = 0;
		Node node = this.front;

		while(node != null){
			node = node.next;
			counter++;
		}
		return counter;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void addFirst(T elem) {
		if (elem == null) {
			throw new NullPointerException();
		}

		if(isEmpty()){
			front = new Node<T>(elem);
		}

		else{
			Node<T> first = new Node<>(elem);
			first.next = front;
			front = first;
		}
	}

	@Override
	public void addLast(T elem) {
		Node<T> aux = front;
		Node<T> nuevo = new Node<>(elem);

		comprobation(elem);

		while(aux.next != null){
			aux = aux.next;
		}

		aux.next = nuevo;
	}

	@Override
	public void addPenult(T elem) {
		Node<T> aux = front;
		Node<T> nuevo = new Node<>(elem);

		comprobation(elem);

		while(aux.next.next != null){
			aux = aux.next;
		}

		nuevo.next = aux.next;
		aux.next = nuevo;
	}

	@Override
	public void addPos(T elem, int position) {
		Node<T> aux = front;
		Node<T> nuevo = new Node<T>(elem);

		comprobation(elem);

		if(position < 1){
			throw new IllegalArgumentException("Introduzca una posición válida");
		}
		else if(position == 1 || isEmpty()){
			addFirst(elem);
		}
		else if(position > size()){
			addLast(elem);
		}
		else if (position == 2) {
			nuevo.next = front.next;
			front.next = nuevo;
		}
		else{
			int count = 1;

			while (count < position-1){
				aux = aux.next;
				count++;
			}

			nuevo.next = aux.next;
			aux.next = nuevo;
		}
	}

	@Override
	public T removeFirst() throws EmptyCollectionException {
		if(isEmpty()){
			throw new EmptyCollectionException("lista");
		}

		T elem = front.elem;

		front = front.next;

		return elem;
	}

	@Override
	public T removelast() throws EmptyCollectionException {
		if(isEmpty()){
			throw new EmptyCollectionException("lista");
		}

		Node<T> aux = front;

		while(aux.next.next != null){
			aux = aux.next;
		}

		T elem = aux.next.elem;

		aux.next = null;
		return elem;
	}

	@Override
	public T removePenult() throws EmptyCollectionException {
		if(isEmpty()){
			throw new EmptyCollectionException("lista");
		}

		Node<T> aux = front;

		while(aux.next.next.next != null){
			aux = aux.next;
		}

		T elem = aux.next.next.elem;

		aux.next.next = null;
		return elem;

	}

	@Override
	public T getElemPos(int position) {
		Node<T> aux = front;
		int count = 1;

		if(position < 1 || position > size()){
			throw new IllegalArgumentException();
		}
		else{
			while(count < position){
				aux = aux.next;
				count++;
			}
		}

		return aux.elem;
	}

	@Override
	public int getPosLast(T elem) {
		Node<T> aux = front;
		int lastPos = 0, current = 1;

		if (elem == null) {
			throw new NullPointerException();
		}

		while(aux != null){
			if(aux.elem.equals(elem)){
				lastPos = current;
			}
			current++;
			aux = aux.next;
		}

		if(lastPos == 0){
			throw new NoSuchElementException();
		}

		return lastPos;
	 }

	@Override
	public int removeAll(T elem) throws EmptyCollectionException {
		Node<T> aux = front;
		int count  = 0, current = 1;

		if(isEmpty()){
			throw new EmptyCollectionException("lista");
		}

		while(aux != null){
			if(aux.elem.equals(elem)){
				count++;
			}
			aux = aux.next;
		}
		if(count == 0){
			throw new NoSuchElementException();
		}

		aux = front;
		while(aux != null){
			if(aux.elem.equals(elem)){
				removeElemPos(current);
				current--;
			}
			current++;
			aux = aux.next;
		}

		return count;
	}

	@Override
	public INotOrderedList<T> reverse() {
		LinkedNotOrderedList<T> list = new LinkedNotOrderedList<>();
		Node<T> aux = front;

		if (!isEmpty()) {
			while (aux != null) {
				list.addFirst(aux.elem);
				aux = aux.next;
			}
		}
		return  list;
	}


	@Override
	public String toString() {
		StringBuilder list = new StringBuilder();
		Node <T> aux = front;

		list.append("(");
		while(aux != null){
			list.append(aux.elem.toString()).append(" ");
			aux = aux.next;
		}
		list.append(")");

		return list.toString();
	}

	@Override
	public int removeElem(T elem) throws EmptyCollectionException {
		Node<T> aux = front;
		int current = 1, pos = 0;

		while(aux != null){
			if(aux.elem.equals(elem)){
				pos = current;
				removeElemPos(pos);
				break;
			}

			aux = aux.next;
			current++;
		}

		if(pos == 0){
			throw new NoSuchElementException();
		}

		return pos;
	}

	@Override
	public T removeElemPos(int position) throws EmptyCollectionException {
		Node<T> aux = front;
		int count = 1;
		T elem;

		if(isEmpty()){
			throw new EmptyCollectionException("lista");
		}
		else if(position < 1 || position > size()){
			throw new IllegalArgumentException();
		}
		else if(position == 1){
			elem = removeFirst();
		}
		else{
			while(count < position-1){
				aux = aux.next;
				count++;
			}

			elem = aux.next.elem;

			aux.next = aux.next.next;
		}

		return elem;
	}

	@Override
	public int removePosLast(T elem) throws EmptyCollectionException {
		int pos = getPosLast(elem);
		removeElemPos(pos);
		return pos;
	}

	@Override
	public String FromUntilNotIncluded(int from, int until) {
		StringBuilder str = new StringBuilder();
		Node<T> aux = front;
		int finalPos = from;

		if(from > until || from <= 0){
			throw new IllegalArgumentException();
		}

		if(until > size()){
			int position = 0;
			while(position < from){
				aux = aux.next;
				position++;
			}
			str.append("(");

			while(aux != null && finalPos < until - 1){
				str.append(aux.elem).append(" ");
				aux = aux.next;
				finalPos++;
			}

			str.append(")");
		}else if(from > size()){
			str.append("()");
		}else{
			int position = 0;
			while(position < from){
				aux = aux.next;
				position++;
			}
			str.append("(");

			while(finalPos < until - 1){
				str.append(aux.elem).append(" ");
				aux = aux.next;
				finalPos++;
			}

			str.append(")");
		}
		return str.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator<T>(front);
	}

	@Override
	public Iterator<T> evenPosIterator() {
		return new LinkedListIteratorPar<>(front);
	}

	@Override
	public Iterator<T> fromUntilIterator(int from, int until) {
		return new LinkedListIteratorFromUntil<>(from, until, front);
	}
}
