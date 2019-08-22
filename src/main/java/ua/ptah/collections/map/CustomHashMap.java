package ua.ptah.collections.map;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import ua.ptah.collections.list.CustomArrayList;
import ua.ptah.collections.list.CustomLinkedList;

public class CustomHashMap<K, V> implements CustomMap<K, V> {

  private final static int DEFAULT_CAPACITY = 16;
  private final static float DEFAULT_LOAD_FACTOR = 0.8f;
  private CustomArrayList<CustomLinkedList<CustomEntry<K, V>>> buckets;
  private Set<Map.Entry<K, V>> entrySet;
  private int size;
  private final float loadFactor;

  /**
   * It is the default constructor which creates an instance of HashMap with initial DEFAULT_CAPACITY and DEFAULT_LOAD_FACTOR.
   */
  CustomHashMap() {
    this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
  }

  /**
   * It creates a HashMap instance with specified initial DEFAULT_CAPACITY and DEFAULT_LOAD_FACTOR.
   *
   * @param capacity
   */
  CustomHashMap(int capacity) {
    this(capacity, DEFAULT_LOAD_FACTOR);
  }

  /**
   * It creates a HashMap instance with specified initial capacity and specified load factor.
   *
   * @param capacity
   * @param loadFactor
   */
  CustomHashMap(int capacity, float loadFactor) {
    buckets = new CustomArrayList<>(capacity);
    this.loadFactor = loadFactor;
    size = 0;
  }

  /**
   * {@inheritDoc}
   */
  //TODO: return old value if was present
  @Override
  public Optional<V> put(K key, V value) {
    int keyHash = Objects.hashCode(key);
    if (buckets.get((size - 1) & keyHash) == null) {
      buckets.get(size - 1).add(new CustomEntry<>(key, value));
      return Optional.empty();
    }
    else {

    }
    size++;
    return Optional.empty();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<V> get(Object key) {
    return Optional.empty();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean containsValue(Object value) {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<V> remove(Object key) {
    size--;
    return Optional.empty();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isEmpty() {
    return (size == 0);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Iterator<Map.Entry<K, V>> iterator() {
    return new Iterator<Map.Entry<K, V>>() {

      private int position = 0;
      private Node<K, V> next;        // next entry to return
      private Node<K, V> current;     // current entry

      /**
       * {@inheritDoc}
       */
      @Override
      public boolean hasNext() {
        return entrySet.iterator().hasNext();
      }

      /**
       * {@inheritDoc}
       *
       * @throws NoSuchElementException {@inheritDoc}
       * @return
       */
      @Override
      public Map.Entry<K, V> next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }

        return entrySet.iterator().next();
      }
    };
  }

  /**
   * Basic hash bin node, used for most entries.
   * Taken from java.util.HashMap itself
   */
  private static class Node<K, V> implements Map.Entry<K, V> {
    final int hash;
    final K key;
    V value;
    Node<K, V> next;

    Node(int hash, K key, V value, Node<K, V> next) {
      this.hash = hash;
      this.key = key;
      this.value = value;
      this.next = next;
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
}
