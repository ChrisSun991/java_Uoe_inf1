public class Inequalities {

    public static int dotProduct(int[] a, int[] b) {
        if (a.length != b.length) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i]* b[i];
        }
        return sum;
    }

    public static int[] concatenate (int[] a, int[] b) {
        int TL = a.length + b.length;
        int[] c = new int[TL];
        for (int i = 0; i < a.length; i++ ){
            c[i] = a[i];
        }
        for (int j = 0; j < b.length; j++) {
            c[j + a.length] = b[j];
        }
        return  c;
    }

    public static boolean cs(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        double lhs = Math.pow(dotProduct(a, b), 2.0);
        double rhs = dotProduct(a, a) * dotProduct(b, b);
        if (lhs <= rhs) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean amgm(int[]a ) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        double AM = sum/a.length;

        double product = 0;
        for (int j = 0; j < a.length; j++) {
            product *= a[j];
        }
        double GM = Math.pow(product, (1/a.length));

        if (AM >= GM) {
            return true ;
        }
        else{
            return false;
        }
    }

    public static void main (String args[]) {
        int L = Integer.parseInt(args[0]);

        int[] a = new int[(int)((args.length-1)/2)];
        int[] b = new int[(int)((args.length-1-a.length))];

        for (int i = 1; i <= a.length; i++ ){
            a[i-1] = Integer.parseInt(args[i]);
        }

        for (int i = 1 + a.length; i <= L; i++) {
            b[i-1-a.length] = Integer.parseInt(args[i]);
        }

        System.out.println(cs(a,b));
        System.out.println(amgm(concatenate(a,b)));

    }
}
