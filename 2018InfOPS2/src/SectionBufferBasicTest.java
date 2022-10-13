import org.junit.Before;
import org.junit.Test;

public class SectionBufferBasicTest {

    private SectionBuffer buff;

    @Before
    public void setUp() {
        buff = new SectionBuffer();
    }

    @Test
    public void testConstructor() {
        SectionBuffer buff = new SectionBuffer(5);
    }

    @Test
    public void testDefaultConstructor() {
        SectionBuffer buff = new SectionBuffer();
    }

    @Test
    public void testAddToBuffer() {
        buff.addToBuffer(5, true);
    }

    @Test
    public void testGetFromBuffer() {
        int element = buff.getFromBuffer(false);
    }

    @Test
    public void testIsEmpty() {
        boolean result = buff.isEmpty(false);
    }

    @Test
    public void testIsFull() {
        boolean result = buff.isFull(true);
    }

    @Test
    public void testClear() {
        buff.clear();
    }
}