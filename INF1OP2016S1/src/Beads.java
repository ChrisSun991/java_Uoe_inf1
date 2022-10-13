import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Beads {

    public static Set<Integer> sums (ArrayList<Integer> beads, int n){

        Set<Integer> output = new HashSet<Integer>();

        Integer[] list = beads.toArray(new Integer[beads.size()]);

        if(n < 1) {
            return output;
        }

        for (int i = 0; i < list.length; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += list[(i+j)%list.length];
            }
            output.add(sum);
        }
        return output;

    }

    public static Set<Integer> allSums ( ArrayList<Integer> a) {

        Set<Integer> output = new HashSet<Integer>();

        for (int i = 0; i < a.size(); i++) {
            output.addAll(sums(a,i));
        }
        return  output;

    }

    public static int findMax ( Set<Integer> input){
        int n = 1;

        while (input.contains(n)){
            n++;
        }

        return  n-1;

    }

    public static void main(String args[]) {

        ArrayList<Integer> input = new ArrayList<Integer>();

        for (int i = 0; i < args.length; i++) {
            input.add(Integer.parseInt(args[i]));
        }

        int output = findMax(allSums(input));

        System.out.println(output);
    }

}
