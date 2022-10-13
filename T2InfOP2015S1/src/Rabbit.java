import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Rabbit {

    private Integer[][] r;
    private int n;

    public Rabbit(int n){
        this.n = n;
        r = new Integer[n][];
    }

    public void init(){
        if (n< 2){
            return;
        }
        r[0] = new Integer[]{1};
        r[1] = new Integer[] {1,0};
        for (int n = 2; n < r.length; n++) {
            r[n] = new Integer[r[n-1].length + r[n-2].length];
            for (int i = 0; i < r[n-1].length; i++) {
                r[n][i] = r[n-1][i];
            }
            for (int j = r[n-1].length; j < r[n].length; j++){
                   r[n][j] = r[n-2][j-(r[n-1].length)];
            }
        }
    }

    public String toString(){
        String output = "";
        for(int i = 0; i <r.length; i++) {
            output += Arrays.toString(r[i]) + "\n";
        }
        return output;
    }

    public int subsequenceIndex(Integer[] target) {
        String str = "" ;
        String strT = "";

        for (int i = 0; i <n; i++) {
            str += r[i];
        }

        for (int j = 0; j <target.length; j++) {
            strT += target[j];
        }

        if (str.contains(strT) == false) {
            return  -1;
        }

        int count = 0;
        int fromIndex = 0;
        while ((fromIndex = str.indexOf(strT,fromIndex)) != -1) {
            count ++ ;
            fromIndex++;
        }
        return count;
    }

    public static void main (String[] args) {
        int input = Integer.parseInt(args[0]);
        if (input <= 2) {
            return;
        }
        Rabbit rabbit = new Rabbit(input);
        rabbit.init();
        System.out.print(rabbit.toString());
        System.out.println(rabbit.subsequenceIndex(new Integer[] {1,1,0}));
        System.out.println(rabbit.subsequenceIndex(new Integer[] {1,1,1}));
    }



}
