import java.util.ArrayList;

public class Question1 {

    public static ArrayList<Integer> cayley () {
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            for(int j = 0; i < 10; j++) {
                int number = i*10 + j;
                int sum = i+j;
                int product = i*j;

                if (number == sum+product){
                    output.add(number);
                }
            }
        }
        return output;
    }

    public static int[] countVowels(String[] input) {
        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i++){
            char[] toChar = input[i].toCharArray();
            for (int j = 0; j < toChar.length; i++) {
                if (toChar[j] == 'a' || toChar[j] == 'e' || toChar[j] == 'i' ||
                toChar[j] == 'o' || toChar[j] =='u' ||toChar[j] == 'A' || toChar[j] == 'E'
                || toChar[j] == 'O' || toChar[j] == 'U' || toChar[j] == 'I'){
                    output[i]++;
                }
            }
        }
        return output;
    }

    public static String mostVowels(String[] input) {
        String temp = "";
        int tempi = 0;
        int[] count = countVowels(input);
        for (int i = 0; i < count.length;i++){
            tempi = Math.max(tempi,count[i]);
            if (tempi == count[i]){
                temp = input[i];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(cayley());
        System.out.println(countVowels(args));
        System.out.println(mostVowels(args));

    }
}
