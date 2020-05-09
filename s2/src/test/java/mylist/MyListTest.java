package mylist;

import mylist.MyIterator;
import mylist.MyList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
    String[] values = new String[] { "prova", "ciao" };

    @Test
    void testCollection() {
        MyList<String> myList = new MyList<>();
        for(String v : values)
            myList.addElement(v);

        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], myList.getElement(i));
        }

        assertEquals(values.length, myList.length());
    }

    @Test
    void testForwardIterator() {
        MyList<String> myList = new MyList<>();
        MyIterator<String> it = myList.getForwardIterator();
        assertFalse(it.hasMoreElements());

        for(String v : values)
            myList.addElement(v);

        int i=0;
        while(it.hasMoreElements()) {
            assertEquals(values[i++], it.nextElement());
        }

        it.rewind();
        assertEquals(values[0], it.nextElement());
    }

    @Test
    void testBackwardIterator() {
        MyList<String> myList = new MyList<>();
        MyIterator<String> it = myList.getBackwardIterator();
        assertFalse(it.hasMoreElements());

        for(String v : values)
            myList.addElement(v);

        int i = values.length-1;
        while(it.hasMoreElements()) {
            assertEquals(values[i--], it.nextElement());
        }

        it.rewind();
        assertEquals(values[values.length-1], it.nextElement());
    }
}