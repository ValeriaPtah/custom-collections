import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {

  @Test
  void addToTheEnd() {
    CustomList<Integer> customList = new CustomArrayList<Integer>();
    customList.add(5);
    customList.add(4);
    assertEquals(2, customList.size());
  }

  @Test
  void addAtIndex() {
    CustomList<Integer> customList = new CustomArrayList<Integer>();
    customList.add(5);
    customList.add(4);
    customList.add(3, 1);
    assertEquals(3, customList.size());
  }

  @Test
  void remove() {
  }

  @Test
  void size() {
  }
}