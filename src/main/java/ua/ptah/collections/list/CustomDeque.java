package ua.ptah.collections.list;

public interface CustomDeque<T> {
  /**
   * Inserts the specified element at the front of this deque
   *
   * @param el the element to add
   */
  void addFirst(T el);

  /**
   * Inserts the specified element at the end of this deque
   *
   * @param el the element to add
   */
  void addLast(T el);

  /**
   * Returns {@code true} if and only if this deque contains
   * at least one element {@code e} such that {@code Objects.equals(o, e)}.
   *
   * @param o element whose presence in this deque is to be tested
   * @return {@code true} if this deque contains the specified element
   * @throws ClassCastException   if the class of the specified element
   *                              is incompatible with this deque
   *                              (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
   * @throws NullPointerException if the specified element is null and this
   *                              deque does not permit null elements
   *                              (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
   */
  boolean contains(Object o);

  /**
   * Returns the element at the specified position in this list.
   *
   * @param index of the element to return
   * @return the element at the specified position in this list
   */
  T get(int index);

  /**
   * Retrieves and removes the first element of this deque.
   *
   * @return the head of this deque
   * @throws java.util.NoSuchElementException if this deque is empty
   */
  T removeFirst();

  /**
   * Retrieves and removes the last element of this deque.
   *
   * @return the tail of this deque
   * @throws java.util.NoSuchElementException if this deque is empty
   */
  T removeLast();

  /**
   * The size of the CustomArrayList (the number of elements it contains).
   *
   * @return amount of elements in the array
   */
  int size();
}
