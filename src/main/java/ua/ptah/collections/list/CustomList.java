package ua.ptah.collections.list;

public interface CustomList<T> {

  /**
   * Adds element of type T to the end of the list.
   *
   * @param el that is added
   */
  void add(T el);

  /**
   * Adds element of type T to the list at position INDEX.
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
   * Removes an element of type T from the end of the list.
   *
   * @return removed element
   */
  T remove();

  /**
   * Removes an element at INDEX.
   *
   * @param index of an element that should be removed
   * @return removed element
   */
  T remove(int index);

  /**
   * The size of the list (the number of elements it contains).
   *
   * @return amount of elements in the list
   */
  int size();
}
