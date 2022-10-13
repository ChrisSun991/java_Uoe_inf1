import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ComplexNumbers {
    public static double[] complexAdd(double[] z1, double[] z2) {
        double[] result = new double[2];
        result[0] = z1[0] + z2[0];
        result[1] = z1[1] + z2[1];
        return result;
    }

    public static double[] complexConjugate(double[] z) {
        double[] result = new double[2];
        result[0] = z[0];
        result[1] = -z[1];
        return result;
    }

    public static double[] complexMultiply(double[] z1, double[] z2) {
        double[] result = new double[2];
        result[0] = z1[0] * z2[0] - z1[1] * z2[1];
        result[1] = z1[1] * z2[0] + z1[0] * z2[1];

        return result;
    }

    public static double[] complexReciprocal(double[] z) {
        double[] result = new double[2];
        result[0] = z[0] / (z[0] * z[0] + z[1] * z[1]);
        result[1] = -z[1] / (z[0] * z[0] + z[1] * z[1]);
        return result;
    }


    public static String toString(double[] z) {

        String output = "";
        if (z[0] > 0) {
            output += ((int) ((z[0] + 0.05) * 10)) / 10.0;
        }
        if (z[0] < 0) {
            output += ((int) ((z[0] - 0.05) * 10)) / 10.0;
        }
        if (z[0] == 0) {

        }
        if (z[1] > 0) {
            output += "+";
        }
        if (z[1] == 0) {

        }
        if (z[1] < 0) {
            output += "-";
        }

        if (z[1] > 0) {
            output += Math.abs(((int) ((z[1] + 0.05) * 10)) / 10.0) + "i";
        }
        if (z[1] < 0) {
            output += Math.abs(((int) ((z[1] - 0.05) * 10)) / 10.0) + "i";
        }
        return output;
    }


    public static double[][] sortByMagnitude(double[][] complexList) {
        double[] arr = new double[complexList.length];
        double[][] result = new double[complexList.length][2];
        for (int i = 0; i < complexList.length; i++) {
            arr[i] = Math.sqrt(complexList[i][0] * complexList[i][0] + complexList[i][1] * complexList[i][1]);
        }

        double[] arr1 = new double[arr.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }

        Arrays.sort(arr1);

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr1[i] == arr[j]) {

                    result[i] = complexList[j];

                }
            }

        }

        return result;
    }

    public static void main(String[] args) {

        double[] z1 = new double[2];
        double[] z2 = new double[2];
        z1[0] = Double.parseDouble(args[0]);
        z1[1] = Double.parseDouble(args[1]);
        z2[0] = Double.parseDouble(args[2]);
        z2[1] = Double.parseDouble(args[3]);
        System.out.println(complexAdd(z1, z2));
        System.out.println(complexConjugate(z1));
        System.out.println(complexMultiply(z1, z2));
        System.out.println(complexReciprocal(z1));
        System.out.println(complexConjugate(complexAdd(z1, z2)));
    }

}
