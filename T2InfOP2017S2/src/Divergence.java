import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

public class Divergence {

    public static int[] charCount(String s){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        if (s == ""){
            return null;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (int i = 0 ;i < chars.length; i ++){
            if (!map.containsKey(chars[i])){
                map.put(chars[i],1);
            }else {
                map.put(chars[i],map.get(chars[i])+1);
            }
        }
        int[] count = new int[map.size()];
        for(int i = 0; i < count.length; i++){
            for (Integer c : map.values()){
                count[i] = c;
            }
        }
        return count;
    }

    public static double[] normalise(int[] c){
        double sum = 0;
        for (int i = 0; i < c.length; i++){
            sum += c[i];
        }
        double[] output = new double[c.length];
        for (int j = 0; j < c.length; j++){
            output[j] = c[j]/sum;
        }
        return output;
    }

    public static double kld(double[] p, double[] q){
        double kld = 0;
        for (int i = 0; i < p.length; i++){
            kld += p[i] * Math.log(p[i]/q[i]);
        }
        return kld;
    }

    public static ArrayList<Character> uniqueFilter(String[] a){
        ArrayList<Character> result = new ArrayList<Character>();
        char[] arr = "abcdefghifjklmnopqrstuvwxyz".toCharArray();
        for (char c : arr){
            int index = 0;
            for (String str : a){
                if(str.indexOf(c) != -1){
                    index++;
                }
            }
            if (index == a.length) {
                result.add(c);
            }
        }
        return result;
    }


    public static int[][] charCountArray(String[] a){
        int[][] output = new int[a.length][];
        for (int i = 0; i < a.length; i++){
            char[] chars = a[i].toCharArray();
            String outputs = "";
            for (char achar : chars){
                if (uniqueFilter(a).contains(achar)){
                    outputs += achar;
                }
            }
            output[i] = charCount(outputs);
        }
        return output;
    }

    public static void main(String[] args){
        String s1 = args[0];
        String s2 = args[1];

        System.out.println("Counting " + s1 + " : " + charCount(s1).toString());

        System.out.println("Symbol probabilities in " + s1 + " : " + normalise(charCount(s1)));
        System.out.println("Symbol probabilities in " + s2 + " : " + normalise(charCount(s2)));

        int[][] CCA = charCountArray(new String[] {s1,s2});
        System.out.println("Shared Symbol Count : " + CCA.toString());

        double kld = kld(normalise(CCA[0]),normalise(CCA[1]));
        System.out.println("Divergence PQ : " + kld);
    }
}
