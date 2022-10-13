public class SectionBuffer extends Buffer{

    private int frontEnd;
    private int backEnd;
    private int frontElementCount;
    private int backElementCount;

    public SectionBuffer(int capacity){
        super(capacity);
        this.frontEnd = 0;
        this.backElementCount = 0;
        this.frontElementCount = 0;
        this.backEnd = capacity/2;
    }

    public SectionBuffer(){
        this(10);
    }

    public boolean isFull(boolean fb){
        if (fb){
            if(frontElementCount == (buffer.length/2) -1 ){
                return true;
            }else {
                return false;
            }
        }else{
            if(backElementCount == buffer.length-1-(buffer.length/2)){
                return true;
            }else{
                return false;
            }
        }
    }

    public boolean isEmpty(boolean fb){
        if (fb){
            if(frontElementCount == 0){
                return true;
            }else{
                return false;
            }
        }else{
            if(backElementCount == (buffer.length/2)) {
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public void clear(){
        for(int i = 0; i < buffer.length; i++) {
            buffer[i] = -1;
        }
        frontEnd = 0;
        backElementCount = 0;
        frontElementCount = 0;
        backEnd = buffer.length/2;
    }

    public void addToBuffer(int a, boolean fb){
        if (fb){
            if(isFull(fb)){
                System.out.println("Buffer is full.\n");
            }else{
                frontEnd++;
                buffer[frontEnd] = a;
                frontElementCount++;
            }
        }else{
            if(isFull(fb)){
                System.out.println("Buffer is full.\n");
            }else{
                backEnd++;
                buffer[backEnd] = a;
                backElementCount++;
            }
        }
    }

    public int getFromBuffer(boolean fb){
        if (fb){
            if(isEmpty(fb)){
                System.out.println("Buffer is empty.\n");
                return -1;
            }else{
                int temp = buffer[frontEnd];
                frontEnd--;
                frontElementCount--;
                return temp;
            }
        }else{
            if(isEmpty(fb)){
                System.out.println("Buffer is empty.\n");
                return -1;
            }else{
                int temp = buffer[backEnd];
                backEnd--;
                backElementCount--;
                return temp;
            }
        }
    }
}
