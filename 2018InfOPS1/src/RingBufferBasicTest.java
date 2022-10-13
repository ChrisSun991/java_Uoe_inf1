import org.junit.Before;
import org.junit.Test;

public class RingBufferBasicTest {

    private RingBuffer buff;

    @Before
    public void setUp() {
        buff = new RingBuffer();
    }

    @Test
    public void testConstructor() {
        RingBuffer buff = new RingBuffer(5);
    }

    @Test
    public void testDefaultConstructor() {
        RingBuffer buff = new RingBuffer();
    }

    @Test
    public void testAddToBuffer() {
        buff.addToBuffer(5);
    }

    @Test
    public void testGetFromBuffer() {
        int element = buff.getFromBuffer();
    }

    @Test
    public void testIsEmpty() {
        boolean result = buff.isEmpty();
    }

    @Test
    public void testIsFull() {
        boolean result = buff.isFull();
    }

    @Test
    public void testClear() {
        buff.clear();
    }

}