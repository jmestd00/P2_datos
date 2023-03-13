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
		/*
			for (int i = 0; i < data.length; i++) {
				if (data[i] == null)
					return true;
			}

		 */
			return true;
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

	private boolean hasNext(){
		for (T list : data) {
			if (list == null) {
				return true;
			}
		}
		return false;
	}

	private int next(){
		return count;
	}

	@SuppressWarnings({"unchecked"})
	private void expandIfNeeded(){
		if(!hasNext()){
			Object[] aux = (T[]) new Object[data.length * 2];
			for(int i = 0; i < data.length; i++){
				aux[i] = data[i];
			}
			data = (T[]) aux;
		}
	}

	private boolean isNull(T elem){
		return elem == null;
	}

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
		return data[0] == null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void addFirst(T elem) {
		expandIfNeeded();

		if(isNull(elem)){
			throw new NullPointerException();
		}

		addPos(elem, 0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addLast(T elem) {
		expandIfNeeded();

		addPos(elem, next());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addPenult(T elem) {
		addPos(elem, next() - 1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addPos(T elem, int position) {
		expandIfNeeded();

		for(int i = data.length - 1; i > position; i--){
			data[i] = data[i - 1];
		}

		data[position] = elem;
		count++;
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
		for(int i = 0; i < data.length || i < next(); i++){
			if(data[i] != null){
				list.append(data[i]).append(" ");
			}
		}

		list.append(")");
		return list.toString();
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
