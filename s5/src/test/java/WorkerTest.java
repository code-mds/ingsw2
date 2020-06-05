import java.security.InvalidAlgorithmParameterException;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    @org.junit.jupiter.api.Test
    void conversion() {
        assertEquals(2, Worker.conversion(4));
        assertEquals(10, Worker.conversion(3));
    }

    @org.junit.jupiter.api.Test
    void sequence() {
        assertThrows(IllegalArgumentException.class, () -> new Worker(1).sequence());
        assertEquals(6, new Worker(10).sequence());
    }
}