import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Fermat {

    public static Set<ArrayList<String>> threadings(int n, Set<String> colors) {
        if (n < 1) {
            Set<ArrayList<String>> necklace = new HashSet<>();
            return necklace;
        }

        Set<ArrayList<String>> necklaces = new HashSet<>();
        for (String firstColor : colors) {
            if (n == 1) {
                ArrayList<String> necklace = new ArrayList<>();
                necklace.add(firstColor);

                necklaces.add(necklace);
            }

            for (ArrayList<String> chainColors : threadings(n-1, colors)) {
                ArrayList<String> necklace = new ArrayList<>();
                necklace.add(firstColor);
                necklace.addAll(chainColors);

                necklaces.add(necklace);
            }

        }

        return necklaces;
    }

    public static boolean isEquiv(ArrayList<String> a, ArrayList<String> b) {
        if (a.size() != b.size()) {
            return false;
        }

        ArrayList<String> aCopy = new ArrayList<>(a);

        for (int i = 0; i < a.size(); i++) {
            Collections.rotate(aCopy, 1);
            if (aCopy.equals(b)) {
                return true;
            }
        }

        Collections.reverse(aCopy);
        for (int i = 0; i < a.size(); i++) {
            Collections.rotate(aCopy, 1);
            if (aCopy.equals(b)) {
                return true;
            }
        }

        return false;
    }

    public static void analyse(Set<ArrayList<String>> s) {
        Set<ArrayList<String>> singletons = new HashSet<ArrayList<String>>(s);



        ArrayList<ArrayList<String>> necklaces = new ArrayList<>(s);

        for (int i = 0; i < necklaces.size(); i++) {
            for (int j = 0; j < necklaces.size(); j++) {
                if (i != j) {
                    if (isEquiv(necklaces.get(i), necklaces.get(j))) {
                        singletons.remove(necklaces.get(i));
                    }
                }
            }
        }

        for (ArrayList<String> n : singletons) {
            System.out.printf("%s is a singleton\n", n);
        }

    }

    public static void main (String[] args) {
        int n = Integer.parseInt(args[0]);
        Set<String> input= new HashSet<String>();

        for (int i = 1; i < args.length; i++){
            input.add(args[i]);
        }

        Set<ArrayList<String>> analyses = threadings(n,input);

        analyse(analyses);

    }

}
