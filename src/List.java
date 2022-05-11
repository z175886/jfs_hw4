public interface List<T> extends Collection<T> {

	/**
	 * Adds 'item' at the given index. Immediately after this get('index')
	 * should return 'item', assuming 'index' was valid
	 * 
	 * @param item item to be inserted
	 * @param index index at which the specified element is to be inserted
	 * @throws IndexOutOfBoundsException
	 *             if (index < 0 || index > size)
	 */
	public void add(T item, int index);

	/**
	 * Gets the item at 'index'
	 * 
	 * @param index the index of the element to return
	 * @return the element at the specified position in the list
	 * @throws IndexOutOfBoundsException
	 *             if (index < 0 || index >= size)
	 */
	public T get(int index);

	/**
	 * @param item element to search for
	 * @return the index of 'item' in this list, -1 if 'item' does not exist in
	 *         this list
	 */
	public int indexOf(Object item);

	/**
	 * Removes and returns the item at 'index'
	 * 
	 * @param index the index of the element to be removed
	 * @return the element previously at the specified position 
	 * @throws IndexOutOfBoundsException
	 *             if (index < 0 || index >= size)
	 */
	public T remove(int index);

}
