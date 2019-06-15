package ua.ptah.collections.list;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomLinkedListTest {

  @SuppressWarnings("Convert2MethodRef")
  @Test
  void canCreate() {
    assertDoesNotThrow(() -> new CustomLinkedList<>());
  }

  @Test
  void addOne() {
    CustomList<Integer> customList = new CustomLinkedList<>();
    customList.add(5);
    assertAll(
        () -> assertEquals(1, customList.size()),
        () -> assertEquals(5, customList.get(0))
    );
  }

  @Test
  void addToTheHead() {
    CustomDeque<Integer> customList = new CustomLinkedList<>();
    customList.add(5);
    customList.addFirst(4);
    assertAll(
        () -> assertEquals(2, customList.size()),
        () -> assertEquals(4, customList.getFirst())
    );
  }

  @Test
  void addToTheEnd() {
    CustomDeque<Integer> customList = new CustomLinkedList<>();
    customList.addLast(5);
    customList.addLast(4);
    assertAll(
        () -> assertEquals(2, customList.size())
    );
  }

  @Test
  void addAtIndex() {
    CustomList<Integer> customList = new CustomLinkedList<>();
    customList.add(0);
    customList.add(1);
    customList.add(2);
    customList.add(3);
    customList.add(4);
    customList.add(5);
    customList.add(100, 4);
    assertAll(
        () -> assertEquals(7, customList.size()),
        () -> assertEquals(100, customList.get(4)),
        () -> assertEquals(4, customList.get(5)),
        () -> assertEquals(5, customList.get(6))
    );
  }

  @Test
  void removeTheOnly() {
    CustomList<Integer> customList = new CustomLinkedList<>();
    customList.add(5);
    assertAll(
        () -> assertEquals(1, customList.size()),
        () -> assertEquals(5, customList.remove(0)),
        () -> assertEquals(0, customList.size())
    );
  }

  @Test
  void removeTheHead() {
    CustomList<Integer> customList = new CustomLinkedList<>();
    customList.add(5);
    customList.add(4);
    customList.add(3);
    assertAll(
        () -> assertEquals(5, customList.remove(0)),
        () -> assertEquals(2, customList.size())
    );
  }

  @Test
  void removeInTheEnd() {
    CustomList<Integer> customList = new CustomLinkedList<>();
    customList.add(5);
    customList.add(4);
    customList.add(3);
    assertAll(
        () -> assertEquals(3, customList.remove(2)),
        () -> assertEquals(2, customList.size())
    );
  }

  @Test
  void removeAtIndex() {
    CustomList<Integer> customList = new CustomLinkedList<>();
    customList.add(5);
    customList.add(4);
    customList.add(3);
    assertAll(
        () -> assertEquals(4, customList.remove(1)),
        () -> assertEquals(2, customList.size()),
        () -> assertEquals(3, customList.get(1))
    );
  }

  @Test
  void triggerExceptionWhenGetFromEmpty() {
    CustomList<Integer> customList = new CustomLinkedList<>();
    CustomDeque<Integer> customDeque = new CustomLinkedList<>();
    assertAll(
        () -> assertThrows(NoSuchElementException.class, () -> customList.get(3)),
        () -> assertThrows(NoSuchElementException.class, customDeque::getFirst)
    );
  }

  @Test
  void triggerExceptionWhenAddOutOfSize() {
    CustomList<Integer> customList = new CustomLinkedList<>();
    assertThrows(IndexOutOfBoundsException.class, () -> customList.add(3, 6));
  }

  @Test
  void triggerExceptionWhenRemoveOutOfSize() {
    CustomList<Integer> customList = new CustomLinkedList<>();
    customList.add(5);
    assertThrows(IndexOutOfBoundsException.class, () -> customList.remove(6));
  }

  @Test
  void triggerExceptionWhenRemoveFromEmpty() {
    CustomList<Integer> customList = new CustomLinkedList<>();
    CustomDeque<Integer> customDeque = new CustomLinkedList<>();
    assertAll(
        () -> assertThrows(NoSuchElementException.class, () -> customList.remove(3)),
        () -> assertThrows(NoSuchElementException.class, customDeque::removeFirst)
    );
  }
}