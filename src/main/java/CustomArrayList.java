/**
 * Make smth ArrayList like
 * First of all you expect the following methods:
 * `public int size()` -> return size of the list
 * and the implementation detail you need to know about
 * you store everything internally in an array, say `T[]` of size 10
 * when you see your array gets full (say capacity 80%, or in this case, has 8 elements) you move all elements over to a new array of size 2*oldSize
 * so in this case 20, then 40, then 80…
 * if you remove and you see you only use 25% of capacity, then move elements over in an array half the size
 *
 * @param <T>
 */

public class CustomArrayList<T> implements CustomList<T> {

  private static int INIT_CAPACITY = 10;
  private Object[] array;

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
   *
   * @param el
   */
  public void add(T el) {

  }

  /**
   * Adds element of type T to the array at position INDEX.
   * All element after index shift one (e.g. `[1, 2, 3]` is your list, if you do `.add(5, 1)` it becomes `[1, 5, 2, 3]`.
   * Throws `ArrayIndexOutOfBoundsException` if the element index is outside of range
   *
   * @param el
   * @param index
   * @throws ArrayIndexOutOfBoundsException
   */
  public void add(T el, int index) throws ArrayIndexOutOfBoundsException {

  }

  /**
   * Removes an element at index i, shifting all back, e.g. `[1, 2, 3]` after removal at 1 list to becomes `[2, 3]`
   *
   * @param index
   * @return removed element
   * @throws ArrayIndexOutOfBoundsException
   */
  @SuppressWarnings("unchecked")
  public T remove(int index) throws ArrayIndexOutOfBoundsException {
    Object removed = this.array[index];
    return (T) removed;
  }

  public int size() {
    return array.length;
  }
}
