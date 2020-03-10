import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequenceCacheTest {

    @Test
    void length() {
        SequenceCache cache = new SequenceCache();
        assertEquals(6, cache.length(10));
        assertEquals(6, cache.length(10));
    }
}