package ua.ptah.collections.map;

import java.util.Map;
import java.util.Objects;

public class CustomEntry<K, V> {

  private final int hash;
  private final K key;
  private V value;

  CustomEntry(K key, V value) {
    this.hash = Objects.hashCode(key);
    this.key = key;
    this.value = value;
  }

  public final K getKey() {
    return key;
  }

  public final V getValue() {
    return value;
  }

  public final String toString() {
    return key + "=" + value + "\n";
  }

  public final int hashCode() {
    return Objects.hashCode(key) ^ Objects.hashCode(value);
  }

  public final V setValue(V newValue) {
    V oldValue = value;
    value = newValue;
    return oldValue;
  }

  public final boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Map.Entry) {
      Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
      return Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue());
    }
    return false;
  }
}
