public interface CustomList<T> {

  void add(T el);

  void add(T el, int index) throws ArrayIndexOutOfBoundsException;

  T remove(int index) throws ArrayIndexOutOfBoundsException;

  T at(int index) throws ArrayIndexOutOfBoundsException;

  int size();
}
