public class RingBuffer extends Buffer{

    private int start;
    private int end;
    private int elementCount;

    public RingBuffer(int capacity){
        super(capacity);
        this.start = 0;
        this.end = capacity - 1;
        this.elementCount = 0;
    }

    public RingBuffer(){
        this(10);
    }

    public boolean isFull(){
        if (elementCount == buffer.length -1){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if (elementCount == start){
            return true;
        }
        return false;
    }

    @Override
    public void clear(){
        for (int i = 0; i < buffer.length; i++){
            buffer[i] = -1;
        }
        start = 0;
        end = buffer.length-1;
        elementCount = 0;
    }

    public void addToBuffer(int a){
        if (isFull()){
            System.out.println("Buffer is full.\n");
        }
        buffer[end] = a;
        end++;
        elementCount++;
        if (end == buffer.length){
            end = 0;
        }
    }

    public int getFromBuffer(){
        if (isEmpty()){
            System.out.println("Buffer is empty.\n");
            return -1;
        }
        int temp = buffer[start];
        buffer[start] = -1;
        start++;
        elementCount--;
        if (start == buffer.length){
            start = 0;
        }
        return temp;
    }
}
