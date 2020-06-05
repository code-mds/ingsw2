import org.junit.jupiter.api.Test;
import org.mockito.internal.util.reflection.Whitebox;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SequenceCacheTest {

    @Test
    void length() {
        int value = 10;
        SequenceCache cache = new SequenceCache();
        Map<Integer, Worker> map = new HashMap<>();
        Whitebox.setInternalState(cache,"cache", map);
        assertTrue(map.isEmpty());

        assertEquals(6, cache.length(value));
        assertEquals(1, map.size());
        Worker w = map.get(value);

        assertEquals(6, cache.length(value));
        assertEquals(1, map.size());
        assertEquals(w, map.get(value));
    }

    @Test
    void withSpy() {
        int value = 10;
        SequenceCache cache = new SequenceCache();
        Map<Integer, Worker> map = spy(new HashMap<>());
        Whitebox.setInternalState(cache,"cache", map);

        assertEquals(6, cache.length(value));
        verify(map, times(1)).containsKey(any());
        verify(map, times(1)).put(any(), any());
        verify(map, times(1)).get(any());

        reset(map);
        assertEquals(6, cache.length(value));
        verify(map, times(1)).containsKey(any());
        verify(map, times(0)).put(any(), any());
        verify(map, times(1)).get(any());

    }

}