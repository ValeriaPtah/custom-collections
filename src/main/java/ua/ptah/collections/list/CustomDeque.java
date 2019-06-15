package ua.ptah.collections.list;

public interface CustomDeque<T> {

  /**
   * Adds element of type T to the end of the deque.
   *
   * @param el that is added
   */
  void add(T el);

  /**
   * Inserts the specified element at the front of this deque.
   *
   * @param el the element to add
   */
  void addFirst(T el);

  /**
   * Inserts the specified element at the end of this deque.
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
   * @throws ClassCastException   if the class of the specified element is incompatible with this deque
   * @throws NullPointerException if the specified element is null and this deque does not permit null elements
   */
  boolean contains(Object o);

  /**
   * Returns the element at the head of this deque.
   *
   * @return the head of this deque
   * @throws java.util.NoSuchElementException if this deque is empty
   */
  T getFirst();

  /**
   * Returns the element at the end of this deque.
   *
   * @return the tail of this deque
   * @throws java.util.NoSuchElementException if this deque is empty
   */
  T getLast();

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
   * The size of the deque (the number of elements it contains).
   *
   * @return amount of elements in the deque
   */
  int size();
}
