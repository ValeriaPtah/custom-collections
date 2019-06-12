package ua.ptah.collections.list;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements CustomList<T>, CustomDeque<T> {

  private Node<T> first;
  private Node<T> last;
  private int size;

  /**
   * {@inheritDoc}
   */
  @Override
  public void add(T el) {
    addLast(el);
  }

  /**
   * {@inheritDoc}
   *
   * @throws IndexOutOfBoundsException if the element index is outside of range
   */
  @Override
  public void add(T el, int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Incorrect index, out of bound");
    }
    if (size == 0) {
      first = new Node<>(el, null, null);
    }
    else {
      if (index == 0) {
        Node<T> h = new Node<>(first.value, first, first.next);
        first = new Node<>(el, null, h);
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
   */
  @Override
  public void addFirst(T el) {
    add(el, 0);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void addLast(T el) {
    if (size == 0) {
      addFirst(el);
    }
    else {
      last.next = new Node<>(el, last, null);
    }
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
    return removeLast();
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
      first = null;
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
  public T removeFirst() {
    return remove(0);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public T removeLast() {
    return remove(size - 1);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean contains(Object o) {
    return false;
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
    if (index < size / 2) {
      Node<T> element = first;
      for (int i = 0; i < index; i++) {
        element = element.next;
      }
      return element;
    }
    else {
      Node<T> element = last;
      for (int i = index; i > 0; i--) {
        element = element.previous;
      }
      return element;
    }
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
