package ua.ptah.collections.list;


import java.util.NoSuchElementException;

/**
 * an element contains a `value T` and a reference to the next element
 * or to null to signify you are at the end of the list
 * classically you have an internal static class `Node` with field `T value` and `Node next`
 * and then your list itself will have a field `Node head`
 * if head == null -> list is empty
 * otherwise keep doing `Node current = head;` and `Node next = current.next`
 * to iterate through
 */

public class CustomLinkedList<T> implements CustomList<T> {

  private T value;
  private Node<T> next;
  private int size;

  /**
   * {@inheritDoc}
   */
  @Override
  public void add(T el) {

  }

  /**
   * {@inheritDoc}
   *
   * @throws ArrayIndexOutOfBoundsException if the element index is outside of range
   */
  @Override
  public void add(T el, int index) {

  }

  /**
   * {@inheritDoc}
   *
   * @throws IndexOutOfBoundsException if the element index is outside of range
   */
  @Override
  public T get(int index) {

    return null;
  }

  /**
   * {@inheritDoc}
   *
   * @throws NoSuchElementException if trying to remove from an empty list
   */
  @Override
  public T remove() {
    return remove(size - 1);
  }

  /**
   * {@inheritDoc}
   *
   * @throws IndexOutOfBoundsException if the element index is outside of range
   * @throws NoSuchElementException    if trying to remove from an empty list
   */
  @Override
  public T remove(int index) {
    if (size == 0) {
      throw new NoSuchElementException("Cannot remove elements from an empty list");
    }
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Incorrect index, nothing at this position");
    }
    T removed = get(index);
    next = next.next;
    return removed;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int size() {
    return 0;
  }

  private static class Node<T> {
    T value;
    Node<T> next;

    Node(T value, Node<T> next) {
      this.value = value;
      this.next = next;
    }
  }
}
