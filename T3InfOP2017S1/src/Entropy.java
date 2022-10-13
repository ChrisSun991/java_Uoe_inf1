import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class Entropy {

    public static int[] charCount(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        if (s == null || s.equals("")){
            return null;
        }
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < c.length; i++){
            if (map.containsKey(c[i])){
                map.put(c[i],map.get(c[i]) + 1);
            }else{
                map.put(c[i],1);
            }
        }
        Integer[] oI = map.values().toArray(new Integer[map.size()]);
        int[] output = new int[oI.length];
        for (int i = 0; i < oI.length; i++){
            output[i] = oI[i];
        }
        return output;
    }

    public static double[] normalise(int[] c){
        double sum = 0;
        if (c.length == 0){
            return null;
        }
        for (int i = 0 ; i < c.length; i++){
            sum += c[i];
        }
        double[] output = new double[c.length];
        for (int j = 0; j < c.length; j++){
            output[j] = c[j] / sum;
        }
        return output;
    }

    public static double entropyOf(double[] p){
        double eO = 0;
        for (int i = 0; i < p.length; i++){
            eO += p[i]*Math.log(p[i]);
        }
        if (eO > 0){
            eO = eO * (-1);
        }
        return eO;
    }

    public static ArrayList<Character> uniqueLetters ( String[] a){
        char[] c = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        ArrayList<Character> result = new ArrayList<>();
        for (char ach:c){
            int index = 0;
            for (String str:a){
                if (str.indexOf(ach) != -1){
                    index++;
                }
            }
            if (index == 1){
                result.add(ach);
            }
        }
        return result;
    }

    public static int[][] charCountArray(String[] a){
        int[][] result = new int[a.length][];
        for (int i = 0; i < a.length; i++){
            char[] c = a[i].toCharArray();
            String output = "";
            for (char achar : c){
                if (uniqueLetters(a).contains(achar)){
                    output += achar;
                }
               result[i] = charCount(output);
            }
        }
        return result;
    }

    public static void main(String[] args){
        String s1 = args[0];
        String s2 = args[1];

        //i
        System.out.println("Character Probabilities in " + s1 + " : " + normalise(charCount(s1)).toString());
        //ii
        System.out.println("Entropy of " + s1 + " : " + entropyOf(normalise(charCount(s1))));
        System.out.println("Entropy of " + s1 + " : " + entropyOf(normalise(charCount(s2))));

        //iii
        double e1 = entropyOf(normalise(charCount(s2)));
        double e2 = entropyOf(normalise(charCount(s2)));
        int[][] c = charCountArray(new String[]{s1,s2});
        System.out.println("Entropy of unique chars in " + s1 + " : " + c[0].toString());
        System.out.println("Entropy of unique chars in " + s2 + " : " + c[1].toString());
    }

}
