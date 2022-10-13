import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;

public class Fermat {

 /*   static Set<ArrayList<String>> thread = new HashSet<ArrayList<String>>();
    static int i = 0;

    public static Set<ArrayList<String>> threadings (int n, Set<String> color) {

        Set<ArrayList<String>> thread1 = new HashSet<ArrayList<String>>();
        ArrayList<String> sublist = new ArrayList<String>();
        ArrayList<String> colorArr = new ArrayList<String>(color);
/*
        n = 0 ; {[]};
        n = 1 ; {[red],[green]};
        n = 2 ; {[red,red],[red,green],[green,red],[green,green]}
        n = 3 ; {[red,red,red],[red,red,green],[red,green,red],[red,green,green],
                 [green,red,red],[green,red,green],[green,green,red],[green,green,green]}
*/
/*
        if (n == 0) {
            thread1.add(sublist);
            i++;
            thread = thread1;
            threadings(n, color);
        }else {
            while (i != n){
                for (int j = 0; j < colorArr.size(); j++) {
                    //list op on sublist
                    for (int k = 0; k < thread1.size(); k++) {

                    }

                    thread1.add(sublist);
                }
                i++;
                thread = thread1;
                threadings(n, color);
            }
        }

        return thread1;
    }
        */

    public static Set<ArrayList<String>> threadings(int n, Set<String> colors) {
        if (n < 1) {
            return new HashSet<>();
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

    public static boolean isEquiv (ArrayList<String> order1, ArrayList<String> order2) {

        boolean output = false;

        String[] order1L = order1.toArray(new String[order1.size()]);
        String[] order2L = order2.toArray(new String[order2.size()]);

        for (int i = 0 ; i < order1L.length; i ++) {
            boolean cache = true;
            for ( int j = 0; j < order2L.length; j++){
                if (order1L[i] != order2L[(i+j)%order1L.length]){
                    cache = false;
                }
            } output = output || cache;
        }

        for (int i = 0; i < order1L.length; i++) {
            boolean cache = true;
            for (int j = 0; j < order1L.length; j++) {
                if (order1L[i] != order2L[((3*order1L.length)-1-(i+j))%order2L.length]){
                    cache = false;
                }
            } output = output || cache;
        }

        return output;
    }

    public static void analyse (Set<ArrayList<String>> s) {

        for ( ArrayList<String> arr : s) {
            Set<ArrayList<String>> s1 = new HashSet<ArrayList<String>>(s);

            s1.remove(arr);

            int i = 0;

            for (ArrayList<String> arr1: s1) {
                if (isEquiv(arr1, arr)) {
                    i++;
                }
                if (i == 0) {
                    System.out.println(arr + " is a singleton");
                }
            }

        }

    }

    public static void main (String args[]) {

        Set<String> input = new HashSet<String>(args.length-2);

        for (int i = 1; i < args.length; i++) {
            input.add(args[i]);
        }

        int n = Integer.parseInt(args[0]);

        Set<ArrayList<String>> thread = new HashSet<ArrayList<String>>();

        thread = threadings(n, input);

        analyse(thread);

    }




}
