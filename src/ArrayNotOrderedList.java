import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayNotOrderedList<T> implements INotOrderedList<T> {
	static final int DEFAULT_CAPACITY = 10;

    private T[] data;
	private int count;
	
	// NO SE PUEDEN AÑADIR MÁS ATRIBUTOS A LA LISTA IMPLEMENTADA CON ARRAYS


	private class ArrayNotOrderedListIterator<T> implements Iterator<T> {
		private int current = 0;

		@Override
		public boolean hasNext() {
			return current < count;
		}


		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			if(!hasNext()){
				throw new NoSuchElementException("Error, no hay siguiente elemento");
			}

			current++;
			return (T) data[current-1];
		}
	}

	private class ArrayNotOrderedListIteratorFromUntil<T> implements Iterator<T> {
		private int current;
		private int until;

		public ArrayNotOrderedListIteratorFromUntil(int from, int until){
			if(until > from){
				current = until;
				this.until = from;
			}else{
				current = from;
				this.until = until;
			}
		}

		@Override
		public boolean hasNext() {
			return (!isEmpty()) || current < until;
		}


		@SuppressWarnings("unchecked")
		@Override
		public T next() {
            if(!hasNext()){
                throw new NoSuchElementException("Error, no hay siguiente elemento");
            }

            current++;
            return (T) data[current-1];
		}
	}

	private class ArrayNotOrderedListIteratorPar<T> implements Iterator<T> {
		private int current = 1;

		@Override
		public boolean hasNext() {
			return current < count;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
            if(!hasNext()){
                throw new NoSuchElementException("Error, no hay siguiente elemento");
            }

            current += 2;
            return (T) data[current-2];
		}
	}

    // FIN ITERADORES


	//Privados
	@SuppressWarnings("unchecked")
	private void expandIfNeeded(){
		if(size() == data.length){
			Object[] aux = (T[]) new Object[data.length * 2];

			for(int i = 0; i < data.length; i++){
				aux[i] = data[i];
			}

			data = (T[]) aux;
		}
	}

	private void isNullPointer(T elem){
		if(elem == null) {
			throw new NullPointerException();
		}
	}


	//Constructores
	@SuppressWarnings("unchecked")
	public ArrayNotOrderedList() {
	   this.count = 0;
	   data = (T[]) new Object[DEFAULT_CAPACITY];
	}

	@SuppressWarnings("unchecked")
	public ArrayNotOrderedList(int capacity) {
	  this.count = 0;
	  data = (T[]) new Object[capacity];
	}


	//UTIL
	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return data[0] == null;
	}


	//Add
	@Override
	public void addFirst(T elem) {
		addPos(elem, 1);
	}

	
	@Override
	public void addLast(T elem) {
		addPos(elem, count+1);
	}

	
	@Override
	public void addPenult(T elem) {
		addPos(elem, count-1);
	}

	
	@Override
	public void addPos(T elem, int position) {
		expandIfNeeded();
		isNullPointer(elem);

		if(position-1 < 0){
			position = 1;
		}

		//Muy grande
		if(position-1 > count){
			addLast(elem);
		}

		//Muy pequeño y vacía
		else if(position-1 <= 0 && isEmpty()){
			data[0] = elem;
			count++;
		}

		//Resto de casos
		else{
			for (int i = count; i > position-1; i--) {
				data[i] = data[i - 1];
			}
			data[position - 1] = elem;
			count++;
		}
	}


	//Remove
	@Override
	public T removeFirst() {
		return removeElemPos(1);
	}

	@Override
	public T removelast() {
		return removeElemPos(count);
	}

	@Override
	public T removePenult() {
		return removeElemPos(count-1);
	}

	@Override
	public int removeElem(T elem) {
		int i = 0;
		while(data[i] != elem || i == 0){
			i++;
		}
		removeElemPos(i+1);
		return i+1;
	}
	
	@Override
	public T getElemPos(int position) {
		if(position < 1 || position > count){
			throw new IllegalArgumentException();
		}
		return data[position-1];
	}

	@Override
	public int getPosLast(T elem) {
		int i = count;

		while(data[i] != elem || i == 0){
			i--;
		}

		return i+1;
	}

	@Override
	public int removeAll(T elem) throws EmptyCollectionException {
		if(isEmpty()){
			throw new EmptyCollectionException("lista");
		}

		int total = 0;
		for(int i = 0; i < data.length; i++){
			if(data[i] == elem){
				removeElemPos(i+1);
				total++;
			}
		}
		return total;
	}

	@SuppressWarnings("unchecked")
	@Override
	public INotOrderedList<T> reverse() {
		ArrayNotOrderedList reverse = new ArrayNotOrderedList();

		for (T datas : data) {
			if(datas != null){
				reverse.addFirst(datas);
			}
		}
		return reverse;
	}

	@Override
	public String toString() {
		StringBuilder list = new StringBuilder();

		list.append("(");
		for(int i = 0; i < data.length || i < count; i++){
			if(data[i] != null){
				list.append(data[i]).append(" ");
			}
		}

		list.append(")");
		return list.toString();
	}

	@Override
	public T removeElemPos(int position){
		if(position < 1 || position > size()){
			throw new IllegalArgumentException("Posición no válida");
		}

		T removed = data[position-1];

		for(int i = position-1; i < data.length-1; i++){
			data[i] = data[i+1];
		}
		data[count-1] = null;
		count--;

		return removed;
	}

	@Override
	public int removePosLast(T elem){
		int i = getPosLast(elem);
		removeElemPos(i);
		return i;
	}

	@Override
	public String FromUntilNotIncluded(int from, int until) {
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayNotOrderedListIterator<>();
	}
	
	@Override
	public Iterator<T> fromUntilIterator(int from, int until) {
		return new ArrayNotOrderedListIteratorFromUntil<>(from, until);
	}

	@Override
	public Iterator<T> evenPosIterator() {
		return new ArrayNotOrderedListIteratorPar<>();
	}
}
