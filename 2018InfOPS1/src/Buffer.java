abstract class Buffer {

    /** The buffer array containing all elements of the buffer. */
    protected int[] buffer;
    /** Indicates how often the buffer has been cleared. */
    private int clearCount;

    /**
     * Creates a new buffer of the given capacity.
     * The capacity must be larger than one, otherwise an exception is thrown.
     */
    public Buffer(int capacity) {
        if(capacity < 1)
            throw new IllegalArgumentException("The given buffer capacity must be larger than one.");

        buffer = new int[capacity];

        for(int i = 0; i < buffer.length; i++)
            buffer[i] = -1;
//     
//     ATTENTION: this was changed after the exam
//        clear();
    }

    /**
     * Clears out all buffer elements. 
     *
     * An empty buffer entry is represented by -1;
     */
    public void clear() {

        for(int i = 0; i < buffer.length; i++)
            buffer[i] = -1;

        if (clearCount == Integer.MAX_VALUE)
            clearCount = 0;
        else
            clearCount++;
    }
}