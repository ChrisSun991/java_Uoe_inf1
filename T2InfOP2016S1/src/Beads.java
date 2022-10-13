import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Beads {

    public static Set<Integer> sums (ArrayList<Integer> beads, int n){

        Set<Integer> output = new HashSet<Integer>();

        Integer[] list = beads.toArray(new Integer[beads.size()]);

        if(n<1){
            return output;
        }

        for (int i = 0; i <list.length; i++) {
            int sum =0;
            for (int j =0; j < n; j++) {
                sum += list[(i+j)%list.length];
            }
            output.add(sum);
        }
        return output;
    }

    public static Set<Integer> allSums (ArrayList<Integer> a ){

        if (a.size() == 0){
            return new HashSet<>();
        }

        HashSet<Integer> output = new HashSet<>();

        for (int i = 0; i <= a.size();i++) {
            output.addAll(sums(a,i));
        }

        return output;

    }

    public static int findMax (Set<Integer> input ) {
        Integer[] list = input.toArray(new Integer[input.size()]);
        int output = 0;

        for(int n : input){
            if(output > n) {
                continue;
            }

            boolean success = true;
            for (int i = 1 ; i <= n; i++) {
                if (!input.contains(i)){
                    success = false;
                }
            }

            if (success) {
                output = n;
            }
        }
        return output;
    }

    public static void main (String[] args){
        ArrayList<Integer> input = new ArrayList<>(args.length);

        for (int i =0; i < args.length; i++) {
            input.add(Integer.parseInt(args[i]));
        }

        System.out.println(findMax(allSums(input)));

    }

}
