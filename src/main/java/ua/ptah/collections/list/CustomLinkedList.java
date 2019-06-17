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
    add(el, size);
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
      last = first;
    }
    else {
      if (index == 0) {
        Node<T> prevHead = new Node<>(first.value, first, first.next);
        first = new Node<>(el, null, prevHead);
      }
      else {
        Node<T> previousNode = nodeAt(index - 1);
        if (index == size) {
          previousNode.next = new Node<>(el, previousNode, null);
          last = previousNode.next;
        }
        else {
          addBefore(el, previousNode.next);
        }
      }
    }
    size++;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public T getFirst() {
    return get(0);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public T getLast() {
    return get(size - 1);
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
    //remove the only element
    if (size == 1) {
      first = null;
      last = null;
    }
    else {
      //remove the last element
      if (index == size - 1) {
        removed.value = last.value;
        last = last.previous;
        last.next = null;
      }
      else {
        //remove the first element
        if (index == 0) {
          removed.value = first.value;
          first = first.next;
          first.previous = null;
        }
        //remove from the middle
        else {
          Node<T> previous = nodeAt(index - 1);
          previous.next = removed.next;
          previous.next.previous = previous;
        }
      }
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
    Node<T> element = first;
    for (int i = 0; i < size; i++) {
      if (element.value.equals(o)) {
        return true;
      }
      element = element.next;
    }
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int size() {
    return size;
  }

  private void addBefore(T el, Node<T> newNext) {
    final Node<T> previous = newNext.previous;
    final Node<T> newNode = new Node<>(el, previous, newNext);
    newNext.previous = newNode;
    if (previous == null) {
      first = newNode;
    }
    else {
      previous.next = newNode;
    }
  }

  private Node<T> nodeAt(int index) {
    if (size == 0) {
      throw new NoSuchElementException("The list is empty");
    }
    if (index == 0) {
      return first;
    }
    if (index == size - 1) {
      return last;
    }
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Incorrect index, nothing at this position");
    }
    if (index <= size / 2) {
      Node<T> element = first;
      for (int i = 0; i < index; i++) {
        element = element.next;
      }
      return element;
    }
    else {
      Node<T> element = last;
      for (int i = size - 1; i > index; i--) {
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
