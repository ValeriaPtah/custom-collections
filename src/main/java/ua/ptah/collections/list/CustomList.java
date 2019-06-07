package ua.ptah.collections.list;

public interface CustomList<T> {

  /**
   * Adds element of type T to the end of the list
   *
   * @param el that is added
   */
  void add(T el);

  /**
   * Adds element of type T to the array at position INDEX.
   * If array gets full (80% capacity is full), rescale to a new array of size 2 * oldSize
   * All element after index shift one (e.g. `[1, 2, 3]` is your list, if you do `.add(5, 1)` it becomes `[1, 5, 2, 3]`.
   *
   * @param el    that is added
   * @param index where an element should be added
   */
  void add(T el, int index);

  /**
   * Returns the element at the specified position in this list.
   *
   * @param index of the element to return
   * @return the element at the specified position in this list
   */
  T get(int index);

  /**
   * Removes an element of type T from the end of the list
   *
   * @return removed element
   */
  T remove();

  /**
   * Removes an element at index i, shifting all back, e.g. `[1, 2, 3]` after removal at 1 list to becomes `[2, 3]`
   * If after removal only 25% of capacity is used, then moves elements over in an array half the size
   *
   * @param index of an element that should be removed
   * @return removed element
   */
  T remove(int index);

  /**
   * The size of the CustomArrayList (the number of elements it contains).
   *
   * @return amount of elements in the array
   */
  int size();
}
