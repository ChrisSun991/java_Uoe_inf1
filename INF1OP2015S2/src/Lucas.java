public class Lucas {

    private static long[] lucas;
    private static double phiPlus = (Math.sqrt(5)+1)/2;;
    private static double phiMinus= (Math.sqrt(5)-1)/2;;

    public static void upto (int n) {
        lucas = new long[n];
        lucas[0] = 2;
        lucas[1] = 1;
        for (int i = 2; i < n; i++){
            lucas[i] = lucas[i-1] + lucas[i-2];
        }
    }

    public static boolean isPrime(long n) {
        if (n == 1 ) {
            return false;
        }else {
            boolean out = true;
            for (int i = 2; i < n; i ++) {
                if (n%i ==0){
                    out = false;
                }
            }return out;
        }
    }

    public static void primes() {
        for (int i = 0; i < lucas.length; i ++ ) {
            if (isPrime(lucas[i]) == true) {
                System.out.println("L(" + i +")=" + lucas[i]);
            }
        }
    }

    public static double maxDiffClosedForm(){
        double max = 0;
        double[] L = new double[lucas.length];
        for (int i = 0; i < lucas.length; i++ ) {
            L[i] = Math.pow(phiPlus,i) + (-Math.pow(phiMinus,i));
            double absD = Math.abs(L[i]-lucas[i]);
            max = Math.max(absD,max);
        }
        return max;
    }

    public static void main(String args[]) {
        int n = Integer.parseInt(args[0]);
        if (n >= 2 && n <= 42)
            upto(n);
            primes();
            System.out.printf("%.15f", maxDiffClosedForm());
    }

}
