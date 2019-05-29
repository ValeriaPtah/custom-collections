import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {

  private static int INIT_CAPACITY = 10;
  private Object[] array;
  private int size;

  public CustomArrayList() {
    array = new Object[INIT_CAPACITY];
  }

  public CustomArrayList(int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("Capacity should be more than 0");
    }
    array = new Object[capacity];
  }

  /**
   * Adds element of type T to the end of the list
   * If array gets full (80% capacity is full), rescale to a new array of size 2 * oldSize
   *
   * @param el that is added
   */
  public void add(T el) {
    if (size + 1 >= array.length * 0.8) {
      this.rescale(array.length * 2);
    }
    array[size] = el;
    size++;
  }

  /**
   * Adds element of type T to the array at position INDEX.
   * All element after index shift one (e.g. `[1, 2, 3]` is your list, if you do `.add(5, 1)` it becomes `[1, 5, 2, 3]`.
   * Throws `ArrayIndexOutOfBoundsException` if the element index is outside of range
   *
   * @param el    that is added
   * @param index where an element should be added
   * @throws ArrayIndexOutOfBoundsException if the element index is outside of range
   */
  public void add(T el, int index) throws ArrayIndexOutOfBoundsException {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("Incorrect index, out of bound");
    }
    System.arraycopy(array, index, array, index + 1, size - index);
    array[index] = el;
    size++;
  }

  /**
   * @param index
   * @return element at INDEX
   */
  @SuppressWarnings("unchecked")
  public T at(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("Incorrect index, nothing at this position");
    }
    return (T) array[index];
  }

  /**
   * @return size of the array (amount of elements it holds
   */
  public int size() {
    return size;
  }


  /**
   * Removes an element at index i, shifting all back, e.g. `[1, 2, 3]` after removal at 1 list to becomes `[2, 3]`
   * If after removal only 25% of capacity is used, then moves elements over in an array half the size
   *
   * @param index of an element that should be removed
   * @return removed element
   * @throws ArrayIndexOutOfBoundsException if the element index is outside of range
   */
  @SuppressWarnings("unchecked")
  public T remove(int index) throws ArrayIndexOutOfBoundsException {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("Incorrect index, nothing at this position");
    }
    Object removed = array[index];
    System.arraycopy(array, index + 1, array, index, size - index - 1);
    array[--size] = null;
    if (size < array.length / 4) {
      this.rescale(array.length / 2);
    }
    return (T) removed;
  }

  @Override
  public String toString() {
    return Arrays.toString(array);
  }

  /**
   * Adjusts the size of the array for efficient memory usage
   *
   * @param newCapacity
   */
  private void rescale(int newCapacity) {
    array = Arrays.copyOf(array, newCapacity);
  }
}
