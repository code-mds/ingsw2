package iteration;

import mylist.IMyList;
import mylist.MyIterator;

public class BackwardStrategy implements IteratorStrategy {
    @Override
    public <T> MyIterator<T> getIterator(IMyList<T> myList) {
        return myList.getBackwardIterator();
    }
}
