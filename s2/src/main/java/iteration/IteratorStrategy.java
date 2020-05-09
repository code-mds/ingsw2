package iteration;

import mylist.IMyList;
import mylist.MyIterator;

public interface IteratorStrategy {
    <T> MyIterator<T> getIterator(IMyList<T> myList);
}
