package ua.ptah.collections.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListTest {

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
  void addToTheEnd() {
    CustomList<Integer> customList = new CustomLinkedList<>();
    customList.add(5);
    customList.add(4);
    assertAll(
        () -> assertEquals(2, customList.size()),
        () -> assertEquals(4, customList.get(0)),
        () -> assertEquals(5, customList.get(1))
    );
  }

  @Test
  void addAtIndex() {
    CustomList<Integer> customList = new CustomLinkedList<>();
    customList.add(5);
    customList.add(4);
    customList.add(3, 1);
    assertAll(
        () -> assertEquals(3, customList.size()),
        () -> assertEquals(3, customList.get(1)),
        () -> assertEquals(5, customList.get(2))
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
        () -> assertEquals(3, customList.get(0))
    );
  }

  @Test
  void removeInTheEnd() {
    CustomList<Integer> customList = new CustomLinkedList<>();
    customList.add(5);
    customList.add(4);
    customList.add(3);
    assertAll(
        () -> assertEquals(5, customList.remove(2)),
        () -> assertEquals(2, customList.size())
    );
  }

  @Test
  void removeTheOnly() {
    CustomList<Integer> customList = new CustomLinkedList<>();
    customList.add(5);
    assertAll(
        () -> assertEquals(5, customList.remove(0)),
        () -> assertEquals(0, customList.size())
    );
  }

  @Test
  void triggerExceptionWhenAddAtIndex() {
    CustomList<Integer> customList = new CustomLinkedList<>();
    assertThrows(IndexOutOfBoundsException.class, () -> customList.add(3, 6));
  }

  @Test
  void triggerExceptionWhenRemoveAtIndex() {
    CustomList<Integer> customList = new CustomLinkedList<>();
    customList.add(5);
    assertThrows(IndexOutOfBoundsException.class, () -> customList.remove(6));
  }
}