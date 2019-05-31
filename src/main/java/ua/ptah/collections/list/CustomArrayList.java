package ua.ptah.collections.list;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {

  private static final int INIT_CAPACITY = 10;
  private static final double GROWTH_THRESHOLD = 0.8;
  private static final double SHRINK_THRESHOLD = 0.25;
  private T[] array;
  private int size;

  /**
   * Constructs an empty list with a default INIT_CAPACITY
   */
  public CustomArrayList() {
    this(INIT_CAPACITY);
  }

  /**
   * Constructs an empty list with the specified capacity.
   *
   * @param capacity the initial capacity of the list
   * @throws IllegalArgumentException if the specified initial capacity
   *                                  is negative
   */
  @SuppressWarnings("unchecked")
  public CustomArrayList(int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("Capacity should be more than 0");
    }
    array = (T[]) new Object[capacity];
  }

  /**
   * Adds element of type T to the end of the list
   *
   * @param el that is added
   */
  @Override
  public void add(T el) {
    add(el, size);
  }

  /**
   * Adds element of type T to the array at position INDEX.
   * If array gets full (80% capacity is full), rescale to a new array of size 2 * oldSize
   * All element after index shift one (e.g. `[1, 2, 3]` is your list, if you do `.add(5, 1)` it becomes `[1, 5, 2, 3]`.
   *
   * @param el    that is added
   * @param index where an element should be added
   * @throws ArrayIndexOutOfBoundsException if the element index is outside of range
   */
  @Override
  public void add(T el, int index) {
    if (index < 0 || index > size) {
      throw new ArrayIndexOutOfBoundsException("Incorrect index, out of bound");
    }
    if (size + 1 >= array.length * GROWTH_THRESHOLD) {
      doubleCapacity();
    }
    // shift to the right if adding inside, otherwise just assign to the end
    if (index != size) {
      System.arraycopy(array, index, array, index + 1, size - index);
    }
    array[index] = el;
    size++;
  }


  /**
   * Returns the element at the specified position in this list.
   *
   * @param index of the element to return
   * @return the element at the specified position in this list
   * @throws IndexOutOfBoundsException if the element index is outside of range
   */
  @Override
  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("Incorrect index, nothing at this position");
    }
    return array[index];
  }

  /**
   * Removes an element at index i, shifting all back, e.g. `[1, 2, 3]` after removal at 1 list to becomes `[2, 3]`
   * If after removal only 25% of capacity is used, then moves elements over in an array half the size
   *
   * @param index of an element that should be removed
   * @return removed element
   * @throws ArrayIndexOutOfBoundsException if the element index is outside of range
   */
  @Override
  public T remove(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("Incorrect index, nothing at this position");
    }
    T removed = array[index];
    size--;
    // was the last element, null the reference to avoid memory leak
    if (index == size) {
      array[size] = null;
    }
    else {
      // was not the last element, shift all next elements one position to the left
      System.arraycopy(array, index + 1, array, index, size - index + 1);
    }
    if ((size <= array.length * SHRINK_THRESHOLD) && (array.length / 2 > INIT_CAPACITY)) {
      shrinkCapacity();
    }
    return removed;
  }

  /**
   * The size of the CustomArrayList (the number of elements it contains).
   *
   * @return amount of elements in the array
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Readable form of CustomArrayList (with null-s)
   *
   * @return full String representation of internal array
   */
  @Override
  public String toString() {
    return Arrays.toString(array);
  }

  private void doubleCapacity() {
    array = Arrays.copyOf(array, array.length * 2);

  }

  private void shrinkCapacity() {
    array = Arrays.copyOf(array, array.length / 2);
  }
}
