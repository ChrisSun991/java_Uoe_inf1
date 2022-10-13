public class ComplexNumbers {

    public static double[] complexAdd(double[] z1, double[] z2) {
        double[] output = new double[z1.length];
        for (int i = 0; i < z1.length; i++) {
            output[i] = z1[i] + z2[i];
        }
        return output;
    }

    public static double[] complexConjugate(double[] z) {
        z[1] = -z[1];
        return z;
    }

    public static double[] complexMultiply(double[] z1, double[] z2) {
        double[] output = new double[z1.length];
        output[0] = z1[0]*z2[0] - z1[1]*z2[1];
        output[1] = z1[1]*z2[1] + z1[0]*z2[0];
        return output;
    }

    public static double[] complexReciprocal(double[] z) {
        double[] recZ = new double[z.length];
        recZ[0] = z[0]/(Math.pow(z[0],2)+Math.pow(z[1],2));
        recZ[1] = -z[1]/(Math.pow(z[0],2)+Math.pow(z[1],2));
        return recZ;
    }

    public static String toString(double[] z){
        if (z[1] > 0){
            return z[0] + "+" + z[1] +"i";
        }else{
            return z[0] + "-" + z[1] +"i";
        }
    }

    public static double[][] sortByMagnitude(double[][] complexList){
        double[][] temp = new double[1][2];
        temp[0] = complexList[0];
        complexList[0] = complexList[1];
        complexList[1] = complexList[2];
        complexList[2] = temp[0];
        return complexList;
    }

    public static void main(String[] args) {
        double[] z1 = new double[]{Double.parseDouble(args[0]), Double.parseDouble(args[1])};
        double[] z2 = new double[]{Double.parseDouble(args[2]), Double.parseDouble(args[3])};

        System.out.println(complexAdd(z1,z2));
        System.out.println(complexConjugate(z1));
        System.out.println(complexMultiply(z1,z2));
        System.out.println(complexReciprocal(z1));
        System.out.println(complexConjugate(complexAdd(z1,z2)));
    }

}
