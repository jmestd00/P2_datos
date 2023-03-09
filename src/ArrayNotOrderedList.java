import java.util.Iterator;


public class ArrayNotOrderedList<T> implements INotOrderedList<T> {
	static final int DEFAULT_CAPACITY = 10;

    private T[] data;
	private int count;
	
	// NO SE PUEDEN AÑADIR MÁS ATRIBUTOS A LA LISTA IMPLEMENTADA CON ARRAYS

	

	private class ArrayNotOrderedListIterator<T> implements Iterator<T> {
		private int current = 0;

		@Override
		public boolean hasNext() {
		//TODO
		return false;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			//TODO
		return null;
		}
	}


	/// TODO :  AÑADIR OTRAS CLASES PARA LOS OTROS ITERADORES
	
	// FIN ITERADORES
	
	
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

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		for (T datas : data) {
			if (datas != null)
				return false;
		}
		return true;
	}

	private boolean isFull(){
		for (T datas : data) {
			if (datas == null)
				return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void addFirst(T elem) {
		if(isFull()){
			data = (T[]) new Object[data.length * 2];
		}

		if(data[0] != null){
			for(int i = data.length - 1; i >= 0; i--){
				data[i] = data[i-1];
			}
		}
		data[0] = elem;
		count++;
	}


	@Override
	public void addLast(T elem) {
		if(isFull()){
			data = (T[]) new Object[data.length * 2];
		}


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
	public int removeElem(T elem) throws EmptyCollectionException {
		// TODO 
		return 0;	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ArrayNotOrderedListIterator<T>();
	}

	
	@Override
	public Iterator<T> fromUntilIterator(int from, int until) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> evenPosIterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
