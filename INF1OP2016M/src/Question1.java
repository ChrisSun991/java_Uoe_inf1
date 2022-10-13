import java.util.ArrayList;

public class Question1 {

    public static ArrayList<Integer> cayley () {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < 10; i ++) {
            for (int j = 0; j < 10; j++) {
                if (10*i + j > 10){
                    result.add(10*i + j);
                }
            }
        }return result;
    }

    public static int[] countVowels(String[] str) {
        int[] results = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].toLowerCase();
        }
        for (int j = 0; j < str.length; j++) {
            char[] chars = str[j].toCharArray();
            for (int k = 0; k < chars.length; k++) {
                if (chars[j] == 'a' || chars[j] == 'e' || chars[j] == 'i' || chars[j] == 'o' || chars[j] == 'o' || chars[j] == 'u'){
                    results[j]++;
                }
            }
        }return results;
    }

    public static String mostVowels(String[] input) {
        int[] n = countVowels(input);
        if (n.length == 0) {
            return "";
        }
        int max = 0;
        int maxInd = 0;
        for (int i = 0; i < n.length; i++ ) {
            if (max < n[i]){
                max = n[i];
                maxInd = i;
            }
        }
        return input[maxInd];
    }

    public static void main(String[] args) {
        cayley();
        System.out.println(cayley());
        System.out.println(countVowels(args));
        System.out.println(mostVowels(args));
    }

}
