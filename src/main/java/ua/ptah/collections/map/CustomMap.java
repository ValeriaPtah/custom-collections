package ua.ptah.collections.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * An object that maps keys to values.  A map cannot contain duplicate keys;
 * each key can map to at most one value.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */

public interface CustomMap<K, V> extends Iterable<Map.Entry<K, V>> {

  /**
   * Returns TRUE if this map maps one or more keys to the specified value. More formally, returns TRUE if and only if
   * this map contains at least one mapping to a value V such that (value==null ? v==null : value.equals(v)).  This operation
   *
   * @param value value whose presence in this map is to be tested
   * @return TRUE if this map maps one or more keys to the specified value
   * @throws ClassCastException   if the value is of an inappropriate type for this map
   * @throws NullPointerException if the specified value is null and this map does not permit null values
   */
  boolean containsValue(Object value);

  /**
   * Returns the value to which the specified key is mapped, or {@code null} if this map contains no mapping for the key.
   *
   * @param key the key whose associated value is to be returned
   * @return the value to which the specified key is mapped, or {@code null} if this map contains no mapping for the key
   * @throws ClassCastException   if the key is of an inappropriate type for this map
   * @throws NullPointerException if the specified key is null and this map does not permit null keys
   */
  Optional<V> get(Object key);

  /**
   * Returns TRUE if this map contains no key-value mappings.
   *
   * @return TRUE if this map contains no key-value mappings
   */
  boolean isEmpty();

  /**
   * Associates the specified value with the specified key in this map
   * (optional operation).  If the map previously contained a mapping for
   * the key, the old value is replaced by the specified value.
   *
   * @param key   key with which the specified value is to be associated
   * @param value value to be associated with the specified key
   * @return the previous value associated with KEY, or NULL if there was no mapping for KEY.
   * @throws ClassCastException   if the class of the specified key or value prevents it from being stored in this map
   * @throws NullPointerException if the specified key or value is null and this map does not permit null keys or values
   */
  Optional<V> put(K key, V value);

  /**
   * Removes the mapping for a key from this map if it is present.
   * Returns the value to which this map previously associated the key,
   * or NULL if the map contained no mapping for the key.
   *
   * @param key key whose mapping is to be removed from the map
   * @return the previous value associated with KEY, or NULL if there was no mapping for KEY.
   * @throws ClassCastException   if the key is of an inappropriate type for this map
   * @throws NullPointerException if the specified key is null and this map does not permit null keys
   */
  Optional<V> remove(Object key);

  /**
   * Returns the number of key-value mappings in this map.
   *
   * @return the number of key-value mappings in this map
   */
  int size();

  Iterator<Map.Entry<K, V>> iterator();

  default Stream<Map.Entry<K, V>> stream() {
    return StreamSupport.stream(spliterator(), false);
  }
}
