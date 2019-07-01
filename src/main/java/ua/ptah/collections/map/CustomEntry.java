package ua.ptah.collections.map;

public interface CustomEntry<K, V> {
  K getKey();

  V getValue();

  void setValue(V value);

  String toString();
}
