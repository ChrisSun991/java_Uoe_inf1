import java.util.ArrayList;

public class Divergence {

    public static int[] charCount(String s) {

        int[] output = new int[s.length()];
        char[] chars = s.toCharArray();

        char temp;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < s.length(); j++) {
                if (chars[j] < chars[j-1]) {
                    temp = chars[j];
                    chars[j] = chars[j-1];
                    chars[j-1] = temp;
                }
            }

            int pointer = 0;
            int k = 0;
            while (pointer != s.length()) {
                while (chars[pointer] == chars[pointer+1]) {
                    int count = 1;
                    count++;
                    pointer++;
                    output[k] = count;
                }k++;
            }
        }


        return output;

    }

    public static double[] normalise(int[] c) {

        double sum = 0.0;

        for (int i =0; i < c.length; i++) {
            sum += c[i];
        }

        double[] p = new double[c.length];

        for (int j = 0; j < c.length; j++) {
            p[j] = c[j]/sum;
        }

        return p;

    }

    public static double kld(double[] p, double[] q) {

        double output = 0.0;

        for (int i = 0; i < p.length; i++) {
            output += p[i] * Math.log(p[i]/q[i]);
        }

        return output;

    }

    public static ArrayList<Character> uniqueletters(String[] a){
        ArrayList<Character> result = new ArrayList<Character>();
        char[] arr = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for(char letter:arr){
            int index=0;
            for(String str:a){
                if(str.indexOf(letter)!=-1){
                    index++;
                }
            }

            if(index==1){
                result.add(letter);
            }
        }
        return result;
    }

    public static int[][] charCountArray(String[] a){
        int[][] result =new  int[a.length][];
        for(int i=0;i<a.length;i++){
            char[] chars =a[i].toCharArray();
            String output = "" ;
            for(char achar:chars){
                if(uniqueletters(a).contains(achar)){
                    output += achar;
                }
            }
            result[i] = charCount(output);
        }
        return result;
    }

    public static void main(String args[]) {
        String s1 = args[0];
        String s2 = args[1];

        String output = "";
        output += "Counting " + s1 + " : " + charCount(s1).toString() + "\n";
        output += "Symbol probabilities in " + s1 + " : " + normalise(charCount(s1)).toString() + "\n";
        output += "Symbol probabilities in " + s2 + " : " + normalise(charCount(s1)).toString() + "\n";
        output += "Shared Symbol Count : " + charCountArray(new String[]{s1,s2}).toString() + "\n";

        System.out.println(output);

     }
}
