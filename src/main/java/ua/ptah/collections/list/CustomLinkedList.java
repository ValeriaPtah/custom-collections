package ua.ptah.collections.list;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements CustomList<T> {

  private Node<T> head;
  private int size;

  /**
   * {@inheritDoc}
   */
  @Override
  public void add(T el) {
    add(el, 0);
  }

  /**
   * {@inheritDoc}
   *
   * @throws ArrayIndexOutOfBoundsException if the element index is outside of range
   */
  @Override
  public void add(T el, int index) {
    if (index < 0 || index > size) {
      throw new ArrayIndexOutOfBoundsException("Incorrect index, out of bound");
    }
    if (size == 0) {
      head = new Node<>(el, null);
    }
    else {
      if (index == 0) {
        Node<T> h = head;
        head = new Node<>(el, h);
      }
      else {
        nodeAt(index - 1).next = new Node<>(el, nodeAt(index));
      }
    }
    size++;
  }

  /**
   * {@inheritDoc}
   *
   * @throws IndexOutOfBoundsException if the element index is outside of range
   */
  @Override
  public T get(int index) {
    return nodeAt(index).value;
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
    if (size == 1) {
      head = null;
    }
    else {
      nodeAt(index - 1).next = nodeAt(index).next;
    }
    size--;
    return removed;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int size() {
    return size;
  }

  private Node<T> nodeAt(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Incorrect index, nothing at this position");
    }
    Node<T> element = head;
    for (int i = 0; i < index; i++) {
      element = element.next;
    }
    return element;
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
