import java.util.Arrays;

public class Rearrangement {

    public static int dotWith(int[] a, int[] b ) {
        int sum = 0;
        if (a.length == b.length){
            for (int i = 0; i < a.length; i ++ ) {
                sum += a[i] * b[i];
            }
        }return sum;
    }

    public static void rotate (int[] b) {
       int temp = b[b.length-1];
       for (int i = b.length-1; i > 0; i --){
           b[i] = b[i-1];
       }
       b[0] = temp;
    }

    public static int useRotations(int[] a, int[] b){
        if (a.length != b.length) {
            return 0;
        }
        int times = b.length-1;
        int max = dotWith(a,b);
        for (int i = 0; i < times; i++) {
            rotate(b);
            max = Math.max(max, dotWith(a,b));
        }
        return max;
    }

    public static int useSorted(int[] a, int[] b){
        int sum = 0;
        if (a.length == b.length){
            Arrays.sort(a);
            Arrays.sort(b);
            sum = dotWith(a,b);
        }return sum;
    }

    public static void main(String[] args){
        int length = Integer.parseInt(args[1]);
        int[] a = new int[length];
        int[] b = new int[length];

        for (int i = 0 ; i < length; i ++){
            a[i] = Integer.parseInt(args[i+1]);
        }

        for (int i = 0; i < length; i++){
            b[i] = Integer.parseInt(args[i+1+length]);
        }

        System.out.println("dotWith gave: " + dotWith(a,b));
        System.out.println("useRotations gave: " + useRotations(a,b));
        System.out.println("useSorted gave: " + useSorted(a,b));

    }

}
