package ua.ptah.collections.map;

import java.util.function.Function;

public interface CustomOptional<T> {
  T getOrThrow();

  T orElse(T other);

  boolean isPresent();

  boolean isAbsent();

  <R> CustomOptional<R> map(Function<T, R> mapper);
}
