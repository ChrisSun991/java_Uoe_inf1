
import java.util.Arrays;

public class Rearrangement {

    public static int dotWith ( int[] a, int[] b){
        int sum = 0;
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                sum = sum + a[i]*b[i];
            }
            return sum;
        }
        else{
        return  0;
        }
    }
    public static void rotate (int[] b) {
        int L = b[b.length-1];
        for (int i = b.length-1 ; i > 0 ; i--){
            b[i] = b[i -1];
        }
        b[0] = L;
    }

    public static int useRotations(int[] a, int[] b) {
        if (a.length != b.length) {
            return 0;
        }
        int times = b.length - 1;
        int max = dotWith(a,b);
        for (int i = 0; i < times; i ++ ) {
            rotate(b);
            max = Math.max(max, dotWith(a,b));
        }
        return max;
    }

    public static int useSorted(int[] a, int[] b) {
        if (a.length != b.length) {
            return 0;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        return dotWith(a,b);
    }

    public static void main (String[] args) {
        int L = Integer.parseInt(args[0]);

        int[] a = new int[((int)(args.length-1)/2)];
        int[] b = new int[((int)(args.length-1)/2)];

        for (int i = 1; i <= L; i++) {

            a[i-1] = Integer.parseInt(args[i]);
        }
        for (int i = 1 ; i <= L; i++) {
            b[i-1] = Integer.parseInt(args[i+Math.round(args.length/2)]);
        }

        System.out.println(dotWith(a,b));
        System.out.println(useRotations(a,b));
        System.out.println(useSorted(a,b));
    }
}
