import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {

  @Test
  void addOne() {
    CustomList<Integer> customList = new CustomArrayList<>();
    customList.add(5);
    assertEquals(1, customList.size());
    assertEquals(5, customList.at(0));
  }

  @Test
  void addToTheEnd() {
    CustomList<Integer> customList = new CustomArrayList<>();
    customList.add(5);
    customList.add(4);
    assertEquals(2, customList.size());
    assertEquals(5, customList.at(0));
    assertEquals(4, customList.at(1));
  }

  @Test
  void addAtIndex() {
    CustomList<Integer> customList = new CustomArrayList<>();
    customList.add(5);
    customList.add(4);
    customList.add(3, 1);
    assertEquals(3, customList.size());
    assertEquals(3, customList.at(1));
    assertEquals(4, customList.at(2));
  }

  @Test
  void removeAtIndex() {
    CustomList<Integer> customList = new CustomArrayList<>();
    customList.add(5);
    customList.add(4);
    customList.add(3);
    assertEquals(4, customList.remove(1));
    assertEquals(2, customList.size());
    assertEquals(3, customList.at(1));
  }

  @Test
  void addAndIncreaseCapacity() {
    CustomList<Integer> customList = new CustomArrayList<>(2);
    customList.add(5);
    customList.add(4);
    customList.add(3);
    assertEquals(3, customList.size());
  }

  @Test
  void removeAndDecreaseCapacity() {
    CustomList<Integer> customList = new CustomArrayList<>(4);
    customList.add(5);
    customList.add(4);
    customList.remove(1);
    assertEquals(1, customList.size());
  }
}
