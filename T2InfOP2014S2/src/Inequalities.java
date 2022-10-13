public class Inequalities {

    public static int dotProduct(int[] a, int[] b){
        int sum = 0;
        if (a.length == b.length ){
            for (int i = 0; i < a.length; i++){
                sum += a[i] * b[i];
            }
        }return sum;
    }

    public static int[] concatenate(int[] a, int[] b){
        int length = a.length + b.length;
        int c[] = new int[length];
        for (int i = 0; i < a.length; i++){
            c[i] = a[i];
        }

        for (int j = 0; j <b.length; j++) {
            c[a.length + j] = b[j];
        }
     return c;
    }

    public static boolean cs(int[] a, int[] b) {
        boolean output = false;
        if (a.length == b.length){
            double lhs = Math.pow(dotProduct(a,b),2);
            double rhs = dotProduct(a,a) * dotProduct(b,b);
            if (lhs <= rhs){
                output = true;
            }
        }return output;
    }

    public static boolean amgm(int[] a ){
        boolean output = false;

        double sum = 0.0;
        for (int i = 0; i < a.length; i++ ) {
            sum += a[i];
        }
        double am = sum/a.length;

        double product = 1.0;
        for (int j = 0; j < a.length; j++) {
            product *= a[j];
        }
        double gm = product/a.length;
        if (am >= gm){
            output = true;
        }
        return output;
    }

    public static void main(String[] args) {
        int argLength = args.length-1;
        int aLength = Integer.parseInt(args[0]);
        int bLength = argLength - aLength;

        int[] a = new int[aLength];
        int[] b = new int[bLength];

        for (int i = 0; i < a.length ; i++) {
            a[i] = Integer.parseInt(args[1+i]);
        }

        for (int j = 0; j < b.length ; j++) {
            b[j] = Integer.parseInt(args[1+aLength+j]);
        }

        System.out.println(("CS held: " + cs(a,b)).trim());
        System.out.println(("AMGM held: " + amgm(concatenate(a,b))).trim());

    }


}
