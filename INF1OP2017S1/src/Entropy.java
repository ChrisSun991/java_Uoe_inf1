import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Entropy {

    public static int[] charCount(String s){
        HashMap<Character,Integer> hashmap = new HashMap<Character,Integer>();
        char[] s1 = s.toCharArray();

        for(int i =0;i<s1.length;i++){
            int index = 0;
            for(int j=0;j<s1.length;j++){
                if(s1[i]==s1[j]){
                    index++;
                }
            }
            hashmap.put(s1[i], index);
        }
        Character[] keysets =  hashmap.keySet().toArray(new Character[hashmap.size()]);
        Arrays.sort(keysets);

        int[] returnvalue = new int[hashmap.size()];
        for(int i = 0;i<returnvalue.length;i++){
            returnvalue[i] = hashmap.get(keysets[i]);
        }
        return returnvalue;
    }

    public static double[] normalise(int[] c) {
        double sum = 0.0;

        for (int i = 0; i < c.length; i++) {
            sum += c[i];
        }

        double[] c1 = new double[c.length];

        for (int j = 0; j < c1.length; j++ ) {
            c1[j] = c[j]/sum;
        }
        return c1;
    }

    public static double entropyOf(double[] p) {
        double sum = 0.0 ;

        for (int i = 0; i < p.length; i++ ) {
            sum -= p[i]*Math.log(p[i]);
        }

        sum = Double.parseDouble(String.format("%.4f", sum));

        return sum;

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

    public static void main( String args[]) {
        String s1 = args[0];
        String s2 = args[1];

        String output = "";
        output += "Character Probabilities in " + s1 + " : " + normalise(charCount(s1)) + "\n";
        output += "Character Probabilities in " + s1 + " : " + normalise(charCount(s2)) + "\n";
        output += "Entropy of " + s1 +" : " + entropyOf(normalise(charCount(s1))) + "\n";
        output += "Entropy of " + s1 +" : " + entropyOf(normalise(charCount(s2))) + "\n";
        output += "Entropy of unique chars in " + s1 + " : " + (new String[] {s1,s2}) + "\n";


        System.out.println(output);
    }



}
