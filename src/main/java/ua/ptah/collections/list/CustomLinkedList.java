package ua.ptah.collections.list;


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
  private Node<T> head;
  private int size;

  @Override
  public void add(T el) {

  }

  @Override
  public void add(T el, int index) {

  }

  @Override
  public T get(int index) {
    return null;
  }

  @Override
  public T remove() {
    return null;
  }

  @Override
  public T remove(int index) {
    return null;
  }

  @Override
  public int size() {
    return 0;
  }

  private static class Node<T> {
    T value;
    Node next;

    Node(T value, Node next) {
      this.value = value;
      this.next = next;
    }
  }
}
