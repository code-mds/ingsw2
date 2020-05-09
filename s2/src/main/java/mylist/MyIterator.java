package mylist;

public interface MyIterator<T> {
    void rewind();
    T nextElement();
    boolean hasMoreElements();
}