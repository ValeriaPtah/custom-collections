package ua.ptah.collections.list;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomArrayListTest {

  @SuppressWarnings("Convert2MethodRef")
  @Test
  void canCreate() {
    assertDoesNotThrow(() -> new CustomArrayList<>());
  }

  @Test
  void addOne() {
    CustomList<Integer> customList = new CustomArrayList<>();
    customList.add(5);
    assertAll(
        () -> assertEquals(1, customList.size()),
        () -> assertEquals(5, customList.get(0))
    );
  }

  @Test
  void addToTheEnd() {
    CustomList<Integer> customList = new CustomArrayList<>();
    customList.add(5);
    customList.add(4);
    assertAll(
        () -> assertEquals(2, customList.size()),
        () -> assertEquals(5, customList.get(0)),
        () -> assertEquals(4, customList.get(1))
    );
  }

  @Test
  void addAtIndex() {
    CustomList<Integer> customList = new CustomArrayList<>();
    customList.add(5);
    customList.add(4);
    customList.add(3, 1);
    assertAll(
        () -> assertEquals(3, customList.size()),
        () -> assertEquals(3, customList.get(1)),
        () -> assertEquals(4, customList.get(2))
    );
  }

  @Test
  void removeAtIndex() {
    CustomList<Integer> customList = new CustomArrayList<>();
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
  void removeTheOnly() {
    CustomList<Integer> customList = new CustomArrayList<>();
    customList.add(5);
    assertAll(
        () -> assertEquals(1, customList.size()),
        () -> assertEquals(5, customList.remove(0)),
        () -> assertEquals(0, customList.size())
    );
  }

  @Test
  void removeInTheEnd() {
    CustomList<Integer> customList = new CustomArrayList<>();
    customList.add(5);
    customList.add(4);
    customList.add(3);
    assertAll(
        () -> assertEquals(3, customList.remove(2)),
        () -> assertEquals(2, customList.size())
    );
  }

  @Test
  void addAndIncreaseCapacity() {
    CustomList<Integer> customList = new CustomArrayList<>(2);
    customList.add(5);
    customList.add(4);
    customList.add(3);
    System.out.println("addAndIncreaseCapacity: 2 results: " + customList.toString());
    assertEquals(3, customList.size());
  }

  @Test
  void removeAndDecreaseCapacity() {
    CustomList<Integer> customList = new CustomArrayList<>(24);
    customList.add(5);
    customList.add(4);
    assertEquals(4, customList.remove());
    System.out.println("removeAndDecreaseCapacity: 24 results: " + customList.toString());
    assertEquals(1, customList.size());
  }

  @Test
  void triggerExceptionWhenAddAtIndex() {
    CustomList<Integer> customList = new CustomArrayList<>(4);
    assertThrows(IndexOutOfBoundsException.class, () -> customList.add(3, 6));
  }

  @Test
  void triggerExceptionWhenGetFromEmpty() {
    CustomList<Integer> customList = new CustomArrayList<>();
    assertThrows(NoSuchElementException.class, () -> customList.get(3));
  }

  @Test
  void triggerExceptionWhenGetOutOfSize() {
    CustomList<Integer> customList = new CustomArrayList<>();
    customList.add(5);
    assertThrows(IndexOutOfBoundsException.class, () -> customList.get(-1));
    assertThrows(IndexOutOfBoundsException.class, () -> customList.get(3));
  }

  @Test
  void triggerExceptionWhenRemoveFromEmpty() {
    CustomList<Integer> customList = new CustomArrayList<>();
    assertThrows(NoSuchElementException.class, () -> customList.remove(3));
  }

  @Test
  void triggerExceptionWhenRemoveAtIndex() {
    CustomList<Integer> customList = new CustomArrayList<>(4);
    customList.add(5);
    assertThrows(IndexOutOfBoundsException.class, () -> customList.remove(6));
  }

  @Test
  void triggerExceptionWithNegativeCapacity() {
    assertThrows(IllegalArgumentException.class, () -> new CustomArrayList<>(-4));
  }
}
