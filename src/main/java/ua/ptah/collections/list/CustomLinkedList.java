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
      head = new Node<>(el, null, null);
    }
    else {
      if (index == 0) {
        Node<T> h = new Node<>(head.value, head, head.next);
        head = new Node<>(el, null, h);
      }
      else {
        Node<T> previousNode = nodeAt(index - 1);
        previousNode.next = new Node<>(el, previousNode, previousNode.next);
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
    Node<T> removed = nodeAt(index);
    if (size == 1) {
      head = null;
    }
    else {
      Node<T> prev = nodeAt(index - 1);
      prev.next = removed.next;
    }
    size--;
    return removed.value;
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
    Node<T> previous;
    Node<T> next;

    Node(T value, Node<T> previous, Node<T> next) {
      this.value = value;
      this.previous = previous;
      this.next = next;
    }
  }
}
